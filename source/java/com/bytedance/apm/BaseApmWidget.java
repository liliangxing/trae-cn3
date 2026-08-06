package com.bytedance.apm;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.IActivityLifeManager;
import com.bytedance.services.apm.api.IActivityLifeObserver;
import com.bytedance.services.apm.api.IWidget;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class BaseApmWidget implements IWidget, IConfigListener, IActivityLifeObserver, AsyncEventManager.IMonitorTimeTask {
    private volatile JSONObject mAllowLogType;
    private volatile JSONObject mAllowService;
    private JSONObject mConfigData;
    private boolean mConfigReady;
    private boolean mIsFront;
    private volatile JSONObject mMetricType;

    public String getTag() {
        return TraceStatsConsts.STATS_BASE_MODULE;
    }

    public void init(Context context) {
    }

    public abstract boolean isOnlyMainProcess();

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityPause(Activity activity) {
    }

    public void onActivityResume(Activity activity) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onChange(Activity activity, Fragment fragment) {
    }

    @Override // com.bytedance.apm.thread.AsyncEventManager.IMonitorTimeTask
    public void onTimeEvent(long j) {
    }

    public void start() {
    }

    public void stop() {
    }

    public void destroy() {
        ensureUnregisterForSafety();
    }

    private void ensureUnregisterForSafety() {
        unregisterAppLifeCycle();
        unregisterConfigService();
        unregisterTimerTask();
    }

    protected final boolean registerConfigService() {
        IConfigManager iConfigManager = (IConfigManager) ServiceManager.getService(IConfigManager.class);
        if (iConfigManager == null) {
            return false;
        }
        iConfigManager.registerConfigListener(this);
        return true;
    }

    protected final boolean registerAppLifeCycle() {
        IActivityLifeManager iActivityLifeManager = (IActivityLifeManager) ServiceManager.getService(IActivityLifeManager.class);
        if (iActivityLifeManager == null) {
            return false;
        }
        iActivityLifeManager.register(this);
        return true;
    }

    protected final void registerTimerTask() {
        AsyncEventManager.getInstance().addTimeTask(this);
    }

    protected final boolean unregisterConfigService() {
        IConfigManager iConfigManager = (IConfigManager) ServiceManager.getService(IConfigManager.class);
        if (iConfigManager == null) {
            return false;
        }
        iConfigManager.unregisterConfigListener(this);
        return true;
    }

    protected final boolean unregisterAppLifeCycle() {
        IActivityLifeManager iActivityLifeManager = (IActivityLifeManager) ServiceManager.getService(IActivityLifeManager.class);
        if (iActivityLifeManager == null) {
            return false;
        }
        iActivityLifeManager.unregister(this);
        return true;
    }

    protected final void unregisterTimerTask() {
        AsyncEventManager.getInstance().removeTimeTask(this);
    }

    protected boolean isFront() {
        return this.mIsFront;
    }

    public void onFront(Activity activity) {
        this.mIsFront = true;
    }

    public void onBackground(Activity activity) {
        this.mIsFront = false;
    }

    public void onRefresh(JSONObject jSONObject, boolean z) {
        this.mConfigData = jSONObject;
        JSONObject optJSONObject = jSONObject.optJSONObject("custom_event_settings");
        if (optJSONObject != null) {
            this.mAllowLogType = optJSONObject.optJSONObject("allow_log_type");
            this.mMetricType = optJSONObject.optJSONObject(SlardarSettingsConsts.BASE_KEY_ALLOW_METRIC_TYPE);
            this.mAllowService = optJSONObject.optJSONObject(SlardarSettingsConsts.BASE_KEY_ALLOW_SERVICE_NAME);
        }
    }

    public void onReady() {
        this.mConfigReady = true;
    }

    public boolean isConfigReady() {
        return this.mConfigReady;
    }

    public boolean getLogTypeSwitch(String str) {
        return (this.mAllowLogType == null || TextUtils.isEmpty(str) || this.mAllowLogType.optInt(str) != 1) ? false : true;
    }

    public boolean getMetricTypeSwitch(String str) {
        return (this.mMetricType == null || TextUtils.isEmpty(str) || this.mMetricType.optInt(str) != 1) ? false : true;
    }

    public boolean getServiceSwitch(String str) {
        return (this.mAllowService == null || TextUtils.isEmpty(str) || this.mAllowService.optInt(str) != 1) ? false : true;
    }

    public boolean getConfigBool(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str) || (jSONObject = this.mConfigData) == null) {
            return false;
        }
        return jSONObject.optBoolean(str);
    }

    public JSONObject getConfigJSON(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str) || (jSONObject = this.mConfigData) == null) {
            return null;
        }
        return jSONObject.optJSONObject(str);
    }

    public int getConfigInt(String str, int i) {
        JSONObject jSONObject;
        return (TextUtils.isEmpty(str) || (jSONObject = this.mConfigData) == null) ? i : jSONObject.optInt(str, i);
    }
}
