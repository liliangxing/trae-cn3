package com.bytedance.kmp.network.bridge;

import com.bytedance.kmp.network.KmpRequestMetrics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpRequest.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BQ\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bBY\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eBa\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007J\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0010J\u0006\u0010\u0016\u001a\u00020\u0003J\u0006\u0010\u0017\u001a\u00020\u0003J\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007J\u0006\u0010\u0019\u001a\u00020\rJ\u0006\u0010\u001a\u001a\u00020\u001bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/kmp/network/bridge/KmpRequest;", "", "host", "", "path", "method", "headers", "", "queries", "body", "Lcom/bytedance/kmp/network/bridge/KmpRequestBody;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/kmp/network/bridge/KmpRequestBody;)V", "reqConfig", "Lcom/bytedance/kmp/network/bridge/KmpRequestConfig;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/kmp/network/bridge/KmpRequestBody;Lcom/bytedance/kmp/network/bridge/KmpRequestConfig;)V", "kmpRequestMetrics", "Lcom/bytedance/kmp/network/KmpRequestMetrics;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/kmp/network/bridge/KmpRequestBody;Lcom/bytedance/kmp/network/bridge/KmpRequestConfig;Lcom/bytedance/kmp/network/KmpRequestMetrics;)V", "getBody", "getHeaders", "getHost", "getKmpRequestMetrics", "getMethod", "getPath", "getQueries", "getReqConfig", "newBuilder", "Lcom/bytedance/kmp/network/bridge/RequestBuilder;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpRequest {
    private final KmpRequestBody body;
    private final Map<String, String> headers;
    private final String host;
    private final KmpRequestMetrics kmpRequestMetrics;
    private final String method;
    private final String path;
    private final Map<String, String> queries;
    private final KmpRequestConfig reqConfig;

    public KmpRequest(String str, String str2, String str3, Map<String, String> map, Map<String, String> map2, KmpRequestBody kmpRequestBody, KmpRequestConfig kmpRequestConfig, KmpRequestMetrics kmpRequestMetrics) {
        Intrinsics.checkNotNullParameter(str, "host");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(str3, "method");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(map2, "queries");
        Intrinsics.checkNotNullParameter(kmpRequestConfig, "reqConfig");
        Intrinsics.checkNotNullParameter(kmpRequestMetrics, "kmpRequestMetrics");
        this.host = str;
        this.path = str2;
        this.method = str3;
        this.headers = map;
        this.queries = map2;
        this.body = kmpRequestBody;
        this.reqConfig = kmpRequestConfig;
        this.kmpRequestMetrics = kmpRequestMetrics;
    }

    public /* synthetic */ KmpRequest(String str, String str2, String str3, Map map, Map map2, KmpRequestBody kmpRequestBody, KmpRequestConfig kmpRequestConfig, KmpRequestMetrics kmpRequestMetrics, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, map, map2, kmpRequestBody, kmpRequestConfig, (i & 128) != 0 ? new KmpRequestMetrics() : kmpRequestMetrics);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KmpRequest(String str, String str2, String str3, Map<String, String> map, Map<String, String> map2, KmpRequestBody kmpRequestBody) {
        this(str, str2, str3, map, map2, kmpRequestBody, new KmpRequestConfig());
        Intrinsics.checkNotNullParameter(str, "host");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(str3, "method");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(map2, "queries");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KmpRequest(String str, String str2, String str3, Map<String, String> map, Map<String, String> map2, KmpRequestBody kmpRequestBody, KmpRequestConfig kmpRequestConfig) {
        this(str, str2, str3, map, map2, kmpRequestBody, kmpRequestConfig, new KmpRequestMetrics());
        Intrinsics.checkNotNullParameter(str, "host");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(str3, "method");
        Intrinsics.checkNotNullParameter(map, "headers");
        Intrinsics.checkNotNullParameter(map2, "queries");
        Intrinsics.checkNotNullParameter(kmpRequestConfig, "reqConfig");
    }

    public final RequestBuilder newBuilder() {
        return new RequestBuilder(this);
    }

    public final String getHost() {
        return this.host;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getMethod() {
        return this.method;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final Map<String, String> getQueries() {
        return this.queries;
    }

    public final KmpRequestBody getBody() {
        return this.body;
    }

    public final KmpRequestConfig getReqConfig() {
        return this.reqConfig;
    }

    public final KmpRequestMetrics getKmpRequestMetrics() {
        return this.kmpRequestMetrics;
    }
}
