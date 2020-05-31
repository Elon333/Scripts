package scripts.combat.tasks;

import org.tribot.api2007.Banking;

import scripts.combat.data.Node;
import scripts.combat.data.Vars;
import scripts.dax_api.api_lib.DaxWalker;
import scripts.utilty.BankUtil;
import scripts.utilty.ItemUtil;

public class Bank extends Node {

	@Override
	public void execute() {

		if (ItemUtil.hasAllItems(Vars.get().inventoryMap)) {
			Vars.get().bank = false;

		} else if (!Banking.isInBank()) {
			DaxWalker.walkTo(Vars.get().bankTile);

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
