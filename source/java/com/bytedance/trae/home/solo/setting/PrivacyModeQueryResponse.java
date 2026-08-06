package com.bytedance.trae.home.solo.setting;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrivacyModeApi.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0015\u001a\u00020\u0016H×\u0001J\t\u0010\u0017\u001a\u00020\u0003H×\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;", "", "privacyStatus", "", "code", "", "message", "<init>", "(Ljava/lang/String;JLjava/lang/String;)V", "getPrivacyStatus", "()Ljava/lang/String;", "getCode", "()J", "getMessage", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PrivacyModeQueryResponse {
    public static final int $stable = 0;

    @SerializedName("code")
    private final long code;

    @SerializedName("message")
    private final String message;

    @SerializedName("privacy_status")
    private final String privacyStatus;

    public PrivacyModeQueryResponse() {
        this(null, 0L, null, 7, null);
    }

    public static /* synthetic */ PrivacyModeQueryResponse copy$default(PrivacyModeQueryResponse privacyModeQueryResponse, String str, long j, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = privacyModeQueryResponse.privacyStatus;
        }
        if ((i & 2) != 0) {
            j = privacyModeQueryResponse.code;
        }
        if ((i & 4) != 0) {
            str2 = privacyModeQueryResponse.message;
        }
        return privacyModeQueryResponse.copy(str, j, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPrivacyStatus() {
        return this.privacyStatus;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCode() {
        return this.code;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final PrivacyModeQueryResponse copy(String privacyStatus, long code, String message) {
        return new PrivacyModeQueryResponse(privacyStatus, code, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrivacyModeQueryResponse)) {
            return false;
        }
        PrivacyModeQueryResponse privacyModeQueryResponse = (PrivacyModeQueryResponse) other;
        return Intrinsics.areEqual(this.privacyStatus, privacyModeQueryResponse.privacyStatus) && this.code == privacyModeQueryResponse.code && Intrinsics.areEqual(this.message, privacyModeQueryResponse.message);
    }

    public int hashCode() {
        String str = this.privacyStatus;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + Long.hashCode(this.code)) * 31;
        String str2 = this.message;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "PrivacyModeQueryResponse(privacyStatus=" + this.privacyStatus + ", code=" + this.code + ", message=" + this.message + ')';
    }

    public PrivacyModeQueryResponse(String str, long j, String str2) {
        this.privacyStatus = str;
        this.code = j;
        this.message = str2;
    }

    public /* synthetic */ PrivacyModeQueryResponse(String str, long j, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? null : str2);
    }

    public final String getPrivacyStatus() {
        return this.privacyStatus;
    }

    public final long getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }
}
