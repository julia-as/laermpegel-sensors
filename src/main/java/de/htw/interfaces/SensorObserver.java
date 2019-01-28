package de.htw.interfaces;

import de.htw.interfaces.Sensor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SensorObserver extends Remote {

    void update(Sensor sensor, int value) throws RemoteException;

}
