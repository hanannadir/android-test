package com.example.android.imagejson.model;

import com.google.gson.annotations.SerializedName;

public class SourceBean {
    /**
     * id : the-wall-street-journal
     * name : The Wall Street Journal
     */

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
