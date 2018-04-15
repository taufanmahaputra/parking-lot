package com.test.mapan.taufan;

/**
 * Car Class
 *
 */
public class Car 
{
    private String numberPlate;
	private String color;

	Car(String plate, String clr) {
		numberPlate = plate;
		color = clr;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public String getColor() {
		return color;
	}
}
