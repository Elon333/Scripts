package scripts.utilty;

import java.util.HashMap;
import java.util.Map.Entry;

import org.tribot.api.DynamicClicking;
import org.tribot.api.General;
import org.tribot.api2007.Camera;
import org.tribot.api2007.Game;
import org.tribot.api2007.GroundItems;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSGroundItem;
import org.tribot.api2007.types.RSItem;




public class ItemUtil {

	public static boolean hasGroundItem(String[] name) {
		RSGroundItem[] itemsOnGround = GroundItems.findNearest(name);
		return itemsOnGround != null && itemsOnGround.length > 0;
	}



	public static void loot(String[] name) {

		RSGroundItem[] itemsOnGround = GroundItems.findNearest(name);
		if (itemsOnGround != null && itemsOnGround.length > 0) {
			for (RSGroundItem item : itemsOnGround) {
				if (item != null) {

					if (Inventory.isFull())
						EatUtil.eatFood();

					int inv = Inventory.getAll().length;

					if (!item.isClickable())
						Camera.turnToTile(item);

					if (DynamicClicking.clickRSGroundItem(item, "Take " + item.getDefinition().getName())) {
						Utils.waitCondtion(() -> Inventory.getAll().length > inv);
					}
				}
			}
		}
	}



	public static boolean hasAllItems(HashMap<Integer, Integer> map) {

		/*
		 * iterates through the hashmap if we dont have the item or correct amount
		 * returns false other wise returns true
		 */
		for (Entry<Integer, Integer> entry : map.entrySet()) {

			int ids = entry.getKey();
			int quantity = entry.getValue();
			int invcount = Inventory.getCount(ids);

			if (invcount < quantity) {
				return false;
			}
		}
		return true;
	}


	public static boolean itemOnItem(int itemIds1, int itemIds2) {
		RSItem[] item1 = Inventory.find(itemIds1);
		RSItem[] item2 = Inventory.find(itemIds2);

		if (item1.length > 0 && item2.length > 0) {

			String itemName1 = item1[0].getDefinition().getName();
			String itemName2 = item2[0].getDefinition().getName();

			int inv = Inventory.getAll().length;

			String text = Game.getUptext();

			if (Game.getItemSelectionState() == 1) {
				if (text.contains("Use " + itemName1)) {
					if (item2[0].click(itemName1 + " -> " + itemName2))
						return Utils.waitCondtion(() -> inv > Inventory.getAll().length || Interfaces.get(270) != null);
				} else {
					Inventory.find(Game.getSelectedItemName())[0].click();
					return false;
				}

			} else {
				
				if (item1[0].click("Use")) {
					General.sleep(50, 250);
					if (item2[0].click(itemName1 + " -> " + itemName2))
						return Utils.waitCondtion(() -> inv > Inventory.getAll().length || Interfaces.get(270) != null);
				}
			}
		}
		return false;
	}


	public static boolean hasItem(int... ids) {
		RSItem[] item = Inventory.find(ids);
		return item != null && item.length > 0;
	}

}
