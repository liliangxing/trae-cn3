package com.bytedance.ies.bullet.preloadv2.cache;

import com.bytedance.ies.bullet.preloadv2.utils.PreloadLogger;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.IPreloadV2ServiceKt;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import com.bytedance.pia.core.metrics.ErrorType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PreloadCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\fJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020\u0003J\u001a\u0010!\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020\u0010H\u0016J\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001aH\u0004J\u000e\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u0003J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\fJ\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001a0&R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadCache;", "", "maxSize", "", "(I)V", "mCache", "Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadLruCache;", "getMCache", "()Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadLruCache;", "setMCache", "(Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadLruCache;)V", "name", "", "getName", "()Ljava/lang/String;", "switch", "", "getSwitch", "()Z", "setSwitch", "(Z)V", "checkEnoughSpace", "size", "", "generateLruCache", "getCache", "Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadItem;", "key", "handleExpire", "", "cache", "useRedirectKey", "nowSize", "put", "reSize", "updateSize", "removeCache", ErrorType.SNAPSHOT, "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PreloadCache {
    private PreloadLruCache mCache;
    private final String name;
    private volatile boolean switch;

    public PreloadCache(int i) {
        PreloadLruCache generateLruCache = generateLruCache(i);
        this.mCache = generateLruCache;
        this.name = generateLruCache.getName();
        this.switch = true;
    }

    protected final PreloadLruCache getMCache() {
        return this.mCache;
    }

    protected final void setMCache(PreloadLruCache preloadLruCache) {
        Intrinsics.checkNotNullParameter(preloadLruCache, "<set-?>");
        this.mCache = preloadLruCache;
    }

    public final String getName() {
        return this.name;
    }

    protected final boolean getSwitch() {
        return this.switch;
    }

    protected final void setSwitch(boolean z) {
        this.switch = z;
    }

    public PreloadLruCache generateLruCache(int size) {
        return new PreloadLruCache("Default", size);
    }

    public final synchronized void reSize(int updateSize) {
        try {
            this.mCache.evictAll();
        } catch (Throwable th) {
            BulletLogger.INSTANCE.printReject(th, "PreloadCache reSize", IPreloadV2ServiceKt.PRELOAD_LOG_TAG);
            IMonitorReportService iMonitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(IMonitorReportService.class);
            if (iMonitorReportService != null) {
                ReportInfo reportInfo = new ReportInfo("bdx_preload_cache_fail", null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cacheName", this.mCache.getName());
                jSONObject.put("updateSize", updateSize);
                jSONObject.put("lruCacheSize", this.mCache.size());
                jSONObject.put("lruMapSize", this.mCache.snapshot().size());
                reportInfo.setCategory(jSONObject);
                iMonitorReportService.report(reportInfo);
            }
        }
        if (updateSize <= 0) {
            this.switch = false;
        } else {
            this.mCache = generateLruCache(updateSize);
        }
    }

    public final int maxSize() {
        return this.mCache.maxSize();
    }

    public final int nowSize() {
        return this.mCache.size();
    }

    public final Map<String, PreloadItem> snapshot() {
        Map<String, PreloadItem> snapshot = this.mCache.snapshot();
        Intrinsics.checkNotNullExpressionValue(snapshot, "mCache.snapshot()");
        return snapshot;
    }

    public final boolean checkEnoughSpace(long size) {
        return ((long) nowSize()) + size <= ((long) maxSize());
    }

    public static /* synthetic */ boolean put$default(PreloadCache preloadCache, PreloadItem preloadItem, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: put");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return preloadCache.put(preloadItem, z);
    }

    public synchronized boolean put(PreloadItem cache, boolean useRedirectKey) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        if (!this.switch) {
            cache.clearMemory();
            return false;
        }
        String key = (!useRedirectKey || cache.getRedirectPath() == null) ? cache.getKey() : cache.getRedirectPath();
        if (key != null && !put(key, cache)) {
            cache.clearMemory();
            return false;
        }
        handleExpire(cache, useRedirectKey);
        return true;
    }

    protected final synchronized boolean put(String key, PreloadItem cache) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(cache, "cache");
        if (!this.switch) {
            return false;
        }
        PreloadItem preloadItem = this.mCache.get(key);
        if (preloadItem != null && preloadItem.checkValid()) {
            PreloadLogger.INSTANCE.m43i("已有缓存 " + this.name + ", size " + this.mCache.size() + ", maxSize " + this.mCache.maxSize() + ", " + cache.getType().getTag() + ' ' + key);
            return false;
        }
        PreloadLogger.INSTANCE.m43i("放入缓存 " + this.name + ", size " + this.mCache.size() + ", maxSize " + this.mCache.maxSize() + ", " + cache.getType().getTag() + ' ' + key);
        this.mCache.put(key, cache);
        return true;
    }

    public final synchronized PreloadItem getCache(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        PreloadItem preloadItem = null;
        if (!this.switch) {
            return null;
        }
        PreloadLogger.INSTANCE.m41d("获取缓存 " + this.name + ", " + key);
        PreloadItem preloadItem2 = this.mCache.get(key);
        if (preloadItem2 != null) {
            if (preloadItem2.checkValid() && preloadItem2.checkFileExists()) {
                PreloadLogger.INSTANCE.m43i("获取成功 " + this.name + ", " + key);
                preloadItem = preloadItem2;
            } else {
                removeCache(key);
            }
        }
        return preloadItem;
    }

    public final synchronized void removeCache(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.switch) {
            this.mCache.remove(key);
        }
    }

    private final void handleExpire(final PreloadItem cache, final boolean useRedirectKey) {
        if (cache.getHighPriority() && cache.getExpire() == PreloadItemKt.DEFAULT_EXPIRE_TIME) {
            return;
        }
        PreloadCacheKt.getExpireHandler().postDelayed(new Runnable() { // from class: com.bytedance.ies.bullet.preloadv2.cache.PreloadCache$handleExpire$1
            @Override // java.lang.Runnable
            public final void run() {
                String key = (!useRedirectKey || cache.getRedirectPath() == null) ? cache.getKey() : cache.getRedirectPath();
                if (key != null) {
                    this.removeCache(key);
                }
            }
        }, cache.getExpire());
    }
}
