package com.bytedance.gkfs.io;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: meta.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSStatus;", "", "isSuccess", "", "error", "", "errorCode", "Lcom/bytedance/gkfs/io/GkFSError;", "(ZLjava/lang/Throwable;Lcom/bytedance/gkfs/io/GkFSError;)V", "getError", "()Ljava/lang/Throwable;", "getErrorCode", "()Lcom/bytedance/gkfs/io/GkFSError;", "()Z", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final /* data */ class GkFSStatus {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final GkFSStatus SUCCESS = new GkFSStatus(true, null, GkFSError.NO_ERROR);
    private final Throwable error;
    private final GkFSError errorCode;
    private final boolean isSuccess;

    public static /* synthetic */ GkFSStatus copy$default(GkFSStatus gkFSStatus, boolean z, Throwable th, GkFSError gkFSError, int i, Object obj) {
        if ((i & 1) != 0) {
            z = gkFSStatus.isSuccess;
        }
        if ((i & 2) != 0) {
            th = gkFSStatus.error;
        }
        if ((i & 4) != 0) {
            gkFSError = gkFSStatus.errorCode;
        }
        return gkFSStatus.copy(z, th, gkFSError);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* renamed from: component2, reason: from getter */
    public final Throwable getError() {
        return this.error;
    }

    /* renamed from: component3, reason: from getter */
    public final GkFSError getErrorCode() {
        return this.errorCode;
    }

    public final GkFSStatus copy(boolean isSuccess, Throwable error, GkFSError errorCode) {
        Intrinsics.checkParameterIsNotNull(errorCode, "errorCode");
        return new GkFSStatus(isSuccess, error, errorCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GkFSStatus)) {
            return false;
        }
        GkFSStatus gkFSStatus = (GkFSStatus) other;
        return this.isSuccess == gkFSStatus.isSuccess && Intrinsics.areEqual(this.error, gkFSStatus.error) && Intrinsics.areEqual(this.errorCode, gkFSStatus.errorCode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.isSuccess;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        Throwable th = this.error;
        int hashCode = (i + (th != null ? th.hashCode() : 0)) * 31;
        GkFSError gkFSError = this.errorCode;
        return hashCode + (gkFSError != null ? gkFSError.hashCode() : 0);
    }

    public String toString() {
        return "GkFSStatus(isSuccess=" + this.isSuccess + ", error=" + this.error + ", errorCode=" + this.errorCode + ")";
    }

    public GkFSStatus(boolean z, Throwable th, GkFSError errorCode) {
        Intrinsics.checkParameterIsNotNull(errorCode, "errorCode");
        this.isSuccess = z;
        this.error = th;
        this.errorCode = errorCode;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public final Throwable getError() {
        return this.error;
    }

    public final GkFSError getErrorCode() {
        return this.errorCode;
    }

    /* compiled from: meta.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSStatus$Companion;", "", "()V", "SUCCESS", "Lcom/bytedance/gkfs/io/GkFSStatus;", "getSUCCESS", "()Lcom/bytedance/gkfs/io/GkFSStatus;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GkFSStatus getSUCCESS() {
            return GkFSStatus.SUCCESS;
        }
    }
}
