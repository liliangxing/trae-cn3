package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;

/* renamed from: com.xiaomi.push.by */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1518by {

    /* renamed from: a */
    private static String f1129a;

    /* renamed from: a */
    private static SimpleDateFormat f1130a;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f1130a = simpleDateFormat;
        f1129a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: a */
    public static C1637gi m1723a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C1637gi c1637gi = new C1637gi();
        c1637gi.m2746d("category_push_stat");
        c1637gi.m2727a("push_sdk_stat_channel");
        c1637gi.m2726a(1L);
        c1637gi.m2738b(str);
        c1637gi.m2729a(true);
        c1637gi.m2737b(System.currentTimeMillis());
        c1637gi.m2754g(C1506bm.m1678a(context).m1685a());
        c1637gi.m2749e("com.xiaomi.xmsf");
        c1637gi.m2752f("");
        c1637gi.m2742c("push_stat");
        return c1637gi;
    }
}
