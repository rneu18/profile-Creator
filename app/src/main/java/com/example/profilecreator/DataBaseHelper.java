package com.example.profilecreator;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBaseHelper extends SQLiteOpenHelper {



    private static final String DB_NAME = "USER.DB";
    private static final String TABLE_NAME = "USER";
    private static String U_ID = "ID";
    private static String USER_NAME = "User";
    private static String USER_ID = "User_id";
    private static String EMAIL= "Email";
    private static String B_DATE = "Birth_date";
    private static String COUNTRY = "Country";




    public DataBaseHelper( Context context) {
        super(context,
                DB_NAME, //name o Db
                null, //factory to create
                1);//version of DB

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery =
                "CREATE TABLE " +
                        TABLE_NAME +
                        "("+U_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        USER_ID+ " VARCHAR(255), " +
                        USER_NAME+ " VARCHAR(255), " +
                        EMAIL+ " VARCHAR(255), " +
                        B_DATE+ " VARCHAR(255), " +
                        COUNTRY+ " VARCHAR(255))";                       ;
        db.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public void insertData (String name, String userName, String email, String country ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_ID, userName);
        contentValues.put(USER_NAME, name);
        contentValues.put(EMAIL, email);
        contentValues.put(COUNTRY, country);
        db.insert(TABLE_NAME, null, contentValues);


    }



}

