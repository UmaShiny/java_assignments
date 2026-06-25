/**
 * 基本課題4.1　Pointクラス
 * @author ---
 */
public class Point {
	protected double x;
	protected double y;
	
	public Point() {
		setX(0.0);
		setY(0.0);
	}
	
	public Point(double x, double y) {
		setX(x);
		setY(y);
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void translate(double dx, double dy) {
		this.x += dx;
		this.y += dy;
	}
	
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
}
