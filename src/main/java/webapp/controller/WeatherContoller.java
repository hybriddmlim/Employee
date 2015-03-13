package webapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import webapp.model.weather.Weather;
import webapp.service.WeatherService;

@Controller
@RequestMapping("/weather")
public class WeatherContoller {
	static Log log = LogFactory.getLog(WeatherContoller.class);
	
	@Autowired //필드주입 하나만 가능하다. 
	WeatherService service;
	
	@RequestMapping(value={"","/"},method=RequestMethod.GET)//두가지로 맵핑 가능 http://localhost:8080/Employee/desktop/weather/ 또는 http://localhost:8080/Employee/desktop/weather 둘다 가능
	public String showForm() {
		log.info("###################");
		log.info("### ShowForm()");
		log.info("###################");
		
		return "weather/form";
	}
	
	@RequestMapping(value="/show", method=RequestMethod.POST)
	public String showWeather(Model model, String city) {//파라미터의 이름과 똑같이 하면 받는다
		log.info("###################");
		log.info("### showWeather()");
		log.info("###################");
		log.info("city = " + city);
		
		Weather weather = service.getWeather(city);

		model.addAttribute("weather", weather);

		
		
		return "weather/weather";
	}
}
