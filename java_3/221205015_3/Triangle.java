/**
 * 基本課題3.2　Triangleクラス
 * @author 221205015 伊藤　優希
 */


//import java.util.Scanner;

public class Triangle{
	public double x;
	public double y;
	
	public Triangle() {
		//指定なし原点設定
		x = 0;
		y = 0;
	}
	
	public Triangle(double in_x, double in_y) {
		//指定で座標設定
		this.x = in_x;
		this.y = in_y;
	}
	
	public double getX() {
		//座標のxを取得
		return x;
	}
	
	public void setX(double x) {
		//入力された座標xを field x に格納
		//int Xx = Integer.parseInt(x);
		this.x = x;
	}
	
	public double getY() {
		//座標のyを取得
		return y;
	}
	
	public void setY(double y) {
		//入力された座標yを field y に格納
		//int Yy = Integer.parseInt(y);
		this.y = y;
	}
	
	public void setLocation(double x, double y) {
		setX(x);
		setY(y);
	}
	
	public void move(double x, double y) {
		setX(x);
		setY(y);
	}
	
	public void tlanslate(double dx, double dy) {
		setX(x + dx);
		setY(y + dy);
	}
	
	public String toString() {
		//情報を一元的に文章化
		String string = "(" + x + ", " + y + ")";
		return string;
	}
	
	public double getDistance() {
		//原点からの距離
		double z = Math.pow(getX(), 2) + Math.pow(getY(), 2);
		double distance =  Math.sqrt(z);
		return distance;
	}	
	
	public double getDistance(double x, double y) {
		//座標を原点(0,0)から(x,y)と(X,Y)の距離の絶対値差を計算
		double z = Math.pow(x, 2) + Math.pow(y, 2);
		double distance =  Math.sqrt(z);
		return distance;
	}
	
	public double getDistance(Point p) {
		//原点からの距離
		double z = Math.pow(p.x - getX(), 2) + Math.pow(p.y - getY(), 2);
		double distance =  Math.sqrt(z);
		return distance;
	}	
	
	public double getDistance(Point p1, Point p2) {
		//座標を原点(0,0)から(x,y)と(X,Y)の距離の絶対値差を計算
		double z = Math.pow(p1.getX()-p2.getX(), 2) + Math.pow(p1.getY()-p2.getY(), 2);
		double distance =  Math.sqrt(z);
		return distance;
	}
	
}