package com.mirea.kt.android.bessonowcwfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SelectorActivity extends AppCompatActivity {
    Button ButtonIp;
    Button ButtonTimex;
    Button buttonPWD;
    Button buttonPoE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
        ButtonIp = (Button) findViewById(R.id.ButtonIP);
        ButtonTimex = (Button) findViewById(R.id.ButtonTime);
        buttonPWD = (Button) findViewById(R.id.ButtonGoPWD);
        buttonPoE = (Button) findViewById(R.id.ButtonGoPoE);

        //Один Обработчик для всех кнопок.
        View.OnClickListener onClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int id = view.getId();
                if (id == R.id.ButtonIP){
                    Intent intent = new Intent(SelectorActivity.this, IpCalcActivity.class);
                    startActivity(intent);
                }

                if (id == R.id.ButtonTime) {
                    Intent intent = new Intent(SelectorActivity.this, TimeCalcActivity.class);
                    startActivity(intent);
                }

                if (id == R.id.ButtonGoPWD){
                    Intent intent = new Intent(SelectorActivity.this, PasswordGenActivity.class) ;
                    startActivity(intent);
                }

                if (id == R.id.ButtonGoPoE){
                    Intent intent = new Intent(SelectorActivity.this, CalculatePoeActivity.class) ;
                    startActivity(intent);
                }
                }
            };
        ButtonIp.setOnClickListener(onClickListener);
        ButtonTimex.setOnClickListener(onClickListener);
        buttonPWD.setOnClickListener(onClickListener);
        buttonPoE.setOnClickListener(onClickListener);


        }
    }