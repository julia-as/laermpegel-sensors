package de.htw.vt;


import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Sensor extends Remote {

    void register(SensorObserver o) throws RemoteException;
    void unregister(SensorObserver o) throws RemoteException;
    void notifyObservers() throws RemoteException;
    void setValue(int value) throws RemoteException;
    void changeValue() throws RemoteException;
    String writeToConsole() throws RemoteException;
    Double getX() throws RemoteException;
    Double getY() throws RemoteException;
    int getId() throws RemoteException;
    void setId(int id) throws RemoteException;
    int getValue() throws RemoteException;
}

/*
nicht jdk observable sonders anderes
eigene observable klasse schreiben, die remote implementiert
observable muss unicast remote object sein
 */
