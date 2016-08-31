package observertwo;

import java.util.Observable;

public class WeatherData extends Observable {

	private Integer temperature;
	private Integer humidity;
	private Integer pressure;

	
	public WeatherData() {
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
		setChanged();
		notifyObservers();
	}	

	public void setMeasuremnts(Integer temperature,Integer humidity,Integer preasure){
		this.temperature=temperature;
		this.humidity=humidity;
		this.pressure=preasure;
		measurementsChanged();
	}



}
