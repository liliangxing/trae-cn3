package com.lynx.tasm.image.model;

import android.content.Context;

/* loaded from: classes7.dex */
public interface LynxImageFetcher {
    void loadImage(ImageRequestInfo imageRequestInfo, ImageLoadListener imageLoadListener, AnimationListener animationListener, Context context);

    void releaseImage(ImageRequestInfo imageRequestInfo);
}
