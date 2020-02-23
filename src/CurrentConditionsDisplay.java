import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	Observable observable;
	private float temperature;
	private float humidity;

	public CurrentConditionsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable observer, Object arguments) {
		WeatherData weatherData = (WeatherData)observer;
		this.temperature = weatherData.getTemperature();
		this.humidity = weatherData.getHumidity();
		display();
	}
	
	public void display() {
		System.out.println("Current conditions : " + temperature + "F degrees and " + humidity + " %humidity");
	}
}
