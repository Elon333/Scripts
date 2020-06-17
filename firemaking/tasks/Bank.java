package scripts.firemaking.tasks;

import org.tribot.api2007.Banking;
import org.tribot.api2007.Player;

import scripts.dax_api.api_lib.DaxWalker;
import scripts.firemaking.data.Cons;
import scripts.firemaking.data.Node;
import scripts.firemaking.data.Utils2;
import scripts.firemaking.data.Vars;
import scripts.utilty.BankUtil;
import scripts.utilty.ItemUtil;
import scripts.utilty.Utils;

public class Bank extends Node {

	@Override
	public void execute() {

		Vars.get().logsToBurn = Utils2.getBestLogToBurn(Vars.get().logToBurnList);

		if (!Vars.get().inventoryMap.containsKey(Vars.get().logsToBurn)) {
			Vars.get().inventoryMap.clear();
			Vars.get().inventoryMap.put(Cons.TINDER_BOX, 1);
			Vars.get().inventoryMap.put(Vars.get().logsToBurn, 27);
		}


		if (ItemUtil.hasAllItems(Vars.get().inventoryMap)) {
			Vars.get().bank = false;
			Vars.get().travel = true;

		} else if (!Banking.isInBank()) {
			if (DaxWalker.walkTo(Vars.get().bankTile))
				Utils.waitCondtion(() -> Player.getPosition().distanceTo(Vars.get().bankTile) < 5);

		} else {

			if (BankUtil.openBank()) {

				if (BankUtil.depositAllExcept(Vars.get().inventoryMap)) {

					if (BankUtil.findAll(Vars.get().inventoryMap)) {

						if (BankUtil.withdrawAll(Vars.get().inventoryMap))
							Banking.close();

					} else {		
						Vars.get().script = false;
					}
				}
			}
		}
	}



	@Override
	public boolean validate() {

		return Vars.get().bank;
	}



	@Override
	public String getName() {

		return "Bank";
	}

}
