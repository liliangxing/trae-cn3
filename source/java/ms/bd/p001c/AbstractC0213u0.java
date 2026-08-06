package ms.bd.p001c;

import java.io.Closeable;
import java.io.IOException;

/* renamed from: ms.bd.c.u0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0213u0 {
    /* renamed from: a */
    public static void m194a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
