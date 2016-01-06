package proiect;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameService {

	private Boolean playing;
	private Car car;
	private Road road;
	private Obstacle obstacle;

	public GameService() {
		playing = true;
	}

	public void createCar(Double x, Double xVelocity, String imagePath) {
		BufferedImage carImage;
		try {
			carImage = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
			carImage = new BufferedImage(20, 20, 1);
		}

		car = new Car(x, xVelocity, carImage);

	}

	public void createRoad(Double y, Double yVelocity, String imagePath) {
		BufferedImage roadImage;
		try {
			roadImage = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
			roadImage = new BufferedImage(20, 20, 1);
		}

		road = new Road(y, yVelocity, roadImage);

	}

	public void createObstacle(Double y, Double yVelocity, String imagePath) {
		BufferedImage obstacleImage;
		try {
			obstacleImage = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
			obstacleImage = new BufferedImage(20, 20, 1);
		}

		obstacle = new Obstacle(y, yVelocity, obstacleImage);

	}

	public Boolean isPlaying() {
		return playing;
	}

	public void setPlaying(Boolean playing) {
		this.playing = playing;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Road getRoad() {
		return road;
	}

	public void setRoad(Road road) {
		this.road = road;
	}

	public Obstacle getObstacle() {
		return obstacle;
	}

	public void setObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}

}
