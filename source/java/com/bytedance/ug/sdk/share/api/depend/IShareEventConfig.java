package com.bytedance.ug.sdk.share.api.depend;

import android.content.Context;
import com.bytedance.ug.sdk.share.api.entity.ShareMonitorEvent;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface IShareEventConfig {
    void onALogEvent(int i, String str, String str2);

    void onAppLogEvent(String str, JSONObject jSONObject);

    void onSDKMonitorEvent(String str, ShareMonitorEvent shareMonitorEvent);

    void onSDKMonitorInit(Context context, String str, JSONObject jSONObject, List<String> list, List<String> list2);
}
