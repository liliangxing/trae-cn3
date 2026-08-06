package com.bytedance.iesgurd;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IESGurdResData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/bytedance/iesgurd/IESGurdResError;", "", "offlineCode", "", "offlineMessage", "", "cdnCode", "cdnMessage", "(ILjava/lang/String;ILjava/lang/String;)V", "getCdnCode", "()I", "setCdnCode", "(I)V", "getCdnMessage", "()Ljava/lang/String;", "setCdnMessage", "(Ljava/lang/String;)V", "getOfflineCode", "getOfflineMessage", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final /* data */ class IESGurdResError {
    private int cdnCode;
    private String cdnMessage;
    private final int offlineCode;
    private final String offlineMessage;

    public IESGurdResError() {
        this(0, null, 0, null, 15, null);
    }

    public static /* synthetic */ IESGurdResError copy$default(IESGurdResError iESGurdResError, int i, String str, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = iESGurdResError.offlineCode;
        }
        if ((i3 & 2) != 0) {
            str = iESGurdResError.offlineMessage;
        }
        if ((i3 & 4) != 0) {
            i2 = iESGurdResError.cdnCode;
        }
        if ((i3 & 8) != 0) {
            str2 = iESGurdResError.cdnMessage;
        }
        return iESGurdResError.copy(i, str, i2, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getOfflineCode() {
        return this.offlineCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getOfflineMessage() {
        return this.offlineMessage;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCdnCode() {
        return this.cdnCode;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCdnMessage() {
        return this.cdnMessage;
    }

    public final IESGurdResError copy(int offlineCode, String offlineMessage, int cdnCode, String cdnMessage) {
        return new IESGurdResError(offlineCode, offlineMessage, cdnCode, cdnMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IESGurdResError)) {
            return false;
        }
        IESGurdResError iESGurdResError = (IESGurdResError) other;
        return this.offlineCode == iESGurdResError.offlineCode && Intrinsics.areEqual(this.offlineMessage, iESGurdResError.offlineMessage) && this.cdnCode == iESGurdResError.cdnCode && Intrinsics.areEqual(this.cdnMessage, iESGurdResError.cdnMessage);
    }

    public int hashCode() {
        int i = this.offlineCode * 31;
        String str = this.offlineMessage;
        int hashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.cdnCode) * 31;
        String str2 = this.cdnMessage;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "IESGurdResError(offlineCode=" + this.offlineCode + ", offlineMessage=" + this.offlineMessage + ", cdnCode=" + this.cdnCode + ", cdnMessage=" + this.cdnMessage + ")";
    }

    public IESGurdResError(int i, String str, int i2, String str2) {
        this.offlineCode = i;
        this.offlineMessage = str;
        this.cdnCode = i2;
        this.cdnMessage = str2;
    }

    public final int getOfflineCode() {
        return this.offlineCode;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ IESGurdResError(int i, String str, int i2, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, i2, str2);
        i = (i3 & 1) != 0 ? 0 : i;
        if ((i3 & 2) != 0) {
            str = null;
        }
        i2 = (i3 & 4) != 0 ? 0 : i2;
        if ((i3 & 8) != 0) {
            str2 = null;
        }
    }

    public final String getOfflineMessage() {
        return this.offlineMessage;
    }

    public final int getCdnCode() {
        return this.cdnCode;
    }

    public final void setCdnCode(int i) {
        this.cdnCode = i;
    }

    public final String getCdnMessage() {
        return this.cdnMessage;
    }

    public final void setCdnMessage(String str) {
        this.cdnMessage = str;
    }
}
