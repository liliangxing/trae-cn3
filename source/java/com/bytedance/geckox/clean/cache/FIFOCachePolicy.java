package com.bytedance.geckox.clean.cache;

import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.bytedance.iesgurd.clean.CleanManager;
import com.bytedance.iesgurd.core.GeckoStore;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.ChannelMetaManager;
import com.bytedance.iesgurd.statistic.model.CleanStrategy;
import com.bytedance.iesgurd.statistic.model.StatisticCleanData;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FIFOCachePolicy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\fH\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/geckox/clean/cache/FIFOCachePolicy;", "Lcom/bytedance/geckox/clean/cache/CachePolicy;", "()V", "append", "", "attach", "configuration", "Lcom/bytedance/geckox/clean/cache/CacheConfig;", "rootDir", "Ljava/io/File;", "accessKeys", "", "", "deleteChannels", "accessKey", "visit", "channel", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class FIFOCachePolicy extends CachePolicy {
    @Override // com.bytedance.geckox.clean.cache.CachePolicy
    public void visit(String channel) {
        Intrinsics.checkParameterIsNotNull(channel, "channel");
    }

    @Override // com.bytedance.geckox.clean.cache.CachePolicy
    public void attach(CacheConfig configuration, File rootDir, List<String> accessKeys) {
        Intrinsics.checkParameterIsNotNull(configuration, "configuration");
        Intrinsics.checkParameterIsNotNull(rootDir, "rootDir");
        Intrinsics.checkParameterIsNotNull(accessKeys, "accessKeys");
        super.attach(configuration, rootDir, accessKeys);
    }

    @Override // com.bytedance.geckox.clean.cache.CachePolicy
    public void append() {
        for (String str : this.mAccessKeys) {
            GeckoStore geckoStore = GeckoStore.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(str, "ak");
            if (geckoStore.isInLocalAks(str)) {
                deleteChannels(str);
            }
        }
    }

    private final void deleteChannels(String accessKey) {
        Map metas = ChannelMetaManager.INSTANCE.getMetas(accessKey);
        Map map = metas != null ? MapsKt.toMap(metas) : null;
        if (map == null || map.isEmpty()) {
            return;
        }
        int size = map.size();
        CacheConfig cacheConfig = this.mConfig;
        Intrinsics.checkExpressionValueIsNotNull(cacheConfig, "mConfig");
        int limitCount = size - cacheConfig.getLimitCount();
        if (limitCount <= 0) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        final HashMap hashMap = new HashMap();
        for (String str : arrayList) {
            Intrinsics.checkExpressionValueIsNotNull(str, "it");
            Object obj = map.get(str);
            if (obj == null) {
                Intrinsics.throwNpe();
            }
            Long updateTime = ((ChannelMeta) obj).getUpdateTime();
            hashMap.put(str, Long.valueOf(updateTime != null ? updateTime.longValue() : 0L));
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.size() > 1) {
            CollectionsKt.sortWith(arrayList2, new Comparator<T>() { // from class: com.bytedance.geckox.clean.cache.FIFOCachePolicy$deleteChannels$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues((Long) hashMap.get((String) t), (Long) hashMap.get((String) t2));
                }
            });
        }
        File file = new File(this.mRootDir, accessKey);
        List<String> subList = arrayList.subList(0, limitCount);
        Intrinsics.checkExpressionValueIsNotNull(subList, "channels.subList(0, needDeleteSize)");
        for (String str2 : subList) {
            ChannelMetaManager channelMetaManager = ChannelMetaManager.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(str2, "channel");
            channelMetaManager.removeChannel(accessKey, str2);
            File file2 = new File(file, str2);
            CleanManager cleanManager = CleanManager.INSTANCE;
            String absolutePath = file2.getAbsolutePath();
            Intrinsics.checkExpressionValueIsNotNull(absolutePath, "channelFile.absolutePath");
            boolean cleanAllVersion = cleanManager.cleanAllVersion(absolutePath);
            CacheConfig cacheConfig2 = this.mConfig;
            Intrinsics.checkExpressionValueIsNotNull(cacheConfig2, "mConfig");
            if (cacheConfig2.getCleanListener() != null) {
                CacheConfig cacheConfig3 = this.mConfig;
                Intrinsics.checkExpressionValueIsNotNull(cacheConfig3, "mConfig");
                cacheConfig3.getCleanListener().onCleaned(str2, cleanAllVersion);
            }
            new StatisticCleanData(CleanStrategy.CACHE_POLICY, 1, accessKey, str2, 0L, 0, 0, (String) null, BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND, (DefaultConstructorMarker) null).upload();
        }
    }
}
