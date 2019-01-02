package de.htw.vt;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.List;
import java.util.Observable;

public class App extends Observable {

    List<Observable> observers;

    public App(int numberOfInstances) {

        try {
            LocateRegistry.createRegistry(1099);
            while (true) {
                //for (int i = 0; i <= numberOfInstances; i++) {
                    // SensorService service = new SensorServiceImpl(numberOfInstances);
                    SensorModelImpl sensor = new SensorModelImpl();
                  //  String url = "rmi://localhost:1099/sensors/" + i;
                    String url = "rmi://localhost:1099/sensors/";
                    System.out.println("rmi url: " + url);
                    Naming.rebind(url, sensor);
               // }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        // int i = args[0];
        new App(3);
    }



}
