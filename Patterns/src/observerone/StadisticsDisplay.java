package observerone;

public class StadisticsDisplay implements IObserver,IDisplay{
	private Integer temperature;
	private Integer humidity;
	private Integer pressure;
	private ISubject weatherData;

	public StadisticsDisplay(ISubject weatherData) {
		this.weatherData = weatherData;
		this.weatherData.registrer(this);
	}

	@Override
	public void update(Integer temperature, Integer humidity, Integer pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure=pressure;
		display();
	}

	@Override
	public void display() {
		System.out.println("Stadistics display :" + temperature
				+ "º degrees and " + humidity + "% humidity" + pressure + " preassure");
	}

}
