package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class ImmersionFragment extends Fragment implements ImmersionOwner {
    private ImmersionProxy mImmersionProxy = new ImmersionProxy(this);

    @Override // com.gyf.barlibrary.ImmersionOwner
    public boolean immersionBarEnabled() {
        return true;
    }

    @Override // com.gyf.barlibrary.ImmersionOwner
    public void onInvisible() {
    }

    @Override // com.gyf.barlibrary.ImmersionOwner
    public void onLazyAfterView() {
    }

    @Override // com.gyf.barlibrary.ImmersionOwner
    public void onLazyBeforeView() {
    }

    @Override // com.gyf.barlibrary.ImmersionOwner
    public void onVisible() {
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mImmersionProxy.setUserVisibleHint(z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mImmersionProxy.onCreate(bundle);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mImmersionProxy.onActivityCreated(bundle);
    }

    public void onResume() {
        super.onResume();
        this.mImmersionProxy.onResume();
    }

    public void onPause() {
        super.onPause();
        this.mImmersionProxy.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mImmersionProxy.onDestroy();
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        this.mImmersionProxy.onHiddenChanged(z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mImmersionProxy.onConfigurationChanged(configuration);
    }
}
