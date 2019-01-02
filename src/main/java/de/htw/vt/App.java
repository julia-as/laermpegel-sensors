package de.htw.vt;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class App extends Observable {

//    List<Observer> observers;
    SensorModelImpl sensor;

    public App(int numberOfInstances) {

        try {
            LocateRegistry.createRegistry(1099);
            while (true) {
                for (int i = 0; i <= numberOfInstances; i++) {
                    sensor = new SensorModelImpl();
                    String url = "rmi://localhost:1099/sensors/" + i;
                    System.out.println("rmi url: " + url);
                    Naming.rebind(url, sensor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        // int i = args[0];
        new App(3);
    }

//    public void addObserver(Observable obj) {
//        this.observers.add(obj);
//    }
// 
//    public void removeObserver(Observable obj) {
//        this.observers.remove(obj);
//    }
//

}
