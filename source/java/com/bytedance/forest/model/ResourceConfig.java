package com.bytedance.forest.model;

import com.bytedance.forest.pollyfill.NetWorker;
import com.bytedance.forest.postprocessor.ForestPostProcessor;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreloadConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B-\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tBI\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r¢\u0006\u0002\u0010\u000eB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u001a\u0010\u001d\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R*\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r2\f\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001f¨\u00061"}, d2 = {"Lcom/bytedance/forest/model/ResourceConfig;", "", "url", "", "enableMemoryCache", "", "size", "", "disableCDN", "(Ljava/lang/String;ZLjava/lang/Long;Z)V", "netWorker", "Lcom/bytedance/forest/pollyfill/NetWorker;", "processor", "Lcom/bytedance/forest/postprocessor/ForestPostProcessor;", "(Ljava/lang/String;ZLjava/lang/Long;ZLcom/bytedance/forest/pollyfill/NetWorker;Lcom/bytedance/forest/postprocessor/ForestPostProcessor;)V", "(Ljava/lang/String;ZLjava/lang/Long;ZLcom/bytedance/forest/pollyfill/NetWorker;)V", "cacheKeySensitiveQueries", "", "getCacheKeySensitiveQueries", "()Ljava/util/Set;", "setCacheKeySensitiveQueries", "(Ljava/util/Set;)V", "cacheKeyUASensitive", "getCacheKeyUASensitive", "()Z", "setCacheKeyUASensitive", "(Z)V", "getDisableCDN", "getEnableMemoryCache", "injectedUserAgent", "getInjectedUserAgent", "()Ljava/lang/String;", "setInjectedUserAgent", "(Ljava/lang/String;)V", "maxAge", "", "getMaxAge", "()I", "setMaxAge", "(I)V", "getNetWorker", "()Lcom/bytedance/forest/pollyfill/NetWorker;", "<set-?>", "getProcessor", "()Lcom/bytedance/forest/postprocessor/ForestPostProcessor;", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUrl", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ResourceConfig {
    private Set<String> cacheKeySensitiveQueries;
    private boolean cacheKeyUASensitive;
    private final boolean disableCDN;
    private final boolean enableMemoryCache;
    private String injectedUserAgent;
    private int maxAge;
    private final NetWorker netWorker;
    private ForestPostProcessor<?> processor;
    private final Long size;
    private final String url;

    public ResourceConfig(String str, boolean z, Long l, boolean z2, NetWorker netWorker) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intrinsics.checkParameterIsNotNull(netWorker, "netWorker");
        this.url = str;
        this.enableMemoryCache = z;
        this.size = l;
        this.disableCDN = z2;
        this.netWorker = netWorker;
        this.injectedUserAgent = "";
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean getEnableMemoryCache() {
        return this.enableMemoryCache;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ResourceConfig(String str, boolean z, Long l, boolean z2, NetWorker netWorker, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, r3, l, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? NetWorker.Downloader : netWorker);
        boolean z3 = (i & 2) != 0 ? false : z;
        if ((i & 4) != 0) {
            l = null;
        }
    }

    public final Long getSize() {
        return this.size;
    }

    public final boolean getDisableCDN() {
        return this.disableCDN;
    }

    public final NetWorker getNetWorker() {
        return this.netWorker;
    }

    public final ForestPostProcessor<?> getProcessor() {
        return this.processor;
    }

    public final int getMaxAge() {
        return this.maxAge;
    }

    public final void setMaxAge(int i) {
        this.maxAge = i;
    }

    public final Set<String> getCacheKeySensitiveQueries() {
        return this.cacheKeySensitiveQueries;
    }

    public final void setCacheKeySensitiveQueries(Set<String> set) {
        this.cacheKeySensitiveQueries = set;
    }

    public final boolean getCacheKeyUASensitive() {
        return this.cacheKeyUASensitive;
    }

    public final void setCacheKeyUASensitive(boolean z) {
        this.cacheKeyUASensitive = z;
    }

    public final String getInjectedUserAgent() {
        return this.injectedUserAgent;
    }

    public final void setInjectedUserAgent(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.injectedUserAgent = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ResourceConfig(String str, boolean z, Long l, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, l, (i & 8) != 0 ? false : z2);
        if ((i & 4) != 0) {
            l = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ResourceConfig(String str, boolean z, Long l, boolean z2) {
        this(str, z, l, z2, NetWorker.Downloader);
        Intrinsics.checkParameterIsNotNull(str, "url");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ResourceConfig(String str, boolean z, Long l, boolean z2, NetWorker netWorker, ForestPostProcessor forestPostProcessor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, r0, r2, r1, r4, (ForestPostProcessor<?>) r3);
        Long l2;
        boolean z3 = (i & 2) != 0 ? false : z;
        ForestPostProcessor forestPostProcessor2 = null;
        if ((i & 4) != 0) {
            l2 = null;
        } else {
            l2 = l;
        }
        boolean z4 = (i & 8) == 0 ? z2 : false;
        NetWorker netWorker2 = (i & 16) != 0 ? NetWorker.Downloader : netWorker;
        if ((i & 32) != 0) {
        } else {
            forestPostProcessor2 = forestPostProcessor;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ResourceConfig(String str, boolean z, Long l, boolean z2, NetWorker netWorker, ForestPostProcessor<?> forestPostProcessor) {
        this(str, z, l, z2, netWorker);
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intrinsics.checkParameterIsNotNull(netWorker, "netWorker");
        this.processor = forestPostProcessor;
    }
}
