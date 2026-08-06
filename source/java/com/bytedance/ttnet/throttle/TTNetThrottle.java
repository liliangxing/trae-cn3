package com.bytedance.ttnet.throttle;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.TTNetInit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TTNetThrottle {
    public static final int DIRECTION_TYPE_DOWN = 2;
    public static final int DIRECTION_TYPE_PC_DOWN = 8;
    public static final int DIRECTION_TYPE_PC_UP = 4;
    public static final int DIRECTION_TYPE_UP = 1;
    private static final String TAG = "TTNetThrottle";

    public static void start(String[] strArr, int i, long j) {
        if (strArr == null || ((i != 1 && i != 2 && i != 4 && i != 8) || j < 0)) {
            if (Logger.debug()) {
                Logger.e(TAG, "start throttle params error hosts:" + strArr + " directionType:" + i + " bytesPerSec:" + j);
            }
        } else {
            try {
                getCronetHttpClient().startThrottle(strArr, i, j);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void stop(String[] strArr, int i) {
        if (strArr == null || (i != 1 && i != 2 && i != 4 && i != 8)) {
            if (Logger.debug()) {
                Logger.e(TAG, "stop throttle params error hosts:" + strArr + " directionType:" + i);
            }
        } else {
            try {
                getCronetHttpClient().stopThrottle(strArr, i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static SsCronetHttpClient getCronetHttpClient() throws Throwable {
        if (HttpClient.isCronetClientEnable()) {
            return SsCronetHttpClient.inst(TTNetInit.getTTNetDepend().getContext());
        }
        throw new UnsupportedOperationException("Cronet is not enabled");
    }
}
