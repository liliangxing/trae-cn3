package com.bytedance.praisedialoglib.depend;

import android.app.Activity;
import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface IPraiseDialogAppConfig {
    String getAppId();

    String getDeviceId();

    String getHost();

    String getHuaWeiAppId();

    String getPackageName();

    Activity getTopActivity();

    void goToFeedback(Context context, String str);

    boolean handleNoAppMarket();

    boolean needShowDefaultDialog();

    void onEvent(String str, JSONObject jSONObject);
}
