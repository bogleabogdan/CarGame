package models;

import java.awt.image.BufferedImage;

public class Road {
	private Double y;
	private Double yVelocity;
	private BufferedImage roadImage;

	public Road(Double y, Double yVelocity, BufferedImage roadImage) {
		super();
		this.y = y;
		this.yVelocity = yVelocity;
		this.roadImage = roadImage;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Double getyVelocity() {
		return yVelocity;
	}

	public void setyVelocity(Double yVelocity) {
		this.yVelocity = yVelocity;
	}

	public BufferedImage getRoadImage() {
		return roadImage;
	}

	public void setRoadImage(BufferedImage roadImage) {
		this.roadImage = roadImage;
	}

}
