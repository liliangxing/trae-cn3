package com.bytedance.trae.kmp.network;

import com.bytedance.forest.model.PreloadConfig;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpRawHttpClient.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003JK\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÇ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001f\u001a\u00020\u0005H×\u0001J\t\u0010 \u001a\u00020\u0003H×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/bytedance/trae/kmp/network/KmpRawHttpResult;", "", "rawBody", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "statusMessage", "headers", "", "error", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;Ljava/lang/Throwable;)V", "getRawBody", "()Ljava/lang/String;", "getStatusCode", "()I", "getStatusMessage", "getHeaders", "()Ljava/util/Map;", "getError", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class KmpRawHttpResult {
    public static final int $stable = 8;
    private final Throwable error;
    private final Map<String, String> headers;
    private final String rawBody;
    private final int statusCode;
    private final String statusMessage;

    public static /* synthetic */ KmpRawHttpResult copy$default(KmpRawHttpResult kmpRawHttpResult, String str, int i, String str2, Map map, Throwable th, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = kmpRawHttpResult.rawBody;
        }
        if ((i2 & 2) != 0) {
            i = kmpRawHttpResult.statusCode;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str2 = kmpRawHttpResult.statusMessage;
        }
        String str3 = str2;
        if ((i2 & 8) != 0) {
            map = kmpRawHttpResult.headers;
        }
        Map map2 = map;
        if ((i2 & 16) != 0) {
            th = kmpRawHttpResult.error;
        }
        return kmpRawHttpResult.copy(str, i3, str3, map2, th);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRawBody() {
        return this.rawBody;
    }

    /* renamed from: component2, reason: from getter */
    public final int getStatusCode() {
        return this.statusCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getStatusMessage() {
        return this.statusMessage;
    }

    public final Map<String, String> component4() {
        return this.headers;
    }

    /* renamed from: component5, reason: from getter */
    public final Throwable getError() {
        return this.error;
    }

    public final KmpRawHttpResult copy(String rawBody, int statusCode, String statusMessage, Map<String, String> headers, Throwable error) {
        Intrinsics.checkNotNullParameter(statusMessage, "statusMessage");
        Intrinsics.checkNotNullParameter(headers, "headers");
        return new KmpRawHttpResult(rawBody, statusCode, statusMessage, headers, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KmpRawHttpResult)) {
            return false;
        }
        KmpRawHttpResult kmpRawHttpResult = (KmpRawHttpResult) other;
        return Intrinsics.areEqual(this.rawBody, kmpRawHttpResult.rawBody) && this.statusCode == kmpRawHttpResult.statusCode && Intrinsics.areEqual(this.statusMessage, kmpRawHttpResult.statusMessage) && Intrinsics.areEqual(this.headers, kmpRawHttpResult.headers) && Intrinsics.areEqual(this.error, kmpRawHttpResult.error);
    }

    public int hashCode() {
        String str = this.rawBody;
        int hashCode = (((((((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.statusCode)) * 31) + this.statusMessage.hashCode()) * 31) + this.headers.hashCode()) * 31;
        Throwable th = this.error;
        return hashCode + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "KmpRawHttpResult(rawBody=" + this.rawBody + ", statusCode=" + this.statusCode + ", statusMessage=" + this.statusMessage + ", headers=" + this.headers + ", error=" + this.error + ')';
    }

    public KmpRawHttpResult(String str, int i, String statusMessage, Map<String, String> headers, Throwable th) {
        Intrinsics.checkNotNullParameter(statusMessage, "statusMessage");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.rawBody = str;
        this.statusCode = i;
        this.statusMessage = statusMessage;
        this.headers = headers;
        this.error = th;
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
