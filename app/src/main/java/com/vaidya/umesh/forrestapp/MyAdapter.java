package com.vaidya.umesh.forrestapp;

/**
 * Created by umesh on 20/3/18.
 */
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

// import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<Upload> uploads;
    private AppPreference mAppPreference;

    public MyAdapter(Context context, List<Upload> uploads) {
        this.uploads = uploads;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_images, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Upload upload = uploads.get(position);

        holder.textViewName.setText(upload.getName());
        holder.textViewDate.setText(upload.getDateAndTime_file());
        holder.textViewUser.setText(upload.getEmail());
        holder.comment.setText(upload.getComment());
        holder.subject.setText(upload.getSubject());
        holder.reference.setText(upload.getReference());
        holder.district.setText(upload.getDistrict());
        holder.receivedfrom.setText(upload.getReceivedfrom());
        holder.remarks.setText(upload.getRemarks());
        holder.forwardedto.setText(upload.getForwardto());
       // Glide.with(context).load(upload.getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return uploads.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public ImageView imageView;
        public TextView textViewDate;
        public TextView textViewUser;
        public TextView comment;
        public TextView subject;
        public TextView reference;
        public TextView district;
        public TextView receivedfrom;
        public TextView remarks;
        public TextView forwardedto;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.Fileno);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textViewDate = (TextView) itemView.findViewById(R.id.textViewDate);
            textViewUser = (TextView) itemView.findViewById(R.id.textViewUser);
            comment = (TextView) itemView.findViewById(R.id.comment);
            subject = (TextView) itemView.findViewById(R.id.subject);
            reference = (TextView) itemView.findViewById(R.id.reference);
            district = (TextView) itemView.findViewById(R.id.district);
            receivedfrom = (TextView) itemView.findViewById(R.id.received);
            remarks = (TextView) itemView.findViewById(R.id.remarks);
            forwardedto = (TextView) itemView.findViewById(R.id.forwarded);

        }
    }
}

