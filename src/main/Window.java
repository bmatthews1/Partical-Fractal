package main;


import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**@author Ben
 *
 * The Window Class creates a Pane that is used to display the various
 * line and point nodes
 */
public class Window extends Pane{
	private static final int WIDTH = 600;
	private static final int HEIGHT = 400;
	private Rectangle background;
	
	/**
	 * Default Constructor
	 */
	public Window(){
		this.setWidth(WIDTH);
		this.setHeight(HEIGHT);
		background = new Rectangle(0, 0, WIDTH, HEIGHT);
		background.setFill(Color.BLACK);
		addChild(background);
	}
	
	/**
	 * Adds a node to this pane
	 * 
	 * @param n
	 */
	public void addChild(Node n){
		this.getChildren().add(n);
	}
	
	/**
	 * removes a node from this pane
	 * 
	 * @param n
	 */
	public void removeChild(Node n){
		this.getChildren().remove(n);
	}
}
