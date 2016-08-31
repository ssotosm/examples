package observerone;

public class CurrentConditionsDisplay implements IObserver, IDisplay {

	private Integer temperature;
	private Integer humidity;
//	private Integer pressure;
	private ISubject weatherData;

	public CurrentConditionsDisplay(ISubject weatherData) {
		this.weatherData = weatherData;
		this.weatherData.registrer(this);
	}

	@Override
	public void update(Integer temperature, Integer humidity, Integer pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}

	@Override
	public void display() {
		System.out.println("Current conditions display :" + temperature
				+ "º degrees and " + humidity + "% humidity");
	}

}
