package com.bytedance.trae.home.solo.setting;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrivacyModeApi.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0012\u001a\u00020\u0013H×\u0001J\t\u0010\u0014\u001a\u00020\u0005H×\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/PrivacyModeOperationResponse;", "", "code", "", "message", "", "<init>", "(JLjava/lang/String;)V", "getCode", "()J", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PrivacyModeOperationResponse {
    public static final int $stable = 0;

    @SerializedName("code")
    private final long code;

    @SerializedName("message")
    private final String message;

    public PrivacyModeOperationResponse() {
        this(0L, null, 3, null);
    }

    public static /* synthetic */ PrivacyModeOperationResponse copy$default(PrivacyModeOperationResponse privacyModeOperationResponse, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = privacyModeOperationResponse.code;
        }
        if ((i & 2) != 0) {
            str = privacyModeOperationResponse.message;
        }
        return privacyModeOperationResponse.copy(j, str);
    }

    /* renamed from: component1, reason: from getter */
    public final long getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final PrivacyModeOperationResponse copy(long code, String message) {
        return new PrivacyModeOperationResponse(code, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrivacyModeOperationResponse)) {
            return false;
        }
        PrivacyModeOperationResponse privacyModeOperationResponse = (PrivacyModeOperationResponse) other;
        return this.code == privacyModeOperationResponse.code && Intrinsics.areEqual(this.message, privacyModeOperationResponse.message);
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.code) * 31;
        String str = this.message;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "PrivacyModeOperationResponse(code=" + this.code + ", message=" + this.message + ')';
    }

    public PrivacyModeOperationResponse(long j, String str) {
        this.code = j;
        this.message = str;
    }

    public /* synthetic */ PrivacyModeOperationResponse(long j, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str);
    }

    public final long getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }
}
