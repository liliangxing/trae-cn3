package com.bytedance.trae.kmp.host;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpMediaLibrary.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÇ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0010\u001a\u00020\u0011H×\u0001J\t\u0010\u0012\u001a\u00020\u0005H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;", "", "isSuccess", "", "errorMessage", "", "<init>", "(ZLjava/lang/String;)V", "()Z", "getErrorMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class KmpMediaLibrarySaveResult {
    public static final int $stable = 0;
    private final String errorMessage;
    private final boolean isSuccess;

    public static /* synthetic */ KmpMediaLibrarySaveResult copy$default(KmpMediaLibrarySaveResult kmpMediaLibrarySaveResult, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = kmpMediaLibrarySaveResult.isSuccess;
        }
        if ((i & 2) != 0) {
            str = kmpMediaLibrarySaveResult.errorMessage;
        }
        return kmpMediaLibrarySaveResult.copy(z, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* renamed from: component2, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final KmpMediaLibrarySaveResult copy(boolean isSuccess, String errorMessage) {
        return new KmpMediaLibrarySaveResult(isSuccess, errorMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KmpMediaLibrarySaveResult)) {
            return false;
        }
        KmpMediaLibrarySaveResult kmpMediaLibrarySaveResult = (KmpMediaLibrarySaveResult) other;
        return this.isSuccess == kmpMediaLibrarySaveResult.isSuccess && Intrinsics.areEqual(this.errorMessage, kmpMediaLibrarySaveResult.errorMessage);
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.isSuccess) * 31;
        String str = this.errorMessage;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "KmpMediaLibrarySaveResult(isSuccess=" + this.isSuccess + ", errorMessage=" + this.errorMessage + ')';
    }

    public KmpMediaLibrarySaveResult(boolean z, String str) {
        this.isSuccess = z;
        this.errorMessage = str;
    }

    public /* synthetic */ KmpMediaLibrarySaveResult(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : str);
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }
}
