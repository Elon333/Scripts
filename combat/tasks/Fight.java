package scripts.combat.tasks;

import org.tribot.api2007.Combat;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSNPC;

import scripts.combat.data.Node;
import scripts.combat.data.Vars;
import scripts.utils.UtilEat;
import scripts.utilty.CombatUtil;
import scripts.utilty.ItemUtil;
import scripts.utilty.Utils;

public class Fight extends Node {

	@Override
	public void execute() {

		if (!UtilEat.hasFood()) {
			Vars.get().bank = true;			
			
		}else{			
			
		RSNPC target = Utils.reachableNpc(Vars.get().target);

		if (!Combat.isUnderAttack()) {

		if (ItemUtil.hasGroundItem(Vars.get().itemsToLoot))
				ItemUtil.loot(Vars.get().itemsToLoot);

		if (CombatUtil.clickTarget(target))
				Vars.get().currentTime = System.currentTimeMillis();
		}


		if (Combat.isUnderAttack()) {

			if (CombatUtil.waitUntilOutOfCombat(Vars.get().target, Vars.get().eatAtHP)) {
				if (Vars.get().abc2Delay)
					Utils.abc2ReactionSleep(Vars.get().currentTime);
			}
		}	
		}	
	}

	
	@Override
	public boolean validate() {

		return Player.getPosition().distanceTo(Vars.get().combatTile) < 20 && !Vars.get().bank;
	}

	@Override
	public String getName() {

		return "Fight";
	}

}
