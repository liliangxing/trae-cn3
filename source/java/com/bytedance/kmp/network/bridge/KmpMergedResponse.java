package com.bytedance.kmp.network.bridge;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpMergedResponse.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/kmp/network/bridge/KmpMergedResponse;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "clientErrorCode", "", "getClientErrorCode", "()I", "setClientErrorCode", "(I)V", "clientMessage", "", "getClientMessage", "()Ljava/lang/String;", "setClientMessage", "(Ljava/lang/String;)V", "code", "getCode", "setCode", "data", "getData", "()Ljava/lang/Object;", AirActionConstant.ActionId.ACTION_ID_NAME_SET_DATA, "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "error", "getError", "setError", "message", "getMessage", "setMessage", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KmpMergedResponse<T> {
    private int clientErrorCode;
    private int code;
    private T data;
    private String message = "";
    private String clientMessage = "";
    private String error = "";

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final int getClientErrorCode() {
        return this.clientErrorCode;
    }

    public final void setClientErrorCode(int i) {
        this.clientErrorCode = i;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public final String getClientMessage() {
        return this.clientMessage;
    }

    public final void setClientMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clientMessage = str;
    }

    public final String getError() {
        return this.error;
    }

    public final void setError(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.error = str;
    }

    public final T getData() {
        return this.data;
    }

    public final void setData(T t) {
        this.data = t;
    }
}
