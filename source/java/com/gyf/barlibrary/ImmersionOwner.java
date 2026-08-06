package com.gyf.barlibrary;

/* loaded from: classes6.dex */
public interface ImmersionOwner {
    boolean immersionBarEnabled();

    void initImmersionBar();

    void onInvisible();

    void onLazyAfterView();

    void onLazyBeforeView();

    void onVisible();
}
