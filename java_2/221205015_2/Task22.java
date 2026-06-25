/** 
 * 基本課題2.2　動作確認クラス
 * @author 210441xxx　情報太郎
 */
import id221205015.Point;

public class Task22 {

	/**
	 * メインメソッド
	 * @param args	X座標とY座標
	 */
	public static void main(String[] args) {
		
		// 点P1を作成してコマンドライン引数で指定した座標を設定
		Point point1 = new Point();
		point1.setX(args[0]);
		point1.setY(args[1]);
		int[] intArgs = {point1.getX(), point1.getY()};
		System.out.printf("点P1%sを生成しました．\n",point1.toString());
		
		// 点P1に関する情報の表示
		System.out.printf("X座標=%d Y座標=%d\n",point1.x, point1.y);
		
		// 原点とP1間の距離を表示
		double distance_1 = point1.getDistance();
		System.out.printf("原点からP1までの距離=%f\n",distance_1);
		
		// 点P2を作成してキーボードで指定した座標を設定
		System.out.printf("P2の座標を入力してください> ");
		Point point2 = new Point();
		int[] intArray = point2.getXY();
		System.out.printf("X座標=%d Y座標=%d\n",point2.x, point2.y);
		
		// P1-P2間の距離を表示
		double distance_2 = point2.getDistance(intArgs,intArray);;
		System.out.printf("P1からP2までの距離=%f",distance_2);
		
	}

}
