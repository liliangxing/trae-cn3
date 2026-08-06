package com.bytedance.ug.sdk.deeplink.fission;

import java.util.List;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface CallbackForFission {
    String getAccessToken();

    List<String> getDefaultTokenRegex();

    String getRequestBaseUrlForFission();

    void onResultForCheckFission(boolean z, String str, String str2);

    void onResultForInvitationCode(boolean z, String str, String str2);

    boolean processCustomParameter(JSONObject jSONObject);
}
