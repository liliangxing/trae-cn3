package com.bytedance.kmp.network.response;

import com.bytedance.kmp.network.Header;
import com.bytedance.kmp.network.NetError;
import com.bytedance.kmp.network.NetRequestMetrics;
import com.bytedance.kmp.network.Protocol;
import com.bytedance.kmp.network.requet.Request;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicRef;

/* compiled from: Response.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\b\u0010$\u001a\u0004\u0018\u00010\u0012J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020(J\b\u0010)\u001a\u00020\u0007H\u0016J\u0010\u0010*\u001a\u00020+2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006,"}, d2 = {"Lcom/bytedance/kmp/network/response/Response;", "", "request", "Lcom/bytedance/kmp/network/requet/Request;", "protocol", "Lcom/bytedance/kmp/network/Protocol;", "message", "", "code", "", "headers", "", "Lcom/bytedance/kmp/network/Header;", "body", "Lcom/bytedance/kmp/network/response/ResponseBody;", "error", "Lcom/bytedance/kmp/network/NetError;", LynxMonitorService.KEY_METRICS, "Lcom/bytedance/kmp/network/NetRequestMetrics;", "(Lcom/bytedance/kmp/network/requet/Request;Lcom/bytedance/kmp/network/Protocol;Ljava/lang/String;ILjava/util/List;Lcom/bytedance/kmp/network/response/ResponseBody;Lcom/bytedance/kmp/network/NetError;Lcom/bytedance/kmp/network/NetRequestMetrics;)V", "getBody", "()Lcom/bytedance/kmp/network/response/ResponseBody;", "getCode", "()I", "getError", "()Lcom/bytedance/kmp/network/NetError;", "getHeaders", "()Ljava/util/List;", "getMessage", "()Ljava/lang/String;", "metricsRef", "Lkotlinx/atomicfu/AtomicRef;", "getProtocol", "()Lcom/bytedance/kmp/network/Protocol;", "getRequest", "()Lcom/bytedance/kmp/network/requet/Request;", "getMetrics", "isValid", "", "newBuilder", "Lcom/bytedance/kmp/network/response/ResponseBuilder;", "toString", "updateMetrics", "", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class Response {
    private final ResponseBody body;
    private final int code;
    private final NetError error;
    private final List<Header> headers;
    private final String message;
    private final AtomicRef<NetRequestMetrics> metricsRef;
    private final Protocol protocol;
    private final Request request;

    public Response(Request request, Protocol protocol, String str, int i, List<Header> list, ResponseBody responseBody, NetError netError, NetRequestMetrics netRequestMetrics) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(list, "headers");
        this.request = request;
        this.protocol = protocol;
        this.message = str;
        this.code = i;
        this.headers = list;
        this.body = responseBody;
        this.error = netError;
        this.metricsRef = AtomicFU.atomic(netRequestMetrics);
    }

    public final Request getRequest() {
        return this.request;
    }

    public final Protocol getProtocol() {
        return this.protocol;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getCode() {
        return this.code;
    }

    public final List<Header> getHeaders() {
        return this.headers;
    }

    public final ResponseBody getBody() {
        return this.body;
    }

    public final NetError getError() {
        return this.error;
    }

    public final NetRequestMetrics getMetrics() {
        return (NetRequestMetrics) this.metricsRef.getValue();
    }

    public final void updateMetrics(NetRequestMetrics metrics) {
        Object value;
        AtomicRef<NetRequestMetrics> atomicRef = this.metricsRef;
        do {
            value = atomicRef.getValue();
        } while (!atomicRef.compareAndSet(value, metrics));
    }

    public final ResponseBuilder newBuilder() {
        return new ResponseBuilder(this);
    }

    public final boolean isValid() {
        return this.error == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Response(code=" + this.code + ", message='" + this.message + '\'');
        if (this.error != null) {
            sb.append(", error=" + this.error);
        }
        sb.append(", headers=" + this.headers);
        sb.append(")");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}
