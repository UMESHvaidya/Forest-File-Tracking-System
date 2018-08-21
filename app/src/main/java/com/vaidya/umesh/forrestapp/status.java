package com.vaidya.umesh.forrestapp;

import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class status extends AppCompatActivity {

    public DatabaseReference mDatabase;
    public ListView mUserList;

    public ArrayList<String> mUsernames = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mUserList = (ListView) findViewById(R.id.listview);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mUsernames);

        mUserList.setAdapter(arrayAdapter);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

/*
        @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

              /*  String value = dataSnapshot.getValue(String.class);
                mUsernames.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }  */
    }


    private void showData(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            Fileinfo fInfo = new Fileinfo();
            fInfo.setFileno(ds.child("user").getValue(Fileinfo.class).getFileno()); //set the name
        //    uInfo.setEmail(ds.child(userID).getValue(UserInformation.class).getEmail()); //set the email
          //  uInfo.setPhone_num(ds.child(userID).getValue(UserInformation.class).getPhone_num()); //set the phone_num

            //display all the information
       //     Log.d(TAG, "showData: name: " + uInfo.getName());
         //   Log.d(TAG, "showData: email: " + uInfo.getEmail());
           // Log.d(TAG, "showData: phone_num: " + uInfo.getPhone_num());

            Toast.makeText(getApplicationContext(),fInfo.getFileno(),Toast.LENGTH_LONG).show();

            ArrayList<String> array  = new ArrayList<>();
            array.add(fInfo.getFileno());
          //  array.add(uInfo.getEmail());
           // array.add(uInfo.getPhone_num());
            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
            mUserList.setAdapter(adapter);
        }
    }
}