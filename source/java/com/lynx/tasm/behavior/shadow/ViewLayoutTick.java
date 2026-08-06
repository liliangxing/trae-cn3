package com.lynx.tasm.behavior.shadow;

import android.view.View;
import com.lynx.tasm.utils.UIThreadUtils;

/* loaded from: classes7.dex */
public class ViewLayoutTick implements LayoutTick {
    private Runnable mRunnable;
    private View mView;

    public ViewLayoutTick(View view) {
        this.mView = view;
    }

    @Override // com.lynx.tasm.behavior.shadow.LayoutTick
    public void request(final Runnable runnable) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.shadow.ViewLayoutTick.1
            @Override // java.lang.Runnable
            public void run() {
                if (ViewLayoutTick.this.mView != null) {
                    ViewLayoutTick.this.mView.requestLayout();
                }
                ViewLayoutTick.this.mRunnable = runnable;
            }
        });
    }

    public void attach(View view) {
        this.mView = view;
    }

    public void triggerLayout() {
        Runnable runnable = this.mRunnable;
        if (runnable != null) {
            runnable.run();
        }
        this.mRunnable = null;
    }
}
