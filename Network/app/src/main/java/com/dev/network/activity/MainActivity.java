package com.dev.network.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dev.network.R;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button httpURLBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        this.httpURLBTN = findViewById(R.id.HttpURLConnetction);
        httpURLBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestUserdata();
            }
        });
    }

    private void requestUserdata() {
        try {
            URL uri = new URL("https://jsonplaceholder.typicode.com/users/1");

            HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(1000);
            connection.setReadTimeout(1000);
            int responsecode = connection.getResponseCode();
            Log.d(MainActivity.class.getSimpleName(),"Reponse code :" + responsecode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}