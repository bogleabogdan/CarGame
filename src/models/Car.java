package models;

import java.awt.image.BufferedImage;

public class Car {
	private Double x;
	private Double xVelocity;
	private BufferedImage carImage;

	public Car(Double x, Double xVelocity, BufferedImage carImage) {
		super();
		this.x = x;
		this.xVelocity = xVelocity;
		this.carImage = carImage;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getxVelocity() {
		return xVelocity;
	}

	public void setxVelocity(Double xVelocity) {
		this.xVelocity = xVelocity;
	}

	public BufferedImage getCarImage() {
		return carImage;
	}

	public void setCarImage(BufferedImage carImage) {
		this.carImage = carImage;
	}

}
