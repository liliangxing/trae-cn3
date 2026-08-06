package ms.bd.p001c;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;

/* renamed from: ms.bd.c.t3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class RunnableC0211t3 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C0216u3 f402a;

    public RunnableC0211t3(C0216u3 c0216u3) {
        this.f402a = c0216u3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            C0216u3 c0216u3 = this.f402a;
            if (c0216u3.f413b != null) {
                c0216u3.f412a.start();
                Handler handler = new Handler(this.f402a.f412a.getLooper());
                C0216u3 c0216u32 = this.f402a;
                c0216u32.f415d = (DisplayManager) c0216u32.f413b.getApplicationContext().getSystemService((String) AbstractC0190p2.m166a(16777217, 0, 0L, "8ce276", new byte[]{45, 104, 5, 86, 4, 32, 34}));
                DisplayManager displayManager = this.f402a.f415d;
                if (displayManager != null) {
                    Display[] displays = displayManager.getDisplays();
                    int length = displays.length;
                    if (length > 1) {
                        if (C0201r3.f371j == null) {
                            C0201r3.f371j = new C0201r3();
                        }
                        C0201r3 c0201r3 = C0201r3.f371j;
                        c0201r3.getClass();
                        String m184b = C0201r3.m184b(displays);
                        String m183a = C0201r3.m183a(displays);
                        if (c0201r3.f375d != length) {
                            c0201r3.f376e = System.currentTimeMillis() / 1000;
                        }
                        c0201r3.f375d = length;
                        c0201r3.f380i = true;
                        if (!TextUtils.isEmpty(m184b)) {
                            c0201r3.f378g = m184b;
                        }
                        if (!TextUtils.isEmpty(m183a)) {
                            c0201r3.f379h = m183a;
                        }
                    }
                    C0216u3 c0216u33 = this.f402a;
                    DisplayManager displayManager2 = c0216u33.f415d;
                    C0126e0 c0126e0 = new C0126e0(displayManager2);
                    c0216u33.f416e = c0126e0;
                    displayManager2.registerDisplayListener(c0126e0, handler);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
