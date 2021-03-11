package com.example.thread;
/*  스레드 : 여러 작업을 동시에 수행하기 위해 사용하는 개념(멀티 스레드)
*   경량 프로세드*/
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb1;
    Button btnInc, btnDec;
    SeekBar sb1;
    TextView tvValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        pb1=findViewById(R.id.pb1);
        btnInc=findViewById(R.id.btnInc);
        btnDec=findViewById(R.id.btnDec);
        sb1=findViewById(R.id.sb1);
        tvValue=findViewById(R.id.tvValue);

        btnInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb1.incrementProgressBy(10);
            }
        });
        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb1.incrementProgressBy(-10);
            }
        });
        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // 잡고 움직이지
                tvValue.setText("진행률 : " + progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //클릭하여 움직이기
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}