package models;

import java.awt.image.BufferedImage;

public class Obstacle {
	private Double x;
	private Double y;
	private Double yVelocity;
	private BufferedImage obstacleImage;

	public Obstacle(Double x, Double y, Double yVelocity, BufferedImage obstacleImage) {
		super();
		this.x = x;
		this.y = y;
		this.yVelocity = yVelocity;
		this.obstacleImage = obstacleImage;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
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

	public BufferedImage getObstacleImage() {
		return obstacleImage;
	}

	public void setObstacleImage(BufferedImage obstacleImage) {
		this.obstacleImage = obstacleImage;
	}

}
