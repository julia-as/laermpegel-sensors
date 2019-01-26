package de.htw.vt;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {

	private Map<Integer, Sensor> sensors = new HashMap<>();;
	ScheduledExecutorService scheduler;
	

	public App(int numberOfInstances) {

		scheduler = Executors.newScheduledThreadPool(numberOfInstances);
		try {
			LocateRegistry.createRegistry(1099);

				for (int i = 0; i <= numberOfInstances; i++) {

					final Sensor sensor = new SensorImpl();
					sensor.setId(i);
					sensors.put(i, sensor);

					final String url = "rmi://localhost:1099/sensors/" + i;
					System.out.println("rmi url sensor: " + url);
					Naming.rebind(url, sensor);

					final Runnable task = new Runnable() {
						public void run() {
							try {
								sensor.changeValue();
							}
							catch (RemoteException e) {
								e.printStackTrace();
							}
						}
					};
					scheduler.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);
				}
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		// int i = args[0];
		new App(3);
	}

}
