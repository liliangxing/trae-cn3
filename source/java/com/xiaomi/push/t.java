package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* loaded from: classes7.dex */
public abstract class t implements Runnable {
    private Context a;

    /* renamed from: a, reason: collision with other field name */
    private File f1093a;

    /* renamed from: a, reason: collision with other field name */
    private Runnable f1094a;

    protected abstract void a(Context context);

    private t(Context context, File file) {
        this.a = context;
        this.f1093a = file;
    }

    public static void a(Context context, File file, final Runnable runnable) {
        new t(context, file) { // from class: com.xiaomi.push.t.1
            @Override // com.xiaomi.push.t
            protected void a(Context context2) {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        }.run();
    }

    @Override // java.lang.Runnable
    public final void run() {
        s sVar = null;
        try {
            try {
                if (this.f1093a == null) {
                    this.f1093a = new File(this.a.getFilesDir(), "default_locker");
                }
                sVar = s.a(this.a, this.f1093a);
                Runnable runnable = this.f1094a;
                if (runnable != null) {
                    runnable.run();
                }
                a(this.a);
                if (sVar == null) {
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (sVar == null) {
                    return;
                }
            }
            sVar.a();
        } catch (Throwable th) {
            if (sVar != null) {
                sVar.a();
            }
            throw th;
        }
    }
}
