package com.bytedance.ug.sdk.share.api.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class UrlList implements Serializable, Parcelable {
    public static final Parcelable.Creator<UrlList> CREATOR = new Parcelable.Creator<UrlList>() { // from class: com.bytedance.ug.sdk.share.api.entity.UrlList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UrlList createFromParcel(Parcel parcel) {
            return new UrlList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UrlList[] newArray(int i) {
            return new UrlList[i];
        }
    };

    @SerializedName("url")
    public String mUrl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mUrl);
    }

    public UrlList() {
    }

    protected UrlList(Parcel parcel) {
        this.mUrl = parcel.readString();
    }
}
