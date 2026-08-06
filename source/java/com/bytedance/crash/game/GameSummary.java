package com.bytedance.crash.game;

import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.util.App;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class GameSummary {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static CrashBody assemblyCrashBody(EventMonitor eventMonitor, String str, long j, String str2, String str3, String str4) {
        CrashBody crashBody = new CrashBody();
        try {
            crashBody.put("data", str4);
            crashBody.put(Header.KEY_CRASH_TYPE, CrashType.GAME.getName());
            crashBody.put("crash_time", Long.valueOf(j));
            crashBody.put("crash_name", str2);
            crashBody.put("crash_reason", str3);
            crashBody.put(CrashBody.CRASH_THREAD_NAME, str);
            crashBody.put("process_name", App.getProcessName());
            crashBody.put("app_start_time", Long.valueOf(Global.getAppStartTime()));
            crashBody.put("upload_scene", "direct");
        } catch (Throwable unused) {
        }
        return crashBody.setHeader(Header.createEventHeader(eventMonitor, j, CrashType.GAME, Process.myPid()));
    }
}
