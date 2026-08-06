package com.huawei;

import android.content.Context;
import com.bytedance.push.utils.Logger;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.p032hw.HWPushAdapter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HMSUtils {
    public static boolean isHMSAvailable(Context context) {
        Logger.i(HWPushAdapter.TAG, "isHMSAvailableCode = " + isHuaweiMobileServicesAvailable(context));
        return HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(context) == 0;
    }

    public static int isHuaweiMobileServicesAvailable(Context context) {
        return HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(context);
    }
}
