package com.lynx.tasm.behavior.p000ui.utils;

import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.renderscript.Matrix4f;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BackgroundManager extends LynxBackground {
    private boolean mEnableTransformOrder;
    private PointF mPostTranslate;
    private TransformProps mTransformProps;
    private float mTranslateZ;
    private WeakReference<LynxUI> mUI;

    public BackgroundManager(LynxUI lynxUI, LynxContext lynxContext) {
        super(lynxContext);
        this.mPostTranslate = null;
        this.mEnableTransformOrder = true;
        this.mUI = new WeakReference<>(lynxUI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.lynx.tasm.behavior.p000ui.utils.LynxBackground, com.lynx.tasm.behavior.p000ui.utils.LynxDrawableManager
    public BackgroundDrawable createLayerDrawable() {
        LynxUI lynxUI = this.mUI.get();
        if (lynxUI == null) {
            return null;
        }
        BackgroundDrawable createLayerDrawable = super.createLayerDrawable();
        if (lynxUI.getView() != null) {
            Drawable background = lynxUI.getView().getBackground();
            ViewHelper.setBackground(lynxUI.getView(), null);
            if (background == null) {
                ViewHelper.setBackground(lynxUI.getView(), createLayerDrawable);
            } else {
                ViewHelper.setBackground(lynxUI.getView(), new LayerDrawable(new Drawable[]{createLayerDrawable, background}));
            }
        }
        return createLayerDrawable;
    }

    public static float convertAngle(String str) {
        if (str.endsWith("deg")) {
            return Float.valueOf(str.substring(0, str.length() - 3)).floatValue();
        }
        if (str.endsWith("rad")) {
            return (Float.valueOf(str.substring(0, str.length() - 3)).floatValue() * 180.0f) / 3.1415927f;
        }
        if (str.endsWith("turn")) {
            return Float.valueOf(str.substring(0, str.length() - 4)).floatValue() * 360.0f;
        }
        return 0.0f;
    }

    private void resetTransform() {
        LynxUI lynxUI = this.mUI.get();
        if (lynxUI == null || lynxUI.getView() == null) {
            return;
        }
        lynxUI.getView().setTranslationX(0.0f);
        lynxUI.getView().setTranslationY(0.0f);
        lynxUI.getView().setRotation(0.0f);
        lynxUI.getView().setRotationX(0.0f);
        lynxUI.getView().setRotationY(0.0f);
        lynxUI.getView().setScaleX(1.0f);
        lynxUI.getView().setScaleY(1.0f);
        this.mTransformProps = null;
        updateViewTranslation();
    }

    public void setPostTranlate(PointF pointF) {
        this.mPostTranslate = pointF;
        updateViewTranslation();
    }

    public void setTransformOrigin(TransformOrigin transformOrigin) {
        LynxUI lynxUI = this.mUI.get();
        if (lynxUI == null || lynxUI.getView() == null || transformOrigin == null) {
            return;
        }
        TransformProps processTransformOrigin = TransformProps.processTransformOrigin(transformOrigin, lynxUI.getLatestWidth(), lynxUI.getLatestHeight());
        lynxUI.getView().setPivotX(processTransformOrigin.getTransformOriginX());
        lynxUI.getView().setPivotY(processTransformOrigin.getTransformOriginY());
        lynxUI.getView().invalidate();
    }

    public void appendTransform(List<TransformRaw> list) {
        LynxUI lynxUI = this.mUI.get();
        if (lynxUI == null || list == null) {
            return;
        }
        TransformProps processTransform = TransformProps.processTransform(list, this.mContext.getUIBody().getFontSize(), this.mFontSize, this.mContext.getUIBody().getLatestWidth(), this.mContext.getUIBody().getLatestHeight(), lynxUI.getLatestWidth(), lynxUI.getLatestHeight());
        Matrix4f transformPropsToMatrix4f = this.mTransformProps.transformPropsToMatrix4f();
        transformPropsToMatrix4f.multiply(processTransform.transformPropsToMatrix4f());
        TransformProps.matrix4fToTransformProps(transformPropsToMatrix4f, this.mTransformProps);
        updateViewTranslation();
        lynxUI.getView().setOutlineProvider(null);
        ViewCompat.setTranslationZ(lynxUI.getView(), this.mTransformProps.getTranslationZ());
        lynxUI.getView().setRotation(this.mTransformProps.getRotation());
        lynxUI.getView().setRotationX(this.mTransformProps.getRotationX());
        lynxUI.getView().setRotationY(this.mTransformProps.getRotationY());
        lynxUI.getView().setScaleX(this.mTransformProps.getScaleX());
        lynxUI.getView().setScaleY(this.mTransformProps.getScaleY());
        lynxUI.setSkewX(this.mTransformProps.getSkewX());
        lynxUI.setSkewY(this.mTransformProps.getSkewY());
        lynxUI.getView().invalidate();
    }

    public void setTransform(List<TransformRaw> list) {
        LynxUI lynxUI = this.mUI.get();
        if (lynxUI == null) {
            return;
        }
        resetTransform();
        if (list == null) {
            return;
        }
        if (this.mEnableTransformOrder) {
            this.mTransformProps = TransformProps.processTransformInOrder(list, this.mContext.getUIBody().getFontSize(), this.mFontSize, this.mContext.getUIBody().getLatestWidth(), this.mContext.getUIBody().getLatestHeight(), lynxUI.getLatestWidth(), lynxUI.getLatestHeight());
        } else {
            this.mTransformProps = TransformProps.processTransform(list, this.mContext.getUIBody().getFontSize(), this.mFontSize, this.mContext.getUIBody().getLatestWidth(), this.mContext.getUIBody().getLatestHeight(), lynxUI.getLatestWidth(), lynxUI.getLatestHeight());
        }
        updateViewTranslation();
        lynxUI.getView().setOutlineProvider(null);
        ViewCompat.setTranslationZ(lynxUI.getView(), this.mTransformProps.getTranslationZ());
        lynxUI.getView().setRotation(this.mTransformProps.getRotation());
        lynxUI.getView().setRotationX(this.mTransformProps.getRotationX());
        lynxUI.getView().setRotationY(this.mTransformProps.getRotationY());
        lynxUI.getView().setScaleX(this.mTransformProps.getScaleX());
        lynxUI.getView().setScaleY(this.mTransformProps.getScaleY());
        lynxUI.setSkewX(this.mTransformProps.getSkewX());
        lynxUI.setSkewY(this.mTransformProps.getSkewY());
        lynxUI.getView().invalidate();
    }

    private void updateViewTranslation() {
        float f;
        LynxUI lynxUI = this.mUI.get();
        if (lynxUI == null) {
            return;
        }
        PointF pointF = this.mPostTranslate;
        float f2 = 0.0f;
        if (pointF != null) {
            f2 = pointF.x + 0.0f;
            f = 0.0f + this.mPostTranslate.y;
        } else {
            f = 0.0f;
        }
        TransformProps transformProps = this.mTransformProps;
        if (transformProps != null) {
            f2 += transformProps.getTranslationX();
            f += this.mTransformProps.getTranslationY();
        }
        if (lynxUI.getView() != null) {
            lynxUI.getView().setTranslationX(f2);
            lynxUI.getView().setTranslationY(f);
        }
    }

    public float getTranslateZ() {
        return this.mTranslateZ;
    }

    public TransformProps getTransformProps() {
        return this.mTransformProps;
    }

    public void setTransformOrder(boolean z) {
        this.mEnableTransformOrder = z;
    }
}
