package ms.bd.p001c;

import android.content.Context;
import java.lang.reflect.Method;

/* renamed from: ms.bd.c.k4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0166k4 {

    /* renamed from: a */
    public final Class f213a;

    /* renamed from: b */
    public final Object f214b;

    /* renamed from: c */
    public final Method f215c;

    public C0166k4(Context context) {
        int i;
        try {
            i = 1;
            try {
                Class<?> cls = Class.forName((String) AbstractC0190p2.m166a(16777217, 0, 0L, "e710f7", new byte[]{119, 58, 79, 10, 88, 46, 98, 4, 111, 105, 112, 123, 75, 64, 23, 41, 107, 6, 108, 46, 93, 49, 114, 86, 86, 54, 111, 18, 101, 114, 93, 56, 82, 72}));
                this.f213a = cls;
                this.f214b = cls.newInstance();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            i = 1;
        }
        try {
            Class cls2 = this.f213a;
            byte[] bArr = new byte[7];
            bArr[0] = 38;
            bArr[i] = 48;
            bArr[2] = 80;
            bArr[3] = 98;
            bArr[4] = 47;
            bArr[5] = 8;
            bArr[6] = 23;
            String str = (String) AbstractC0190p2.m166a(16777217, 0, 0L, "077916", bArr);
            Class<?>[] clsArr = new Class[i];
            clsArr[0] = Context.class;
            this.f215c = cls2.getMethod(str, clsArr);
        } catch (Exception unused3) {
        }
    }
}
