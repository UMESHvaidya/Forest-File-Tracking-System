package com.vaidya.umesh.forrestapp;

/**
 * Created by umesh on 17/3/18.
 */
public class Users {
    public Users() {
    }

    public String name, comment, subject;

    public Users(String name, String comment, String subject) {
        this.name = name;
        this.comment = comment;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}