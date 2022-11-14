package com.greatlearning.floorBuilder;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FloorBuilder {
	private int maxFloors;
	private Queue<Integer> dayQueue = new LinkedList<>();
	private Queue<Integer> sizeQueue = new PriorityQueue<>(Comparator.reverseOrder());

	public FloorBuilder(int maxFloors) {
		super();
		this.maxFloors = maxFloors;
	}

	public int getMaxFloors() {
		return maxFloors;
	}

	// floor size addition
	public void addFloors(int floorSize) {
		dayQueue.add(floorSize);
	}

	// duplicate floor size checker
	public boolean duplicateFloorsCheck(int floorSize) {
		return dayQueue.contains(floorSize);

	}

	// method to analyze building construction
	public void startConstruction() {
		System.out.println("The order of construction is as follows");
		int currentMaxfloor = maxFloors;
		for (int i = 1; i <= maxFloors; i++) {
			System.out.println("Day " + i);

			this.sizeQueue.add(dayQueue.remove());

			while (!sizeQueue.isEmpty() && sizeQueue.peek() >= currentMaxfloor) {
				System.out.print(sizeQueue.remove() + " ");
				currentMaxfloor--;
			}
			System.out.println();
		}
	}

}
