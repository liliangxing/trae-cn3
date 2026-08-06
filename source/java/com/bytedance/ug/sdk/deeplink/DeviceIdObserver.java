package com.bytedance.ug.sdk.deeplink;

import com.bytedance.applog.IDataObserver;
import com.bytedance.ug.sdk.deeplink.utils.Logger;
import com.bytedance.ug.sdk.deeplink.utils.ThreadUtils;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DeviceIdObserver implements IDataObserver {
    private static volatile DeviceIdObserver INSTANCE = null;
    private static final String TAG = "DeviceIdObserver";

    public void onAbVidsChange(String str, String str2) {
    }

    public void onRemoteAbConfigGet(boolean z, JSONObject jSONObject) {
    }

    public void onRemoteConfigGet(boolean z, JSONObject jSONObject) {
    }

    public static DeviceIdObserver getInstance() {
        if (INSTANCE == null) {
            synchronized (DeviceIdObserver.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DeviceIdObserver();
                }
            }
        }
        return INSTANCE;
    }

    public void onIdLoaded(String str, String str2, String str3) {
        Logger.m446d(TAG, "HuaWeiReferrerHelper getReferrerAndUpload onIdLoaded");
        ThreadUtils.executeAsync(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.DeviceIdObserver.1
            @Override // java.lang.Runnable
            public void run() {
                HuaWeiReferrerHelper.getInstance().getReferrerAndUpload(GlobalContext.INSTANCE.getApplication());
            }
        });
    }

    public void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        if (z) {
            Logger.m446d(TAG, "HuaWeiReferrerHelper getReferrerAndUpload onRemoteIdGet");
            ThreadUtils.executeAsync(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.DeviceIdObserver.2
                @Override // java.lang.Runnable
                public void run() {
                    HuaWeiReferrerHelper.getInstance().getReferrerAndUpload(GlobalContext.INSTANCE.getApplication());
                }
            });
        }
    }
}
