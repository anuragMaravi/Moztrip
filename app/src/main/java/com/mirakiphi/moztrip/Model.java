package com.mirakiphi.moztrip;

/**
 * Created by anuragmaravi on 07/04/17.
 */

public class Model {
    public Model(){}

    private String tpName,
    tpPlaceID,
    tpRating,
    tpReference;


    public String getTpName() {
        return tpName;
    }

    public void setTpName(String tpName) {
        this.tpName = tpName;
    }

    public String getTpPlaceID() {
        return tpPlaceID;
    }

    public void setTpPlaceID(String tpPlaceID) {
        this.tpPlaceID = tpPlaceID;
    }

    public String getTpRating() {
        return tpRating;
    }

    public void setTpRating(String tpRating) {
        this.tpRating = tpRating;
    }

    public String getTpReference() {
        return tpReference;
    }

    public void setTpReference(String tpReference) {
        this.tpReference = tpReference;
    }
}
