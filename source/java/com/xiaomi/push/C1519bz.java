package com.xiaomi.push;

import android.system.Os;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import java.io.File;

/* renamed from: com.xiaomi.push.bz */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1519bz {
    /* renamed from: a */
    public static long m1724a(String str) {
        try {
            if (new File(str).exists()) {
                return Os.stat(str).st_size;
            }
            return 0L;
        } catch (Exception e) {
            AbstractC1417b.m1093a(e);
            return 0L;
        }
    }
}
