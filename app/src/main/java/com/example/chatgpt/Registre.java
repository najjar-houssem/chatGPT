package com.example.chatgpt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registre extends AppCompatActivity {
    Button okBTM;
    EditText mail;
    EditText pass;
    ProgressBar progressBar;

    FirebaseAuth mAuth ;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(Registre.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);
        mAuth = FirebaseAuth.getInstance();

        okBTM = findViewById(R.id.okBTMid);
        mail = findViewById(R.id.registre_username);
        pass = findViewById(R.id.registre_pass);
        progressBar = findViewById(R.id.login_progress_bar);



       okBTM.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String email , pas;

               email = String.valueOf(mail.getText());
               pas = String.valueOf(pass.getText());

               if (TextUtils.isEmpty(email)){
                   Toast.makeText(Registre.this, "enter mail", Toast.LENGTH_SHORT).show();
                   return;
               }
               if (TextUtils.isEmpty(pas)){
                   Toast.makeText(Registre.this, "enter pass", Toast.LENGTH_SHORT).show();
                   return;
               }
               mAuth.signInWithEmailAndPassword(email, pas)
                       .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               progressBar.setVisibility(View.GONE);
                               if (task.isSuccessful()) {

                                   // Sign in success, update UI with the signed-in user's information
                                   Intent intent = new Intent(Registre.this,MainActivity.class);
                                   startActivity(intent);
                                   finish();
                               } else {
                                   // If sign in fails, display a message to the user.
                                   Toast.makeText(Registre.this, "Authentication failed.",
                                           Toast.LENGTH_SHORT).show();
                               }
                           }
                       });

           }
       });

    }


}