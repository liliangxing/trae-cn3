package com.heytap.mcssdk.p011b;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.heytap.mcssdk.C0869R;
import com.heytap.mcssdk.utils.C0896e;
import com.heytap.mcssdk.utils.C0897f;
import com.huawei.hms.push.constant.RemoteMessageConst;

/* renamed from: com.heytap.mcssdk.b.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0874a {

    /* renamed from: a */
    public static final String f498a = "Heytap PUSH";

    /* renamed from: b */
    private static final String f499b = "System Default Channel";

    /* renamed from: c */
    private static final int f500c = 3;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m579a(Context context, String str, String str2, int i) {
        NotificationManager notificationManager;
        if (context == null || (notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)) == null) {
            return false;
        }
        notificationManager.createNotificationChannel(new NotificationChannel(str, str2, i));
        return true;
    }

    /* renamed from: a */
    public void m581a(final Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        C0897f.m690a(new Runnable() { // from class: com.heytap.mcssdk.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (C0896e.m684c().m688a()) {
                    return;
                }
                String string = context.getString(C0869R.string.system_default_channel);
                if (TextUtils.isEmpty(string)) {
                    string = C0874a.f499b;
                }
                C0896e.m684c().m687a(C0874a.this.m579a(context, C0874a.f498a, string, 3));
            }
        });
    }
}
