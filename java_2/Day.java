

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Day{
	public int year;
	public int month;
	public int date;
	//method
	public int getYear() {
		year = Task21.scanner.nextInt();
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getMonth() {
		month = Task21.scanner.nextInt();
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getDate() {
		date = Task21.scanner.nextInt();
		Task21.scanner.close();
		return date;
	}
	
	public void setDate(int date) {
		this.date = date;
	}
	
	public String getDayOfWeek() {
		String[] dayOfWeek = {"日曜日","月曜日","火曜日","水曜日","木曜日","金曜日","土曜日",};
		int h = (year + (year/4) - (year/100) + (year/400) + ((13*month +8)/5) + date) % 7;
		return dayOfWeek[h];
	}
	
	public String toString() {
		Calendar c = new GregorianCalendar(year, month-1, date);
		String sentence = String.format("%1$tY年%1$tm月%1$te日",c);
		return sentence;
	}
}