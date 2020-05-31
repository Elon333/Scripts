package scripts.combat.data;







import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.tribot.api2007.types.RSTile;

import com.allatori.annotations.DoNotRename;



public class Vars {
	
	private static  Vars vars;
	
	public static  Vars get() {
		return vars == null? vars = new Vars() : vars;
	}


	public static  void reset() {
		vars = new Vars();
	}
	
	public long currentTime,startTime;
		
	
	public  String nodeName = "Idle";
	
	public  String target;
	
	public  RSTile combatTile,bankTile;

	public  int eatAtHP,playerCount;

	public  String[] itemsToLoot;

	public  boolean script = true;
	
	public  boolean bankPotion = false;
	
	public  boolean bank = true;
	
	public  boolean abc2Delay;

	public boolean drinkPotions = false;
	
	public ArrayList<String> potionNames = new ArrayList<>();
	
	public 	LinkedHashMap<Integer, Integer> inventoryMap = new LinkedHashMap<>();

	public int attXp,startAttXp, strXp, startStrXp, defXp, startDefXp, mageXp, startMageXp, rangeXp, startRangeXp, hpXp;
}
