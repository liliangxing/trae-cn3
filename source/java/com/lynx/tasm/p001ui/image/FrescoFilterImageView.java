package com.lynx.tasm.p001ui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.Postprocessor;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.utils.BorderRadius;
import com.lynx.tasm.utils.ContextUtils;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FrescoFilterImageView extends FrescoImageView {
    private int mBlurRadius;
    private int mShadowColor;
    private int mShadowOffsetX;
    private int mShadowOffsetY;
    private int mShadowRadius;

    public FrescoFilterImageView(Context context, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, GlobalImageLoadListener globalImageLoadListener, Object obj, LynxBaseUI lynxBaseUI) {
        super(context, abstractDraweeControllerBuilder, globalImageLoadListener, obj, lynxBaseUI);
    }

    public void setShadowOffsetX(int i) {
        if (this.mShadowOffsetX != i) {
            this.mShadowOffsetX = i;
            markShadowDirty();
        }
    }

    public void setShadowOffsetY(int i) {
        if (this.mShadowOffsetY != i) {
            this.mShadowOffsetY = i;
            markShadowDirty();
        }
    }

    public void setShadowColor(int i) {
        if (this.mShadowColor != i) {
            this.mShadowColor = i;
            markShadowDirty();
        }
    }

    public void setShadowRadius(int i) {
        if (this.mShadowRadius != i) {
            this.mShadowRadius = i;
            markShadowDirty();
        }
    }

    @Override // com.lynx.tasm.p001ui.image.FrescoImageView
    public void setBlurRadius(int i) {
        if (this.mBlurRadius != i) {
            this.mBlurRadius = i;
            markShadowDirty();
        }
    }

    public void markShadowDirty() {
        this.mIsDirty = true;
    }

    @Override // com.lynx.tasm.p001ui.image.FrescoImageView
    public void setBorderRadius(BorderRadius borderRadius) {
        super.setBorderRadius(borderRadius);
    }

    @Override // com.lynx.tasm.p001ui.image.FrescoImageView
    protected void onDraw(Canvas canvas) {
        if (getTopLevelDrawable() != null && isUseShadowProcessor()) {
            getTopLevelDrawable().draw(canvas);
        } else {
            super.onDraw(canvas);
        }
    }

    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        configureBounds();
        return frame;
    }

    private void configureBounds() {
        if (getTopLevelDrawable() == null || !isUseShadowProcessor()) {
            return;
        }
        getTopLevelDrawable().setBounds(new Rect(0, 0, getWidth(), getHeight()));
    }

    private boolean isUseShadowProcessor() {
        return (getWidth() == 0 || getHeight() == 0 || (this.mShadowRadius == 0 && this.mShadowColor == 0 && this.mBlurRadius == 0)) ? false : true;
    }

    @Override // com.lynx.tasm.p001ui.image.FrescoImageView
    protected void onPostprocessorPreparing(List<Postprocessor> list) {
        if (isUseShadowProcessor()) {
            list.add(new ShadowPostProcessor(getWidth(), getHeight(), getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), getFrescoScaleType(), this.mShadowOffsetX, this.mShadowOffsetY, this.mShadowColor, this.mShadowRadius, this.mBlurRadius, getContext()));
        }
    }

    @Override // com.lynx.tasm.p001ui.image.FrescoImageView
    protected void onImageRequestLoaded() {
        configureBounds();
    }

    @Override // com.lynx.tasm.p001ui.image.FrescoImageView
    public void maybeUpdateView() {
        super.maybeUpdateView();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static class ShadowPostProcessor extends BasePostprocessor {
        private final int mBlurRadius;
        private WeakReference<LynxContext> mContextRef;
        private final int mHeight;
        private final int mPaddingBottom;
        private final int mPaddingLeft;
        private final int mPaddingRight;
        private final int mPaddingTop;
        private final ScalingUtils.ScaleType mScaleType;
        private final int mShadowColor;
        private final int mShadowOffsetX;
        private final int mShadowOffsetY;
        private final int mShadowRadius;
        private final int mWidth;

        public String getName() {
            return "ShadowPostProcessor";
        }

        ShadowPostProcessor(int i, int i2, int i3, int i4, int i5, int i6, ScalingUtils.ScaleType scaleType, int i7, int i8, int i9, int i10, int i11, Context context) {
            this.mWidth = i;
            this.mHeight = i2;
            this.mPaddingLeft = i3;
            this.mPaddingTop = i4;
            this.mPaddingRight = i5;
            this.mPaddingBottom = i6;
            this.mScaleType = scaleType;
            this.mShadowOffsetX = i7;
            this.mShadowOffsetY = i8;
            this.mShadowColor = i9;
            this.mShadowRadius = i10;
            this.mBlurRadius = i11;
            this.mContextRef = new WeakReference<>(ContextUtils.toLynxContext(context));
        }

        public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
            Bitmap.Config config = bitmap.getConfig();
            int i = this.mWidth;
            int i2 = this.mHeight;
            if (config == null) {
                config = FALLBACK_BITMAP_CONFIGURATION;
            }
            CloseableReference createBitmapInternal = platformBitmapFactory.createBitmapInternal(i, i2, config);
            try {
                if (this.mWidth != 0 && this.mHeight != 0 && (this.mShadowRadius != 0 || this.mShadowColor != 0 || this.mBlurRadius != 0)) {
                    Bitmap transform = transform(bitmap, platformBitmapFactory);
                    Canvas canvas = new Canvas((Bitmap) createBitmapInternal.get());
                    if (this.mShadowColor != 0) {
                        Paint paint = new Paint();
                        paint.setFlags(3);
                        paint.setColorFilter(new PorterDuffColorFilter(this.mShadowColor, PorterDuff.Mode.SRC_IN));
                        canvas.drawBitmap(transform, this.mShadowOffsetX, this.mShadowOffsetY, paint);
                    }
                    if (this.mShadowRadius != 0) {
                        NativeBlurFilter.iterativeBoxBlur((Bitmap) createBitmapInternal.get(), 3, this.mShadowRadius);
                    }
                    canvas.drawBitmap(transform, 0.0f, 0.0f, (Paint) null);
                    if (this.mBlurRadius != 0) {
                        NativeBlurFilter.iterativeBoxBlur((Bitmap) createBitmapInternal.get(), 3, this.mBlurRadius);
                    }
                    return CloseableReference.cloneOrNull(createBitmapInternal);
                }
                process((Bitmap) createBitmapInternal.get(), bitmap);
                return CloseableReference.cloneOrNull(createBitmapInternal);
            } catch (UnsatisfiedLinkError unused) {
                UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.ui.image.FrescoFilterImageView.ShadowPostProcessor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ShadowPostProcessor.this.mContextRef == null || ShadowPostProcessor.this.mContextRef.get() == null) {
                            return;
                        }
                        ((LynxContext) ShadowPostProcessor.this.mContextRef.get()).handleLynxError(new LynxError(220301, "blur-radius/drop-shadow is not supported in this app and it will crash in lower versions", "Please remove blur-radius/drop-shadow props in image/filter-image.", "error", -3));
                    }
                });
                return CloseableReference.cloneOrNull(createBitmapInternal);
            } finally {
                CloseableReference.closeSafely(createBitmapInternal);
            }
        }

        public Bitmap transform(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
            int i;
            RectF rectF;
            RectF rectF2;
            int i2 = this.mWidth;
            if (i2 == 0 || (i = this.mHeight) == 0) {
                return bitmap;
            }
            Bitmap bitmap2 = (Bitmap) platformBitmapFactory.createBitmapInternal(i2, i, bitmap.getConfig()).get();
            Matrix matrix = new Matrix();
            Canvas canvas = new Canvas(bitmap2);
            canvas.translate(this.mPaddingLeft, this.mPaddingTop);
            canvas.clipRect(0, 0, i2 - this.mPaddingRight, i - this.mPaddingBottom);
            canvas.drawARGB(0, 0, 0, 0);
            Paint paint = new Paint(1);
            float f = (i2 - this.mPaddingLeft) - this.mPaddingRight;
            float f2 = (i - this.mPaddingTop) - this.mPaddingBottom;
            BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            float width = bitmap.getWidth();
            float height = bitmap.getHeight();
            if (this.mScaleType == ScalingUtils.ScaleType.FIT_XY) {
                matrix.setScale(f / width, f2 / height);
                matrix.postTranslate(0.0f, 0.0f);
                rectF = new RectF(0.0f, 0.0f, f + 0.0f, f2 + 0.0f);
            } else if (this.mScaleType == ScalingUtils.ScaleType.FIT_CENTER) {
                float f3 = f / width;
                float f4 = f2 / height;
                if (f3 > f4) {
                    float f5 = width * f4;
                    float f6 = ((f - f5) / 2.0f) + 0.0f;
                    rectF = new RectF(f6, 0.0f, f5 + f6, f2 + 0.0f);
                    matrix.setScale(f4, f4);
                    matrix.postTranslate(f6, 0.0f);
                } else {
                    float f7 = height * f3;
                    float f8 = ((f2 - f7) / 2.0f) + 0.0f;
                    rectF2 = new RectF(0.0f, f8, f + 0.0f, f7 + f8);
                    matrix.setScale(f3, f3);
                    matrix.postTranslate(0.0f, f8);
                    rectF = rectF2;
                }
            } else if (this.mScaleType == ScalingUtils.ScaleType.CENTER_CROP) {
                float f9 = f / width;
                float f10 = f2 / height;
                if (f9 > f10) {
                    rectF2 = new RectF(0.0f, 0.0f, f + 0.0f, f2 + 0.0f);
                    matrix.setScale(f9, f9);
                    matrix.postTranslate(0.0f, ((f2 - (height * f9)) / 2.0f) + 0.0f);
                } else {
                    float f11 = ((f - (width * f10)) / 2.0f) + 0.0f;
                    rectF2 = new RectF(0.0f, 0.0f, f + 0.0f, f2 + 0.0f);
                    matrix.setScale(f10, f10);
                    matrix.postTranslate(f11, 0.0f);
                }
                rectF = rectF2;
            } else {
                RectF rectF3 = new RectF(0.0f, 0.0f, f, f2);
                matrix.setTranslate(Math.round((f - width) * 0.5f), Math.round((f2 - height) * 0.5f));
                rectF = rectF3;
            }
            bitmapShader.setLocalMatrix(matrix);
            paint.setShader(bitmapShader);
            paint.setFilterBitmap(true);
            canvas.drawRect(rectF, paint);
            return bitmap2;
        }

        public CacheKey getPostprocessorCacheKey() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.mWidth);
            sb.append(this.mHeight);
            sb.append(this.mPaddingBottom);
            sb.append(this.mPaddingTop);
            sb.append(this.mPaddingLeft);
            sb.append(this.mPaddingRight);
            sb.append(this.mScaleType);
            sb.append(this.mShadowOffsetX);
            sb.append(this.mShadowOffsetY);
            sb.append(this.mShadowColor);
            sb.append(this.mShadowRadius);
            sb.append(this.mBlurRadius);
            return new SimpleCacheKey(sb.toString());
        }
    }
}
