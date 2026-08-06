package com.bytedance.push.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.common.support.PushCommonSupport;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BatteryUtils {
    public static boolean isUsbCharging(Context context) {
        Intent registerReceiver = PushCommonSupport.getInstance().getIPushCommonConfiguration().registerReceiver(context, (BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return registerReceiver != null && registerReceiver.getIntExtra("plugged", -1) == 2;
    }
}
