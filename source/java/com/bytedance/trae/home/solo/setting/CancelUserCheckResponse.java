package com.bytedance.trae.home.solo.setting;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountCancelApi.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÇ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001a\u001a\u00020\u0003H×\u0001J\t\u0010\u001b\u001a\u00020\u0005H×\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/CancelUserCheckResponse;", "", "errorCode", "", "message", "", "description", "data", "Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;)V", "getErrorCode", "()I", "getMessage", "()Ljava/lang/String;", "getDescription", "getData", "()Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CancelUserCheckResponse {
    public static final int $stable = 8;

    @SerializedName("data")
    private final CancelUserCheckData data;

    @SerializedName("description")
    private final String description;

    @SerializedName("error_code")
    private final int errorCode;

    @SerializedName("message")
    private final String message;

    public CancelUserCheckResponse() {
        this(0, null, null, null, 15, null);
    }

    public static /* synthetic */ CancelUserCheckResponse copy$default(CancelUserCheckResponse cancelUserCheckResponse, int i, String str, String str2, CancelUserCheckData cancelUserCheckData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = cancelUserCheckResponse.errorCode;
        }
        if ((i2 & 2) != 0) {
            str = cancelUserCheckResponse.message;
        }
        if ((i2 & 4) != 0) {
            str2 = cancelUserCheckResponse.description;
        }
        if ((i2 & 8) != 0) {
            cancelUserCheckData = cancelUserCheckResponse.data;
        }
        return cancelUserCheckResponse.copy(i, str, str2, cancelUserCheckData);
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

    /* renamed from: component4, reason: from getter */
    public final CancelUserCheckData getData() {
        return this.data;
    }

    public final CancelUserCheckResponse copy(int errorCode, String message, String description, CancelUserCheckData data) {
        return new CancelUserCheckResponse(errorCode, message, description, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CancelUserCheckResponse)) {
            return false;
        }
        CancelUserCheckResponse cancelUserCheckResponse = (CancelUserCheckResponse) other;
        return this.errorCode == cancelUserCheckResponse.errorCode && Intrinsics.areEqual(this.message, cancelUserCheckResponse.message) && Intrinsics.areEqual(this.description, cancelUserCheckResponse.description) && Intrinsics.areEqual(this.data, cancelUserCheckResponse.data);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.errorCode) * 31;
        String str = this.message;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        CancelUserCheckData cancelUserCheckData = this.data;
        return hashCode3 + (cancelUserCheckData != null ? cancelUserCheckData.hashCode() : 0);
    }

    public String toString() {
        return "CancelUserCheckResponse(errorCode=" + this.errorCode + ", message=" + this.message + ", description=" + this.description + ", data=" + this.data + ')';
    }

    public CancelUserCheckResponse(int i, String str, String str2, CancelUserCheckData cancelUserCheckData) {
        this.errorCode = i;
        this.message = str;
        this.description = str2;
        this.data = cancelUserCheckData;
    }

    public /* synthetic */ CancelUserCheckResponse(int i, String str, String str2, CancelUserCheckData cancelUserCheckData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : cancelUserCheckData);
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

    public final CancelUserCheckData getData() {
        return this.data;
    }
}
