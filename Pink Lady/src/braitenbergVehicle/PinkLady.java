package braitenbergVehicle;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.subsumption.Behavior;

public class PinkLady {

	public static void main(String[] args) {
		Port port1 = LocalEV3.get().getPort("S1");
		Port port2 = LocalEV3.get().getPort("S2");
		
		EV3ColorSensor colLeft = new EV3ColorSensor(port1);
		EV3ColorSensor colRight = new EV3ColorSensor(port2);
		
		Behavior avoid = new Avoid(colLeft, colRight);
		
		Behavior[] behaviors = {avoid};

	}

}
