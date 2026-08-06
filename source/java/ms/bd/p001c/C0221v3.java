package ms.bd.p001c;

import android.content.Context;
import android.os.Build;
import android.view.WindowManager;
import org.json.JSONObject;

/* renamed from: ms.bd.c.v3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0221v3 {

    /* renamed from: d */
    public static volatile C0221v3 f438d;

    /* renamed from: e */
    public static final JSONObject f439e = new JSONObject();

    /* renamed from: a */
    public final Context f440a;

    /* renamed from: b */
    public boolean f441b = false;

    /* renamed from: c */
    public C0206s3 f442c;

    public C0221v3(Context context) {
        this.f440a = context.getApplicationContext();
    }

    /* renamed from: a */
    public static C0221v3 m202a(Context context) {
        if (f438d == null) {
            synchronized (C0221v3.class) {
                if (f438d == null) {
                    f438d = new C0221v3(context);
                }
            }
        }
        return f438d;
    }

    /* renamed from: b */
    public final synchronized void m204b() {
        Context context;
        try {
            if (this.f441b && (context = this.f440a) != null && Build.VERSION.SDK_INT >= 35) {
                this.f442c = new C0206s3();
                ((WindowManager) context.getSystemService((String) AbstractC0190p2.m166a(16777217, 0, 0L, "d87c2f", new byte[]{98, 51, 74, 19, 2, 102}))).addScreenRecordingCallback(this.f440a.getMainExecutor(), this.f442c);
            }
        } catch (Throwable unused) {
        }
    }

    public final void finalize() {
        synchronized (this) {
            if (this.f441b && Build.VERSION.SDK_INT >= 35) {
                if (this.f442c != null) {
                    ((WindowManager) this.f440a.getSystemService((String) AbstractC0190p2.m166a(16777217, 0, 0L, "d54e11", new byte[]{98, 62, 73, 21, 1, 49}))).removeScreenRecordingCallback(this.f442c);
                }
                this.f441b = false;
            }
        }
        super.finalize();
    }

    /* renamed from: a */
    public final synchronized void m203a() {
        if (this.f441b) {
            return;
        }
        this.f441b = true;
        if (Build.VERSION.SDK_INT < 35) {
            return;
        }
        m204b();
    }
}
