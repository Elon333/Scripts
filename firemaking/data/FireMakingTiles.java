package scripts.firemaking.data;

import org.tribot.api2007.types.RSTile;

import com.allatori.annotations.DoNotRename;

@DoNotRename
public enum FireMakingTiles {
   
    GRAND_EXCHANGE_NORTH(3169, 3495, 0),
    GRAND_EXCHANGE_SOUTH(3169, 3483, 0),
    VARROCK(3190, 3451, 0),
    EDGEVILLE(3102, 3504, 0),
    SEERS_VILLAGE(2732, 3485, 0);
    
	
	RSTile position;
    FireMakingTiles(int x, int y, int z){
        this.position = new RSTile(x,y,z);
    }

    public RSTile getPosition(){
        return this.position;
    }
}
