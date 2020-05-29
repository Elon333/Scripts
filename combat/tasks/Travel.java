package scripts.combat.tasks;

import org.tribot.api2007.Player;

import scripts.combat.data.Node;
import scripts.combat.data.Vars;
import scripts.dax_api.api_lib.DaxWalker;
import scripts.utils.UtilEat;
import scripts.utilty.ItemUtil;
import scripts.utilty.Utils;


public class Travel extends Node {

	@Override
	public void execute() {

		if (DaxWalker.walkTo(Vars.get().combatTile))
			Utils.waitCondtion(() -> Player.getPosition().distanceTo(Vars.get().combatTile) < 5);
	}


	@Override
	public boolean validate() {

		return (!Vars.get().bank && Player.getPosition().distanceTo(Vars.get().combatTile) >= 20);
	}


	@Override
	public String getName() {

		return "Travel To Combat Area";
	}

}
