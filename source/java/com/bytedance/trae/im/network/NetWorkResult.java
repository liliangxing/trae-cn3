package com.bytedance.trae.im.network;

import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.timonbase.scene.PageDataManager;
import java.io.BufferedReader;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NetWorkResult.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u0004\u0018\u00010\u0003J\b\u0010!\u001a\u0004\u0018\u00010\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\u0017\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jq\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0005HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u0006/"}, d2 = {"Lcom/bytedance/trae/im/network/NetWorkResult;", "", IWeixinService.ResponseConstants.URL, "", PageDataManager.EXTRA_STATUS, "", "headers", "", "body", "message", "stream", "Ljava/io/BufferedReader;", "exception", "", "originRequestUrl", "<init>", "(Ljava/lang/String;ILjava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/io/BufferedReader;Ljava/lang/Throwable;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getStatus", "()I", "getHeaders", "()Ljava/util/Map;", "getBody", "getMessage", "getStream", "()Ljava/io/BufferedReader;", "getException", "()Ljava/lang/Throwable;", "getOriginRequestUrl", "isSuccessful", "", "acquireLogId", "acquireLDeviceId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class NetWorkResult {
    private final String body;
    private final Throwable exception;
    private final Map<String, String> headers;
    private final String message;
    private final String originRequestUrl;
    private final int status;
    private final BufferedReader stream;
    private final String url;

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    public final Map<String, String> component3() {
        return this.headers;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component6, reason: from getter */
    public final BufferedReader getStream() {
        return this.stream;
    }

    /* renamed from: component7, reason: from getter */
    public final Throwable getException() {
        return this.exception;
    }

    /* renamed from: component8, reason: from getter */
    public final String getOriginRequestUrl() {
        return this.originRequestUrl;
    }

    public final NetWorkResult copy(String url, int status, Map<String, String> headers, String body, String message, BufferedReader stream, Throwable exception, String originRequestUrl) {
        Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
        return new NetWorkResult(url, status, headers, body, message, stream, exception, originRequestUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetWorkResult)) {
            return false;
        }
        NetWorkResult netWorkResult = (NetWorkResult) other;
        return Intrinsics.areEqual(this.url, netWorkResult.url) && this.status == netWorkResult.status && Intrinsics.areEqual(this.headers, netWorkResult.headers) && Intrinsics.areEqual(this.body, netWorkResult.body) && Intrinsics.areEqual(this.message, netWorkResult.message) && Intrinsics.areEqual(this.stream, netWorkResult.stream) && Intrinsics.areEqual(this.exception, netWorkResult.exception) && Intrinsics.areEqual(this.originRequestUrl, netWorkResult.originRequestUrl);
    }

    public int hashCode() {
        int hashCode = ((this.url.hashCode() * 31) + Integer.hashCode(this.status)) * 31;
        Map<String, String> map = this.headers;
        int hashCode2 = (hashCode + (map == null ? 0 : map.hashCode())) * 31;
        String str = this.body;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.message;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        BufferedReader bufferedReader = this.stream;
        int hashCode5 = (hashCode4 + (bufferedReader == null ? 0 : bufferedReader.hashCode())) * 31;
        Throwable th = this.exception;
        int hashCode6 = (hashCode5 + (th == null ? 0 : th.hashCode())) * 31;
        String str3 = this.originRequestUrl;
        return hashCode6 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "NetWorkResult(url=" + this.url + ", status=" + this.status + ", headers=" + this.headers + ", body=" + this.body + ", message=" + this.message + ", stream=" + this.stream + ", exception=" + this.exception + ", originRequestUrl=" + this.originRequestUrl + ')';
    }

    public NetWorkResult(String str, int i, Map<String, String> map, String str2, String str3, BufferedReader bufferedReader, Throwable th, String str4) {
        Intrinsics.checkNotNullParameter(str, IWeixinService.ResponseConstants.URL);
        this.url = str;
        this.status = i;
        this.headers = map;
        this.body = str2;
        this.message = str3;
        this.stream = bufferedReader;
        this.exception = th;
        this.originRequestUrl = str4;
    }

    public /* synthetic */ NetWorkResult(String str, int i, Map map, String str2, String str3, BufferedReader bufferedReader, Throwable th, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, map, str2, str3, (i2 & 32) != 0 ? null : bufferedReader, (i2 & 64) != 0 ? null : th, (i2 & 128) != 0 ? null : str4);
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getStatus() {
        return this.status;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getMessage() {
        return this.message;
    }

    public final BufferedReader getStream() {
        return this.stream;
    }

    public final Throwable getException() {
        return this.exception;
    }

    public final String getOriginRequestUrl() {
        return this.originRequestUrl;
    }

    public final boolean isSuccessful() {
        int i = this.status;
        return 200 <= i && i < 300;
    }

    public final String acquireLogId() {
        Map<String, String> map = this.headers;
        String str = map != null ? map.get(XBridgeAPIRequestUtils.X_TT_LOG_ID) : null;
        return str == null ? "" : str;
    }

    public final String acquireLDeviceId() {
        String str = this.originRequestUrl;
        if (str == null) {
            str = "";
        }
        if (StringsKt.isBlank(str)) {
            return null;
        }
        return "";
    }
}
