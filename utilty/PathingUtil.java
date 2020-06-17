package scripts.utilty;


import java.util.ArrayList;
import java.util.Collections;

import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSObject;
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
			}
		}
		return bankTile;
	}



	public static RSTile findFireMakingStartTile(RSTile startTile, int tileAmount) {

		int startTileX = startTile.getX();
		int startTileY = startTile.getY();

		RSArea burnLogArea = new RSArea(new RSTile(startTileX - 2, startTileY + 3, 0),
				new RSTile(startTileX, startTileY - 3, 0));

		ArrayList<RSTile> list = new ArrayList<RSTile>();

		RSTile[] tiles = burnLogArea.getAllTiles();

		for (RSTile tile : tiles) {
			list.add(tile);
		}

		Collections.shuffle(list);

		for (RSTile tile : list) {
			if (checkNoObjects(tile, tileAmount))
				return startTile = tile;
		}
		return startTile;
	}


	
	public static boolean checkNoObjects(RSTile tile, int tileAmount) {
	
		ArrayList<Integer> objectIdList = new ArrayList<Integer>();

		for (int i = 0; i < tileAmount; i++) {

			RSTile pathTile = new RSTile(tile.getX() - i, tile.getY(), 0);

			RSObject[] objects = Objects.getAt(pathTile);

			for (RSObject object : objects) {
				if (!object.getDefinition().getName().equals("null")) 
				objectIdList.add(object.getDefinition().getID());
			}
		}
		return objectIdList.isEmpty();
	}



}
