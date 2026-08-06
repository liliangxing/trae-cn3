package com.bytedance.lynx.service.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.lynx.tasm.behavior.ui.background.BackgroundLayerDrawable;
import com.lynx.tasm.image.model.AnimationListener;
import com.lynx.tasm.image.model.ImageLoadListener;
import com.lynx.tasm.image.model.ImageRequestInfo;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.ILynxImageServiceExtension;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LynxImageServiceProvider implements ILynxImageService, ILynxImageServiceExtension {
    public void fetchImage(ImageRequestInfo imageRequestInfo, ImageLoadListener imageLoadListener, AnimationListener animationListener, Context context) {
        LynxImageService.getInstance().fetchImage(imageRequestInfo, imageLoadListener, animationListener, context);
    }

    public boolean startAnimation(Drawable drawable) {
        return LynxImageService.getInstance().startAnimation(drawable);
    }

    public boolean resumeAnimation(Drawable drawable) {
        return LynxImageService.getInstance().resumeAnimation(drawable);
    }

    public boolean pauseAnimation(Drawable drawable) {
        return LynxImageService.getInstance().pauseAnimation(drawable);
    }

    public boolean stopAnimation(Drawable drawable) {
        return LynxImageService.getInstance().stopAnimation(drawable);
    }

    public void prefetchImage(String str, Object obj, Map<String, Object> map, ImageLoadListener imageLoadListener) {
        LynxImageService.getInstance().prefetchImage(str, obj, map, imageLoadListener);
    }

    public void prefetchImage(String str, Object obj, Map<String, Object> map) {
        LynxImageService.getInstance().prefetchImage(str, obj, map);
    }

    public void decodeImage(ImageRequestInfo imageRequestInfo, ImageLoadListener imageLoadListener) {
        LynxImageService.getInstance().decodeImage(imageRequestInfo, imageLoadListener);
    }

    public void releaseImage(ImageRequestInfo imageRequestInfo) {
        LynxImageService.getInstance().releaseImage(imageRequestInfo);
    }

    public void releaseAnimDrawable(Drawable drawable) {
        LynxImageService.getInstance().releaseAnimDrawable(drawable);
    }

    public boolean canParseUrl(String str) {
        return LynxImageService.getInstance().canParseUrl(str);
    }

    public BackgroundLayerDrawable createBackgroundImageDrawable(Context context, String str) {
        return LynxImageService.getInstance().createBackgroundImageDrawable(context, str);
    }

    public void setCustomImageDecoder(Object obj) {
        LynxImageService.getInstance().setCustomImageDecoder(obj);
    }

    public Object getImageSRPostProcessor() {
        return LynxImageService.getInstance().getImageSRPostProcessor();
    }

    public void setImageSRSize(Object obj, View view) {
        LynxImageService.getInstance().setImageSRSize(obj, view);
    }

    public void setImageCacheChoice(String str, Object obj) {
        LynxImageService.getInstance().setImageCacheChoice(str, obj);
    }

    public void setImagePlaceHolderHash(Object obj, Object obj2, Object obj3, String str, String str2, int i, int i2, int i3, int i4, boolean z) {
        LynxImageService.getInstance().setImagePlaceHolderHash(obj, obj2, obj3, str, str2, i, i2, i3, i4, z);
    }

    public void onLynxEnvSetup() {
        LynxImageService.getInstance().onLynxEnvSetup();
    }
}
