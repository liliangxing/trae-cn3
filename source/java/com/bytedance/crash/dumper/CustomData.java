package com.bytedance.crash.dumper;

import android.os.SystemClock;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.IUserCrashInfoCallback;
import com.bytedance.crash.dumper.tools.JsonDumper;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CustomData {
    private static final String CUSTOM = "custom";

    private static boolean appendUserInfo(JsonDumper jsonDumper, Map<? extends String, ? extends String> map, String str, long j, boolean z) {
        if (map != null && map.size() != 0) {
            StringBuilder sb = new StringBuilder("zz_cost_");
            sb.append(str);
            for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
                if (z) {
                    z = false;
                } else {
                    jsonDumper.next();
                }
                jsonDumper.key(entry.getKey()).value(entry.getValue());
                sb.append("_").append(entry.getKey());
            }
            jsonDumper.next().key(sb.toString()).value(SystemClock.uptimeMillis() - j);
        }
        return z;
    }

    public static void dumpAttachUserData(JsonDumper jsonDumper, CrashType crashType, int i) {
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        if (appMonitor == null) {
            return;
        }
        List<AttachUserData> attachUserData = appMonitor.getUserDataCenter().getAttachUserData(crashType);
        boolean z = true;
        if (attachUserData != null) {
            for (int i2 = 0; i2 < attachUserData.size(); i2++) {
                AttachUserData attachUserData2 = attachUserData.get(i2);
                try {
                    z = appendUserInfo(jsonDumper, attachUserData2.getUserData(crashType), attachUserData2.getClass().getName(), SystemClock.uptimeMillis(), z);
                } catch (Throwable unused) {
                }
            }
        }
        List<IUserCrashInfoCallback> userCrashInfoCallback = appMonitor.getUserDataCenter().getUserCrashInfoCallback(crashType);
        if (userCrashInfoCallback != null) {
            JSONObject jSONObject = new JSONObject();
            JSONUtils.put(jSONObject, CrashBody.TID, Integer.valueOf(i));
            boolean z2 = z;
            for (int i3 = 0; i3 < userCrashInfoCallback.size(); i3++) {
                IUserCrashInfoCallback iUserCrashInfoCallback = userCrashInfoCallback.get(i3);
                try {
                    z2 = appendUserInfo(jsonDumper, iUserCrashInfoCallback.getCrashInfo(crashType, jSONObject), iUserCrashInfoCallback.getClass().getName(), SystemClock.uptimeMillis(), z2);
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public static void dump(File file, CrashType crashType, int i) {
        if (AppMonitorConfigService.enableUserCustomData()) {
            JsonDumper jsonDumper = new JsonDumper(file.getAbsolutePath() + "/custom.json");
            jsonDumper.objectBegin();
            jsonDumper.key("custom");
            jsonDumper.objectBegin();
            dumpAttachUserData(jsonDumper, crashType, i);
            jsonDumper.objectEnd();
            jsonDumper.objectEnd();
            jsonDumper.release();
        }
    }

    public static void pushTo(JSONObject jSONObject, File file) {
        String readUtf8File;
        if (AppMonitorConfigService.enableUserCustomData() && (readUtf8File = FileSystemUtils.readUtf8File(new File(file, "custom.json"))) != null) {
            try {
                JSONUtils.combineJson(jSONObject, new JSONObject(readUtf8File));
            } catch (Throwable unused) {
            }
        }
    }
}
