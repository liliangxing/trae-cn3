package com.lynx.tasm.p001ui.image;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import com.facebook.cache.common.CacheKey;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.p001ui.image.helper.ByteDanceFrescoUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ImageUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static CacheKey getCacheKey(ImageRequest imageRequest, Object obj) {
        CacheKeyFactory cacheKeyFactory = Fresco.getImagePipeline().getCacheKeyFactory();
        if (cacheKeyFactory == null || imageRequest == null) {
            return null;
        }
        if (imageRequest.getPostprocessor() != null) {
            return cacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, obj);
        }
        return cacheKeyFactory.getBitmapCacheKey(imageRequest, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void runOnImageAsyncThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            LynxThreadPool.getImageRequestExecutor().execute(runnable);
        }
    }

    public static ImageRequestBuilder getImageRequestBuilder(Uri uri, Bitmap.Config config, boolean z) {
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(uri);
        ByteDanceFrescoUtils.fixAnimationBug(newBuilderWithSource, config, z);
        return newBuilderWithSource;
    }
}
