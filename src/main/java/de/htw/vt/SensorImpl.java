package de.htw.vt;

import java.rmi.RemoteException;
import java.util.*;

public class SensorImpl extends java.rmi.server.UnicastRemoteObject implements Sensor {

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
    List<SensorObserver> observers;
    

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
        try {
            this.setValue(r.nextInt(201));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.setX((rangeMin + (rangeMax - rangeMin) * r.nextDouble()));
        this.setY((rangeMin + (rangeMax - rangeMin) * r.nextDouble()));
    }

    private void setX(Double x) {
        this.x = x;
    }

    private void setY(Double y) {
        this.y = y;
    }

    public void setValue(int value) throws RemoteException {
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

    public void register(SensorObserver o) throws RemoteException {
        if(!observers.contains(o)) {
            this.observers.add(o);
            System.out.println("register(SensorObserver in Sensor): " + o.toString());
        }
    }

    public void unregister(SensorObserver o) throws RemoteException {
        this.observers.remove(o);
    }

    //method to notify observers of change
    public void notifyObservers() throws RemoteException {

    }

    public void changeValue() throws RemoteException {
        Random r = new Random();
        try {
            this.setValue(r.nextInt(201));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        valueChanged = true;
        if (valueChanged) {
            System.out.println(observers.size());
            if (observers.size() > 0) {
                for (SensorObserver observer : observers) {
                    observer.update(this.value);
                }
            }
            System.out.println("new value: " + this.value +
                    "\n sensor id: " + this.id);
            valueChanged = false;
        }
    }

    @Override
    public String toString() {
        return "In SensorImpl: toString() \n"
                + "Longitude: " + this.getX() + "\nLatitude: " + this.getY()
                + "\nValue: " + this.getValue() + " dB";
    }

    public String writeToConsole() {
        return "In SensorImpl: toString() \n"
                + "Longitude: " + this.getX() + "\nLatitude: " + this.getY()
                + "\nValue: " + this.getValue() + " dB";
    }
}

