package scripts.utilty;

import java.util.function.Predicate;

import org.tribot.api2007.Combat;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.ext.Filters;
import org.tribot.api2007.types.RSItem;


public class EatUtil {

	public static int hpPercent() {	
		int current = Combat.getHP();
		int max = Combat.getMaxHP();
		int Percent = current * 100 / max;	
		return Percent;
	}


	
	public static boolean eatFood() {	
		Predicate<RSItem> food = Filters.Items.actionsEquals("Eat");
		if (food != null) {
			RSItem[] item = Inventory.find(food);
			if (item != null && item.length > 0) {
				if (item[0].click("Eat")) 
				return	Utils.waitCondtion(() -> Player.getAnimation() == 829);				
			}
		}

		return false;
	}


	
	public static boolean hasFood() {
		Predicate<RSItem> food = Filters.Items.actionsEquals("Eat");
		if (food != null) {
		RSItem[] item = Inventory.find(food);
		return item != null && item.length > 0;
		}
		return false;
	}
	
	
	
}
