package com.bytedance.ug.sdk.share.api.depend;

import android.app.Activity;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface IShareInterceptConfig {
    String executeGet(int i, String str) throws Exception;

    String executePost(int i, String str, JSONObject jSONObject) throws Exception;

    JSONObject getExtraConfig();

    boolean handleQrScanResult(Activity activity, String str);

    boolean interceptNetwork(String str);
}
