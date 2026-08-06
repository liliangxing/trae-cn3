package com.lynx.tasm.p001ui.image;

import android.content.Context;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.p000ui.UIBody;
import com.lynx.tasm.event.LynxDetailEvent;
import com.lynx.tasm.image.ImageErrorCodeUtils;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.UnitUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIFilterImage extends UIImage<FrescoFilterImageView> {
    private static final String TAG = "UIShadowImage";

    @Deprecated
    public UIFilterImage(Context context) {
        this((LynxContext) context);
    }

    public UIFilterImage(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    public UIFilterImage(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.p001ui.image.UIImage
    public FrescoFilterImageView createView(Context context) {
        this.mDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
        FrescoFilterImageView frescoFilterImageView = new FrescoFilterImageView(context, this.mDraweeControllerBuilder, null, getLynxContext().getFrescoCallerContext(), this);
        frescoFilterImageView.setImageLoaderCallback(new ImageLoaderCallback() { // from class: com.lynx.tasm.ui.image.UIFilterImage.1
            @Override // com.lynx.tasm.p001ui.image.ImageLoaderCallback
            public void onImageLoadSuccess(int i, int i2) {
                if (UIFilterImage.this.mEvents == null || !UIFilterImage.this.mEvents.containsKey("load")) {
                    return;
                }
                LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(UIFilterImage.this.getSign(), "load");
                lynxDetailEvent.addDetail("height", Integer.valueOf(i2));
                lynxDetailEvent.addDetail("width", Integer.valueOf(i));
                UIFilterImage.this.getLynxContext().getEventEmitter().sendCustomEvent(lynxDetailEvent);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.lynx.tasm.p001ui.image.ImageLoaderCallback
            public void onImageLoadFailed(LynxError lynxError, int i, int i2) {
                if (lynxError == null) {
                    return;
                }
                LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(UIFilterImage.this.getSign(), "error");
                lynxDetailEvent.addDetail("errMsg", lynxError.getSummaryMessage() + ": " + lynxError.getRootCause());
                lynxDetailEvent.addDetail(ImageErrorCodeUtils.LYNX_IMAGE_CATEGORIZED_CODE_KEY, Integer.valueOf(i));
                lynxDetailEvent.addDetail("error_code", Integer.valueOf(i2));
                UIFilterImage.this.getLynxContext().getEventEmitter().sendCustomEvent(lynxDetailEvent);
            }
        });
        return frescoFilterImageView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.p001ui.image.UIImage, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        ((FrescoFilterImageView) this.mView).markShadowDirty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "drop-shadow")
    public void setDropShadow(String str) {
        boolean z = false;
        if (str == null) {
            ((FrescoFilterImageView) this.mView).setShadowOffsetX(0);
            ((FrescoFilterImageView) this.mView).setShadowOffsetY(0);
            ((FrescoFilterImageView) this.mView).setShadowColor(0);
            ((FrescoFilterImageView) this.mView).setShadowRadius(0);
            return;
        }
        String[] split = str.split(" +");
        boolean z2 = true;
        try {
            if (split.length == 4) {
                UIBody uIBody = this.mContext.getUIBody();
                ((FrescoFilterImageView) this.mView).setShadowOffsetX(Math.round(UnitUtils.toPxWithDisplayMetrics(split[0], uIBody.getFontSize(), this.mFontSize, uIBody.getWidth(), uIBody.getHeight(), 0.0f, this.mContext.getScreenMetrics())));
                ((FrescoFilterImageView) this.mView).setShadowOffsetY(Math.round(UnitUtils.toPxWithDisplayMetrics(split[1], uIBody.getFontSize(), this.mFontSize, uIBody.getWidth(), uIBody.getHeight(), 0.0f, this.mContext.getScreenMetrics())));
                ((FrescoFilterImageView) this.mView).setShadowRadius(Math.round(UnitUtils.toPxWithDisplayMetrics(split[2], uIBody.getFontSize(), this.mFontSize, uIBody.getWidth(), uIBody.getHeight(), 0.0f, this.mContext.getScreenMetrics())));
                ((FrescoFilterImageView) this.mView).setShadowColor(ColorUtils.parse(split[3]));
            } else {
                z = true;
            }
            z2 = z;
        } catch (Exception unused) {
        }
        if (z2) {
            LLog.w(TAG, "Parse error for drop-shadow!");
        }
    }
}
