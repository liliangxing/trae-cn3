package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.C1443b;
import com.xiaomi.mipush.sdk.C1457p;
import com.xiaomi.mipush.sdk.C1462u;
import com.xiaomi.mipush.sdk.COSPushHelper;
import com.xiaomi.mipush.sdk.EnumC1445d;
import com.xiaomi.mipush.sdk.EnumC1463v;
import com.xiaomi.mipush.sdk.FTOSPushHelper;
import com.xiaomi.mipush.sdk.HWPushHelper;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.C1486at;
import com.xiaomi.push.C1626fy;
import com.xiaomi.push.C1696l;
import com.xiaomi.push.service.ServiceClient;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NetworkStatusReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static boolean f3209a;

    /* renamed from: b */
    private boolean f3210b = true;

    public NetworkStatusReceiver() {
    }

    public NetworkStatusReceiver(Object obj) {
        f3209a = true;
    }

    /* renamed from: a */
    public static boolean m3977a() {
        return f3209a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        if (this.f3210b) {
            return;
        }
        C1486at.m1543a();
        C1696l.m3450a().post(new Runnable() { // from class: com.xiaomi.push.service.receivers.NetworkStatusReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                NetworkStatusReceiver.this.m3975a(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3975a(Context context) {
        if (!C1462u.m1373a(context).m1417a() && C1443b.m1222a(context).m1242c() && !C1443b.m1222a(context).m1248f()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                ServiceClient.getInstance(context).startServiceSafely(intent);
            } catch (Exception e) {
                AbstractC1417b.m1093a(e);
            }
        }
        C1626fy.m2661a(context);
        if (C1486at.m1545a(context) && C1462u.m1373a(context).m1421b()) {
            C1462u.m1373a(context).m1422c();
        }
        if (C1486at.m1545a(context)) {
            if ("syncing".equals(C1457p.m1333a(context).m1335a(EnumC1463v.DISABLE_PUSH))) {
                MiPushClient.disablePush(context);
            }
            if ("syncing".equals(C1457p.m1333a(context).m1335a(EnumC1463v.ENABLE_PUSH))) {
                MiPushClient.enablePush(context);
            }
            if ("syncing".equals(C1457p.m1333a(context).m1335a(EnumC1463v.UPLOAD_HUAWEI_TOKEN))) {
                C1462u.m1373a(context).m1413a((String) null, EnumC1463v.UPLOAD_HUAWEI_TOKEN, EnumC1445d.ASSEMBLE_PUSH_HUAWEI, "net");
            }
            if ("syncing".equals(C1457p.m1333a(context).m1335a(EnumC1463v.UPLOAD_FCM_TOKEN))) {
                C1462u.m1373a(context).m1413a((String) null, EnumC1463v.UPLOAD_HUAWEI_TOKEN, EnumC1445d.ASSEMBLE_PUSH_HUAWEI, "net");
            }
            if ("syncing".equals(C1457p.m1333a(context).m1335a(EnumC1463v.UPLOAD_COS_TOKEN))) {
                C1462u.m1373a(context).m1413a((String) null, EnumC1463v.UPLOAD_COS_TOKEN, EnumC1445d.ASSEMBLE_PUSH_COS, "net");
            }
            if ("syncing".equals(C1457p.m1333a(context).m1335a(EnumC1463v.UPLOAD_FTOS_TOKEN))) {
                C1462u.m1373a(context).m1413a((String) null, EnumC1463v.UPLOAD_FTOS_TOKEN, EnumC1445d.ASSEMBLE_PUSH_FTOS, "net");
            }
            if (HWPushHelper.needConnect() && HWPushHelper.shouldTryConnect(context)) {
                HWPushHelper.setConnectTime(context);
                HWPushHelper.registerHuaWeiAssemblePush(context);
            }
            COSPushHelper.doInNetworkChange(context);
            FTOSPushHelper.doInNetworkChange(context);
        }
    }
}
