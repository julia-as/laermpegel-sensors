//package de.htw.vt;
//
//import java.rmi.RemoteException;
//import java.util.*;
//
//public class SensorServiceImpl extends java.rmi.server.UnicastRemoteObject implements SensorService, Observer {
//
//    Map<UUID, SensorModelImpl> sensors = new HashMap<>();
//
//
//    public SensorServiceImpl(int numberOfSensors) throws java.rmi.RemoteException {
//        super();
//        SensorModelImpl sensor = new SensorModelImpl();
//        sensors = sensor.createInstance(numberOfSensors);
//        //getSensors(numberOfSensors);
//    }
//
//
//    public Map<UUID, SensorModelImpl> getSensors(int numberOfSensors) throws RemoteException {
////                for (int i = 0; i <= numberOfSensors; i++) {
////                    SensorModelImpl sensor = new SensorModelImpl();
////                    createInstance();
////                    sensors.put(SensorModelImpl);
////                }
//        SensorModelImpl sensor = new SensorModelImpl();
//        Map<UUID, SensorModelImpl> sensors = sensor.createInstance(numberOfSensors);
//        return sensors;
//    }
//
//    @Override
//    public void update(Observable o, Object arg) {
//
//    }
//}
