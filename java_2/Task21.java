import java.util.Scanner;

public class Task21 {
	
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Day day = new Day();
		System.out.println("年月日を入力してください");
		int y = day.getYear();
		int m = day.getMonth();
		int d = day.getDate();
		day.setYear(y);
		day.setMonth(m);
		day.setDate(d);
		System.out.println(day.toString() + "は，" + day.getDayOfWeek() + "です.");
	}
}