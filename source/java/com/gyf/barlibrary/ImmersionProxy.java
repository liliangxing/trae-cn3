package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ImmersionProxy {
    private Fragment mFragment;
    private ImmersionOwner mImmersionOwner;
    private boolean mIsActivityCreated;
    private boolean mIsLazyAfterView;
    private boolean mIsLazyBeforeView;

    public ImmersionProxy(Fragment fragment) {
        this.mFragment = fragment;
        if (fragment instanceof ImmersionOwner) {
            this.mImmersionOwner = (ImmersionOwner) fragment;
            return;
        }
        throw new IllegalArgumentException("please implement SimpleImmersionOwner in your Fragment");
    }

    public void setUserVisibleHint(boolean z) {
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            if (fragment.getUserVisibleHint()) {
                if (!this.mIsLazyBeforeView) {
                    this.mImmersionOwner.onLazyBeforeView();
                    this.mIsLazyBeforeView = true;
                }
                if (this.mIsActivityCreated && this.mFragment.getUserVisibleHint()) {
                    if (this.mImmersionOwner.immersionBarEnabled()) {
                        this.mImmersionOwner.initImmersionBar();
                    }
                    if (!this.mIsLazyAfterView) {
                        this.mImmersionOwner.onLazyAfterView();
                        this.mIsLazyAfterView = true;
                    }
                    this.mImmersionOwner.onVisible();
                    return;
                }
                return;
            }
            if (this.mIsActivityCreated) {
                this.mImmersionOwner.onInvisible();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        Fragment fragment = this.mFragment;
        if (fragment == null || !fragment.getUserVisibleHint() || this.mIsLazyBeforeView) {
            return;
        }
        this.mImmersionOwner.onLazyBeforeView();
        this.mIsLazyBeforeView = true;
    }

    public void onActivityCreated(Bundle bundle) {
        this.mIsActivityCreated = true;
        Fragment fragment = this.mFragment;
        if (fragment == null || !fragment.getUserVisibleHint()) {
            return;
        }
        if (this.mImmersionOwner.immersionBarEnabled()) {
            this.mImmersionOwner.initImmersionBar();
        }
        if (this.mIsLazyAfterView) {
            return;
        }
        this.mImmersionOwner.onLazyAfterView();
        this.mIsLazyAfterView = true;
    }

    public void onResume() {
        Fragment fragment = this.mFragment;
        if (fragment == null || !fragment.getUserVisibleHint()) {
            return;
        }
        this.mImmersionOwner.onVisible();
    }

    public void onPause() {
        if (this.mFragment != null) {
            this.mImmersionOwner.onInvisible();
        }
    }

    public void onDestroy() {
        Fragment fragment = this.mFragment;
        if (fragment != null && fragment.getActivity() != null && this.mImmersionOwner.immersionBarEnabled()) {
            ImmersionBar.with(this.mFragment).destroy();
        }
        this.mFragment = null;
        this.mImmersionOwner = null;
    }

    public void onConfigurationChanged(Configuration configuration) {
        Fragment fragment = this.mFragment;
        if (fragment == null || !fragment.getUserVisibleHint()) {
            return;
        }
        if (this.mImmersionOwner.immersionBarEnabled()) {
            this.mImmersionOwner.initImmersionBar();
        }
        this.mImmersionOwner.onVisible();
    }

    public void onHiddenChanged(boolean z) {
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            fragment.setUserVisibleHint(!z);
        }
    }

    public boolean isUserVisibleHint() {
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            return fragment.getUserVisibleHint();
        }
        return false;
    }
}
