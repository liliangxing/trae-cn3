package com.bytedance.bdinstall.appstate;

/* loaded from: classes3.dex */
public interface AppStateListener {

    /* loaded from: classes3.dex */
    public interface OnActivityResumeListener {
        void onResume();
    }

    boolean isActive();

    boolean isForeground();

    void setOnResumeListener(OnActivityResumeListener onActivityResumeListener);
}
