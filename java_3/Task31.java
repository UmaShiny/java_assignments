/**
 * 基本課題3.1 Task31
 * @author 221205015 伊藤優希
 */

import java.util.Scanner;

public class Task31 {

	public static void main(String[] args) {
		//点P1を生成
		Point point1 = new Point();
		System.out.printf("点P1%sを生成しました．\n",point1.toString());
		//入力ストリームを宣言
		Scanner scanner = new Scanner(System.in);
		
		//点P2の座標を入力
		System.out.print("点P2の座標を入力してください[x y]:");
		double x = scanner.nextDouble();
		double y = scanner.nextDouble();
		
		//点P2を生成し，引き数に座標を指定
		Point point2 = new Point(x,y);
		System.out.printf("点P2%sを生成しました．\n",point2.toString());
		
		//原点から点P2の距離を出力
		double d1 = point2.getDistance();
		System.out.printf("P1とP2の間の距離d1 = %f\n",d1);
		
		//点P1の移動先の座標を入力
		System.out.print("点P1の移動先座標を入力してください[x y]:");
		double mx = scanner.nextDouble();
		double my = scanner.nextDouble();
		
		//点P1を移動させる
		point1.move(mx, my);
		System.out.printf("移動後の点P1の座標d1 = %s\n",point1.toString());
		
		//点P1と点P2の間の距離を表示
		double d2= point2.getDistance(point1);
		System.out.printf("P1とP2の間の距離d2 = %f\n",d2);
		
		//点P3を移動させる数字を入力
		System.out.printf("点P2の移動量を入力してください[dx dy]:");
		double dx = scanner.nextDouble();
		double dy = scanner.nextDouble();
		
		//点P2を移動させる
		point2.tlanslate(dx, dy);
		System.out.printf("移動後の点P2の座標 = %s",point2.toString());
		
		//点P1と点P2の間の距離を表示
		double d3 = point2.getDistance(point1,point2);
		System.out.printf("P1とP2の間の距離d1 = %f\n",d3);
		
		//原点から点P2の距離を出力
		double d4 = point2.getDistance();
		System.out.printf("原点とP2の間の距離d4 = %f\n",d4);
		scanner.close();
	}

}
