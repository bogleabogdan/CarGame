package services;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import listeners.Direction;
import models.Car;
import models.Obstacle;
import models.Road;

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

	public void createObstacle(Double x, Double y, Double yVelocity, String imagePath) {
		BufferedImage obstacleImage;
		try {
			obstacleImage = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
			obstacleImage = new BufferedImage(20, 20, 1);
		}

		obstacle = new Obstacle(x, y, yVelocity, obstacleImage);

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
		road.setyVelocity(1.4 + score.doubleValue() / 2000);
		if (road.getY() >= road.getRoadImage().getHeight() - 480) {
			road.setY(0.0);
		}
	}

	public void moveObstacle() {
		obstacle.setyVelocity(1.4 + score.doubleValue() / 2000);
		Random i = new Random();
		if (obstacle.getY() >= road.getRoadImage().getHeight() - 480) {
			obstacle.setY(0.0);
			obstacle.setX((double) i.nextInt(480 - 345) + 345);
		}
	}

	public void moveCar(Direction direction) {
		if (direction.equals(Direction.LEFT)) {
			car.setxVelocity(-0.7);
			// road.setyVelocity(0);
		}
		if (direction.equals(Direction.RIGHT)) {
			car.setxVelocity(0.7);
			// road.setyVelocity(0);
		}
	}

	public void checkCarPosition() {
		if (car.getX() <= 345.0) {
			car.setX(345.0);
		}
		if (car.getX() >= 483.0) {
			car.setX(483.0);
		}

	}

	public void checkCollision() {
		if (obstacle.getY() >= 350 && obstacle.getY() <= 410) {
			if (car.getX() >= obstacle.getX() && car.getX() <= obstacle.getX() + 40) {
				setPlaying(false);
			}
		}
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}
