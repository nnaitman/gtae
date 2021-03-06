package data;

/*
 * The trajectory is a list of 2D points that a plane takes during a flight
 * These 2D points are generated by a method: calculateTrajetory() 
 */

import java.util.ArrayList;

public class Trajectory {
	
	private ArrayList<Position> points; 
	private int altitude;
	private Position source;
	private Position destination;
	public Trajectory(Position source, Position destination) {
		this.source = source;
		this.destination = destination;
		points=new ArrayList<>();
		calculateTrajectory();
	}
		
	public ArrayList<Position> getTrajectory(){
		return points;
	}
	public void setPoints (ArrayList<Position> points) {
		this.points = points;
	}

	public void setAltitude (int altitude) {
		this.altitude = altitude;
	}
	
	
	public int getAltitude() {
		return this.altitude;
	}
	
	/*
	 * This method takes as parameters the position of the source airport 
	 * and the position of the destination airport and calculates the distance
	 * between these two airports. This distance is a "double" type.
	 */
	
	public double distance(){
		Position sourcePosition =  this.source;
		Position destinationPosition = this.destination;		
		double dx = (sourcePosition.getX() - destinationPosition.getX());
		double dy = (sourcePosition.getY() - destinationPosition.getY());
		double distance = Math.sqrt(dx*dx + dy*dy);
		return distance;
		
	}
	

	/*
	 * This method calculates randomly positions: 2D points.
	 */
	public void calculateTrajectory() {
		// TODO Auto-generated method stub
		int xA, xB, yA, yB ,x, y;
		double distance=distance();
		xA = this.source.getX();
		yA = this.source.getY();		
		xB = this.destination.getX();
		yB = this.destination.getY();
		for(int i=0;i<distance;i++) {
			x=(int) (xA+(xB-xA)*(i/distance));
			y=(int) (yA+(yB-yA)*(i/distance));
			points.add(new Position(x, y));
			
		}
		
		
		
		
	}
	
	
}

