package com.bytedance.forest.model;

import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.forest.pollyfill.NetWorker;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: constants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0086T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/forest/model/DefaultConfig;", "", "()V", "CDN_TIMEOUT", "", "getCDN_TIMEOUT", "()J", "setCDN_TIMEOUT", "(J)V", "ENABLE_CDN_CACHE", "", "getENABLE_CDN_CACHE", "()Z", "setENABLE_CDN_CACHE", "(Z)V", "ENABLE_CDN_NEGOTIATION", "getENABLE_CDN_NEGOTIATION", "setENABLE_CDN_NEGOTIATION", "ENABLE_MEM_CACHE", "getENABLE_MEM_CACHE", "setENABLE_MEM_CACHE", "FETCHER_SEQUENCE", "", "Lcom/bytedance/forest/model/FetcherType;", "getFETCHER_SEQUENCE", "()Ljava/util/List;", "NET_WORKER", "Lcom/bytedance/forest/pollyfill/NetWorker;", "getNET_WORKER", "()Lcom/bytedance/forest/pollyfill/NetWorker;", "setNET_WORKER", "(Lcom/bytedance/forest/pollyfill/NetWorker;)V", "NORMAL_MEM_SIZE", "", "PRELOAD_MEM_SIZE", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class DefaultConfig {
    private static boolean ENABLE_CDN_NEGOTIATION = false;
    private static boolean ENABLE_MEM_CACHE = false;
    public static final int NORMAL_MEM_SIZE = 10485760;
    public static final int PRELOAD_MEM_SIZE = 4194304;
    public static final DefaultConfig INSTANCE = new DefaultConfig();
    private static NetWorker NET_WORKER = NetWorker.TTNet;
    private static boolean ENABLE_CDN_CACHE = true;
    private static long CDN_TIMEOUT = TraceStatsConsts.PAGE_LOAD_MAX_LIMIT_MS;
    private static final List<FetcherType> FETCHER_SEQUENCE = CollectionsKt.listOf(new FetcherType[]{FetcherType.GECKO, FetcherType.BUILTIN, FetcherType.CDN});

    private DefaultConfig() {
    }

    public final NetWorker getNET_WORKER() {
        return NET_WORKER;
    }

    public final void setNET_WORKER(NetWorker netWorker) {
        Intrinsics.checkParameterIsNotNull(netWorker, "<set-?>");
        NET_WORKER = netWorker;
    }

    public final boolean getENABLE_CDN_NEGOTIATION() {
        return ENABLE_CDN_NEGOTIATION;
    }

    public final void setENABLE_CDN_NEGOTIATION(boolean z) {
        ENABLE_CDN_NEGOTIATION = z;
    }

    public final boolean getENABLE_MEM_CACHE() {
        return ENABLE_MEM_CACHE;
    }

    public final void setENABLE_MEM_CACHE(boolean z) {
        ENABLE_MEM_CACHE = z;
    }

    public final boolean getENABLE_CDN_CACHE() {
        return ENABLE_CDN_CACHE;
    }

    public final void setENABLE_CDN_CACHE(boolean z) {
        ENABLE_CDN_CACHE = z;
    }

    public final long getCDN_TIMEOUT() {
        return CDN_TIMEOUT;
    }

    public final void setCDN_TIMEOUT(long j) {
        CDN_TIMEOUT = j;
    }

    public final List<FetcherType> getFETCHER_SEQUENCE() {
        return FETCHER_SEQUENCE;
    }
}
