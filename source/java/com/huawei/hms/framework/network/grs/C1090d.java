package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.framework.network.grs.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1090d {

    /* renamed from: a */
    private static final Map<String, C1089c> f1286a = new ConcurrentHashMap(16);

    /* renamed from: b */
    private static final Object f1287b = new Object();

    /* renamed from: a */
    public static C1089c m1231a(GrsBaseInfo grsBaseInfo, Context context) {
        synchronized (f1287b) {
            int uniqueCode = grsBaseInfo.uniqueCode();
            Map<String, C1089c> map = f1286a;
            C1089c c1089c = map.get(context.getPackageName() + uniqueCode);
            if (c1089c == null) {
                Logger.m1185i("GrsClientManager", "grsClientImpl == null, and new GrsClientImpl");
                C1089c c1089c2 = new C1089c(context, grsBaseInfo);
                map.put(context.getPackageName() + uniqueCode, c1089c2);
                return c1089c2;
            }
            if (c1089c.m1229a((Object) new C1089c(grsBaseInfo))) {
                return c1089c;
            }
            Logger.m1185i("GrsClientManager", "The app_name, ser_country, reg_country and issue_country is equal, but other not.");
            C1089c c1089c3 = new C1089c(context, grsBaseInfo);
            map.put(context.getPackageName() + uniqueCode, c1089c3);
            return c1089c3;
        }
    }
}
