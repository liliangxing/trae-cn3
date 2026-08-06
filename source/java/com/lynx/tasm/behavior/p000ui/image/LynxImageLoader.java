package com.lynx.tasm.behavior.p000ui.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.image.model.AnimationListener;
import com.lynx.tasm.image.model.ImageLoadListener;
import com.lynx.tasm.image.model.ImageRequestInfo;
import com.lynx.tasm.image.model.LynxImageFetcher;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.LynxServiceCenter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxImageLoader {
    private boolean mEnableImageFetcher;
    private LynxImageFetcher mImageFetcher;
    private ILynxImageService mLynxImageService = (ILynxImageService) LynxServiceCenter.inst().getService(ILynxImageService.class);

    public LynxImageLoader(LynxImageFetcher lynxImageFetcher) {
        this.mImageFetcher = lynxImageFetcher;
        this.mEnableImageFetcher = lynxImageFetcher != null;
    }

    public void fetchImage(ImageRequestInfo imageRequestInfo, ImageLoadListener imageLoadListener, AnimationListener animationListener, Context context) {
        TraceEvent.beginSection("LynxImageServiceProxy.fetchImage");
        if (this.mEnableImageFetcher) {
            this.mImageFetcher.loadImage(imageRequestInfo, imageLoadListener, animationListener, context);
        } else {
            this.mLynxImageService.fetchImage(imageRequestInfo, imageLoadListener, animationListener, context);
        }
        TraceEvent.endSection("LynxImageServiceProxy.fetchImage");
    }

    public boolean startAnimation(Drawable drawable) {
        if (this.mEnableImageFetcher) {
            return false;
        }
        return this.mLynxImageService.startAnimation(drawable);
    }

    public boolean resumeAnimation(Drawable drawable) {
        if (this.mEnableImageFetcher) {
            return false;
        }
        return this.mLynxImageService.resumeAnimation(drawable);
    }

    public boolean pauseAnimation(Drawable drawable) {
        if (this.mEnableImageFetcher) {
            return false;
        }
        return this.mLynxImageService.pauseAnimation(drawable);
    }

    public boolean stopAnimation(Drawable drawable) {
        if (this.mEnableImageFetcher) {
            return false;
        }
        return this.mLynxImageService.stopAnimation(drawable);
    }

    public void releaseImage(ImageRequestInfo imageRequestInfo) {
        if (!this.mEnableImageFetcher) {
            this.mLynxImageService.releaseImage(imageRequestInfo);
        } else {
            this.mImageFetcher.releaseImage(imageRequestInfo);
        }
    }

    public void releaseAnimDrawable(Drawable drawable) {
        if (this.mEnableImageFetcher) {
            return;
        }
        this.mLynxImageService.releaseAnimDrawable(drawable);
    }

    public boolean canParseUrl(String str) {
        if (this.mEnableImageFetcher) {
            return false;
        }
        return this.mLynxImageService.canParseUrl(str);
    }
}
