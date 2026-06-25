/**
 * 基本課題 7.2 CountDownTask
 * @author 221205015 伊藤優希
 */

package jp.ac.meijo_u.id221205015.task72;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;

public class CountDownTask extends AsyncTask<Integer,String,String>{

    private MainActivity mainActivity;

    public CountDownTask(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Override
    protected String doInBackground(Integer... params){
        for (int i = params[0].intValue(); i >= 0; i--){
            publishProgress(String.valueOf(i));
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return "Done!";
    }

    @Override
    public void onPostExecute(String result){
        mainActivity.setTextCount(result);
    }

    @Override
    public void onProgressUpdate(String... values){
        mainActivity.setTextCount(values[0]);
    }
}
