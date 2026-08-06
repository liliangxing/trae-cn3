package com.example.interopdemo.response;

import com.bytedance.android.monitorV2.constant.ReportConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NativeResponse.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0015\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00020\u0003J\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030 J\b\u0010!\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006\""}, d2 = {"Lcom/example/interopdemo/response/NativeResponse;", "", "url", "", "httpStatusCode", "", "headers", "", "Lkotlin/Pair;", ReportConst.ValidationReport.BODY, "", "logId", "requestLog", "errorCode", "errorMessage", "<init>", "(Ljava/lang/String;ILjava/util/List;[BLjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getHttpStatusCode", "()I", "getHeaders", "()Ljava/util/List;", "getBody", "()[B", "getLogId", "getRequestLog", "getErrorCode", "getErrorMessage", "getHeader", "key", "getHeadersMap", "", "toString", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NativeResponse {
    private final byte[] body;
    private final int errorCode;
    private final String errorMessage;
    private final List<Pair<String, String>> headers;
    private final int httpStatusCode;
    private final String logId;
    private final String requestLog;
    private final String url;

    public NativeResponse() {
        this(null, 0, null, null, null, null, 0, null, 255, null);
    }

    public NativeResponse(String url, int i, List<Pair<String, String>> headers, byte[] bArr, String logId, String requestLog, int i2, String errorMessage) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(logId, "logId");
        Intrinsics.checkNotNullParameter(requestLog, "requestLog");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        this.url = url;
        this.httpStatusCode = i;
        this.headers = headers;
        this.body = bArr;
        this.logId = logId;
        this.requestLog = requestLog;
        this.errorCode = i2;
        this.errorMessage = errorMessage;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public /* synthetic */ NativeResponse(String str, int i, List list, byte[] bArr, String str2, String str3, int i2, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? -1 : i, (i3 & 4) != 0 ? new ArrayList() : list, (i3 & 8) != 0 ? null : bArr, (i3 & 16) != 0 ? "" : str2, (i3 & 32) != 0 ? "" : str3, (i3 & 64) != 0 ? 0 : i2, (i3 & 128) == 0 ? str4 : "");
    }

    public final List<Pair<String, String>> getHeaders() {
        return this.headers;
    }

    public final byte[] getBody() {
        return this.body;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getRequestLog() {
        return this.requestLog;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getHeader(String key) {
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        Iterator<T> it = this.headers.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (StringsKt.equals((String) ((Pair) obj).getFirst(), key, true)) {
                break;
            }
        }
        Pair pair = (Pair) obj;
        if (pair != null) {
            return (String) pair.getSecond();
        }
        return null;
    }

    public final Map<String, String> getHeadersMap() {
        return MapsKt.toMap(this.headers);
    }

    public String toString() {
        return "NativeResponse(url='" + this.url + "', httpStatusCode=" + this.httpStatusCode + ", headers=" + this.headers + ", logId='" + this.logId + "', requestLog='" + this.requestLog + "', errorCode=" + this.errorCode + ", errorMessage='" + this.errorMessage + "')";
    }
}
