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
	private LinkedList<Double> distances;
	private LinkedList<Double> angles;
	private double totalDistance; //distance from first control to last;
	private double totalAngle; //total angle between first control and last
	
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
		distances = new LinkedList<>();
		angles = new LinkedList<>();
	}
	
	/**
	 * Public call to calculate the RenderPoint positions and colors
	 */
	public void calculatePoints(){
		distances.clear();
		angles.clear();
		//TODO
		for (int i = 0; i < controls.size()-1; i++){
			ControlPoint current = controls.get(i);
			ControlPoint next = controls.get(i+1);
			
			double x1 = current.getCenterX();
			double y1 = current.getCenterY();
			double x2 = next.getCenterX();
			double y2 = next.getCenterY();
			
			double xDiff = x1 - x2;
			double yDiff = y1 - y2;
			
			double distance = Math.sqrt(xDiff*xDiff + yDiff*yDiff);
			
			double angle = Math.atan(yDiff/xDiff);
			
			distances.add(distance);
			
			angles.add(angle);
		}
		
		ControlPoint start = controls.get(0);
		ControlPoint end = controls.get(controls.size()-1);
		
		double x1 = start.getCenterX();
		double y1 = start.getCenterY();
		double x2 = end.getCenterX();
		double y2 = end.getCenterY();
		
		double xDiff = x1 - x2;
		double yDiff = y1 - y2;
		
		totalDistance = Math.sqrt(xDiff*xDiff + yDiff*yDiff);
		
		totalAngle = Math.atan(yDiff/xDiff);
		
		for (int i = 0; i < angles.size(); i++){
			Double angle = angles.get(i);
			angle = angle - totalAngle;
		}
		
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
		
	}
}
