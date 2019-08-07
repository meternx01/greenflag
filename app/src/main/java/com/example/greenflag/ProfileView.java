package com.example.greenflag;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ProfileView extends AppCompatActivity {

    private static final int REQUEST_CODE_TASK = 3333;
    RecyclerView recyclerView;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);

        recyclerView = findViewById(R.layout.activity_profile_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_TASK && resultCode == RESULT_OK) {

            ProfileDatabase profileDatabase = new ProfileDatabase(this, DatabaseUtil.databaseName,null,DatabaseUtil.databaseVersion);
            SQLiteDatabase readableDB = profileDatabase.getReadableDatabase();

//            String[] columns = {
//                    DatabaseUtil.ProfileTable.nameColumn,
//                    DatabaseUtil.ProfileTable.usernameColumn,
//                    DatabaseUtil.ProfileTable.ageColumn,
//                    DatabaseUtil.ProfileTable.countryColumn
//            };
//      public String name, userName, password, birthDate, country, gender;
//      public int age;

            Cursor cursor = readableDB.query(DatabaseUtil.ProfileTable.tablename,  null, null, null, null, null,null);

            List<Profile> dataSet = new ArrayList<>();
            Profile item;
            while(cursor.moveToNext()){
                String name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseUtil.ProfileTable.nameColumn));
                String username = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseUtil.ProfileTable.usernameColumn));
                String password = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseUtil.ProfileTable.passwordColumn));
                String birthdate = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseUtil.ProfileTable.birthdateColumn));
                String country = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseUtil.ProfileTable.countryColumn));
                String gender = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseUtil.ProfileTable.genderColumn));
                int age = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseUtil.ProfileTable.ageColumn)));
                item = new Profile(name,username,password,birthdate,country,gender,age);
                dataSet.add(item);

            }

            adapter = new CustomAdapter(dataSet);
            recyclerView.setAdapter(adapter);
        }
    }
}
