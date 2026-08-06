package com.bytedance.common.push.interfaze;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IPushCommonEventSender {
    void onEvent(Context context, String str, String str2, String str3, long j, long j2, JSONObject jSONObject);

    void onEventV3(String str, JSONObject jSONObject);
}
