package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1572dy;
import com.xiaomi.push.service.AbstractC1756an;
import com.xiaomi.push.service.ServiceClient;
import com.xiaomi.push.service.XMPushService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PingReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        AbstractC1417b.m1101c(intent.getPackage() + " is the package name");
        if (XMPushService.m3530e()) {
            return;
        }
        if (AbstractC1756an.f3057q.equals(intent.getAction())) {
            if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                AbstractC1417b.m1101c("Ping XMChannelService on timer");
                try {
                    Intent intent2 = new Intent(context, (Class<?>) XMPushService.class);
                    intent2.putExtra("time_stamp", System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    ServiceClient.getInstance(context).startServiceSafely(intent2);
                    return;
                } catch (Exception e) {
                    AbstractC1417b.m1093a(e);
                    return;
                }
            }
            return;
        }
        AbstractC1417b.m1089a("cancel the old ping timer");
        C1572dy.m2324a();
    }
}
