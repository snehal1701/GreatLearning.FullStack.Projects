package com.greatlearning.building;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.greatlearning.floorBuilder.FloorBuilder;

public class ConstructBuildng {
	public static void main(String[] args) {
		FloorBuilder fb = null;
		int maxFloors = 0;
		// Collect user Inputs
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("enter the total no of floors in the building");
			// Error Checking for invalid inputs
			try {
				maxFloors = sc.nextInt();
			} catch (InputMismatchException e) {
				throw new InputMismatchException("Only positive Integers are allowed for Max Floors");
			}
			if (maxFloors < 1) {
				System.out.println("Max floors lesser than 1 is not allowed");
				throw new InputMismatchException("Expecting Positive integers");
			}

			fb = new FloorBuilder(maxFloors);

			// Capture floor sizes
			for (int i = 1; i <= fb.getMaxFloors(); i++) {
				int floorSize = 0;
				System.out.println("enter the floor size given on day : " + i);

				// Error Checking for invalid inputs
				try {
					floorSize = sc.nextInt();
				} catch (InputMismatchException e) {
					throw new InputMismatchException("Only positive Integers are allowed");
				}
				// Check for floor size greater than max floors
				if (floorSize > fb.getMaxFloors()) {
					System.out.println("entered floor size is greater than Max Floors, retry");
					i--;
					continue;
				}
				// Check for duplicate floor sizes
				if (fb.duplicateFloorsCheck(floorSize)) {
					System.out.println("entered floor size already exists, retry");
					i--;
					continue;
				}
				// Check for floor sized less than 1
				if (floorSize < 1) {
					System.out.println("Floor size lesser than 1 is not allowed, retry ");
					i--;
					continue;
				}
				fb.addFloors(floorSize);

			}
			// Call Construction method
			fb.startConstruction();

		} catch (InputMismatchException e) {
			System.out.println("Exception occured : " + e);
		}

	}

}
