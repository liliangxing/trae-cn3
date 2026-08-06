package com.bytedance.kmp.network;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetRequestMetrics.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b9\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010Q\u001a\u00020\u0019H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001a\u0010*\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\u001a\u0010-\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\f\"\u0004\b2\u0010\u000eR\u001a\u00103\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001b\"\u0004\b5\u0010\u001dR\u001a\u00106\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\f\"\u0004\b8\u0010\u000eR\u001a\u00109\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\f\"\u0004\b;\u0010\u000eR\u001a\u0010<\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u000eR\u001a\u0010?\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\f\"\u0004\bA\u0010\u000eR\u001a\u0010B\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\f\"\u0004\bD\u0010\u000eR\u001a\u0010E\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\f\"\u0004\bG\u0010\u000eR\u001a\u0010H\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\f\"\u0004\bJ\u0010\u000eR\u001a\u0010K\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\f\"\u0004\bM\u0010\u000eR\u001a\u0010N\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\f\"\u0004\bP\u0010\u000e¨\u0006R"}, d2 = {"Lcom/bytedance/kmp/network/NetRequestMetrics;", "", "()V", "bizStartTimeStamp", "", "getBizStartTimeStamp", "()J", "setBizStartTimeStamp", "(J)V", "biz_before_time", "", "getBiz_before_time", "()I", "setBiz_before_time", "(I)V", "biz_total_time", "getBiz_total_time", "setBiz_total_time", "callback_time", "getCallback_time", "setCallback_time", "queue_time", "getQueue_time", "setQueue_time", "req_info", "", "getReq_info", "()Ljava/lang/String;", "setReq_info", "(Ljava/lang/String;)V", "requestLog", "getRequestLog", "setRequestLog", "requestSendTimeStamp", "getRequestSendTimeStamp", "setRequestSendTimeStamp", "requestStartTimeStamp", "getRequestStartTimeStamp", "setRequestStartTimeStamp", "request_interceptors_time", "getRequest_interceptors_time", "setRequest_interceptors_time", "responseContentLength", "getResponseContentLength", "setResponseContentLength", "responseRecvTimeStamp", "getResponseRecvTimeStamp", "setResponseRecvTimeStamp", "response_interceptor_time", "getResponse_interceptor_time", "setResponse_interceptor_time", "resposneContentType", "getResposneContentType", "setResposneContentType", "timing_create_stream", "getTiming_create_stream", "setTiming_create_stream", "timing_dns", "getTiming_dns", "setTiming_dns", "timing_header_recv", "getTiming_header_recv", "setTiming_header_recv", "timing_recv", "getTiming_recv", "setTiming_recv", "timing_send", "getTiming_send", "setTiming_send", "timing_ssl", "getTiming_ssl", "setTiming_ssl", "timing_tcp", "getTiming_tcp", "setTiming_tcp", "timing_total", "getTiming_total", "setTiming_total", "timing_wait", "getTiming_wait", "setTiming_wait", "toString", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NetRequestMetrics {
    private String requestLog = "";
    private String req_info = "";
    private int biz_total_time = -1;
    private int biz_before_time = -1;
    private int queue_time = -1;
    private int callback_time = -1;
    private int request_interceptors_time = -1;
    private int timing_total = -1;
    private int timing_create_stream = -1;
    private int timing_dns = -1;
    private int timing_tcp = -1;
    private int timing_ssl = -1;
    private int timing_send = -1;
    private int timing_header_recv = -1;
    private int timing_wait = -1;
    private int timing_recv = -1;
    private int response_interceptor_time = -1;
    private long bizStartTimeStamp = -1;
    private long requestStartTimeStamp = -1;
    private long requestSendTimeStamp = -1;
    private long responseRecvTimeStamp = -1;
    private String resposneContentType = "";
    private int responseContentLength = -1;

    public final String getRequestLog() {
        return this.requestLog;
    }

    public final void setRequestLog(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.requestLog = str;
    }

    public final String getReq_info() {
        return this.req_info;
    }

    public final void setReq_info(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.req_info = str;
    }

    public final int getBiz_total_time() {
        return this.biz_total_time;
    }

    public final void setBiz_total_time(int i) {
        this.biz_total_time = i;
    }

    public final int getBiz_before_time() {
        return this.biz_before_time;
    }

    public final void setBiz_before_time(int i) {
        this.biz_before_time = i;
    }

    public final int getQueue_time() {
        return this.queue_time;
    }

    public final void setQueue_time(int i) {
        this.queue_time = i;
    }

    public final int getCallback_time() {
        return this.callback_time;
    }

    public final void setCallback_time(int i) {
        this.callback_time = i;
    }

    public final int getRequest_interceptors_time() {
        return this.request_interceptors_time;
    }

    public final void setRequest_interceptors_time(int i) {
        this.request_interceptors_time = i;
    }

    public final int getTiming_total() {
        return this.timing_total;
    }

    public final void setTiming_total(int i) {
        this.timing_total = i;
    }

    public final int getTiming_create_stream() {
        return this.timing_create_stream;
    }

    public final void setTiming_create_stream(int i) {
        this.timing_create_stream = i;
    }

    public final int getTiming_dns() {
        return this.timing_dns;
    }

    public final void setTiming_dns(int i) {
        this.timing_dns = i;
    }

    public final int getTiming_tcp() {
        return this.timing_tcp;
    }

    public final void setTiming_tcp(int i) {
        this.timing_tcp = i;
    }

    public final int getTiming_ssl() {
        return this.timing_ssl;
    }

    public final void setTiming_ssl(int i) {
        this.timing_ssl = i;
    }

    public final int getTiming_send() {
        return this.timing_send;
    }

    public final void setTiming_send(int i) {
        this.timing_send = i;
    }

    public final int getTiming_header_recv() {
        return this.timing_header_recv;
    }

    public final void setTiming_header_recv(int i) {
        this.timing_header_recv = i;
    }

    public final int getTiming_wait() {
        return this.timing_wait;
    }

    public final void setTiming_wait(int i) {
        this.timing_wait = i;
    }

    public final int getTiming_recv() {
        return this.timing_recv;
    }

    public final void setTiming_recv(int i) {
        this.timing_recv = i;
    }

    public final int getResponse_interceptor_time() {
        return this.response_interceptor_time;
    }

    public final void setResponse_interceptor_time(int i) {
        this.response_interceptor_time = i;
    }

    public final long getBizStartTimeStamp() {
        return this.bizStartTimeStamp;
    }

    public final void setBizStartTimeStamp(long j) {
        this.bizStartTimeStamp = j;
    }

    public final long getRequestStartTimeStamp() {
        return this.requestStartTimeStamp;
    }

    public final void setRequestStartTimeStamp(long j) {
        this.requestStartTimeStamp = j;
    }

    public final long getRequestSendTimeStamp() {
        return this.requestSendTimeStamp;
    }

    public final void setRequestSendTimeStamp(long j) {
        this.requestSendTimeStamp = j;
    }

    public final long getResponseRecvTimeStamp() {
        return this.responseRecvTimeStamp;
    }

    public final void setResponseRecvTimeStamp(long j) {
        this.responseRecvTimeStamp = j;
    }

    public final String getResposneContentType() {
        return this.resposneContentType;
    }

    public final void setResposneContentType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.resposneContentType = str;
    }

    public final int getResponseContentLength() {
        return this.responseContentLength;
    }

    public final void setResponseContentLength(int i) {
        this.responseContentLength = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NetRequestMetrics(requestLog='");
        String substring = this.requestLog.substring(100);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        sb.append(substring).append("', req_info='").append(this.req_info).append("', biz_total_time=").append(this.biz_total_time).append(", biz_before_time=").append(this.biz_before_time).append(", queue_time=").append(this.queue_time).append(", callback_time=").append(this.callback_time).append(", request_interceptors_time=").append(this.request_interceptors_time).append(", timing_total=").append(this.timing_total).append(", timing_create_stream=").append(this.timing_create_stream).append(", timing_dns=").append(this.timing_dns).append(", timing_tcp=").append(this.timing_tcp).append(", timing_ssl=");
        sb.append(this.timing_ssl).append(", timing_send=").append(this.timing_send).append(", timing_header_recv=").append(this.timing_header_recv).append(", timing_wait=").append(this.timing_wait).append(", timing_recv=").append(this.timing_recv).append(", response_interceptor_time=").append(this.response_interceptor_time).append(", bizStartTimeStamp=").append(this.bizStartTimeStamp).append(", requestStartTimeStamp=").append(this.requestStartTimeStamp).append(", requestSendTimeStamp=").append(this.requestSendTimeStamp).append(", responseRecvTimeStamp=").append(this.responseRecvTimeStamp).append(") resposneContentType=").append(this.resposneContentType).append(", responseContentLength=").append(this.responseContentLength);
        return sb.toString();
    }
}
