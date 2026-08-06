package com.bytedance.geckox;

import android.text.TextUtils;
import com.bytedance.forest.chain.fetchers.GeckoFetcher;
import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.geckox.model.CheckRequestParamModel;
import com.bytedance.geckox.strategy.OnDemandManager;
import com.bytedance.iesgurd.core.GeckoStore;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.model.DeploymentsData;
import com.bytedance.iesgurd.model.RequestBodyUpdate;
import com.bytedance.iesgurd.request.UpdateRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class GeckoPipeline {
    private static final String PARAMS_INVALID = "request params can not be null or empty";

    public static RequestBodyUpdate createDeployments(Map<String, CheckRequestParamModel> map, OptionCheckUpdateParams optionCheckUpdateParams, ReqType reqType) throws Exception {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        boolean z = optionCheckUpdateParams.getTag() != null && optionCheckUpdateParams.getTag().equals(GeckoFetcher.GECKO_SDK_INVOKE_SYNC_TAG);
        List noLocalAks = GeckoStore.INSTANCE.getNoLocalAks();
        String str = null;
        for (Map.Entry<String, CheckRequestParamModel> entry : map.entrySet()) {
            String key = entry.getKey();
            if (noLocalAks != null && noLocalAks.contains(key)) {
                z = true;
            }
            CheckRequestParamModel value = entry.getValue();
            ArrayList arrayList = new ArrayList();
            if (value.getTargetChannels() != null) {
                for (CheckRequestBodyModel.TargetChannel targetChannel : value.getTargetChannels()) {
                    if (!arrayList.contains(targetChannel.channelName)) {
                        arrayList.add(targetChannel.channelName);
                    }
                }
            }
            if (AppSettingsManager.inst().isInForbidRequestWhiteList(key, arrayList)) {
                z = true;
            }
            ArrayList arrayList2 = new ArrayList();
            String group = value.getGroup();
            if (!TextUtils.isEmpty(group) && !"default".equals(group)) {
                arrayList2.add(group);
                z = true;
            }
            if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                str = key;
            } else {
                concurrentHashMap.put(key, new DeploymentsData(arrayList2, arrayList));
            }
        }
        if (!TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(PARAMS_INVALID);
            if (optionCheckUpdateParams.getListener() != null) {
                optionCheckUpdateParams.getListener().onCheckServerVersionFail(null, illegalArgumentException);
                throw illegalArgumentException;
            }
            throw illegalArgumentException;
        }
        AppSettingsManager.IGeckoAppSettings geckoAppSettings = AppSettingsManager.inst().getGeckoAppSettings();
        if (!z && geckoAppSettings != null && geckoAppSettings.isForbidRequest()) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("no need to request");
            if (optionCheckUpdateParams.getListener() != null) {
                optionCheckUpdateParams.getListener().onCheckServerVersionFail(null, illegalArgumentException2);
                throw illegalArgumentException2;
            }
            throw illegalArgumentException2;
        }
        RequestBodyUpdate requestBodyUpdate = new RequestBodyUpdate(reqType);
        requestBodyUpdate.setDeployments(concurrentHashMap);
        requestBodyUpdate.initCustom(new ArrayList(concurrentHashMap.keySet()), (GeckoUpdateParams) null, optionCheckUpdateParams);
        return requestBodyUpdate;
    }

    public static void startRequest(GeckoConfig geckoConfig, Map<String, List<CheckRequestBodyModel.TargetChannel>> map, String str, OptionCheckUpdateParams optionCheckUpdateParams) throws Exception {
        HashMap hashMap = new HashMap();
        if (map == null || map.isEmpty()) {
            Iterator<String> it = geckoConfig.getAccessKeys().iterator();
            while (it.hasNext()) {
                hashMap.put(it.next(), new CheckRequestParamModel(str));
            }
        } else {
            for (Map.Entry<String, List<CheckRequestBodyModel.TargetChannel>> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), new CheckRequestParamModel(str, entry.getValue()));
            }
        }
        new UpdateRequest(createDeployments(hashMap, optionCheckUpdateParams, ReqType.NORMAL), OnDemandManager.INSTANCE.toParamsNew(optionCheckUpdateParams)).start();
    }

    public static void startRequest(Map<String, CheckRequestParamModel> map, OptionCheckUpdateParams optionCheckUpdateParams, ReqType reqType) throws Exception {
        GeckoUpdateParams paramsNew = OnDemandManager.INSTANCE.toParamsNew(optionCheckUpdateParams);
        if (map == null || map.isEmpty()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(PARAMS_INVALID);
            if (optionCheckUpdateParams.getListener() != null) {
                optionCheckUpdateParams.getListener().onCheckServerVersionFail(null, illegalArgumentException);
                throw illegalArgumentException;
            }
            throw illegalArgumentException;
        }
        new UpdateRequest(createDeployments(map, optionCheckUpdateParams, reqType), paramsNew).start();
    }
}
