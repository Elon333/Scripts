package scripts.utilty;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.Combat;
import org.tribot.api2007.NPCs;
import org.tribot.api2007.PathFinding;
import org.tribot.api2007.Players;
import org.tribot.api2007.types.RSNPC;
import org.tribot.api2007.types.RSPlayer;

public class Utils {

	private static List<Integer> abc2waitTimes = new ArrayList<>();
	private static double FACTOR = 0.4;


	public static boolean waitCondtion(BooleanSupplier condition) {
		return Timing.waitCondition(() -> {
			General.sleep(100, 400);
			return (condition.getAsBoolean());
		}, General.random(4000, 6500));
	}



	public static boolean waitCondtion(BooleanSupplier condition, int min, int max) {
		return Timing.waitCondition(() -> {
			General.sleep(100, 400);
			return (condition.getAsBoolean());
		}, General.random(min, max));
	}



	public static Integer getPlayerCount() {
		RSPlayer[] players = Players.getAll();
		int playersAmount = players.length - 1;
		return playersAmount;
	}


	public static RSNPC reachableNpc(String name) {
		RSNPC[] targets = NPCs.findNearest(name);
		if (targets != null && targets.length > 0) {
			for (RSNPC target : targets) {
				if (!target.isInCombat() && (PathFinding.canReach(target.getPosition(), false))) {
					return target;
				}
			}
			return null;
		} else {
			return null;
		}
	}



	public static int average(List<Integer> times) {
		Integer total = 0;
		if (!times.isEmpty()) {
			for (Integer i : times)
				total += i;
			return total.intValue() / times.size();
		}
		return total;
	}



	public static List<Integer> sleep(List<Integer> waitTimes) {
		if (waitTimes.isEmpty())
			AntiBan.generateTrackers(General.random(500, 1600), false);

		if (!waitTimes.isEmpty())
			AntiBan.generateTrackers(average(waitTimes), false);

		final int reactionTime = (int) (AntiBan.getReactionTime() * FACTOR);
		waitTimes.add(reactionTime);
		General.println("ABC2 DELAY: " + reactionTime);
		AntiBan.sleepReactionTime(reactionTime);
		return waitTimes;

	}



	public static void abc2ReactionSleep(long time) {
		if (Combat.isUnderAttack())
			return;
		AntiBan.generateTrackers((int) (System.currentTimeMillis() - time), false);
		abc2waitTimes.add(AntiBan.getReactionTime());
		abc2waitTimes = Utils.sleep(abc2waitTimes);
	}



	public static String removeWord(String string, String word) {

		if (string.contains(word)) {
			String tempWord = word + " ";
			string = string.replaceAll(tempWord, "");
			tempWord = " " + word;
			string = string.replaceAll(tempWord, "");
		}
		return string;
	}



}
