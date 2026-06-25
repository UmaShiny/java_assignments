import java.io.*;

public class Task8_CLI {

	public static void main(String[] args) {

		int[] HEX = new int[32];
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			
			fis = new FileInputStream(args[0]);		// ファイル入力バイトストリーム
			bis = new BufferedInputStream(fis);		// 入力用バッファ
			
			int ch, j = 0, count = 0;
// バイナリファイルからまとめて入力用バッファ読み込み，入力用バッファから1バイト読み込み
			while ((ch = bis.read()) != -1) {
				if(count % 255 == 0 && count != 0) {
					PressAnyKey();
				}
				HEX[j] = ch;
				count++;
				if(j % 15 == 0 && j != 0) {
					
					System.out.printf("%08x   ",count);
					
					for(int p = 0; p < 16; p++) {
						System.out.printf("%02x ",HEX[p]);
						if(p == 7) {
							System.out.print("   ");
						}
					}
					
					System.out.print("   | ");
					
					for(int q = 0; q < 16; q++) {
						if(31<HEX[q] && HEX[q]<127) {
							System.out.printf("%c ",HEX[q]);
						}else {
							System.out.print(". ");
						}
					}
					System.out.print("|\n");
					j = 0;
					continue;
				}else {
					j++;
				}
			}
//16行ずつの読み込みは終了，以下に端数分の読み上げ処理
			
//最後の一行は，whileとは別途で表示させる端数分の読み上げ処理を行う．
			System.out.printf("%08x   ",count);
			for(int n = 0; n < j; n++) {
				System.out.printf("%02x ",HEX[n]);
				if(n == 7) {
					System.out.print("   ");
				}
			}
			for(; j < 16; j++ ) {
				System.out.print("   ");
				HEX[j] = 0xffffffff;
			}
			
			System.out.print("   | ");
			
			for(int n = 0; n < j; n++) {
				if(31<HEX[n] && HEX[n]<127) {
					System.out.printf("%c ",HEX[n]);
				}else if(HEX[n] == 0xffffffff) {
					System.out.print("  ");
				}else {
					System.out.print(". ");
				}
			}
			System.out.print("|\n");
//最後の一行の表示を終了．
			
		} catch (FileNotFoundException e) {
			System.out.println("ファイル" + args[0] + "が見つかりません．");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			/*
			 * BufferedInputStreamとBufferedOutputStreamをクローズ
			 * （連結されているFileInputStream，FileOutputStreamも同時にクローズされる）
			 */
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {}
			}
		}
	}
	
	public static void PressAnyKey() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Press \"Enter\" key...");
		try {
			input.readLine();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
