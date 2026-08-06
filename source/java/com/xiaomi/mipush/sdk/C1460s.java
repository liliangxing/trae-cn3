package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.C1448g;
import com.xiaomi.push.C1488av;

/* renamed from: com.xiaomi.mipush.sdk.s */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1460s {
    /* renamed from: a */
    public static AbstractPushManager m1347a(Context context, EnumC1445d enumC1445d) {
        return m1348b(context, enumC1445d);
    }

    /* renamed from: b */
    private static AbstractPushManager m1348b(Context context, EnumC1445d enumC1445d) {
        C1448g.a m1300a = C1448g.m1300a(enumC1445d);
        if (m1300a == null || TextUtils.isEmpty(m1300a.f854a) || TextUtils.isEmpty(m1300a.f855b)) {
            return null;
        }
        return (AbstractPushManager) C1488av.m1570a(m1300a.f854a, m1300a.f855b, context);
    }
}
