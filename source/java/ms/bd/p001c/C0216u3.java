package ms.bd.p001c;

import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.HandlerThread;
import kotlin.io.encoding.Base64;

/* renamed from: ms.bd.c.u3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0216u3 {

    /* renamed from: f */
    public static volatile C0216u3 f411f;

    /* renamed from: a */
    public final HandlerThread f412a;

    /* renamed from: b */
    public final Context f413b;

    /* renamed from: c */
    public boolean f414c = false;

    /* renamed from: d */
    public DisplayManager f415d;

    /* renamed from: e */
    public C0126e0 f416e;

    public C0216u3(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f413b = applicationContext;
        if (!(applicationContext instanceof Application)) {
            Context context2 = null;
            try {
                context2 = (Application) Class.forName((String) AbstractC0190p2.m166a(16777217, 0, 0L, "47a00e", new byte[]{36, 59, 22, 86, 0, 123, 51, 88, 49, 112, 53, 123, 51, 71, 27, 123, 33, 31, 36, 121, 17, Base64.padSymbol, 0, 65, 14, 118})).getMethod((String) AbstractC0190p2.m166a(16777217, 0, 0L, "23394a", new byte[]{32, 36, 82, 95, 14, 120, 37, 51, 114, 121, 47, 56, 67, 76, 31, Byte.MAX_VALUE, 62, 28}), null).invoke(null, null);
            } catch (Throwable unused) {
            }
            this.f413b = context2 == null ? this.f413b : context2;
        }
        this.f412a = new HandlerThread((String) AbstractC0190p2.m166a(16777217, 0, 0L, "a1e5d9", new byte[]{93, 0, 37, 115}));
    }

    /* renamed from: a */
    public final synchronized void m195a() {
        if (this.f414c) {
            return;
        }
        this.f414c = true;
        new Thread(new RunnableC0211t3(this)).start();
    }

    public final void finalize() {
        C0126e0 c0126e0;
        synchronized (this) {
            try {
                DisplayManager displayManager = this.f415d;
                if (displayManager != null && (c0126e0 = this.f416e) != null) {
                    displayManager.unregisterDisplayListener(c0126e0);
                }
            } catch (Throwable unused) {
            }
            HandlerThread handlerThread = this.f412a;
            if (handlerThread != null) {
                try {
                    handlerThread.quitSafely();
                } catch (Throwable unused2) {
                }
            }
        }
        super.finalize();
    }
}
