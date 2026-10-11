package com.dev.datastorages.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dev.datastorages.R;

public class SharedPrefernceActivity extends AppCompatActivity {

    private static final String APP_DATA = "My_App_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_shared_prefernce);
        EditText emailInput = findViewById(R.id.EmailInput);
        EditText passwordInput = findViewById(R.id.PasswordInput);
        Button loginbtn = findViewById(R.id.SubmitButton);

        checkIsLogged();

        String email  = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.equals("dev@gmail.com") && password.equals("405090")){
                    Toast.makeText(SharedPrefernceActivity.this,"Login SuccessFull!",Toast.LENGTH_SHORT).show();

                  SharedPreferences sharedPreferences = getSharedPreferences(APP_DATA,MODE_PRIVATE);
                  SharedPreferences.Editor editor = sharedPreferences.edit();
                  editor.putBoolean("IsLoggedIn",true);
                  editor.commit();  // work immedialtly
                  editor.apply();  // work as asychronizly (As a background process)

                }else{
                    Toast.makeText(SharedPrefernceActivity.this,"Login Failed!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void checkIsLogged(){
        SharedPreferences sharedPreferences = getSharedPreferences(APP_DATA,MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("IsLoggedIn",false);  // Key & Default Value
        if (isLoggedIn){
            Toast.makeText(SharedPrefernceActivity.this,"Already Logged!",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(SharedPrefernceActivity.this,"Please Fill Logging Data!",Toast.LENGTH_SHORT).show();
        }
    }
}