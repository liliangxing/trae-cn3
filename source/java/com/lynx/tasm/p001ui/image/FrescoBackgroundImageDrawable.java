package com.lynx.tasm.p001ui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.background.BackgroundLayerDrawable;
import com.lynx.tasm.event.LynxDetailEvent;
import com.lynx.tasm.image.ImageErrorCodeUtils;
import com.lynx.tasm.image.ImageUtils;
import com.lynx.tasm.p001ui.image.LynxImageManager;
import com.lynx.tasm.service.LynxMemoryInfo;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FrescoBackgroundImageDrawable extends BackgroundLayerDrawable implements LynxImageManager.DrawableReadyListener, Drawable.Callback {
    public static final String EVENT_ERROR = "bgerror";
    public static final String EVENT_LOAD = "bgload";
    private final Context mContext;
    private int mHeight;
    private LynxImageManager mLynxImageManager;
    private WeakReference<LynxBaseUI> mUI;
    private String mUrl;
    private int mWidth;
    private Drawable mImageDrawable = null;
    private boolean mAttached = false;
    private int imgWidth = 0;
    private int imgHeight = 0;
    private boolean mLoadedFromLocal = false;

    @Override // com.lynx.tasm.ui.image.LynxImageManager.DrawableReadyListener
    public void onImageLoaded() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FrescoBackgroundImageDrawable(final Context context, final String str) {
        this.mContext = context;
        this.mUrl = str;
        LynxImageManager lynxImageManager = new LynxImageManager(context, Fresco.newDraweeControllerBuilder(), null, context instanceof LynxContext ? ((LynxContext) context).getFrescoCallerContext() : null, this, true);
        this.mLynxImageManager = lynxImageManager;
        lynxImageManager.setResizeMethod(ImageResizeMethod.AUTO);
        this.mLynxImageManager.setImageRedirectListener(new ImageAsyncRedirectListener() { // from class: com.lynx.tasm.ui.image.FrescoBackgroundImageDrawable.1
            @Override // com.lynx.tasm.p001ui.image.ImageAsyncRedirectListener
            public void onAsyncRedirectFinish() {
                if (FrescoBackgroundImageDrawable.this.mLynxImageManager == null || FrescoBackgroundImageDrawable.this.mWidth <= 0 || FrescoBackgroundImageDrawable.this.mHeight <= 0) {
                    return;
                }
                FrescoBackgroundImageDrawable.this.mLynxImageManager.maybeUpdateView(FrescoBackgroundImageDrawable.this.mWidth, FrescoBackgroundImageDrawable.this.mHeight, 0, 0, 0, 0);
            }
        });
        this.mLynxImageManager.mLoaderCallback = new ImageLoaderCallback() { // from class: com.lynx.tasm.ui.image.FrescoBackgroundImageDrawable.2
            @Override // com.lynx.tasm.p001ui.image.ImageLoaderCallback
            public void onImageLoadSuccess(int i, int i2) {
                FrescoBackgroundImageDrawable.this.imgWidth = i;
                FrescoBackgroundImageDrawable.this.imgHeight = i2;
                if (!(context instanceof LynxContext) || FrescoBackgroundImageDrawable.this.mUI == null || FrescoBackgroundImageDrawable.this.mUI.get() == null) {
                    return;
                }
                LynxBaseUI lynxBaseUI = (LynxBaseUI) FrescoBackgroundImageDrawable.this.mUI.get();
                if (lynxBaseUI.getEvents() == null || !lynxBaseUI.getEvents().containsKey("bgload")) {
                    return;
                }
                LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(lynxBaseUI.getSign(), "bgload");
                lynxDetailEvent.addDetail("height", Integer.valueOf(i2));
                lynxDetailEvent.addDetail("width", Integer.valueOf(i));
                lynxDetailEvent.addDetail("url", str);
                ((LynxContext) context).getEventEmitter().sendCustomEvent(lynxDetailEvent);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.lynx.tasm.p001ui.image.ImageLoaderCallback
            public void onImageLoadFailed(LynxError lynxError, int i, int i2) {
                if (lynxError != null) {
                    Context context2 = context;
                    if (context2 instanceof LynxContext) {
                        ((LynxContext) context2).reportResourceError(str, LynxMemoryInfo.TYPE_IMAGE, lynxError);
                        if (FrescoBackgroundImageDrawable.this.mUI == null || FrescoBackgroundImageDrawable.this.mUI.get() == null) {
                            return;
                        }
                        LynxBaseUI lynxBaseUI = (LynxBaseUI) FrescoBackgroundImageDrawable.this.mUI.get();
                        if (lynxBaseUI.getEvents() == null || !lynxBaseUI.getEvents().containsKey("bgerror")) {
                            return;
                        }
                        LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(lynxBaseUI.getSign(), "bgerror");
                        lynxDetailEvent.addDetail("errMsg", lynxError.getSummaryMessage() + ": " + lynxError.getRootCause());
                        lynxDetailEvent.addDetail("url", str);
                        lynxDetailEvent.addDetail(ImageErrorCodeUtils.LYNX_IMAGE_CATEGORIZED_CODE_KEY, Integer.valueOf(i));
                        lynxDetailEvent.addDetail("error_code", Integer.valueOf(i2));
                        ((LynxContext) context).getEventEmitter().sendCustomEvent(lynxDetailEvent);
                    }
                }
            }
        };
    }

    @Override // com.lynx.tasm.behavior.p000ui.background.BackgroundLayerDrawable
    public boolean isReady() {
        return this.mImageDrawable != null;
    }

    @Override // com.lynx.tasm.behavior.p000ui.background.BackgroundLayerDrawable
    public int getImageWidth() {
        return this.imgWidth;
    }

    @Override // com.lynx.tasm.behavior.p000ui.background.BackgroundLayerDrawable
    public int getImageHeight() {
        return this.imgHeight;
    }

    private void attachIfNeeded() {
        if (this.mAttached) {
            return;
        }
        this.mLynxImageManager.onAttach();
        this.mAttached = true;
        this.mLynxImageManager.setDirty(true);
    }

    @Override // com.lynx.tasm.behavior.p000ui.background.BackgroundLayerDrawable
    public void setBitmapConfig(Bitmap.Config config) {
        this.mLynxImageManager.setBitmapConfig(config);
    }

    @Override // com.lynx.tasm.behavior.p000ui.background.BackgroundLayerDrawable
    public void onAttach() {
        int i;
        attachIfNeeded();
        int i2 = this.mWidth;
        if (i2 <= 0 || (i = this.mHeight) <= 0) {
            return;
        }
        this.mLynxImageManager.maybeUpdateView(i2, i, 0, 0, 0, 0);
    }

    @Override // com.lynx.tasm.behavior.p000ui.background.BackgroundLayerDrawable
    public void onDetach() {
        this.mLynxImageManager.onDetach();
        this.mAttached = false;
    }

    @Override // com.lynx.tasm.behavior.p000ui.background.BackgroundLayerDrawable
    public void onSizeChanged(int i, int i2) {
        attachIfNeeded();
        this.mWidth = i;
        this.mHeight = i2;
        this.mLynxImageManager.maybeUpdateView(i, i2, 0, 0, 0, 0);
    }

    @Override // com.lynx.tasm.ui.image.LynxImageManager.DrawableReadyListener
    public void onDrawableReady(Drawable drawable) {
        if (this.mLoadedFromLocal) {
            return;
        }
        this.mImageDrawable = drawable;
        drawable.setBounds(getBounds());
        this.mImageDrawable.setCallback(this);
        updateImageRendering();
        invalidateSelf();
    }

    private void updateImageRendering() {
        LynxBaseUI lynxBaseUI;
        WeakReference<LynxBaseUI> weakReference = this.mUI;
        if (weakReference == null || (lynxBaseUI = weakReference.get()) == null) {
            return;
        }
        int imageRendering = lynxBaseUI.getImageRendering();
        if (imageRendering == 2) {
            this.mImageDrawable.setFilterBitmap(false);
        } else if (imageRendering == 1 || imageRendering == 0) {
            this.mImageDrawable.setFilterBitmap(true);
        }
    }

    @Override // com.lynx.tasm.ui.image.LynxImageManager.DrawableReadyListener
    public void onCloseableRefReady(CloseableReference<?> closeableReference) {
        Bitmap bitmap;
        if (closeableReference == null || !closeableReference.isValid()) {
            return;
        }
        Object obj = closeableReference.get();
        if (obj instanceof CloseableBitmap) {
            bitmap = ((CloseableBitmap) obj).getUnderlyingBitmap();
        } else {
            bitmap = obj instanceof Bitmap ? (Bitmap) obj : null;
        }
        if (bitmap != null) {
            this.mLoadedFromLocal = true;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.mContext.getResources(), bitmap.copy(bitmap.getConfig(), true));
            this.mImageDrawable = bitmapDrawable;
            bitmapDrawable.setBounds(getBounds());
            this.mImageDrawable.setCallback(this);
            this.imgWidth = bitmap.getWidth();
            this.imgHeight = bitmap.getHeight();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.ui.image.FrescoBackgroundImageDrawable.3
            @Override // java.lang.Runnable
            public void run() {
                FrescoBackgroundImageDrawable.this.invalidateSelf();
            }
        });
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        UIThreadUtils.runOnUiThreadAtTime(runnable, drawable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        UIThreadUtils.removeCallbacks(runnable, drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mImageDrawable != null) {
            if (this.mLynxImageManager.isEnableAsyncRequest() && this.mLynxImageManager.isAsyncBitmapInValid()) {
                return;
            }
            this.mImageDrawable.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Drawable drawable = this.mImageDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.background.BackgroundLayerDrawable
    public void setLynxUI(LynxBaseUI lynxBaseUI) {
        this.mUI = new WeakReference<>(lynxBaseUI);
        ImageUtils.LocalCacheState parseLocalCache = ImageUtils.parseLocalCache(lynxBaseUI.getEnableLocalCache());
        if (lynxBaseUI.getSkipRedirection()) {
            this.mLynxImageManager.setSrcSkippingRedirection(this.mUrl);
        } else {
            this.mLynxImageManager.updateRedirectCheckResult(this.mUrl, null, true, false);
            this.mLynxImageManager.setSrc(this.mUrl);
        }
        this.mLynxImageManager.setUseLocalCache(parseLocalCache.mUseLocalCache);
        this.mLynxImageManager.setAwaitLocalCache(parseLocalCache.mAwaitLocalCache);
    }
}
