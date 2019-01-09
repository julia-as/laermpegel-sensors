package de.htw.vt;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {

	//    List<Observer> observers;
	private Map<Integer, SensorImpl> sensors = new HashMap<>();;
	ScheduledExecutorService scheduler;
	

	public App(int numberOfInstances) {

		scheduler = Executors.newScheduledThreadPool(numberOfInstances);
		try {
			LocateRegistry.createRegistry(1099);

			//while (true) {

				for (int i = 0; i <= numberOfInstances; i++) {

					final SensorImpl sensor = new SensorImpl();
					sensors.put(i, sensor);
					final String url = "rmi://localhost:1099/sensors/" + i;
					System.out.println("rmi url: " + url);
					Naming.rebind(url, sensor);
					
					final Runnable task = new Runnable() {
						public void run() {
							sensor.changeValue();
						}
					};
					scheduler.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);
				}
			//}
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Do nothing");
		}
	}


	public static void main(String args[]) {
		// int i = args[0];
		new App(3);
	}

}
