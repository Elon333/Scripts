package scripts.firemaking.tasks;



import org.tribot.api.General;
import org.tribot.api2007.Player;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSTile;

import scripts.dax_api.api_lib.DaxWalker;
import scripts.firemaking.data.Cons;
import scripts.firemaking.data.Node;
import scripts.firemaking.data.Vars;
import scripts.utilty.ItemUtil;
import scripts.utilty.PathingUtil;
import scripts.utilty.Utils;

public class BurnLogs extends Node {

	@Override
	public void execute() {

		if (!ItemUtil.hasItem(Vars.get().logsToBurn) || !ItemUtil.hasItem(Cons.TINDER_BOX)) {
			Vars.get().bank = true;

		} else {

			if (!Player.isMoving()) {
			
				RSTile postion = Player.getPosition();

				if (PathingUtil.checkNoObjects(Player.getPosition(), General.random(2, 4))) {			
					if (ItemUtil.itemOnItem(Cons.TINDER_BOX, Vars.get().logsToBurn))
						Utils.waitCondtion(() -> !Player.getPosition().equals(postion), 20000, 25000);
		
				} else {				
					Vars.get().travel = true;		
				}
			}
		}
	}



	@Override
	public boolean validate() {

		return !Vars.get().travel && !Vars.get().bank;
	}

	@Override
	public String getName() {

		return "Burn Logs";
	}

}
