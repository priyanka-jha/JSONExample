package com.android.priyanka.jsonexample.volley.model;

public class DataModel {

    private String country;

    private String flag_url;

    private String rank;

    private String population;

    public DataModel() {
    }

    public DataModel(String country, String flag, String rank, String population) {
        this.country = country;
        this.flag_url = flag;
        this.rank = rank;
        this.population = population;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getFlag_url()
    {
        return flag_url;
    }

    public void setFlag_url(String flag_url)
    {
        this.flag_url = flag_url;
    }

    public String getRank ()
    {
        return rank;
    }

    public void setRank (String rank)
    {
        this.rank = rank;
    }

    public String getPopulation ()
    {
        return population;
    }

    public void setPopulation (String population)
    {
        this.population = population;
    }
}
