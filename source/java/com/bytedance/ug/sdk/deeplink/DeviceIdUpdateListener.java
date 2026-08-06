package com.bytedance.ug.sdk.deeplink;

import com.bytedance.ug.sdk.deeplink.utils.Logger;
import com.bytedance.ug.sdk.deeplink.utils.ThreadUtils;
import com.ss.android.deviceregister.DeviceRegisterManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DeviceIdUpdateListener implements DeviceRegisterManager.OnDeviceConfigUpdateListener {
    private static volatile DeviceIdUpdateListener INSTANCE = null;
    private static final String TAG = "DeviceConfigUpdateListener";

    public void onRemoteConfigUpdate(boolean z, boolean z2) {
    }

    public static DeviceIdUpdateListener getInstance() {
        if (INSTANCE == null) {
            synchronized (DeviceIdUpdateListener.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DeviceIdUpdateListener();
                }
            }
        }
        return INSTANCE;
    }

    public void onDeviceRegistrationInfoChanged(String str, String str2) {
        Logger.m446d(TAG, "HuaWeiReferrerHelper getReferrerAndUpload onDeviceRegistrationInfoChanged");
        ThreadUtils.executeAsync(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.DeviceIdUpdateListener.1
            @Override // java.lang.Runnable
            public void run() {
                HuaWeiReferrerHelper.getInstance().getReferrerAndUpload(GlobalContext.INSTANCE.getApplication());
            }
        });
    }

    public void onDidLoadLocally(boolean z) {
        if (z) {
            Logger.m446d(TAG, "HuaWeiReferrerHelper getReferrerAndUpload after did load locally");
            ThreadUtils.executeAsync(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.DeviceIdUpdateListener.2
                @Override // java.lang.Runnable
                public void run() {
                    HuaWeiReferrerHelper.getInstance().getReferrerAndUpload(GlobalContext.INSTANCE.getApplication());
                }
            });
        }
    }
}
