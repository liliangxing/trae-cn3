package com.bytedance.push.configuration;

import android.content.Context;
import com.bytedance.push.interfaze.IEventSender;
import com.bytedance.push.utils.Logger;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.lib.AppLogNewUtils;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DefaultEventSender implements IEventSender {
    private final String TAG = "DefaultEventSender";

    public void onEvent(Context context, String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        Logger.m268d("DefaultEventSender", "[onEventV2] tag:" + str2 + " category:" + str + " label:" + str3 + " ext_json:" + jSONObject);
        AppLog.onEvent(context, str, str2, str3, j, j2, jSONObject);
    }

    public void onEventV3(String str, JSONObject jSONObject) {
        Logger.m268d("DefaultEventSender", "[onEventV3] " + str);
        AppLogNewUtils.onEventV3(str, jSONObject);
    }
}
