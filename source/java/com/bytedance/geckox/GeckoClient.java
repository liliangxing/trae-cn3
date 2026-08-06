package com.bytedance.geckox;

import android.text.TextUtils;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.clean.cache.CachePolicy;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.listener.ListenerManager;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.geckox.model.CheckRequestParamModel;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.geckox.strategy.OnDemandManager;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.statistic.model.EventMessageModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GeckoClient {
    public static final String GECKO_ROOT_DIR = "gecko_offline_res_x";
    private GeckoConfig mConfig;

    @Deprecated
    public void checkUpdateMulti() {
    }

    public void release() {
    }

    private GeckoClient(GeckoConfig geckoConfig) {
        this.mConfig = geckoConfig;
    }

    public static GeckoClient create(GeckoConfig geckoConfig) {
        if (geckoConfig == null) {
            throw new IllegalArgumentException("config == null");
        }
        List<String> accessKeys = geckoConfig.getAccessKeys();
        if (accessKeys == null || accessKeys.isEmpty()) {
            throw new IllegalArgumentException("access key empty");
        }
        try {
            Iterator<String> it = geckoConfig.getAccessKeys().iterator();
            while (it.hasNext()) {
                GeckoGlobalManager.inst().registerAccessKey2Dir(it.next(), geckoConfig.getResRootDir().getAbsolutePath());
            }
        } catch (IllegalArgumentException e) {
            GeckoLogger.m296d("gecko client register root dir failed:" + e.getMessage());
        }
        GeckoClient geckoClient = new GeckoClient(geckoConfig);
        GeckoClientManager.INSTANCE.registerGeckoClient(geckoConfig.getAccessKey(), geckoClient);
        return geckoClient;
    }

    @Deprecated
    public void checkUpdateTarget(List<String> list, GeckoUpdateListener geckoUpdateListener) {
        checkUpdateTarget(list, null, geckoUpdateListener);
    }

    @Deprecated
    public void checkUpdateTarget(List<String> list, Map<String, Object> map, GeckoUpdateListener geckoUpdateListener) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new CheckRequestBodyModel.TargetChannel(it.next()));
        }
        hashMap.put(this.mConfig.getAccessKey(), arrayList);
        OptionCheckUpdateParams optionCheckUpdateParams = new OptionCheckUpdateParams();
        optionCheckUpdateParams.setEnableThrottle(false);
        optionCheckUpdateParams.setListener(geckoUpdateListener);
        if (map != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(this.mConfig.getAccessKey(), map);
            optionCheckUpdateParams.setCustomParam(hashMap2);
        }
        checkUpdateMulti("", hashMap, optionCheckUpdateParams);
    }

    public void checkUpdateMulti(String str) {
        checkUpdateMulti(str, null, null, null);
    }

    public void checkUpdateMulti(String str, Map<String, List<CheckRequestBodyModel.TargetChannel>> map) {
        checkUpdateMulti(str, null, map, null);
    }

    public void checkUpdateMulti(Map<String, List<CheckRequestBodyModel.TargetChannel>> map) {
        checkUpdateMulti(null, null, map, null);
    }

    public void checkUpdateMulti(Map<String, List<CheckRequestBodyModel.TargetChannel>> map, GeckoUpdateListener geckoUpdateListener) {
        checkUpdateMulti(null, null, map, geckoUpdateListener);
    }

    public void checkUpdateMulti(String str, GeckoUpdateListener geckoUpdateListener) {
        checkUpdateMulti(str, null, null, geckoUpdateListener);
    }

    public void checkUpdateMulti(String str, GeckoUpdateListener geckoUpdateListener, Map<String, List<CheckRequestBodyModel.TargetChannel>> map) {
        checkUpdateMulti(str, null, map, geckoUpdateListener);
    }

    public void checkUpdateMulti(String str, Map<String, Map<String, Object>> map, Map<String, List<CheckRequestBodyModel.TargetChannel>> map2, GeckoUpdateListener geckoUpdateListener) {
        OptionCheckUpdateParams listener = new OptionCheckUpdateParams().setListener(geckoUpdateListener);
        if (map != null) {
            listener.setCustomParam(map);
        }
        checkUpdateMulti(str, map2, listener);
    }

    public void checkUpdateMulti(String str, Map<String, List<CheckRequestBodyModel.TargetChannel>> map, OptionCheckUpdateParams optionCheckUpdateParams) {
        CachePolicy cachePolicy = null;
        if (!GlobalManager.INSTANCE.getInited().get()) {
            if (optionCheckUpdateParams != null && optionCheckUpdateParams.getListener() != null) {
                optionCheckUpdateParams.getListener().onCheckServerVersionFail(null, new IllegalStateException("do not call checkUpdateMulti before GeckoGlobalManager.init"));
            }
            GeckoLogger.m300w("do not call checkUpdateMulti before GeckoGlobalManager.init");
            new EventMessageModel(EventSubType.CHECK_UPDATE_BEFORE_INIT, this.mConfig.getAccessKeys().toString(), map.toString(), str, optionCheckUpdateParams != null ? optionCheckUpdateParams.getTag() : "", 1L).upload();
            return;
        }
        if (!GeckoGlobalManager.inst().isGeckoEnable()) {
            if (optionCheckUpdateParams == null || optionCheckUpdateParams.getListener() == null) {
                return;
            }
            optionCheckUpdateParams.getListener().onCheckServerVersionFail(null, new IllegalStateException("gecko is disabled"));
            return;
        }
        if (!checkTargetChannel(map)) {
            throw new IllegalArgumentException("target keys are not in deployments keys");
        }
        if (optionCheckUpdateParams == null) {
            optionCheckUpdateParams = new OptionCheckUpdateParams();
        }
        if (!OnDemandManager.INSTANCE.updateFromClient(this.mConfig, str, map, optionCheckUpdateParams) && needRequest(str, map, optionCheckUpdateParams)) {
            if (this.mConfig.getCacheConfig() != null) {
                cachePolicy = this.mConfig.getCacheConfig().getCachePolicy();
                cachePolicy.attach(this.mConfig.getCacheConfig(), this.mConfig.getResRootDir(), this.mConfig.getAccessKeys());
            }
            try {
                try {
                    GeckoPipeline.startRequest(this.mConfig, map, str, optionCheckUpdateParams);
                    if (optionCheckUpdateParams != null && optionCheckUpdateParams.getListener() != null) {
                        optionCheckUpdateParams.getListener().onUpdateFinish();
                    }
                    if (cachePolicy == null) {
                        return;
                    }
                } catch (Exception e) {
                    GeckoLogger.m303w("Gecko update failed:", e);
                    if (optionCheckUpdateParams != null && optionCheckUpdateParams.getListener() != null) {
                        optionCheckUpdateParams.getListener().onUpdateFinish();
                    }
                    if (cachePolicy == null) {
                        return;
                    }
                }
                cachePolicy.append();
            } catch (Throwable th) {
                if (optionCheckUpdateParams != null && optionCheckUpdateParams.getListener() != null) {
                    optionCheckUpdateParams.getListener().onUpdateFinish();
                }
                if (cachePolicy != null) {
                    cachePolicy.append();
                }
                throw th;
            }
        }
    }

    private boolean needRequest(String str, Map<String, List<CheckRequestBodyModel.TargetChannel>> map, OptionCheckUpdateParams optionCheckUpdateParams) {
        if (optionCheckUpdateParams.isRequestWhenHasLocalVersion() || map == null || map.isEmpty()) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && !"default".equals(str)) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<CheckRequestBodyModel.TargetChannel>> entry : map.entrySet()) {
            String key = entry.getKey();
            for (CheckRequestBodyModel.TargetChannel targetChannel : entry.getValue()) {
                Long innerGetLatestChannelVersion = ResLoadUtils.innerGetLatestChannelVersion(this.mConfig.getResRootDir(), key, targetChannel.channelName);
                if (innerGetLatestChannelVersion == null) {
                    return true;
                }
                arrayList.add(new UpdatePackage(key, targetChannel.channelName, innerGetLatestChannelVersion.longValue()));
            }
        }
        if (optionCheckUpdateParams.getListener() == null) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ListenerManager.INSTANCE.callUpdateSuccess(optionCheckUpdateParams.getListener(), (UpdatePackage) it.next());
        }
        return false;
    }

    @Deprecated
    public void checkUpdateMulti(Map<String, CheckRequestParamModel> map, OptionCheckUpdateParams optionCheckUpdateParams) {
        CachePolicy cachePolicy = null;
        if (!GlobalManager.INSTANCE.getInited().get()) {
            if (optionCheckUpdateParams != null && optionCheckUpdateParams.getListener() != null) {
                optionCheckUpdateParams.getListener().onCheckServerVersionFail(null, new IllegalStateException("do not call deprecated checkUpdateMulti before GeckoGlobalManager.init"));
            }
            GeckoLogger.m300w("do not call deprecated checkUpdateMulti before GeckoGlobalManager.init");
            new EventMessageModel(EventSubType.CHECK_UPDATE_BEFORE_INIT, this.mConfig.getAccessKeys().toString(), map.toString(), "", optionCheckUpdateParams != null ? optionCheckUpdateParams.getTag() : "", 2L).upload();
            return;
        }
        if (!GeckoGlobalManager.inst().isGeckoEnable()) {
            if (optionCheckUpdateParams == null || optionCheckUpdateParams.getListener() == null) {
                return;
            }
            optionCheckUpdateParams.getListener().onCheckServerVersionFail(null, new IllegalStateException("gecko is disabled"));
            return;
        }
        if (!checkTargetChannelAndGroup(map)) {
            throw new IllegalArgumentException("requestParams is null or target keys are not in deployments keys");
        }
        if (optionCheckUpdateParams == null) {
            optionCheckUpdateParams = new OptionCheckUpdateParams();
        }
        if (this.mConfig.getCacheConfig() != null) {
            cachePolicy = this.mConfig.getCacheConfig().getCachePolicy();
            cachePolicy.attach(this.mConfig.getCacheConfig(), this.mConfig.getResRootDir(), this.mConfig.getAccessKeys());
        }
        try {
            try {
                GeckoPipeline.startRequest(map, optionCheckUpdateParams, ReqType.NORMAL);
                if (optionCheckUpdateParams != null && optionCheckUpdateParams.getListener() != null) {
                    optionCheckUpdateParams.getListener().onUpdateFinish();
                }
                if (cachePolicy == null) {
                    return;
                }
            } catch (Exception e) {
                GeckoLogger.m303w("Gecko update failed:", e);
                if (optionCheckUpdateParams != null && optionCheckUpdateParams.getListener() != null) {
                    optionCheckUpdateParams.getListener().onUpdateFinish();
                }
                if (cachePolicy == null) {
                    return;
                }
            }
            cachePolicy.append();
        } catch (Throwable th) {
            if (optionCheckUpdateParams != null && optionCheckUpdateParams.getListener() != null) {
                optionCheckUpdateParams.getListener().onUpdateFinish();
            }
            if (cachePolicy != null) {
                cachePolicy.append();
            }
            throw th;
        }
    }

    @Deprecated
    public void registerCheckUpdate(Map<String, CheckRequestParamModel> map, OptionCheckUpdateParams optionCheckUpdateParams, Map<String, String> map2) {
        checkUpdateMulti(map, optionCheckUpdateParams);
    }

    @Deprecated
    public void addCustomParams(Map<String, Map<String, OptionCheckUpdateParams.CustomValue>> map) {
        GeckoGlobalManager.inst().addCustomValueParams(map);
    }

    private boolean checkTargetChannel(Map<String, List<CheckRequestBodyModel.TargetChannel>> map) {
        if (map != null && !map.isEmpty()) {
            List<String> accessKeys = this.mConfig.getAccessKeys();
            for (Map.Entry<String, List<CheckRequestBodyModel.TargetChannel>> entry : map.entrySet()) {
                Iterator<String> it = accessKeys.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next(), entry.getKey())) {
                        z = true;
                    }
                }
                if (!z) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkTargetChannelAndGroup(Map<String, CheckRequestParamModel> map) {
        if (map == null) {
            return false;
        }
        return GeckoGlobalManager.inst().getAccessKeyDirs().keySet().containsAll(map.keySet());
    }

    public GeckoConfig getConfig() {
        return this.mConfig;
    }
}
