package com.bytedance.geckox.strategy;

import com.bytedance.geckox.GeckoConfig;
import com.bytedance.geckox.GeckoUpdateParams;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.listener.ListenerManager;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.geckox.utils.GeckoExecutors;
import com.bytedance.iesgurd.IESGurdUpdatePriority;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.ChannelMetaManager;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.PrepareMetaManager;
import com.bytedance.iesgurd.update.UpdateQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnDemandManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J2\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0010J4\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006H\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\tJ<\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0006\u0018\u00010\u00162\u0006\u0010\b\u001a\u00020\u0010¨\u0006\u0018"}, d2 = {"Lcom/bytedance/geckox/strategy/OnDemandManager;", "", "()V", "downloadMetas", "", "metas", "", "Lcom/bytedance/iesgurd/meta/PrepareMeta;", "params", "Lcom/bytedance/geckox/GeckoUpdateParams;", "filterLazy", "accessKey", "", "channels", "group", "toParamsNew", "Lcom/bytedance/geckox/OptionCheckUpdateParams;", "update", "", "updateFromClient", "config", "Lcom/bytedance/geckox/GeckoConfig;", "", "Lcom/bytedance/geckox/model/CheckRequestBodyModel$TargetChannel;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class OnDemandManager {
    public static final OnDemandManager INSTANCE = new OnDemandManager();

    private OnDemandManager() {
    }

    public final GeckoUpdateParams toParamsNew(OptionCheckUpdateParams params) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        return toParamsNew(params, null, null, null);
    }

    private final GeckoUpdateParams toParamsNew(OptionCheckUpdateParams params, String accessKey, String group, List<String> channels) {
        String tag = params.getTag();
        String str = tag;
        if (str == null || str.length() == 0) {
            tag = "gecko_client_default";
        }
        String str2 = tag;
        IESGurdUpdatePriority iESGurdUpdatePriority = IESGurdUpdatePriority.MIDDLE;
        int channelUpdatePriority = params.getChannelUpdatePriority();
        if (channelUpdatePriority == 0) {
            iESGurdUpdatePriority = IESGurdUpdatePriority.LOW;
        } else if (channelUpdatePriority == 1) {
            iESGurdUpdatePriority = IESGurdUpdatePriority.MIDDLE;
        } else if (channelUpdatePriority == 2) {
            iESGurdUpdatePriority = IESGurdUpdatePriority.HIGH;
        } else if (channelUpdatePriority == 3) {
            iESGurdUpdatePriority = IESGurdUpdatePriority.USE_INTERACTION;
        }
        GeckoUpdateParams geckoUpdateParams = new GeckoUpdateParams(str2, accessKey, channels, group, params.isLazyUpdate(), iESGurdUpdatePriority, null, null, params.isEnableDownloadAutoRetry(), null, 704, null);
        geckoUpdateParams.setEnableThrottle$geckox_noasanRelease(params.isEnableThrottle());
        geckoUpdateParams.setEnableRetry$geckox_noasanRelease(params.isEnableRetry());
        geckoUpdateParams.setListener$geckox_noasanRelease(params.getListener());
        return geckoUpdateParams;
    }

    public final boolean updateFromClient(GeckoConfig config, String group, Map<String, ? extends List<? extends CheckRequestBodyModel.TargetChannel>> channels, OptionCheckUpdateParams params) {
        List<? extends CheckRequestBodyModel.TargetChannel> list;
        Intrinsics.checkParameterIsNotNull(config, "config");
        Intrinsics.checkParameterIsNotNull(params, "params");
        if (params.isLazyUpdate()) {
            ArrayList arrayList = null;
            if (config.getAccessKeys().size() > 1) {
                GeckoUpdateListener listener = params.getListener();
                if (listener != null) {
                    listener.onCheckServerVersionFail(null, new IllegalArgumentException("lazy update not support multi ak"));
                }
                return true;
            }
            if ((channels != null ? channels.size() : 0) > 1) {
                GeckoUpdateListener listener2 = params.getListener();
                if (listener2 != null) {
                    listener2.onCheckServerVersionFail(null, new IllegalArgumentException("lazy update not support channels with multi ak"));
                }
                return true;
            }
            String accessKey = config.getAccessKey();
            List<? extends CheckRequestBodyModel.TargetChannel> list2 = channels != null ? channels.get(accessKey) : null;
            List<? extends CheckRequestBodyModel.TargetChannel> list3 = list2;
            boolean z = list3 == null || list3.isEmpty();
            String str = group;
            boolean z2 = (str == null || str.length() == 0) || Intrinsics.areEqual(group, "default");
            if (z && z2) {
                GeckoUpdateListener listener3 = params.getListener();
                if (listener3 != null) {
                    listener3.onCheckServerVersionFail(null, new IllegalArgumentException("lazy update argument error: channel empty and group empty"));
                }
                return true;
            }
            if (!z && !z2) {
                GeckoUpdateListener listener4 = params.getListener();
                if (listener4 != null) {
                    listener4.onCheckServerVersionFail(null, new IllegalArgumentException("lazy update argument error: channel not empty and group not empty"));
                }
                return true;
            }
            if (list2 != null) {
                List<? extends CheckRequestBodyModel.TargetChannel> list4 = list2;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                Iterator it = list4.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((CheckRequestBodyModel.TargetChannel) it.next()).channelName);
                }
                arrayList = arrayList2;
            }
            return update(toParamsNew(params, accessKey, group, arrayList));
        }
        if (config.getAccessKeys().size() > 1) {
            return false;
        }
        String accessKey2 = config.getAccessKey();
        if (channels == null || channels.size() != 1 || (list = channels.get(accessKey2)) == null || list.size() != 1) {
            return false;
        }
        return update(toParamsNew(params, accessKey2, group, CollectionsKt.listOf(list.get(0).channelName)));
    }

    public final boolean update(GeckoUpdateParams params) {
        PrepareMeta updateMeta;
        Intrinsics.checkParameterIsNotNull(params, "params");
        String accessKey = params.getAccessKey();
        if (accessKey == null) {
            Intrinsics.throwNpe();
        }
        String group = params.getGroup();
        List<String> channels = params.getChannels();
        if (params.getOnDemand()) {
            filterLazy(accessKey, channels, group, params);
            return true;
        }
        String str = group;
        if ((!(str == null || str.length() == 0) && (!Intrinsics.areEqual(group, "default"))) || channels == null || channels.size() != 1 || (updateMeta = PrepareMetaManager.INSTANCE.getUpdateMeta(accessKey, channels.get(0))) == null || !updateMeta.getOnDemand()) {
            return false;
        }
        downloadMetas(CollectionsKt.listOf(updateMeta), params);
        return true;
    }

    private final void filterLazy(String accessKey, List<String> channels, String group, GeckoUpdateParams params) {
        String str = accessKey;
        ArrayList arrayList = new ArrayList();
        String str2 = group;
        Long l = null;
        if (!(str2 == null || str2.length() == 0) && (!Intrinsics.areEqual("default", group))) {
            Map metas = PrepareMetaManager.INSTANCE.getMetas(str);
            if (metas != null) {
                Iterator it = metas.entrySet().iterator();
                while (it.hasNext()) {
                    PrepareMeta prepareMeta = (PrepareMeta) ((Map.Entry) it.next()).getValue();
                    List groups = prepareMeta.getGroups();
                    if (groups != null && groups.contains(group) && prepareMeta.getOnDemand()) {
                        prepareMeta.setGroupName(group);
                        arrayList.add(prepareMeta);
                        params.addUpdateChannel$geckox_noasanRelease(prepareMeta.getChannel());
                    }
                }
            }
            if (arrayList.isEmpty()) {
                GeckoUpdateListener listener = params.getListener();
                if (listener != null) {
                    listener.onCheckServerVersionFail(null, new IllegalStateException("no update meta for group: " + group));
                }
                params.onFailed$geckox_noasanRelease("no update meta for group: " + group);
                return;
            }
        }
        if (channels != null) {
            for (String str3 : channels) {
                PrepareMeta updateMeta = PrepareMetaManager.INSTANCE.getUpdateMeta(str, str3);
                if (updateMeta != null) {
                    if (updateMeta.getOnDemand()) {
                        arrayList.add(updateMeta);
                    } else {
                        ListenerManager.INSTANCE.callUpdateFailed(params.getListener(), updateMeta.getPack(), new IllegalArgumentException("Not on demand channel"));
                        params.onUpdateFailed$geckox_noasanRelease(str3, "Not on demand channel");
                    }
                } else {
                    ChannelMeta meta = ChannelMetaManager.INSTANCE.getMeta(str, str3);
                    Long id = meta != null ? meta.getId() : l;
                    if (id != null) {
                        ListenerManager.INSTANCE.callVersionExist(params.getListener(), accessKey, str3, id.longValue());
                        params.onUpdateSuccess$geckox_noasanRelease(str3, id.longValue());
                    } else {
                        ListenerManager.INSTANCE.callUpdateFailed(params.getListener(), new UpdatePackage(accessKey, str3, 0L, 4, null), new IllegalStateException("No update meta for the channel"));
                        params.onUpdateFailed$geckox_noasanRelease(str3, "No update meta for the channel");
                    }
                }
                str = accessKey;
                l = null;
            }
        }
        downloadMetas(arrayList, params);
    }

    private final void downloadMetas(final List<PrepareMeta> metas, final GeckoUpdateParams params) {
        if (metas.isEmpty()) {
            return;
        }
        for (PrepareMeta prepareMeta : metas) {
            prepareMeta.setReqType(ReqType.LAZY);
            prepareMeta.ignoreBlocks();
        }
        GeckoExecutors.INSTANCE.getCheckUpdateExecutor().execute(new Runnable() { // from class: com.bytedance.geckox.strategy.OnDemandManager$downloadMetas$2
            @Override // java.lang.Runnable
            public final void run() {
                UpdateQueue.INSTANCE.add(metas, params);
            }
        });
    }
}
