package com.bytedance.sdk.account.platform.onekey.carrier;

import android.content.Context;
import android.os.Handler;
import com.bytedance.sdk.account.platform.onekey.OnekeyLoginConfig;
import com.bytedance.sdk.account.platform.onekey.OnekeySettingManager;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface IServiceContainer {
    Context getApplicationContext();

    OnekeyLoginConfig getConfig();

    Handler getHandler();

    OnekeySettingManager getSetting();

    void onEvent(String str, JSONObject jSONObject);
}
