package scripts.utilty;

import org.tribot.api.DynamicClicking;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.input.Mouse;
import org.tribot.api2007.Camera;
import org.tribot.api2007.ChooseOption;
import org.tribot.api2007.Combat;
import org.tribot.api2007.Game;
import org.tribot.api2007.Options;
import org.tribot.api2007.PathFinding;
import org.tribot.api2007.Player;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSCharacter;
import org.tribot.api2007.types.RSNPC;
import org.tribot.api2007.types.RSTile;


public class CombatUtil {

	public static boolean checkForAgroNpc() {
		
		RSCharacter interacting = Player.getRSPlayer().getInteractingCharacter();

		if (interacting != null) {

			if (Player.getPosition().distanceTo(interacting) < 12 && PathFinding.canReach(interacting.getPosition(), false)) {

				if (Utils.waitCondtion(() -> Combat.isUnderAttack(), 2000, 3500))
					return true;

				if (!Combat.isUnderAttack()) {

					if (!interacting.isClickable())
						Camera.turnToTile(interacting);

					if (interacting.isClickable()) {
						if (interacting.click("Attack"))
							return Utils.waitCondtion(() -> Combat.isUnderAttack());
					}
				}
			}
		}
		return Combat.isUnderAttack();
	}

	
	
	public static void clickAttack() {
	if (ChooseOption.select("Attack")) 
		Utils.waitCondtion(() -> Combat.isUnderAttack());
	}
	
		
		
	public static boolean clickTarget(RSNPC target) {		
		
		if (Game.getRunEnergy() > (General.random(20, 30)))
			Options.setRunEnabled(true);
		
		RSCharacter interacting = Player.getRSPlayer().getInteractingCharacter();
		if (interacting != null) {
			checkForAgroNpc();
		}
		
		if (target != null) {

			if (!target.isClickable()) {
				Camera.turnToTile(target);
			}
			
			if (!Combat.isUnderAttack()){	
					
				if (target.isClickable()) {							
					if (DynamicClicking.clickRSNPC(target, "attack")) 
					return Utils.waitCondtion(() -> Combat.isUnderAttack());							
			}else{ 
					
				RSTile targetPostion = target.getPosition();				
					if (Walking.walkTo(targetPostion))
						Utils.waitCondtion(() -> Player.getPosition().distanceTo(targetPostion) <= 2);		
				}
				}
		}
		return Combat.isUnderAttack();
	}


		
	public static boolean waitUntilOutOfCombat(String name,int eatAt) {	
		int eatAtHP = eatAt + General.random(1, 10);
		
		 Timing.waitCondition(() -> {
				General.sleep(100);
				
				AntiBan.timedActions();
				
				if (EatUtil.hpPercent() <= (eatAtHP)) {
					EatUtil.eatFood();
				}
				
				if (AntiBan.getShouldHover() && Mouse.isInBounds()) {
					AntiBan.hoverNextNPC(name);
					AntiBan.resetShouldHover();
				}
				
				if (AntiBan.getShouldOpenMenu() && (Mouse.isInBounds() && (!ChooseOption.isOpen()))) {
					AntiBan.openMenuNextNPC(name);
				}
				return !Combat.isUnderAttack() || !EatUtil.hasFood();
			}, General.random(5000, 10000));
			
			AntiBan.resetShouldOpenMenu();

			if (ChooseOption.isOpen() && !Combat.isUnderAttack() && EatUtil.hasFood()) {
				CombatUtil.clickAttack();
			}
			return !Combat.isUnderAttack();
	}








	





}
