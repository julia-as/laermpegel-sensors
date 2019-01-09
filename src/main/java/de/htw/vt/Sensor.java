package de.htw.vt;

import javafx.beans.Observable;

import java.util.Observer;


public interface Sensor {

    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers();
    void update(Sensor s, int value);
    void setValue(int value);

}

/*
nicht jdk observable sonders anderes
eigene observable klasse schreiben, die remote implementiert
observable muss unicast remote object sein
 */
