package de.htw.vt;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RemoteObject;
import java.rmi.server.ServerNotActiveException;
import java.util.*;

public class SensorModelImpl extends java.rmi.server.UnicastRemoteObject implements SensorModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8185498752647882345L;
	
	protected UUID id;
    // Longitude
    private Double x;
    // Latitude
    private Double y;
    private Double rangeMin = 0.0;
    private Double rangeMax = 300.0;
    // Value is the current noise level
    private int value;


    public SensorModelImpl() throws RemoteException {
        super();
        this.setData();
    }

    /*decimal  degrees  distance
      places
    -------------------------------
    0        1.0        111 km
    1        0.1        11.1 km
    2        0.01       1.11 km
    3        0.001      111 m
    4        0.0001     11.1 m
    5        0.00001    1.11 m
    6        0.000001   0.111 m
    7        0.0000001  1.11 cm
    8        0.00000001 1.11 mm*/
    private void setData() {
        this.id = UUID.randomUUID();
        Random r = new Random();
        this.setValue(r.nextInt(201));
        this.setX((rangeMin + (rangeMax - rangeMin) * r.nextDouble()));
        this.setY((rangeMin + (rangeMax - rangeMin) * r.nextDouble()));
    }

    public String getSensor() {
    	return "In SensorModelImpl: getSensor() \n"
				+ "Longitude: " + this.getX() + "\nLatitude: " + this.getY()
				+ "\nValue: " + this.getValue() + " dB";
//        System.out.println("In SensorModelImpl: getSensor() \n "
//				+ "Longitude: " + this.getX() + "\nLatitude: " + this.getY());
//		return this;
    }

//    public Map<UUID, SensorModelImpl> createInstance(int numberOfSensors) throws RemoteException {
//        //   SensorModelImpl sensorModelImpl = new SensorModelImpl();
//        Map<UUID, SensorModelImpl> sensors = new HashMap<>();
//        for (int i = 0; i <= numberOfSensors; i++) {
//            SensorModelImpl sensor = new SensorModelImpl();
//            sensors.put(sensor.id, sensor);
//            System.out.println("createInstance() in SensorModelImpl: " + id.toString() + getX() + getY() + getValue());
//        }
//        return sensors;
//    }

    private void setX(Double x) {
        this.x = x;
    }

    private void setY(Double y) {
        this.y = y;
    }

    private void setValue(int value) {
        this.value = value;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public int getValue() {
        return value;
    }
}

