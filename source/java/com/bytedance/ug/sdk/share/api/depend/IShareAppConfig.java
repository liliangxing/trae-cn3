package com.bytedance.ug.sdk.share.api.depend;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface IShareAppConfig {
    String getAppId();

    String getDeviceId();

    JSONObject getExtraConfig();

    void openPage(Context context, String str);
}
