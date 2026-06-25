/**
 * 基本課題1.2 メインクラス
 * @author 221205015 伊藤優希
 */
package p1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

//数値入力のエラーをcatchする為のクラス宣言
class Integer_catch{
	int Integer;
	void Integer_Exception_Catch(int Integer) {
		if(!(0 <= Integer && Integer < 3)) {
			throw new IllegalArgumentException();
		}
		this.Integer = Integer;
	}
}

public class Task12 {
	//メインの関数
	public static void main(String[] args) {
		System.out.println("### じゃんゲーム ###\nじゃんけん");
		Value_Input();
	}
	
	//数値を入力する関数
	private static void Value_Input() {
		System.out.println("(0:グー 1:チョキ 2:パー )>");
		int r = 0;
		Scanner Hand = new Scanner(System.in);
		try {
			r = Hand.nextInt();
			Output_View(r,Hand);
		}
		catch(InputMismatchException e) {
			System.out.println("EXCEPTION WAS OCCURS!");
			System.out.println("ERROR-TYPE IS <CHARACTER-MISS>");
			Hand.nextLine();
			Value_Input();
		}catch(IllegalArgumentException e) {
			System.out.println("A EXCEPTION WAS OCCURS!");
			System.out.println("THE ERROR-TYPE IS <NUMBER-MISS>");
			Hand.nextLine();
			Value_Input();
		}catch(Exception e) {
			System.out.println("A EXCEPTION WAS OCCURS!");
			System.out.println("THE ERROR-TYPE IS <TYPING-MISS>");
			Hand.nextLine();
			Value_Input();
		}
	}
	
	//結果を表示する関数
	private static void Output_View(int r, Scanner Hand) {
		String H_Key[] = {"「グー」","「チョキ」","「パー」"};
		int[] box = Judge_Game(r);
		int Comp = box[2];
		int s = box[1];
		switch(Comp) {
		case 0:System.out.println("あなた：" + H_Key[r] + "\n相手：" + H_Key[s]+"\n...あいこ");
			Value_Input();
			break;
		case 1:System.out.println("あなた：" + H_Key[r] + "\n相手：" + H_Key[s]+"\n...勝ち");
			Hand.close();
			break;
		case 2:System.out.println("あなた：" + H_Key[r] + "\n相手：" + H_Key[s]+"\n...負け");
			Hand.close();
			break;
		default:
			System.out.println("A EXCEPTION WAS OCCURS!");
			System.out.println("THE ERROR-TYPE IS <UNEXPECTED-MISS>");
		}
	}

	//勝敗を決定する要素を生成する関数
	private static int[] Judge_Game(int r) {
		Integer_catch i = new Integer_catch();
		i.Integer_Exception_Catch(r);
		int box[] = {0,0,0};
		int Comp = 0;
		Random Robot_Hand = new Random();
		int s = Robot_Hand.nextInt(3);
		if(s-r < 0) {Comp = s-r+3;}
		else {Comp = s-r;}
		Comp = Comp % 3;
		box[0] = r;
		box[1] = s;
		box[2] = Comp;
		return box;
	}
}