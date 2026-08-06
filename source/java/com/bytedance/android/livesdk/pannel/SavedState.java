package com.bytedance.android.livesdk.pannel;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.bytedance.android.livesdk.pannel.SavedState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new SavedState(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        public SavedState createFromParcel(Parcel parcel) {
            return new SavedState(parcel, (ClassLoader) null);
        }

        @Override // android.os.Parcelable.Creator
        public SavedState[] newArray(int i) {
            return new SavedState[i];
        }
    };
    final int state;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SavedState(Parcel parcel) {
        this(parcel, (ClassLoader) null);
    }

    public SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.state = parcel.readInt();
    }

    public SavedState(Parcelable parcelable, int i) {
        super(parcelable);
        this.state = i;
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.state);
    }
}
