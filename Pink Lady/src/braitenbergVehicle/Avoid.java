package braitenbergVehicle;

import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.subsumption.Behavior;

public class Avoid implements Behavior {
	
	private boolean suppressed = false;
	
	private EV3ColorSensor colLeft;
	private EV3ColorSensor colRight;

	public Avoid(EV3ColorSensor colLeft, EV3ColorSensor colRight) {
		this.colLeft = colLeft;
		this.colRight = colRight;
	}

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void action() {
		SensorMode lightLeft = colLeft.getRedMode();
		SensorMode lightRight = colRight.getRedMode();
		
		float[] leftSamples = new float[lightLeft.sampleSize()];
		float[] rightSamples = new float[lightRight.sampleSize()];
		
		
		while(!suppressed){
			
			lightLeft.fetchSample(leftSamples, 0);
			lightRight.fetchSample(rightSamples, 0);
			
			float left = leftSamples[0]*100;
			float right = rightSamples[0]*100;
			
			Motor.B.setSpeed(left);
			Motor.A.setSpeed(right);
			
			Motor.B.forward();
			Motor.A.forward();
			
		}

	}

	@Override
	public void suppress() {
		this.suppressed = true;

	}

}
