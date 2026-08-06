package com.bytedance.timonbase.commoncache.strategy;

import android.os.SystemClock;
import com.bytedance.timonbase.commoncache.store.CacheStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PeriodCacheStrategy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/timonbase/commoncache/strategy/PeriodCacheStrategy;", "Lcom/bytedance/timonbase/commoncache/strategy/CacheUpdateStrategy;", "period", "", "(J)V", "lastCalledClock", "getLastCalledClock", "()J", "setLastCalledClock", "needUpdate", "", "store", "Lcom/bytedance/timonbase/commoncache/store/CacheStore;", "storeKey", "", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class PeriodCacheStrategy implements CacheUpdateStrategy {
    private long lastCalledClock;
    private final long period;

    public PeriodCacheStrategy(long j) {
        this.period = j;
    }

    public final long getLastCalledClock() {
        return this.lastCalledClock;
    }

    public final void setLastCalledClock(long j) {
        this.lastCalledClock = j;
    }

    @Override // com.bytedance.timonbase.commoncache.strategy.CacheUpdateStrategy
    public boolean needUpdate(CacheStore store, String storeKey) {
        Intrinsics.checkParameterIsNotNull(store, "store");
        Intrinsics.checkParameterIsNotNull(storeKey, "storeKey");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!store.containsKey(storeKey)) {
            this.lastCalledClock = elapsedRealtime;
            return true;
        }
        if (elapsedRealtime - this.lastCalledClock <= this.period) {
            return false;
        }
        this.lastCalledClock = elapsedRealtime;
        return true;
    }
}
