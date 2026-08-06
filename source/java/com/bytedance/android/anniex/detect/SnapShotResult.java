package com.bytedance.android.anniex.detect;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DetectorConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/anniex/detect/SnapShotResult;", "", "isSuccess", "", "errorMsg", "", "(ZLjava/lang/String;)V", "getErrorMsg", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SnapShotResult {
    private final String errorMsg;
    private final boolean isSuccess;

    public static /* synthetic */ SnapShotResult copy$default(SnapShotResult snapShotResult, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = snapShotResult.isSuccess;
        }
        if ((i & 2) != 0) {
            str = snapShotResult.errorMsg;
        }
        return snapShotResult.copy(z, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* renamed from: component2, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final SnapShotResult copy(boolean isSuccess, String errorMsg) {
        return new SnapShotResult(isSuccess, errorMsg);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SnapShotResult)) {
            return false;
        }
        SnapShotResult snapShotResult = (SnapShotResult) other;
        return this.isSuccess == snapShotResult.isSuccess && Intrinsics.areEqual(this.errorMsg, snapShotResult.errorMsg);
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.isSuccess) * 31;
        String str = this.errorMsg;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SnapShotResult(isSuccess=" + this.isSuccess + ", errorMsg=" + this.errorMsg + ')';
    }

    public SnapShotResult(boolean z, String str) {
        this.isSuccess = z;
        this.errorMsg = str;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }
}
