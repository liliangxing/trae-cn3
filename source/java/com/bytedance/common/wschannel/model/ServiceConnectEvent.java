package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class ServiceConnectEvent implements Parcelable {
    public static final Parcelable.Creator<ServiceConnectEvent> CREATOR = new Parcelable.Creator<ServiceConnectEvent>() { // from class: com.bytedance.common.wschannel.model.ServiceConnectEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ServiceConnectEvent createFromParcel(Parcel parcel) {
            return new ServiceConnectEvent(parcel.readInt(), parcel.readInt(), parcel.readByte() != 0, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ServiceConnectEvent[] newArray(int i) {
            return new ServiceConnectEvent[i];
        }
    };
    private final int mChannelId;
    private final boolean mConnected;
    private final String mLogInfo;
    private final int mServiceId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ServiceConnectEvent(int i, int i2, boolean z, String str) {
        this.mChannelId = i;
        this.mServiceId = i2;
        this.mConnected = z;
        this.mLogInfo = str;
    }

    public int getChannelId() {
        return this.mChannelId;
    }

    public int getServiceId() {
        return this.mServiceId;
    }

    public boolean isServiceConnected() {
        return this.mConnected;
    }

    public String getLogInfo() {
        return this.mLogInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mChannelId);
        parcel.writeInt(this.mServiceId);
        parcel.writeByte(this.mConnected ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mLogInfo);
    }

    public String toString() {
        return "ServiceConnectEvent{mChannelId=" + this.mChannelId + ", mServiceId=" + this.mServiceId + ", mConnected=" + this.mConnected + ", mLogInfo='" + this.mLogInfo + "'}";
    }
}
