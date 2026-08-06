package com.bytedance.trae.login.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OverseaProfileApi.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;", "", "message", "", "errorCode", "", "description", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getErrorCode", "()I", "getDescription", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class OverseaUpdateProfileResponse {

    @SerializedName("description")
    private final String description;

    @SerializedName("error_code")
    private final int errorCode;

    @SerializedName("message")
    private final String message;

    public OverseaUpdateProfileResponse() {
        this(null, 0, null, 7, null);
    }

    public static /* synthetic */ OverseaUpdateProfileResponse copy$default(OverseaUpdateProfileResponse overseaUpdateProfileResponse, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = overseaUpdateProfileResponse.message;
        }
        if ((i2 & 2) != 0) {
            i = overseaUpdateProfileResponse.errorCode;
        }
        if ((i2 & 4) != 0) {
            str2 = overseaUpdateProfileResponse.description;
        }
        return overseaUpdateProfileResponse.copy(str, i, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component2, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final OverseaUpdateProfileResponse copy(String message, int errorCode, String description) {
        return new OverseaUpdateProfileResponse(message, errorCode, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OverseaUpdateProfileResponse)) {
            return false;
        }
        OverseaUpdateProfileResponse overseaUpdateProfileResponse = (OverseaUpdateProfileResponse) other;
        return Intrinsics.areEqual(this.message, overseaUpdateProfileResponse.message) && this.errorCode == overseaUpdateProfileResponse.errorCode && Intrinsics.areEqual(this.description, overseaUpdateProfileResponse.description);
    }

    public int hashCode() {
        String str = this.message;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.errorCode)) * 31;
        String str2 = this.description;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "OverseaUpdateProfileResponse(message=" + this.message + ", errorCode=" + this.errorCode + ", description=" + this.description + ')';
    }

    public OverseaUpdateProfileResponse(String str, int i, String str2) {
        this.message = str;
        this.errorCode = i;
        this.description = str2;
    }

    public /* synthetic */ OverseaUpdateProfileResponse(String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : str2);
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getDescription() {
        return this.description;
    }
}
