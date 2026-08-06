package com.bytedance.kmp.network.requet;

import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.kmp.network.KmpRequestMetrics;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Request.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0010\u001a\u00020\u0003J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bJ\u0006\u0010\u0013\u001a\u00020\u000bJ\u0006\u0010\u0014\u001a\u00020\tJ\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\tJ\u001a\u0010\u0007\u001a\u00020\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\tR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/kmp/network/requet/RequestBuilder;", "", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/kmp/network/requet/Request;", "(Lcom/bytedance/kmp/network/requet/Request;)V", ReportConst.ValidationReport.BODY, "Lcom/bytedance/kmp/network/requet/RequestBody;", "headers", "", "", "kmpRequestMetrics", "Lcom/bytedance/kmp/network/KmpRequestMetrics;", "method", "reqContext", "Lcom/bytedance/kmp/network/requet/RequestContext;", "url", "build", "getBody", "getHeaders", "getKmpRequestMetrics", "getMethod", "getReqContext", "getUrl", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RequestBuilder {
    private RequestBody body;
    private Map<String, String> headers;
    private KmpRequestMetrics kmpRequestMetrics;
    private String method;
    private RequestContext reqContext;
    private String url;

    public RequestBuilder(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.url = "";
        this.method = "";
        this.headers = MapsKt.emptyMap();
        this.reqContext = new RequestContext();
        this.kmpRequestMetrics = new KmpRequestMetrics();
        this.url = request.getUrl();
        this.method = request.getMethod();
        this.headers = request.getHeaders();
        this.body = request.getBody();
        this.reqContext = request.getReqContext();
        this.kmpRequestMetrics = request.getKmpRequestMetrics();
    }

    public final RequestBuilder url(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        return this;
    }

    public final String getUrl() {
        return this.url;
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

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final RequestBuilder body(RequestBody body) {
        this.body = body;
        return this;
    }

    public final RequestBody getBody() {
        return this.body;
    }

    public final RequestContext getReqContext() {
        return this.reqContext;
    }

    public final KmpRequestMetrics getKmpRequestMetrics() {
        return this.kmpRequestMetrics;
    }

    public final Request build() {
        return new Request(this.url, this.method, this.headers, this.body, this.reqContext, this.kmpRequestMetrics);
    }
}
