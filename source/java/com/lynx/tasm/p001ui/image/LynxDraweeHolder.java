package com.lynx.tasm.p001ui.image;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.interfaces.DraweeHierarchy;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxDraweeHolder<DH extends DraweeHierarchy> {
    private DH mHierarchy;
    private volatile boolean mIsControllerAttached = false;
    private boolean mIsHolderAttached = false;
    private boolean mIsVisible = true;
    private LynxAbstractDraweeController mController = null;

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public static <DH extends DraweeHierarchy> LynxDraweeHolder<DH> create(DH dh) {
        return new LynxDraweeHolder<>(dh);
    }

    public LynxDraweeHolder(DH dh) {
        if (dh != null) {
            setHierarchy(dh);
        }
    }

    public void onAttach() {
        this.mIsHolderAttached = true;
        this.mIsControllerAttached = true;
    }

    public void onDetach() {
        this.mIsHolderAttached = false;
        detachController();
    }

    public void setController(LynxAbstractDraweeController lynxAbstractDraweeController) {
        boolean z = this.mIsControllerAttached;
        if (z) {
            detachController();
        }
        if (isControllerValid()) {
            this.mController.setHierarchy(null);
        }
        this.mController = lynxAbstractDraweeController;
        if (lynxAbstractDraweeController != null) {
            lynxAbstractDraweeController.setHierarchy(this.mHierarchy);
        }
        if (z) {
            attachController();
        }
    }

    public LynxAbstractDraweeController getController() {
        return this.mController;
    }

    public void setHierarchy(DH dh) {
        this.mHierarchy = dh;
    }

    public DH getHierarchy() {
        return (DH) Preconditions.checkNotNull(this.mHierarchy);
    }

    public boolean hasHierarchy() {
        return this.mHierarchy != null;
    }

    public Drawable getTopLevelDrawable() {
        DH dh = this.mHierarchy;
        if (dh == null) {
            return null;
        }
        return dh.getTopLevelDrawable();
    }

    public boolean isControllerValid() {
        LynxAbstractDraweeController lynxAbstractDraweeController = this.mController;
        return lynxAbstractDraweeController != null && lynxAbstractDraweeController.getHierarchy() == this.mHierarchy;
    }

    private void attachController() {
        if (this.mIsControllerAttached) {
            return;
        }
        this.mIsControllerAttached = true;
        ImageUtils.runOnImageAsyncThread(new Runnable() { // from class: com.lynx.tasm.ui.image.LynxDraweeHolder.1
            @Override // java.lang.Runnable
            public void run() {
                LynxDraweeHolder.this.doAttach();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAttach() {
        LynxAbstractDraweeController lynxAbstractDraweeController = this.mController;
        if (lynxAbstractDraweeController == null || lynxAbstractDraweeController.getHierarchy() == null) {
            return;
        }
        this.mController.onAttach();
    }

    private void detachController() {
        if (this.mIsControllerAttached) {
            this.mIsControllerAttached = false;
            ImageUtils.runOnImageAsyncThread(new Runnable() { // from class: com.lynx.tasm.ui.image.LynxDraweeHolder.2
                @Override // java.lang.Runnable
                public void run() {
                    if (LynxDraweeHolder.this.isControllerValid()) {
                        LynxDraweeHolder.this.mController.onDetach();
                    }
                }
            });
        }
    }

    public String toString() {
        return Objects.toStringHelper(this).add("controllerAttached", this.mIsControllerAttached).add("holderAttached", this.mIsHolderAttached).add("drawableVisible", this.mIsVisible).toString();
    }
}
