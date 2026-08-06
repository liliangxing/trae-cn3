package com.bytedance.timonbase.network;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Response.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\nR\u001a\u0010\t\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/timonbase/network/Response;", ExifInterface.GPS_DIRECTION_TRUE, "", "message", "", "extra", "Lcom/google/gson/JsonObject;", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "data", "(Ljava/lang/String;Lcom/google/gson/JsonObject;ILjava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getExtra", "()Lcom/google/gson/JsonObject;", "getMessage", "()Ljava/lang/String;", "getStatusCode", "()I", "succeed", "", "getSucceed", "()Z", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class Response<T> {

    @SerializedName("data")
    private final T data;

    @SerializedName("extra")
    private final JsonObject extra;

    @SerializedName("message")
    private final String message;

    @SerializedName("status_code")
    private final int statusCode;

    public Response(String message, JsonObject extra, int i, T t) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(extra, "extra");
        this.message = message;
        this.extra = extra;
        this.statusCode = i;
        this.data = t;
    }

    public final String getMessage() {
        return this.message;
    }

    public final JsonObject getExtra() {
        return this.extra;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final T getData() {
        return this.data;
    }

    public final boolean getSucceed() {
        return this.statusCode == 0;
    }
}
