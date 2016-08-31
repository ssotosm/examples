package observertwo;

import java.util.Observable;
import java.util.Observer;

public class StadisticsDisplay implements  Observer,IDisplay{
	private Integer temperature;
	private Integer humidity;
	private Integer pressure;
	Observable observable;


	@Override
	public void display() {
		System.out.println("Stadistics display :" + temperature
				+ "º degrees and " + humidity + "% humidity " + pressure + " preassure");
	}


	public StadisticsDisplay(Observable observable) {
		this.observable=observable;
		observable.addObserver(this);
		
	}


	@Override
	public void update(Observable o, Object arg) {
		
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			this.pressure=weatherData.getPreasure();
			display();
		}

	}
}
