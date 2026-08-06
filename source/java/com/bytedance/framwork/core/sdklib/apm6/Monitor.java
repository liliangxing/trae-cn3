package com.bytedance.framwork.core.sdklib.apm6;

import com.bytedance.framwork.core.sdklib.apm6.downgrade.DowngradeController;
import com.bytedance.framwork.core.sdklib.apm6.header.HeaderManager;
import com.bytedance.framwork.core.sdklib.apm6.safety.Logger;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class Monitor {
    private static ConcurrentHashMap<Long, Long> headerIds = new ConcurrentHashMap<>();
    private static PersistentBuffer persistentBuffer;
    private volatile boolean inited = false;

    public static Monitor getInstance() {
        return InnerHolder.holder;
    }

    public void record(long j, JSONObject jSONObject) {
        try {
            if (!DowngradeController.getInstance().uploadEnabled(jSONObject, (int) j)) {
                if (SDKContext.isDebugMode()) {
                    Logger.m1305d(Constants.TAG, "push failed: event(aid=" + j + " is downgraded: " + jSONObject.toString());
                    return;
                }
                return;
            }
            if (!headerIds.containsKey(Long.valueOf(j))) {
                headerIds.put(Long.valueOf(j), Long.valueOf(HeaderManager.getInstance().init(j, SDKContext.getHeaderInfo(j))));
            }
            ensureInited();
            try {
                if (jSONObject.getJSONObject("_debug_self") == null) {
                    jSONObject.put("_debug_self", new JSONObject());
                }
                new JSONObject().put("sdk_report_from", "apm6");
            } catch (Exception unused) {
            }
            if (SDKContext.isDebugMode()) {
                Logger.m1305d(Constants.TAG, "record:" + j + " " + jSONObject);
            }
            persistentBuffer.push(j, headerIds.get(Long.valueOf(j)).longValue(), jSONObject);
        } catch (Throwable th) {
            Logger.m1307e(Constants.TAG, "record", th);
        }
    }

    private synchronized void ensureInited() {
        if (this.inited) {
            return;
        }
        this.inited = true;
        if (SDKContext.isDebugMode()) {
            Logger.m1305d(Constants.TAG, "Initializing SlardarHandler...");
        }
        persistentBuffer = new PersistentBuffer(DiskEnvironmentHelper.getPersistentFile(), DiskEnvironmentHelper.getFlushDirectory());
        LogReporter.getInstance().setPersistentBuffer(persistentBuffer);
        LogReporter.getInstance().init();
        LogSender.getInstance().init();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    private static class InnerHolder {
        private static final Monitor holder = new Monitor();

        private InnerHolder() {
        }
    }
}
