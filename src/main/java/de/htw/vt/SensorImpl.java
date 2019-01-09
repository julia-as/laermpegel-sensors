package de.htw.vt;

import java.rmi.RemoteException;
import java.util.*;

public class SensorImpl extends java.rmi.server.UnicastRemoteObject implements Sensor, Observer {

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
    private boolean valueChanged = false;
    List<Observer> observers;
    

    public SensorImpl() throws RemoteException {
        super();
        this.observers = new ArrayList<>();
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
    void setData() {
        this.id = UUID.randomUUID();
        Random r = new Random();
        this.setValue(r.nextInt(201));
        this.setX((rangeMin + (rangeMax - rangeMin) * r.nextDouble()));
        this.setY((rangeMin + (rangeMax - rangeMin) * r.nextDouble()));
    }

    @Override
    public String toString() {
    	return "In SensorImpl: getSensor() \n"
				+ "Longitude: " + this.getX() + "\nLatitude: " + this.getY()
				+ "\nValue: " + this.getValue() + " dB";
//         this;
    }

//    public Map<UUID, SensorImpl> createInstance(int numberOfSensors) throws RemoteException {
//        //   SensorImpl sensorModelImpl = new SensorImpl();
//        Map<UUID, SensorImpl> sensors = new HashMap<>();
//        for (int i = 0; i <= numberOfSensors; i++) {
//            SensorImpl sensor = new SensorImpl();
//            sensors.put(sensor.id, sensor);
//            System.out.println("createInstance() in SensorImpl: " + id.toString() + getX() + getY() + getValue());
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

    private Double getX() {
        return x;
    }

    private Double getY() {
        return y;
    }

    private int getValue() {
        return value;
    }

    public void register(Observer obj) {
        if(!observers.contains(obj)) {
            this.observers.add(obj);
        }
    }

    public void unregister(Observer obj) {

        this.observers.remove(obj);
    }

    //method to notify observers of change
    public void notifyObservers() {

    }

    //method to update the observer, used by subject
    public void update(MyObservable o, Object arg) {
        notifyObservers();
    }

    //method to get updates from subject
    public Object getUpdate(Observer obj) {
        return null;
    }

    void changeValue() {
        Random r = new Random();
        this.setValue(r.nextInt(201));
        valueChanged = true;
        if (valueChanged) {
            update(this, this.getValue());
            valueChanged = false;
        }
    }
}

