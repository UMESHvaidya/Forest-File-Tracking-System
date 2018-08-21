package com.vaidya.umesh.forrestapp;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Belal on 8/25/2017.
 */

@IgnoreExtraProperties
public class Upload{

    public String name;
    public String url;
    public String email;
    private String dateAndTime;
    public String comment;
    public String subject;
    public String reference;
    public String district;
    public String receivedfrom;
    public String remarks;
    public String forwardto;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public Upload() {
    }

    public Upload(String name, String url) {
        this.name = name;
        this.url= url;
    }

    /*  public Upload(String name, String url,String dateAndTime,String email) {
          this.dateAndTime = dateAndTime;
          this.name = name;
          this.url= url;
          this.email=email;
      }
  */
    public Upload(String name,String dateAndTime,String email,String comment,String subject,String reference,String district,String receivedfrom,String remarks,String forwardto) {
        this.dateAndTime = dateAndTime;
        this.name = name;
        this.email=email;
        this.comment=comment;
        this.subject=subject;
        this.reference=reference;
        this.district=district;
        this.receivedfrom=receivedfrom;
        this.remarks=remarks;
        this.forwardto=forwardto;
    }

    public Upload(String name, String url,String dateAndTime,String email,String comment,String subject,String reference,String district,String receivedfrom,String remarks,String forwardto) {
        this.dateAndTime = dateAndTime;
        this.name = name;
        this.url= url;
        this.email=email;
        this.comment=comment;
        this.subject=subject;
        this.reference=reference;
        this.district=district;
        this.receivedfrom=receivedfrom;
        this.remarks=remarks;
        this.forwardto=forwardto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateAndTime_file() {
        return dateAndTime;
    }

    public void setDateAndTime_file(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getName() {
        return name;
    }
    public String getSubject() {
        return subject;
    }


    public String getUrl() {
        return url;
    }

    public String getComment() {
        return comment;
    }
    public String getReference() {
        return reference;
    }
    public String getDistrict() {
        return district;
    }
    public String getReceivedfrom() {
        return receivedfrom;
    }
    public String getRemarks() {
        return remarks;
    }
    public String getForwardto() {
        return forwardto;
    }


}