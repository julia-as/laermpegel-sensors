package de.htw.vt;

import javafx.beans.Observable;


public interface Sensor  {

    void register(MyObservable o);
    void unregister(MyObservable o);
    void notifyObservers();


}

/*
nicht jdk observable sonders anderes
eigene observable klasse schreiben, die remote implementiert
observable muss unicast remote object sein
 */
