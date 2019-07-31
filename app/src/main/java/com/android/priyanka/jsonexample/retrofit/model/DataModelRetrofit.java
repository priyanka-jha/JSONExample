package com.android.priyanka.jsonexample.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataModelRetrofit {

    @SerializedName("worldpopulation")
    @Expose
    private List<Worldpopulation> worldpopulation = null;

    public DataModelRetrofit() {
    }

    public DataModelRetrofit(List<Worldpopulation> worldpopulation) {
        super();
        this.worldpopulation = worldpopulation;
    }

    public List<Worldpopulation> getWorldpopulation() {
        return worldpopulation;
    }

    public void setWorldpopulation(List<Worldpopulation> worldpopulation) {
        this.worldpopulation = worldpopulation;
    }

    public static class Worldpopulation {
        @SerializedName("rank")
        @Expose
        private Integer rank;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("population")
        @Expose
        private String population;
        @SerializedName("flag")
        @Expose
        private String flag_url;

        public Worldpopulation() {
        }

        public Worldpopulation(Integer rank, String country, String population, String flag_url) {
            this.rank = rank;
            this.country = country;
            this.population = population;
            this.flag_url = flag_url;
        }

        public Integer getRank() {
            return rank;
        }

        public void setRank(Integer rank) {
            this.rank = rank;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
            System.out.println("model.."+country);

        }

        public String getPopulation() {
            return population;
        }

        public void setPopulation(String population) {
            this.population = population;
        }

        public String getFlag_url() {
            return flag_url;
        }

        public void setFlag_url(String flag_url) {
            this.flag_url = flag_url;
        }
    }
}