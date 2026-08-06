package com.bytedance.iesgurd.loader;

import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.listener.ListenerManager;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.policy.meta.MetaDataManager;
import com.bytedance.geckox.strategy.PreUpdateManager;
import com.bytedance.geckox.utils.ChannelState;
import com.bytedance.geckox.utils.GeckoExecutors;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.iesgurd.IESGurdKit;
import com.bytedance.iesgurd.IESGurdObserver;
import com.bytedance.iesgurd.IESGurdObserverAccessInfo;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.PrepareMetaManager;
import com.bytedance.iesgurd.statistic.UploadStatistic;
import com.bytedance.iesgurd.strategy.ColdStartManager;
import com.bytedance.iesgurd.update.UpdateQueue;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AccessManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JC\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\u0010\u000eJ-\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u0011J:\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/iesgurd/loader/AccessManager;", "", "()V", "getUploadData", "Lorg/json/JSONObject;", "accessKey", "", "channel", IPiaCacheProvider.CacheConfig.FIELD_VERSION, "", "type", "pair", "Lkotlin/Pair;", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lkotlin/Pair;)Lorg/json/JSONObject;", "handleAccess", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "runAccessActions", "offlineVersion", "accessTime", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AccessManager {
    public static final AccessManager INSTANCE = new AccessManager();

    private AccessManager() {
    }

    public final void handleAccess(final String accessKey, final String channel, final Long version, final String type) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Intrinsics.checkParameterIsNotNull(type, "type");
        final long currentTimeMillis = System.currentTimeMillis();
        GeckoExecutors.INSTANCE.getAccessExecutor().execute(new Runnable() { // from class: com.bytedance.iesgurd.loader.AccessManager$handleAccess$1
            @Override // java.lang.Runnable
            public final void run() {
                Long l = version;
                long longValue = l != null ? l.longValue() : 0L;
                JSONObject uploadData = AccessManager.INSTANCE.getUploadData(accessKey, channel, version, type, AccessManager.INSTANCE.runAccessActions(accessKey, channel, longValue, longValue, currentTimeMillis));
                if (uploadData != null) {
                    UploadStatistic.INSTANCE.uploadEventWithJson("geckosdk_resource_access_stats", uploadData);
                }
            }
        });
    }

    public final Pair<Boolean, Long> runAccessActions(String accessKey, String channel, long version, long offlineVersion, long accessTime) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        if (offlineVersion == 0) {
            ChannelState.INSTANCE.channelAccessed(accessKey, channel);
        } else {
            ChannelState.INSTANCE.setChannelConsumed(accessKey, channel);
        }
        Pair<Boolean, Long> resourceAccessUpdateMetaData = MetaDataManager.INSTANCE.resourceAccessUpdateMetaData(accessKey, channel, accessTime);
        try {
            Result.Companion companion = Result.Companion;
            AccessManager accessManager = this;
            Iterator it = ListenerManager.INSTANCE.getListeners().iterator();
            while (it.hasNext()) {
                ((GeckoUpdateListener) it.next()).onChannelAccess(new GeckoUpdateListener.GeckoParams(accessKey, channel, version));
            }
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        PrepareMetaManager.INSTANCE.updateWhenAccess(accessKey, channel);
        PreUpdateManager.INSTANCE.triggerTargetChannelUpdate(accessKey, channel);
        IESGurdObserverAccessInfo iESGurdObserverAccessInfo = new IESGurdObserverAccessInfo(accessKey, channel, version);
        Iterator<Map.Entry<String, IESGurdObserver>> it2 = IESGurdKit.INSTANCE.getObservers$geckox_noasanRelease().entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().onResAccess(iESGurdObserverAccessInfo);
        }
        return resourceAccessUpdateMetaData;
    }

    public final JSONObject getUploadData(String accessKey, String channel, Long version, String type, Pair<Boolean, Long> pair) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(pair, "pair");
        try {
            Result.Companion companion = Result.Companion;
            AccessManager accessManager = this;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("access_key", accessKey);
            jSONObject.put("channel", channel);
            jSONObject.put("id", version == null ? ViewVisibleBridge.INVISIBLE : String.valueOf(version.longValue()));
            jSONObject.put("type", type);
            jSONObject.put("is_blacklist", ((Boolean) pair.getFirst()).booleanValue() ? 1 : 0);
            if (((Number) pair.getSecond()).longValue() > 0) {
                jSONObject.put("dur_expire_clean_to_access", String.valueOf(((Number) pair.getSecond()).longValue()));
            }
            jSONObject.put("cold_start_finish", ColdStartManager.INSTANCE.isFinish());
            PrepareMeta updateMeta = PrepareMetaManager.INSTANCE.getUpdateMeta(accessKey, channel);
            if (updateMeta != null) {
                jSONObject.put("prepare_id", updateMeta.getVersion());
                jSONObject.put("prepare_block_type", updateMeta.getBlockType());
                jSONObject.put("prepare_updating", UpdateQueue.INSTANCE.checkIsUpdating(accessKey, channel));
            }
            return jSONObject;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Throwable th2 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
            if (th2 == null) {
                throw null;
            }
            GeckoLogger.e("resource access occurs exception", th2);
            return null;
        }
    }
}
