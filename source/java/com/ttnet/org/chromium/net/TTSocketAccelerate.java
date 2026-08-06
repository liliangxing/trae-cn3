package com.ttnet.org.chromium.net;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import java.lang.reflect.Method;

@JNINamespace(ApmTrafficStats.KEY_TRAFFIC_STATUS_NET)
/* loaded from: classes7.dex */
public class TTSocketAccelerate {
    private static final int ACCELERATE_ERROR_CALLBACK_EXCEPTION = -1001;
    private static final int ACCELERATE_ERROR_RESULT_CODE_ERROR = -1002;
    private static final int ACCELERATE_ERROR_TIMEOUT = -1003;
    private static final int ACCELERATE_NOTIFY_EXCEPTION = -1000;
    private static final int ACCELERATE_NOTIFY_SUCC = 0;
    private static final int ACC_DEFAULT = 3;
    private static final int MSG_TYPE_ACC_INFO = 16;
    private static final int MSG_TYPE_SCENE_INFO = 1;
    private static final int MSG_TYPE_SUB_SCENE_INFO = 32;
    private static final int REGIST_ANDROID_VERSION_ERROR = -1003;
    private static final int REGIST_BRAND_ERROR = -1002;
    private static final int REGIST_EXCEPTION = -1001;
    private static final int REGIST_SUCC = 0;
    private static final int REGIST_UNKNOWN = -1000;
    private static final int SCENE_SHORT_VIDEO = 16;
    private static final int STATUS_SCENE_ENTER = 1;
    private static final int SUB_SCENE_HTTP_DNS = 1;
    private static final String TAG = "TTSocketAccelerate";
    private static final String sEmcomManagerExClass = "com.hihonor.android.emcom.EmcomManagerEx";
    private static final String sNotifyAppInfoMethod = "notifyAppInfo";
    private long nativeDelegate = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface Natives {
        @NativeClassQualifiedName("TTSocketAccelerateDelegateAndroid")
        void OnCheckSystemAvailableResult(long j, TTSocketAccelerate tTSocketAccelerate, int i);

        @NativeClassQualifiedName("TTSocketAccelerateDelegateAndroid")
        void OnNotifyAccelerateResult(long j, TTSocketAccelerate tTSocketAccelerate, int i, int i2);
    }

    protected TTSocketAccelerate() {
    }

    public static TTSocketAccelerate init() {
        return new TTSocketAccelerate();
    }

    public void setNativeDelegate(long j) {
        this.nativeDelegate = j;
    }

    public void checkSystemAvailable() {
        if (this.nativeDelegate == 0) {
            return;
        }
        if (!Build.MANUFACTURER.toLowerCase().contains("honor") && !Build.BRAND.toLowerCase().contains("honor")) {
            TTSocketAccelerateJni.get().OnCheckSystemAvailableResult(this.nativeDelegate, this, -1002);
        } else if (Build.VERSION.SDK_INT < 29) {
            TTSocketAccelerateJni.get().OnCheckSystemAvailableResult(this.nativeDelegate, this, -1003);
        } else {
            TTSocketAccelerateJni.get().OnCheckSystemAvailableResult(this.nativeDelegate, this, 0);
        }
    }

    public void notifyAccelerate(int i, int i2, int i3) {
        try {
            Method method = Class.forName(sEmcomManagerExClass).getMethod(sNotifyAppInfoMethod, Bundle.class);
            Log.e("SA", "notify scene:" + i + " value: " + i2 + " fd:" + i3);
            Bundle bundle = new Bundle();
            bundle.putInt("msgType", 49);
            bundle.putInt("scene", 16);
            bundle.putInt("subscene", i2);
            bundle.putInt("status", 1);
            bundle.putInt("accStatus", 3);
            bundle.putString("KFD", "" + i3);
            method.invoke(null, bundle);
            TTSocketAccelerateJni.get().OnNotifyAccelerateResult(this.nativeDelegate, this, i, 0);
        } catch (Throwable th) {
            th.printStackTrace();
            TTSocketAccelerateJni.get().OnNotifyAccelerateResult(this.nativeDelegate, this, i, -1000);
        }
    }
}
