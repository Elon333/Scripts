package scripts.utilty;

import org.tribot.api.General;
import org.tribot.api2007.types.RSTile;

import scripts.dax_api.api_lib.models.RunescapeBank;

public class PathingUtil {

	public static RSTile nearestBankTile(RSTile startTile) {
		
		int distance = startTile.distanceTo(RunescapeBank.VARROCK_WEST.getPosition());
		RSTile bankTile = RunescapeBank.VARROCK_WEST.getPosition();

		for (RunescapeBank tile : RunescapeBank.values()) {

			if (startTile.distanceTo(tile.getPosition()) < distance) {
				distance = startTile.distanceTo(tile.getPosition());
				bankTile = tile.getPosition();
				General.println(bankTile + "bankTile");
			General.println(distance);
			}
		}
		return bankTile;
	}



	


}
