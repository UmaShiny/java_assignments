/**
 * 基本課題　5.2 Task52
 * @author 221205015 伊藤優希
 */
import java.io.*;
import java.util.IllegalFormatException;

public class Task52 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		int[] PNG_key = new int[16];
		int[] SENCE_key = new int[4];
		int key = 0;
		try {
			fis = new FileInputStream(args[0]);
			bis = new BufferedInputStream(fis);
			for(int i = 0; i < 8; i++) {
				key = bis.read();
				PNG_key[i] = key;
			}
			String str = String.format("%02X%02X%02X%02X%02X%02X%02X%02X",PNG_key[0],PNG_key[1],PNG_key[2],PNG_key[3],PNG_key[4],PNG_key[5],PNG_key[6],PNG_key[7]);
			if (!(str.equals("89504E470D0A1A0A"))) throw new Exception();
			while(key != -1) {
				//System.out.println("whileに入りました");
				key = bis.read();
				SENCE_key[0] = SENCE_key[1];
				SENCE_key[1] = SENCE_key[2];
				SENCE_key[2] = SENCE_key[3];
				SENCE_key[3] = key;
				String senceIHDR  = String.format("%02X%02X%02X%02X",SENCE_key[0],SENCE_key[1],SENCE_key[2],SENCE_key[3]);
				if(!(senceIHDR.equals("49484452"))) continue;
				else {
					int vertical = size(bis);
					int horizontal = size(bis);
					System.out.printf("Width = %d pixel, Height = %d pixel",vertical,horizontal);
					break;
				}
			}
		}catch(IllegalFormatException e){
			System.out.println("エラーが発生しました．次の原因が考えられます．");
			System.out.println("＊不正な配列へのアクセスが発生しました．");			
		}catch(IOException e) {
			System.out.println("エラーが発生しました．次の原因が考えられます．");
			System.out.printf("＊拡張子(.png)が適切ではない\n...%s\n",args[0]);
			System.out.println("＊ファイルが存在しないか，正しく配置されていない");
		}catch(Exception e) {
			System.out.println("エラーが発生しました．次の原因が考えられます．");
			System.out.printf("＊拡張子(.png)が適切ではない\n...%s\n",args[0]);
			System.out.println("＊ファイルが存在しないか，正しく配置されていない");
			System.out.println("＊バイナリファイルのヘッダ情報が正しく読まれていない");
			System.out.println("＊想定されていないエラーの発生");
		}finally {
			try {
				bis.close();
			} catch (IOException e) {
				System.out.println("ファイルのクローズ中にエラーが発生しました");
			}finally {
				System.exit(1);
			}
		}
	}
	public static int size(BufferedInputStream bis) throws IOException, IllegalFormatException { 
		int[] size = new int[4];
		for(int i = 0; i < 4; i++) size[i] = bis.read();
		String strBinary  = String.format("%02X%02X%02X%02X",size[0],size[1],size[2],size[3]);
		int length = Integer.parseInt(strBinary,16);
		return length;
	}
}
