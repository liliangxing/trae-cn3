package com.ss.android.account.adapter;

import com.bytedance.sdk.account.utils.IMonitor;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.lib.AppLogNewUtils;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MonitorAdapter implements IMonitor {
    public void onEvent(String str, JSONObject jSONObject) {
        AppLogNewUtils.onEventV3(str, jSONObject);
    }

    public void setAppLogInfo(long j, String str) {
        AppLog.setUserId(j);
        AppLog.setSessionKey(str);
    }
}
