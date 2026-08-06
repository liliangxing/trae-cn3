package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class ServiceParcelable implements Parcelable {
    public static final Parcelable.Creator<ServiceParcelable> CREATOR = new Parcelable.Creator<ServiceParcelable>() { // from class: com.bytedance.common.wschannel.model.ServiceParcelable.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ServiceParcelable createFromParcel(Parcel parcel) {
            return new ServiceParcelable(parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ServiceParcelable[] newArray(int i) {
            return new ServiceParcelable[i];
        }
    };
    private final int mChannelId;
    private final int mServiceId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ServiceParcelable(int i, int i2) {
        this.mChannelId = i;
        this.mServiceId = i2;
    }

    public int getChannelId() {
        return this.mChannelId;
    }

    public int getServiceId() {
        return this.mServiceId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mChannelId);
        parcel.writeInt(this.mServiceId);
    }
}
