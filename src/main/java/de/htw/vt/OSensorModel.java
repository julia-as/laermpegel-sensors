package de.htw.vt;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class OSensorModel implements Observer {
	
	 List<Observer> observers;
	 SensorModelImpl sensor;
	
	 //TODO: change values every x second for each sensor
    for (Observer ob : this.observers) {
    	sensor.setData();
//    	sensor.
        ob.notifyObservers(sensor.getSensor());
    }
    
    
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	

	 public void addObserver(Observer obj) {
	        this.observers.add(obj);
	    }
	 
	    public void removeObserver(Observer obj) {
	        this.observers.remove(obj);
	    }
}

}
