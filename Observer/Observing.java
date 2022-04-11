import java.util.Observable;
import java.util.Observer;
class Observing {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();

		CurrentConditionsDisplay curDisplay = new CurrentConditionsDisplay(weatherData);
		weatherData.setMeasurements(80, 65, 30.4);
	}
}

class WeatherData extends Observable {
	private double temp;
	private double humidity;
	private double pressure;

	public void setMeasurements(double temp, double humidity, double pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		setChanged();
		notifyObservers();
	}

	public double getTemp() {
		return this.temp;
	}

	public double getHumidity() {
		return this.humidity;
	}

	public double getPressure() {
		return this.pressure;
	}
}

interface DisplayElement {
	public void display();
}

class CurrentConditionsDisplay implements Observer, DisplayElement {
	private double temp;
	private double humidity;
	private Observable weatherData;

	public CurrentConditionsDisplay(Observable weatherData) {
		this.weatherData = weatherData;
		weatherData.addObserver(this);
	}

	public void update(Observable o, Object arg) {
		this.temp = ((WeatherData) o).getTemp();
		this.humidity = ((WeatherData) o).getHumidity();
		display();
	}

	public void display() {
		System.out.println(temp + " " + humidity);
	}
}