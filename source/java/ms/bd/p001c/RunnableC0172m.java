package ms.bd.p001c;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import kotlin.io.encoding.Base64;

/* renamed from: ms.bd.c.m */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class RunnableC0172m implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        if (AbstractC0177n.f252g.getAndSet(false)) {
            try {
                HandlerThread handlerThread = AbstractC0177n.f251f;
                handlerThread.start();
                AbstractC0177n.f253h = new Handler(handlerThread.getLooper());
            } catch (Exception unused) {
            }
            Application application = null;
            try {
                application = (Application) Class.forName((String) AbstractC0190p2.m166a(16777217, 0, 0L, "b13686", new byte[]{114, Base64.padSymbol, 68, 80, 8, 40, 101, 94, 99, 118, 99, 125, 97, 65, 19, 40, 119, 25, 118, Byte.MAX_VALUE, 71, 59, 82, 71, 6, 37})).getMethod((String) AbstractC0190p2.m166a(16777217, 0, 0L, "b7437f", new byte[]{112, 32, 85, 85, 13, Byte.MAX_VALUE, 117, 55, 117, 115, Byte.MAX_VALUE, 60, 68, 70, 28, 120, 110, 24}), null).invoke(null, null);
            } catch (Throwable unused2) {
            }
            try {
                application.registerActivityLifecycleCallbacks(new C0167l());
            } catch (Throwable unused3) {
            }
        }
    }
}
