package com.bytedance.geckox.strategy;

import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.utils.GeckoExecutors;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.model.DeploymentsData;
import com.bytedance.iesgurd.model.RequestBodyUpdate;
import com.bytedance.iesgurd.request.UpdateRequest;
import com.bytedance.iesgurd.strategy.ColdStartManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OccasionManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ$\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011J$\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0005R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/geckox/strategy/OccasionManager;", "", "()V", "datas", "", "", "Lcom/bytedance/iesgurd/model/DeploymentsData;", "cancelTriggerUpdate", "", "occasion", "isOccasionUpdate", "", "pack", "Lcom/bytedance/iesgurd/meta/PrepareMeta;", "registerChannelUpdateOccasion", "accessKey", "channels", "", "registerGroupUpdateOccasion", "groups", "triggerUpdateOccasionLately", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class OccasionManager {
    public static final OccasionManager INSTANCE = new OccasionManager();
    private static Map<String, Map<String, DeploymentsData>> datas = new HashMap();

    private OccasionManager() {
    }

    public final void registerGroupUpdateOccasion(String occasion, String accessKey, List<String> groups) {
        Intrinsics.checkParameterIsNotNull(occasion, "occasion");
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(groups, "groups");
        if (occasion.length() == 0) {
            return;
        }
        if ((accessKey.length() == 0) || groups.isEmpty()) {
            return;
        }
        GeckoLogger.m296d("register group occasion: " + occasion + ", ak: " + accessKey + ", groups: " + groups);
        synchronized (datas) {
            HashMap hashMap = datas.get(occasion);
            if (hashMap == null) {
                hashMap = new HashMap();
                datas.put(occasion, hashMap);
            }
            DeploymentsData deploymentsData = hashMap.get(accessKey);
            if (deploymentsData == null) {
                hashMap.put(accessKey, new DeploymentsData(groups, (List) null));
                return;
            }
            if (deploymentsData.getGroups() == null) {
                deploymentsData.setGroups(groups);
            } else {
                List groups2 = deploymentsData.getGroups();
                if (groups2 == null) {
                    Intrinsics.throwNpe();
                }
                Set mutableSet = CollectionsKt.toMutableSet(groups2);
                mutableSet.addAll(groups);
                deploymentsData.setGroups(CollectionsKt.toList(mutableSet));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void registerChannelUpdateOccasion(String occasion, String accessKey, List<String> channels) {
        Intrinsics.checkParameterIsNotNull(occasion, "occasion");
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channels, "channels");
        if (occasion.length() == 0) {
            return;
        }
        if ((accessKey.length() == 0) || channels.isEmpty()) {
            return;
        }
        GeckoLogger.m296d("register channel occasion: " + occasion + ", ak: " + accessKey + ", channels: " + channels);
        synchronized (datas) {
            HashMap hashMap = datas.get(occasion);
            if (hashMap == null) {
                hashMap = new HashMap();
                datas.put(occasion, hashMap);
            }
            DeploymentsData deploymentsData = hashMap.get(accessKey);
            if (deploymentsData == null) {
                hashMap.put(accessKey, new DeploymentsData((List) null, channels));
                return;
            }
            if (deploymentsData.getChannels() == null) {
                deploymentsData.setChannels(channels);
            } else {
                List channels2 = deploymentsData.getChannels();
                if (channels2 == null) {
                    Intrinsics.throwNpe();
                }
                Set mutableSet = CollectionsKt.toMutableSet(channels2);
                mutableSet.addAll(channels);
                deploymentsData.setChannels(CollectionsKt.toList(mutableSet));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean triggerUpdateOccasionLately(String occasion) {
        Map map;
        Intrinsics.checkParameterIsNotNull(occasion, "occasion");
        if (!ColdStartManager.INSTANCE.getSendFinish()) {
            synchronized (datas) {
                datas.remove(occasion);
            }
            return false;
        }
        synchronized (datas) {
            Map<String, DeploymentsData> map2 = datas.get(occasion);
            map = map2 != null ? MapsKt.toMap(map2) : null;
        }
        if (map == null) {
            return false;
        }
        RequestBodyUpdate requestBodyUpdate = new RequestBodyUpdate(ReqType.CUSTOM_REQUEST);
        requestBodyUpdate.initCustom();
        requestBodyUpdate.setDeployments(map);
        new UpdateRequest(requestBodyUpdate).start();
        return true;
    }

    public final void cancelTriggerUpdate(String occasion) {
        Intrinsics.checkParameterIsNotNull(occasion, "occasion");
        if (occasion.length() == 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        synchronized (datas) {
            if (datas.get(occasion) == null) {
                return;
            }
            Map<String, DeploymentsData> map = datas.get(occasion);
            if (map == null) {
                Intrinsics.throwNpe();
            }
            for (Map.Entry<String, DeploymentsData> entry : map.entrySet()) {
                List groups = entry.getValue().getGroups();
                if (groups != null) {
                    hashMap.put(entry.getKey(), groups);
                }
            }
            Unit unit = Unit.INSTANCE;
            if (hashMap.isEmpty()) {
                return;
            }
            GeckoLogger.m296d("cancelTriggerUpdate: " + occasion);
            GeckoExecutors.INSTANCE.getUpdateExecutor().cancelUpdateTask(ReqType.CUSTOM_REQUEST, hashMap);
        }
    }

    public final boolean isOccasionUpdate(PrepareMeta pack) {
        Intrinsics.checkParameterIsNotNull(pack, "pack");
        synchronized (datas) {
            Iterator<T> it = datas.values().iterator();
            while (it.hasNext()) {
                DeploymentsData deploymentsData = (DeploymentsData) ((Map) it.next()).get(pack.getAccessKey());
                if (deploymentsData != null && deploymentsData.isHit(pack.getGroups(), pack.getChannel())) {
                    return true;
                }
            }
            Unit unit = Unit.INSTANCE;
            return false;
        }
    }
}
