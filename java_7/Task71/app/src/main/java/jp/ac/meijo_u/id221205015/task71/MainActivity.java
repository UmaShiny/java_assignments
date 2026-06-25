/**
 * 基本課題 7.1 Task71
 * @author 221205015 伊藤優希
 */

package jp.ac.meijo_u.id221205015.task71;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.Toast;

import java.io.*;

public class MainActivity extends AppCompatActivity {

    private Button buttonSave;
    private Button buttonLoad;
    private EditText content;
    private EditText Path;
    private TextView condition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = (EditText) findViewById(R.id.content);
        buttonLoad =(Button) findViewById(R.id.buttonLoad);
        buttonSave=(Button) findViewById(R.id.buttonSave);
        Path=(EditText) findViewById(R.id.Path);
        condition=(TextView) findViewById(R.id.Title);
    }

    public void LoadClickAction(View view) {
        String path = Path.getText().toString();
        //FileInputStream fis = null;
        BufferedReader br = null;

        try {
            //fr = new FileReader(path);	// ファイル入力文字ストリーム
            FileInputStream fis = openFileInput(path);
            InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
            br = new BufferedReader(isr);	// 入力用バッファ
            String text = "";
            String str;
            // ファイルからまとめて入力用バッファ読み込み，入力用バッファxから1行読み込み
            while ((str = br.readLine()) != null) {
                text += str + "\r\n";    // 改行コードを付け加える
            }
            String Message = path + "から読み取りました";
            //condition.setText(Message);

            //content.setText(Message);


            //String Message = path + "から読み取りました";
            Toast.makeText(this, Message, Toast.LENGTH_LONG).show();

            content.setText(text);

        }catch (FileNotFoundException e) {
            //System.out.println("ファイル" + path + "が見つかりません．");
            String Message = path + "が見つかりませんでした";
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();

            condition.setText(Message);
            //System.exit(1);
        } catch (IOException e) {
            //e.printStackTrace();
            String Message = path + "にアクセス拒否されました";
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
            condition.setText(Message);
        }finally{
            /*
             * BufferedReaderストリームをクローズ
             * （連結されているFileReaderストリームも同時にクローズされる）
             */
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    String Message = path + "にアクセス拒否されました";
                    Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();

                    condition.setText(Message);
                }
            }
        }
    }

    public void SaveClickAction(View view){
        String path = Path.getText().toString();
        String str = content.getText().toString();
        //FileOutputStream fos = null;
        BufferedWriter bw = null;
        try {
            FileOutputStream fos = openFileOutput(path,MODE_PRIVATE);	// ファイル出力文字ストリーム
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
            bw = new BufferedWriter(osw);	// 出力用バッファ
            // 引数で指定した文字列を出力用バッファに書き込む
            bw.write(str);
            // 出力用バッファの内容をファイルへ書き出す
            bw.flush();
            String Message = path + "に保存しました．";
            Toast.makeText(this,Message,Toast.LENGTH_LONG).show();

            condition.setText(Message);
        } catch (FileNotFoundException e) {
            String Message = "ファイル" + path + "が見つかりません．";
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();

            condition.setText(Message);
            //System.exit(1);
        } catch (IOException e) {
            //e.printStackTrace();
            String Message = path + "アクセスが拒否されました";
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();

            condition.setText(Message);
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
                    Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();

                    condition.setText(Message);
                }
            }
        }
    }
}