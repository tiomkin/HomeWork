package by.tut.tiomkin.homework9.models;


import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Address {

    @SerializedName("Address")
    private String address;

    private String objectId;
    private Date updated;
    private Date created;
    private String ownerId;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getUpdated() {
        return updated;
    }

    public Date getCreated() {
        return created;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getOwnerId() {
        return ownerId;
    }
}
