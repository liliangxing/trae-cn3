package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import java.io.File;

/* renamed from: com.xiaomi.push.cy */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1545cy {

    /* renamed from: a */
    private static InterfaceC1544cx f1277a;

    /* renamed from: a */
    public static File m1991a(Context context) {
        if (context == null) {
            AbstractC1417b.m1103d("ERROR: Context cannot be null.");
            return null;
        }
        InterfaceC1544cx interfaceC1544cx = f1277a;
        if (interfaceC1544cx != null) {
            return interfaceC1544cx.m1990a(context);
        }
        AbstractC1417b.m1103d("ERROR: XMSF not configure the instance of LogAgent.");
        return null;
    }
}
