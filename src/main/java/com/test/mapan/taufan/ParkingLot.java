package com.test.mapan.taufan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map;

/**
 * Parking Lot Class
 *
 */
public class ParkingLot 
{
	private int parkSize;
	private PriorityQueue<Park> availablePark;
	private ArrayList<Park> parked;
	private Map<String, ArrayList<Car>> carsWithColorKey;

	ParkingLot(int size) {
		parkSize = size;
		availablePark = new PriorityQueue<Park>(parkSize, new ParkComparator());
		parked = new ArrayList<Park>();
		carsWithColorKey = new HashMap<String, ArrayList<Car>>();
	}

	public void parkCar(Car car) {
		if (!isFull()) {
			Park park = new Park(car);
			parked.add(park);
			assignCarWithColor(car);
		}
		else if (!availablePark.isEmpty()) {
			Park park = availablePark.remove();
			park.changeCar(car);
			assignCarWithColor(car);
		}
		else
			System.out.println("Sorry, parking lot is full");
	}

	public void assignCarWithColor(Car car) {
		String color = car.getColor();

		if (!carsWithColorKey.containsKey(color)) {
			ArrayList<Car> cars = new ArrayList<Car>();
			carsWithColorKey.put(color, cars);
		}

		ArrayList<Car> result = carsWithColorKey.get(color);
		result.add(car);
		carsWithColorKey.put(color, result);
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

	public void findAllRegNumbersByColour(String color) {
		
		if (!carsWithColorKey.containsKey(color))
			System.out.println("Not found");
		else {
			ArrayList<Car> result = carsWithColorKey.get(color);

			for (int idx = 0; idx < result.size(); idx++) { 		      
		        if (idx != result.size()-1)
		        	System.out.print(result.get(idx).getNumberPlate() + ", "); 
		        else
		        	System.out.println(result.get(idx).getNumberPlate()); 		
		    }   
		}
	}

	public void findAllSlotNumbersByColour(String color) {
		ArrayList<Integer> result = new ArrayList();

		for (Park park : parked) {
			Car car = park.getCar();		      
        	
        	if (!park.isAvailableForPark()) {
	        	if(car.getColor().equals(color)) {
	        		result.add(park.getSlotNumber());
	        	}
	        }
		}

		if (result.size() > 0) {
			for (int idx = 0; idx < result.size(); idx++) { 		      
		        if (idx != result.size()-1)
		        	System.out.print(result.get(idx) + ", "); 
		        else
		        	System.out.println(result.get(idx)); 		
		    }   
		}
		else
			System.out.println("Not found");
	}

	public void findSlotNumberByRegNumber(String regNumber) {
		int result = -1;

		for (Park park : parked) {
			Car car = park.getCar();		      
        	
        	if (!park.isAvailableForPark()) {
	        	if (car.getNumberPlate().equals(regNumber)) {
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
    // for ascending order of slot number
    public int compare(Park park1, Park park2) {
    	return 	park1.getSlotNumber() > park2.getSlotNumber() ? 1 :
    			(park1.getSlotNumber() < park2.getSlotNumber() ? -1 : 0);
    }
}