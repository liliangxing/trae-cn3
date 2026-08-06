package com.bytedance.iesgurd.meta;

import com.bytedance.geckox.GeckoUpdateParams;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.policy.meta.MetaDataManager;
import com.bytedance.ies.bullet.service.sdk.param.StringListParam;
import com.bytedance.iesgurd.IESGurdUpdatePriority;
import com.bytedance.iesgurd.IESGurdUpdateResultInfo;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.update.UpdateQueue;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrepareMetaManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0007J\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\u0005J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005J'\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005R)\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/iesgurd/meta/PrepareMetaManager;", "", "()V", "metaMap", "", "", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/iesgurd/meta/PrepareMeta;", "getMetaMap", "()Ljava/util/Map;", "addMeta", "", "accessKey", "channel", IPiaCacheProvider.CacheConfig.FIELD_META, "getMetas", "", "getUpdateMeta", "removeUpdateMeta", IPiaCacheProvider.CacheConfig.FIELD_VERSION, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "updateWhenAccess", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrepareMetaManager {
    public static final PrepareMetaManager INSTANCE = new PrepareMetaManager();
    private static final Map<String, ConcurrentHashMap<String, PrepareMeta>> metaMap = new ConcurrentHashMap();

    private PrepareMetaManager() {
    }

    public final Map<String, ConcurrentHashMap<String, PrepareMeta>> getMetaMap() {
        return metaMap;
    }

    public final void addMeta(String accessKey, String channel, PrepareMeta meta) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Intrinsics.checkParameterIsNotNull(meta, IPiaCacheProvider.CacheConfig.FIELD_META);
        Map<String, ConcurrentHashMap<String, PrepareMeta>> map = metaMap;
        if (map.get(accessKey) == null) {
            synchronized (map) {
                if (map.get(accessKey) == null) {
                    map.put(accessKey, new ConcurrentHashMap<>());
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        ConcurrentHashMap<String, PrepareMeta> concurrentHashMap = map.get(accessKey);
        if (concurrentHashMap == null) {
            Intrinsics.throwNpe();
        }
        concurrentHashMap.put(channel, meta);
    }

    public final Map<String, PrepareMeta> getMetas(String accessKey) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        return metaMap.get(accessKey);
    }

    public final PrepareMeta getUpdateMeta(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        ConcurrentHashMap<String, PrepareMeta> concurrentHashMap = metaMap.get(accessKey);
        if (concurrentHashMap != null) {
            return concurrentHashMap.get(channel);
        }
        return null;
    }

    public static /* synthetic */ void removeUpdateMeta$default(PrepareMetaManager prepareMetaManager, String str, String str2, Long l, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        prepareMetaManager.removeUpdateMeta(str, str2, l);
    }

    public final void removeUpdateMeta(String accessKey, String channel, Long version) {
        PrepareMeta prepareMeta;
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        ConcurrentHashMap<String, PrepareMeta> concurrentHashMap = metaMap.get(accessKey);
        if (concurrentHashMap == null || (prepareMeta = concurrentHashMap.get(channel)) == null) {
            return;
        }
        if (version == null || prepareMeta.getVersion() == version.longValue()) {
            GeckoLogger.d("remove update meta:" + accessKey + StringListParam.SPLIT_DELIMITER + channel + ",version:" + prepareMeta.getVersion());
            concurrentHashMap.remove(channel);
        }
    }

    public final void updateWhenAccess(final String accessKey, final String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        ConcurrentHashMap<String, PrepareMeta> concurrentHashMap = metaMap.get(accessKey);
        PrepareMeta prepareMeta = concurrentHashMap != null ? concurrentHashMap.get(channel) : null;
        if (prepareMeta == null) {
            MetaDataManager.INSTANCE.removeFromBlock(accessKey, channel);
        } else {
            if (prepareMeta.getInQueue()) {
                return;
            }
            prepareMeta.setInQueue(true);
            prepareMeta.ignoreBlocks();
            prepareMeta.setReqType(ReqType.UPDATE_BY_ACCESS);
            UpdateQueue.INSTANCE.add(CollectionsKt.listOf(prepareMeta), new GeckoUpdateParams("", (String) null, (List) null, (String) null, false, IESGurdUpdatePriority.HIGH, new Function1<IESGurdUpdateResultInfo, Unit>() { // from class: com.bytedance.iesgurd.meta.PrepareMetaManager$updateWhenAccess$params$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((IESGurdUpdateResultInfo) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(IESGurdUpdateResultInfo iESGurdUpdateResultInfo) {
                    Intrinsics.checkParameterIsNotNull(iESGurdUpdateResultInfo, "it");
                    MetaDataManager.INSTANCE.removeFromBlock(accessKey, channel);
                }
            }, (Function1) null, false, (Map) null, 926, (DefaultConstructorMarker) null));
        }
    }
}
