/**
 * 基本課題5.1 気象データクラス雛型
 * カプセル化されるようにアクセス修飾子およびstatic修飾子を各自で適切に設定すること
 */
public class WeatherData {
	/** 年 */
	private int year;
	/** 月 */
	private int month;
	/** 日 */
	private int date;
	/** 平均気温 */
	private double averageTemperature;
	/** 最高気温 */
	private double maxTemperature;
	/** 最低気温 */
	private double minTemperature;
	/** 降水量の合計 */
	private double rainfall;
	/** 日照時間 */
	private double hoursOfDaylight;
	
	/** 月間最高温度 */
	private static double monthlyMaxTemperature;
	/** 月間最低温度 */
	private static double monthlyMinTemperature;
	/** 月間降水量（合計） */
	private static double monthlyRainfall;
	/** 月間日照時間（合計） */
	private static double monthlyHoursOfDaylight;
	
	/**
	 * 指定値で初期化するコンストラクタ
	 * @param year	年
	 * @param month	月
	 * @param date	日
	 * @param averageTemperature	平均気温
	 * @param maxTemperature		最大気温
	 * @param minTemperature		最低気温
	 * @param rainfall				降水量
	 * @param hoursOfDaylight		日照時間
	 */
	
	public double getrainfall() {
		return rainfall;
	}
	public double gethoursOfDaylight() {
		return hoursOfDaylight;
	}
	public double getmaxTemperature() {
		return maxTemperature;
	}
	public double getminTemperature() {
		return minTemperature;
	}
	public WeatherData(int year, int month, int date, double averageTemperature, double maxTemperature,
			double minTemperature, double rainfall, double hoursOfDaylight) {
		this.year = year;
		this.month = month;
		this.date = date;
		this.averageTemperature = averageTemperature;
		this.maxTemperature = maxTemperature;
		this.minTemperature = minTemperature;
		this.rainfall = rainfall;
		this.hoursOfDaylight = hoursOfDaylight;
	}
	public static void setmonthlyMaxTemperature(double monthlyMaxTemperature) {
		WeatherData.monthlyMaxTemperature = monthlyMaxTemperature;
	}
	public static void setmonthlyMinTemperature(double monthlyMinTemperature) {
		WeatherData.monthlyMinTemperature = monthlyMinTemperature;
	}
	public static void setmonthlyRainfall(double monthlyRainfall) {
		WeatherData.monthlyRainfall = monthlyRainfall;
	}
	public static void setmonthlyHoursOfDaylight(double monthlyHoursOfDaylight) {
		WeatherData.monthlyHoursOfDaylight = monthlyHoursOfDaylight;
	}
	
	
	/**
	 * 気象データをCSV形式（コンマ区切り）の文字列として出力するメソッド
	 * @return 気象データ（日付,平均気温,最高気温,最低気温,降水量,日照時間）
	 */
	@Override
	public String toString() {
		return String.format("%d/%d%d,%f,%f,%f,%f,%f", this.year, this.month, this.date,
				this.averageTemperature, this.maxTemperature, this.minTemperature,
				this.rainfall, this.hoursOfDaylight);
	}

	/**
	 * 月間の気象情報を出力するメソッド
	 * ※メソッドのアクセス修飾子は変更しないこと
	 */
	public static void showMonthlySummary() {
		System.out.println(" * 月間最高気温 = " + monthlyMaxTemperature + "℃");
		System.out.println(" * 月間最低気温 = " + monthlyMinTemperature + "℃");
		System.out.println(" * 月間降水量合計 = " + monthlyRainfall + "mm");
		System.out.println(" * 月間日照時間合計 = " + monthlyHoursOfDaylight + "時間");
	}
}
