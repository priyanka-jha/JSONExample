package com.android.priyanka.jsonexample.retrofit.model;

import com.android.priyanka.jsonexample.retrofit.model.DataModelRetrofit;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataModelRetrofit2 {
    @SerializedName("worldpopulation")
    @Expose
    private List<DataModelRetrofit> worldpopulation = null;

    public DataModelRetrofit2() {
    }

    public DataModelRetrofit2(List<DataModelRetrofit> worldpopulation) {
        this.worldpopulation = worldpopulation;
    }

    public List<DataModelRetrofit> getWorldpopulation() {
        return worldpopulation;
    }

    public void setWorldpopulation(List<DataModelRetrofit> worldpopulation) {
        this.worldpopulation = worldpopulation;
    }
}
