package com.bytedance.trae.home.solo.setting;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountCancelApi.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÇ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0015\u001a\u00020\u0003H×\u0001J\t\u0010\u0016\u001a\u00020\u0005H×\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/CancelConfirmResponse;", "", "errorCode", "", "message", "", "description", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getErrorCode", "()I", "getMessage", "()Ljava/lang/String;", "getDescription", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CancelConfirmResponse {
    public static final int $stable = 0;

    @SerializedName("description")
    private final String description;

    @SerializedName("error_code")
    private final int errorCode;

    @SerializedName("message")
    private final String message;

    public CancelConfirmResponse() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ CancelConfirmResponse copy$default(CancelConfirmResponse cancelConfirmResponse, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = cancelConfirmResponse.errorCode;
        }
        if ((i2 & 2) != 0) {
            str = cancelConfirmResponse.message;
        }
        if ((i2 & 4) != 0) {
            str2 = cancelConfirmResponse.description;
        }
        return cancelConfirmResponse.copy(i, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final CancelConfirmResponse copy(int errorCode, String message, String description) {
        return new CancelConfirmResponse(errorCode, message, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CancelConfirmResponse)) {
            return false;
        }
        CancelConfirmResponse cancelConfirmResponse = (CancelConfirmResponse) other;
        return this.errorCode == cancelConfirmResponse.errorCode && Intrinsics.areEqual(this.message, cancelConfirmResponse.message) && Intrinsics.areEqual(this.description, cancelConfirmResponse.description);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.errorCode) * 31;
        String str = this.message;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "CancelConfirmResponse(errorCode=" + this.errorCode + ", message=" + this.message + ", description=" + this.description + ')';
    }

    public CancelConfirmResponse(int i, String str, String str2) {
        this.errorCode = i;
        this.message = str;
        this.description = str2;
    }

    public /* synthetic */ CancelConfirmResponse(int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2);
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getDescription() {
        return this.description;
    }
}
