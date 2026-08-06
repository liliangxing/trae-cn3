package com.lynx.animax.p034ui;

import android.view.MotionEvent;
import com.lynx.animax.base.IAnimaXCompositionReadyListener;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface IAnimaXView extends IAnimaXCompositionReadyListener {
    IAnimaXPlayer getPlayer();

    void release();

    void requestLayout();

    void setEnableTapLayerEvent(boolean z);

    void setIgnoreAttachStatus(boolean z);

    default void handleTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getAction() != 0) {
            return;
        }
        getPlayer().onTap(motionEvent.getX(), motionEvent.getY());
    }
}
