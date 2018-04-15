package com.test.mapan.taufan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Parking Lot Class
 *
 */
public class ParkingLot 
{
	private int parkSize;
	private Queue<Park> availablePark;
	private ArrayList<Park> parked;

	ParkingLot(int size) {
		parkSize = size;
		availablePark = new LinkedList<Park>();
		parked = new ArrayList<Park>();
	}

	public void parkCar(Car car) {
		if (!isFull()) {
			Park park = new Park(car);
			parked.add(park);
		}
		else
			System.out.println("Sorry, parking lot is full");
	}

	public boolean isFull() {
		return parked.size() >= parkSize;
	}
}
