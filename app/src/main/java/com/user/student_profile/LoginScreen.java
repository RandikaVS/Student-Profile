package com.user.student_profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {

    private TextView SignIn;
    private EditText Email,Password;
    private Button Login;
    private ProgressBar ProgressBar;
    private CheckBox PasswordShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        SignIn = findViewById(R.id.sign_button);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        Login = findViewById(R.id.login_button);
        ProgressBar = findViewById(R.id.progress_circular);
        PasswordShow = findViewById(R.id.password_show);


        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginScreen.this,SignIn.class);
                startActivity(intent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = Email.getText().toString().trim();
                String password  = Password.getText().toString().trim();
                Login.setVisibility(View.GONE);
                ProgressBar.setVisibility(View.VISIBLE);
                boolean isSuccess = true;

                if(email.isEmpty()){
                    Email.setError("Please enter valid email");
                    Email.requestFocus();
                    isSuccess=false;
                }
                if(password.isEmpty()){
                    Password.setError("Please enter password");
                    Password.requestFocus();
                    isSuccess=false;
                }

                if(isSuccess==true){

                }
                else{
                    ProgressBar.setVisibility(View.GONE);
                    Login.setVisibility(View.VISIBLE);

                    Toast.makeText(getApplicationContext(),"Check empty fields",Toast.LENGTH_SHORT).show();
                }

            }
        });

        PasswordShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox)view).isChecked();

                if(checked){
                    Password.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                else{
                    Password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                if(checked==false){
                    Password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                Password.setSelection(Password.getText().length());

//                switch (view.getId()){
//                    case R.id.password_show:
//                        if(checked){
//                            Password.setInputType(InputType.TYPE_CLASS_TEXT);
//                        }
//                        else{
//                            Password.setInputType((InputType.TYPE_NUMBER_VARIATION_PASSWORD));
//                        }
//                        Password.setSelection(Password.getText().length());
//                        break;
//                }
            }
        });
    }
}