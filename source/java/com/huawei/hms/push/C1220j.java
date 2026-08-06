package com.huawei.hms.push;

import android.app.Notification;
import android.text.TextUtils;

/* compiled from: NotificationUtils.java */
/* renamed from: com.huawei.hms.push.j */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1220j {
    /* renamed from: a */
    public static EnumC1221k m1963a(C1225o c1225o) {
        EnumC1221k enumC1221k = EnumC1221k.STYLE_DEFAULT;
        return (c1225o.m2017v() < 0 || c1225o.m2017v() >= EnumC1221k.values().length) ? enumC1221k : EnumC1221k.values()[c1225o.m2017v()];
    }

    /* renamed from: a */
    public static void m1964a(Notification.Builder builder, String str, C1225o c1225o) {
        Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
        if (!TextUtils.isEmpty(c1225o.m2004g())) {
            bigTextStyle.setBigContentTitle(c1225o.m2004g());
        }
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            bigTextStyle.bigText(str);
        }
        builder.setStyle(bigTextStyle);
    }
}
