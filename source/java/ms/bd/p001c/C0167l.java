package ms.bd.p001c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.Window;
import com.bytedance.mobsec.metasec.ml.MSC;
import java.util.Arrays;

/* renamed from: ms.bd.c.l */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0167l implements Application.ActivityLifecycleCallbacks {
    /* renamed from: a */
    public static void m139a(Activity activity) {
        Window.Callback callback;
        int i = AbstractC0177n.f246a;
        String packageName = activity.getPackageName();
        String className = activity.getComponentName().getClassName();
        if (Arrays.asList(AbstractC0205s2.f394a).contains(packageName) && Arrays.asList(AbstractC0205s2.f395b).contains(className) && (callback = activity.getWindow().getCallback()) != null) {
            activity.getWindow().setCallback(new C0222w(callback));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(final Activity activity, Bundle bundle) {
        if (((String) AbstractC0190p2.m166a(16777217, 0, 0L, "5e1c26", new byte[]{32, 104, 87, 14, 4, 47})).equals((String) AbstractC0190p2.m166a(16777217, 0, 0L, "18ed96", new byte[]{36, 53, 3, 9, 15, 47})) && (MSC.GetABSwitch() & 256) == 256) {
            AbstractC0177n.f253h.post(new Runnable() { // from class: ms.bd.c.l$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C0167l.m139a(activity);
                }
            });
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (AbstractC0177n.f250e) {
            return;
        }
        AbstractC0177n.f250e = true;
        AbstractC0177n.f253h.post(new RunnableC0149i(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        if (AbstractC0177n.f250e) {
            AbstractC0177n.f253h.post(new RunnableC0161k(this));
        }
    }
}
