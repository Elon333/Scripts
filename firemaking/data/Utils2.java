package scripts.firemaking.data;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;

import org.tribot.api2007.Skills;
import org.tribot.api2007.Skills.SKILLS;
import org.tribot.api2007.types.RSTile;
import org.tribot.util.Util;

import scripts.firemaking.gui.GuiFXML;





public class Utils2 {

	public static final File FOLDER = new File(Util.getWorkingDirectory().getAbsolutePath(), "//ElonFireMaker");

	public static final File IMAGE_FOLDER = new File(FOLDER.getAbsolutePath(), "//Images");
	
	public static void createFolder() {
		if (!FOLDER.exists()) {
			try {
				FOLDER.mkdir();
			} catch (SecurityException Se) {
				System.out.println("Error while creating directory in Java:" + Se);
			}
			if (FOLDER.exists())
				System.out.println("Directory created successfully");
			else
				System.out.println("Directory was not created successfully");
		}
	}

	public static void createImageFolder() {
		if (!IMAGE_FOLDER.exists()) {
			try {
				IMAGE_FOLDER.mkdir();
			} catch (SecurityException Se) {
				System.out.println("Error while creating directory in Java:" + Se);
			}
			if (IMAGE_FOLDER.exists())
				System.out.println("Directory created successfully");
			else
				System.out.println("Directory was not created successfully");
		}
	}



	public static URL createCssFile() {
		try {

			File file = new File(IMAGE_FOLDER.getAbsolutePath(), "Gui" + ".css");
			String str = GuiFXML.getStyleSheet;
			FileOutputStream outputStream = new FileOutputStream(file);
			byte[] strToBytes = str.getBytes();
			outputStream.write(strToBytes);
			outputStream.close();
			return file.toURI().toURL();

		} catch (Exception e1) {
			System.out.print("cant create css file");
			e1.printStackTrace();
		}
		return null;
	}
	
	
	public static void recordExp() {

		Vars.get().fireMakingXp = Skills.getXP(SKILLS.FIREMAKING);
	}


	public static void recordStartExp() {

		Vars.get().fireMakingStartXp = Skills.getXP(SKILLS.FIREMAKING);
	}


	public static boolean checkExp() {

		return (Skills.getXP(SKILLS.FIREMAKING) > Vars.get().fireMakingXp);
	}


	public static int getBestLogToBurn(ArrayList<LogType> logList) {
		int logToBurn = LogType.NORMAL_LOG.getLogId();

		for (LogType log : logList) {
			if (Skills.getActualLevel(SKILLS.FIREMAKING) >= log.getLogLvl())
				logToBurn = log.getLogId();
		}

		return logToBurn;
	}

	public static RSTile nearestFireMakingTile(RSTile startTile) {

		int distance = startTile.distanceTo(FireMakingTiles.VARROCK.getPosition());
		RSTile fireMakingTile = FireMakingTiles.VARROCK.getPosition();

		for (FireMakingTiles tile : FireMakingTiles.values()) {

			if (startTile.distanceTo(tile.getPosition()) < distance) {
				distance = startTile.distanceTo(tile.getPosition());
				fireMakingTile = tile.getPosition();
			}
		}
		return fireMakingTile;
	}
	
	
}


