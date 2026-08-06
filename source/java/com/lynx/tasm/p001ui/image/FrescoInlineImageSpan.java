package com.lynx.tasm.p001ui.image;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan;
import com.lynx.tasm.p001ui.image.fresco.LynxNetworkImageRequest;
import com.lynx.tasm.p001ui.image.helper.ByteDanceFrescoUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class FrescoInlineImageSpan extends AbsInlineImageSpan {
    private final Object mCallerContext;
    private final BaseControllerListener mControllerListener;
    private Drawable mDrawable;
    private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
    private final DraweeHolder<GenericDraweeHierarchy> mDraweeHolder;
    private ScalingUtils.ScaleType mScaleType;
    private Uri mUri;

    public FrescoInlineImageSpan(Resources resources, int i, int i2, int[] iArr, Uri uri, ScalingUtils.ScaleType scaleType, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, Object obj, BaseControllerListener baseControllerListener) {
        super(i, i2, iArr);
        this.mDraweeHolder = new DraweeHolder<>(GenericDraweeHierarchyBuilder.newInstance(resources).build());
        this.mDraweeControllerBuilder = abstractDraweeControllerBuilder;
        this.mCallerContext = obj;
        this.mUri = uri == null ? Uri.EMPTY : uri;
        this.mScaleType = scaleType;
        this.mControllerListener = baseControllerListener;
    }

    @Override // com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan
    public void setCallback(Drawable.Callback callback) {
        super.setCallback(callback);
        if (callback != null && this.mDrawable == null && this.mUri != Uri.EMPTY) {
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(this.mUri);
            ByteDanceFrescoUtils.fixAnimationBug(newBuilderWithSource);
            this.mDraweeHolder.setController(this.mDraweeControllerBuilder.reset().setAutoPlayAnimations(true).setOldController(this.mDraweeHolder.getController()).setCallerContext(this.mCallerContext).setImageRequest(LynxNetworkImageRequest.fromBuilderWithHeaders(newBuilderWithSource, null)).setControllerListener(this.mControllerListener).build());
            this.mDraweeControllerBuilder.reset();
            Drawable topLevelDrawable = this.mDraweeHolder.getTopLevelDrawable();
            this.mDrawable = topLevelDrawable;
            if (topLevelDrawable != null) {
                topLevelDrawable.setBounds(0, 0, getWidth(), getHeight());
                this.mDrawable.setCallback(getCallback());
                this.mDraweeHolder.getHierarchy().setActualImageScaleType(this.mScaleType);
            }
        }
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            drawable.setCallback(callback);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan
    public void onDetachedFromWindow() {
        this.mDraweeHolder.onDetach();
    }

    @Override // com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan
    public void onStartTemporaryDetach() {
        this.mDraweeHolder.onDetach();
    }

    @Override // com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan
    public void onAttachedToWindow() {
        this.mDraweeHolder.onAttach();
    }

    @Override // com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan
    public void onFinishTemporaryDetach() {
        this.mDraweeHolder.onAttach();
    }

    @Override // com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan
    public Drawable getDrawable() {
        return this.mDrawable;
    }

    @Override // com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        if (getCallback() == null) {
            return;
        }
        super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
    }
}
