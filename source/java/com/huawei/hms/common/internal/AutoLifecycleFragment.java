package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.SparseArray;
import com.huawei.hms.api.HuaweiApiClient;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AutoLifecycleFragment extends Fragment {

    /* renamed from: a */
    private final SparseArray<C1057a> f1175a = new SparseArray<>();

    /* renamed from: b */
    private boolean f1176b;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.huawei.hms.common.internal.AutoLifecycleFragment$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class C1057a {

        /* renamed from: a */
        public final HuaweiApiClient f1177a;

        /* renamed from: b */
        protected final int f1178b;

        public C1057a(int i, HuaweiApiClient huaweiApiClient) {
            this.f1177a = huaweiApiClient;
            this.f1178b = i;
        }

        /* renamed from: a */
        public void m1095a() {
            this.f1177a.disconnect();
        }
    }

    public static AutoLifecycleFragment getInstance(Activity activity) {
        Preconditions.checkMainThread("Must be called on the main thread");
        try {
            AutoLifecycleFragment autoLifecycleFragment = (AutoLifecycleFragment) activity.getFragmentManager().findFragmentByTag("HmsAutoLifecycleFrag");
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (autoLifecycleFragment != null) {
                return autoLifecycleFragment;
            }
            AutoLifecycleFragment autoLifecycleFragment2 = new AutoLifecycleFragment();
            fragmentManager.beginTransaction().add(autoLifecycleFragment2, "HmsAutoLifecycleFrag").commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
            return autoLifecycleFragment2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag HmsAutoLifecycleFrag is not a AutoLifecycleFragment", e);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f1176b = true;
        for (int i = 0; i < this.f1175a.size(); i++) {
            this.f1175a.valueAt(i).f1177a.connect((Activity) null);
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f1176b = false;
        for (int i = 0; i < this.f1175a.size(); i++) {
            this.f1175a.valueAt(i).f1177a.disconnect();
        }
    }

    public void startAutoMange(int i, HuaweiApiClient huaweiApiClient) {
        Preconditions.checkNotNull(huaweiApiClient, "HuaweiApiClient instance cannot be null");
        Preconditions.checkState(this.f1175a.indexOfKey(i) < 0, "Already managing a HuaweiApiClient with this clientId: " + i);
        this.f1175a.put(i, new C1057a(i, huaweiApiClient));
        if (this.f1176b) {
            huaweiApiClient.connect((Activity) null);
        }
    }

    public void stopAutoManage(int i) {
        C1057a c1057a = this.f1175a.get(i);
        this.f1175a.remove(i);
        if (c1057a != null) {
            c1057a.m1095a();
        }
    }
}
