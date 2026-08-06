package com.bytedance.apm6.foundation.context;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface ApmContextAdapter {
    int getAid();

    String getAppVersion();

    String getChannel();

    Context getContext();

    String getDeviceId();

    JSONObject getDynamicHeaderExtras();

    int getManifestVersionCode();

    JSONObject getOutsideConfig();

    Map<String, String> getParamsExtras();

    String getProcessName();

    String getReleaseBuild();

    String getSessionId();

    JSONObject getStableHeaderExtras();

    long getUid();

    int getUpdateVersionCode();

    int getVersionCode();

    String getVersionName();
}
