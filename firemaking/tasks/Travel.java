package scripts.firemaking.tasks;

import org.tribot.api2007.Player;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSTile;

import scripts.dax_api.api_lib.DaxWalker;
import scripts.firemaking.data.Node;
import scripts.firemaking.data.Vars;
import scripts.utilty.PathingUtil;
import scripts.utilty.Utils;


public class Travel extends Node {

	@Override
	public void execute() {

		if (Player.getPosition().distanceTo(Vars.get().fireMakingTile) >= 20) {
			if (DaxWalker.walkTo(Vars.get().fireMakingTile))
				Utils.waitCondtion(() -> Player.getPosition().distanceTo(Vars.get().fireMakingTile) < 5);

		} else {

			RSTile tile = PathingUtil.findFireMakingStartTile(Vars.get().fireMakingTile, 15);
			if (Walking.walkTo(tile)) {
				if (Utils.waitCondtion(() -> Player.getPosition().distanceTo(tile) < 5))
					Vars.get().travel = false;
			}
		}
	}


	@Override
	public boolean validate() {

		return (!Vars.get().bank && Vars.get().travel);
	}

	@Override
	public String getName() {

		return "Travel To FireMaking Start Tile";
	}

}
