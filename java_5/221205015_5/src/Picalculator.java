/**
 * 基本課題3.3 Picalculatorクラス
 * @author 221205015 伊藤優希
 */
import java.util.Random;

public class Picalculator {
	
	private static final Random random = new Random();
	
	private static int inOfSector;
	private static final double realPI = Math.PI;
	private static double plotPI;
	private static int calclationNumberOfTimes;
	private static double gapFromTrueValue;
	private static double processingTime;
	
	//演算の試行回数を返す関数
	public static int getNum(){
		return calclationNumberOfTimes;
	}
	
	//引き数をフィールドに試行回数として格納する関数
	public static void setNum(int calclationNumberOfTimes) {
		Picalculator.calclationNumberOfTimes = calclationNumberOfTimes;
	}
	
	//扇形の中にある座標の数を返す関数
	public static int getSect(){
		return inOfSector;
	}
	
	//π 演算して求めた結果を返す関数
	public static double getplotPI(){
		return plotPI;
	}
	
	//引き数をフィールドに演算して求めた π として格納する関数
	public static void setplotPI(double plotPI) {
		Picalculator.plotPI = plotPI;
	}
	
	//π を返す関数
	public static double getRealPI(){
		return realPI;
	}
	
	//演算に要した処理時間を返す関数
	public static int getProcessingTime(){
		return (int) processingTime;
	}
	
	//引き数をフィールドに演算して求めた π として格納する関数
	public static void setProcessingTime(double deltaT) {
		Picalculator.processingTime = (int) deltaT;
	}
	
	//実際のπと演算で求めたπの差を求めて格納する関数
	public static double getgapFromTrueValue() {
		return gapFromTrueValue;
	}
	
	//実際のπと演算で求めたπの差を求めて格納する関数
	public static void setgapFromTrueValue() {
		double gap = realPI - plotPI;
		gapFromTrueValue = gap;
	}
	
	//座標判定を行い，因子factorが１以下だった場合inOfSectorが１ずつ加算される関数
	public static void judge() {
		double x = random.nextDouble();
		double y = random.nextDouble();
		double factor = Math.pow(x, 2) + Math.pow(y, 2);
		if(factor <= 1) {
			inOfSector = inOfSector + 1;
		}
	}
	
	//実際に計算する関数
	public static void calcPI() {
		long startT = System.currentTimeMillis();
		for(int i = 0; i < getNum(); i++) {
			judge();
		}
		long stopT = System.currentTimeMillis();
		double deltaT = stopT - startT;
		setProcessingTime(deltaT);
		double plotPI = (double) inOfSector * 4.0 / (double) calclationNumberOfTimes;
		setplotPI(plotPI);
		setgapFromTrueValue();
	}
}