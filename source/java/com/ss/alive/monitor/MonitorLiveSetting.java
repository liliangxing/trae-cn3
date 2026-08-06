package com.ss.alive.monitor;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.push.utils.Logger;
import com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MonitorLiveSetting {
    public static final String LAST_SEND_DATA_TIME = "last_send_monitor_live_data_time";
    public static final String MONITOR_ALIVE_CONFIG = "monitor_alive_config";
    public static final String SEND_DATA_INTERVAL_SECOND = "send_monitor_live_data_interval_second";
    private static final String SP_CONFIG_NAME = "push_multi_process_config";
    private static final String TAG = "MonitorLiveSetting";
    private static volatile MonitorLiveSetting sMonitorLiveSetting;
    private ConfigModel mConfigModel;
    private Context mContext;
    private boolean mEnableLocalPush = false;
    private PushMultiProcessSharedProvider.MultiProcessShared multiProcessShared;

    public static MonitorLiveSetting getInstance(Context context) {
        if (sMonitorLiveSetting == null) {
            synchronized (MonitorLiveSetting.class) {
                if (sMonitorLiveSetting == null) {
                    sMonitorLiveSetting = new MonitorLiveSetting(context);
                }
            }
        }
        return sMonitorLiveSetting;
    }

    private MonitorLiveSetting(Context context) {
        context = context instanceof Application ? context : context.getApplicationContext();
        this.mContext = context;
        this.multiProcessShared = PushMultiProcessSharedProvider.getMultiprocessShared(context);
    }

    public void setMonitorAliveConfig(String str) {
        this.multiProcessShared.edit().putString(MONITOR_ALIVE_CONFIG, str).apply();
        ConfigModel configModel = this.mConfigModel;
        if (configModel == null) {
            this.mConfigModel = new ConfigModel(str);
        } else {
            configModel.setConfigJson(str);
        }
    }

    public String getMonitorAliveConfig() {
        return this.multiProcessShared.getString(MONITOR_ALIVE_CONFIG, "");
    }

    public synchronized ConfigModel getMonitorAliveConfigModel() {
        if (this.mConfigModel == null) {
            this.mConfigModel = new ConfigModel(getMonitorAliveConfig());
        }
        return this.mConfigModel;
    }

    public void setLastSendDatdaTime(long j) {
        this.multiProcessShared.edit().putLong(LAST_SEND_DATA_TIME, j).apply();
    }

    public Long getLastSendDatdaTime() {
        return Long.valueOf(this.multiProcessShared.getLong(LAST_SEND_DATA_TIME, 0L));
    }

    public void setSendDataIntervalSecond(int i) {
        this.multiProcessShared.edit().putInt(SEND_DATA_INTERVAL_SECOND, i).apply();
    }

    public int getSendDataIntervalSecond() {
        return this.multiProcessShared.getInt(SEND_DATA_INTERVAL_SECOND, getMonitorAliveConfigModel().defaultSendDataInterval);
    }

    public void setAppLastCheckStatus(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.multiProcessShared.edit().putInt(str, i);
    }

    public int getAppLastCheckStatus(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return this.multiProcessShared.getInt(str, -1);
    }

    public void setLocalPushEnable(boolean z) {
        this.mEnableLocalPush = z;
    }

    public boolean isLocalPushEnable() {
        return this.mEnableLocalPush;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class ConfigModel {
        public boolean isMonitorAliveEnable = false;
        public int monitorLiveIntervalSecond = 60;
        public int maxSendStartInfoNum = 100;
        public int defaultSendDataInterval = 7200;
        public boolean enableUploadActiveApps = false;
        public List<String> uploadActiveAppPackages = null;

        public ConfigModel() {
        }

        public ConfigModel(String str) {
            setConfigJson(str);
        }

        public void setConfigJson(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i = 0;
                this.isMonitorAliveEnable = jSONObject.optInt("is_monitor_alive_enable", 0) > 0;
                this.monitorLiveIntervalSecond = jSONObject.optInt("monitor_live_interval_second", 30);
                this.maxSendStartInfoNum = jSONObject.optInt("max_send_start_info_num", 100);
                this.defaultSendDataInterval = jSONObject.optInt("default_send_data_interval", 7200);
                this.enableUploadActiveApps = jSONObject.optBoolean("enable_upload_unactive_apps", false);
                JSONArray optJSONArray = jSONObject.optJSONArray("upload_unactive_app_packages");
                if (optJSONArray != null) {
                    this.uploadActiveAppPackages = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        try {
                            String string = optJSONArray.getString(i2);
                            if (!TextUtils.isEmpty(string)) {
                                this.uploadActiveAppPackages.add(string);
                            }
                        } catch (JSONException e) {
                            Logger.d(MonitorLiveSetting.TAG, "setConfigJson error" + e.getMessage());
                        }
                    }
                }
                if (Logger.debug()) {
                    Logger.d(MonitorLiveSetting.TAG, "enable_upload_unactive_apps : " + this.enableUploadActiveApps);
                    StringBuilder append = new StringBuilder().append("upload_unactive_app_packages size : ");
                    List<String> list = this.uploadActiveAppPackages;
                    if (list != null) {
                        i = list.size();
                    }
                    Logger.d(MonitorLiveSetting.TAG, append.append(i).append("").toString());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
