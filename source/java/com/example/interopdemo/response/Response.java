package com.example.interopdemo.response;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Response.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R,\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00150\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010\tR\u001a\u0010,\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010\tR\u001a\u0010/\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0010\"\u0004\b1\u0010\u0012R\u001a\u00102\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0007\"\u0004\b4\u0010\t¨\u00065"}, d2 = {"Lcom/example/interopdemo/response/Response;", "", "<init>", "()V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", MonitorConstants.PROTOCOL, "getProtocol", "setProtocol", "responseCode", "", "getResponseCode", "()I", "setResponseCode", "(I)V", "responseHeaders", "", "Lkotlin/Pair;", "getResponseHeaders", "()Ljava/util/List;", "setResponseHeaders", "(Ljava/util/List;)V", "responseContentType", "getResponseContentType", "setResponseContentType", "responseContentLength", "", "getResponseContentLength", "()J", "setResponseContentLength", "(J)V", "bodyByteArray", "", "getBodyByteArray", "()[B", "setBodyByteArray", "([B)V", "requestLog", "getRequestLog", "setRequestLog", "logId", "getLogId", "setLogId", "errorCode", "getErrorCode", "setErrorCode", "errorMessage", "getErrorMessage", "setErrorMessage", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Response {
    private byte[] bodyByteArray;
    private int errorCode;
    private String url = "";
    private String protocol = "unknown";
    private int responseCode = -1;
    private List<Pair<String, String>> responseHeaders = CollectionsKt.emptyList();
    private String responseContentType = "";
    private long responseContentLength = -1;
    private String requestLog = "";
    private String logId = "";
    private String errorMessage = "";

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final void setProtocol(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.protocol = str;
    }

    public final int getResponseCode() {
        return this.responseCode;
    }

    public final void setResponseCode(int i) {
        this.responseCode = i;
    }

    public final List<Pair<String, String>> getResponseHeaders() {
        return this.responseHeaders;
    }

    public final void setResponseHeaders(List<Pair<String, String>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.responseHeaders = list;
    }

    public final String getResponseContentType() {
        return this.responseContentType;
    }

    public final void setResponseContentType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.responseContentType = str;
    }

    public final long getResponseContentLength() {
        return this.responseContentLength;
    }

    public final void setResponseContentLength(long j) {
        this.responseContentLength = j;
    }

    public final byte[] getBodyByteArray() {
        return this.bodyByteArray;
    }

    public final void setBodyByteArray(byte[] bArr) {
        this.bodyByteArray = bArr;
    }

    public final String getRequestLog() {
        return this.requestLog;
    }

    public final void setRequestLog(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.requestLog = str;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final void setLogId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.logId = str;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(int i) {
        this.errorCode = i;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errorMessage = str;
    }
}
