package com.mirea.kt.android.bessonowcwfinal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.mirea.kt.android.bessonowcwfinal.IPv4;

public class IpCalcActivity extends AppCompatActivity {
    Button CalculateButton;
    EditText EditIp;
    EditText EditMask;
    TextView OutputText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip_calc);
        CalculateButton = (Button) findViewById(R.id.ButtonFindNetwork);
        EditIp = (EditText) findViewById(R.id.ipedit) ;
        EditMask = (EditText) findViewById(R.id.maskedit) ;
        OutputText = (TextView) findViewById(R.id.networkadresout);


        CalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IPv4 Calculator = new IPv4(EditIp.getText().toString(), EditMask.getText().toString());
                OutputText.setText(Calculator.getCIDR());





            }
        });
    }
}
