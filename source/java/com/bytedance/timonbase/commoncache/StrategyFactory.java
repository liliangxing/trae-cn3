package com.bytedance.timonbase.commoncache;

import com.bytedance.timonbase.TMLogger;
import com.bytedance.timonbase.commoncache.strategy.CacheUpdateStrategy;
import com.bytedance.timonbase.commoncache.strategy.PeriodCacheStrategy;
import com.bytedance.timonbase.commoncache.strategy.PersistCacheStrategy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StrategyFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/timonbase/commoncache/StrategyFactory;", "", "()V", "DEFAULT_PERIOD", "", "strategyGenerators", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/timonbase/commoncache/StrategyFactory$StrategyGenerator;", "getStrategy", "Lcom/bytedance/timonbase/commoncache/strategy/CacheUpdateStrategy;", "name", "params", "", "registerStrategyGenerator", "", "generator", "StrategyGenerator", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class StrategyFactory {
    public static final long DEFAULT_PERIOD = 60000;
    public static final StrategyFactory INSTANCE = new StrategyFactory();
    private static final ConcurrentHashMap<String, StrategyGenerator> strategyGenerators;

    /* compiled from: StrategyFactory.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/timonbase/commoncache/StrategyFactory$StrategyGenerator;", "", "generate", "Lcom/bytedance/timonbase/commoncache/strategy/CacheUpdateStrategy;", "params", "", "", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface StrategyGenerator {
        CacheUpdateStrategy generate(Map<String, String> params);
    }

    static {
        ConcurrentHashMap<String, StrategyGenerator> concurrentHashMap = new ConcurrentHashMap<>();
        strategyGenerators = concurrentHashMap;
        concurrentHashMap.put("period", new StrategyGenerator() { // from class: com.bytedance.timonbase.commoncache.StrategyFactory.1
            @Override // com.bytedance.timonbase.commoncache.StrategyFactory.StrategyGenerator
            public CacheUpdateStrategy generate(Map<String, String> params) {
                Intrinsics.checkParameterIsNotNull(params, "params");
                String str = params.get("period");
                if (str == null) {
                    str = String.valueOf(60000L);
                }
                String str2 = str;
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= str2.length()) {
                        z = true;
                        break;
                    }
                    if (!Character.isDigit(str2.charAt(i))) {
                        break;
                    }
                    i++;
                }
                if (z) {
                    return new PeriodCacheStrategy(Long.parseLong(str));
                }
                return new PeriodCacheStrategy(60000L);
            }
        });
        concurrentHashMap.put("persist", new StrategyGenerator() { // from class: com.bytedance.timonbase.commoncache.StrategyFactory.2
            @Override // com.bytedance.timonbase.commoncache.StrategyFactory.StrategyGenerator
            public CacheUpdateStrategy generate(Map<String, String> params) {
                Intrinsics.checkParameterIsNotNull(params, "params");
                return new PersistCacheStrategy();
            }
        });
    }

    private StrategyFactory() {
    }

    public final CacheUpdateStrategy getStrategy(String name, Map<String, String> params) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(params, "params");
        ConcurrentHashMap<String, StrategyGenerator> concurrentHashMap = strategyGenerators;
        if (concurrentHashMap.get(name) != null) {
            StrategyGenerator strategyGenerator = concurrentHashMap.get(name);
            if (strategyGenerator == null) {
                Intrinsics.throwNpe();
            }
            return strategyGenerator.generate(params);
        }
        TMLogger.INSTANCE.m221e(CacheEnv.TAG, "getStrategy " + name + " error");
        return null;
    }

    public final void registerStrategyGenerator(String name, StrategyGenerator generator) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(generator, "generator");
        strategyGenerators.put(name, generator);
    }
}
