package com.vaidya.umesh.forrestapp;

/**
 * Created by umesh on 2/3/18.
 */

public class Fileinfo {
    public String fileno;
    public String filedate;
    public String filereference;
    public String district;
    public String filetitle;
    public String filesubject;
    public String filereceived;
    public String remarks;
    public String fileforwarded;


    public  Fileinfo()
    {

    }


    public Fileinfo(String fileno,String filedate,String filereference,String district,String filetitle,String filesubject,String filereceived,String remarks,String fileforwarded){
        this.fileno=fileno;
        this.filedate=filedate;
        this.filereference=filereference;
        this.district=district;
        this.filetitle=filetitle;
        this.filesubject=filesubject;
        this.filereceived=filereceived;
        this.remarks=remarks;
        this.fileforwarded=fileforwarded;
    }

    public String getFileno() {
        return fileno;
    }

    public void setFileno(String fileno) {
        this.fileno = fileno;
    }

    public String getFiledate() {
        return filedate;
    }

    public void setFiledate(String filedate) {
        this.filedate = filedate;
    }

    public String getFilereference() {
        return filereference;
    }

    public void setFilereference(String filereference) {
        this.filereference = filereference;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getFiletitle() {
        return filetitle;
    }

    public void setFiletitle(String filetitle) {
        this.filetitle = filetitle;
    }

    public String getFilesubject() {
        return filesubject;
    }

    public void setFilesubject(String filesubject) {
        this.filesubject = filesubject;
    }

    public String getFilereceived() {
        return filereceived;
    }

    public void setFilereceived(String filereceived) {
        this.filereceived = filereceived;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFileforwarded() {
        return fileforwarded;
    }

    public void setFileforwarded(String fileforwarded) {
        this.fileforwarded = fileforwarded;
    }
}
