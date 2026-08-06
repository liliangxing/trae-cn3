package com.vivo.push.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.p010b.C1219p;
import com.vivo.push.p016g.C1261b;
import com.vivo.push.restructure.C1313a;
import java.security.PublicKey;
import java.util.HashMap;

/* compiled from: BaseConvertMsgToIntent.java */
/* renamed from: com.vivo.push.util.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractC1375b {

    /* renamed from: a */
    protected String f678a;

    /* renamed from: b */
    protected long f679b;

    /* renamed from: c */
    protected Context f680c;

    /* renamed from: d */
    protected NotifyArriveCallbackByUser f681d;

    /* renamed from: a */
    protected abstract int mo974a();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public abstract PendingIntent mo975a(Context context, Intent intent);

    /* renamed from: a */
    protected abstract Intent mo976a(Context context, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static void m973a(Intent intent, Context context) {
        try {
            String mo690a = C1261b.m693a().m694a(context).mo690a("com.vivo.pushservice");
            PublicKey mo691a = C1261b.m693a().m694a(context).mo691a();
            if (TextUtils.isEmpty(mo690a)) {
                mo690a = "com.vivo.pushservice";
            }
            intent.putExtra("security_avoid_pull_rsa", mo690a);
            intent.putExtra("security_avoid_rsa_public_key", mo691a == null ? "com.vivo.pushservice" : C1367ab.m935a(mo691a));
        } catch (Exception e) {
            C1393t.m1034a("BaseNotifyClickIntentParam", "pushNotificationBySystem encrypt ：" + e.getMessage());
            intent.putExtra("security_avoid_pull_rsa", "com.vivo.pushservice");
            intent.putExtra("security_avoid_rsa_public_key", "com.vivo.pushservice");
        }
    }

    /* renamed from: b */
    public final long m978b() {
        return this.f679b;
    }

    /* renamed from: a */
    public final Intent m977a(Context context, String str, long j, InsideNotificationItem insideNotificationItem, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        this.f679b = j;
        this.f678a = str;
        this.f680c = context;
        this.f681d = notifyArriveCallbackByUser;
        Intent mo976a = mo976a(context, insideNotificationItem, notifyArriveCallbackByUser);
        int mo974a = mo974a();
        if (mo974a <= 0) {
            return mo976a;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("messageID", String.valueOf(this.f679b));
        String mo854a = C1313a.m810a().m815e().mo854a();
        if (!TextUtils.isEmpty(mo854a)) {
            hashMap.put("remoteAppId", mo854a);
        }
        hashMap.put("ap", this.f678a);
        hashMap.put("clientsdkver", String.valueOf(C1373ah.m964c(this.f680c, this.f678a)));
        C1379f.m995a(mo974a, (HashMap<String, String>) hashMap);
        return null;
    }

    /* renamed from: a */
    public static Intent m972a(Context context, String str, long j, Intent intent, InsideNotificationItem insideNotificationItem) {
        Intent intent2 = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent2.setPackage(context.getPackageName());
        intent2.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
        intent2.putExtra("command_type", "reflect_receiver");
        intent2.putExtras(intent.getExtras());
        m973a(intent2, context);
        C1219p c1219p = new C1219p(str, j, insideNotificationItem);
        c1219p.m611b(intent.getAction());
        if (intent.getComponent() != null) {
            c1219p.m612c(intent.getComponent().getPackageName());
            c1219p.m613d(intent.getComponent().getClassName());
        }
        if (intent.getData() != null) {
            c1219p.m610a(intent.getData());
        }
        c1219p.m1068b(intent2);
        return intent2;
    }
}
