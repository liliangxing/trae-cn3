package com.example.kmp.shared.sha;

import com.bytedance.forest.model.PreloadConfig;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TTHttpRequestBridge.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0006HÆ\u0003J\u001b\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t0\bHÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\fHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0006HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u008b\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\u0006HÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR,\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001eR\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018¨\u0006F"}, d2 = {"Lcom/example/kmp/shared/sha/BridgeResponse;", "", "url", "", MonitorConstants.PROTOCOL, "responseCode", "", "responseHeaders", "", "Lkotlin/Pair;", "responseContentType", "responseContentLength", "", "bodyByteArray", "", "requestLog", "logId", "errorCode", "errorMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;J[BLjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getProtocol", "setProtocol", "getResponseCode", "()I", "setResponseCode", "(I)V", "getResponseHeaders", "()Ljava/util/List;", "setResponseHeaders", "(Ljava/util/List;)V", "getResponseContentType", "setResponseContentType", "getResponseContentLength", "()J", "setResponseContentLength", "(J)V", "getBodyByteArray", "()[B", "setBodyByteArray", "([B)V", "getRequestLog", "setRequestLog", "getLogId", "setLogId", "getErrorCode", "setErrorCode", "getErrorMessage", "setErrorMessage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "kmpNativeBridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class BridgeResponse {
    private byte[] bodyByteArray;
    private int errorCode;
    private String errorMessage;
    private String logId;
    private String protocol;
    private String requestLog;
    private int responseCode;
    private long responseContentLength;
    private String responseContentType;
    private List<Pair<String, String>> responseHeaders;
    private String url;

    public BridgeResponse() {
        this(null, null, 0, null, null, 0L, null, null, null, 0, null, 2047, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component10, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component11, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: component2, reason: from getter */
    public final String getProtocol() {
        return this.protocol;
    }

    /* renamed from: component3, reason: from getter */
    public final int getResponseCode() {
        return this.responseCode;
    }

    public final List<Pair<String, String>> component4() {
        return this.responseHeaders;
    }

    /* renamed from: component5, reason: from getter */
    public final String getResponseContentType() {
        return this.responseContentType;
    }

    /* renamed from: component6, reason: from getter */
    public final long getResponseContentLength() {
        return this.responseContentLength;
    }

    /* renamed from: component7, reason: from getter */
    public final byte[] getBodyByteArray() {
        return this.bodyByteArray;
    }

    /* renamed from: component8, reason: from getter */
    public final String getRequestLog() {
        return this.requestLog;
    }

    /* renamed from: component9, reason: from getter */
    public final String getLogId() {
        return this.logId;
    }

    public final BridgeResponse copy(String url, String protocol, int responseCode, List<Pair<String, String>> responseHeaders, String responseContentType, long responseContentLength, byte[] bodyByteArray, String requestLog, String logId, int errorCode, String errorMessage) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(responseContentType, "responseContentType");
        Intrinsics.checkNotNullParameter(requestLog, "requestLog");
        Intrinsics.checkNotNullParameter(logId, "logId");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        return new BridgeResponse(url, protocol, responseCode, responseHeaders, responseContentType, responseContentLength, bodyByteArray, requestLog, logId, errorCode, errorMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BridgeResponse)) {
            return false;
        }
        BridgeResponse bridgeResponse = (BridgeResponse) other;
        return Intrinsics.areEqual(this.url, bridgeResponse.url) && Intrinsics.areEqual(this.protocol, bridgeResponse.protocol) && this.responseCode == bridgeResponse.responseCode && Intrinsics.areEqual(this.responseHeaders, bridgeResponse.responseHeaders) && Intrinsics.areEqual(this.responseContentType, bridgeResponse.responseContentType) && this.responseContentLength == bridgeResponse.responseContentLength && Intrinsics.areEqual(this.bodyByteArray, bridgeResponse.bodyByteArray) && Intrinsics.areEqual(this.requestLog, bridgeResponse.requestLog) && Intrinsics.areEqual(this.logId, bridgeResponse.logId) && this.errorCode == bridgeResponse.errorCode && Intrinsics.areEqual(this.errorMessage, bridgeResponse.errorMessage);
    }

    public int hashCode() {
        int hashCode = ((((((((((this.url.hashCode() * 31) + this.protocol.hashCode()) * 31) + Integer.hashCode(this.responseCode)) * 31) + this.responseHeaders.hashCode()) * 31) + this.responseContentType.hashCode()) * 31) + Long.hashCode(this.responseContentLength)) * 31;
        byte[] bArr = this.bodyByteArray;
        return ((((((((hashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31) + this.requestLog.hashCode()) * 31) + this.logId.hashCode()) * 31) + Integer.hashCode(this.errorCode)) * 31) + this.errorMessage.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BridgeResponse(url=");
        sb.append(this.url).append(", protocol=").append(this.protocol).append(", responseCode=").append(this.responseCode).append(", responseHeaders=").append(this.responseHeaders).append(", responseContentType=").append(this.responseContentType).append(", responseContentLength=").append(this.responseContentLength).append(", bodyByteArray=").append(Arrays.toString(this.bodyByteArray)).append(", requestLog=").append(this.requestLog).append(", logId=").append(this.logId).append(", errorCode=").append(this.errorCode).append(", errorMessage=").append(this.errorMessage).append(')');
        return sb.toString();
    }

    public BridgeResponse(String url, String protocol, int i, List<Pair<String, String>> responseHeaders, String responseContentType, long j, byte[] bArr, String requestLog, String logId, int i2, String errorMessage) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(responseContentType, "responseContentType");
        Intrinsics.checkNotNullParameter(requestLog, "requestLog");
        Intrinsics.checkNotNullParameter(logId, "logId");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        this.url = url;
        this.protocol = protocol;
        this.responseCode = i;
        this.responseHeaders = responseHeaders;
        this.responseContentType = responseContentType;
        this.responseContentLength = j;
        this.bodyByteArray = bArr;
        this.requestLog = requestLog;
        this.logId = logId;
        this.errorCode = i2;
        this.errorMessage = errorMessage;
    }

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

    public /* synthetic */ BridgeResponse(String str, String str2, int i, List list, String str3, long j, byte[] bArr, String str4, String str5, int i2, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "unknown" : str2, (i3 & 4) != 0 ? -1 : i, (i3 & 8) != 0 ? CollectionsKt.emptyList() : list, (i3 & 16) != 0 ? "" : str3, (i3 & 32) != 0 ? -1L : j, (i3 & 64) != 0 ? null : bArr, (i3 & 128) != 0 ? "" : str4, (i3 & 256) != 0 ? "" : str5, (i3 & 512) != 0 ? 0 : i2, (i3 & 1024) == 0 ? str6 : "");
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
