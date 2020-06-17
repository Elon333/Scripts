package scripts.firemaking.paint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;

import javax.imageio.ImageIO;

import org.tribot.api.Timing;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Skills;
import org.tribot.api2007.Skills.SKILLS;
import org.tribot.api2007.types.RSInterface;

import scripts.firemaking.data.Vars;





public class Paint {

	private static int paintX = 0;
	private static int paintY = 338;
	private static int paintWidth = 519;
	private static int paintHeight = 165;

	public static final Rectangle closeButtonArea = new Rectangle(paintX+500, paintY, 20, 20);
	
	private static final Image paintBackGround = getImage("");

	private static final Image closeButton = getImage("https://i.imgur.com/6cR4t5w.png");
	
	private static final RenderingHints aa = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON);


	public static void paint(Graphics g) {

		Graphics2D gg = (Graphics2D) g;

		gg.setRenderingHints(aa);

		g.setColor(Color.WHITE);

		g.setFont(new Font("Verdant", Font.ITALIC, 16));

		g.drawImage(paintBackGround, paintX, paintY, paintWidth, paintHeight, null);

		g.drawImage(closeButton, paintX+500, paintY, 20, 20, null);
		
		g.drawString("Runtime: " + Timing.msToString(Timing.timeFromMark(Vars.get().startTime)), paintX + 10,
				paintY + 30);

		g.drawString("Status: " + Vars.get().nodeName, paintX + 10, paintY + 50);
	
		int gainedXp = Skills.getXP(SKILLS.FIREMAKING) - Vars.get().fireMakingStartXp;
			
		g.drawString("XP Gained: " + NumberFormat.getNumberInstance(Locale.US).format(gainedXp) + "  /  Hour: "+ 
		NumberFormat.getNumberInstance(Locale.US).format(gainedXp * (long) 3600000 / Timing.timeFromMark(Vars.get().startTime)),paintX + 10, paintY + 70);
		}
	



	public static void getPaintBackgroundLayout() {
		RSInterface chatInterface = Interfaces.get(162);

		if (chatInterface != null) {
			paintWidth = chatInterface.getWidth();
			paintHeight = chatInterface.getHeight();
			paintY = chatInterface.getAbsolutePosition().y;
			paintX = chatInterface.getAbsolutePosition().x;
		}
	}


	private static Image getImage(String url) {

		try {

			return ImageIO.read(new URL(url));

		} catch (IOException e) {

			return null;

		}

	}
}
