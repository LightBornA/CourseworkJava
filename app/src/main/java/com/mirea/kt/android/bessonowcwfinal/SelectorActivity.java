package com.mirea.kt.android.bessonowcwfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectorActivity extends AppCompatActivity {
    Button ButtonIp;
    Button ButtonTimex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
        ButtonIp = (Button) findViewById(R.id.ButtonIP);
        ButtonTimex = (Button) findViewById(R.id.ButtonTime);

        //Один Обработчик для всех кнопок.
        View.OnClickListener onClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int id = view.getId();
                if (id == R.id.ButtonIP){
                    Intent intent = new Intent(SelectorActivity.this, IpCalcActivity.class);
                    startActivity(intent);
                }
                else if (id == R.id.ButtonTime){
                    Intent intent = new Intent(SelectorActivity.this, TimeCalcActivity.class) ;
                    startActivity(intent);
                }
                }
            };
        ButtonIp.setOnClickListener(onClickListener);
        ButtonTimex.setOnClickListener(onClickListener);


        }
    }