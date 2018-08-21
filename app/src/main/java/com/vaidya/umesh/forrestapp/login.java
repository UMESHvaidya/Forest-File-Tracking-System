package com.vaidya.umesh.forrestapp;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    LinearLayout l1;
    private EditText Name;
    private EditText Password;
    private TextView Attempts;
    private Button Login;
    private int counter =5;
    private Button userRegistration;
    private FirebaseAuth firebaseAuth;
    protected FirebaseUser mFirebaseUser;
    private ProgressDialog progressDialog ;
    ConnectionDetector cd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText)findViewById(R.id.etName);
        l1 =(LinearLayout) findViewById(R.id.l1);
        Password = (EditText)findViewById(R.id.etPassword);
        Attempts = (TextView)findViewById(R.id.tvAttempts);
        Login = (Button)findViewById(R.id.btnRegister);
        userRegistration =(Button) findViewById(R.id.tvRegistration);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        l1.setAnimation(myanim);
        Attempts.setText("Attempts Remaining: 5");
        firebaseAuth=FirebaseAuth.getInstance();
        mFirebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        progressDialog =new ProgressDialog(this);
        cd =new ConnectionDetector(this);
        FirebaseUser user= firebaseAuth.getCurrentUser();
        if (user !=null){
            finish();
            startActivity(new Intent(login.this,home.class));
        }

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check()) {
                    if (cd.isConnected()) {
                        validate(Name.getText().toString(), Password.getText().toString());
                    }else {
                        Toast.makeText(login.this,"Check Internet Connection ",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this,registration.class));
            }
        });


    }

    private void validate(String userName, String userPassword)
    {
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(userName,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
                    progressDialog.dismiss();
                    Toast.makeText(login.this, "Login Sucessful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(login.this, home.class));
                }
            else {
                    progressDialog.dismiss();
                    Toast.makeText(login.this,"Login Failed",Toast.LENGTH_SHORT).show();
                    counter--;
                    Attempts.setText("Attempts Remaining: "  + counter);
                    if (counter == 0) {
                        Login.setEnabled(false);

                    }
                }

            }
        });

    }



    @Override
    public void onBackPressed(){
        final AlertDialog.Builder builder =new AlertDialog.Builder(login.this);
        builder.setMessage("Are you sure to exit ?");
        builder.setCancelable(true);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                finish();
            }
        });
        AlertDialog alertDialog =builder.create();
        alertDialog.show();
    }
    private Boolean check() {
        Boolean result = false;
        String name = Name.getText().toString();
        String password = Password.getText().toString();

        if (password.isEmpty() || password.length() < 4 ) {
            Password.setError(" Enter Password");
            result = false;
        }
        if (name.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(name).matches()) {
            Name.setError("Enter Valid Email Address");
            result = false;
        }

       else {
            result = true;
        }
        return result;
    }

}
