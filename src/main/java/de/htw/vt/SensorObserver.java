package de.htw.vt;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SensorObserver extends Remote {

    void update(Sensor sensor, int value) throws RemoteException;

}
