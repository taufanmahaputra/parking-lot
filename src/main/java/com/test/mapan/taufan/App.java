package com.test.mapan.taufan;

import java.util.Scanner;

/**
 * Main App 
 *
 */
public class App 
{
	private ParkingLot parkingLot;

	public void processInput(String[] commands) {
		String cmd = commands[0];

		if (cmd.equals("create_parking_lot")) {
			int size = Integer.parseInt(commands[1]);
			parkingLot = new ParkingLot(size);

			System.out.println("Created a parking lot with " + size + " slots");
		}
		else if (cmd.equals("park")) {
			parkingLot.parkCar(new Car(commands[1], commands[2]));
		}
		else if (cmd.equals("leave")) {
			parkingLot.leave(Integer.parseInt(commands[1]));
		}
		else if (cmd.equals("status")) {
			parkingLot.status();
		}
		else if (cmd.equals("registration_numbers_for_cars_with_colour")) {

		}
		else if (cmd.equals("slot_numbers_for_cars_with_colour")) {

		}
		else { // equals to slot_number_for_registration_number

		} 
	}

    public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		App main = new App();

		while(true) {
			String command = input.nextLine();

			String[] commands = command.split(" ");

			main.processInput(commands);
		}

		// INPUT

		// create_parking_lot 6
		// park KA-01-HH-1234 White
		// park KA-01-HH-9999 White
		// park KA-01-BB-0001 Black
		// park KA-01-HH-7777 Red
		// park KA-01-HH-2701 Blue
		// park KA-01-HH-3141 Black
		// leave 4
		// status
		// park KA-01-P-333 White
		// park DL-12-AA-9999 White
		// registration_numbers_for_cars_with_colour White
		// slot_numbers_for_cars_with_colour White
		// slot_number_for_registration_number KA-01-HH-3141
		// slot_number_for_registration_number MH-04-AY-1111


		// OUTPUT

		// Created a parking lot with 6 slots
		// Allocated slot number: 1
		// Allocated slot number: 2
		// Allocated slot number: 3
		// Allocated slot number: 4
		// Allocated slot number: 5
		// Allocated slot number: 6
		// Slot number 4 is free
		// Slot No. Registration No Colour
		// 1 KA-01-HH-1234 White
		// 2 KA-01-HH-9999 White
		// 3 KA-01-BB-0001 Black
		// 5 KA-01-HH-2701 Blue
		// 6 KA-01-HH-3141 Black
		// Allocated slot number: 4
		// Sorry, parking lot is full
		// KA-01-HH-1234, KA-01-HH-9999, KA-01-P-333
		// 1, 2, 4
		// 6
		// Not found
	}
}
