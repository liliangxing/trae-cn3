package ms.bd.p001c;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.Method;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* renamed from: ms.bd.c.b0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class RunnableC0108b0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Context f134a;

    /* renamed from: b */
    public final /* synthetic */ C0120d0 f135b;

    public RunnableC0108b0(C0120d0 c0120d0, Context context) {
        this.f135b = c0120d0;
        this.f134a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Method method;
        String str;
        C0157j1 c0157j1;
        C0235y2 c0235y2;
        C0235y2 c0235y22;
        while (!((Boolean) AbstractC0190p2.m166a(67108868, 0, 0L, null, null)).booleanValue()) {
            try {
                Thread.sleep(500L);
            } catch (Throwable unused) {
                return;
            }
        }
        C0120d0 c0120d0 = this.f135b;
        Context context = this.f134a;
        c0120d0.getClass();
        String m81b = C0120d0.m81b(context);
        if (m81b != null) {
            this.f135b.f153a.f473a.f481c = m81b;
        }
        String m78a = C0120d0.m78a(this.f134a);
        if (m78a != null) {
            this.f135b.f153a.f473a.f480b = m78a;
        }
        if (((String) AbstractC0190p2.m166a(16777217, 0, 0L, "0ebc4a", new byte[]{0, 84, 36, 36})).equals(C0120d0.m80a(this.f135b).toUpperCase())) {
            new C0107b(this.f134a).m71a(this.f135b.f153a);
        } else {
            this.f135b.getClass();
            String m79a = C0120d0.m79a((String) AbstractC0190p2.m166a(16777217, 0, 0L, "d9c00a", new byte[]{103, 52, 94, 70, 26, Byte.MAX_VALUE, 107, 28, 124, 118, 112, 41, 3, 77, 0, 120, 41, 29, Utf8.REPLACEMENT_BYTE, 117, 124}));
            if ((TextUtils.isEmpty(m79a) || m79a.contains((String) AbstractC0190p2.m166a(16777217, 0, 0L, "b4cf27", new byte[]{102, 56, 27, 28, 2, 55, 111}))) && !((String) AbstractC0190p2.m166a(16777217, 0, 0L, "7a4865", new byte[]{14, 86, 102, 123, 44, 11})).equals(C0120d0.m80a(this.f135b).toUpperCase()) && !((String) AbstractC0190p2.m166a(16777217, 0, 0L, "1f3e0b", new byte[]{8, 77, 110, 62, 57, 84})).equals(C0120d0.m80a(this.f135b).toUpperCase())) {
                if (((String) AbstractC0190p2.m166a(16777217, 0, 0L, "d8cd28", new byte[]{93, 21, 62, Utf8.REPLACEMENT_BYTE, Utf8.REPLACEMENT_BYTE})).equals(C0120d0.m80a(this.f135b).toUpperCase())) {
                    new C0121d1(this.f134a).m82a(this.f135b.f153a);
                } else {
                    if (!((String) AbstractC0190p2.m166a(16777217, 0, 0L, "e8e07c", new byte[]{91, 10, 38, 107})).equals(C0120d0.m80a(this.f135b).toUpperCase()) && !((String) AbstractC0190p2.m166a(16777217, 0, 0L, "b3b76e", new byte[]{65, 20, 48, 111, 36, 87})).equals(C0120d0.m80a(this.f135b).toUpperCase()) && !((String) AbstractC0190p2.m166a(16777217, 0, 0L, "9c4409", new byte[]{7, 79, 98, 112, 35, 27, 9})).equals(C0120d0.m80a(this.f135b).toUpperCase())) {
                        if (((String) AbstractC0190p2.m166a(16777217, 0, 0L, "0d8898", new byte[]{18, 71, 102, Byte.MAX_VALUE, 51, 1, 20})).equals(C0120d0.m80a(this.f135b).toUpperCase())) {
                            new C0191p3(this.f134a).m168a(this.f135b.f153a);
                        } else {
                            if (((String) AbstractC0190p2.m166a(16777217, 0, 0L, "bd9338", new byte[]{95, 67, 100, 104, 58, 0})).equals(C0120d0.m80a(this.f135b).toUpperCase())) {
                                c0157j1 = new C0157j1(this.f134a);
                                c0235y2 = this.f135b.f153a;
                            } else if (((String) AbstractC0190p2.m166a(16777217, 0, 0L, "611228", new byte[]{10, 28, 118, 105, 33, 0, 7, 49})).equals(C0120d0.m80a(this.f135b).toUpperCase())) {
                                c0157j1 = new C0157j1(this.f134a);
                                c0235y2 = this.f135b.f153a;
                            } else {
                                if (((String) AbstractC0190p2.m166a(16777217, 0, 0L, "174010", new byte[]{14, 0, 101, 109, 47})).equals(C0120d0.m80a(this.f135b).toUpperCase())) {
                                    str = new C0230x2(this.f134a).m208a();
                                } else if (((String) AbstractC0190p2.m166a(16777217, 0, 0L, "27b98a", new byte[]{21, 28, 39, 98})).equals(C0120d0.m80a(this.f135b).toUpperCase())) {
                                    str = new C0160j4(this.f134a).m133a();
                                } else if (((String) AbstractC0190p2.m166a(16777217, 0, 0L, "f52561", new byte[]{90, 18, 104, 123, 60})).equals(C0120d0.m80a(this.f135b).toUpperCase())) {
                                    new C0195q2(this.f134a).m173a(this.f135b.f153a);
                                } else {
                                    this.f135b.getClass();
                                    String m79a2 = C0120d0.m79a((String) AbstractC0190p2.m166a(16777217, 0, 0L, "00e0a8", new byte[]{51, Base64.padSymbol, 88, 73, 87, 58, 58, 95, 33, 105, 111, 36, 19, 86, 77, 38, 60, 31, 122, 110, 32, Utf8.REPLACEMENT_BYTE, 19}));
                                    if ((TextUtils.isEmpty(m79a2) || m79a2.contains((String) AbstractC0190p2.m166a(16777217, 0, 0L, "c6cc91", new byte[]{103, 58, 27, 25, 9, 49, 110}))) && !((String) AbstractC0190p2.m166a(16777217, 0, 0L, "282feb", new byte[]{27, 19, 96, Base64.padSymbol, 119, 92})).equals(C0120d0.m80a(this.f135b).toUpperCase()) && !((String) AbstractC0190p2.m166a(16777217, 0, 0L, "ebdc1d", new byte[]{70, 69, 51, 58, 39})).equals(C0120d0.m80a(this.f135b).toUpperCase()) && !((String) AbstractC0190p2.m166a(16777217, 0, 0L, "727d80", new byte[]{4, 28, 101, 51, 44, 20, 28, 50, 84, 31})).equals(C0120d0.m80a(this.f135b).toUpperCase())) {
                                        new C0232y(this.f134a).m210a(this.f135b.f153a);
                                    }
                                    Context context2 = this.f134a;
                                    C0166k4 c0166k4 = new C0166k4(context2);
                                    if (c0166k4.f213a != null && (obj = c0166k4.f214b) != null && (method = c0166k4.f215c) != null) {
                                        try {
                                            str = (String) method.invoke(obj, context2);
                                        } catch (Exception unused2) {
                                        }
                                    }
                                }
                                if (str != null || (c0235y22 = this.f135b.f153a) == null) {
                                }
                                c0235y22.f473a.f479a = str;
                                return;
                            }
                            c0157j1.m132a(c0235y2);
                        }
                    }
                    new C0111b3(this.f134a).m73a(this.f135b.f153a);
                }
            }
            new C0233y0(this.f134a).m211a(this.f135b.f153a);
        }
        str = null;
        if (str != null) {
        }
    }
}
