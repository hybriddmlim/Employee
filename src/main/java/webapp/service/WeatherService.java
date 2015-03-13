package webapp.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.stereotype.Service;

import webapp.exception.JDOMRuntimeException;
import webapp.exception.URLRuntimeException;
import webapp.model.weather.Current;
import webapp.model.weather.Forecast;
import webapp.model.weather.Weather;

@Service
public class WeatherService {
	static Log log = LogFactory.getLog(WeatherService.class);
	String url = "http://weather.service.msn.com/data.aspx?culture=ko-KR&weasearchstr=";
	SAXBuilder jdom = new SAXBuilder();
	
	
	
	Current getCurrent(Element current) {
		Current c = new Current();
		
		c.setTemperature(Integer.parseInt(current.getAttributeValue("temperature")));
		c.setSkycode(current.getAttributeValue("skycode"));
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			c.setDate(df.parse(current.getAttributeValue("date")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		c.setObservationtime(current.getAttributeValue("observationtime"));
		c.setObservationpoint(current.getAttributeValue("observationpoint"));
		c.setFeelslike(current.getAttributeValue("feelslike"));
		c.setHumidity(current.getAttributeValue("humidity"));
		c.setWinddisplay(current.getAttributeValue("winddisplay"));
		c.setDay(current.getAttributeValue("day"));
		c.setShortday(current.getAttributeValue("shortday"));
		c.setWindspeed(current.getAttributeValue("windspeed"));
		
		return c;

	}
	
	
	
	List<Forecast> getForecasts(Element weather) {
		List<Forecast> list = new ArrayList<Forecast>();
		List<Element> ws = weather.getChildren("forecast");
//		Integer low;
//		Integer high;
//		String skycodeday;
//		String skytextday;
//		Date date;
//		String day;
//		String shortday;
//		Integer precip;
		for (Element e : ws) {
			Forecast f = new Forecast();
			f.setLow(Integer.parseInt(e.getAttributeValue("low")));
			f.setHigh(Integer.parseInt(e.getAttributeValue("high")));
			f.setSkycodeday(e.getAttributeValue("skycodeday"));
			f.setSkytextday(e.getAttributeValue("skytextday"));
			
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				f.setDate(df.parse(e.getAttributeValue("date")));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			f.setDay(e.getAttributeValue("day"));
			f.setShortday(e.getAttributeValue("shortday"));
			f.setPrecip(Integer.parseInt(e.getAttributeValue("precip")));

			list.add(f);
		}
		
		
		return list;
	}
	
	
	
	public Weather getWeather(String city) {
		log.info("############################");
		log.info("#########getWeather#########");
		log.info("############################");
		
		String urlcity = url + city;
		Weather w=null;
		try {
			URL u = new URL(urlcity);
			InputStream in = u.openStream();
			Document doc = jdom.build(in);
			Element weatherdata = doc.getRootElement();
			Element weather = weatherdata.getChild("weather");
			Element current = weather.getChild("current");
			
			
			w = new Weather();
			Current c = getCurrent(current);
			List<Forecast> forecasts = getForecasts(weather);
			
			
			w.setCurrent(c);
			w.setForecasts(forecasts);
			
			
			log.info("skeytext = " +  current.getAttributeValue("skytext"));
			log.info("Date= " + c.getDate());
			
			XMLOutputter output = new XMLOutputter();
			output.setFormat(Format.getPrettyFormat());
			output.output(doc, System.out);
			
		} catch (IOException e) {
			throw new URLRuntimeException(urlcity, e);
		} catch (JDOMException e) {
			throw new JDOMRuntimeException("Build error", e);
		}
		
		return w;
	}
}
