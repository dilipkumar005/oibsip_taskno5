package com.dk.stopwatch;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

import java.text.MessageFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView textview;
    MaterialButton start, stop, hold;
    int milliSeconds, seconds, minutes;
    long milliseconds, startTime, timebuff, updateTime = 0L;
    Handler handler;
    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            milliseconds = SystemClock.uptimeMillis() - startTime;
            updateTime = timebuff + milliseconds;
            seconds = (int) (updateTime /1000);
            minutes = seconds / 60;
            seconds = seconds % 60;
            milliSeconds = (int) (updateTime % 1000);

            textview.setText(MessageFormat.format("{0}:{1}:{2}", minutes, String.format(Locale.getDefault(), "%02d", seconds), String.format(Locale.getDefault(), "%02d", milliSeconds)));
            handler.postDelayed(this, 0);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textview = findViewById(R.id.textview);

        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        hold = findViewById(R.id.hold);

        handler = new Handler(Looper.myLooper());

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);
                stop.setEnabled(false);
                hold.setEnabled(true);
                start.setEnabled(false);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               milliseconds = 0L;
               startTime = 0L;
               timebuff = 0L;
               updateTime = 0L;
               seconds = 0;
               minutes = 0;
               milliSeconds = 0;
               textview.setText(R.string.timer);
            }
        });

        hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timebuff += milliseconds;
                handler.removeCallbacks(runnable);
                stop.setEnabled(true);
                hold.setEnabled(false);
                start.setEnabled(true);
            }
        });

        textview.setText(R.string.timer);
    }
}