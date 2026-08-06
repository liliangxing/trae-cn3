package com.bytedance.dataplatform.applog;

import android.util.Log;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: classes3.dex */
class DefaultAppLogService implements IAppLogService {
    private Method onEventV3Method;

    DefaultAppLogService() {
    }

    private void ensureInit() {
        if (this.onEventV3Method == null) {
            try {
                this.onEventV3Method = Class.forName("com.ss.android.common.lib.AppLogNewUtils").getDeclaredMethod("onEventV3", String.class, JSONObject.class);
            } catch (Throwable unused) {
            }
        }
        if (this.onEventV3Method == null) {
            try {
                this.onEventV3Method = Class.forName("com.bytedance.applog.AppLog").getDeclaredMethod("onEventV3", String.class, JSONObject.class);
            } catch (Throwable unused2) {
            }
        }
    }

    @Override // com.bytedance.dataplatform.applog.IAppLogService
    public void onEventV3(String event, JSONObject params) {
        ensureInit();
        Method method = this.onEventV3Method;
        if (method == null) {
            Log.e("ABSDK", "onEventV3 failed, can't find the AppLog SDK");
            return;
        }
        try {
            method.invoke(null, event, params);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
