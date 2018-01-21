package com.dev.codehouse.data;

/**
 * Created by wachirapan on 21/1/2018 AD.
 */

public class DataOffline {
    String id ;
    byte[] imgname ;
    String headtxt ;
    String detail ;
    public DataOffline(String id, byte[] image, String headtxt, String detail){
        this.id = id ;
        this.imgname = image ;
        this.headtxt = headtxt ;
        this.detail = detail ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getImgname() {
        return imgname;
    }

    public void setImgname(byte[] imgname) {
        this.imgname = imgname;
    }

    public String getHeadtxt() {
        return headtxt;
    }

    public void setHeadtxt(String headtxt) {
        this.headtxt = headtxt;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
