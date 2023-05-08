package com.example.chatgpt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.hbb20.CountryCodePicker;

public class login extends AppCompatActivity {

    CountryCodePicker countryCodePicker;
    EditText phoneInput;
    Button sendOtpBtm;
    ProgressBar progressBar;
    Button registreBTM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        countryCodePicker = findViewById(R.id.login_country_code);
        phoneInput = findViewById(R.id.login_mobile_number);
        sendOtpBtm = findViewById(R.id.send_otp_btm);
        progressBar = findViewById(R.id.login_progress_bar);

        registreBTM = findViewById(R.id.registreBtm);

        progressBar.setVisibility(View.GONE);
        countryCodePicker.registerCarrierNumberEditText(phoneInput);
        sendOtpBtm.setOnClickListener((v -> {
             if(!countryCodePicker.isValidFullNumber()){
                 phoneInput.setError("phone not valid");
                 return;
             }
            Intent intent = new Intent(login.this,loginOTP.class);
             intent.putExtra("phone",countryCodePicker.getFullNumberWithPlus());
             startActivity(intent);

        }));

        registreBTM.setOnClickListener((v -> {

            Intent intent = new Intent(login.this,Registre.class);
            startActivity(intent);

        }));


    }
}