package Motor;

import java.util.ArrayList;

import data.Plane;
import data.Position;
import dataEnum.FlightStatus;
public class Fly {
	Plane plane;
	public Fly(Plane plane) {
		this.plane=plane;
	}
	
	public void run() {
		ArrayList<Position> trajectory=new ArrayList<>();
		trajectory=plane.getFlight().getTrajectory();
		if(trajectory!=null) {
			for (Position pos : trajectory) {
				plane.setPosition(pos);
				plane.setFuel();
				if(plane.getFuel()<200 && !plane.getStatuts().equals(FlightStatus.EMERGENCY_LANDING)) {
					Main.controller.emergencyLanding(plane);
					System.out.println("emergency landing !!!");
					break;
				}
				try {
					Thread.sleep((long) (70000/plane.getSpeed()));
				} catch (InterruptedException e) {}
			}
		}		
	}
}
