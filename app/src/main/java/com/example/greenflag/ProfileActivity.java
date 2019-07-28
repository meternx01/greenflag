package com.example.greenflag;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class ProfileActivity extends AppCompatActivity {

    RelativeLayout rl_pa;
    Button btn_pa_button1, btn_pa_button2, btn_pa_datepicker;
    DatePickerDialog datePickerDialog;
    EditText et_pa_dateentry;
    Spinner sp_pa_country;

    String[] countryNames = {"Not-Specified", "Malaysia", "United States", "Indonesia","France", "Italy", "Singapore", "New Zealand", "India"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        rl_pa = (RelativeLayout) findViewById(R.id.rl_pa);
        btn_pa_button1 = (Button) findViewById(R.id.btn_pa_button1);
        btn_pa_button2 = (Button) findViewById(R.id.btn_pa_button2);
        btn_pa_datepicker = (Button) findViewById(R.id.btn_pa_datepicker);
        et_pa_dateentry = (EditText) findViewById(R.id.et_pa_dateentry);
        sp_pa_country = (Spinner) findViewById(R.id.sp_pa_country);



        sp_pa_country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item,countryNames);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_pa_country.setAdapter(aa);;

        btn_pa_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_pa_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(ProfileActivity.this, new
                DatePickerDialog.OnDateSetListener()
                {

                    @Override public void onDateSet(DatePicker view, int year, int
                            monthOfYear, int dayOfMonth)
                    {
                        // set day of month , month and year value in the edit text
                        et_pa_dateentry.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);

                    }
                }
                , mYear, mMonth, mDay);

        btn_pa_datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                datePickerDialog.show();
            }
        });


    }

}
