package com.bytedance.kmp.network.requet;

import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.kmp.network.KmpRequestMetrics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Request.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B5\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB=\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fBE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\bJ\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006J\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0017R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/kmp/network/requet/Request;", "", "url", "", "method", "headers", "", ReportConst.ValidationReport.BODY, "Lcom/bytedance/kmp/network/requet/RequestBody;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/kmp/network/requet/RequestBody;)V", "reqContext", "Lcom/bytedance/kmp/network/requet/RequestContext;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/kmp/network/requet/RequestBody;Lcom/bytedance/kmp/network/requet/RequestContext;)V", "kmpRequestMetrics", "Lcom/bytedance/kmp/network/KmpRequestMetrics;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/kmp/network/requet/RequestBody;Lcom/bytedance/kmp/network/requet/RequestContext;Lcom/bytedance/kmp/network/KmpRequestMetrics;)V", "getBody", "getHeaders", "getKmpRequestMetrics", "getMethod", "getReqContext", "getUrl", "newBuilder", "Lcom/bytedance/kmp/network/requet/RequestBuilder;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Request {
    private final RequestBody body;
    private final Map<String, String> headers;
    private final KmpRequestMetrics kmpRequestMetrics;
    private final String method;
    private final RequestContext reqContext;
    private final String url;

    public Request(String url, String method, Map<String, String> headers, RequestBody requestBody, RequestContext reqContext, KmpRequestMetrics kmpRequestMetrics) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(reqContext, "reqContext");
        Intrinsics.checkNotNullParameter(kmpRequestMetrics, "kmpRequestMetrics");
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.body = requestBody;
        this.reqContext = reqContext;
        this.kmpRequestMetrics = kmpRequestMetrics;
    }

    public /* synthetic */ Request(String str, String str2, Map map, RequestBody requestBody, RequestContext requestContext, KmpRequestMetrics kmpRequestMetrics, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, map, requestBody, requestContext, (i & 32) != 0 ? new KmpRequestMetrics() : kmpRequestMetrics);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Request(String url, String method, Map<String, String> headers, RequestBody requestBody) {
        this(url, method, headers, requestBody, new RequestContext());
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Request(String url, String method, Map<String, String> headers, RequestBody requestBody, RequestContext reqContext) {
        this(url, method, headers, requestBody, reqContext, new KmpRequestMetrics());
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(reqContext, "reqContext");
    }

    public final RequestBuilder newBuilder() {
        return new RequestBuilder(this);
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getMethod() {
        return this.method;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
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
}
