package com.example.chatgpt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chatgpt.utils.AndroidUtil;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class loginOTP extends AppCompatActivity {
String phoneNumber;
Long timeoutSeconds = 60L;
String verificationCode;
PhoneAuthProvider.ForceResendingToken resendingToken;
EditText otpInput;
Button nextBtn;
ProgressBar progressBar;
TextView resentOtpTextView;
FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_otp);

        otpInput = findViewById(R.id.login_otp);
        nextBtn = findViewById(R.id.login_next_btm2);
        progressBar = findViewById(R.id.login_progress_bar);
        resentOtpTextView = findViewById(R.id.resend_otp_text);

        phoneNumber = getIntent().getExtras().getString("phone");
        nextBtn.setOnClickListener((v -> {

            Intent intent = new Intent(loginOTP.this,LoginUserNamer.class);
            startActivity(intent);

        }));
   // sendOpt(phoneNumber , false);

    }
  /* void  sendOpt(String phoneNumber, boolean isResend){
   setInProgress(true);
       PhoneAuthOptions.Builder builder =
               PhoneAuthOptions.newBuilder(mAuth)
                       .setPhoneNumber(phoneNumber)
                       .setTimeout(timeoutSeconds , TimeUnit.SECONDS)
                       .setActivity(this)
                       .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                           @Override
                           public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                               singIn(phoneAuthCredential);
                               setInProgress(false);
                           }

                           @Override
                           public void onVerificationFailed(@NonNull FirebaseException e) {
                               AndroidUtil.showToast(getApplicationContext(),"OTP VERfcation Failed");
                               setInProgress(false);

                           }

                           @Override
                           public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                               super.onCodeSent(s, forceResendingToken);
                               verificationCode =s;
                               resendingToken = forceResendingToken;
                               AndroidUtil.showToast(getApplicationContext(),"OTP Sent succescf");
                               setInProgress(false);

                           }
                       });
       if (isResend){
           PhoneAuthProvider.verifyPhoneNumber(builder.setForceResendingToken(resendingToken).build());
       }else {
           PhoneAuthProvider.verifyPhoneNumber(builder.build());

       }
    }

    void setInProgress(boolean inProgress){
        if (inProgress)
        {
            progressBar.setVisibility(View.VISIBLE);
            nextBtn.setVisibility(View.GONE);
        }else {
            progressBar.setVisibility(View.GONE);
            nextBtn.setVisibility(View.VISIBLE);


        }



    }

    void singIn(PhoneAuthCredential phoneAuthCredential)
    {


    } */
}