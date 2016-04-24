package main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * @author Ben
 *
 * The RenderPoint class Extends Circle and represents a rendered point
 * on the fractal as calculated by PointCalculator
 */
public class RenderPoint extends Circle{
	private static final double RADIUS = 2;
	
	/**
	 * Default Constructor creates a White point at [0, 0]
	 */
	public RenderPoint(){
		this.setFill(Color.WHITE);
		setLocation(0, 0);
		this.setRadius(RADIUS);
	}
	
	/**
	 * Sets the Color of this RenderPoint
	 * 
	 * @param fill
	 */
	public void setFill(Color fill){
		
	}
	
	/**
	 * Sets the Center Location of this RenderPoint
	 * 
	 * @param x
	 * @param y
	 */
	public void setLocation(double x, double y){
		
	}
}
