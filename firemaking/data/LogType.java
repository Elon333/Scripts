package scripts.firemaking.data;

public enum LogType {
	
	NORMAL_LOG("Logs", 1511,1),
	OAK_LOG("Oak logs", 1521,15),
	WILLOW_LOG("Willow logs", 1519,30),
	TEAK_LOG("Teak logs", 1519,35),
	MAPLE_LOG("Maple logs", 1517,45),
	MAHOGANY_LOG("Mahogany logs", 1515,60),
	YEW_LOG("Yew logs", 1515,60),
	MAGIC_LOG("Magic logs", 1513,75),
	RED_LOG("Redwood logs", 1513,75);
	
	private String name;
	private int id;
	private int lvl;
	
	LogType(String name, int id,int lvl){
		this.name = name;
		this.id = id;
		this.lvl = lvl;
	}
	
	public String getLogName(){
		return this.name;
	}
	
	public int getLogId(){
		return this.id;
	}
	
	public int getLogLvl(){
		return this.lvl;
	}

}
