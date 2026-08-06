package com.bytedance.apm.data;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.MonitorCoreExceptionManager;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.data.p004ui.ActionRecord;
import com.bytedance.apm.doctor.DoctorDataUtil;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.observer.LogObserver;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.commonevent.model.GeneralLegacyEvent;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import com.bytedance.tracing.internal.BatchTracingLogWrapUtils;
import com.bytedance.tracing.internal.TracingData;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class BaseDataPipeline<T extends ITypeData> implements IConfigListener {
    private static final String TAG = "BaseDataPipeline";
    private static boolean isEnable = false;
    private static int sCacheBufferMaxSize = 1000;
    private volatile boolean mConfigReady;
    private volatile boolean mHasReported = false;
    public boolean fastMode = false;
    private final LinkedList<T> mLogBuffer = new LinkedList<>();

    protected boolean checkValid(T t) {
        return true;
    }

    protected abstract void handleAfterReady(T t);

    protected void hookBeforeRealHandle(T t) {
    }

    public void onRefresh(JSONObject jSONObject, boolean z) {
    }

    public void init() {
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).registerConfigListener(this);
    }

    public final void handle(final T t) {
        if (!AsyncEventManager.getInstance().inWorkThread()) {
            AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.data.BaseDataPipeline.1
                @Override // java.lang.Runnable
                public void run() {
                    BaseDataPipeline.this.handleInner(t);
                }
            });
        } else {
            handleInner(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInner(T t) {
        if (checkValid(t)) {
            hookBeforeRealHandle(t);
            if (this.mConfigReady) {
                handleAfterReady(t);
            } else {
                cache(t);
            }
        }
    }

    private void cache(T t) {
        if (t == null) {
            return;
        }
        synchronized (this.mLogBuffer) {
            if (this.mLogBuffer.size() > sCacheBufferMaxSize) {
                T poll = this.mLogBuffer.poll();
                if (isEnable && !this.mHasReported) {
                    MonitorCoreExceptionManager.getInstance().ensureNotReachHere("apm_cache_buffer_full");
                    this.mHasReported = true;
                }
                try {
                    ApmAlogHelper.m77i("apm_debug", "apm_cache_buffer_full:" + poll.packLog().toString());
                } catch (Exception unused) {
                }
            }
            this.mLogBuffer.add(t);
        }
    }

    private void handleCache() {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.data.BaseDataPipeline.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                LinkedList linkedList;
                synchronized (BaseDataPipeline.this.mLogBuffer) {
                    linkedList = new LinkedList(BaseDataPipeline.this.mLogBuffer);
                    BaseDataPipeline.this.mLogBuffer.clear();
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    BaseDataPipeline.this.handleAfterReady((ITypeData) it.next());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void logSend(String str, String str2, JSONObject jSONObject, boolean z, boolean z2) {
        if (ApmContext.isDebugMode()) {
            Logger.m86d(TAG, "type:" + str + " isSaveUnSampleLog:" + z2 + "isSampled:" + z + " log:" + jSONObject);
        }
        if (z) {
            JSONObject safeJsonObject = this.fastMode ? JsonUtils.safeJsonObject(jSONObject) : JsonUtils.deepCopy(jSONObject);
            if (TextUtils.equals(str, "tracing")) {
                monitorTrace(new TracingData(safeJsonObject, (String) null, false, str2));
            } else if (TextUtils.equals(str, "common_log")) {
                CommonEventDeliverer.monitorLegacyEvent(new GeneralLegacyEvent(str2, safeJsonObject));
            } else {
                CommonEventDeliverer.monitorLegacyEvent(new GeneralLegacyEvent(str, safeJsonObject));
            }
        } else {
            if (ApmContext.isDebugMode()) {
                DoctorDataUtil.onReceivedEvent(str, jSONObject, false);
            }
            if (z2 && ApmAlogHelper.isUnSampleEnable()) {
                try {
                    ApmAlogHelper.onUnSampleLog(str, jSONObject.toString());
                } catch (Exception e) {
                    EnsureManager.ensureNotReachHere(e, "apm_unsampled_log_error");
                }
            }
        }
        LogObserver.getInstance().notifyObservers(str, str2, jSONObject);
        if (TextUtils.equals(str, "ui_action")) {
            ActionRecord.getInstance().addRecord(jSONObject);
        }
    }

    private void monitorTrace(TracingData tracingData) {
        if ("batch_tracing".equals(tracingData.getSubTypeLabel())) {
            CommonEventDeliverer.monitorTrace(new com.bytedance.apm6.commonevent.model.TracingData(BatchTracingLogWrapUtils.stripData(tracingData.packLog())));
        } else {
            CommonEventDeliverer.monitorTrace(new com.bytedance.apm6.commonevent.model.TracingData(tracingData.packLog()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isConfigReady() {
        return this.mConfigReady;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isBackground() {
        if (ActivityLifeObserver.getInstance() == null) {
            return true;
        }
        return !ActivityLifeObserver.getInstance().isForeground();
    }

    public void onReady() {
        this.mConfigReady = true;
        handleCache();
    }

    public boolean isOnReady() {
        return this.mConfigReady;
    }

    public static void setCacheBufferMaxSize(int i) {
        sCacheBufferMaxSize = i;
    }

    public static void setReportFullException(boolean z) {
        isEnable = z;
    }
}
