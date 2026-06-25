
/**
 * 基本課題6.1 Task61Controller
 * @author 221205015 伊藤優希
 */


package jp.ac.meijo_u.id_221205015;

import java.io.*;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert.AlertType;
import jp.ac.meijo_u.id_221205015.Task61Controller.SampleAlertController;

public class Task61Controller {
	@FXML private TextField pathtext;
	@FXML private TextArea content;
	@FXML private Button buttonSave;
	@FXML private Button buttonLoad;
	@FXML private Label labelCount;
	
	@FXML protected void reader() {
		SampleAlertController sampleAlertController = new SampleAlertController();
		String path = pathtext.getText();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(path);	// ファイル入力文字ストリーム
			br = new BufferedReader(fr);	// 入力用バッファ
			String text = "";
			String str;
			// ファイルからまとめて入力用バッファ読み込み，入力用バッファから1行読み込み
			while ((str = br.readLine()) != null) {
				text += str + "\r\n";	// 改行コードを付け加える
			}
			content.setText(text);
			//System.out.println(path + "の内容:");
			//System.out.println(text);
			String Message = path + "に保存しました";
			sampleAlertController.handleButtonConfirmationAction(Message);
		} catch (FileNotFoundException e) {
			//System.out.println("ファイル" + path + "が見つかりません．");
			String Message = path + "が見つかりませんでした";
			sampleAlertController.handleButtonErrorAction(Message);
			System.exit(1);
		} catch (IOException e) {
			//e.printStackTrace();
			String Message = path + "にアクセス拒否されました";
			sampleAlertController.handleButtonWarningAction(Message);
		} finally {
			/*
			 * BufferedReaderストリームをクローズ
			 * （連結されているFileReaderストリームも同時にクローズされる）
			 */
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					String Message = path + "にアクセス拒否されました";
					sampleAlertController.handleButtonWarningAction(Message);	
				}
			}
		}
	}
	
	@FXML protected void writer() {
		SampleAlertController sampleAlertController = new SampleAlertController();
		String path = pathtext.getText();
		String str = content.getText();
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(path);	// ファイル出力文字ストリーム
			bw = new BufferedWriter(fw);	// 出力用バッファ
			// 引数で指定した文字列を出力用バッファに書き込む
			bw.write(str);
			// 出力用バッファの内容をファイルへ書き出す
			bw.flush();
			String Message = path + "に保存しました．";
			sampleAlertController.handleButtonConfirmationAction(Message);
			//System.out.println(path + "に保存しました．");
		} catch (FileNotFoundException e) {
			String Message = "ファイル" + path + "が見つかりません．";
			//System.out.println("ファイル" + path + "が見つかりません．");
			sampleAlertController.handleButtonWarningAction(Message);
			System.exit(1);
		} catch (IOException e) {
			//e.printStackTrace();
			String Message = path + "アクセスが拒否されました";
			sampleAlertController.handleButtonErrorAction(Message);
		} finally {
			/*
			 * BufferedWriterストリームをクローズ
			 * （連結されているFileWriterストリームも同時にクローズされる）
			 */
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					//e.printStackTrace();
					String Message = path + "アクセスが拒否されました";
					sampleAlertController.handleButtonErrorAction(Message);
				}
			}
		}
	}
	
	
	public class SampleAlertController {
		@FXML private Button buttonConfirmation;
		@FXML private Button buttonError;
		@FXML private Button buttonInformation;
		@FXML private Button buttonWarning;
		@FXML private Label labelMessage;
		
		@FXML
		public void handleButtonConfirmationAction(String Message) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("保存成功");
			alert.setHeaderText(null);
			alert.setContentText(Message);
			Optional<ButtonType> result = alert.showAndWait();
			// 確認ダイアログでクリックされたボタンを判別
			if (result.get() == ButtonType.OK) {
				labelMessage.setText("CONFIRMATION: OK");
			} else {
				labelMessage.setText("CONFIRMATION: Cancel");
			}
		}
		
		@FXML
		public void handleButtonErrorAction(String Message) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("保存失敗");
			alert.setHeaderText(null);
			alert.setContentText(Message);
			Optional<ButtonType> result = alert.showAndWait();
			// 確認ダイアログでクリックされたボタンを判別
			if (result.get() == ButtonType.OK) {
				labelMessage.setText("ERROR: OK");
			}
		}
		
		@FXML
		public void handleButtonInformationAction(String Message) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("読み込み成功");
			alert.setHeaderText(null);
			alert.setContentText(Message);
			Optional<ButtonType> result = alert.showAndWait();
			// 確認ダイアログでクリックされたボタンを判別
			if (result.get() == ButtonType.OK) {
				labelMessage.setText("INFORMATION: OK");
			}
		}
		
		@FXML
		public void handleButtonWarningAction(String Message) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("読み込み失敗");
			alert.setHeaderText(null);
			alert.setContentText(Message);
			Optional<ButtonType> result = alert.showAndWait();
			// 確認ダイアログでクリックされたボタンを判別
			if (result.get() == ButtonType.OK) {
				labelMessage.setText("WARNING: OK");
			}
		}
	}
}
