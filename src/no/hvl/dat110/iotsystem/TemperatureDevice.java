package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;
		
		public static void main(String[] args) {

			// simulated / virtual temperature sensor
			TemperatureSensor sn = new TemperatureSensor();

			// TODO - start
			
			String user = "sensor";
			
			// create a client object and use it to
			//user, server, port
			Client sensor = new Client(user, Common.BROKERHOST, Common.BROKERPORT);
			
			// - connect to the broker - user "sensor" as the user name
			
			sensor.connect();
			
			// - publish the temperature(s)
			

			for (int i = 0; i < COUNT; i++) {

				sensor.publish(Common.TEMPTOPIC, sn.read() + "");
			
			}
			
			
			// - disconnect from the broker

			sensor.disconnect();
			
			// TODO - end

		System.out.println("Temperature device stopping ... ");


	}
}
