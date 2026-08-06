package com.bytedance.kmp.network.response;

import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.kmp.network.Header;
import com.bytedance.kmp.network.NetError;
import com.bytedance.kmp.network.NetRequestMetrics;
import com.bytedance.kmp.network.Protocol;
import com.bytedance.kmp.network.requet.Request;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Response.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0016\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0018\u001a\u00020\bJ\b\u0010\u0019\u001a\u0004\u0018\u00010\nJ\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0006\u0010\u001b\u001a\u00020\u000fJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0013J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0015J\u0014\u0010\u000b\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/kmp/network/response/ResponseBuilder;", "", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/kmp/network/response/Response;", "(Lcom/bytedance/kmp/network/response/Response;)V", ReportConst.ValidationReport.BODY, "Lcom/bytedance/kmp/network/response/ResponseBody;", "code", "", "error", "Lcom/bytedance/kmp/network/NetError;", "headers", "", "Lcom/bytedance/kmp/network/Header;", "message", "", "metrics", "Lcom/bytedance/kmp/network/NetRequestMetrics;", MonitorConstants.PROTOCOL, "Lcom/bytedance/kmp/network/Protocol;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/kmp/network/requet/Request;", "build", "getBody", "getCode", "getError", "getHeaders", "getMessage", "getMetrics", "getProtocol", "getRequest", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ResponseBuilder {
    private ResponseBody body;
    private int code;
    private NetError error;
    private List<Header> headers;
    private String message;
    private NetRequestMetrics metrics;
    private Protocol protocol;
    private Request request;

    public ResponseBuilder(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        this.message = "";
        this.headers = CollectionsKt.emptyList();
        this.request = response.getRequest();
        this.protocol = response.getProtocol();
        this.message = response.getMessage();
        this.code = response.getCode();
        this.headers = response.getHeaders();
        this.body = response.getBody();
        this.error = response.getError();
        this.metrics = response.getMetrics();
    }

    public final ResponseBuilder request(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.request = request;
        return this;
    }

    public final Request getRequest() {
        return this.request;
    }

    public final ResponseBuilder protocol(Protocol protocol) {
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        this.protocol = protocol;
        return this;
    }

    public final Protocol getProtocol() {
        return this.protocol;
    }

    public final ResponseBuilder message(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.message = message;
        return this;
    }

    public final String getMessage() {
        return this.message;
    }

    public final ResponseBuilder code(int code) {
        this.code = code;
        return this;
    }

    public final int getCode() {
        return this.code;
    }

    public final ResponseBuilder headers(List<Header> headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.headers = headers;
        return this;
    }

    public final List<Header> getHeaders() {
        return this.headers;
    }

    public final ResponseBuilder body(ResponseBody body) {
        this.body = body;
        return this;
    }

    public final ResponseBody getBody() {
        return this.body;
    }

    public final ResponseBuilder error(NetError error) {
        this.error = error;
        return this;
    }

    public final NetError getError() {
        return this.error;
    }

    public final ResponseBuilder metrics(NetRequestMetrics metrics) {
        this.metrics = metrics;
        return this;
    }

    public final NetRequestMetrics getMetrics() {
        return this.metrics;
    }

    public final Response build() {
        if (this.request == null) {
            throw new IllegalArgumentException("Request cannot be null".toString());
        }
        if (this.protocol == null) {
            throw new IllegalArgumentException("Protocol cannot be null".toString());
        }
        Request request = this.request;
        Intrinsics.checkNotNull(request);
        Protocol protocol = this.protocol;
        Intrinsics.checkNotNull(protocol);
        return new Response(request, protocol, this.message, this.code, this.headers, this.body, this.error, this.metrics);
    }
}
