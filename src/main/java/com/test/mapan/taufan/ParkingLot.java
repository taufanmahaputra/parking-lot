package com.test.mapan.taufan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Parking Lot Class
 *
 */
public class ParkingLot 
{
	private int parkSize;
	private PriorityQueue<Park> availablePark;
	private ArrayList<Park> parked;

	ParkingLot(int size) {
		parkSize = size;
		availablePark = new PriorityQueue<Park>(6, new ParkComparator());
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

	public void findSlotNumberByRegNumber(String regNumber) {
		int result = -1;

		for(Park park : parked) {
			Car car = park.getCar();		      
        	
        	if (!park.isAvailableForPark()) {
	        	if(car.getNumberPlate().equals(regNumber)) {
	        		result = park.getSlotNumber();
	        		break;
	        	}
	        }
		}

		if (result > 0)
			System.out.println(result);
		else
			System.out.println("Not found");
	}

	public boolean isFull() {
		return parked.size() >= parkSize;
	}
}

class ParkComparator implements Comparator<Park>{
     
    // Overriding compare() method of Comparator 
    // for descending order of slot number
    public int compare(Park park1, Park park2) {
    	return 	park1.getSlotNumber() > park2.getSlotNumber() ? 1 :
    			(park1.getSlotNumber() < park2.getSlotNumber() ? -1 : 0);
    }
}