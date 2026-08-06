package ms.bd.p001c;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.WindowManager;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import net.openid.appauth.BuildConfig;

/* renamed from: ms.bd.c.r1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0199r1 {

    /* renamed from: a */
    public final boolean f363a;

    /* renamed from: b */
    public final Context f364b;

    /* renamed from: c */
    public final WindowManager f365c;

    /* renamed from: d */
    public C0194q1 f366d;

    /* renamed from: e */
    public boolean f367e = false;

    /* renamed from: g */
    public final C0214u1 f369g = new C0214u1();

    /* renamed from: f */
    public final LinkedBlockingDeque f368f = new LinkedBlockingDeque();

    /* renamed from: h */
    public final Object f370h = new Object();

    static {
    }

    public C0199r1(Context context) {
        boolean canDrawOverlays = Settings.canDrawOverlays(context);
        this.f363a = canDrawOverlays;
        if (canDrawOverlays) {
            this.f364b = context;
            this.f365c = (WindowManager) context.getSystemService((String) AbstractC0190p2.m166a(16777217, 0, 0L, "7f9e42", new byte[]{49, 109, 68, 21, 4, 50}));
        }
    }

    /* renamed from: a */
    public final void m178a() {
        if (this.f363a) {
            if (this.f366d == null) {
                this.f366d = new C0194q1(this, this.f364b);
            }
            if (this.f367e) {
                return;
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(1, 1, Build.VERSION.SDK_INT >= 26 ? 2038 : 2002, 262152, -3);
            layoutParams.gravity = 8388661;
            try {
                this.f365c.addView(this.f366d, layoutParams);
            } catch (Exception unused) {
            }
            this.f367e = true;
        }
    }

    /* renamed from: b */
    public final String m180b() {
        String str;
        if (!this.f363a) {
            C0214u1 c0214u1 = this.f369g;
            c0214u1.f404b = -1L;
            return c0214u1.toString();
        }
        if (this.f368f.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        synchronized (this.f370h) {
            int i = 0;
            this.f368f.size();
            LinkedBlockingDeque linkedBlockingDeque = this.f368f;
            int i2 = AbstractC0112b4.f142a;
            if (linkedBlockingDeque != null && !linkedBlockingDeque.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator it = linkedBlockingDeque.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().toString());
                    if (i < linkedBlockingDeque.size() - 1) {
                        sb.append((Object) '|');
                    }
                    i++;
                }
                str = sb.toString();
                this.f368f.clear();
            }
            str = BuildConfig.FLAVOR;
            this.f368f.clear();
        }
        return str;
    }

    /* renamed from: c */
    public final void m181c() {
        if (this.f363a) {
            this.f369g.f408f = SystemClock.uptimeMillis();
            this.f369g.f403a++;
            C0214u1 clone = this.f369g.clone();
            synchronized (this.f370h) {
                if (this.f368f.size() > 50) {
                    this.f368f.pop();
                }
                this.f368f.add(clone);
            }
            C0214u1 c0214u1 = this.f369g;
            c0214u1.f404b = 0L;
            c0214u1.f405c = 0L;
        }
    }

    /* renamed from: a */
    public final void m179a(boolean z) {
        if (this.f363a) {
            C0194q1 c0194q1 = this.f366d;
            if (c0194q1 != null && this.f367e) {
                try {
                    this.f365c.removeView(c0194q1);
                } catch (Exception unused) {
                }
                this.f367e = false;
            }
            if (z) {
                this.f366d = null;
                C0214u1 c0214u1 = this.f369g;
                c0214u1.f404b = 0L;
                c0214u1.f405c = 0L;
                c0214u1.f403a = 0L;
            }
        }
    }
}
