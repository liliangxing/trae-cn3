package com.bytedance.crash.dumper;

import com.bytedance.crash.TagService;
import com.bytedance.crash.dumper.tools.JsonDumper;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.IoUtil;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CustomFilter {
    public static final String CUSTOM_CRASH_REASON = "custom_crash_reason";
    public static final String FILETERS = "filters";

    public static void dumpCustomCrashReason(File file) {
        Map<String, JSONArray> customData;
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        if (appMonitor != null && (customData = appMonitor.getUserDataCenter().getCustomData()) != null && !customData.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, JSONArray> entry : customData.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                FileUtils.writeFile(new File(file.getAbsolutePath() + "/" + CUSTOM_CRASH_REASON + ".json"), jSONObject, false);
            } catch (Throwable unused) {
            }
        }
    }

    public static void dump(File file) {
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        if (appMonitor == null || new File(file.getAbsolutePath() + "/tags.txt").exists()) {
            return;
        }
        if (appMonitor.getUserDataCenter().isTagOptEnable()) {
            NativeBridge.dumpTags(new File(file.getAbsolutePath() + "/tags.txt").getAbsolutePath());
            return;
        }
        if (TagService.getTagCacheService() != null) {
            return;
        }
        Map<String, String> cacheCustomTags = appMonitor.getUserDataCenter().getCacheCustomTags();
        if (cacheCustomTags.size() != 0) {
            JsonDumper jsonDumper = new JsonDumper(file.getAbsolutePath() + "/filters.json");
            jsonDumper.objectBegin();
            jsonDumper.key("filters");
            jsonDumper.objectBegin();
            boolean z = true;
            for (Map.Entry<String, String> entry : cacheCustomTags.entrySet()) {
                if (z) {
                    z = false;
                } else {
                    jsonDumper.next();
                }
                jsonDumper.key(entry.getKey()).value(entry.getValue());
            }
            jsonDumper.objectEnd();
            jsonDumper.objectEnd();
            jsonDumper.release();
        }
    }

    public static void pushCustomReasonTo(JSONObject jSONObject, File file) {
        try {
            jSONObject.put(CUSTOM_CRASH_REASON, new JSONObject(FileSystemUtils.readUtf8File(new File(file, "custom_crash_reason.json"))));
        } catch (Throwable unused) {
        }
    }

    public static void pushTo(JSONObject jSONObject, File file) {
        File file2 = new File(file, "tags.txt");
        if (file2.exists()) {
            packTags(jSONObject, file2);
            return;
        }
        String readUtf8File = FileSystemUtils.readUtf8File(new File(file, "filters.json"));
        if (readUtf8File != null) {
            try {
                JSONUtils.combineJson(jSONObject, new JSONObject(readUtf8File));
            } catch (JSONException e) {
                NpthLog.m233i(e);
            }
        }
        TagService.packTags(jSONObject);
    }

    public static void packTags(JSONObject jSONObject, File file) {
        if (file == null || !file.exists()) {
            return;
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            String str = "";
            int i = 0;
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        return;
                    }
                    if ((i & 1) == 0) {
                        str = readLine;
                    } else {
                        CrashBody.putInJson(jSONObject, "filters", str, readLine);
                    }
                    i++;
                } catch (Throwable unused) {
                    bufferedReader = bufferedReader2;
                    IoUtil.close(bufferedReader);
                    return;
                }
            }
        } catch (Throwable unused2) {
        }
    }
}
