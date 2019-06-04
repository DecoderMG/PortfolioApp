package com.dakota.gallimore.portfolio

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Dakota on 10/26/2017.
 */

class ChildEducation : Parcelable {
    var header: String? = null
    var date: String? = null
    var details: String? = null

    constructor(headerIn: String, dateIn: String, detailsIn: String) {
        header = headerIn
        date = dateIn
        details = detailsIn
    }

    protected constructor(`in`: Parcel) {
        header = `in`.readString()
        date = `in`.readString()
        details = `in`.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(this.header)
        parcel.writeString(this.date)
        parcel.writeString(this.details)
    }

    companion object {

        val CREATOR: Parcelable.Creator<ChildEducation> = object : Parcelable.Creator<ChildEducation> {
            override fun createFromParcel(`in`: Parcel): ChildEducation {
                return ChildEducation(`in`)
            }

            override fun newArray(size: Int): Array<ChildEducation?> {
                return arrayOfNulls(size)
            }
        }
    }

}
