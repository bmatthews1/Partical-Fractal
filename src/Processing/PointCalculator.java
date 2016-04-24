package Processing;

import java.util.LinkedList;

import javafx.scene.shape.Circle;
import main.ControlPoint;
import main.RenderPoint;

/**
 * @author Ben
 *
 * The PointCalculator class is used to calculate the point positions for
 * the RenderPoits based on the ControlPoints
 */
public class PointCalculator {
	private static final double START_HUE = 60;
	private static final double END_HUE = 240;
	
	private LinkedList<ControlPoint> controls;
	private LinkedList<RenderPoint> renders;
	
	/**
	 * Contructor for the PointCalculator takes in a list of ControlPoints
	 * and RenderPoints
	 * 
	 * @param controls - LinkedList of ControlPoints 
	 * @param renders - LinkedList of RenderPoints
	 */
	public PointCalculator(LinkedList<ControlPoint> controls, LinkedList<RenderPoint> renders){
		this.controls = controls;
		this.renders = renders;
	}
	
	/**
	 * Public call to calculate the RenderPoint positions and colors
	 */
	public void calculatePoints(){
		//TODO
	}
	
	/**
	 * Allocates and adjusts the location of RenderPoints based on
	 * two bound circles. This is done using the CenterPoint of the
	 * circles
	 * 
	 * @param c1 - bound Circle 1
	 * @param c2 - bound circle 2
	 */
	private void addPoints(Circle c1, Circle c2){
		double x1 = c1.getCenterX();
		double y1 = c1.getCenterY();
		double x2 = c2.getCenterX();
		double y2 = c2.getCenterY();
		
		double xDiff = x1 - x2;
		double yDiff = y1 - y2;
		
		double distance = Math.sqrt(xDiff*xDiff + yDiff*yDiff);
	}
}
