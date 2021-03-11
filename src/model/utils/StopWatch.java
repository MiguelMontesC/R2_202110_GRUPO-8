package model.utils;

public class StopWatch {

	private final long start;

	public StopWatch()
	{ 
		start = System.nanoTime(); }

	public double elapsedTime()
	{
		long now = System.nanoTime();
		return (now - start) / 1.0e9;
	}

}

