package com.copasso.billbook.bean;

public class BUser extends BaseBean{
    private Integer id;

    private String username;

    private String password;

    private String image;

    private String gender;

    private String phone;

    private String mail;

    private Integer state;

    private String mailcode;

    private String phonecode;

    public BUser(){
        super();
    }

    public BUser(Integer id, String image) {
        this.id = id;
        this.image = image;
    }

    public BUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public BUser(String username, String password, String mail) {
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    public BUser(Integer id, String username, String gender, String phone, String mail) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.phone = phone;
        this.mail = mail;
    }

    public BUser(Integer id, String username,
                 String password, String image,
                 String gender, String phone,
                 String mail, Integer state,
                 String mailcode, String phonecode) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.image = image;
        this.gender = gender;
        this.phone = phone;
        this.mail = mail;
        this.state = state;
        this.mailcode = mailcode;
        this.phonecode = phonecode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMailcode() {
        return mailcode;
    }

    public void setMailcode(String mailcode) {
        this.mailcode = mailcode == null ? null : mailcode.trim();
    }

    public String getPhonecode() {
        return phonecode;
    }

    public void setPhonecode(String phonecode) {
        this.phonecode = phonecode == null ? null : phonecode.trim();
    }
}