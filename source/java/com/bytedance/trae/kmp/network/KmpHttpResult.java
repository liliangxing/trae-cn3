package com.bytedance.trae.kmp.network;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.forest.model.PreloadConfig;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpHttpResult.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BI\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003Jb\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÇ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0002H×\u0003J\t\u0010&\u001a\u00020\u0007H×\u0001J\t\u0010'\u001a\u00020\u0005H×\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lcom/bytedance/trae/kmp/network/KmpHttpResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "data", "rawBody", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "statusMessage", "headers", "", "error", "", "<init>", "(Ljava/lang/Object;Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;Ljava/lang/Throwable;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getRawBody", "()Ljava/lang/String;", "getStatusCode", "()I", "getStatusMessage", "getHeaders", "()Ljava/util/Map;", "getError", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Object;Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;Ljava/lang/Throwable;)Lcom/bytedance/trae/kmp/network/KmpHttpResult;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class KmpHttpResult<T> {
    public static final int $stable = 8;
    private final T data;
    private final Throwable error;
    private final Map<String, String> headers;
    private final String rawBody;
    private final int statusCode;
    private final String statusMessage;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KmpHttpResult copy$default(KmpHttpResult kmpHttpResult, Object obj, String str, int i, String str2, Map map, Throwable th, int i2, Object obj2) {
        T t = obj;
        if ((i2 & 1) != 0) {
            t = kmpHttpResult.data;
        }
        if ((i2 & 2) != 0) {
            str = kmpHttpResult.rawBody;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            i = kmpHttpResult.statusCode;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str2 = kmpHttpResult.statusMessage;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            map = kmpHttpResult.headers;
        }
        Map map2 = map;
        if ((i2 & 32) != 0) {
            th = kmpHttpResult.error;
        }
        return kmpHttpResult.copy(t, str3, i3, str4, map2, th);
    }

    public final T component1() {
        return this.data;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRawBody() {
        return this.rawBody;
    }

    /* renamed from: component3, reason: from getter */
    public final int getStatusCode() {
        return this.statusCode;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStatusMessage() {
        return this.statusMessage;
    }

    public final Map<String, String> component5() {
        return this.headers;
    }

    /* renamed from: component6, reason: from getter */
    public final Throwable getError() {
        return this.error;
    }

    public final KmpHttpResult<T> copy(T data, String rawBody, int statusCode, String statusMessage, Map<String, String> headers, Throwable error) {
        Intrinsics.checkNotNullParameter(statusMessage, "statusMessage");
        Intrinsics.checkNotNullParameter(headers, "headers");
        return new KmpHttpResult<>(data, rawBody, statusCode, statusMessage, headers, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KmpHttpResult)) {
            return false;
        }
        KmpHttpResult kmpHttpResult = (KmpHttpResult) other;
        return Intrinsics.areEqual(this.data, kmpHttpResult.data) && Intrinsics.areEqual(this.rawBody, kmpHttpResult.rawBody) && this.statusCode == kmpHttpResult.statusCode && Intrinsics.areEqual(this.statusMessage, kmpHttpResult.statusMessage) && Intrinsics.areEqual(this.headers, kmpHttpResult.headers) && Intrinsics.areEqual(this.error, kmpHttpResult.error);
    }

    public int hashCode() {
        T t = this.data;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        String str = this.rawBody;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.statusCode)) * 31) + this.statusMessage.hashCode()) * 31) + this.headers.hashCode()) * 31;
        Throwable th = this.error;
        return hashCode2 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "KmpHttpResult(data=" + this.data + ", rawBody=" + this.rawBody + ", statusCode=" + this.statusCode + ", statusMessage=" + this.statusMessage + ", headers=" + this.headers + ", error=" + this.error + ')';
    }

    public KmpHttpResult(T t, String str, int i, String statusMessage, Map<String, String> headers, Throwable th) {
        Intrinsics.checkNotNullParameter(statusMessage, "statusMessage");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.data = t;
        this.rawBody = str;
        this.statusCode = i;
        this.statusMessage = statusMessage;
        this.headers = headers;
        this.error = th;
    }

    public final T getData() {
        return this.data;
    }

    public final String getRawBody() {
        return this.rawBody;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMessage() {
        return this.statusMessage;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final Throwable getError() {
        return this.error;
    }
}
