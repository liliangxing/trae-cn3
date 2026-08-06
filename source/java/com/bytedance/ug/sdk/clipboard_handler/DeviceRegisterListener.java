package com.bytedance.ug.sdk.clipboard_handler;

import com.bytedance.ug.sdk.deeplink.utils.Logger;
import com.ss.android.deviceregister.DeviceRegisterManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
class DeviceRegisterListener implements DeviceRegisterManager.OnDeviceConfigUpdateListener {
    private static volatile DeviceRegisterListener INSTANCE = null;
    private static final String TAG = "DeviceRegisterListener";

    public void onRemoteConfigUpdate(boolean z, boolean z2) {
    }

    DeviceRegisterListener() {
    }

    public static DeviceRegisterListener getInstance() {
        if (INSTANCE == null) {
            synchronized (DeviceRegisterListener.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DeviceRegisterListener();
                }
            }
        }
        return INSTANCE;
    }

    public void onDeviceRegistrationInfoChanged(String str, String str2) {
        Logger.m446d(TAG, "SchemeClipboardChecker doReCheck onDeviceRegistrationInfoChanged");
        SchemeClipboardChecker.inst().doReCheck();
    }

    public void onDidLoadLocally(boolean z) {
        if (z) {
            Logger.m446d(TAG, "SchemeClipboardChecker doReCheck after did load locally");
            SchemeClipboardChecker.inst().doReCheck();
        }
    }
}
