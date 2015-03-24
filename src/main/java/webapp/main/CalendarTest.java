package webapp.main;

import java.sql.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

import webapp.escape.Screen;

public class CalendarTest {
	
	public static void printCalendar(int year, int month) {
		Screen.cursorPosition(3, 5);
//		System.out.println("year= "+ year + ", month = " + month);
		
		Date date = new Date(year-1900, month-1, 1);
		
		
		System.out.println(date.toLocaleString());
		
		System.out.println("\t" +year + " " + month);
		System.out.println("=====================");
		
		for(int i=0; i<date.getDay(); i++) {
			System.out.print("   ");
		}
		
		while(true) {
			
			if(10>date.getDate()){
			System.out.print("0"+date.getDate() + " ");
			}else{
			System.out.print(date.getDate() + " ");
			}
			
			date.setDate(date.getDate()+1);
			
			if(date.getDate()==1)
				break;
			
			if(date.getDay()==0)
				System.out.println();
						
		}
		
		
		
	}
	public static void main(String[] args) {
		
		Screen.clear();
		
		Scanner scan = new Scanner(System.in);
		
		
		while(true) {
			
			
			
			boolean flag=true;
			String param="";
			do{
				flag=true;
				Screen.cursorPosition(20, 1);
				System.out.print("[yyyy/MM] : ");
				param = scan.nextLine();
				Screen.clear();
				System.out.println("param=" + param);
				
//				flag=param.matches("[1-9][0-9][0-9][0-9]/[0-9][0-9]");//첫자리는 1부터9 사이의 숫자가 올수있다. 두번째는 0부터 9까지
				flag=param.matches("[1-9][0-9]{3}/[0-1][0-9]");//위에랑 똑같은 표현이지만 단축한것 [0-9]가 3자리 라는 의미
				
				
			} while(!flag);
				
			StringTokenizer tokens = new StringTokenizer(param,"/");
			
			int year= Integer.parseInt((String)tokens.nextElement());
			int month =Integer.parseInt((String)tokens.nextElement());
			
			if(month > 0 && month < 13 )
				printCalendar(year, month);
		}
		
	}

}
