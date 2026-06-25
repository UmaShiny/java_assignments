package jp.ac.meijo_u.id221205015;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class Task8_GUIController extends Thread {
	@FXML private Button ButtonGo;
	@FXML private TextField Path;
	@FXML private TextArea PlotArea;
	@FXML private ProgressBar pgr;
	
	@FXML public void fileOpenAction(ActionEvent evevt) {
		ChooserThread thread_Chooser = new ChooserThread();
		thread_Chooser.setPath(Path);
		thread_Chooser.setArea(PlotArea);
		thread_Chooser.setGage(pgr);
		thread_Chooser.run();
	}
	
	@FXML protected void handleButtonClickAction(ActionEvent event) {
		//ConvertToASCIIThread thread_ToASCII = new ConvertToASCIIThread();
		//thread_ToASCII.setPath(Path);
		//thread_ToASCII.setArea(PlotArea);
		//thread_ToASCII.setGage(pgr);
		
		
		new Thread() {
			public void run() {
				String dir = Path.getText();
				PlotArea.setText(dir + "を確認中\n");
				
				int[] HEX = new int[32];
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				String len = "";
				
				try {
					
					fis = new FileInputStream(dir);		// ファイル入力バイトストリーム
					bis = new BufferedInputStream(fis);		// 入力用バッファ
					
					PlotArea.setText(dir + "の内容:\n");
					int ch = 0 ,j = 0, count = 0;
		// バイナリファイルからまとめて入力用バッファ読み込み，入力用バッファから1バイト読み込み
					while ((ch = bis.read()) != -1) {
						//System.out.println(ch);
						HEX[j] = ch;
						count++;
						if(j % 15 == 0 && j != 0) {
							len += String.format("%08x  ",count);
							for(int p = 0; p < 16; p++) {
								len += String.format("%02x ",HEX[p]);
								if(p == 7) {
									len += "   ";
								}
							}
							len += "   | ";
							for(int q = 0; q < 16; q++) {
								if(31<HEX[q] && HEX[q]<127) {
									len += String.format("%c ",HEX[q]);
								}else {
									len += ". ";
								}
							}
							len += "|\n";
							PlotArea.appendText(len);
							len = "";
							Thread.sleep(50);
							j = 0;
						}else {
							j++;
						}
					}
					len = "";
					//ラス１行
					//PlotArea.appendText(String.format("%08x  ",count));
					len += String.format("%08x  ",count);
					for(int n = 0; n < j; n++) {
						//PlotArea.appendText(String.format("%02x ",HEX[n]));
						len += String.format("%02x ",HEX[n]);
						if(n == 7) {
							//PlotArea.appendText("   ");
							len += "   ";
						}
					}
					for(; j < 16; j++ ) {
						//PlotArea.appendText("   ");
						len += "   ";
						HEX[j] = 0xffffffff;
					}
					//PlotArea.appendText("   | ");
					len += "   | ";
					
					for(int n = 0; n < j; n++) {
						if(31<HEX[n] && HEX[n]<127) {
							//PlotArea.appendText(String.format("%c ",HEX[n]));
							len += String.format("%c ",HEX[n]);
						}else if(HEX[n] == 0xffffffff) {
							//PlotArea.appendText("  ");
							len += "  ";
							
						}else {
							//PlotArea.appendText(". ");
							len += ". ";
						}
					}
					//PlotArea.appendText("|\n");
					len += "|\n";
					PlotArea.appendText(len);
					pgr.setProgress(1);
					len = "";
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					if(bis != null) {
						try {
							bis.close();
						}catch(IOException e) {}
					}
				}
			}
		}.start();
		
		/*
		ConvertToASCIIThread converttoasciithread = new ConvertToASCIIThread();
		converttoasciithread.start();
		*/
		
		new Thread() {
			@Override
			public void run() {
				float progress = 0;
                while( progress < 90 ) {
 
                    // 進捗を更新
                    progress += 5;
                    pgr.setProgress(progress / 100);
 
                    // 1秒スリープ
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
			}
		}.start();
		
		//thread_ToASCII.start();
		/*
		try {
			thread_ToASCII.join();
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		*/
		
		System.out.println("表示の終了");
	}
}