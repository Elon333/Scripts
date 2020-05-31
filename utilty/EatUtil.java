package scripts.utilty;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.function.Predicate;

import org.tribot.api2007.Combat;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.ext.Filters;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSItemDefinition;


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
					return Utils.waitCondtion(() -> Player.getAnimation() == 829);
			}
		}

		return false;
	}


	public static boolean hasNoFood(HashMap<Integer, Integer> map) {

		for (Entry<Integer, Integer> entry : map.entrySet()) {

			int itemID = entry.getKey();
			String[] itemActions = RSItemDefinition.get(itemID).getActions();

			for (String itemAction : itemActions) {
				if (itemAction == "Eat")
					return true;
			}
		}
		return false;
	}



	public static boolean hasPotion() {
		Predicate<RSItem> item = Filters.Items.actionsEquals("Drink");
		if (item != null) {
			RSItem[] potion = Inventory.find(item);
			return potion != null && potion.length > 0;
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
