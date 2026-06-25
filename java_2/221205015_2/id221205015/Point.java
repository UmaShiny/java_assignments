package id221205015;

import java.util.Scanner;

public class Point{
	public int x;
	public int y;
	
	//このインスタンスで得られる座標のペアを(x,y)とする．
	
	public int getX() {
		//座標のxを取得
		return x;
	}
	
	public void setX(String x) {
		//入力された座標xを field x に格納
		int Xx = Integer.parseInt(x);
		this.x = Xx;
	}
	
	public int getY() {
		//座標のyを取得
		return y;
	}
	
	public void setY(String y) {
		//入力された座標yを field y に格納
		int Yy = Integer.parseInt(y);
		this.y = Yy;
	}
	
	public String toString() {
		//情報を一元的に文章化
		String string = "(" + x + "," + y + ")";
		return string;
	}
	
	public int[] getXY() {
		//座標配列XYを取得
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] strArray = input.split(" ");
		setXY(strArray);
		int[] intArray = {getX(),getY()};
		scanner.close();
		return intArray;
	}
	
	public void setXY(String[] strArray) {
		//座標XYを setX setY を経由して格納
		setX(strArray[0]);
		setY(strArray[1]);
	}
	
	public double getDistance(int[] args, int[] intArray) {
		//座標を原点(0,0)から(x,y)と(X,Y)の距離の絶対値差を計算
		double z = Math.pow(args[0] - intArray[0], 2) + Math.pow(args[1] - intArray[1], 2);
		return Math.sqrt(z);
	}
	
	public double getDistance() {
		//原点からの距離
		double z = Math.pow(getX(), 2) + Math.pow(getY(), 2);
		return Math.sqrt(z);
	}
}