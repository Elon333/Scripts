package scripts.utilty;

import java.util.HashMap;
import java.util.Map.Entry;

import org.tribot.api.DynamicClicking;
import org.tribot.api2007.Camera;
import org.tribot.api2007.GroundItems;
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



	public static boolean hasItem(int... ids) {
		RSItem[] item = Inventory.find(ids);
		return item != null && item.length > 0;
	}

}
