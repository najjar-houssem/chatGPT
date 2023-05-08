package com.example.chatgpt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginUserNamer extends AppCompatActivity {
    Button nextBtn3;
    EditText mail;
    EditText pass;
    FirebaseAuth mAuth ;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(LoginUserNamer.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user_namer);
        mAuth = FirebaseAuth.getInstance();


        nextBtn3 = findViewById(R.id.login_next_btm3);
        mail = findViewById(R.id.login_username);
        pass = findViewById(R.id.login_pass);

        nextBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email , pas;

                email = String.valueOf(mail.getText());
                pas = String.valueOf(pass.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(LoginUserNamer.this, "enter mail", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pas)){
                    Toast.makeText(LoginUserNamer.this, "enter pass", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email, pas)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Intent intent = new Intent(LoginUserNamer.this,Registre.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(LoginUserNamer.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });
    }
}