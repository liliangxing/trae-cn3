package ms.bd.p001c;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.util.concurrent.CountDownLatch;

/* renamed from: ms.bd.c.p1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0189p1 {

    /* renamed from: a */
    public final C0199r1 f303a;

    /* renamed from: b */
    public final C0219v1 f304b;

    /* renamed from: c */
    public final String f305c;

    /* renamed from: d */
    public final boolean f306d;

    /* renamed from: e */
    public HandlerC0179n1 f307e;

    /* renamed from: f */
    public Handler f308f;

    /* renamed from: g */
    public HandlerThread f309g;

    /* renamed from: h */
    public final CountDownLatch f310h;

    static {
    }

    public C0189p1(Context context, String str) {
        C0199r1 c0199r1 = new C0199r1(context);
        this.f306d = false;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C0219v1 c0219v1 = new C0219v1();
        this.f304b = c0219v1;
        if (c0219v1.f433e) {
        }
        if (c0219v1.f434f) {
            this.f305c = str;
            this.f303a = c0199r1;
            this.f310h = new CountDownLatch(1);
            this.f306d = true;
        }
    }
}
