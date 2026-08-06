package com.bytedance.applog.collector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.applog.AppLogHelper;
import com.bytedance.applog.log.LoggerImpl;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Collector extends BroadcastReceiver {
    public static final String KEY_DATA = "K_DATA";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String[] stringArrayExtra = intent.getStringArrayExtra(KEY_DATA);
        if (stringArrayExtra != null && stringArrayExtra.length > 0) {
            AppLogHelper.receive(stringArrayExtra);
        } else {
            LoggerImpl.global().warn("Collector onReceive empty", new Object[0]);
        }
    }
}
