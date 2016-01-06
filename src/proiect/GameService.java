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
	private Integer score;

	public GameService() {
		playing = true;
		score = 0;
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

	public void moveRoad() {
		road.setyVelocity(1.4 + score / 2000);
	}

	public void moveObstacle() {
		// o fac
	}

	public void moveCar(Direction direction) {
		if (direction.equals(Direction.LEFT)) {
			car.setxVelocity(-0.7);
			// road.setyVelocity(0);
		} else {
			car.setxVelocity(0.7);
			// road.setyVelocity(0);
		}
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}
