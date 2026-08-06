package com.bytedance.kmp.network.wschannel;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WsChannelMsg.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u000e\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/bytedance/kmp/network/wschannel/WsChannelMsg;", "", "seqId", "", "logId", "service", "", "method", "headers", "", "payloadEncoding", "payloadType", "payload", "", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/Map;Ljava/lang/String;Ljava/lang/String;[B)V", "getHeaders", "()Ljava/util/Map;", "getLogId", "()Ljava/lang/String;", "getMethod", "()I", "getPayload", "()[B", "getPayloadEncoding", "getPayloadType", "getSeqId", "getService", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WsChannelMsg {
    private final Map<String, String> headers;
    private final String logId;
    private final int method;
    private final byte[] payload;
    private final String payloadEncoding;
    private final String payloadType;
    private final String seqId;
    private final int service;

    public WsChannelMsg(String seqId, String logId, int i, int i2, Map<String, String> headers, String payloadEncoding, String payloadType, byte[] payload) {
        Intrinsics.checkNotNullParameter(seqId, "seqId");
        Intrinsics.checkNotNullParameter(logId, "logId");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(payloadEncoding, "payloadEncoding");
        Intrinsics.checkNotNullParameter(payloadType, "payloadType");
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.seqId = seqId;
        this.logId = logId;
        this.service = i;
        this.method = i2;
        this.headers = headers;
        this.payloadEncoding = payloadEncoding;
        this.payloadType = payloadType;
        this.payload = payload;
    }

    public final String getSeqId() {
        return this.seqId;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final int getService() {
        return this.service;
    }

    public final int getMethod() {
        return this.method;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final String getPayloadEncoding() {
        return this.payloadEncoding;
    }

    public final String getPayloadType() {
        return this.payloadType;
    }

    public final byte[] getPayload() {
        return this.payload;
    }
}
