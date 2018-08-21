package com.vaidya.umesh.forrestapp;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class SearchActivity extends AppCompatActivity {

    private EditText mSearchField;
    private ImageButton mSearchBtn;

    private RecyclerView mResultList;
    private DatabaseReference mUserDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
       /* mUserDatabase=FirebaseDatabase.getInstance().getReference("uploads");

        mSearchField = (EditText) findViewById(R.id.search_field);
        mSearchBtn = (ImageButton) findViewById(R.id.search_btn);

        mResultList = (RecyclerView) findViewById(R.id.result_list);
        mResultList.setHasFixedSize(true);
        mResultList.setLayoutManager(new LinearLayoutManager(this));
        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseUserSearch();
            }
        });*/
    }
   /* private void firebaseUserSearch(String searchText) {

        Toast.makeText(SearchActivity.this, "Started Search", Toast.LENGTH_LONG).show();

        Query firebaseSearchQuery = mUserDatabase.orderByChild("fileno").startAt(searchText).endAt(searchText + "\uf8ff");

        FirebaseRecyclerAdapter<Users, UsersViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Users, UsersViewHolder>(

                Users.class,
                R.layout.list_layout,
                UsersViewHolder.class,
                firebaseSearchQuery

        ){
            @Override
            protected void onBindViewHolder(UsersViewHolder holder, int position, Users model) {
               // holder.setPersonFirstName(model.getName());
              //  holder.setPersonLastName(model.getComment());
                holder.setDetails(getApplicationContext(),model.getName(), model.getComment(), model.getSubject());

            }

            @Override
            public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_layout, parent, false);

                return new UsersViewHolder(view);
            }
        };

        mResultList.setAdapter(firebaseRecyclerAdapter);
    }

    //
    public class UsersViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public UsersViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
        }
        public void setDetails(Context applicationContext, String name, String comment, String subject) {
            TextView file_no=(TextView)mView.findViewById(R.id.fileno);
            TextView file_title=(TextView)mView.findViewById(R.id.filetitle);
            TextView file_subject=(TextView)mView.findViewById(R.id.filesubject);


            file_no.setText(name);
            file_title.setText(comment);
            file_subject.setText(subject);
        }
       /* public  void setDetails(String fileno,String filetitle,String filesubject){
            TextView file_no=(TextView)mView.findViewById(R.id.fileno);
            TextView file_title=(TextView)mView.findViewById(R.id.filetitle);
            TextView file_subject=(TextView)mView.findViewById(R.id.filesubject);


            file_no.setText(fileno);
            file_title.setText(filetitle);
            file_subject.setText(filesubject);*/
      /*  }


    }*/

}
/*
    DatabaseReference personsRef = FirebaseDatabase.getInstance().getReference().child("People");
    Query personsQuery = personsRef.orderByKey();

    mPeopleRV.hasFixedSize();
    mPeopleRV.setLayoutManager(new LinearLayoutManager(getActivity()));

    FirebaseRecyclerOptions personsOptions = new FirebaseRecyclerOptions.Builder<PersonModel>().setQuery(personsQuery, PersonModel.class).build();

    mPeopleRVAdapter = new FirebaseRecyclerAdapter<PersonModel, PeopleVH>(personsOptions) {
        @Override
        protected void onBindViewHolder(PeopleVH holder, int position, PersonModel model) {
            holder.setPersonFirstName(model.getFirstName());
            holder.setPersonLastName(model.getLastName());
        }

        @Override
        public PeopleVH onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_people_rv, parent, false);

            return new PeopleVH(view);
        }
    };

    mPeopleRV.setAdapter(mPeopleRVAdapter);*/
