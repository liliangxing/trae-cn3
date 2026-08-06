package com.bytedance.iesgurd;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IESGurdDefines.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/iesgurd/IESGurdUpdateChannelInfo;", "", "success", "", "version", "", "errorMessage", "", "(ZJLjava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "getSuccess", "()Z", "getVersion", "()J", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final /* data */ class IESGurdUpdateChannelInfo {
    private final String errorMessage;
    private final boolean success;
    private final long version;

    public static /* synthetic */ IESGurdUpdateChannelInfo copy$default(IESGurdUpdateChannelInfo iESGurdUpdateChannelInfo, boolean z, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = iESGurdUpdateChannelInfo.success;
        }
        if ((i & 2) != 0) {
            j = iESGurdUpdateChannelInfo.version;
        }
        if ((i & 4) != 0) {
            str = iESGurdUpdateChannelInfo.errorMessage;
        }
        return iESGurdUpdateChannelInfo.copy(z, j, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final long getVersion() {
        return this.version;
    }

    /* renamed from: component3, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final IESGurdUpdateChannelInfo copy(boolean success, long version, String errorMessage) {
        return new IESGurdUpdateChannelInfo(success, version, errorMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IESGurdUpdateChannelInfo)) {
            return false;
        }
        IESGurdUpdateChannelInfo iESGurdUpdateChannelInfo = (IESGurdUpdateChannelInfo) other;
        return this.success == iESGurdUpdateChannelInfo.success && this.version == iESGurdUpdateChannelInfo.version && Intrinsics.areEqual(this.errorMessage, iESGurdUpdateChannelInfo.errorMessage);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.success;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        long j = this.version;
        int i = ((r0 * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str = this.errorMessage;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "IESGurdUpdateChannelInfo(success=" + this.success + ", version=" + this.version + ", errorMessage=" + this.errorMessage + ")";
    }

    public IESGurdUpdateChannelInfo(boolean z, long j, String str) {
        this.success = z;
        this.version = j;
        this.errorMessage = str;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final long getVersion() {
        return this.version;
    }
}
