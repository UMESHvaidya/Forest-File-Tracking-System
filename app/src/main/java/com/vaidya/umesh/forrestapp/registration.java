package com.vaidya.umesh.forrestapp;

import android.accounts.Account;
import android.app.ProgressDialog;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registration extends AppCompatActivity {
    ImageView l1;
    Animation mytransiton;
    private EditText userName, userPassword, userEmail;
    private Button regButton;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth mAuth;
    ConnectionDetector cd;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setupUIViews();
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        cd =new ConnectionDetector(this);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    //upload
                    if (cd.isConnected()) {
                        progressDialog.setMessage("Please wait");
                        progressDialog.show();
                        String user_email = userEmail.getText().toString().trim();
                        String user_passowrd = userPassword.getText().toString().trim();
                        firebaseAuth.createUserWithEmailAndPassword(user_email, user_passowrd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    progressDialog.dismiss();
                                    Toast.makeText(registration.this, "Registration Successful ", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(registration.this, login.class));
                                } else {
                                    progressDialog.dismiss();
                                    Toast.makeText(registration.this, "Registration Failed ", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
                    }else {
                        Toast.makeText(registration.this,"Check Internet Connection",Toast.LENGTH_SHORT).show();
                   }
                }
            }
        });
    }


    private void setupUIViews() {
        l1 = (ImageView) findViewById(R.id.l1);
        userName = (EditText) findViewById(R.id.etUserName);
        userPassword = (EditText) findViewById(R.id.etPassword);
        userEmail = (EditText) findViewById(R.id.etUserEmail);
        regButton = (Button) findViewById(R.id.btnRegister);
          Animation myanim = AnimationUtils.loadAnimation(this,R.anim.slowanimation);
          l1.setAnimation(myanim);
    }

    private Boolean validate() {
        Boolean result = false;
        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        String email = userEmail.getText().toString();

        if (name.isEmpty() || name.length() < 4) {
            userName.setError("Minimum 4 Letters Required");
            result = false;
        }
        if (password.isEmpty() || password.length() < 4) {
            userPassword.setError("Minimum 6 Alphanumeric Characters");
            result = false;
        }
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            userEmail.setError("Enter Email Address");
            result = false;
        }
        else {
            result = true;
        }
        return result;
    }
}
