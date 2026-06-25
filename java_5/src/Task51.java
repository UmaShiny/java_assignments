/**
 * 基本課題　5.1 Task51
 * @author 221205015 伊藤優希
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task51 {

	public static void main(String[] args){
		try {
			if(Integer.parseInt(args[2]) > 12 || Integer.parseInt(args[2]) < 0) throw new NumberFormatException();
			if(Integer.parseInt(args[1]) != 2021 ) throw new NumberFormatException();
		}catch(NumberFormatException e){
			System.out.printf("年月の入力が不適切 / データが存在しません．\n>> %s年%s月．",args[1],args[2]);
			System.out.println("申し訳ありませんが，再度実行をお願い致します．");
			System.exit(1);
		}
		BufferedReader br = null;
		BufferedWriter bw = null;
		FileReader fr = null;
		FileWriter fw = null;
		try {
			String outputFileName = args[0].split("\\.")[0] +"_"+ args[1] +"_"+ args[2] + ".csv";
			fr = new FileReader(args[0]);
			fw = new FileWriter(outputFileName);
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			String str;
			WeatherData[] weatherSet = new WeatherData[32];
			bw.write("年月日,平均気温(℃),最高気温(℃),最低気温(℃),降水量の合計(mm),日照時間(時間)\r\n");
			int count = 0;
			while((str = br.readLine()) != null) {
				if(str.contains("年月日")) continue;
				if(Integer.parseInt(str.split(",")[0].split("/")[1]) == Integer.parseInt(args[2])) {
					String[] data = str.split(",");
					WeatherData A = new WeatherData(Integer.parseInt(data[0].split("/")[0]),Integer.parseInt(data[0].split("/")[1]),Integer.parseInt(data[0].split("/")[2]),Double.parseDouble(data[1]),Double.parseDouble(data[2]),Double.parseDouble(data[3]),Double.parseDouble(data[4]),Double.parseDouble(data[5]));
					weatherSet[count] = A;
					count++;
					bw.write(A.toString() + "\r\n");
				}else continue;
				bw.flush();
				for(int d_count = 0; count + d_count < 32; d_count++) weatherSet[count + d_count] = new WeatherData(0,0,0,0,0,1000,0,0);
			}
			WeatherData.setmonthlyRainfall(Totalrainfall(weatherSet));
			WeatherData.setmonthlyHoursOfDaylight(Totalhourofdaylight(weatherSet));
			WeatherData.setmonthlyMaxTemperature(MaxTemperature(weatherSet));
			WeatherData.setmonthlyMinTemperature(MinTemperature(weatherSet));
			WeatherData.showMonthlySummary();
		}catch(NullPointerException e){
			System.out.println("エラーが発生しました．参照先がNULLだった可能性があります．");
		}catch(FileNotFoundException e) {
			System.out.println("エラーが発生しました．以下の原因が考えられます．");
			System.out.printf("＊ファイル名%sが存在しないか，正しく配置されていない＊．",args[0]);			
		}catch(IOException e) {
			System.out.println("エラーが発生しました．以下の原因が考えられます．");
			System.out.println("＊書き込みに必要な条件が満たされていない．");
		}catch(NumberFormatException e) {
			System.out.println("エラーが発生しました．以下の原因が考えられます．");
			System.out.printf("＊ファイル名%sにおいて，想定された書式フォーマットが採用されていない＊",args[0]);	
			System.out.printf("＊ファイル名%sにおいて，数値を半角数字で表現されていない＊．",args[0]);	
		}
		catch(Exception e) {
			System.out.println("深刻なエラーが発生しました.");
			System.out.println(e);
		}finally {
			//close
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				System.exit(1);			
			}
		}
	}public static double Totalrainfall(WeatherData[] weatherSet) {
		double addRainfall = 0;
		for(int j = 0; j < weatherSet.length; j++) addRainfall = addRainfall + weatherSet[j].getrainfall();
		return addRainfall;
	}public static double Totalhourofdaylight(WeatherData[] weatherSet) {
		double addHoursOfDaylight = 0;
		for(int j = 0; j < weatherSet.length; j++) addHoursOfDaylight = addHoursOfDaylight + weatherSet[j].gethoursOfDaylight();
		return addHoursOfDaylight;
	}public static double MaxTemperature(WeatherData[] weatherSet) {
		double MaxTemperature = 0.0;
		for(int j = 0; j < weatherSet.length; j++) if(weatherSet[j].getrainfall() > MaxTemperature) MaxTemperature = weatherSet[j].getmaxTemperature();
		return MaxTemperature;
	}public static double MinTemperature(WeatherData[] weatherSet) {
		double MinTemperature = 1000;
		for(int j = 0; j < weatherSet.length; j++) if(MinTemperature > weatherSet[j].getminTemperature()) MinTemperature = weatherSet[j].getminTemperature();
		return MinTemperature;
	}
}
