package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class NewMsgTimeHolder implements Parcelable {
    public static final Parcelable.Creator<NewMsgTimeHolder> CREATOR = new Parcelable.Creator<NewMsgTimeHolder>() { // from class: com.bytedance.common.wschannel.model.NewMsgTimeHolder.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NewMsgTimeHolder createFromParcel(Parcel parcel) {
            return new NewMsgTimeHolder(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NewMsgTimeHolder[] newArray(int i) {
            return new NewMsgTimeHolder[i];
        }
    };
    public final long endDecodeTs;
    public final long receiveRawDataTs;
    public final long startDecodeTs;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public NewMsgTimeHolder(long j, long j2, long j3) {
        this.receiveRawDataTs = j;
        this.startDecodeTs = j2;
        this.endDecodeTs = j3;
    }

    protected NewMsgTimeHolder(Parcel parcel) {
        this.receiveRawDataTs = parcel.readLong();
        this.startDecodeTs = parcel.readLong();
        this.endDecodeTs = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.receiveRawDataTs);
        parcel.writeLong(this.startDecodeTs);
        parcel.writeLong(this.endDecodeTs);
    }
}
