package com.lynx.animax.loader;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AnimaXLoader {
    private final IAnimaXLoader mLoader;

    AnimaXLoader(IAnimaXLoader iAnimaXLoader) {
        this.mLoader = iAnimaXLoader;
    }

    public static AnimaXLoader create(IAnimaXLoader iAnimaXLoader) {
        return new AnimaXLoader(iAnimaXLoader);
    }

    public void load(AnimaXLoaderRequest animaXLoaderRequest, AnimaXLoaderCompletionHandler animaXLoaderCompletionHandler) {
        this.mLoader.load(animaXLoaderRequest, animaXLoaderCompletionHandler);
    }
}
