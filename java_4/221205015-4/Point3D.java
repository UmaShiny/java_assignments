/**
 * 基本課題4.1　Point3Dクラス
 * @author 221205015 伊藤　優希
 */


public class Point3D extends Point{
	public double z;
	
	public Point3D() {
		super(0,0);
		this.z = 0;
	}
	
	public Point3D(double x, double y, double z) {
		super(x,y);
		this.z = z;
	}
	
	public double getZ() {
		//座標のxを取得
		return z;
	}
	
	public void setZ(double z) {
		//入力された座標xを field x に格納
		this.z = z;
	}
	
	public void tlanslate(double dx, double dy, double dz) {
		super.setX(x + dx);
		super.setY(y + dy);
		this.setZ(z + dz);
	}
	
	@Override
	public String toString() {
		//情報を一元的に文章化
		String string = "(" + super.x + ", " + super.y + ", " + this.z + ")";
		return string;
	}
}