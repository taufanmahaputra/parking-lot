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
		else if (!availablePark.isEmpty()) {
			Park park = availablePark.remove();
			park.changeCar(car);
		}
		else
			System.out.println("Sorry, parking lot is full");
	}

	public void leave(int idx) {
		System.out.println("Slot number " + idx + " is free");

		idx -= 1;
		Park park = parked.get(idx);

		park.setAvailableForPark();
		availablePark.add(park);
	}

	public void status() {
		System.out.println("Slot No. Registration No Colour");
		
		for (Park park : parked) { 
        	Car car = park.getCar();		      
        	
        	if (!park.isAvailableForPark()) {
	        	System.out.print(park.getSlotNumber());
	        	System.out.print(" " + car.getNumberPlate() + " " + car.getColor());
	        	System.out.println();
	        }
      	}
	}

	public boolean isFull() {
		return parked.size() >= parkSize;
	}
}
