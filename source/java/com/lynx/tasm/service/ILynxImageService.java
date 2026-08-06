package com.lynx.tasm.service;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.lynx.tasm.image.model.AnimationListener;
import com.lynx.tasm.image.model.ImageLoadListener;
import com.lynx.tasm.image.model.ImageRequestInfo;
import java.util.Map;

/* loaded from: classes7.dex */
public interface ILynxImageService extends IServiceProvider {
    boolean canParseUrl(String str);

    void decodeImage(ImageRequestInfo imageRequestInfo, ImageLoadListener imageLoadListener);

    void fetchImage(ImageRequestInfo imageRequestInfo, ImageLoadListener imageLoadListener, AnimationListener animationListener, Context context);

    @Deprecated
    Object getImageSRPostProcessor();

    boolean pauseAnimation(Drawable drawable);

    void prefetchImage(String str, Object obj, Map<String, Object> map);

    void prefetchImage(String str, Object obj, Map<String, Object> map, ImageLoadListener imageLoadListener);

    void releaseAnimDrawable(Drawable drawable);

    void releaseImage(ImageRequestInfo imageRequestInfo);

    boolean resumeAnimation(Drawable drawable);

    @Deprecated
    void setCustomImageDecoder(Object obj);

    @Deprecated
    void setImageCacheChoice(String str, Object obj);

    @Deprecated
    void setImagePlaceHolderHash(Object obj, Object obj2, Object obj3, String str, String str2, int i, int i2, int i3, int i4, boolean z);

    @Deprecated
    void setImageSRSize(Object obj, View view);

    boolean startAnimation(Drawable drawable);

    boolean stopAnimation(Drawable drawable);

    @Override // com.lynx.tasm.service.IServiceProvider
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxImageService.class;
    }
}
