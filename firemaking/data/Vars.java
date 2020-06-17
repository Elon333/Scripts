package scripts.firemaking.data;







import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.tribot.api2007.types.RSTile;




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
	
	public  RSTile fireMakingTile,bankTile;

	public  boolean script = true;
	
	public  int logsToBurn;
	
	public  boolean bank = true;
	
	public  boolean travel = false;

	public 	LinkedHashMap<Integer, Integer> inventoryMap = new LinkedHashMap<>();

	public ArrayList<LogType> logToBurnList = new ArrayList<LogType>();
	
	public int fireMakingXp,fireMakingStartXp;
}
