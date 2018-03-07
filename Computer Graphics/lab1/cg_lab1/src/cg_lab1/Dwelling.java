package cg_lab1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene; // contains Group
import javafx.stage.Stage; // contains Scene

// colors
import javafx.scene.paint.Color;

// primitives
import javafx.scene.shape.*;

public class Dwelling extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage){
		Group root = new Group();
		
		// background initialization
		Scene scene = new Scene(root, 800, 600);
		scene.setFill(Color.BLACK);
		
		// rectangle: x, y, x_length, y_length
		Rectangle skyline = new Rectangle(0, 400, 800, 200);
		root.getChildren().add(skyline);
		skyline.setFill(Color.GREEN);
		
		Rectangle houseBody = new Rectangle(150, 250, 500, 250);
		root.getChildren().add(houseBody);
		houseBody.setFill(Color.BROWN);
		
		int amountOfWindows = 2;
		Rectangle[] windows = new Rectangle[amountOfWindows];
		for(int i=0; i<amountOfWindows; i++){
			windows[i] = createSquare(0, 0, 75);
			windows[i].setFill(Color.YELLOW);
		}
		setRectangleCoords(windows[0], 200, 320);
		setRectangleCoords(windows[1], 525, 320);
		for(int i=0; i<amountOfWindows; i++){
			root.getChildren().add(windows[i]);
		}
		
		Polygon roof = new Polygon(400, 75, 125, 250, 675, 250);
		root.getChildren().add(roof);
		roof.setFill(Color.GRAY);
		
		int amountOfStars = 4;
		Rectangle[] stars = new Rectangle[amountOfStars];
		for(int i=0; i<amountOfStars; i++){
			stars[i] = createSquare(0, 0, 25);
			stars[i].setFill(Color.WHITE);
		}
		setRectangleCoords(stars[0], 100, 100);
		setRectangleCoords(stars[1], 200, 60);
		setRectangleCoords(stars[2], 500, 50);
		setRectangleCoords(stars[3], 730, 230);
		for(int i=0; i<amountOfStars; i++){
			root.getChildren().add(stars[i]);
		}
		
		Circle moon = new Circle(700, 100, 50);
		moon.setFill(Color.YELLOW);
		root.getChildren().add(moon);
		
		Circle eclipse = new Circle(725, 100, 35);
		eclipse.setFill(Color.BLACK);
		root.getChildren().add(eclipse);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private Rectangle createSquare(double x, double y, double length){
		return new Rectangle(x, y, length, length);
	}
	
	private void setRectangleCoords(Rectangle rec, double x, double y){
		rec.setX(x);
		rec.setY(y);
	}
}
