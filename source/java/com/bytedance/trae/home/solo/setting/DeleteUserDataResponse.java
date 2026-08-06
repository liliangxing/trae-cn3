package com.bytedance.trae.home.solo.setting;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountCancelApi.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0012\u001a\u00020\u0003H×\u0001J\t\u0010\u0013\u001a\u00020\u0005H×\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/DeleteUserDataResponse;", "", "errorCode", "", "message", "", "<init>", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DeleteUserDataResponse {
    public static final int $stable = 0;

    @SerializedName("error_code")
    private final int errorCode;

    @SerializedName("message")
    private final String message;

    /* JADX WARN: Multi-variable type inference failed */
    public DeleteUserDataResponse() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DeleteUserDataResponse copy$default(DeleteUserDataResponse deleteUserDataResponse, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = deleteUserDataResponse.errorCode;
        }
        if ((i2 & 2) != 0) {
            str = deleteUserDataResponse.message;
        }
        return deleteUserDataResponse.copy(i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final DeleteUserDataResponse copy(int errorCode, String message) {
        return new DeleteUserDataResponse(errorCode, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeleteUserDataResponse)) {
            return false;
        }
        DeleteUserDataResponse deleteUserDataResponse = (DeleteUserDataResponse) other;
        return this.errorCode == deleteUserDataResponse.errorCode && Intrinsics.areEqual(this.message, deleteUserDataResponse.message);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.errorCode) * 31;
        String str = this.message;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "DeleteUserDataResponse(errorCode=" + this.errorCode + ", message=" + this.message + ')';
    }

    public DeleteUserDataResponse(int i, String str) {
        this.errorCode = i;
        this.message = str;
    }

    public /* synthetic */ DeleteUserDataResponse(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str);
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getMessage() {
        return this.message;
    }
}
