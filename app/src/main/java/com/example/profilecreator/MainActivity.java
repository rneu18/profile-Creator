package com.example.profilecreator;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper helper;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
    }
    public void addListenerOnButton() {

        final Context context = this;

        button = (Button) findViewById(R.id.btnCreateId);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);

            }

        });
    }

}
