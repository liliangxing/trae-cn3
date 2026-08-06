package com.lynx.tasm.behavior.p000ui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.background.BackgroundLayerDrawable;
import com.lynx.tasm.event.LynxDetailEvent;
import com.lynx.tasm.image.ImageErrorCodeUtils;
import com.lynx.tasm.service.LynxMemoryInfo;
import com.lynx.tasm.utils.ContextUtils;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BackgroundImageDrawable extends BackgroundLayerDrawable {
    public static final String EVENT_ERROR = "bgerror";
    public static final String EVENT_LOAD = "bgload";
    private final LynxContext mContext;
    private int mHeight;
    private final LynxImageManager mLynxImageManager;
    private WeakReference<LynxBaseUI> mUI;
    private final String mUrl;
    private int mWidth;
    private int mImgWidth = 0;
    private int mImgHeight = 0;
    private boolean mAttached = false;

    public BackgroundImageDrawable(final Context context, final String str) {
        LynxContext lynxContext = ContextUtils.toLynxContext(context);
        this.mContext = lynxContext;
        this.mUrl = str;
        LynxImageManager lynxImageManager = new LynxImageManager(lynxContext) { // from class: com.lynx.tasm.behavior.ui.image.BackgroundImageDrawable.1
            @Override // com.lynx.tasm.behavior.p000ui.image.LynxImageManager
            protected void onImageLoadSuccess(int i, int i2) {
                BackgroundImageDrawable.this.mImgWidth = i;
                BackgroundImageDrawable.this.mImgHeight = i2;
                BackgroundImageDrawable.this.mLynxImageManager.getSrcImageDrawable().setBounds(BackgroundImageDrawable.this.getBounds());
                if (!(context instanceof LynxContext) || BackgroundImageDrawable.this.mUI == null || BackgroundImageDrawable.this.mUI.get() == null) {
                    return;
                }
                LynxBaseUI lynxBaseUI = (LynxBaseUI) BackgroundImageDrawable.this.mUI.get();
                if (lynxBaseUI.getEvents() == null || !lynxBaseUI.getEvents().containsKey("bgload")) {
                    return;
                }
                LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(lynxBaseUI.getSign(), "bgload");
                lynxDetailEvent.addDetail("height", Integer.valueOf(i2));
                lynxDetailEvent.addDetail("width", Integer.valueOf(i));
                lynxDetailEvent.addDetail("url", str);
                ((LynxContext) context).getEventEmitter().sendCustomEvent(lynxDetailEvent);
            }

            @Override // com.lynx.tasm.behavior.p000ui.image.LynxImageManager
            protected void onImageLoadError(LynxError lynxError, int i, int i2) {
                if (lynxError != null) {
                    Context context2 = context;
                    if (context2 instanceof LynxContext) {
                        ((LynxContext) context2).reportResourceError(str, LynxMemoryInfo.TYPE_IMAGE, lynxError);
                        if (BackgroundImageDrawable.this.mUI == null || BackgroundImageDrawable.this.mUI.get() == null) {
                            return;
                        }
                        LynxBaseUI lynxBaseUI = (LynxBaseUI) BackgroundImageDrawable.this.mUI.get();
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
        this.mLynxImageManager = lynxImageManager;
        lynxImageManager.setDisableDefaultResize(true);
    }

    @Override // com.lynx.tasm.behavior.p000ui.background.BackgroundLayerDrawable
    public boolean isReady() {
        return this.mLynxImageManager.getSrcImageDrawable() != null;
    }

    @Override // com.lynx.tasm.behavior.p000ui.background.BackgroundLayerDrawable
    public int getImageWidth() {
        return this.mImgWidth;
    }

    @Override // com.lynx.tasm.behavior.p000ui.background.BackgroundLayerDrawable
    public int getImageHeight() {
        return this.mImgHeight;
    }

    @Override // com.lynx.tasm.behavior.p000ui.background.BackgroundLayerDrawable
    public void setBitmapConfig(Bitmap.Config config) {
        this.mLynxImageManager.setImageConfig(config);
    }

    @Override // com.lynx.tasm.behavior.p000ui.background.BackgroundLayerDrawable
    public void onAttach() {
        attachIfNeeded();
    }

    @Override // com.lynx.tasm.behavior.p000ui.background.BackgroundLayerDrawable
    public void onDetach() {
        this.mAttached = false;
        this.mLynxImageManager.destroy();
    }

    private void attachIfNeeded() {
        if (this.mAttached) {
            return;
        }
        this.mAttached = true;
        if (this.mWidth <= 0 || this.mHeight <= 0) {
            return;
        }
        this.mLynxImageManager.updateNodeProps();
    }

    @Override // com.lynx.tasm.behavior.p000ui.background.BackgroundLayerDrawable
    public void onSizeChanged(int i, int i2) {
        if (this.mWidth == i && this.mHeight == i2) {
            return;
        }
        this.mWidth = i;
        this.mHeight = i2;
        this.mLynxImageManager.onLayoutUpdated(i, i2, 0, 0, 0, 0);
        this.mLynxImageManager.updateNodeProps();
    }

    private void updateImageDrawableBounds(Rect rect) {
        if (this.mLynxImageManager.getSrcImageDrawable() != null) {
            this.mLynxImageManager.getSrcImageDrawable().setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        updateImageDrawableBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mLynxImageManager.onDraw(canvas);
    }

    @Override // com.lynx.tasm.behavior.p000ui.background.BackgroundLayerDrawable
    public void setLynxUI(LynxBaseUI lynxBaseUI) {
        super.setLynxUI(lynxBaseUI);
        this.mUI = new WeakReference<>(lynxBaseUI);
        this.mLynxImageManager.setLocalCache(lynxBaseUI.getEnableLocalCache());
        this.mLynxImageManager.setLynxBaseUI(lynxBaseUI);
        this.mLynxImageManager.setSkipRedirection(lynxBaseUI.getSkipRedirection());
        this.mLynxImageManager.setSrc(this.mUrl);
        this.mLynxImageManager.updateRedirectCheckResult();
    }
}
