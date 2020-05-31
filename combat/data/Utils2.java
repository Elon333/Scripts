package scripts.combat.data;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.function.Predicate;

import org.tribot.api.util.Screenshots;
import org.tribot.api2007.GameTab.TABS;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.Skills;
import org.tribot.api2007.Skills.SKILLS;
import org.tribot.api2007.ext.Filters;
import org.tribot.api2007.types.RSInterface;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSItemDefinition;
import org.tribot.util.Util;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import scripts.combat.gui.GuiFXML;
import scripts.utilty.Utils;



public class Utils2 {

	public static final File FOLDER = new File(Util.getWorkingDirectory().getAbsolutePath(), "//Elon");

	public static final File IMAGE_FOLDER = new File(FOLDER.getAbsolutePath(), "//Images");

   private static final String[] NAMES_TO_REMOVE = {"Divine","Super","super"};
	
	
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

			File file = new File(IMAGE_FOLDER.getAbsolutePath(), "combatGui" + ".css");
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


	public static Image cropImageInventory() {

		if (!TABS.INVENTORY.isOpen())
			TABS.INVENTORY.open();

		if (TABS.INVENTORY.isOpen()) {

			RSInterface tab = Interfaces.get(7);

			if (tab != null) {

				int yCord = tab.getAbsolutePosition().y;
				int xCord = tab.getAbsolutePosition().x;
				int height = tab.getHeight();
				int width = tab.getWidth();

				BufferedImage clientScreenShot = Screenshots.getScreenshotImage();
				BufferedImage croppedImage = clientScreenShot.getSubimage(xCord, yCord, width, height);

				Image image = SwingFXUtils.toFXImage(croppedImage, null);

				return image;
			}
		}
		return null;
	}



	public static void drinkPotion(ArrayList<String> potionList) {

		for (String potionName : potionList) {

			int actualLvl = Skills.getActualLevel(PotionEnum.valueOf(potionName.toUpperCase()).getCorrespondingSkill());
			int currentLvl = Skills.getCurrentLevel(PotionEnum.valueOf(potionName.toUpperCase()).getCorrespondingSkill());

			if (currentLvl <= actualLvl) {

				Predicate<RSItem> potion = Filters.Items.nameContains(potionName);

				if (potion != null) {

					RSItem[] item = Inventory.find(potion);

					if (item != null && item.length > 0) {

						if (item[0].click("Drink"))
							Utils.waitCondtion(() -> Player.getAnimation() == 829);
					}
				}
			}
		}
	}



	public static boolean potionHandler(HashMap<Integer, Integer> map, ArrayList<String> list) {

		for (Entry<Integer, Integer> entry : map.entrySet()) {

			int itemID = entry.getKey();
			String itemName = RSItemDefinition.get(itemID).getName();

			for (String name : NAMES_TO_REMOVE) {				
			
				if (itemName.contains(name))
				itemName = Utils.removeWord(itemName, name);
			}
			
			for (PotionEnum potion : PotionEnum.values()) {

				int spacePos = itemName.indexOf(" ");

				if (spacePos > 0) {
					String itemNameTrimed = itemName.substring(0, spacePos);

					if (itemNameTrimed.equalsIgnoreCase(potion.toString()))
					list.add(itemNameTrimed);
				}
			}
		}
		return !list.isEmpty();
	}



	public static void recordExp() {

		Vars.get().mageXp = Skills.getXP(SKILLS.MAGIC);

		Vars.get().defXp = Skills.getXP(SKILLS.DEFENCE);

		Vars.get().attXp = Skills.getXP(SKILLS.ATTACK);

		Vars.get().strXp = Skills.getXP(SKILLS.STRENGTH);

		Vars.get().hpXp = Skills.getXP(SKILLS.HITPOINTS);

		Vars.get().rangeXp = Skills.getXP(SKILLS.RANGED);
	}


	public static void recordStartExp() {

		Vars.get().startMageXp = Skills.getXP(SKILLS.MAGIC);

		Vars.get().startDefXp = Skills.getXP(SKILLS.DEFENCE);

		Vars.get().startAttXp = Skills.getXP(SKILLS.ATTACK);

		Vars.get().startStrXp = Skills.getXP(SKILLS.STRENGTH);

		Vars.get().startRangeXp = Skills.getXP(SKILLS.RANGED);
	}


	public static boolean checkExp() {

		return (Skills.getXP(SKILLS.MAGIC) > Vars.get().mageXp)

				|| (Skills.getXP(SKILLS.DEFENCE) > Vars.get().defXp)

				|| (Skills.getXP(SKILLS.ATTACK) > Vars.get().attXp)

				|| (Skills.getXP(SKILLS.STRENGTH) > Vars.get().strXp)

				|| (Skills.getXP(SKILLS.HITPOINTS) > Vars.get().hpXp)

				|| (Skills.getXP(SKILLS.RANGED) > Vars.get().rangeXp);
	}



}


