package com.mirea.kt.android.bessonowcwfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;


import org.json.JSONException;
import org.json.JSONObject;

import org.apache.commons.text.StringEscapeUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    EditText login;
    EditText password;
    Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = (Button) findViewById(R.id.submit);
        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);

        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {authorization(login.getText().toString(), password.getText().toString());}
        });
    }

    private void authorization(String login, String password) {
        OkHttpClient client = new OkHttpClient();

        String API_URL = "https://android-for-students.ru/coursework/login.php";

        RequestBody formBody = new FormBody.Builder()
                .add("lgn", "Student99544") //login для работы входа, для обхода написаны правильные значения
                .add("pwd", "5L5AUFV")//password
                .add("g", "RIBO-01-21")//
                .build();
        Request req = new Request.Builder()
                .url(API_URL)
                .post(formBody)
                .build();

        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String res = response.body().string();

                runOnUiThread(() -> {
                    try {
                        JSONObject jsonObject = new JSONObject(res);
                        int resultCode = jsonObject.getInt("result_code");
                        String decodedResponse = StringEscapeUtils.unescapeJava(res);
                        Log.i("ans",decodedResponse);
                        if (resultCode == 1) {
                            Intent intent = new Intent(MainActivity.this, SelectorActivity.class);
                            startActivity(intent);
                        } else if (resultCode == -1) {
                            Toast.makeText(MainActivity.this, "Bad data", Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        });
    }
}
