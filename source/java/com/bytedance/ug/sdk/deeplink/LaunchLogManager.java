package com.bytedance.ug.sdk.deeplink;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.applog.AppLog;
import com.bytedance.ug.sdk.deeplink.utils.CollectionsUtils;
import com.bytedance.ug.sdk.deeplink.utils.EventUtil;
import com.bytedance.ug.sdk.deeplink.utils.Logger;
import com.bytedance.ug.sdk.deeplink.utils.ThreadUtils;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.deviceregister.DeviceRegisterManager;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LaunchLogManager {
    public static final String FROM_CLICK_BROWSER = "click_browser";
    public static final String FROM_ENTER_LAUNCH = "enter_launch";
    public static final String GD_LABEL = "gd_label";
    public static final String REPORT_LAUNCH_LOG = "report_launch_log";
    public static final String UNKNOWN_LABEL = "unknown";
    private final String TAG;
    private String mCodeLaunchMode;

    private LaunchLogManager() {
        this.TAG = "LaunchLogManager";
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class InstanceHolder {
        private static final LaunchLogManager launchLogManager = new LaunchLogManager();

        private InstanceHolder() {
        }
    }

    public static LaunchLogManager getInstance() {
        return InstanceHolder.launchLogManager;
    }

    public String getLaunchMode() {
        return this.mCodeLaunchMode;
    }

    public String getGdLabel(Uri uri) {
        return uri == null ? "" : uri.getQueryParameter(GD_LABEL);
    }

    public void reportLaunchLogEvent(final String str, final Uri uri, final String str2, final Map<String, Object> map) {
        if (TextUtils.isEmpty(this.mCodeLaunchMode)) {
            this.mCodeLaunchMode = TextUtils.isEmpty(str) ? "unknown" : str;
            Logger.m449i("LaunchLogManager", "set code launch mode : " + str);
        }
        ThreadUtils.executeAsync(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.LaunchLogManager.1
            @Override // java.lang.Runnable
            public void run() {
                String str3 = str;
                if (TextUtils.isEmpty(str3)) {
                    str3 = "unknown";
                }
                LaunchLogManager.this.doReportLaunchLogEvent(str3, uri, str2, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doReportLaunchLogEvent(String str, Uri uri, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(GD_LABEL, str);
            if (uri != null) {
                jSONObject.put("scheme", uri.toString());
            } else {
                jSONObject.put("scheme", "");
            }
            jSONObject.put("entrance", str2);
            jSONObject.put("code_launch_mode", this.mCodeLaunchMode);
            if (CollectionsUtils.isNotEmptyMap(map)) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (entry != null && !TextUtils.isEmpty(entry.getKey())) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        } catch (JSONException e) {
            Logger.m448e("LaunchLogManager", "reportLaunchLogEvent json exception : " + e.getMessage(), e);
        }
        Logger.m449i("LaunchLogManager", "reportLaunchLogEvent, gd_label = " + str + ", scheme = " + jSONObject.opt("scheme") + ", entrance = " + str2 + ", code_launch_mode = " + this.mCodeLaunchMode);
        if (EventUtil.onEvent("launch_log", jSONObject)) {
            return;
        }
        defaultReportEvent("launch_log", jSONObject);
    }

    private void defaultReportEvent(String str, JSONObject jSONObject) {
        try {
            try {
                DeviceRegisterManager.getDeviceId();
                AppLogNewUtils.onEventV3(str, jSONObject);
            } catch (NoClassDefFoundError unused) {
            }
        } catch (NoClassDefFoundError unused2) {
            AppLog.getDid();
            AppLog.onEventV3(str, jSONObject);
        }
    }
}
