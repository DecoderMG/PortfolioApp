package com.dakota.gallimore.portfolio;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dakota on 10/26/2017.
 */

public class ChildEducation implements Parcelable {

    public static final Creator<ChildEducation> CREATOR = new Creator<ChildEducation>() {
        @Override
        public ChildEducation createFromParcel(Parcel in) {
            return new ChildEducation(in);
        }

        @Override
        public ChildEducation[] newArray(int size) {
            return new ChildEducation[size];
        }
    };
    private String header;
    private String date;
    private String details;

    public ChildEducation(String headerIn, String dateIn, String detailsIn) {
        header = headerIn;
        date = dateIn;
        details = detailsIn;
    }

    protected ChildEducation(Parcel in) {
        header = in.readString();
        date = in.readString();
        details = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.header);
        parcel.writeString(this.date);
        parcel.writeString(this.details);
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
