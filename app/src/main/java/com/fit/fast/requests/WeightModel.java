package com.fit.fast.requests;

import com.google.gson.annotations.SerializedName;

public class WeightModel {

    @SerializedName("id_user")
    private String id;

    @SerializedName("weight")
    private String weight;

    public WeightModel(String id, String weight) {
        this.id = id;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "WeightModel{" +
                "id='" + id + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
