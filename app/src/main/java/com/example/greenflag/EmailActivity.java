package com.example.greenflag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class EmailActivity extends AppCompatActivity {

    RelativeLayout rl_emailpass;
    ImageButton ib_ea_back;
    Button btn_ea_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        rl_emailpass = (RelativeLayout) findViewById(R.id.rl_emailpass);
        ib_ea_back = (ImageButton) findViewById(R.id.ib_ea_back);
        btn_ea_next = (Button) findViewById(R.id.btn_ea_next);

        ib_ea_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getBaseContext(),
                        MainActivity.class
                );
                startActivity(intent);
            }
        });

        btn_ea_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getBaseContext(),
                        ProfileActivity.class
                );
                startActivity(intent);
            }
        });
    }



}