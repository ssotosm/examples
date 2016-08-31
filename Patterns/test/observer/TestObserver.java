package observer;

import observerone.CurrentConditionsDisplay;
import observerone.StadisticsDisplay;
import observerone.WeatherData;

import org.junit.Test;


public class TestObserver {

	@Test
	public void testObserverFirst(){
		System.out.println("FIRST OBSERVER");
		
		WeatherData weatherData= new WeatherData();
		
		new CurrentConditionsDisplay(weatherData);
		new StadisticsDisplay(weatherData);
		
		weatherData.setMeasuremnts(80,65,30);
		weatherData.setMeasuremnts(82,70,29);
		
		System.out.println();
		
	}
	

	@Test
	public void testObserverSecond(){
		System.out.println("SECOND OBSERVER USING OBSERVER/OBSERVABLE");
		
		observertwo.WeatherData weatherData= new observertwo.WeatherData();
		
		new observertwo.CurrentConditionsDisplay(weatherData);
		new observertwo.StadisticsDisplay(weatherData);
		
		weatherData.setMeasuremnts(80,65,30);
		weatherData.setMeasuremnts(82,70,29);
		
		System.out.println();
	}
}
