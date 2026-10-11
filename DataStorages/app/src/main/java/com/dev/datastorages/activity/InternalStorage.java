package com.dev.datastorages.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dev.datastorages.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InternalStorage extends AppCompatActivity {

    private Button storebtn, retrievebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_internal_storage);

        storebtn = findViewById(R.id.Store);
        retrievebtn = findViewById(R.id.Retrieve);

        storebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeData();
            }
        });

        retrievebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readData();
            }
        });
    }

    private void storeData() {
        //  getFilesDir(); //  Files Directory
        //  getCacheDir(); // Cache Directory
        File file = new File(getFilesDir(), "AppData.txt"); // lk/jiat/data_storage/files/AppData.txt
        try {
            FileOutputStream fileOutputStream = openFileOutput("AppData.txt", MODE_PRIVATE);
            String text = "My name is Anjana";
            fileOutputStream.write(text.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readData() {
        try {
            FileInputStream fileInputStream = openFileInput("AppData.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            fileInputStream.close();
            bufferedReader.close();
            Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}