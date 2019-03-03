package com.example.profilecreator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        addListenerOnButton();
    }
    public void addListenerOnButton() {

        final Context context = this;

        button = (Button) findViewById(R.id.btnSignUpNext);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                TextView email_add = findViewById(R.id.input_email);
                String email_address = email_add.getText().toString();
                TextView pwd1 = findViewById(R.id.input_password);
                String password1 = pwd1.getText().toString();
                TextView pwd2 = findViewById(R.id.rep_password);
                String password2 = pwd2.getText().toString();
                Boolean email_true = validateEmail(email_address);
                Boolean password_t1 = validatePassWord1(password1);
                Boolean password_t2 = validatePassWord2(password2, password1);

                if((email_true == true) && (password_t1 == true) && (password_t2 == true)){

                    Intent intent = new Intent(SignUpActivity.this, ProfileInput.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(SignUpActivity.this, SignUpActivity.class);
                    startActivity(intent);
                }
            }

        });
    }

    public Boolean validatePassWord2(String password2, String password1) {
        if(password2.equals(password1)){
            return true;
        }else{
            return false;
        }
    }


    public Boolean validatePassWord1(String password1) {
        List<String> errorList = new ArrayList<String>();
        Pattern specailCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
        Pattern lowerCasePatten = Pattern.compile("[a-z ]");
        Pattern digitCasePatten = Pattern.compile("[0-9 ]");
        errorList.clear();

        boolean flag=true;


        if (password1.length() < 8) {
            errorList.add("Password lenght must have alleast 8 character !!");
            flag=false;
        }

        if (!UpperCasePatten.matcher(password1).find()) {
            errorList.add("Password must have atleast one uppercase character !!");
            flag=false;
        }
        if (!lowerCasePatten.matcher(password1).find()) {
            errorList.add("Password must have atleast one lowercase character !!");
            flag=false;
        }
        if (!digitCasePatten.matcher(password1).find()) {
            errorList.add("Password must have atleast one digit character !!");
            flag=false;
        }

        return flag;
    }

    public Boolean validateEmail(String email_address) {

        Pattern regexPattern;
        Matcher regMatcher;

        regexPattern = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
        regMatcher   = regexPattern.matcher(email_address);
        if(regMatcher.matches()) {
            return true;
        } else {
            return false;
        }

    }
}
