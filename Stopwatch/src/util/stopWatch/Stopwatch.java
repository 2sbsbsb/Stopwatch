/**
 * @author sb
 */
package util.stopWatch;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

import util.map.MapUtil;

/*-
 * Simple StopWatch
 * 
 * 1. Prints time in desc order. 
 * 2. Simple to use
 * 
 * Usages
 * Stopwatch sw = new Stopwatch(); 
 * sw.start(); 
 * After Task 1 completion 
 * sw.measure("Task1"); 
 * After Task 2 completion 
 * sw.measure("Task2");
 * After Task 3 completion  
 * sw.measure("Task3 Complete"); 
 * sw.stop(); // It will print time consumed by task A, B and C in descending order
 */
public class Stopwatch {

	private long startTime;
	private long stopTime;
	private Map<String, Double> measurementMap = new HashMap<String, Double>();

	/**
     */
	public void start() {
		startTime = System.nanoTime();
	}

	/**
	 * @return
	 */
	public long elapsedTimeNanos() {
		return stopTime - startTime;
	}

	/**
	 * @return
	 */
	public double elapsedTimeMicros() {
		return elapsedTimeNanos() / 1000d;
	}

	/**
	 * @return
	 */
	public double elapsedTimeMills() {
		return elapsedTimeMicros() / 1000d;
	}

	/**
	 * @return
	 */
	public double elapsedTimeSeconds() {
		return elapsedTimeMills() / 1000d;
	}

	/**
	 * @return
	 */
	public double elapsedTimeMinutes() {
		return elapsedTimeSeconds() / 60d;
	}

	/**
	 * @param measurePoint
	 */
	public void measure(String measurePoint) {
		// Stop the time first
		stopTime = System.nanoTime();
		// Housekeeping while the stopWatch is not running - Important
		double elapsedTime = elapsedTimeSeconds();
		measurementMap.put(measurePoint, new Double(elapsedTime));
		// Restart the stop watch
		startTime = System.nanoTime();
	}

	/**
	 * @param printAllMeasurements
	 */
	public void stop(boolean printAllMeasurements) {
		// Stop the time first
		stopTime = System.nanoTime();
		// If no measurement was ever called, total time is stopTime -
		// startTime, otherwise sum or all measurements
		double totalTime = measurementMap.size() == 0 ? (stopTime - startTime)
				: 0d;
		//
		Map<Double, Set<String>> valuesToKeys = MapUtil
				.valueToKey(measurementMap);
		TreeMap<Double, Set<String>> sortedValuesToKeysMap = new TreeMap<>(
				valuesToKeys);
		NavigableMap<Double, Set<String>> reverseSortedMap = sortedValuesToKeysMap
				.descendingMap();
		Iterator<Entry<Double, Set<String>>> iterator = reverseSortedMap
				.entrySet().iterator();
		//
		System.out.println("Tasks 		-> time (seconds)");
		System.out.println("--------------------------------------");
		while (iterator.hasNext()) {
			Entry<Double, Set<String>> tasksEntry = iterator.next();
			double time = tasksEntry.getKey();
			Set<String> tasks = tasksEntry.getValue();
			for (String task : tasks) {
				totalTime += time;
				if (printAllMeasurements) {
					System.out.println(task + " 		-> " + time);
				}
			}
		}
		System.out.println("Sum(Tasks)	-> " + totalTime);
	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Stopwatch sw = new Stopwatch();
		sw.start();
		Thread.sleep(100);
		sw.measure("A");
		Thread.sleep(1000);
		sw.measure("B");
		Thread.sleep(10);
		sw.measure("C");
		sw.stop(true);
		sw.stop(false);
	}

}
