/**
 * 基本課題3.2 Task32
 * @author 221205015 伊藤優希
 */

import java.util.Scanner;

public class Task32 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		double X1 = Double.valueOf(args[0]) ;
		double Y1 = Double.valueOf(args[1]) ;
		
		double X2 = Double.valueOf(args[2]) ;
		double Y2 = Double.valueOf(args[3]) ;
		
		double X3 = Double.valueOf(args[4]) ;
		double Y3 = Double.valueOf(args[5]) ;
		
		Triangle tri_1 = new Triangle(X1,Y1);
		Triangle tri_2 = new Triangle(X2,Y2);
		Triangle tri_3 = new Triangle(X3,Y3);
		
		System.out.printf("三角形の頂点座標：　A%s, B%s, C%s\n", tri_1.toString(),tri_2.toString(),tri_3.toString());
		
		System.out.printf("三角形の移動量を入力してください　[dx dy]:");
		
		double dx = scanner.nextDouble();
		double dy = scanner.nextDouble();
		
		tri_1.tlanslate(dx, dy);
		tri_2.tlanslate(dx, dy);
		tri_3.tlanslate(dx, dy);
		
		System.out.printf("三角形の頂点座標：　A%s, B%s, C%s\n", tri_1.toString(),tri_2.toString(),tri_3.toString());
		scanner.close();
	}
}