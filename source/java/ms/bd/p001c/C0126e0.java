package ms.bd.p001c;

import android.hardware.display.DisplayManager;
import android.text.TextUtils;
import android.view.Display;

/* renamed from: ms.bd.c.e0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0126e0 implements DisplayManager.DisplayListener {

    /* renamed from: a */
    public final DisplayManager f161a;

    public C0126e0(DisplayManager displayManager) {
        this.f161a = displayManager;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i) {
        try {
            Display[] displays = this.f161a.getDisplays();
            int length = displays.length;
            if (length > 0) {
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
                if (!TextUtils.isEmpty(m184b)) {
                    c0201r3.f378g = m184b;
                }
                if (!TextUtils.isEmpty(m183a)) {
                    c0201r3.f379h = m183a;
                }
                c0201r3.f372a = System.currentTimeMillis() / 1000;
                c0201r3.f377f = (String) AbstractC0190p2.m166a(16777217, 0, 0L, "73890a", new byte[]{39, 53, 79});
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i) {
        try {
            Display[] displays = this.f161a.getDisplays();
            int length = displays.length;
            if (length > 0) {
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
                if (!TextUtils.isEmpty(m184b)) {
                    c0201r3.f378g = m184b;
                }
                if (!TextUtils.isEmpty(m183a)) {
                    c0201r3.f379h = m183a;
                }
                c0201r3.f373b = System.currentTimeMillis() / 1000;
                c0201r3.f377f = (String) AbstractC0190p2.m166a(16777217, 0, 0L, "c7f849", new byte[]{96, 48, 24, 67, 29, 43});
            }
        } catch (Exception unused) {
        }
    }
}
