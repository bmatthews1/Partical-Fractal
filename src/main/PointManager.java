package main;

import java.util.LinkedList;
import java.util.Random;

import Processing.PointCalculator;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * @author Ben
 *
 * The PointManager class is responsible for keeping track of the control points
 * and render points as well as recalculating point positions if a control point is moved
 */
public class PointManager {
	private static final int INITIAL_CONTROLS = 5;
	private static final int INITIAL_RENDERS = 500;
	
	private LinkedList<ControlPoint> controls;
	private LinkedList<Line> lines;
	private LinkedList<RenderPoint> renders;
	private Window window;
	private PointCalculator pointCalculator;
	
	private double width;
	private double height;
	
	private Random random;
	
	
	/**
	 * creates a new Point manager with a reference to a
	 * Widnow object
	 * 
	 * @param window - a Window object
	 */
	public PointManager(Window window){
		this.window = window;
		width = window.getWidth();
		height = window.getHeight();
		random = new Random();
		pointCalculator = new PointCalculator(controls, renders);
		init();
	}
	
	/**
	 * Initializes the point lists
	 */
	private void init(){
		controls = new LinkedList<>();
		lines = new LinkedList<>();
		renders = new LinkedList<>();
		
		for (int i = 0; i < INITIAL_CONTROLS; i++){
			double x = random.nextDouble()*width;
			double y = random.nextDouble()*height;
			
			ControlPoint c = new ControlPoint(x,y, this);
			controls.add(c);
			
			if (i != 0){
				ControlPoint prev = controls.get(i-1);
				Line line = new Line(c.getCenterX(), c.getCenterY(),
									 prev.getCenterX(), prev.getCenterY());
				line.setStroke(Color.YELLOW);
				lines.add(line);
			}
		}
		
		for (Line l : lines){
			window.addChild(l);
		}
		
		for (ControlPoint p : controls){
			window.addChild(p);
		}
		
		for (int i = 0; i < INITIAL_RENDERS; i++){
			RenderPoint render = new RenderPoint();
			renders.add(render);
		}
		
		pointCalculator.calculatePoints();
	}
	
	/**
	 * Recalculates all of the relative RenderPoint and line positions
	 */
	public void recalculate(){
		for (int i = 0; i < controls.size()-1; i++){
			ControlPoint current = controls.get(i);
			ControlPoint next = controls.get(i+1);
			
			Line line  = lines.get(i);
			
			line.setStartX(current.getCenterX());
			line.setStartY(current.getCenterY());
			line.setEndX(next.getCenterX());
			line.setEndY(next.getCenterY());
		}
		
		pointCalculator.calculatePoints();
	}
}
