package scripts.utilty;

import java.util.HashMap;
import java.util.Map.Entry;

import org.tribot.api.General;
import org.tribot.api2007.Banking;
import org.tribot.api2007.Equipment;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSItemDefinition;


public class BankUtil {


	public static boolean openBank() {

		if (Banking.isBankScreenOpen()) {
			return true;
		} else {
			if (Banking.openBank())
				Banking.waitUntilLoaded(General.random(2000, 4000));

			return Banking.isBankScreenOpen();
		}
	}



	public static boolean depositAllExcept(HashMap<Integer, Integer> invMap) {

		if (Inventory.getAll().length > 0) {
			RSItem[] invItems = Inventory.getAll();

			for (RSItem invItem : invItems) {

				int invItemID = invItem.getID();

				if (!invMap.containsKey(invItemID)) {

					if (Banking.deposit(0, invItemID))
						if (!Utils.waitCondtion(() -> !ItemUtil.hasItem(invItemID))) {
							return false;
						}

				} else {

					int mapItemCount = invMap.get(invItemID);
					int itemCount = Inventory.getCount(invItemID);

					if (itemCount > mapItemCount) {
						if (Banking.deposit(itemCount - mapItemCount, invItemID))
							if (!Utils.waitCondtion(() -> Inventory.getCount(invItemID) == mapItemCount)) {
								return false;
							}
					}
				}
			}
		}
		return true;
	}



	public static boolean withdrawAll(HashMap<Integer, Integer> bankMap) {

		bankMap.forEach((ids, quantity) -> {

			RSItem[] bankItem = Banking.find(ids);
			int invCount = Inventory.getCount(ids);

			if (invCount < quantity) {

				int withdrawAmount = quantity - invCount;

				if (bankItem.length >= 1 && (bankItem[0].getStack() >= withdrawAmount)) {

					if (Banking.withdraw(withdrawAmount, ids)) {
						Utils.waitCondtion(() -> Inventory.getCount(ids) > invCount);
						if (Inventory.getCount(ids) < invCount)
							return;
					}
				}
			}
		});
		return ItemUtil.hasAllItems(bankMap);
	}



	public static boolean findAll(HashMap<Integer, Integer> bankMap) {

		for (Entry<Integer, Integer> entry : bankMap.entrySet()) {

			int ids = entry.getKey();
			int quantity = entry.getValue();
			RSItem[] bankItem = Banking.find(ids);
			int invCount = Inventory.getCount(ids);
			int equipedCount = Equipment.getCount(ids);
			int itemCount = invCount + equipedCount;
			String itemName = RSItemDefinition.get(ids).getName();
			
			if (itemCount < quantity) {	
				if (bankItem.length >= 1 && bankItem[0].getStack() + itemCount >= quantity) {		
				}else {
					General.println("Missing " + itemName + " Ending Script");
					return false;
				}								
			}
		}
		return true;
	}


}

