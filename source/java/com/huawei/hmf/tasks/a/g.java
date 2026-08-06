package com.huawei.hmf.tasks.a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.util.Log;
import com.huawei.hmf.tasks.ExecuteResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes6.dex */
public class g extends Fragment {
    public static final WeakHashMap<Activity, WeakReference<g>> b = new WeakHashMap<>();
    public final List<WeakReference<ExecuteResult<?>>> a = new ArrayList();

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Activity activity, ExecuteResult executeResult) {
        g gVar;
        g gVar2;
        WeakReference<g> weakReference = b.get(activity);
        if (weakReference == null || weakReference.get() == null) {
            FragmentManager fragmentManager = activity.getFragmentManager();
            g gVar3 = null;
            try {
                g gVar4 = (g) fragmentManager.findFragmentByTag("com.huawei.hmf.tasks.lifecycle_fragment_tag");
                if (gVar4 == null) {
                    try {
                        gVar2 = new g();
                    } catch (Exception e) {
                        e = e;
                    }
                    try {
                        fragmentManager.beginTransaction().add(gVar2, "com.huawei.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();
                        gVar3 = gVar2;
                    } catch (Exception e2) {
                        e = e2;
                        gVar3 = gVar2;
                        try {
                            Log.e("LifecycleCallbackFrg", "create fragment failed." + e.getMessage());
                            b.put(activity, new WeakReference<>(gVar3));
                        } catch (ClassCastException e3) {
                            e = e3;
                            gVar3 = gVar4;
                            Log.e("LifecycleCallbackFrg", "found LifecycleCallbackFragment but the type do not match. " + e.getMessage());
                            gVar = gVar3;
                            if (gVar != null) {
                            }
                        }
                        gVar = gVar3;
                        if (gVar != null) {
                        }
                    }
                } else {
                    gVar3 = gVar4;
                }
                b.put(activity, new WeakReference<>(gVar3));
            } catch (ClassCastException e4) {
                e = e4;
            }
            gVar = gVar3;
        } else {
            gVar = weakReference.get();
        }
        if (gVar != null) {
            gVar.a(executeResult);
        }
    }

    public final void a(ExecuteResult executeResult) {
        synchronized (this.a) {
            this.a.add(new WeakReference<>(executeResult));
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        synchronized (this.a) {
            Iterator<WeakReference<ExecuteResult<?>>> it = this.a.iterator();
            while (it.hasNext()) {
                ExecuteResult<?> executeResult = it.next().get();
                if (executeResult != null) {
                    executeResult.cancel();
                }
            }
            this.a.clear();
        }
    }
}
