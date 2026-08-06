package com.bytedance.timonbase.commoncache.strategy;

import android.os.SystemClock;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.TMLogger;
import com.bytedance.timonbase.commoncache.store.CacheStore;
import com.bytedance.timonbase.scene.ScenesDetector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PeriodSceneCacheStrategy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/timonbase/commoncache/strategy/PeriodSceneCacheStrategy;", "Lcom/bytedance/timonbase/commoncache/strategy/CacheUpdateStrategy;", "period", "", "(J)V", "lastCalledClock", "lastStatus", "", "isCurrentStatusChanged", "", "needUpdate", "store", "Lcom/bytedance/timonbase/commoncache/store/CacheStore;", "storeKey", "", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PeriodSceneCacheStrategy implements CacheUpdateStrategy {
    private long lastCalledClock;
    private int lastStatus = -1;
    private final long period;

    public PeriodSceneCacheStrategy(long j) {
        this.period = j;
    }

    @Override // com.bytedance.timonbase.commoncache.strategy.CacheUpdateStrategy
    public boolean needUpdate(CacheStore store, String storeKey) {
        Intrinsics.checkParameterIsNotNull(store, "store");
        Intrinsics.checkParameterIsNotNull(storeKey, "storeKey");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (isCurrentStatusChanged()) {
            this.lastCalledClock = elapsedRealtime;
            if (TMEnv.INSTANCE.getDEBUG()) {
                TMLogger.INSTANCE.m219d("PeriodSceneCacheStrategy", "有场景变化，不用缓存值");
            }
            return true;
        }
        if (!store.containsKey(storeKey)) {
            this.lastCalledClock = elapsedRealtime;
            if (TMEnv.INSTANCE.getDEBUG()) {
                TMLogger.INSTANCE.m219d("PeriodSceneCacheStrategy", "没有缓存值");
            }
            return true;
        }
        if (elapsedRealtime - this.lastCalledClock <= this.period) {
            return false;
        }
        if (TMEnv.INSTANCE.getDEBUG()) {
            TMLogger.INSTANCE.m219d("PeriodSceneCacheStrategy", "超出有效时间 " + this.period);
        }
        this.lastCalledClock = elapsedRealtime;
        return true;
    }

    private final boolean isCurrentStatusChanged() {
        int appMode$default = ScenesDetector.getAppMode$default(ScenesDetector.INSTANCE, false, false, false, false, false, false, 63, null);
        if (this.lastStatus == appMode$default) {
            return false;
        }
        this.lastStatus = appMode$default;
        return true;
    }
}
