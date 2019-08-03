package com.example.greenflag;

import android.provider.BaseColumns;

public class DatabaseUtil {

    public static final String databaseName = "profilesDB";
    public static final int databaseVersion = 1;

    public class ProfileTable implements BaseColumns{
        public static final String tablename = "profiles";
        public static final String nameColumn = "name";
        public static final String usernameColumn = "username";
        public static final String passwordColumn = "password";
        public static final String ageColumn = "age";
        public static final String birthdateColumn = "birthdate";
        public static final String genderColumn = "gender";
        public static final String countryColumn = "country";
    }
}
