package com.bytedance.kmp.network.bridge;

import com.bytedance.kmp.network.KmpRequestMetrics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpRequest.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0012\u001a\u00020\u0003J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bJ\u0006\u0010\u0015\u001a\u00020\tJ\u0006\u0010\u0016\u001a\u00020\fJ\u0006\u0010\u0017\u001a\u00020\tJ\u0006\u0010\u0018\u001a\u00020\tJ\u0006\u0010\u0019\u001a\u00020\u0011J\u001a\u0010\u0007\u001a\u00020\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\tJ\u001a\u0010\u000f\u001a\u00020\u00002\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/kmp/network/bridge/RequestBuilder;", "", "request", "Lcom/bytedance/kmp/network/bridge/KmpRequest;", "(Lcom/bytedance/kmp/network/bridge/KmpRequest;)V", "body", "Lcom/bytedance/kmp/network/bridge/KmpRequestBody;", "headers", "", "", "host", "kmpRequestMetrics", "Lcom/bytedance/kmp/network/KmpRequestMetrics;", "method", "path", "queries", "reqConfig", "Lcom/bytedance/kmp/network/bridge/KmpRequestConfig;", "build", "getBody", "getHeaders", "getHost", "getKmpRequestMetrics", "getMethod", "getPath", "getReqConfig", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RequestBuilder {
    private KmpRequestBody body;
    private Map<String, String> headers;
    private String host;
    private KmpRequestMetrics kmpRequestMetrics;
    private String method;
    private String path;
    private Map<String, String> queries;
    private KmpRequestConfig reqConfig;

    public RequestBuilder(KmpRequest kmpRequest) {
        Intrinsics.checkNotNullParameter(kmpRequest, "request");
        this.host = "";
        this.path = "";
        this.method = "";
        this.headers = MapsKt.emptyMap();
        this.queries = MapsKt.emptyMap();
        this.reqConfig = new KmpRequestConfig();
        this.kmpRequestMetrics = new KmpRequestMetrics();
        this.host = kmpRequest.getHost();
        this.path = kmpRequest.getPath();
        this.method = kmpRequest.getMethod();
        this.headers = kmpRequest.getHeaders();
        this.queries = kmpRequest.getQueries();
        this.body = kmpRequest.getBody();
        this.reqConfig = kmpRequest.getReqConfig();
        this.kmpRequestMetrics = kmpRequest.getKmpRequestMetrics();
    }

    public final RequestBuilder host(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        this.host = host;
        return this;
    }

    public final String getHost() {
        return this.host;
    }

    public final RequestBuilder path(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
        return this;
    }

    public final String getPath() {
        return this.path;
    }

    public final RequestBuilder method(String method) {
        Intrinsics.checkNotNullParameter(method, "method");
        this.method = method;
        return this;
    }

    public final String getMethod() {
        return this.method;
    }

    public final RequestBuilder headers(Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.headers = headers;
        return this;
    }

    public final RequestBuilder queries(Map<String, String> queries) {
        Intrinsics.checkNotNullParameter(queries, "queries");
        this.queries = queries;
        return this;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final RequestBuilder body(KmpRequestBody body) {
        this.body = body;
        return this;
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

    public final KmpRequest build() {
        return new KmpRequest(this.host, this.path, this.method, this.headers, this.queries, this.body, this.reqConfig, this.kmpRequestMetrics);
    }
}
