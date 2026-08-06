package com.bytedance.reparo.secondary;

import android.content.Context;
import com.bytedance.reparo.core.common.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MonitorConfig {
    private static final String CHECK_INITED = "inited";
    private static final String ENABLE_NEW_ANDROID = "enable15";
    private static MonitorConfig sInstence = new MonitorConfig();
    private static ScheduledExecutorService mExecutorService = null;
    private static Context mContext = null;
    private Set<String> mPendingUpdate = new HashSet();
    private boolean mInited = false;
    private JSONObject mLocalConfig = null;

    public static void init(Context context, ScheduledExecutorService scheduledExecutorService) {
        mExecutorService = scheduledExecutorService;
        mContext = context;
    }

    private void checkInit() {
        if (this.mInited) {
            return;
        }
        this.mInited = true;
        initLocalConfig();
        mExecutorService.schedule(new Runnable() { // from class: com.bytedance.reparo.secondary.MonitorConfig.1
            @Override // java.lang.Runnable
            public void run() {
                MonitorConfig.this.updateSDKMonitorConfig();
            }
        }, 10L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSDKMonitorConfig() {
        if (MonitorService.getMonitor().getLogTypeSwitch(CHECK_INITED)) {
            Iterator<String> keys = this.mLocalConfig.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.mPendingUpdate.remove(next);
                updateKey(next);
            }
            Iterator<String> it = this.mPendingUpdate.iterator();
            while (it.hasNext()) {
                updateKey(it.next());
            }
            updateLocalConfig();
        }
    }

    private void updateKey(String str) {
        if (MonitorService.getMonitor().getLogTypeSwitch(str)) {
            try {
                this.mLocalConfig.put(str, 1);
            } catch (JSONException unused) {
            }
        } else if (this.mLocalConfig.opt(str) != null) {
            this.mLocalConfig.remove(str);
        }
    }

    private void initLocalConfig() {
        try {
            File file = new File(mContext.getFilesDir(), "reparo-root/localConfig");
            if (file.exists()) {
                this.mLocalConfig = new JSONObject(FileUtils.readStr(file));
            }
        } catch (Throwable unused) {
        }
        if (this.mLocalConfig == null) {
            this.mLocalConfig = new JSONObject();
        }
    }

    private void updateLocalConfig() {
        JSONObject jSONObject = this.mLocalConfig;
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        try {
            FileUtils.writeFile(new File(mContext.getFilesDir(), "reparo-root/localConfig"), this.mLocalConfig.toString(), false);
        } catch (IOException unused) {
        }
    }

    public static MonitorConfig getInstance() {
        sInstence.checkInit();
        return sInstence;
    }

    public boolean logTypeSwitch(String str) {
        this.mPendingUpdate.add(str);
        return this.mLocalConfig.opt(str) != null;
    }

    public boolean enableNewAndroid() {
        return logTypeSwitch(ENABLE_NEW_ANDROID);
    }
}
