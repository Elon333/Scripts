package scripts.combat.data;







import java.awt.image.BufferedImage;
import java.util.LinkedHashMap;

import org.tribot.api2007.types.RSTile;
import scripts.combat.paint.Paint;
import scripts.combat.paint.Paint.Tabs;







public class Vars {
	
	private static  Vars vars;
	
	public static  Vars get() {
		return vars == null? vars = new Vars() : vars;
	}


	public static  void reset() {
		vars = new Vars();
	}
	
	public long currentTime,startTime;
		
	public  String target,nodeName;

	public  String status = "fefeg";
	
	public Tabs tab = Paint.Tabs.INFO;
	
	public  RSTile combatTile,bankTile;

	public  int eatAtHP,playerCount;

	public  String[] itemsToLoot;

	public  boolean script = true;
	
	public  boolean bank = true;
	
	public  boolean abc2Delay;

	public 	LinkedHashMap<Integer, Integer> inventoryMap = new LinkedHashMap<>();

	public int attXp, strXp, defXp, mageXp, rangeXp, hpXp;


}
