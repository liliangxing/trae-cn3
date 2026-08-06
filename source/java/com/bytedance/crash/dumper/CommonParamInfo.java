package com.bytedance.crash.dumper;

import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CommonParamInfo {
    private static final String FILE_NAME = "common_params.json";
    private static final String KEY_MP_PARAMS = "mp_params";

    public static void dump(File file) {
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        if (appMonitor == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        Map<String, Object> commParams = appMonitor.getCommParams();
        if (commParams != null) {
            try {
                for (String str : commParams.keySet()) {
                    if (commParams.get(str) != null) {
                        jSONObject.put(str, commParams.get(str));
                    }
                }
                if (commParams.containsKey("version_name")) {
                    jSONObject.put("crash_version_name", commParams.get("version_name"));
                }
                if (commParams.containsKey("update_version_code")) {
                    jSONObject.put("crash_update_version_code", commParams.get("update_version_code"));
                }
                if (commParams.containsKey("version_code")) {
                    jSONObject.put("crash_version_code", commParams.get("version_code"));
                }
            } catch (Exception unused) {
            }
        }
        try {
            JSONObject mPParams = appMonitor.getMPParams();
            if (mPParams != null) {
                jSONObject.put(KEY_MP_PARAMS, mPParams);
            }
        } catch (Exception unused2) {
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
            JSONUtils.combineJson(jSONObject, new JSONObject(readUtf8File));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
