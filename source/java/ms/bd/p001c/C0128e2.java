package ms.bd.p001c;

import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import org.json.JSONObject;

/* renamed from: ms.bd.c.e2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0128e2 {

    /* renamed from: a */
    public long f163a;

    /* renamed from: b */
    public String f164b;

    /* renamed from: a */
    public final void m87a(String str, int i) {
        C0241z3 c0241z3;
        synchronized (C0241z3.class) {
            c0241z3 = C0241z3.f482c;
        }
        if (c0241z3 == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f163a;
        long j2 = currentTimeMillis - j;
        String str2 = this.f164b;
        SDKMonitor sDKMonitor = c0241z3.f483a;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorApiError(j2, j, str2, (String) null, str, i, (JSONObject) null);
    }
}
