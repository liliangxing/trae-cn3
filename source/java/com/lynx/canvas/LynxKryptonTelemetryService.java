package com.lynx.canvas;

import com.lynx.canvas.telemetry.KryptonTelemetryService;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxKryptonTelemetryService extends KryptonTelemetryService {
    private static final String TAG = "LynxKryptonTelemetryService";
    private final int mInstanceId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LynxKryptonTelemetryService(WeakReference<LynxContext> weakReference) {
        LynxContext lynxContext = weakReference.get();
        if (lynxContext != null) {
            this.mInstanceId = lynxContext.getInstanceId();
        } else {
            this.mInstanceId = -1;
            LLog.m2577e(TAG, "LynxKryptonTelemetryService created with invalid context");
        }
    }

    @Override // com.lynx.canvas.telemetry.KryptonTelemetryService
    public void reportEvent(String str, Map<String, String> map) {
        if (this.mInstanceId > -1) {
            LLog.m2577e(TAG, "report " + str + " " + map);
            LynxEventReporter.onEvent("lynxsdk_krypton_" + str, new HashMap(map), this.mInstanceId);
        }
    }
}
