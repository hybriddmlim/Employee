package webapp.test;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import webapp.escape.Background;
import webapp.escape.Screen;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DateTest {
	static Log log = LogFactory.getLog(DateTest.class);
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void test1() {
		Date current = new Date();
//		log.info(current);
		log.info(current.toLocaleString());
		
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test2() {
		Calendar current = Calendar.getInstance();
		
		log.info(current.getTime().toLocaleString());
		
	}
	
	@Test
	public void test3() {
		Date current = new Date();
		
		current.setDate(current.getDate() + 1);//오늘 날짜에 하루를 더해서 내일을 만든것
		
		log.info("year = " + (current.getYear() + 1900));
		log.info("month = " + (current.getMonth() + 1));
		log.info("date = " + current.getDate());
		log.info("week = " + current.getDay());//일요일은 0 월요일은 1 화요일은 2 이런식이다.

	}
	
	@Test
	public void test4() {
		Date date = new Date(2015 - 1900, 3-1, 1);//3월 1일 표시
		
		log.info("start week = " + date.getDay());//0 이 나옴 일요일이기 때문에
		
		
		
		int month = date.getMonth();
		while(true) {
			date.setDate(date.getDate() + 1);
			if (month != date.getMonth())
				break;
		}
		
		date.setDate(date.getDate() - 1);
		
		log.info("end week = " + date.getDay());
		log.info("end date = " + date.getDate());
		
		
		log.info(date.toLocaleString());
		
		
		
	}
	
	@Test//원하는 달을 설정하면 1일부터 마지막 일까지 출력하는 것
	public void test5() {
		Date date = new Date();
		
		date.setMonth(3-1);
		date.setDate(1);
		
		log.info(date.toLocaleString());
		
		
		while(true) {
			
			System.out.print("[ "+date.getDate()+" ]");
			
			date.setDate(date.getDate()+1);
			
			if(date.getDay()==0)
				System.out.println();
			
			if(date.getDate() == 1)
				break;
	
		}
		
		System.out.println();
		
	}
	
	@Test
	public void test6() {
		Screen.clear();
		
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			Screen.cursorPosition(5, 1);
			System.out.print("[yyyy/MM] : ");
			
			String param = scan.next();
		
			if(param.equals(".")) break;
			
			System.out.println("param = " + param);
		}
		
		
//		Screen.reset();
	}

		
	
	
	
}
