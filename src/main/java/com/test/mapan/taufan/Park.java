package com.test.mapan.taufan;

/**
 * Park Class
 *
 */
public class Park 
{
    private static int slot = 1;
    private int slotNumber;
	private Car car;
	private boolean isCarParked;

	Park(Car _car) {
		System.out.println("Allocated slot number: " + slot);
		car = _car;
		slotNumber = slot;
		isCarParked = true;
		incrementSlotNumber();
	}

	public Car getCar() {
		return car;
	}

	public boolean isAvailableForPark() {
		return !isCarParked;
	}

	public void setAvailableForPark() {
		isCarParked = false;
	}

	public void changeCar(Car _car) {
		System.out.println("Allocated slot number: " + slotNumber);
		car = _car;
		isCarParked = true;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public static void incrementSlotNumber() {
		slot++;
	}
}
