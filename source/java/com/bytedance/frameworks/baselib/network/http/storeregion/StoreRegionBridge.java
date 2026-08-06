package com.bytedance.frameworks.baselib.network.http.storeregion;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface StoreRegionBridge {
    void onStoreIdcChanged(String str, String str2, String str3, String str4, String str5, String str6);

    void sendFeedbackLog(String str, String str2);

    boolean updateTncConfig(JSONObject jSONObject, String str, String str2, boolean z);
}
