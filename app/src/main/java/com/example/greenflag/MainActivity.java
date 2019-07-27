package com.example.greenflag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rl_main;
    Button btn_ma_create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl_main = (RelativeLayout) findViewById(R.id.rl_main);
        btn_ma_create = (Button) findViewById(R.id.btn_ma_create);

        btn_ma_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getBaseContext(),
                        EmailActivity.class
                );
                startActivity(intent);
            }
        });
    }





}
