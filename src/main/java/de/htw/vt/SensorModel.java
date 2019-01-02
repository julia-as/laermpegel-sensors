package de.htw.vt;

public interface SensorModel<Observable> extends java.rmi.Remote {

    String getSensor() throws java.rmi.RemoteException;

}
