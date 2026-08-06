package com.bytedance.apm.perf;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.IActivityLifeObserver;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class AbstractPerfCollector implements IActivityLifeObserver, IConfigListener, AsyncEventManager.IMonitorTimeTask {
    private static final String TAG = "AbstractPerfCollector";
    private boolean mBackground;
    protected String mCollectorSettingKey;
    private boolean mInited;
    private boolean mReady;
    private boolean mStarted;
    private long workLastTimeStamp;

    /* JADX INFO: Access modifiers changed from: protected */
    public void doConfig(JSONObject jSONObject) {
    }

    protected abstract boolean isTimerMonitor();

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

    protected void onDestroy() {
    }

    protected void onInit() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
    }

    protected abstract long workInternalMs();

    public final void init() {
        if (this.mInited) {
            return;
        }
        if (TextUtils.isEmpty(this.mCollectorSettingKey)) {
            throw new IllegalStateException("Must set collector Setting key, before init");
        }
        this.mInited = true;
        ActivityLifeObserver.getInstance().register(this);
        this.mBackground = !ActivityLifeObserver.getInstance().isForeground();
        onInit();
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).registerConfigListener(this);
        if (ApmContext.isDebugMode()) {
            Logger.m86d(TAG, "perf init: " + this.mCollectorSettingKey);
        }
    }

    private final void start() {
        if (!this.mStarted) {
            this.mStarted = true;
            if (isTimerMonitor()) {
                AsyncEventManager.getInstance().addTimeTask(this);
            }
        }
        onStart();
        this.workLastTimeStamp = System.currentTimeMillis();
    }

    public final void stop() {
        if (this.mStarted) {
            this.mStarted = false;
            if (isTimerMonitor()) {
                AsyncEventManager.getInstance().removeTimeTask(this);
            }
        }
        onStop();
    }

    public final void destroy() {
        ActivityLifeObserver.getInstance().unregister(this);
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).unregisterConfigListener(this);
        onDestroy();
    }

    protected boolean isConfigReady() {
        return this.mReady;
    }

    @Override // com.bytedance.apm.thread.AsyncEventManager.IMonitorTimeTask
    public final void onTimeEvent(long j) {
        long workInternalMs = workInternalMs();
        if (workInternalMs <= 0 || j - this.workLastTimeStamp <= workInternalMs || !this.mReady) {
            return;
        }
        onStart();
        this.workLastTimeStamp = System.currentTimeMillis();
    }

    public void onRefresh(JSONObject jSONObject, boolean z) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("performance_modules");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject(this.mCollectorSettingKey)) == null) {
            return;
        }
        doConfig(optJSONObject);
    }

    public void onReady() {
        this.mReady = true;
        start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isBackground() {
        return this.mBackground;
    }

    public void onFront(Activity activity) {
        this.mBackground = false;
        if (ApmContext.isStopWhenBackground() && this.mReady) {
            start();
        }
    }

    public void onBackground(Activity activity) {
        this.mBackground = true;
        if (ApmContext.isStopWhenBackground()) {
            stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendPerfLog(PerfData perfData) {
        CommonDataAssembly.wrapPerfStatus(perfData);
        CommonDataAssembly.wrapFilters(perfData, perfData.isAddDeviceInfo());
        CommonDataPipeline.getInstance().handle(perfData);
    }
}
