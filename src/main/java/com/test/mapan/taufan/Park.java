package com.test.mapan.taufan;

/**
 * Park Class
 *
 */
public class Park 
{
    private static int slotNumber = 1;
	private Car car;

	Park(Car _car) {
		System.out.println("Allocated slot number: " + slotNumber);
		car = _car;
		incrementSlotNumber();
	}

	public Car getCar() {
		return car;
	}

	public static void incrementSlotNumber() {
		slotNumber++;
	}
}
