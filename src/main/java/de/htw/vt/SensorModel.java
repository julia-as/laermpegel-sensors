package de.htw.vt;

public interface SensorModel extends java.rmi.Remote {

    String getSensor() throws java.rmi.RemoteException;

}
