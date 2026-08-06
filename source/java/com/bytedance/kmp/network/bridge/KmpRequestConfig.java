package com.bytedance.kmp.network.bridge;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpRequestConfig.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\b¨\u00063"}, d2 = {"Lcom/bytedance/kmp/network/bridge/KmpRequestConfig;", "", "()V", "connectTimeout", "", "getConnectTimeout", "()J", "setConnectTimeout", "(J)V", "dtoInfo", "Lcom/bytedance/kmp/network/bridge/KmpNetworkDtoInfo;", "getDtoInfo", "()Lcom/bytedance/kmp/network/bridge/KmpNetworkDtoInfo;", "setDtoInfo", "(Lcom/bytedance/kmp/network/bridge/KmpNetworkDtoInfo;)V", "dtoTransformer", "Lcom/bytedance/kmp/network/bridge/KmpCustomDtoTransformer;", "getDtoTransformer", "()Lcom/bytedance/kmp/network/bridge/KmpCustomDtoTransformer;", "setDtoTransformer", "(Lcom/bytedance/kmp/network/bridge/KmpCustomDtoTransformer;)V", "preloadCacheKey", "", "getPreloadCacheKey", "()Ljava/lang/String;", "setPreloadCacheKey", "(Ljava/lang/String;)V", "readTimeout", "getReadTimeout", "setReadTimeout", "requestSerializeType", "Lcom/bytedance/kmp/network/bridge/KmpSerializeType;", "getRequestSerializeType", "()Lcom/bytedance/kmp/network/bridge/KmpSerializeType;", "setRequestSerializeType", "(Lcom/bytedance/kmp/network/bridge/KmpSerializeType;)V", "requestTimeout", "getRequestTimeout", "setRequestTimeout", "socketConnectTimeout", "getSocketConnectTimeout", "setSocketConnectTimeout", "socketReadTimeout", "getSocketReadTimeout", "setSocketReadTimeout", "socketWriteTimeout", "getSocketWriteTimeout", "setSocketWriteTimeout", "writeTimeout", "getWriteTimeout", "setWriteTimeout", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KmpRequestConfig {
    private KmpNetworkDtoInfo dtoInfo;
    private KmpCustomDtoTransformer<?> dtoTransformer;
    private String preloadCacheKey;
    private long connectTimeout = 15000;
    private long readTimeout = 15000;
    private long writeTimeout = 15000;
    private long requestTimeout = -1;
    private long socketConnectTimeout = 15000;
    private long socketReadTimeout = 15000;
    private long socketWriteTimeout = 15000;
    private KmpSerializeType requestSerializeType = KmpSerializeType.JSON;

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

    public final KmpSerializeType getRequestSerializeType() {
        return this.requestSerializeType;
    }

    public final void setRequestSerializeType(KmpSerializeType kmpSerializeType) {
        Intrinsics.checkNotNullParameter(kmpSerializeType, "<set-?>");
        this.requestSerializeType = kmpSerializeType;
    }

    public final KmpCustomDtoTransformer<?> getDtoTransformer() {
        return this.dtoTransformer;
    }

    public final void setDtoTransformer(KmpCustomDtoTransformer<?> kmpCustomDtoTransformer) {
        this.dtoTransformer = kmpCustomDtoTransformer;
    }

    public final KmpNetworkDtoInfo getDtoInfo() {
        return this.dtoInfo;
    }

    public final void setDtoInfo(KmpNetworkDtoInfo kmpNetworkDtoInfo) {
        this.dtoInfo = kmpNetworkDtoInfo;
    }

    public final String getPreloadCacheKey() {
        return this.preloadCacheKey;
    }

    public final void setPreloadCacheKey(String str) {
        this.preloadCacheKey = str;
    }
}
