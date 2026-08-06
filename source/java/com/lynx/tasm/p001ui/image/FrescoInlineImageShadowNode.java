package com.lynx.tasm.p001ui.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.p000ui.image.ImageUrlRedirectUtils;
import com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan;
import com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode;
import com.lynx.tasm.image.ImageErrorCodeUtils;
import com.lynx.tasm.p001ui.image.fresco.LoopCountModifyingBackend;
import com.lynx.tasm.p001ui.image.helper.ByteDanceFrescoUtils;
import com.lynx.tasm.service.LynxMemoryInfo;
import com.lynx.tasm.utils.LynxConstants;
import com.lynx.tasm.utils.UIThreadUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FrescoInlineImageShadowNode extends AbsInlineImageShadowNode {
    private static String TAG = "FrescoInlineImageShadowNode";
    private boolean mEnableVSyncAligned;
    private Uri mUri;
    private String mSource = null;
    private boolean mHasPendingSource = false;
    private boolean mSkipRedirection = false;
    private int mLoopCount = 0;
    private CloseableReference<?> mRef = null;
    private final AbstractDraweeControllerBuilder mDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
    private ScalingUtils.ScaleType mScaleType = ImageResizeMode.defaultValue();
    private final BaseControllerListener mControllerListener = new BaseControllerListener() { // from class: com.lynx.tasm.ui.image.FrescoInlineImageShadowNode.1
        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            super.onFinalImageSet(str, obj, animatable);
            if (obj instanceof CloseableStaticBitmap) {
                CloseableReference cloneUnderlyingBitmapReference = ((CloseableStaticBitmap) obj).cloneUnderlyingBitmapReference();
                if (cloneUnderlyingBitmapReference == null) {
                    FrescoInlineImageShadowNode.this.notifyErrorIfNeeded("reference null");
                    FrescoInlineImageShadowNode.this.getContext().reportResourceError(FrescoInlineImageShadowNode.this.mSource, LynxMemoryInfo.TYPE_IMAGE, new LynxError(30102, "Failed to load image，the reason is get null bitmap reference from response", "", "error"));
                    return;
                }
                Bitmap bitmap = (Bitmap) cloneUnderlyingBitmapReference.get();
                if (bitmap == null) {
                    FrescoInlineImageShadowNode.this.notifyErrorIfNeeded("bitmap null");
                    FrescoInlineImageShadowNode.this.getContext().reportResourceError(FrescoInlineImageShadowNode.this.mSource, LynxMemoryInfo.TYPE_IMAGE, new LynxError(30102, "Failed to load image，the reason is get null bitmap from response", "", "error"));
                    return;
                } else {
                    if (FrescoInlineImageShadowNode.this.mEnableVSyncAligned) {
                        FrescoInlineImageShadowNode.this.closeRef();
                        FrescoInlineImageShadowNode.this.mRef = cloneUnderlyingBitmapReference;
                        LLog.i(FrescoInlineImageShadowNode.TAG, "clone reference mRef = " + FrescoInlineImageShadowNode.this.mRef.hashCode());
                    }
                    FrescoInlineImageShadowNode.this.notifyLoadSuccessIfNeeded(bitmap.getWidth(), bitmap.getHeight());
                    return;
                }
            }
            if (animatable instanceof AnimatedDrawable2) {
                AnimatedDrawable2 animatedDrawable2 = (AnimatedDrawable2) animatable;
                int intrinsicWidth = animatedDrawable2.getIntrinsicWidth();
                int intrinsicHeight = animatedDrawable2.getIntrinsicHeight();
                animatedDrawable2.setAnimationBackend(new LoopCountModifyingBackend(animatedDrawable2.getAnimationBackend(), FrescoInlineImageShadowNode.this.mLoopCount));
                FrescoInlineImageShadowNode.this.notifyLoadSuccessIfNeeded(intrinsicWidth, intrinsicHeight);
                ByteDanceFrescoUtils.fixSlowBug(animatedDrawable2);
            }
        }

        public void onFailure(String str, Throwable th) {
            super.onFailure(str, th);
            String message = th == null ? "unknown" : th.getMessage();
            FrescoInlineImageShadowNode.this.notifyErrorIfNeeded(message);
            LynxError lynxError = new LynxError(ImageErrorCodeUtils.checkImageExceptionCategory(ImageErrorCodeUtils.checkImageException(th)), "Failed to load image", "", "error");
            lynxError.setRootCause(message);
            FrescoInlineImageShadowNode.this.getContext().reportResourceError(FrescoInlineImageShadowNode.this.mSource, LynxMemoryInfo.TYPE_IMAGE, lynxError);
        }
    };

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode, com.lynx.tasm.behavior.shadow.ShadowNode
    public void setContext(LynxContext lynxContext) {
        super.setContext(lynxContext);
        this.mEnableVSyncAligned = lynxContext.getEnableVSyncAligned();
    }

    @LynxProp(defaultBoolean = false, name = PropsConstants.SKIP_REDIRECTION)
    public void setSkipRedirection(boolean z) {
        this.mSkipRedirection = z;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public void setSource(String str) {
        this.mSource = str;
        this.mHasPendingSource = true;
        markDirty();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public void onDestroy() {
        super.onDestroy();
        if (this.mEnableVSyncAligned) {
            UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.ui.image.FrescoInlineImageShadowNode.2
                @Override // java.lang.Runnable
                public void run() {
                    FrescoInlineImageShadowNode.this.closeRef();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeRef() {
        if (this.mRef != null) {
            LLog.i(TAG, "close reference mRef = " + this.mRef.hashCode());
            this.mRef.close();
            this.mRef = null;
        }
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public void setMode(String str) {
        this.mScaleType = ImageResizeMode.toScaleType(str);
    }

    @LynxProp(name = PropsConstants.LOOP_COUNT)
    public void setLoopCount(int i) {
        if (i <= 0) {
            i = 0;
        }
        this.mLoopCount = i;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public AbsInlineImageSpan generateInlineImageSpan() {
        return new FrescoInlineImageSpan(getContext().getResources(), (int) Math.ceil(getStyle().getWidth()), (int) Math.ceil(getStyle().getHeight()), getStyle().getMargins(), this.mUri, this.mScaleType, this.mDraweeControllerBuilder, getContext().getFrescoCallerContext(), this.mControllerListener);
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public void onAfterUpdateTransaction() {
        if (this.mHasPendingSource) {
            Uri uri = null;
            if (this.mSource != null) {
                if (!this.mSkipRedirection) {
                    this.mSource = ImageUrlRedirectUtils.redirectUrl(getContext(), this.mSource);
                }
                Uri parse = Uri.parse(this.mSource);
                if (parse.getScheme() == null) {
                    LLog.e(LynxConstants.TAG, "Image src should not be relative url : " + this.mSource);
                } else {
                    uri = parse;
                }
            }
            this.mUri = uri;
            this.mHasPendingSource = false;
        }
        markDirty();
    }
}
