package com.huawei.hmf.tasks.p018a;

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

/* renamed from: com.huawei.hmf.tasks.a.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class FragmentC1004g extends Fragment {

    /* renamed from: b */
    public static final WeakHashMap<Activity, WeakReference<FragmentC1004g>> f911b = new WeakHashMap<>();

    /* renamed from: a */
    public final List<WeakReference<ExecuteResult<?>>> f912a = new ArrayList();

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x007e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m855a(Activity activity, ExecuteResult executeResult) {
        FragmentC1004g fragmentC1004g;
        FragmentC1004g fragmentC1004g2;
        WeakReference<FragmentC1004g> weakReference = f911b.get(activity);
        if (weakReference == null || weakReference.get() == null) {
            FragmentManager fragmentManager = activity.getFragmentManager();
            FragmentC1004g fragmentC1004g3 = null;
            try {
                FragmentC1004g fragmentC1004g4 = (FragmentC1004g) fragmentManager.findFragmentByTag("com.huawei.hmf.tasks.lifecycle_fragment_tag");
                if (fragmentC1004g4 == null) {
                    try {
                        fragmentC1004g2 = new FragmentC1004g();
                    } catch (Exception e) {
                        e = e;
                    }
                    try {
                        fragmentManager.beginTransaction().add(fragmentC1004g2, "com.huawei.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();
                        fragmentC1004g3 = fragmentC1004g2;
                    } catch (Exception e2) {
                        e = e2;
                        fragmentC1004g3 = fragmentC1004g2;
                        try {
                            Log.e("LifecycleCallbackFrg", "create fragment failed." + e.getMessage());
                            f911b.put(activity, new WeakReference<>(fragmentC1004g3));
                        } catch (ClassCastException e3) {
                            e = e3;
                            fragmentC1004g3 = fragmentC1004g4;
                            Log.e("LifecycleCallbackFrg", "found LifecycleCallbackFragment but the type do not match. " + e.getMessage());
                            fragmentC1004g = fragmentC1004g3;
                            if (fragmentC1004g != null) {
                            }
                        }
                        fragmentC1004g = fragmentC1004g3;
                        if (fragmentC1004g != null) {
                        }
                    }
                } else {
                    fragmentC1004g3 = fragmentC1004g4;
                }
                f911b.put(activity, new WeakReference<>(fragmentC1004g3));
            } catch (ClassCastException e4) {
                e = e4;
            }
            fragmentC1004g = fragmentC1004g3;
        } else {
            fragmentC1004g = weakReference.get();
        }
        if (fragmentC1004g != null) {
            fragmentC1004g.m856a(executeResult);
        }
    }

    /* renamed from: a */
    public final void m856a(ExecuteResult executeResult) {
        synchronized (this.f912a) {
            this.f912a.add(new WeakReference<>(executeResult));
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        synchronized (this.f912a) {
            Iterator<WeakReference<ExecuteResult<?>>> it = this.f912a.iterator();
            while (it.hasNext()) {
                ExecuteResult<?> executeResult = it.next().get();
                if (executeResult != null) {
                    executeResult.cancel();
                }
            }
            this.f912a.clear();
        }
    }
}
