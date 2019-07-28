package com.example.greenflag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailActivity extends AppCompatActivity {

    RelativeLayout rl_emailpass;
    ImageButton ib_ea_back;
    Button btn_ea_next, test_button;
    TextView et_ea_emailentry, et_ea_cpassword, et_ea_rpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        rl_emailpass = (RelativeLayout) findViewById(R.id.rl_emailpass);
        ib_ea_back = (ImageButton) findViewById(R.id.ib_ea_back);
        btn_ea_next = (Button) findViewById(R.id.btn_ea_next);
        et_ea_emailentry = (TextView) findViewById(R.id.et_ea_emailentry);
        et_ea_cpassword = (TextView) findViewById(R.id.et_ea_cpassword);
        et_ea_rpassword = (TextView) findViewById(R.id.et_ea_rpassword);

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

                Boolean emailValid = validateEmail(et_ea_emailentry.getText());
                if(emailValid){
                    et_ea_emailentry.setBackgroundResource(R.layout.edittext_valid);
                }
                else{
                    et_ea_emailentry.setBackgroundResource(R.layout.edittext_invalid);
                }

                Boolean passwordValid = isValidPassword(et_ea_cpassword.getText().toString());
                if(passwordValid){
                    et_ea_cpassword.setBackgroundResource(R.layout.edittext_valid);
                }
                else{
                    et_ea_cpassword.setBackgroundResource(R.layout.edittext_invalid);
                }
                Boolean passwordsMatch = (et_ea_cpassword.getText().toString().equals(et_ea_rpassword.getText().toString()));
                if(passwordsMatch){
                    et_ea_rpassword.setBackgroundResource(R.layout.edittext_valid);
                }
                else{
                    et_ea_rpassword.setBackgroundResource(R.layout.edittext_invalid);
                }



                if(emailValid && passwordValid && passwordsMatch) {
                    Intent intent = new Intent(
                            getBaseContext(),
                            ProfileActivity.class
                    );
                    startActivity(intent);
                }
            }
        });



                CharSequence inputString;
                inputString = et_ea_emailentry.getText();

                boolean valid;
                valid = isValidEmail(inputString);


    }

    public static boolean validateEmail(CharSequence emailEntry){
        boolean emailvalid;
        emailvalid = isValidEmail(emailEntry);
        return  emailvalid;
    }

    public final static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=\\S+$).{8,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
}