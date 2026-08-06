package com.bytedance.forest.model;

import com.bytedance.applog.server.Api;
import com.bytedance.forest.model.GeckoConfig;
import com.bytedance.forest.pollyfill.NetWorker;
import com.bytedance.forest.utils.LoaderUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForestConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B?\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\u0010\nB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\u000bJ\u0012\u0010.\u001a\u0004\u0018\u00010\u00052\b\u0010D\u001a\u0004\u0018\u00010\u0003J\b\u0010E\u001a\u00020\u0003H\u0016Ru\u0010\f\u001a]\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\rj\u0004\u0018\u0001`\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001a\u0010$\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R$\u0010'\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010+\"\u0004\b:\u0010-R\u001a\u0010;\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010+\"\u0004\b=\u0010-R\u001a\u0010>\u001a\u00020?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lcom/bytedance/forest/model/ForestConfig;", "", "host", "", "geckoConfig", "Lcom/bytedance/forest/model/GeckoConfig;", "geckoConfigs", "", "prefixList", "", "(Ljava/lang/String;Lcom/bytedance/forest/model/GeckoConfig;Ljava/util/Map;Ljava/util/Set;)V", "(Ljava/lang/String;Lcom/bytedance/forest/model/GeckoConfig;Ljava/util/Map;)V", "aLog", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "logLevel", Api.COL_TAG, "", "params", "", "Lcom/bytedance/forest/utils/LogReporter;", "getALog", "()Lkotlin/jvm/functions/Function3;", "setALog", "(Lkotlin/jvm/functions/Function3;)V", "enableCDNCache", "", "getEnableCDNCache", "()Z", "setEnableCDNCache", "(Z)V", "enableMemoryCache", "getEnableMemoryCache", "setEnableMemoryCache", "enableNegotiation", "getEnableNegotiation", "setEnableNegotiation", "geckoCheckPathTraversalMode", "geckoCheckPathTraversalMode$annotations", "()V", "getGeckoCheckPathTraversalMode", "()I", "setGeckoCheckPathTraversalMode", "(I)V", "getGeckoConfig", "()Lcom/bytedance/forest/model/GeckoConfig;", "setGeckoConfig", "(Lcom/bytedance/forest/model/GeckoConfig;)V", "getGeckoConfigs", "()Ljava/util/Map;", "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "maxNormalMemorySize", "getMaxNormalMemorySize", "setMaxNormalMemorySize", "maxPreloadMemorySize", "getMaxPreloadMemorySize", "setMaxPreloadMemorySize", "netWorker", "Lcom/bytedance/forest/pollyfill/NetWorker;", "getNetWorker", "()Lcom/bytedance/forest/pollyfill/NetWorker;", "setNetWorker", "(Lcom/bytedance/forest/pollyfill/NetWorker;)V", "ak", "toString", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ForestConfig {
    private Function3<? super Integer, ? super String, ? super Map<String, ? extends Object>, Unit> aLog;
    private boolean enableCDNCache;
    private boolean enableMemoryCache;
    private boolean enableNegotiation;
    private int geckoCheckPathTraversalMode;
    private GeckoConfig geckoConfig;
    private final Map<String, GeckoConfig> geckoConfigs;
    private String host;
    private int maxNormalMemorySize;
    private int maxPreloadMemorySize;
    private NetWorker netWorker;

    @SecureMode
    public static /* synthetic */ void geckoCheckPathTraversalMode$annotations() {
    }

    public ForestConfig(String str, GeckoConfig geckoConfig, Map<String, GeckoConfig> map) {
        Intrinsics.checkParameterIsNotNull(str, "host");
        Intrinsics.checkParameterIsNotNull(map, "geckoConfigs");
        this.host = str;
        this.geckoConfig = geckoConfig;
        this.geckoConfigs = map;
        this.netWorker = DefaultConfig.INSTANCE.getNET_WORKER();
        this.maxNormalMemorySize = DefaultConfig.NORMAL_MEM_SIZE;
        this.maxPreloadMemorySize = DefaultConfig.PRELOAD_MEM_SIZE;
        this.enableNegotiation = DefaultConfig.INSTANCE.getENABLE_CDN_NEGOTIATION();
        this.enableMemoryCache = DefaultConfig.INSTANCE.getENABLE_MEM_CACHE();
        this.enableCDNCache = DefaultConfig.INSTANCE.getENABLE_CDN_CACHE();
    }

    public final String getHost() {
        return this.host;
    }

    public final void setHost(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.host = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ForestConfig(String str, GeckoConfig geckoConfig, LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, geckoConfig, (i & 4) != 0 ? new LinkedHashMap() : linkedHashMap);
        if ((i & 2) != 0) {
            geckoConfig = null;
        }
    }

    public final GeckoConfig getGeckoConfig() {
        return this.geckoConfig;
    }

    public final void setGeckoConfig(GeckoConfig geckoConfig) {
        this.geckoConfig = geckoConfig;
    }

    public final Map<String, GeckoConfig> getGeckoConfigs() {
        return this.geckoConfigs;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ForestConfig(String str, GeckoConfig geckoConfig, Map map, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, geckoConfig, map, set);
        if ((i & 4) != 0) {
            map = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "prefixList is useless. Forest do not support global prefix injection anymore.")
    public ForestConfig(String str, GeckoConfig geckoConfig, LinkedHashMap linkedHashMap, Set<String> set) {
        this(str, geckoConfig, linkedHashMap == null ? new LinkedHashMap() : linkedHashMap);
        Intrinsics.checkParameterIsNotNull(str, "host");
        Intrinsics.checkParameterIsNotNull(set, "prefixList");
    }

    public final NetWorker getNetWorker() {
        return this.netWorker;
    }

    public final void setNetWorker(NetWorker netWorker) {
        Intrinsics.checkParameterIsNotNull(netWorker, "<set-?>");
        this.netWorker = netWorker;
    }

    public final Function3<Integer, String, Map<String, ? extends Object>, Unit> getALog() {
        return this.aLog;
    }

    public final void setALog(Function3<? super Integer, ? super String, ? super Map<String, ? extends Object>, Unit> function3) {
        this.aLog = function3;
    }

    public final int getGeckoCheckPathTraversalMode() {
        return this.geckoCheckPathTraversalMode;
    }

    public final void setGeckoCheckPathTraversalMode(int i) {
        this.geckoCheckPathTraversalMode = i;
    }

    public final int getMaxNormalMemorySize() {
        return this.maxNormalMemorySize;
    }

    public final void setMaxNormalMemorySize(int i) {
        this.maxNormalMemorySize = i;
    }

    public final int getMaxPreloadMemorySize() {
        return this.maxPreloadMemorySize;
    }

    public final void setMaxPreloadMemorySize(int i) {
        this.maxPreloadMemorySize = i;
    }

    public final boolean getEnableNegotiation() {
        return this.enableNegotiation;
    }

    public final void setEnableNegotiation(boolean z) {
        this.enableNegotiation = z;
    }

    public final boolean getEnableMemoryCache() {
        return this.enableMemoryCache;
    }

    public final void setEnableMemoryCache(boolean z) {
        this.enableMemoryCache = z;
    }

    public final boolean getEnableCDNCache() {
        return this.enableCDNCache;
    }

    public final void setEnableCDNCache(boolean z) {
        this.enableCDNCache = z;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("{[host]=").append(this.host).append(",[region]=");
        GeckoConfig geckoConfig = this.geckoConfig;
        StringBuilder append2 = append.append(geckoConfig != null ? geckoConfig.getRegion() : null).append(",[appId]=");
        GeckoConfig geckoConfig2 = this.geckoConfig;
        StringBuilder append3 = append2.append(geckoConfig2 != null ? Long.valueOf(geckoConfig2.getAppId()) : null).append(",[appVersion]=");
        GeckoConfig geckoConfig3 = this.geckoConfig;
        StringBuilder append4 = append3.append(geckoConfig3 != null ? geckoConfig3.getAppVersion() : null).append(",[did]=");
        GeckoConfig geckoConfig4 = this.geckoConfig;
        return append4.append(geckoConfig4 != null ? geckoConfig4.getDid() : null).toString();
    }

    public final GeckoConfig getGeckoConfig(String ak) {
        GeckoConfig geckoConfig = this.geckoConfigs.get(ak != null ? ak : "");
        if (geckoConfig == null) {
            if (LoaderUtils.INSTANCE.isNotNullOrEmpty(ak)) {
                GeckoConfig geckoConfig2 = this.geckoConfig;
                if (Intrinsics.areEqual(ak, geckoConfig2 != null ? geckoConfig2.getAccessKey() : null)) {
                    geckoConfig = this.geckoConfig;
                }
            }
            GeckoConfig.Companion companion = GeckoConfig.INSTANCE;
            if (ak == null) {
                ak = "";
            }
            geckoConfig = companion.fromGeckoRegistry$forest_release(ak);
        }
        return geckoConfig != null ? geckoConfig : this.geckoConfig;
    }
}
