package com.apm.lite.p021i;

import android.os.Handler;
import android.text.TextUtils;
import com.apm.lite.C0749e;
import com.apm.lite.p023k.C0794q;

/* renamed from: com.apm.lite.i.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0764c extends AbstractRunnableC0762a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0764c(Handler handler, long j, long j2) {
        super(handler, j, j2);
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        if (C0749e.m560c().m1228b()) {
            C0794q.m887a((Object) "[DeviceIdTask] did is done, stop check.");
            return;
        }
        String m1124d = C0749e.m553a().m1124d();
        if (TextUtils.isEmpty(m1124d) || "0".equals(m1124d)) {
            m642a(m644c());
            str = "[DeviceIdTask] did is null, continue check.";
        } else {
            C0749e.m560c().m1227a(m1124d);
            str = "[DeviceIdTask] did is " + m1124d;
        }
        C0794q.m887a((Object) str);
    }
}
