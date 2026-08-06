package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.push.InterfaceC1671hp;

/* renamed from: com.xiaomi.mipush.sdk.k */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1452k {
    /* renamed from: a */
    public static <T extends InterfaceC1671hp<T, ?>> void m1320a(Context context, Config config) {
        if (config == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_cr_config");
        intent.putExtra("action_cr_event_switch", config.isEventUploadSwitchOpen());
        intent.putExtra("action_cr_event_frequency", config.getEventUploadFrequency());
        intent.putExtra("action_cr_perf_switch", config.isPerfUploadSwitchOpen());
        intent.putExtra("action_cr_perf_frequency", config.getPerfUploadFrequency());
        intent.putExtra("action_cr_event_en", config.isEventEncrypted());
        intent.putExtra("action_cr_max_file_size", config.getMaxFileLength());
        C1462u.m1373a(context).m1401a(intent);
    }
}
