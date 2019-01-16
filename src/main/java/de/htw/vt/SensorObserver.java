package de.htw.vt;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SensorObserver extends Remote {

    void update(int value) throws RemoteException;

}
