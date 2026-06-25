/**
 * 基本課題3.3 Task33
 * @author 221205015 伊藤優希
 */
import java.util.Scanner;

public class Task33 {

	public static void main(String[] args) {
		Picalculator piCalc = new Picalculator();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("演算回数を入力> ");
		int numberOfTimes = scanner.nextInt();
		piCalc.setNum(numberOfTimes);
		
		System.out.printf("演算回数%dで円周率を演算開始...",piCalc.getNum());
		piCalc.calcPI();
		System.out.print("  演算終了\n");
		
		System.out.println("処理時間 = " + piCalc.getProcessingTime() +  "ms");
		System.out.println("演算結果 = " + piCalc.getplotPI());
		System.out.println("誤　　　差 = " + piCalc.getgapFromTrueValue());
		
		scanner.close();
	}
}
