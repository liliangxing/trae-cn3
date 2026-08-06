package com.lynx.tasm.behavior.p000ui.list.container;

import android.content.Context;
import android.view.Choreographer;
import com.lynx.tasm.utils.DeviceUtils;
import com.lynx.tasm.utils.UnitUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class UIListAutoScroller {
    private boolean mStart = false;
    protected int mAutoRatePerFrame = 0;
    private boolean mAutoStopOnBounds = true;
    private Choreographer.FrameCallback mFrameCallback = null;

    abstract boolean canScroll(int i);

    abstract void onAutoScrollEnd();

    abstract void onAutoScrollError(String str);

    abstract void onAutoScrollStart();

    abstract void scrollBy(int i);

    public void setAutoScrollParams(boolean z, boolean z2) {
        this.mStart = z;
        this.mAutoStopOnBounds = z2;
    }

    public void execute(String str, Context context) {
        if (this.mStart) {
            int px = (int) UnitUtils.toPx(str, 0.0f);
            if (px == 0) {
                onAutoScrollError("rate is not right");
                return;
            }
            int refreshRate = (int) DeviceUtils.getRefreshRate(context);
            if (refreshRate <= 0) {
                refreshRate = 60;
            }
            this.mAutoRatePerFrame = px > 0 ? Math.max(px / refreshRate, 1) : Math.min(px / refreshRate, -1);
            removeFrameCallback();
            onAutoScrollStart();
            autoScroll();
            return;
        }
        onAutoScrollEnd();
        removeFrameCallback();
    }

    private void autoScroll() {
        this.mFrameCallback = new Choreographer.FrameCallback() { // from class: com.lynx.tasm.behavior.ui.list.container.UIListAutoScroller.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                UIListAutoScroller uIListAutoScroller = UIListAutoScroller.this;
                boolean canScroll = uIListAutoScroller.canScroll(uIListAutoScroller.mAutoRatePerFrame);
                if (canScroll) {
                    UIListAutoScroller uIListAutoScroller2 = UIListAutoScroller.this;
                    uIListAutoScroller2.scrollBy(uIListAutoScroller2.mAutoRatePerFrame);
                }
                if (!UIListAutoScroller.this.mStart || (!canScroll && UIListAutoScroller.this.mAutoStopOnBounds)) {
                    if (!UIListAutoScroller.this.mStart || !canScroll) {
                        UIListAutoScroller.this.onAutoScrollEnd();
                    }
                    UIListAutoScroller.this.removeFrameCallback();
                    return;
                }
                if (UIListAutoScroller.this.mFrameCallback != null) {
                    Choreographer.getInstance().postFrameCallback(UIListAutoScroller.this.mFrameCallback);
                }
            }
        };
        Choreographer.getInstance().postFrameCallback(this.mFrameCallback);
    }

    public void removeFrameCallback() {
        if (this.mFrameCallback != null) {
            Choreographer.getInstance().removeFrameCallback(this.mFrameCallback);
            this.mFrameCallback = null;
        }
    }
}
