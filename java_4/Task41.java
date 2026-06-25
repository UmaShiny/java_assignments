import java.util.Scanner;
/**
 * 基本課題4.1　Task41
 * @author 221205015 伊藤　優希
 */

/**
 * 3次元空間上の点を扱う基本課題4.1
 */
public class Task41 {

	public static void main(String[] args) {
		// 原点に点P1を生成
		Point p1 = new Point3D();
		
		System.out.println("点P1" + p1.toString() + "を生成しました．");
		
		// キーボードで指定した座標に点P2を生成
		Scanner scanner = new Scanner(System.in);
		System.out.print("点P2の座標を入力して下さい[x y z]: ");
		double p2_Coordinate_x = scanner.nextDouble();
		double p2_Coordinate_y = scanner.nextDouble();
		double p2_Coordinate_z = scanner.nextDouble();
		Point3D p2 = new Point3D(p2_Coordinate_x, p2_Coordinate_y, p2_Coordinate_z);
		
		System.out.println("点P2" + p2.toString() + "を生成しました．");

		// キーボードで点P2の移動量を入力して移動させる
		System.out.print("点P2の移動量を入力して下さい[dx dy dz]: ");
		double p2_Momentum_x = scanner.nextDouble();
		double p2_Momentum_y = scanner.nextDouble();
		double p2_Momentum_z = scanner.nextDouble();
		p2.tlanslate(p2_Momentum_x, p2_Momentum_y, p2_Momentum_z);

		System.out.println("移動後の点P2の座標 = " + p2.toString());
		scanner.close();
	}

}
