package scripts.combat.tasks;

import org.tribot.api2007.Combat;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSNPC;

import com.allatori.annotations.DoNotRename;

import scripts.combat.data.Node;
import scripts.combat.data.Utils2;
import scripts.combat.data.Vars;
import scripts.utilty.CombatUtil;
import scripts.utilty.EatUtil;
import scripts.utilty.ItemUtil;
import scripts.utilty.Utils;

public class Fight extends Node {

	@Override
	public void execute() {

		if (!EatUtil.hasFood() || Vars.get().bankPotion && (!EatUtil.hasPotion())) {
			Vars.get().bank = true;

		} else {

			if (!Combat.isUnderAttack()) {

				RSNPC target = Utils.reachableNpc(Vars.get().target);

				if (ItemUtil.hasGroundItem(Vars.get().itemsToLoot))
					ItemUtil.loot(Vars.get().itemsToLoot);

				if (CombatUtil.clickTarget(target))
					Vars.get().currentTime = System.currentTimeMillis();
			}


			if (Combat.isUnderAttack()) {

				if (Vars.get().drinkPotions)
					Utils2.drinkPotion(Vars.get().potionNames);

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
