package com.lynx.animax.p034ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AnimaXContainerView extends FrameLayout {
    private AnimaXImageView mAnimaXImageView;
    private AnimaXView mAnimaXView;
    private IDispatchDrawHook mDispatchDrawHook;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface IDispatchDrawHook {
        void beforeDispatchDraw(Canvas canvas);

        boolean useBitmapOnDraw();
    }

    public AnimaXContainerView(Context context) {
        super(context);
    }

    public void addChildAnimaXView(View view, IDispatchDrawHook iDispatchDrawHook) {
        if (view instanceof AnimaXView) {
            this.mAnimaXView = (AnimaXView) view;
        } else if (!(view instanceof AnimaXImageView)) {
            return;
        } else {
            this.mAnimaXImageView = (AnimaXImageView) view;
        }
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(view);
        this.mDispatchDrawHook = iDispatchDrawHook;
    }

    public AnimaXView getAnimaXView() {
        return this.mAnimaXView;
    }

    public AnimaXImageView getAnimaXImageView() {
        return this.mAnimaXImageView;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Bitmap currentBitmap;
        IDispatchDrawHook iDispatchDrawHook;
        IDispatchDrawHook iDispatchDrawHook2 = this.mDispatchDrawHook;
        if (iDispatchDrawHook2 != null) {
            iDispatchDrawHook2.beforeDispatchDraw(canvas);
        }
        super.dispatchDraw(canvas);
        if ((canvas.isHardwareAccelerated() || (iDispatchDrawHook = this.mDispatchDrawHook) == null || !iDispatchDrawHook.useBitmapOnDraw()) ? false : true) {
            AnimaXView animaXView = this.mAnimaXView;
            if (animaXView != null) {
                currentBitmap = animaXView.getBitmap();
            } else {
                AnimaXImageView animaXImageView = this.mAnimaXImageView;
                currentBitmap = animaXImageView != null ? animaXImageView.getCurrentBitmap() : null;
            }
            if (currentBitmap != null) {
                canvas.drawBitmap(currentBitmap, getPaddingLeft(), getPaddingTop(), (Paint) null);
            }
        }
    }
}
