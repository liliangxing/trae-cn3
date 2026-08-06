package com.bytedance.crash.dart;

import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.dumper.MemoryInfo;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.JSONUtils;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DartSummary {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static CrashBody assemblyCrashBody(EventMonitor eventMonitor, String str, long j, String str2, Map<? extends String, ? extends String> map, Map<String, String> map2) {
        CrashBody crashBody = new CrashBody();
        try {
            if (eventMonitor.getBodyDumper() != null) {
                JSONUtils.combineJson(crashBody.getJson(), eventMonitor.getBodyDumper().load(CrashType.DART));
            }
            crashBody.put("is_dart", 1);
            crashBody.put("data", str2);
            crashBody.put("crash_time", Long.valueOf(j));
            crashBody.put(CrashBody.CRASH_THREAD_NAME, str);
            crashBody.put("process_name", App.getProcessName());
            crashBody.put("app_start_time", Long.valueOf(Global.getAppStartTime()));
            crashBody.put("upload_scene", "direct");
            MemoryInfo.pushTo(crashBody.getJson());
            Scraps.pushTo(crashBody.getJson());
            if (AppMonitorConfigService.enableUserCustomData() && map != null) {
                JSONObject jSONObject = new JSONObject();
                JSONUtils.put(jSONObject, map);
                if (map2 != null) {
                    JSONUtils.put(jSONObject, map2);
                }
                crashBody.put("custom", jSONObject);
            }
        } catch (Throwable unused) {
        }
        return crashBody.setHeader(Header.createEventHeader(eventMonitor, j, CrashType.DART, Process.myPid()));
    }
}
