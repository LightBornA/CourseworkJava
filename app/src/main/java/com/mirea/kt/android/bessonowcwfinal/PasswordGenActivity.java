package com.mirea.kt.android.bessonowcwfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.mirea.kt.android.bessonowcwfinal.PasswordGenerator;
public class PasswordGenActivity extends AppCompatActivity {
    TextView generatedPWD1;
    TextView generatedPWD2;
    TextView generatedPWD3;
    TextView generatedPWD4;
    TextView generatedPWD5;
    ImageButton buttonGoBack;
    Button buttonGenerate;
    PasswordGenerator generator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_gen);

        generatedPWD1 = (TextView) findViewById(R.id.GeneratedPWD1);
        generatedPWD2 = (TextView) findViewById(R.id.GeneratedPWD2);
        generatedPWD3 = (TextView) findViewById(R.id.GeneratedPWD3);
        generatedPWD4 = (TextView) findViewById(R.id.GeneratedPWD4);
        generatedPWD5 = (TextView) findViewById(R.id.GeneratedPWD5);


        buttonGoBack = (ImageButton) findViewById(R.id.goBackButtonPWD);
        buttonGenerate = (Button) findViewById(R.id.ButtonGeneratePassword);


        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generatedPWD1.setText(generator.generateSecurePassword());
                generatedPWD2.setText(generator.generateSecurePassword());
                generatedPWD3.setText(generator.generateSecurePassword());
                generatedPWD4.setText(generator.generateSecurePassword());
                generatedPWD5.setText(generator.generateSecurePassword());

            }
        });

        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordGenActivity.this,SelectorActivity.class);
                startActivity(intent);
            }

    });
}
}