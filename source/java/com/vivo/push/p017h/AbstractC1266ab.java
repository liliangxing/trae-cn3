package com.vivo.push.p017h;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.ss.android.http.legacy.protocol.HTTP;
import com.vivo.push.AbstractC1400v;
import com.vivo.push.AbstractRunnableC1352s;
import com.vivo.push.C1306m;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.C1367ab;
import com.vivo.push.util.C1373ah;
import com.vivo.push.util.C1393t;
import com.vivo.push.util.NotifyAdapterUtil;
import java.security.PublicKey;
import java.util.HashMap;

/* compiled from: OnReceiveTask.java */
/* renamed from: com.vivo.push.h.ab */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractC1266ab extends AbstractRunnableC1352s {

    /* renamed from: b */
    protected PushMessageCallback f454b;

    /* renamed from: c */
    private int f455c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC1266ab(AbstractC1400v abstractC1400v) {
        super(abstractC1400v);
        this.f455c = 0;
    }

    /* renamed from: a */
    public final void m706a(PushMessageCallback pushMessageCallback) {
        this.f454b = pushMessageCallback;
    }

    /* renamed from: a */
    public final boolean m707a(PublicKey publicKey, String str, String str2) {
        if (!C1306m.m762a().m789d()) {
            C1393t.m1048d("OnVerifyCallBackCommand", "vertify is not support , vertify is ignore");
            return true;
        }
        if (publicKey == null) {
            C1393t.m1048d("OnVerifyCallBackCommand", "vertify key is null");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            C1393t.m1048d("OnVerifyCallBackCommand", "contentTag is null");
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                C1393t.m1048d("OnVerifyCallBackCommand", str.hashCode() + " = " + str2);
                if (C1367ab.m937a(str.getBytes(HTTP.UTF_8), publicKey, Base64.decode(str2, 2))) {
                    C1393t.m1048d("OnVerifyCallBackCommand", "vertify id is success");
                    return true;
                }
                C1393t.m1048d("OnVerifyCallBackCommand", "vertify fail srcDigest is ".concat(String.valueOf(str)));
                C1393t.m1047c(this.f625a, "vertify fail srcDigest is ".concat(String.valueOf(str)));
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                C1393t.m1048d("OnVerifyCallBackCommand", "vertify exception");
                return false;
            }
        }
        C1393t.m1048d("OnVerifyCallBackCommand", "vertify id is null");
        return false;
    }

    /* renamed from: b */
    public final int m708b() {
        NotificationManager notificationManager = (NotificationManager) this.f625a.getSystemService("notification");
        if (notificationManager != null && !notificationManager.areNotificationsEnabled()) {
            return 2104;
        }
        if (Build.VERSION.SDK_INT < 26 || notificationManager == null) {
            return 0;
        }
        try {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(NotifyAdapterUtil.PRIMARY_CHANNEL);
            if (notificationChannel != null) {
                return notificationChannel.getImportance() == 0 ? 2121 : 0;
            }
            return 0;
        } catch (Exception unused) {
            C1393t.m1041b("OnVerifyCallBackCommand", "判断通知通道出现系统错误");
            return 0;
        }
    }

    /* renamed from: a */
    public final int m703a(NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        if (notifyArriveCallbackByUser == null) {
            C1393t.m1041b("OnVerifyCallBackCommand", "pkg name : " + this.f625a.getPackageName() + " 应用到达回调返回值为空，不做处理");
            C1393t.m1043b(this.f625a, "应用到达回调返回值异常，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回正确的对象");
            return 2163;
        }
        if (!notifyArriveCallbackByUser.isIntercept()) {
            return 0;
        }
        C1393t.m1041b("OnVerifyCallBackCommand", "pkg name : " + this.f625a.getPackageName() + " 应用主动拦截通知");
        C1393t.m1043b(this.f625a, "应用主动拦截通知，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回false");
        return 2120;
    }

    /* renamed from: a */
    public final HashMap<String, String> m704a(long j) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("messageID", String.valueOf(j));
        String mo854a = C1313a.m810a().m815e().mo854a();
        if (!TextUtils.isEmpty(mo854a)) {
            hashMap.put("remoteAppId", mo854a);
        }
        hashMap.put("clientsdkver", String.valueOf(C1373ah.m964c(this.f625a, this.f625a.getPackageName())));
        return hashMap;
    }

    /* renamed from: c */
    public final int m709c() {
        return this.f455c;
    }

    /* renamed from: a */
    public final void m705a(int i) {
        this.f455c = i;
    }
}
