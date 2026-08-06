package com.lynx.tasm;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.service.ILynxMonitorService;
import com.lynx.tasm.service.LynxServiceCenter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxInfoReportHelper {
    public static final String KEY_ASYNC_COMPONENT_URL = "last_lynx_async_component_url";
    public static final String KEY_LAST_LYNX_URL = "last_lynx_url";
    private static final String TAG = "LynxInfoReportHelper";
    private volatile ILynxMonitorService mMonitorService = null;

    public void reportLynxCrashContext(String str, String str2) {
        if (str2 == null || str == null) {
            return;
        }
        try {
            if (this.mMonitorService == null) {
                synchronized (this) {
                    if (this.mMonitorService == null) {
                        this.mMonitorService = LynxServiceCenter.inst().getService(ILynxMonitorService.class);
                    }
                }
            }
            if (this.mMonitorService == null) {
                LLog.m2577e(TAG, "LynxMonitorService is null");
            } else {
                this.mMonitorService.reportCrashGlobalContextTag(str, str2);
            }
        } catch (ClassCastException | NullPointerException e) {
            LLog.m2580w(TAG, "Report Lynx Crash Context tag failed for LynxServiceCenter " + e.getMessage());
        }
    }
}
