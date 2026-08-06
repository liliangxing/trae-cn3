package com.bytedance.ies.uikit.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.FrameLayout;

/* loaded from: classes4.dex */
public class FullscreenVideoFrame extends FrameLayout {
    private Listener mListener;

    /* loaded from: classes4.dex */
    public interface Listener {
        void onHideFullscreenVideoFrame();
    }

    public FullscreenVideoFrame(Context context) {
        super(context);
        init();
    }

    public FullscreenVideoFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public FullscreenVideoFrame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Listener listener = this.mListener;
            if (listener == null) {
                return true;
            }
            listener.onHideFullscreenVideoFrame();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }
}
