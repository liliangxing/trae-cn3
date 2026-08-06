package com.bytedance.android.anniex.engine;

import android.util.LruCache;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXLynxEngineManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R3\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00070\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/anniex/engine/AnnieXLynxEngineManager;", "", "()V", "TAG", "", "engineCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/util/LruCache;", "Lcom/bytedance/android/anniex/engine/AnnieXLynxEngine;", "getEngineCacheMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "engineCacheMap$delegate", "Lkotlin/Lazy;", "getEngine", "bid", "sessionId", "hasExpired", "", "putEngine", "annieXLynxEngine", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLynxEngineManager {
    public static final String TAG = "AnnieXLynxEngineManager";
    public static final AnnieXLynxEngineManager INSTANCE = new AnnieXLynxEngineManager();

    /* renamed from: engineCacheMap$delegate, reason: from kotlin metadata */
    private static final Lazy engineCacheMap = LazyKt.lazy(new Function0<ConcurrentHashMap<String, LruCache<String, AnnieXLynxEngine>>>() { // from class: com.bytedance.android.anniex.engine.AnnieXLynxEngineManager$engineCacheMap$2
        public final ConcurrentHashMap<String, LruCache<String, AnnieXLynxEngine>> invoke() {
            return new ConcurrentHashMap<>();
        }
    });

    private AnnieXLynxEngineManager() {
    }

    private final ConcurrentHashMap<String, LruCache<String, AnnieXLynxEngine>> getEngineCacheMap() {
        return (ConcurrentHashMap) engineCacheMap.getValue();
    }

    public final synchronized AnnieXLynxEngine getEngine(String bid, String sessionId) {
        AnnieXLynxEngine annieXLynxEngine;
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        hasExpired();
        LruCache<String, AnnieXLynxEngine> lruCache = getEngineCacheMap().get(bid);
        AnnieXLynxEngine annieXLynxEngine2 = null;
        if (lruCache == null || (annieXLynxEngine = lruCache.get(sessionId)) == null) {
            return null;
        }
        if (annieXLynxEngine.isExpired()) {
            lruCache.remove(sessionId);
            HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "AnnieXLynxEngine expired, bid: " + bid + ", sessionId: " + sessionId, (Map) null, (LoggerContext) null, 12, (Object) null);
        } else {
            lruCache.remove(sessionId);
            annieXLynxEngine2 = annieXLynxEngine;
        }
        return annieXLynxEngine2;
    }

    public final synchronized void putEngine(String bid, String sessionId, AnnieXLynxEngine annieXLynxEngine) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(annieXLynxEngine, "annieXLynxEngine");
        if (getEngineCacheMap().containsKey(bid)) {
            LruCache<String, AnnieXLynxEngine> lruCache = getEngineCacheMap().get(bid);
            if (lruCache != null) {
                lruCache.put(sessionId, annieXLynxEngine);
            }
            HybridLogger hybridLogger = HybridLogger.INSTANCE;
            StringBuilder append = new StringBuilder("AnnieXLynxEngine Count, bid: ").append(bid).append(", count: ");
            LruCache<String, AnnieXLynxEngine> lruCache2 = getEngineCacheMap().get(bid);
            HybridLogger.i$default(hybridLogger, TAG, append.append(lruCache2 != null ? Integer.valueOf(lruCache2.size()) : null).toString(), (Map) null, (LoggerContext) null, 12, (Object) null);
        } else {
            LruCache<String, AnnieXLynxEngine> lruCache3 = new LruCache<>(annieXLynxEngine.getCacheNumber());
            lruCache3.put(sessionId, annieXLynxEngine);
            HybridLogger hybridLogger2 = HybridLogger.INSTANCE;
            StringBuilder append2 = new StringBuilder("AnnieXLynxEngine Count, bid: ").append(bid).append(", count: ");
            LruCache<String, AnnieXLynxEngine> lruCache4 = INSTANCE.getEngineCacheMap().get(bid);
            HybridLogger.i$default(hybridLogger2, TAG, append2.append(lruCache4 != null ? Integer.valueOf(lruCache4.size()) : null).toString(), (Map) null, (LoggerContext) null, 12, (Object) null);
            getEngineCacheMap().put(bid, lruCache3);
        }
    }

    public final synchronized void hasExpired() {
        Iterator<Map.Entry<String, LruCache<String, AnnieXLynxEngine>>> it = getEngineCacheMap().entrySet().iterator();
        while (it.hasNext()) {
            LruCache<String, AnnieXLynxEngine> value = it.next().getValue();
            Map<String, AnnieXLynxEngine> snapshot = value.snapshot();
            Intrinsics.checkNotNullExpressionValue(snapshot, "lruCache.snapshot()");
            for (Map.Entry<String, AnnieXLynxEngine> entry : snapshot.entrySet()) {
                String key = entry.getKey();
                if (entry.getValue().isExpired()) {
                    value.remove(key);
                }
            }
        }
    }
}
