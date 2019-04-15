package com.isa.analyse;

public class TimeCounter {
	private long totalTime;
	private long startTime;
	private long lapTimeStamp;
	private int nombreElements;
	private long minTime = Long.MAX_VALUE;
	private long maxTime = Long.MIN_VALUE;

	public void start() {
		startTime = System.currentTimeMillis();
		lapTimeStamp = startTime;
	}

	public void stop() {
		totalTime = System.currentTimeMillis() - startTime;
		lap();
	}

	public long getTotalTime() {
		return totalTime;
	}

	public void lap() {
		long timeStamp = System.currentTimeMillis();

		long lapDiff = ajouteLap(timeStamp);
		lapTimeStamp = timeStamp;
		if (lapDiff < minTime)
			minTime = lapDiff;
		if (lapDiff > maxTime)
			maxTime = lapDiff;
	}

	public long getMinTime() {
		return minTime;
	}

	public long getMaxTime() {
		return maxTime;
	}

	public long getAverageTime() {
		long avg = nombreElements == 0 ? 0 : totalTime / nombreElements;
		return avg;
	}

	private long ajouteLap(long timeStamp) {
		nombreElements++;
		return timeStamp - lapTimeStamp;
	}

}
