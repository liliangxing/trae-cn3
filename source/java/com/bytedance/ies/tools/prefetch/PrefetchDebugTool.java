package com.bytedance.ies.tools.prefetch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: PrefetchDebugTool.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0006H\u0000¢\u0006\u0002\b\u0016J%\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u001bJ\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00060\u001cJ\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001d0\u001cR3\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR7\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f0\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0010\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/PrefetchDebugTool;", "", "()V", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/ies/tools/prefetch/TrimmableLruCache;", "Lcom/bytedance/ies/tools/prefetch/PrefetchProcess;", "getCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "cacheMap$delegate", "Lkotlin/Lazy;", "configMap", "Ljava/util/ArrayList;", "Lcom/bytedance/ies/tools/prefetch/RawConfig;", "Lkotlin/collections/ArrayList;", "getConfigMap", "configMap$delegate", "addCache", "", "businessTag", "lruCache", "addCache$prefetch_release", "addConfig", "business", "project", "config", "addConfig$prefetch_release", "", "", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchDebugTool {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PrefetchDebugTool.class), "configMap", "getConfigMap()Ljava/util/concurrent/ConcurrentHashMap;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PrefetchDebugTool.class), "cacheMap", "getCacheMap()Ljava/util/concurrent/ConcurrentHashMap;"))};
    public static final PrefetchDebugTool INSTANCE = new PrefetchDebugTool();

    /* renamed from: configMap$delegate, reason: from kotlin metadata */
    private static final Lazy configMap = LazyKt.lazy(new Function0<ConcurrentHashMap<String, ArrayList<RawConfig>>>() { // from class: com.bytedance.ies.tools.prefetch.PrefetchDebugTool$configMap$2
        public final ConcurrentHashMap<String, ArrayList<RawConfig>> invoke() {
            return new ConcurrentHashMap<>();
        }
    });

    /* renamed from: cacheMap$delegate, reason: from kotlin metadata */
    private static final Lazy cacheMap = LazyKt.lazy(new Function0<ConcurrentHashMap<String, TrimmableLruCache<String, PrefetchProcess>>>() { // from class: com.bytedance.ies.tools.prefetch.PrefetchDebugTool$cacheMap$2
        public final ConcurrentHashMap<String, TrimmableLruCache<String, PrefetchProcess>> invoke() {
            return new ConcurrentHashMap<>();
        }
    });

    private final ConcurrentHashMap<String, TrimmableLruCache<String, PrefetchProcess>> getCacheMap() {
        Lazy lazy = cacheMap;
        KProperty kProperty = $$delegatedProperties[1];
        return (ConcurrentHashMap) lazy.getValue();
    }

    private final ConcurrentHashMap<String, ArrayList<RawConfig>> getConfigMap() {
        Lazy lazy = configMap;
        KProperty kProperty = $$delegatedProperties[0];
        return (ConcurrentHashMap) lazy.getValue();
    }

    private PrefetchDebugTool() {
    }

    public final void addConfig$prefetch_release(String business, String project, String config) {
        Intrinsics.checkParameterIsNotNull(business, "business");
        Intrinsics.checkParameterIsNotNull(project, "project");
        Intrinsics.checkParameterIsNotNull(config, "config");
        if (!getConfigMap().containsKey(business)) {
            getConfigMap().put(business, new ArrayList<>());
        }
        ArrayList<RawConfig> arrayList = getConfigMap().get(business);
        if (arrayList != null) {
            arrayList.add(new RawConfig(project, config));
        }
    }

    public final void addCache$prefetch_release(String businessTag, TrimmableLruCache<String, PrefetchProcess> lruCache) {
        Intrinsics.checkParameterIsNotNull(businessTag, "businessTag");
        Intrinsics.checkParameterIsNotNull(lruCache, "lruCache");
        getCacheMap().put(businessTag, lruCache);
    }

    /* renamed from: getConfigMap, reason: collision with other method in class */
    public final Map<String, List<RawConfig>> m615getConfigMap() {
        return getConfigMap();
    }

    /* renamed from: getCacheMap, reason: collision with other method in class */
    public final Map<String, TrimmableLruCache<String, PrefetchProcess>> m614getCacheMap() {
        return getCacheMap();
    }
}
