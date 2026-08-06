package com.bytedance.iesgurd.clean;

import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.AccessKeyCacheConfig;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.ChannelMetaManager;
import com.bytedance.iesgurd.statistic.model.CleanStrategy;
import com.bytedance.iesgurd.statistic.model.StatisticCleanData;
import java.io.File;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccessKeyCacheManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/iesgurd/clean/AccessKeyCacheManager;", "", "()V", "cacheConfigs", "", "", "Lcom/bytedance/iesgurd/AccessKeyCacheConfig;", "runClean", "", "accessKey", "setConfig", "config", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AccessKeyCacheManager {
    public static final AccessKeyCacheManager INSTANCE = new AccessKeyCacheManager();
    private static final Map<String, AccessKeyCacheConfig> cacheConfigs = new ConcurrentHashMap();

    private AccessKeyCacheManager() {
    }

    public final void setConfig(String accessKey, AccessKeyCacheConfig config) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(config, "config");
        cacheConfigs.put(accessKey, config);
    }

    public final void runClean(String accessKey) {
        Map<String, ChannelMeta> metas;
        int size;
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        AccessKeyCacheConfig accessKeyCacheConfig = cacheConfigs.get(accessKey);
        if (accessKeyCacheConfig != null) {
            GeckoGlobalManager inst = GeckoGlobalManager.inst();
            Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
            String str = (String) inst.getAccessKeyDirs().get(accessKey);
            if (str == null || (metas = ChannelMetaManager.INSTANCE.getMetas(accessKey)) == null || (size = metas.size() - accessKeyCacheConfig.getLimit()) <= 0) {
                return;
            }
            List list = MapsKt.toList(metas);
            if (accessKeyCacheConfig.getPolicy() != AccessKeyCacheConfig.Policy.FIFO) {
                GeckoLogger.d("not support");
                return;
            }
            List sortedWith = CollectionsKt.sortedWith(list, new Comparator<T>() { // from class: com.bytedance.iesgurd.clean.AccessKeyCacheManager$runClean$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((ChannelMeta) ((Pair) t).getSecond()).getUpdateTime(), ((ChannelMeta) ((Pair) t2).getSecond()).getUpdateTime());
                }
            });
            File file = new File(str, accessKey);
            Iterator it = sortedWith.subList(0, size).iterator();
            while (it.hasNext()) {
                String str2 = (String) ((Pair) it.next()).getFirst();
                ChannelMetaManager.INSTANCE.removeChannel(accessKey, str2);
                File file2 = new File(file, str2);
                CleanManager cleanManager = CleanManager.INSTANCE;
                String absolutePath = file2.getAbsolutePath();
                Intrinsics.checkExpressionValueIsNotNull(absolutePath, "channelFile.absolutePath");
                cleanManager.cleanAllVersion(absolutePath);
                new StatisticCleanData(CleanStrategy.CACHE_POLICY, 1, accessKey, str2, 0L, 0, 0, null, 240, null).upload();
                CleanManager.INSTANCE.callbackWhenClean(accessKey, str2);
            }
        }
    }
}
