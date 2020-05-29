package scripts.combat.data;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.tribot.api.util.Screenshots;
import org.tribot.api2007.GameTab.TABS;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Skills;
import org.tribot.api2007.Skills.SKILLS;
import org.tribot.api2007.types.RSInterface;
import org.tribot.util.Util;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import scripts.combat.gui.GUIController;
import scripts.combat.gui.GuiFXML;




public class Utils2 {

	public static final File FOLDER = new File(Util.getWorkingDirectory().getAbsolutePath(), "//Elon");


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

	
	
	public static URL createCssFile() {
		try {
			
			File file = new File(GUIController.FOLDER.getAbsolutePath(), "combatGui" + ".css");
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
	

	
	public static void recordExp() {

		Vars.get().mageXp = Skills.getXP(SKILLS.MAGIC);

		Vars.get().defXp = Skills.getXP(SKILLS.DEFENCE);

		Vars.get().attXp = Skills.getXP(SKILLS.ATTACK);

		Vars.get().strXp = Skills.getXP(SKILLS.STRENGTH);

		Vars.get().hpXp = Skills.getXP(SKILLS.HITPOINTS);

		Vars.get().rangeXp = Skills.getXP(SKILLS.RANGED);
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
