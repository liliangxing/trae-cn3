package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* renamed from: com.xiaomi.push.t */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractRunnableC1799t implements Runnable {

    /* renamed from: a */
    private Context f3265a;

    /* renamed from: a */
    private File f3266a;

    /* renamed from: a */
    private Runnable f3267a;

    /* renamed from: a */
    protected abstract void mo4101a(Context context);

    private AbstractRunnableC1799t(Context context, File file) {
        this.f3265a = context;
        this.f3266a = file;
    }

    /* renamed from: a */
    public static void m4100a(Context context, File file, final Runnable runnable) {
        new AbstractRunnableC1799t(context, file) { // from class: com.xiaomi.push.t.1
            @Override // com.xiaomi.push.AbstractRunnableC1799t
            /* renamed from: a */
            protected void mo4101a(Context context2) {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        }.run();
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1704s c1704s = null;
        try {
            try {
                if (this.f3266a == null) {
                    this.f3266a = new File(this.f3265a.getFilesDir(), "default_locker");
                }
                c1704s = C1704s.m3478a(this.f3265a, this.f3266a);
                Runnable runnable = this.f3267a;
                if (runnable != null) {
                    runnable.run();
                }
                mo4101a(this.f3265a);
                if (c1704s == null) {
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (c1704s == null) {
                    return;
                }
            }
            c1704s.m3479a();
        } catch (Throwable th) {
            if (c1704s != null) {
                c1704s.m3479a();
            }
            throw th;
        }
    }
}
