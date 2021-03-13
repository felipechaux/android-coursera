package com.example.contactformapp;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String name;
    private String birthDate;
    private String phone;
    private String email;
    private String descriptionContact;

    public User(String name, String birthDate, String phone, String email, String descriptionContact) {
        this.name = name;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.descriptionContact = descriptionContact;
    }

    protected User(Parcel in) {
        name = in.readString();
        birthDate = in.readString();
        phone = in.readString();
        email = in.readString();
        descriptionContact = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(birthDate);
        dest.writeString(phone);
        dest.writeString(email);
        dest.writeString(descriptionContact);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescriptionContact() {
        return descriptionContact;
    }

    public void setDescriptionContact(String descriptionContact) {
        this.descriptionContact = descriptionContact;
    }
}
