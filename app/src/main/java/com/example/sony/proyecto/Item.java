package com.example.sony.proyecto;

/**
 * Created by SONY on 10/05/2017.
 */

public class Item {

    private String userName, userId;
    private int userPictureId;

    public Item(String uId, String uname, int upictureid) {
        userName = uname;
        userId = uId;
        userPictureId = upictureid;
    }

    public String getUserName(){return userName;}
    public void setUserName(String name) {userName = name;}
    public int getUserPictureId() {return userPictureId;}
    public void setPictureId(int pictureId) {userPictureId = pictureId;}
    public String getUserId() {return userId;}
    public void setUserId(String uId) {userId = uId;}

}
