package com.bytedance.applog.task;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.IHeaderCustomTimelyCallback;
import com.bytedance.applog.manager.DeviceManager;
import com.bytedance.applog.monitor.p006v3.StatsCountKeys;
import com.bytedance.applog.store.DbStore;
import com.bytedance.applog.store.Pack;
import com.bytedance.applog.store.Terminate;
import com.bytedance.applog.util.SensitiveUtils;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BgSessionTaskModel {
    private static final String KEY_TASK_SESSION = "key_task_session";
    private static final List<String> logTags = Collections.singletonList("BgSessionTaskModel");
    private final AppLogInstance appLogInstance;
    private final Context context;
    private final DbStore dbStore;
    private final DeviceManager deviceManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BgSessionTaskModel(AppLogInstance appLogInstance, DbStore dbStore, DeviceManager deviceManager) {
        this.dbStore = dbStore;
        this.deviceManager = deviceManager;
        this.appLogInstance = appLogInstance;
        this.context = appLogInstance.getContext();
        init();
    }

    public void init() {
        TeaThread.getInst().ensureTeaThreadLite(new Runnable() { // from class: com.bytedance.applog.task.BgSessionTaskModel.1
            @Override // java.lang.Runnable
            public void run() {
                TaskSession savedTaskSessionInSp = BgSessionTaskModel.this.getSavedTaskSessionInSp();
                if (savedTaskSessionInSp != null) {
                    BgSessionTaskModel.this.saveTaskSessionToDb(savedTaskSessionInSp);
                }
                BgSessionTaskModel.this.clearSessionSp();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TaskSession getSavedTaskSessionInSp() {
        return TaskSession.fromString(this.context.getSharedPreferences(getSpName(), 0).getString(KEY_TASK_SESSION, ""));
    }

    public void saveTaskSessionToDb(TaskSession taskSession) {
        saveTaskSessionToPack(taskSession);
    }

    public void saveTaskSessionToSp(TaskSession taskSession) {
        if (taskSession == null) {
            return;
        }
        this.appLogInstance.getLogger().debug(logTags, "[Task] saveTaskSessionToSp : {}", taskSession);
        saveTaskSessionToSp(taskSession.toJsonString());
    }

    public boolean report(TaskSession taskSession) {
        if (taskSession == null) {
            return false;
        }
        this.appLogInstance.getLogger().debug(logTags, "[Task] start to report session : {}", taskSession);
        if (!saveTaskSessionToPack(taskSession)) {
            return false;
        }
        clearSessionSp();
        this.appLogInstance.flushAsync();
        return true;
    }

    private void saveTaskSessionToSp(String str) {
        if (str == null) {
            str = "";
        }
        try {
            SharedPreferences.Editor edit = this.context.getSharedPreferences(getSpName(), 0).edit();
            edit.putString(KEY_TASK_SESSION, str);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public void clearSessionSp() {
        this.appLogInstance.getLogger().debug(logTags, "[Task] clear task session sp", new Object[0]);
        saveTaskSessionToSp("");
    }

    private String getSpName() {
        if (this.appLogInstance.getInitConfig() != null) {
            return this.appLogInstance.getInitConfig().getSpName();
        }
        return "applog_task@" + this.appLogInstance.getAppId();
    }

    private boolean saveTaskSessionToPack(TaskSession taskSession) {
        if (taskSession == null) {
            return false;
        }
        try {
            Terminate terminate = new Terminate();
            this.appLogInstance.fillSessionParams(terminate);
            terminate.f80ts = taskSession.getStartTime();
            terminate.sid = taskSession.getSessionId();
            terminate.bgSession = 1;
            if (taskSession.hasFrontSession()) {
                terminate.fromSessionId = taskSession.getFrontSessionId();
            }
            if (taskSession.hasEndSession()) {
                terminate.toSessionId = taskSession.getEndSessionId();
            }
            terminate.duration = taskSession.getDuration();
            terminate.stopTs = taskSession.getLatestEndTime();
            terminate.sessionType = Integer.valueOf(taskSession.getSessionType());
            if (taskSession.getFlatParams() != null) {
                terminate.flatParams = taskSession.getFlatParams().toString();
            }
            if (this.deviceManager.isValidDidAndIid()) {
                JSONObject transferHeader = SensitiveUtils.transferHeader(this.deviceManager.getCopiedHeader());
                IHeaderCustomTimelyCallback headerCustomCallback = this.appLogInstance.getHeaderCustomCallback();
                if (headerCustomCallback != null) {
                    try {
                        headerCustomCallback.updateHeader(transferHeader);
                    } catch (Throwable th) {
                        this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.PACK_ERROR_COUNT);
                        this.appLogInstance.getLogger().error(logTags, "header custom callback updateHeader error", th, new Object[0]);
                    }
                }
                this.appLogInstance.getLogger().debug(logTags, "[Task] save task session to db : {}", taskSession);
                Pack pack = new Pack();
                pack.setData(this.appLogInstance.getAppId(), transferHeader, null, terminate, null, new JSONArray[]{null, null, null}, new long[]{-1, -1, -1}, null, null, 9);
                this.dbStore.saveAndDeleteDataFromPack(pack, true, null, null);
                return true;
            }
        } catch (Throwable th2) {
            this.appLogInstance.getLogger().error(logTags, "[Task] Save task session to pack failed", th2, new Object[0]);
        }
        return false;
    }
}
