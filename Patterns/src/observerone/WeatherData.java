package observerone;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements ISubject{

	private Integer temperature;
	private Integer humidity;
	private Integer pressure;
	private List<IObserver> observers;
	
	public WeatherData() {
	this.observers= new ArrayList<>();
	}
	
	@Override
	public void registrer(IObserver observer) {		
		this.observers.add(observer);
	}

	@Override
	public void remove(IObserver observer) {
		int i=this.observers.indexOf(observer);
		if(i>0)
			this.observers.remove(i);
	}


	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			IObserver observer = (IObserver)observers.get(i);
			observer.update(temperature, humidity, pressure);
			}
		
	}
	public Integer getTemperature() {
		return temperature;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public Integer getPreasure() {
		return pressure;
	}
	
	public void measurementsChanged(){
		notifyObservers();
	}
	

	public void setMeasuremnts(Integer temperature,Integer humidity,Integer preasure){
		this.temperature=temperature;
		this.humidity=humidity;
		this.pressure=preasure;
		measurementsChanged();
	}


}
