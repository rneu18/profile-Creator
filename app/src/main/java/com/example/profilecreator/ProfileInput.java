package com.example.profilecreator;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Calendar;

public class ProfileInput<CountryCodePicker> extends AppCompatActivity {


    Button selectDate;
    Button button;
    TextView date;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_input);

        //Previous password retrieve


        Button selectDate = findViewById(R.id.input_user_bd);
        date = findViewById(R.id.input_user_age);
        EditText pass_wd = (EditText) findViewById(R.id.input_user_password);
//        pass_wd.setText(first_password);

        button = (Button) findViewById(R.id.savebtn);


        button.setOnClickListener(new View.OnClickListener() {
            final String my_password = getIntent().getExtras().getString("password");
            final String my_email = getIntent().getExtras().getString("email");


            public void onClick(View arg0) {

                EditText pass_wd = (EditText) findViewById(R.id.input_user_password);
                String pass_str = pass_wd.getText().toString();
                EditText person_name = (EditText) findViewById(R.id.input_person_name);
                final String full_name = person_name.getText().toString();
                EditText user_name = (EditText) findViewById(R.id.input_user_name);
                final String user_id = person_name.getText().toString();
                TextView birthday = (TextView) findViewById(R.id.input_user_bd);
                final String brthday = birthday.getText().toString();
                EditText country1 = (EditText) findViewById(R.id.input_user_country);
                final String country = country1.getText().toString();
                EditText address1 = (EditText) findViewById(R.id.input_user_address);
                final String address = address1.getText().toString();



                if(my_password.equals(pass_str)){
                    Intent intent = new Intent(ProfileInput.this, ProfileGrid.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Name", full_name);
                    bundle.putString("Email", my_email);
                    bundle.putString("userId", user_id);
                    bundle.putString("birth_date", brthday);
                    bundle.putString("country", country);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else {
                    TextView alert = (TextView) findViewById(R.id.alert);
                    alert.setText("Wrong Password!!!");
                }

            }

        });

        selectDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(ProfileInput.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                date.setText(day + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });
    }
}
