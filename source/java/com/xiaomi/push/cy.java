package com.xiaomi.push;

import android.content.Context;
import java.io.File;

/* loaded from: classes7.dex */
public class cy {
    private static cx a;

    public static File a(Context context) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.d("ERROR: Context cannot be null.");
            return null;
        }
        cx cxVar = a;
        if (cxVar != null) {
            return cxVar.a(context);
        }
        com.xiaomi.channel.commonutils.logger.b.d("ERROR: XMSF not configure the instance of LogAgent.");
        return null;
    }
}
