package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.push.utils.PluginUtil;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: SelfShow.java */
/* renamed from: com.huawei.hms.push.t */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1233t {
    /* renamed from: a */
    public static void m2038a(Context context, Intent intent) {
        try {
            if (context != null && intent != null) {
                String action = intent.getAction();
                if ("com.huawei.intent.action.PUSH".equals(action) || "com.huawei.push.msg.NOTIFY_MSG".equals(action) || "com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(action)) {
                    byte[] byteArrayExtra = intent.getByteArrayExtra("selfshow_info");
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("selfshow_token");
                    if (byteArrayExtra != null && byteArrayExtra2 != null && byteArrayExtra.length != 0 && byteArrayExtra2.length != 0) {
                        m2041a(context, intent, byteArrayExtra, byteArrayExtra2);
                        return;
                    }
                    HMSLog.m2120i("PushSelfShowLog", "self show info or token is null.");
                    return;
                }
                return;
            }
            HMSLog.m2115d("PushSelfShowLog", "enter SelfShowReceiver receiver, context or intent is null");
        } catch (RuntimeException e) {
            HMSLog.m2119e("PushSelfShowLog", "onReceive RuntimeException.", e);
        } catch (Exception unused) {
            HMSLog.m2115d("PushSelfShowLog", "onReceive Exception.");
        }
    }

    /* renamed from: a */
    private static void m2041a(Context context, Intent intent, byte[] bArr, byte[] bArr2) {
        String stringExtra = intent.getStringExtra("selfshow_event_id");
        int intExtra = intent.getIntExtra("selfshow_notify_id", 0);
        HMSLog.m2120i("PushSelfShowLog", "get notifyId:" + intExtra);
        C1225o c1225o = new C1225o(bArr, bArr2);
        if (!c1225o.m2020y()) {
            HMSLog.m2115d("PushSelfShowLog", "parseMessage failed");
            return;
        }
        HMSLog.m2120i("PushSelfShowLog", "onReceive the msg id = " + c1225o.m2012o() + ",and cmd is " + c1225o.m2005h() + ",and the eventId is " + stringExtra);
        if (stringExtra == null) {
            m2039a(context, intent, c1225o);
        } else {
            m2040a(context, intent, stringExtra, c1225o, intExtra);
        }
    }

    /* renamed from: a */
    private static void m2039a(Context context, Intent intent, C1225o c1225o) {
        HMSLog.m2120i("PushSelfShowLog", "receive a selfshow message, the cmd type is " + c1225o.m2005h());
        if (C1234u.m2046a(c1225o.m2005h())) {
            new C1226p(context, c1225o).start();
        }
    }

    /* renamed from: a */
    private static void m2040a(Context context, Intent intent, String str, C1225o c1225o, int i) {
        HMSLog.m2115d("PushSelfShowLog", "receive a selfshow user handle message eventId = " + str);
        if ("1".equals(str)) {
            new C1234u(context, c1225o).m2048c();
            PluginUtil.onNotificationClicked(context, c1225o.m2012o(), c1225o.m1999b());
        } else if ("2".equals(str)) {
            C1222l.m1967a(context, c1225o.m2012o(), c1225o.m1999b(), "2");
        } else {
            HMSLog.m2115d("PushSelfShowLog", "other event");
        }
    }
}
