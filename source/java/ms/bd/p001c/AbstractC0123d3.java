package ms.bd.p001c;

import android.content.Context;
import android.os.Process;

/* renamed from: ms.bd.c.d3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0123d3 {
    /* renamed from: a */
    public static boolean m84a(String... strArr) {
        try {
            Context context = C0122d2.f158b.f159a;
            for (String str : strArr) {
                if (context.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m83a() {
        return m84a((String) AbstractC0190p2.m166a(16777217, 0, 0L, "5c1e9e", new byte[]{37, 111, 70, 3, 9, 123, 50, 12, 112, 48, 54, 108, 75, 2, 21, 123, 57, 76, 46, 20, 7, 66, 103, 34, 53, 77, 1, 107, 70, 28, 27, 82, 118, 48, 50, 87}));
    }
}
