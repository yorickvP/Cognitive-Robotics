package braitenbergVehicle;

import lejos.robotics.subsumption.Behavior;

public class Aggression implements Behavior {
	
	private boolean supressed = false;

	public Aggression() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void action() {
		while(!supressed){
			
			
		}

	}

	@Override
	public void suppress() {
		this.supressed = true;

	}

}
