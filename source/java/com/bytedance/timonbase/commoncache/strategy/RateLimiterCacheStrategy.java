package com.bytedance.timonbase.commoncache.strategy;

import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.TMLogger;
import com.bytedance.timonbase.commoncache.ratelimiter.RateLimiter;
import com.bytedance.timonbase.commoncache.store.CacheStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateLimiterCacheStrategy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/timonbase/commoncache/strategy/RateLimiterCacheStrategy;", "Lcom/bytedance/timonbase/commoncache/strategy/CacheUpdateStrategy;", "rate", "", "(D)V", "rateLimiter", "Lcom/bytedance/timonbase/commoncache/ratelimiter/RateLimiter;", "needUpdate", "", "store", "Lcom/bytedance/timonbase/commoncache/store/CacheStore;", "storeKey", "", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class RateLimiterCacheStrategy implements CacheUpdateStrategy {
    private final double rate;
    public final RateLimiter rateLimiter;

    public RateLimiterCacheStrategy(double d) {
        this.rate = d;
        RateLimiter create = RateLimiter.create(d);
        Intrinsics.checkExpressionValueIsNotNull(create, "RateLimiter.create(rate)");
        this.rateLimiter = create;
    }

    @Override // com.bytedance.timonbase.commoncache.strategy.CacheUpdateStrategy
    public boolean needUpdate(CacheStore store, String storeKey) {
        Intrinsics.checkParameterIsNotNull(store, "store");
        Intrinsics.checkParameterIsNotNull(storeKey, "storeKey");
        boolean z = true;
        if (this.rateLimiter.tryAcquire()) {
            if (TMEnv.INSTANCE.getDEBUG()) {
                TMLogger.INSTANCE.m219d("RateLimiterCacheStrategy", storeKey + " 拿到令牌");
            }
        } else {
            z = true ^ store.containsKey(storeKey);
            if (TMEnv.INSTANCE.getDEBUG()) {
                if (z) {
                    TMLogger.INSTANCE.m219d("RateLimiterCacheStrategy", storeKey + " 没拿到令牌且没有拿到缓存");
                } else {
                    TMLogger.INSTANCE.m219d("RateLimiterCacheStrategy", storeKey + " 没拿到令牌且拿到缓存");
                }
            }
        }
        return z;
    }
}
