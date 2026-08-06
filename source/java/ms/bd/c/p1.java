package ms.bd.c;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes8.dex */
public final class p1 {
    public final r1 a;
    public final v1 b;
    public final String c;
    public final boolean d;
    public n1 e;
    public Handler f;
    public HandlerThread g;
    public final CountDownLatch h;

    static {
    }

    public p1(Context context, String str) {
        r1 r1Var = new r1(context);
        this.d = false;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        v1 v1Var = new v1();
        this.b = v1Var;
        if (v1Var.e) {
        }
        if (v1Var.f) {
            this.c = str;
            this.a = r1Var;
            this.h = new CountDownLatch(1);
            this.d = true;
        }
    }
}
