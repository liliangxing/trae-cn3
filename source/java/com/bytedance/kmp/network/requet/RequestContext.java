package com.bytedance.kmp.network.requet;

import com.bytedance.kmp.network.Protocol;
import com.bytedance.kmp.network.response.IResponseInterceptor;
import com.bytedance.kmp.network.response.ResponseBodyConvertor;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestContext.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR\u001a\u0010(\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\r\"\u0004\b.\u0010\u000fR\u001a\u0010/\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000fR\u001a\u00101\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018R\u001a\u00104\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\r\"\u0004\b6\u0010\u000fR\u001a\u00107\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0016\"\u0004\b9\u0010\u0018R\u001a\u0010:\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001c\"\u0004\bB\u0010\u001eR\u001a\u0010C\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0016\"\u0004\bE\u0010\u0018R\"\u0010F\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001a\u0010M\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u001c\"\u0004\bO\u0010\u001eR\u001a\u0010P\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0016\"\u0004\bR\u0010\u0018R \u0010S\u001a\b\u0012\u0002\b\u0003\u0018\u00010TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010Y\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010*\"\u0004\b[\u0010,R\"\u0010\\\u001a\n\u0012\u0004\u0012\u00020]\u0018\u00010GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010J\"\u0004\b_\u0010LR\u001a\u0010`\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u001c\"\u0004\bb\u0010\u001eR\u001a\u0010c\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u001c\"\u0004\be\u0010\u001eR\u001a\u0010f\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u001c\"\u0004\bh\u0010\u001eR\u001a\u0010i\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u001c\"\u0004\bk\u0010\u001e¨\u0006l"}, d2 = {"Lcom/bytedance/kmp/network/requet/RequestContext;", "", "()V", "bizJsonLogMap", "", "", "getBizJsonLogMap", "()Ljava/util/Map;", "setBizJsonLogMap", "(Ljava/util/Map;)V", "bypassCronetCookie", "", "getBypassCronetCookie", "()Z", "setBypassCronetCookie", "(Z)V", "bypassKmpBizInterceptor", "getBypassKmpBizInterceptor", "setBypassKmpBizInterceptor", "commonParamLevel", "", "getCommonParamLevel", "()I", "setCommonParamLevel", "(I)V", "connectTimeout", "", "getConnectTimeout", "()J", "setConnectTimeout", "(J)V", "dnsConfig", "Lcom/bytedance/kmp/network/requet/DnsConfig;", "getDnsConfig", "()Lcom/bytedance/kmp/network/requet/DnsConfig;", "setDnsConfig", "(Lcom/bytedance/kmp/network/requet/DnsConfig;)V", "followRedirectInternal", "getFollowRedirectInternal", "setFollowRedirectInternal", "host", "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "isCinteropRequest", "setCinteropRequest", "isDownloadStreaming", "setDownloadStreaming", "kmpRequestId", "getKmpRequestId", "setKmpRequestId", "needCommonParams", "getNeedCommonParams", "setNeedCommonParams", "priorityLevel", "getPriorityLevel", "setPriorityLevel", "protocol", "Lcom/bytedance/kmp/network/Protocol;", "getProtocol", "()Lcom/bytedance/kmp/network/Protocol;", "setProtocol", "(Lcom/bytedance/kmp/network/Protocol;)V", "readTimeout", "getReadTimeout", "setReadTimeout", "requestFlag", "getRequestFlag", "setRequestFlag", "requestInterceptorList", "", "Lcom/bytedance/kmp/network/requet/IRequestInterceptor;", "getRequestInterceptorList", "()Ljava/util/List;", "setRequestInterceptorList", "(Ljava/util/List;)V", "requestTimeout", "getRequestTimeout", "setRequestTimeout", "requestUuid", "getRequestUuid", "setRequestUuid", "responseBodyConvertor", "Lcom/bytedance/kmp/network/response/ResponseBodyConvertor;", "getResponseBodyConvertor", "()Lcom/bytedance/kmp/network/response/ResponseBodyConvertor;", "setResponseBodyConvertor", "(Lcom/bytedance/kmp/network/response/ResponseBodyConvertor;)V", "responseBodyType", "getResponseBodyType", "setResponseBodyType", "responseInterceptorList", "Lcom/bytedance/kmp/network/response/IResponseInterceptor;", "getResponseInterceptorList", "setResponseInterceptorList", "socketConnectTimeout", "getSocketConnectTimeout", "setSocketConnectTimeout", "socketReadTimeout", "getSocketReadTimeout", "setSocketReadTimeout", "socketWriteTimeout", "getSocketWriteTimeout", "setSocketWriteTimeout", "writeTimeout", "getWriteTimeout", "setWriteTimeout", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RequestContext {
    private Map<String, ? extends Object> bizJsonLogMap;
    private boolean bypassCronetCookie;
    private boolean bypassKmpBizInterceptor;
    private int commonParamLevel;
    private DnsConfig dnsConfig;
    private boolean isCinteropRequest;
    private boolean isDownloadStreaming;
    private int requestFlag;
    private List<? extends IRequestInterceptor> requestInterceptorList;
    private ResponseBodyConvertor<?> responseBodyConvertor;
    private List<? extends IResponseInterceptor> responseInterceptorList;
    private long connectTimeout = 15000;
    private long readTimeout = 15000;
    private long writeTimeout = 15000;
    private long requestTimeout = -1;
    private long socketConnectTimeout = 15000;
    private long socketReadTimeout = 15000;
    private long socketWriteTimeout = 15000;
    private int priorityLevel = -999;
    private boolean needCommonParams = true;
    private String responseBodyType = "ARRAYBUFFER";
    private boolean followRedirectInternal = true;
    private String host = "";
    private int requestUuid = -1;
    private int kmpRequestId = -1;
    private Protocol protocol = Protocol.UNKNOWN;

    public final long getConnectTimeout() {
        return this.connectTimeout;
    }

    public final void setConnectTimeout(long j) {
        this.connectTimeout = j;
    }

    public final long getReadTimeout() {
        return this.readTimeout;
    }

    public final void setReadTimeout(long j) {
        this.readTimeout = j;
    }

    public final long getWriteTimeout() {
        return this.writeTimeout;
    }

    public final void setWriteTimeout(long j) {
        this.writeTimeout = j;
    }

    public final long getRequestTimeout() {
        return this.requestTimeout;
    }

    public final void setRequestTimeout(long j) {
        this.requestTimeout = j;
    }

    public final long getSocketConnectTimeout() {
        return this.socketConnectTimeout;
    }

    public final void setSocketConnectTimeout(long j) {
        this.socketConnectTimeout = j;
    }

    public final long getSocketReadTimeout() {
        return this.socketReadTimeout;
    }

    public final void setSocketReadTimeout(long j) {
        this.socketReadTimeout = j;
    }

    public final long getSocketWriteTimeout() {
        return this.socketWriteTimeout;
    }

    public final void setSocketWriteTimeout(long j) {
        this.socketWriteTimeout = j;
    }

    public final int getPriorityLevel() {
        return this.priorityLevel;
    }

    public final void setPriorityLevel(int i) {
        this.priorityLevel = i;
    }

    public final boolean getNeedCommonParams() {
        return this.needCommonParams;
    }

    public final void setNeedCommonParams(boolean z) {
        this.needCommonParams = z;
    }

    public final int getCommonParamLevel() {
        return this.commonParamLevel;
    }

    public final void setCommonParamLevel(int i) {
        this.commonParamLevel = i;
    }

    public final boolean getBypassCronetCookie() {
        return this.bypassCronetCookie;
    }

    public final void setBypassCronetCookie(boolean z) {
        this.bypassCronetCookie = z;
    }

    public final boolean getBypassKmpBizInterceptor() {
        return this.bypassKmpBizInterceptor;
    }

    public final void setBypassKmpBizInterceptor(boolean z) {
        this.bypassKmpBizInterceptor = z;
    }

    /* renamed from: isDownloadStreaming, reason: from getter */
    public final boolean getIsDownloadStreaming() {
        return this.isDownloadStreaming;
    }

    public final void setDownloadStreaming(boolean z) {
        this.isDownloadStreaming = z;
    }

    public final String getResponseBodyType() {
        return this.responseBodyType;
    }

    public final void setResponseBodyType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.responseBodyType = str;
    }

    public final boolean getFollowRedirectInternal() {
        return this.followRedirectInternal;
    }

    public final void setFollowRedirectInternal(boolean z) {
        this.followRedirectInternal = z;
    }

    public final ResponseBodyConvertor<?> getResponseBodyConvertor() {
        return this.responseBodyConvertor;
    }

    public final void setResponseBodyConvertor(ResponseBodyConvertor<?> responseBodyConvertor) {
        this.responseBodyConvertor = responseBodyConvertor;
    }

    public final int getRequestFlag() {
        return this.requestFlag;
    }

    public final void setRequestFlag(int i) {
        this.requestFlag = i;
    }

    public final Map<String, Object> getBizJsonLogMap() {
        return this.bizJsonLogMap;
    }

    public final void setBizJsonLogMap(Map<String, ? extends Object> map) {
        this.bizJsonLogMap = map;
    }

    public final String getHost() {
        return this.host;
    }

    public final void setHost(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.host = str;
    }

    public final List<IRequestInterceptor> getRequestInterceptorList() {
        return this.requestInterceptorList;
    }

    public final void setRequestInterceptorList(List<? extends IRequestInterceptor> list) {
        this.requestInterceptorList = list;
    }

    public final List<IResponseInterceptor> getResponseInterceptorList() {
        return this.responseInterceptorList;
    }

    public final void setResponseInterceptorList(List<? extends IResponseInterceptor> list) {
        this.responseInterceptorList = list;
    }

    public final int getRequestUuid() {
        return this.requestUuid;
    }

    public final void setRequestUuid(int i) {
        this.requestUuid = i;
    }

    public final int getKmpRequestId() {
        return this.kmpRequestId;
    }

    public final void setKmpRequestId(int i) {
        this.kmpRequestId = i;
    }

    public final DnsConfig getDnsConfig() {
        return this.dnsConfig;
    }

    public final void setDnsConfig(DnsConfig dnsConfig) {
        this.dnsConfig = dnsConfig;
    }

    public final Protocol getProtocol() {
        return this.protocol;
    }

    public final void setProtocol(Protocol protocol) {
        Intrinsics.checkNotNullParameter(protocol, "<set-?>");
        this.protocol = protocol;
    }

    /* renamed from: isCinteropRequest, reason: from getter */
    public final boolean getIsCinteropRequest() {
        return this.isCinteropRequest;
    }

    public final void setCinteropRequest(boolean z) {
        this.isCinteropRequest = z;
    }
}
