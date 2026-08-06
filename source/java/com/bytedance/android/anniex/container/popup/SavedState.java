package com.bytedance.android.anniex.container.popup;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SavedState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/SavedState;", "Landroidx/customview/view/AbsSavedState;", "superState", "Landroid/os/Parcelable;", "state", "", "(Landroid/os/Parcelable;I)V", "getState", "()I", "writeToParcel", "", "out", "Landroid/os/Parcel;", RouterConstants.QUERY_KEY_FLAGS, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class SavedState extends AbsSavedState {
    private final int state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SavedState(Parcelable superState, int i) {
        super(superState);
        Intrinsics.checkNotNullParameter(superState, "superState");
        this.state = i;
    }

    public final int getState() {
        return this.state;
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, flags);
        out.writeInt(this.state);
    }
}
