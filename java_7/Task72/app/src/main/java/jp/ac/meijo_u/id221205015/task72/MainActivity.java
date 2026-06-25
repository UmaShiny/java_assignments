/**
 * 基本課題 7.2 Task72
 * @author 221205015 伊藤優希
 */

package jp.ac.meijo_u.id221205015.task72;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CountDownTask task;

    private EditText editCount;
    private Button buttonStart;
    private Button buttonStop;
    private TextView textCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCount = (EditText)findViewById(R.id.editCount);
        buttonStart = (Button)findViewById(R.id.buttonStart);
        buttonStop = (Button)findViewById(R.id.buttonStop);
        textCount = (TextView)findViewById(R.id.textCount);
    }

    public void handleButtonStart(View view){
        task = new CountDownTask(this);
        int count = Integer.parseInt(editCount.getText().toString());
        task.execute(count);
    }

    public void handleButtonStop(View view){
        if (task != null){
            task.cancel(true);
        }
    }

    public void setTextCount(String value){
        textCount.setText(value);
    }
}