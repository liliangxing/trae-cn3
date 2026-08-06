package com.bytedance.forest.model;

import com.bytedance.forest.pollyfill.NetWorker;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreloadConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 !2\u00020\u0001:\u0001!BU\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB7\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0007¢\u0006\u0002\u0010\u0010B5\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0007¢\u0006\u0002\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR%\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/bytedance/forest/model/PreloadConfig;", "", "mainUrl", "", "type", "Lcom/bytedance/forest/model/PreloadType;", "subResource", "", "", "Lcom/bytedance/forest/model/ResourceConfig;", "enableMemoryCache", "", "disableCDN", "netWorker", "Lcom/bytedance/forest/pollyfill/NetWorker;", "(Ljava/lang/String;Lcom/bytedance/forest/model/PreloadType;Ljava/util/Map;ZZLcom/bytedance/forest/pollyfill/NetWorker;)V", "(Ljava/lang/String;Lcom/bytedance/forest/model/PreloadType;Ljava/util/Map;)V", "mainResource", "(Lcom/bytedance/forest/model/ResourceConfig;Lcom/bytedance/forest/model/PreloadType;Ljava/util/Map;)V", "from", "getFrom", "()Ljava/lang/String;", "setFrom", "(Ljava/lang/String;)V", "injectUserAgent", "getInjectUserAgent", "setInjectUserAgent", "getMainResource", "()Lcom/bytedance/forest/model/ResourceConfig;", "getSubResource", "()Ljava/util/Map;", "getType", "()Lcom/bytedance/forest/model/PreloadType;", "JsonKeys", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class PreloadConfig {
    public static final String KEY_FONT = "font";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_OTHER = "other";
    public static final String KEY_SCRIPT = "script";
    public static final String KEY_STYLESHEET = "css";
    public static final String KEY_TYPE = "type";
    public static final String SUB_KEY_ENABLE_MEMORY = "enableMemory";
    public static final String SUB_KEY_SIZE = "size";
    public static final String SUB_KEY_URL = "url";
    private String from;
    private String injectUserAgent;
    private final ResourceConfig mainResource;
    private final Map<String, List<ResourceConfig>> subResource;
    private final PreloadType type;

    /* JADX WARN: Multi-variable type inference failed */
    public PreloadConfig(ResourceConfig resourceConfig, PreloadType preloadType, Map<String, ? extends List<ResourceConfig>> map) {
        Intrinsics.checkParameterIsNotNull(preloadType, "type");
        this.mainResource = resourceConfig;
        this.type = preloadType;
        this.subResource = map;
    }

    public final ResourceConfig getMainResource() {
        return this.mainResource;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PreloadConfig(ResourceConfig resourceConfig, PreloadType preloadType, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(resourceConfig, preloadType, (Map<String, ? extends List<ResourceConfig>>) map);
        if ((i & 2) != 0) {
            preloadType = PreloadConfigKt.calcMainUrlType(resourceConfig != null ? resourceConfig.getUrl() : null);
            if (preloadType == null) {
                preloadType = PreloadType.LYNX;
            }
        }
    }

    public final PreloadType getType() {
        return this.type;
    }

    public final Map<String, List<ResourceConfig>> getSubResource() {
        return this.subResource;
    }

    public final String getFrom() {
        return this.from;
    }

    public final void setFrom(String str) {
        this.from = str;
    }

    public final String getInjectUserAgent() {
        return this.injectUserAgent;
    }

    public final void setInjectUserAgent(String str) {
        this.injectUserAgent = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PreloadConfig(String str, PreloadType preloadType, Map map, boolean z, boolean z2, NetWorker netWorker, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, preloadType, map, (i & 8) != 0 ? true : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? NetWorker.Downloader : netWorker);
        if ((i & 2) != 0 && (preloadType = PreloadConfigKt.calcMainUrlType(str)) == null) {
            preloadType = PreloadType.LYNX;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PreloadConfig(String str, PreloadType preloadType, Map<String, ? extends List<ResourceConfig>> map, boolean z, boolean z2, NetWorker netWorker) {
        this(r0 == null || r0.length() == 0 ? null : new ResourceConfig(str, z, null, z2, netWorker, 4, null), preloadType, map);
        Intrinsics.checkParameterIsNotNull(preloadType, "type");
        Intrinsics.checkParameterIsNotNull(netWorker, "netWorker");
        String str2 = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PreloadConfig(String str, PreloadType preloadType, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, preloadType, (Map<String, ? extends List<ResourceConfig>>) map);
        if ((i & 2) != 0 && (preloadType = PreloadConfigKt.calcMainUrlType(str)) == null) {
            preloadType = PreloadType.LYNX;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PreloadConfig(String str, PreloadType preloadType, Map<String, ? extends List<ResourceConfig>> map) {
        this(str, preloadType, map, true, false, NetWorker.Downloader);
        Intrinsics.checkParameterIsNotNull(preloadType, "type");
    }
}
