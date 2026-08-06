package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class IntegerParcelable implements Parcelable {
    public static final Parcelable.Creator<IntegerParcelable> CREATOR = new Parcelable.Creator<IntegerParcelable>() { // from class: com.bytedance.common.wschannel.model.IntegerParcelable.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntegerParcelable createFromParcel(Parcel parcel) {
            return new IntegerParcelable(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntegerParcelable[] newArray(int i) {
            return new IntegerParcelable[i];
        }
    };
    private final int mData;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IntegerParcelable(int i) {
        this.mData = i;
    }

    protected IntegerParcelable(Parcel parcel) {
        this.mData = parcel.readInt();
    }

    public int getData() {
        return this.mData;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mData);
    }
}
