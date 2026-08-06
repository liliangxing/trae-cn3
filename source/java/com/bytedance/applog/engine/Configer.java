package com.bytedance.applog.engine;

import com.bytedance.applog.AppLogHelper;
import com.bytedance.applog.filter.AbstractEventFilter;
import com.bytedance.applog.manager.ConfigManager;
import com.bytedance.applog.manager.DeviceManager;
import com.bytedance.applog.server.Api;
import com.bytedance.applog.util.EncryptUtils;
import com.bytedance.applog.util.Utils;
import com.bytedance.bdinstall.Level;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Configer extends BaseWorker {
    private static final List<String> logTags = Collections.singletonList("Configer");

    @Override // com.bytedance.applog.engine.BaseWorker
    protected String getName() {
        return "configer";
    }

    @Override // com.bytedance.applog.engine.BaseWorker
    protected boolean needNet() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Configer(Engine engine) {
        super(engine, engine.getConfig().getConfigTs());
    }

    @Override // com.bytedance.applog.engine.BaseWorker
    protected long nextInterval() {
        return this.mEngine.getConfig().getConfigInterval();
    }

    @Override // com.bytedance.applog.engine.BaseWorker
    protected long[] getRetryIntervals() {
        return RETRY_SAME;
    }

    @Override // com.bytedance.applog.engine.BaseWorker
    public boolean doWork(int i) throws JSONException {
        getAppLog().getLogger().debug(logTags, getName() + " start doWork curTs = {}", Long.valueOf(System.currentTimeMillis()));
        DeviceManager dm = this.mEngine.getDm();
        if (dm.isValidDidAndIid()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("header", dm.getCopiedHeader());
            jSONObject.put(Api.KEY_GEN_TIME, System.currentTimeMillis());
            JSONObject jSONObject2 = new JSONObject();
            if (getAppLog().isEventParamControlEnabled()) {
                jSONObject2.put(Api.KEY_PARAMS_BLOCK_ENABLE, 1);
            }
            if (getAppLog().isCustomHeaderControlEnabled()) {
                jSONObject2.put(Api.KEY_HEADER_CUSTOM_ALLOW_ENABLE, 1);
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put(Api.KEY_OPTIONS, jSONObject2);
            }
            getAppLog().getApi().fillKeyIvForEncryptResp(jSONObject, false);
            JSONObject config = getAppLog().getApi().config(Api.filterQuery(getAppLog().addNetCommonParams(this.mEngine.getContext(), this.mEngine.getUriConfig().getSettingUri(), true, Level.L1), EncryptUtils.KEYS_CONFIG_QUERY), jSONObject);
            ConfigManager config2 = this.mEngine.getConfig();
            if (getAppLog().getDataObserverHolder() != null) {
                getAppLog().getDataObserverHolder().onRemoteConfigGet(!Utils.jsonEquals(config, config2.getConfig()), config);
            }
            if (config != null) {
                config2.setConfig(config);
                if (this.mEngine.getConfig().getInitConfig().isEventFilterEnable()) {
                    if (getAppLog().isServerFilterByNativeEnabled()) {
                        this.mEngine.setEventFilter(AbstractEventFilter.parseNativeFilterFromServer(this.mEngine.getAppLog(), config));
                    } else {
                        this.mEngine.setEventFilter(AbstractEventFilter.parseFilterFromServer(this.mEngine.getAppLog(), AppLogHelper.getInstanceSpName(this.mEngine.getAppLog(), AbstractEventFilter.SP_FILTER_NAME), config));
                    }
                }
                return true;
            }
        }
        return false;
    }
}
