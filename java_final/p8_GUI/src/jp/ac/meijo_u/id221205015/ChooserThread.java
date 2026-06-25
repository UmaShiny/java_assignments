package jp.ac.meijo_u.id221205015;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class ChooserThread extends Thread{
	@FXML private Button ButtonGo;
	@FXML private TextField Path;
	@FXML private TextArea PlotArea;
	@FXML private ProgressBar pgr;
	
	@Override
	public void run() {
		FileChooser fc = new FileChooser();
	    fc.setTitle("ファイル選択");
	    fc.getExtensionFilters().addAll(
	    	new FileChooser.ExtensionFilter("イメージファイル", "*.jpg", "*.png"),
	    	new FileChooser.ExtensionFilter("すべてのファイル", "*.*")
	    );
	    // 初期フォルダをホームに
	    fc.setInitialDirectory(new File(System.getProperty("user.home")));
	    // ファイルダイアログ表示
	    //File file = fc.showSaveDialog(null);
	    File file = fc.showOpenDialog(null);
	    if(file != null) {
	    	Path.setText(file.getPath());
	    }
	}
	
	public void setBuutonGo(Button ButtonGo) {
		this.ButtonGo = ButtonGo;
	}

	public void setPath(TextField Path) {
		this.Path = Path;
	}
	
	public void setArea(TextArea PlotArea) {
		this.PlotArea = PlotArea;
	}
	
	public void setGage(ProgressBar pgr) {
		this.pgr = pgr;
	}

}
