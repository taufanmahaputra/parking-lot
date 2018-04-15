//Author : Taufan Mahaputra   -   https://github.com/taufanmahaputra

package com.test.mapan.taufan;

import java.io.*;
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
			parkingLot.findAllRegNumbersByColour(commands[1]);
		}
		else if (cmd.equals("slot_numbers_for_cars_with_colour")) {
			parkingLot.findAllSlotNumbersByColour(commands[1]);
		}
		else if (cmd.equals("slot_number_for_registration_number")) {
			parkingLot.findSlotNumberByRegNumber(commands[1]);
		}
		else { // error command
			System.out.println("Command no supported. Please try again.");
		} 
	}

    public static void main(String[] args) throws FileNotFoundException {
		App main = new App();

		String[] commands;

		if (args.length > 0) {
			Scanner scan = new Scanner(new File(args[0]));

		    while(scan.hasNextLine()){
		        String line = scan.nextLine();
		        
		        commands = line.split(" ");

				main.processInput(commands);
		    }
		}
		else {
			Scanner input = new Scanner(System.in);

			while(true) {
				String command = input.nextLine();

				commands = command.split(" ");

				main.processInput(commands);
			}
		}
	}
}
