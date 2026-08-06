package com.bytedance.ug.sdk.deeplink.settings;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.bytedance.ug.sdk.deeplink.GlobalContext;
import com.bytedance.ug.sdk.deeplink.HostCommonServices;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.bytedance.ug.sdk.deeplink.callback.CallbackManager;
import com.bytedance.ug.sdk.deeplink.monitor.MonitorUtil;
import com.bytedance.ug.sdk.deeplink.utils.EventUtil;
import com.bytedance.ug.sdk.deeplink.utils.Logger;
import com.bytedance.ug.sdk.deeplink.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ZlinkSettingsManager {
    private static final int MAX_RETRY_REQUEST_TIMES = 3;
    private static final String TAG = "com.bytedance.ug.sdk.deeplink.settings.ZlinkSettingsManager";
    private static final Handler POLLING_HANDLER = new PollingHandler();
    private static int sRetryTimes = 0;
    private static boolean sSettingResultEventSent = false;

    ZlinkSettingsManager() {
    }

    static /* synthetic */ boolean access$100() {
        return settingsRefactorEnable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void updateSettings(final String str) {
        Logger.m446d(TAG, "start to update Settings");
        ThreadUtils.executeAsyncWithNewThread(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.settings.ZlinkSettingsManager.1
            @Override // java.lang.Runnable
            public void run() {
                RequestServiceImpl.request(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void updateSettingsIfNeed() {
        ThreadUtils.executeAsyncWithNewThread(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.settings.ZlinkSettingsManager.2
            @Override // java.lang.Runnable
            public void run() {
                Logger.m446d(ZlinkSettingsManager.TAG, "updateSettingsIfNeed()....");
                boolean access$100 = ZlinkSettingsManager.access$100();
                Logger.m449i(ZlinkSettingsManager.TAG, "settingsRefactorEnable = " + access$100);
                if (!access$100) {
                    RequestServiceImpl.request(EventConstants.PARAM_SOURCE_INIT);
                    return;
                }
                Application application = GlobalContext.INSTANCE.getApplication();
                boolean hasSettingsDataCache = ZlinkSettingsCacheHelper.hasSettingsDataCache(application);
                long lastestUpdateTime = ZlinkSettingsCacheHelper.getLastestUpdateTime(application);
                long j = ZlinkSettingsCacheHelper.getLong(application, "update_settings_interval", 3600L);
                Logger.m449i(ZlinkSettingsManager.TAG, "hasCache = " + hasSettingsDataCache + ", lastestUpdateTime = " + lastestUpdateTime + ", updateInterval = " + j);
                if (hasSettingsDataCache && lastestUpdateTime > 0 && j > 0 && System.currentTimeMillis() - lastestUpdateTime <= 1000 * j) {
                    ZlinkSettingsManager.postDelayUpdateTask(j);
                } else {
                    RequestServiceImpl.request(EventConstants.PARAM_SOURCE_INIT);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void doAfterSettingsRequest(boolean z, JSONObject jSONObject) {
        long optLong;
        int i;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (z) {
            optLong = jSONObject.optLong("update_settings_interval", 3600L);
            CallbackManager.setAppLinkInterval(jSONObject.optLong("settings_app_link_interval", 1000L));
            Application application = GlobalContext.INSTANCE.getApplication();
            if (application != null) {
                monitorSettingsDataDiff(application, jSONObject);
            }
            ZlinkSettingsCacheHelper.setSettingsDataCache(GlobalContext.INSTANCE.getApplication(), jSONObject);
            if (settingsRefactorEnable()) {
                ZlinkSettingsCacheHelper.setLastestUpdateTime(GlobalContext.INSTANCE.getApplication());
            }
        } else if (!RequestServiceImpl.isRequested() && (i = sRetryTimes) < 3) {
            sRetryTimes = i + 1;
            optLong = 5;
        } else {
            optLong = jSONObject.optLong("update_settings_interval", 3600L);
            monitorFirstSettingResult(0);
        }
        if (z && !RequestServiceImpl.isRequested()) {
            RequestServiceImpl.setIsRequested();
            ZlinkSettingsApi.notifySettingsListeners();
            monitorFirstSettingResult(sRetryTimes + 1);
        }
        postDelayUpdateTask(optLong);
    }

    private static boolean settingsRefactorEnable() {
        IZlinkDepend zlinkDepend = HostCommonServices.getZlinkDepend();
        if (zlinkDepend != null) {
            return zlinkDepend.settingsRefactorEnable();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void postDelayUpdateTask(long j) {
        Logger.m449i(TAG, "postDelayUpdateTask()....");
        Handler handler = POLLING_HANDLER;
        handler.removeMessages(37, "deep_link_settings_id");
        Message obtain = Message.obtain();
        obtain.obj = "deep_link_settings_id";
        obtain.what = 37;
        handler.sendMessageDelayed(obtain, j * 1000);
    }

    public static void monitorFirstSettingResult(int i) {
        if (sSettingResultEventSent) {
            return;
        }
        EventUtil.sendFirstSettingResultEvent(i);
        sSettingResultEventSent = true;
    }

    private static void monitorSettingsDataDiff(Context context, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 1) {
            return;
        }
        JSONObject settingsDataCache = ZlinkSettingsCacheHelper.getSettingsDataCache(context);
        if (!"".equals(settingsDataCache.toString()) && settingsDataCache.length() > 1) {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                arrayList.add(next);
                if (!TextUtils.equals(String.valueOf(jSONObject.opt(next)), String.valueOf(settingsDataCache.opt(next)))) {
                    hashSet.add(next);
                }
            }
            Iterator<String> keys2 = settingsDataCache.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                if (!arrayList.contains(next2)) {
                    hashSet.add(next2);
                }
            }
            hashSet.remove(CommonConstants.KEY_SETTINGS_TIME);
            if (hashSet.isEmpty()) {
                return;
            }
            ArrayList arrayList2 = new ArrayList(hashSet);
            Collections.sort(arrayList2);
            IZlinkDepend zlinkDepend = HostCommonServices.getZlinkDepend();
            if (zlinkDepend != null) {
                Logger.m449i("zlink_settings_diff_key_" + zlinkDepend.getUpdateVersionCode(), arrayList2.toString());
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject2.put("zlink_settings_diff_keys", arrayList2);
                jSONObject3.put("zlink_settings_diff_count", arrayList2.size());
                MonitorUtil.monitorEventByHost("settings_diff_monitor", jSONObject2, jSONObject3, new JSONObject());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class PollingHandler extends Handler {
        PollingHandler() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 37 && (message.obj instanceof String) && "deep_link_settings_id".equals(message.obj.toString())) {
                Logger.m446d(ZlinkSettingsManager.TAG, "updating settings regularly");
                ZlinkSettingsManager.updateSettings(EventConstants.PARAM_SOURCE_INTERVAL);
            }
        }
    }
}
