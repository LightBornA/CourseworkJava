package com.mirea.kt.android.bessonowcwfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import java.lang.StringBuffer;
import java.text.DecimalFormat;

public class TimeCalcActivity extends AppCompatActivity {
EditText SpeedText;
EditText SizeText;
TextView TimeOut;
ImageButton GoBack;
Button Calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_calc);
        SpeedText = (EditText) findViewById(R.id.speedEdit);
        SizeText = (EditText) findViewById(R.id.sizeEdit);
        TimeOut = (TextView) findViewById(R.id.TimeOut);
        GoBack = (ImageButton) findViewById(R.id.goBackButtonTime);
        Calculate = (Button) findViewById(R.id.ButtonCalculateTime);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        Calculate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                try {
                    String speedtext = SpeedText.getText().toString();
                    float speed = Float.parseFloat(speedtext);
                    String speedsize = SizeText.getText().toString();
                    float size = Float.parseFloat(speedsize);
                    float speedseconds = size*1024*8/speed;
                    String seconds = df.format(speedseconds);
                    TimeOut.setText(seconds + " секунд");
                }
                catch (NumberFormatException e){
                    Toast.makeText(TimeCalcActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });

        GoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimeCalcActivity.this,SelectorActivity.class);
                startActivity(intent);
            }
        });








    }
}