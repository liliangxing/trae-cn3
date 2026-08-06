package com.bytedance.crash.dumper;

import android.text.TextUtils;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AppVersion {
    private static final String FILE_NAME = "version.json";
    private static final String KEY_VERSION_NAME = "version_name";

    public static String getJsonString(long j, long j2, long j3, String str) {
        if (j == 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version_code", j);
            jSONObject.put("update_version_code", j2);
            jSONObject.put("version_name", str);
            jSONObject.put("manifest_version_code", j3);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void dump(File file) {
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        if (appMonitor == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (appMonitor.getVersionCode() != 0 && !TextUtils.isEmpty(appMonitor.getVersionName())) {
            try {
                jSONObject.put("version_code", appMonitor.getVersionCode());
                jSONObject.put("update_version_code", appMonitor.getUpdateVersionCode());
                jSONObject.put("version_name", appMonitor.getVersionName());
                jSONObject.put("app_version", appMonitor.getVersionName());
                jSONObject.put("manifest_version_code", appMonitor.getManifestVersionCode());
            } catch (Throwable unused) {
            }
        }
        if (jSONObject.length() > 0) {
            FileSystemUtils.writeFile(new File(file, FILE_NAME), jSONObject.toString());
        }
    }

    public static boolean load(JSONObject jSONObject, File file) {
        String readUtf8File = FileSystemUtils.readUtf8File(new File(file, FILE_NAME));
        if (readUtf8File == null) {
            return false;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(readUtf8File);
            JSONUtils.combineJson(jSONObject, jSONObject2);
            NpthLog.m228d("AppVersion:load", jSONObject2);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
