package com.bytedance.ug.sdk.deeplink;

import java.util.List;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface IZlinkDepend {
    boolean dealWithClipboard(boolean z, String str, boolean z2);

    boolean dealWithSchema(String str);

    long delayMillis();

    String getAppId();

    List<String> getDeepLinkActivities();

    String getDeviceId();

    List<String> getSchemeList();

    long getUpdateVersionCode();

    boolean isConfirmedPrivacy();

    void log(int i, String str, String str2, Throwable th);

    void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    void onEvent(String str, JSONObject jSONObject);

    boolean settingsRefactorEnable();
}
