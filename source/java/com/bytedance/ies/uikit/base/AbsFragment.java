package com.bytedance.ies.uikit.base;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.common.utility.collection.WeakContainer;
import java.util.Iterator;

/* loaded from: classes4.dex */
public abstract class AbsFragment extends Fragment implements IComponent {
    protected boolean mStatusActive;
    protected boolean mStatusDestroyed;
    protected boolean mStatusViewValid;
    protected boolean mUserVisibleHintCompat = true;
    private WeakContainer<LifeCycleMonitor> mMonitors = new WeakContainer<>();
    private long mDestoryTime = 0;

    public void registerLifeCycleMonitor(LifeCycleMonitor lifeCycleMonitor) {
        this.mMonitors.add(lifeCycleMonitor);
    }

    public void unregisterLifeCycleMonitor(LifeCycleMonitor lifeCycleMonitor) {
        this.mMonitors.remove(lifeCycleMonitor);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mStatusActive = false;
        this.mStatusViewValid = false;
        this.mStatusDestroyed = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mStatusViewValid = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.putBoolean("WORKAROUND_FOR_BUG_19917_KEY", true);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mStatusActive = true;
        if (this.mMonitors.isEmpty()) {
            return;
        }
        Iterator<LifeCycleMonitor> it = this.mMonitors.iterator();
        while (it.hasNext()) {
            LifeCycleMonitor next = it.next();
            if (next != null) {
                next.onResume();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mMonitors.isEmpty()) {
            return;
        }
        Iterator<LifeCycleMonitor> it = this.mMonitors.iterator();
        while (it.hasNext()) {
            LifeCycleMonitor next = it.next();
            if (next != null) {
                next.onPause();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.mStatusActive = false;
        if (this.mMonitors.isEmpty()) {
            return;
        }
        Iterator<LifeCycleMonitor> it = this.mMonitors.iterator();
        while (it.hasNext()) {
            LifeCycleMonitor next = it.next();
            if (next != null) {
                next.onStop();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mStatusViewValid = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mDestoryTime = System.currentTimeMillis();
        this.mStatusViewValid = false;
        this.mStatusDestroyed = true;
        if (this.mMonitors.isEmpty()) {
            return;
        }
        Iterator<LifeCycleMonitor> it = this.mMonitors.iterator();
        while (it.hasNext()) {
            LifeCycleMonitor next = it.next();
            if (next != null) {
                next.onDestroy();
            }
        }
        this.mMonitors.clear();
    }

    @Override // com.bytedance.ies.uikit.base.IComponent
    public boolean isActive() {
        return this.mStatusActive;
    }

    @Override // com.bytedance.ies.uikit.base.IComponent
    public boolean isViewValid() {
        return this.mStatusViewValid;
    }

    public boolean isDestroyed() {
        return this.mStatusDestroyed;
    }

    public void setUserVisibleHintCompat(boolean z) {
        setUserVisibleHint(z);
    }

    public boolean getUserVisibleHintCompat() {
        return getUserVisibleHint();
    }
}
