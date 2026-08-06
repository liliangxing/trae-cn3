package com.bytedance.geckox.net;

import android.text.TextUtils;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.iesgurd.statistic.UploadStatistic;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: HttpRequestInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0006HÆ\u0003J'\u0010M\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Q\u001a\u00020 HÖ\u0001J\t\u0010R\u001a\u00020\u0003HÖ\u0001J\u0006\u0010S\u001a\u00020TR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\n\"\u0004\b&\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0016R\u001c\u0010(\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\n\"\u0004\b*\u0010\fR\u001a\u0010+\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u001a\u0010.\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R\u001a\u00101\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018R\u001a\u00104\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018R\u001a\u00107\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0016\"\u0004\b9\u0010\u0018R\u001a\u0010:\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0016\"\u0004\b<\u0010\u0018R\u001a\u0010=\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0016\"\u0004\b?\u0010\u0018R\u001a\u0010@\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0016\"\u0004\bB\u0010\u0018R\u001c\u0010C\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\n\"\u0004\bE\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\nR\u001c\u0010G\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\n\"\u0004\bI\u0010\f¨\u0006U"}, d2 = {"Lcom/bytedance/geckox/net/HttpRequestInfo;", "", "url", "", "cdnDomain", "packageSize", "", "(Ljava/lang/String;Ljava/lang/String;J)V", com.bytedance.bdinstall.Api.KEY_ACCESS, "getAccess", "()Ljava/lang/String;", "setAccess", "(Ljava/lang/String;)V", "getCdnDomain", "clientIP", "getClientIP", "setClientIP", "clientIPVersion", "getClientIPVersion", "setClientIPVersion", "downloadByteCount", "getDownloadByteCount", "()J", "setDownloadByteCount", "(J)V", "downloadDuration", "getDownloadDuration", "setDownloadDuration", "errorCode", "getErrorCode", "setErrorCode", "httpStatus", "", "getHttpStatus", "()I", "setHttpStatus", "(I)V", "isSocketReused", "setSocketReused", "getPackageSize", "serverIP", "getServerIP", "setServerIP", "timingConnect", "getTimingConnect", "setTimingConnect", "timingDns", "getTimingDns", "setTimingDns", "timingProxy", "getTimingProxy", "setTimingProxy", "timingReceive", "getTimingReceive", "setTimingReceive", "timingSend", "getTimingSend", "setTimingSend", "timingSsl", "getTimingSsl", "setTimingSsl", "timingTotal", "getTimingTotal", "setTimingTotal", "timingWait", "getTimingWait", "setTimingWait", "ttTraceLogId", "getTtTraceLogId", "setTtTraceLogId", "getUrl", "xResponseCacheXResponseCache", "getXResponseCacheXResponseCache", "setXResponseCacheXResponseCache", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "upload", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final /* data */ class HttpRequestInfo {
    private String access;
    private final String cdnDomain;
    private String clientIP;
    private String clientIPVersion;
    private long downloadByteCount;
    private long downloadDuration;
    private long errorCode;
    private int httpStatus;
    private String isSocketReused;
    private final long packageSize;
    private String serverIP;
    private long timingConnect;
    private long timingDns;
    private long timingProxy;
    private long timingReceive;
    private long timingSend;
    private long timingSsl;
    private long timingTotal;
    private long timingWait;
    private String ttTraceLogId;
    private final String url;
    private String xResponseCacheXResponseCache;

    public static /* synthetic */ HttpRequestInfo copy$default(HttpRequestInfo httpRequestInfo, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = httpRequestInfo.url;
        }
        if ((i & 2) != 0) {
            str2 = httpRequestInfo.cdnDomain;
        }
        if ((i & 4) != 0) {
            j = httpRequestInfo.packageSize;
        }
        return httpRequestInfo.copy(str, str2, j);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCdnDomain() {
        return this.cdnDomain;
    }

    /* renamed from: component3, reason: from getter */
    public final long getPackageSize() {
        return this.packageSize;
    }

    public final HttpRequestInfo copy(String url, String cdnDomain, long packageSize) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(cdnDomain, "cdnDomain");
        return new HttpRequestInfo(url, cdnDomain, packageSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HttpRequestInfo)) {
            return false;
        }
        HttpRequestInfo httpRequestInfo = (HttpRequestInfo) other;
        return Intrinsics.areEqual(this.url, httpRequestInfo.url) && Intrinsics.areEqual(this.cdnDomain, httpRequestInfo.cdnDomain) && this.packageSize == httpRequestInfo.packageSize;
    }

    public int hashCode() {
        String str = this.url;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.cdnDomain;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        long j = this.packageSize;
        return hashCode2 + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "HttpRequestInfo(url=" + this.url + ", cdnDomain=" + this.cdnDomain + ", packageSize=" + this.packageSize + ")";
    }

    public HttpRequestInfo(String url, String cdnDomain, long j) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(cdnDomain, "cdnDomain");
        this.url = url;
        this.cdnDomain = cdnDomain;
        this.packageSize = j;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getCdnDomain() {
        return this.cdnDomain;
    }

    public final long getPackageSize() {
        return this.packageSize;
    }

    public final String getTtTraceLogId() {
        return this.ttTraceLogId;
    }

    public final void setTtTraceLogId(String str) {
        this.ttTraceLogId = str;
    }

    public final String getXResponseCacheXResponseCache() {
        return this.xResponseCacheXResponseCache;
    }

    public final void setXResponseCacheXResponseCache(String str) {
        this.xResponseCacheXResponseCache = str;
    }

    public final String getClientIP() {
        return this.clientIP;
    }

    public final void setClientIP(String str) {
        this.clientIP = str;
    }

    public final String getClientIPVersion() {
        return this.clientIPVersion;
    }

    public final void setClientIPVersion(String str) {
        this.clientIPVersion = str;
    }

    public final String getServerIP() {
        return this.serverIP;
    }

    public final void setServerIP(String str) {
        this.serverIP = str;
    }

    public final int getHttpStatus() {
        return this.httpStatus;
    }

    public final void setHttpStatus(int i) {
        this.httpStatus = i;
    }

    public final long getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(long j) {
        this.errorCode = j;
    }

    public final long getTimingDns() {
        return this.timingDns;
    }

    public final void setTimingDns(long j) {
        this.timingDns = j;
    }

    public final long getTimingConnect() {
        return this.timingConnect;
    }

    public final void setTimingConnect(long j) {
        this.timingConnect = j;
    }

    public final long getTimingSend() {
        return this.timingSend;
    }

    public final void setTimingSend(long j) {
        this.timingSend = j;
    }

    public final long getTimingSsl() {
        return this.timingSsl;
    }

    public final void setTimingSsl(long j) {
        this.timingSsl = j;
    }

    public final long getTimingWait() {
        return this.timingWait;
    }

    public final void setTimingWait(long j) {
        this.timingWait = j;
    }

    public final long getTimingProxy() {
        return this.timingProxy;
    }

    public final void setTimingProxy(long j) {
        this.timingProxy = j;
    }

    public final long getTimingReceive() {
        return this.timingReceive;
    }

    public final void setTimingReceive(long j) {
        this.timingReceive = j;
    }

    /* renamed from: isSocketReused, reason: from getter */
    public final String getIsSocketReused() {
        return this.isSocketReused;
    }

    public final void setSocketReused(String str) {
        this.isSocketReused = str;
    }

    public final long getTimingTotal() {
        return this.timingTotal;
    }

    public final void setTimingTotal(long j) {
        this.timingTotal = j;
    }

    public final String getAccess() {
        return this.access;
    }

    public final void setAccess(String str) {
        this.access = str;
    }

    public final long getDownloadDuration() {
        return this.downloadDuration;
    }

    public final void setDownloadDuration(long j) {
        this.downloadDuration = j;
    }

    public final long getDownloadByteCount() {
        return this.downloadByteCount;
    }

    public final void setDownloadByteCount(long j) {
        this.downloadByteCount = j;
    }

    public final void upload() {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.ttTraceLogId)) {
            jSONObject.put("tt_trace_tag_id", this.ttTraceLogId);
        }
        if (!TextUtils.isEmpty(this.xResponseCacheXResponseCache)) {
            jSONObject.put("x_response_cache", this.xResponseCacheXResponseCache);
        }
        if (!TextUtils.isEmpty(this.clientIP)) {
            jSONObject.put("client_ip", this.clientIP);
        }
        if (!TextUtils.isEmpty(this.clientIPVersion)) {
            jSONObject.put("client_ip_version", this.clientIPVersion);
        }
        if (!TextUtils.isEmpty(this.serverIP)) {
            jSONObject.put("server_ip", this.serverIP);
        }
        jSONObject.put("http_status", this.httpStatus);
        if (this.httpStatus != 200) {
            jSONObject.put("error_code", this.errorCode);
        }
        jSONObject.put("timing_dns", this.timingDns);
        jSONObject.put("timing_connect", this.timingConnect);
        jSONObject.put("timing_send", this.timingSend);
        jSONObject.put("timing_ssl", this.timingSsl);
        jSONObject.put("timing_wait", this.timingWait);
        jSONObject.put("timing_proxy", this.timingProxy);
        jSONObject.put("timing_receive", this.timingReceive);
        if (!TextUtils.isEmpty(this.isSocketReused)) {
            jSONObject.put("timing_isSocketReused", this.isSocketReused);
        }
        jSONObject.put("timing_total", this.timingTotal);
        if (!TextUtils.isEmpty(this.access)) {
            jSONObject.put(com.bytedance.bdinstall.Api.KEY_ACCESS, this.access);
        }
        jSONObject.put("download_duration", this.downloadDuration);
        jSONObject.put("cdn_domain", this.cdnDomain);
        jSONObject.put("package_size", this.packageSize);
        jSONObject.put("url", this.url);
        UploadStatistic.INSTANCE.uploadEventWithJson("geckosdk_cdn_stats", jSONObject);
    }
}
