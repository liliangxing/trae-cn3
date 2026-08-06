package com.bytedance.push.starter;

import android.util.Log;
import com.ss.android.deviceregister.DeviceRegisterManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushOnDeviceConfigUpdateListener {
    public static DeviceRegisterManager.OnDeviceConfigUpdateListener onDeviceConfigUpdateListener = new DeviceRegisterManager.OnDeviceConfigUpdateListener() { // from class: com.bytedance.push.starter.PushOnDeviceConfigUpdateListener.1
        public void onDeviceRegistrationInfoChanged(String str, String str2) {
            Log.d("PushStarter", "onDeviceRegistrationInfoChanged");
            PushStarter.startPush();
        }

        public void onRemoteConfigUpdate(boolean z, boolean z2) {
            Log.d("PushStarter", "onRemoteConfigUpdate , success is " + z + " noPreviousDid is " + z2);
            PushStarter.startPush();
        }

        public void onDidLoadLocally(boolean z) {
            Log.d("PushStarter", "onDidLoadLocally , success is " + z);
            PushStarter.startPush();
        }
    };
}
