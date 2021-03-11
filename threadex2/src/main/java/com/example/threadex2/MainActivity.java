package com.example.threadex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnStart;
    SeekBar sb1, sb2;
    TextView tv1, tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart=findViewById(R.id.btnStart);
        sb1=findViewById(R.id.sd1);
        sb2=findViewById(R.id.sd2);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0; i<100; i++) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    sb1.setProgress(sb1.getProgress() + 2);
                                    tv1.setText("1번 진행률 : " + sb1.getProgress() + "%");
                                }
                            });
                            SystemClock.sleep(100);
                        }
                    }
                });
                thread.start();

                new Thread(new Runnable() { //익명 스레드
                    @Override
                    public void run() {
                        for(int i=0; i<100; i++){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    sb2.setProgress((sb2.getProgress()+1));
                                    tv2.setText("2번 진행률 : " + sb2.getProgress() + "%");
                                }
                            });
                            SystemClock.sleep(100); //for문 한번 돌 때 쉬었다 하기
                        }
                    }
                }).start();

            }
        });
    }
}