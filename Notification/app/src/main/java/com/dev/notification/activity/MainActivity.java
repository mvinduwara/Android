package com.dev.notification.activity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dev.notification.R;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFICATION_NUMBER = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button notificfatiobtn = findViewById(R.id.notificationbutton);


        notificfatiobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupNotification();
            }
        });
    }

    private void popupNotification(){
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String channelId = "test_channel";
        NotificationChannel testNotification = new NotificationChannel(channelId,
                "Test Notification",
                NotificationManager.IMPORTANCE_DEFAULT);
        manager.createNotificationChannel(testNotification);

        Notification notification = new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.outline_10k_24)
                .setContentTitle("Notification Practical")
                .setContentText("This is my notification message")
                .setAutoCancel(true)
                .build();
        manager.notify(NOTIFICATION_NUMBER, notification);
    }
}