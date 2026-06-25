package jp.ac.meijo_u.id221205015.task83;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BinaryOperator;

public class MainActivity extends AppCompatActivity {

    //private Button GoButton;
    private Button FileButton;
    private EditText HexToAsciiOnThisTable;
    private TextView PathName;

    static final int REQUEST_OPEN_FILE = 1001;
    private static final int PICK_BINARY_FILE = 1;

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GoButton = (Button) findViewById(R.id.GoButton);
        FileButton = (Button) findViewById(R.id.FileButton);
        HexToAsciiOnThisTable = (EditText) findViewById(R.id.HexToAsciiOnThisTable);
        PathName = (TextView) findViewById(R.id.PathName);
    }

    public void handleFileButton(View view) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        context = MainActivity.this;
        startActivityForResult(Intent.createChooser(intent,"Open a file"),REQUEST_OPEN_FILE);

    }

    public void handleGoButton(View view){
        //write here main process.
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //File Load
        if(requestCode == REQUEST_OPEN_FILE){
            if(resultCode == RESULT_OK && data != null){
                Uri uri = data.getData();
                String[] projection = {MediaStore.MediaColumns.DISPLAY_NAME};
                Cursor cursor = context.getContentResolver().query(uri,projection,null,null,null);
                if(uri != null){
                    HexToAsciiOnThisTable.setText(loadStrFromUri(uri));
                    /*
                    String filename = new File(uri.getPath()).getName();
                    PathName.setText(filename);
                    */
                }
                if (cursor != null){
                    String path = null;
                    if (cursor.moveToFirst()){
                        path = cursor.getString(0);
                        //Log.d("kyo",path);
                        PathName.setText(path);
                    }
                    cursor.close();
                }
            }
        }
        super.onActivityResult(requestCode,resultCode,data);
    }

    String loadStrFromUri(Uri uri){
        int length = 0;
        int i = 0;
        int ch = 0;
        String str = "";
        String temp_ascii = "";
        String temp_hex = "";
        //Boolean loop=true;
        try{
            if(uri.getScheme().equals("content")){
                InputStream is = getContentResolver().openInputStream(uri);
                //if(is==null)loop=false;
                //ByteArrayOutputStream bout = new ByteArrayOutputStream();
                int[] hex = new int[1024];
                while((ch = is.read()) != -1){
                    if(i % 16 == 0 && i != 0) {
                        str += String.format("%08x  ",length) + temp_hex + "|" + temp_ascii + "|\n";
                        temp_ascii = "";
                        temp_hex = "";
                        i = 0;
                    }
                    temp_hex += String.format("%02x ",ch);
                    if(!(32<ch && ch<127)){
                        ch = 46;
                    }
                    length += 1;
                    //bout.write(hex, 0, ch);
                    temp_ascii += (char) ch;
                    i++;
                }
                str += String.format("%08x   ",length) + temp_hex + " |" + temp_ascii + "|\n";

                //str = bout.toString();
            }else{
                Toast.makeText(this,"Unknown scheme",Toast.LENGTH_LONG).show();
            }
        }catch(Exception e){
            Toast.makeText(this, "Cannot read the file:" + e.toString(), Toast.LENGTH_LONG).show();
        }
        return str;
    }
}