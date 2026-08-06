package com.bytedance.apm.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class SpPair implements Parcelable {
    public static final Parcelable.Creator<SpPair> CREATOR = new Parcelable.Creator<SpPair>() { // from class: com.bytedance.apm.core.SpPair.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SpPair createFromParcel(Parcel parcel) {
            return new SpPair(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SpPair[] newArray(int i) {
            return new SpPair[i];
        }
    };
    public String mKey;
    public Object mValue;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SpPair(String str, Object obj) {
        this.mKey = str;
        this.mValue = obj;
    }

    protected SpPair(Parcel parcel) {
        this.mKey = parcel.readString();
        this.mValue = parcel.readValue(getClass().getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mKey);
        parcel.writeValue(this.mValue);
    }
}
