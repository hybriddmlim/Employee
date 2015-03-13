package webapp.model.weather;

import java.util.List;

public class Weather {

	Current current;
	List<Forecast> forecasts;
	
	
	public Current getCurrent() {
		return current;
	}
	public void setCurrent(Current current) {
		this.current = current;
	}
	
	public List<Forecast> getForecasts() {
		return forecasts;
	}
	public void setForecasts(List<Forecast> forecasts) {
		this.forecasts = forecasts;
	}

	
	
}
