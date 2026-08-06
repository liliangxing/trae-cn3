package com.bytedance.push.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

/* loaded from: classes4.dex */
public class TelephonyUtils {
    public static boolean hasSimCard(Context context) {
        int simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
        return (simState == 0 || simState == 1) ? false : true;
    }
}
