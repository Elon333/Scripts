package scripts.utilty;

public class Timer {
	private long end;
	private final long start;
	private final long period;

	/** Our script's start time */
	public static final long SCRIPT_START_TIME = System.currentTimeMillis();

	/**
	 * Instantiates a new Timer with a given time period in milliseconds.
	 *
	 * @param period Time period in milliseconds.
	 */
	public Timer(final long period) {
		this.period = period;
		start = System.currentTimeMillis();
		end = start + period;
	}

	/**
	 * @return Elapsed time
	 */
	public static long getScriptElapsedTime() {
		return System.currentTimeMillis() - Timer.SCRIPT_START_TIME;
	}

	/**
	 * Returns the number of milliseconds elapsed since the start time.
	 *
	 * @return The elapsed time in milliseconds.
	 */
	public long getElapsed() {
		return System.currentTimeMillis() - start;
	}

	/**
	 * Returns the number of milliseconds remaining until the timer is up.
	 *
	 * @return The remaining time in milliseconds.
	 */
	public long getRemaining() {
		if (isRunning()) {
			return end - System.currentTimeMillis();
		}
		return 0;
	}

	/**
	 * Returns <tt>true</tt> if this timer's time period has not yet elapsed.
	 *
	 * @return <tt>true</tt> if the time period has not yet passed.
	 */
	public boolean isRunning() {
		return System.currentTimeMillis() < end;
	}

	/**
	 * Restarts this timer using its period.
	 */
	public void reset() {
		end = System.currentTimeMillis() + period;
	}

	/**
	 * Sets the end time of this timer to a given number of milliseconds from the
	 * time it is called. This does not edit the period of the timer (so will not
	 * affect operation after reset).
	 *
	 * @param ms The number of milliseconds before the timer should stop running.
	 * @return The new end time.
	 */
	public long setEndIn(final long ms) {
		end = System.currentTimeMillis() + ms;
		return end;
	}
}
