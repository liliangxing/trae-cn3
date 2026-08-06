package com.bytedance.geckox.policy.request;

import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.GeckoUpdateParams;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.strategy.OnDemandManager;
import com.bytedance.iesgurd.clean.AccessKeyCacheManager;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.model.DeploymentsData;
import com.bytedance.iesgurd.model.RequestBodyUpdate;
import com.bytedance.iesgurd.request.UpdateRequest;
import com.bytedance.iesgurd.statistic.model.EventMessageModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/geckox/policy/request/RequestHelper;", "", "()V", "updateResource", "", "params", "Lcom/bytedance/geckox/GeckoUpdateParams;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class RequestHelper {
    public static final RequestHelper INSTANCE = new RequestHelper();

    private RequestHelper() {
    }

    public final void updateResource(GeckoUpdateParams params) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        String tag = params.getTag();
        String accessKey = params.getAccessKey();
        String group = params.getGroup();
        List<String> channels = params.getChannels();
        boolean z = true;
        if (!(tag.length() == 0)) {
            String str = accessKey;
            if (!(str == null || str.length() == 0)) {
                if (Intrinsics.areEqual(group, "default")) {
                    params.onFailed$geckox_noasanRelease("default group is forbidden");
                    return;
                }
                String str2 = group;
                if (str2 == null || str2.length() == 0) {
                    List<String> list = channels;
                    if (list == null || list.isEmpty()) {
                        params.onFailed$geckox_noasanRelease("group and channels are empty");
                        return;
                    }
                }
                if (!(str2 == null || str2.length() == 0)) {
                    List<String> list2 = channels;
                    if (!(list2 == null || list2.isEmpty())) {
                        params.onFailed$geckox_noasanRelease("not support channels and group");
                        return;
                    }
                }
                if (!GlobalManager.INSTANCE.getInited().get()) {
                    new EventMessageModel(EventSubType.CHECK_UPDATE_BEFORE_INIT, accessKey, String.valueOf(channels), group, tag, 0L).upload();
                    params.onFailed$geckox_noasanRelease("do not call updateResource before gecko init");
                    return;
                }
                GeckoGlobalManager inst = GeckoGlobalManager.inst();
                Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
                String str3 = inst.getAccessKeyDirs().get(accessKey);
                if (str3 != null && str3.length() != 0) {
                    z = false;
                }
                if (z) {
                    params.onFailed$geckox_noasanRelease("accessKey is not register");
                    return;
                }
                GeckoGlobalManager inst2 = GeckoGlobalManager.inst();
                Intrinsics.checkExpressionValueIsNotNull(inst2, "GeckoGlobalManager.inst()");
                if (!inst2.isGeckoEnable()) {
                    params.onFailed$geckox_noasanRelease("gecko is disabled");
                    return;
                }
                if (OnDemandManager.INSTANCE.update(params)) {
                    return;
                }
                RequestBodyUpdate requestBodyUpdate = new RequestBodyUpdate(ReqType.NORMAL);
                RequestBodyUpdate.initCustom$default(requestBodyUpdate, CollectionsKt.listOf(accessKey), params, (OptionCheckUpdateParams) null, 4, (Object) null);
                if (channels != null) {
                    requestBodyUpdate.setDeployments(MapsKt.mapOf(TuplesKt.to(accessKey, new DeploymentsData((List) null, channels))));
                } else if (group != null) {
                    requestBodyUpdate.setDeployments(MapsKt.mapOf(TuplesKt.to(accessKey, new DeploymentsData(CollectionsKt.listOf(group), (List) null))));
                } else {
                    params.onFailed$geckox_noasanRelease("checkUpdate should not happened");
                    GeckoLogger.m300w("checkUpdate should not happened");
                    return;
                }
                new UpdateRequest(requestBodyUpdate, params).start();
                AccessKeyCacheManager.INSTANCE.runClean(accessKey);
                return;
            }
        }
        params.onFailed$geckox_noasanRelease("tag or accessKey is empty");
    }
}
