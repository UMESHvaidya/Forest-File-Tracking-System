package com.vaidya.umesh.forrestapp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class createfile extends AppCompatActivity {

    private EditText Fileno,Filedate,Fileref,District,Filetitle,Filesubject,Filereceived,Remarks,Forwarded;
    ConnectionDetector cd;
    //private TextView tvfileno,tvfiledate,tvfileref,tvdistrict,tvfiletitle,tvfilesubject,tvfilereceived,tvremarks,tvforwarded;

    private Button save,reset;
    private FirebaseAuth firebaseAuth;

    private FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    public String fileno,filedate,fileref,district,filetitle,filesubject,filereceived,remarks,forwarded;
    private ProgressDialog progressDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createfile);

        Fileno=(EditText)findViewById(R.id.etfileno);
      //  Filedate=(EditText)findViewById(R.id.etfiledate);
        Fileref=(EditText)findViewById(R.id.etfileref);
        District=(EditText)findViewById(R.id.etdistrict);
        Filetitle=(EditText)findViewById(R.id.etfiletitle);
        Filesubject=(EditText)findViewById(R.id.etfilesubject);
        Filereceived=(EditText)findViewById(R.id.etfilereceived);
        Remarks=(EditText)findViewById(R.id.etfileremarks);
        Forwarded=(EditText)findViewById(R.id.etfileforward);
        save=(Button)findViewById(R.id.btnsave);
        reset=(Button)findViewById(R.id.btnreset);


        reference=FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        cd =new ConnectionDetector(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cd.isConnected()) {
                    if (check()){
                        progressDialog = new ProgressDialog(view.getContext());
                        progressDialog.show();
                        final Timer t = new Timer();
                        t.schedule(new TimerTask() {
                            public void run() {
                                progressDialog.dismiss();
                                t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                            }
                        }, 2500);
                      //  sendUserData();
                        String file= fileno =Fileno.getText().toString();
                        String  filedate=Filedate.getText().toString();
                        String  fileref=Fileref.getText().toString();
                        String  district=District.getText().toString();
                        String   filetitle=Filetitle.getText().toString();
                        String     filesubject=Filesubject.getText().toString();
                        String  filereceived=Filereceived.getText().toString();
                        String  remarks=Remarks.getText().toString();
                        String forwarded=Forwarded.getText().toString();


                        Fileinfo fileinfo = new Fileinfo(file,filedate,fileref,district,filetitle,filesubject,filereceived,remarks,forwarded);

                        reference.child("user").push().setValue(fileinfo);
                    }
                }else {

                    Toast.makeText(createfile.this,"Check Internet Connection",Toast.LENGTH_SHORT).show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fileno.setText("");
                Filedate.setText("");
                Fileref.setText("");
                District.setText("");
                Filetitle.setText("");
                Filesubject.setText("");
                Filereceived.setText("");
                Remarks.setText("");
                Forwarded.setText("");

            }
        });

    }

/*
    private void sendUserData(){
        Fileinfo fileinfo=new Fileinfo(fileno,filedate,fileref,district,filetitle,filesubject,filereceived,remarks,forwarded);
     //   reference.child("Root").child(filedate+"-"+filetitle).setValue(fileinfo);
        reference.child("User").push().setValue(fileinfo);
       // reference.setValue(fileinfo);
     //  reference.child("umesh").child(filedate+"-"+filetitle).child("Received From").setValue(pppp+"-->"+Filereceived.getText().toString());
    }

*/
    private boolean check(){
        boolean result =false;
        String fileno =Fileno.getText().toString();
        String filedate=Filedate.getText().toString();
        String fileref=Fileref.getText().toString();
        String district=District.getText().toString();
        String filetitle=Filetitle.getText().toString();
        String filesubject=Filesubject.getText().toString();
        String  filereceived=Filereceived.getText().toString();
        String  remarks=Remarks.getText().toString();
        String forwarded=Forwarded.getText().toString();

        if (fileno.isEmpty()) {
            //Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
            Fileno.setError("Enter File No");
            result=false;
        }
        if (filedate.isEmpty()){
            Filedate.setError("Enter File Date");
            result =false;
        }
        if (district.isEmpty()){
            District.setError("Enter District");
            result =false;
        }
        if (filetitle.isEmpty()){
            Filetitle.setError("Enter File Title");
            result =false;
        }
        if (filesubject.isEmpty()){
            Filesubject.setError("Enter File Subject");
            result =false;
        }
        if (filereceived.isEmpty()){
            Filereceived.setError("Enter File Received From");
            result =false;
        }
       else {
            result=true;
        }
        return result;
    }


}
