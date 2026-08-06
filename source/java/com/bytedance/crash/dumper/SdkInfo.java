package com.bytedance.crash.dumper;

import com.bytedance.crash.dumper.tools.JsonDumper;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SdkInfo {
    public static final String INNER_SDK = "inner_sdk";
    public static final String SDK_INFO = "sdk_info";

    public static void dump(File file) {
        boolean z;
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        if (appMonitor == null) {
            return;
        }
        JsonDumper jsonDumper = new JsonDumper(file.getAbsolutePath() + "/sdk_info.json");
        jsonDumper.objectBegin();
        ConcurrentHashMap<Integer, String> sdkInfo = appMonitor.getUserDataCenter().getSdkInfo();
        boolean z2 = true;
        if (sdkInfo == null || sdkInfo.size() <= 0) {
            z = true;
        } else {
            jsonDumper.key(SDK_INFO);
            jsonDumper.objectBegin();
            z = true;
            for (Integer num : sdkInfo.keySet()) {
                if (z) {
                    z = false;
                } else {
                    jsonDumper.next();
                }
                jsonDumper.key(String.valueOf(num)).value(String.valueOf(sdkInfo.get(num)));
            }
            jsonDumper.objectEnd();
        }
        JSONObject innerSdkInfoToJson = appMonitor.getUserDataCenter().getInnerSdkInfoToJson();
        if (innerSdkInfoToJson.length() > 0) {
            if (!z) {
                jsonDumper.next();
            }
            jsonDumper.key(INNER_SDK);
            jsonDumper.objectBegin();
            Iterator<String> keys = innerSdkInfoToJson.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    String string = innerSdkInfoToJson.getString(next);
                    if (z2) {
                        z2 = false;
                    } else {
                        jsonDumper.next();
                    }
                    jsonDumper.key(next).value(string);
                } catch (JSONException unused) {
                }
            }
            jsonDumper.objectEnd();
        }
        jsonDumper.objectEnd();
        jsonDumper.release();
    }

    public static void pushTo(JSONObject jSONObject, File file) {
        String readUtf8File = FileSystemUtils.readUtf8File(new File(file, "sdk_info.json"));
        if (readUtf8File != null) {
            try {
                JSONUtils.combineJson(jSONObject, new JSONObject(readUtf8File));
            } catch (JSONException e) {
                NpthLog.m233i(e);
            }
        }
    }

    public static void pushTo(JSONObject jSONObject) {
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        if (appMonitor == null) {
            return;
        }
        ConcurrentHashMap<Integer, String> sdkInfo = appMonitor.getUserDataCenter().getSdkInfo();
        JSONObject jSONObject2 = new JSONObject();
        if (sdkInfo != null) {
            try {
                if (sdkInfo.size() > 0) {
                    for (Integer num : sdkInfo.keySet()) {
                        jSONObject2.put(String.valueOf(num), sdkInfo.get(num));
                    }
                }
            } catch (Throwable unused) {
            }
        }
        JSONObject innerSdkInfoToJson = appMonitor.getUserDataCenter().getInnerSdkInfoToJson();
        try {
            if (!JSONUtils.isEmpty(jSONObject2)) {
                jSONObject.put(SDK_INFO, jSONObject2);
            }
            if (JSONUtils.isEmpty(innerSdkInfoToJson)) {
                return;
            }
            jSONObject.put(INNER_SDK, innerSdkInfoToJson);
        } catch (Throwable unused2) {
        }
    }
}
