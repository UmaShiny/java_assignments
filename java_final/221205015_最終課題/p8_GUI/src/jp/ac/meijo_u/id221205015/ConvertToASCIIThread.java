package jp.ac.meijo_u.id221205015;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.fxml.FXML;
//import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ConvertToASCIIThread extends Thread{
	//@FXML private Button ButtonGo;
	@FXML private TextField Path;
	@FXML private TextArea PlotArea;
	@FXML private ProgressBar pgr;

	public void setPath(TextField Path) {
		this.Path = Path;
	}
	
	public void setArea(TextArea PlotArea) {
		this.PlotArea = PlotArea;
	}
	
	public void setGage(ProgressBar pgr) {
		this.pgr = pgr;
	}
	
	
	@Override
	public void run() {
		
		String dir = Path.getText();
		PlotArea.setText(dir + "を確認中\n");
		
		int[] HEX = new int[32];
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		try {
			fis = new FileInputStream(dir);		// ファイル入力バイトストリーム
			bis = new BufferedInputStream(fis);		// 入力用バッファ
			
			PlotArea.setText(dir + "の内容:\n");
			int ch = 0 ,j = 0, count = 0;
// バイナリファイルからまとめて入力用バッファ読み込み，入力用バッファから1バイト読み込み
			while ((ch = bis.read()) != -1) {
				System.out.println(ch);
				HEX[j] = ch;
				count++;
				if(j % 15 == 0 && j != 0) {
					//Thread.sleep(10);
					PlotArea.appendText(String.format("%08x  ",count));
					
					for(int p = 0; p < 16; p++) {
						PlotArea.appendText(String.format("%02x ",HEX[p]));
						if(p == 7) {
							PlotArea.appendText("   ");
						}
					}
					PlotArea.appendText("   | ");
					for(int q = 0; q < 16; q++) {
						if(31<HEX[q] && HEX[q]<127) {
							PlotArea.appendText(String.format("%c ",HEX[q]));
						}else {
							PlotArea.appendText(". ");
						}
					}
					PlotArea.appendText("|\n");
					//Thread.sleep(1000);
					j = 0;
				}else {
					j++;
				}
			}
//16行ずつの読み込みは終了，以下に端数分の読み上げ処理
			
//最後の一行は，whileとは別途で表示させる端数分の読み上げ処理を行う．
			PlotArea.appendText(String.format("%08x  ",count));
			for(int n = 0; n < j; n++) {
				PlotArea.appendText(String.format("%02x ",HEX[n]));
				if(n == 7) {
					PlotArea.appendText("   ");
				}
			}
			for(; j < 16; j++ ) {
				PlotArea.appendText("   ");
				HEX[j] = 0xffffffff;
			}
			PlotArea.appendText("   | ");
			
			for(int n = 0; n < j; n++) {
				if(31<HEX[n] && HEX[n]<127) {
					PlotArea.appendText(String.format("%c ",HEX[n]));
				}else if(HEX[n] == 0xffffffff) {
					PlotArea.appendText("  ");
				}else {
					PlotArea.appendText(". ");
				}
			}
			PlotArea.appendText("|\n");
//最後の一行の表示を終了．
			
		} catch (FileNotFoundException e) {
			PlotArea.appendText("ファイル" + dir + "が見つかりません．");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {}
			}
		}
	}
}