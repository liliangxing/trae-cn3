package com.bytedance.lynx.service.image.decoder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.Postprocessor;
import com.lynx.tasm.image.model.BitmapPostProcessor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MultiPostProcessor implements Postprocessor {
    private Bitmap.Config mBitmapConfig;
    private final List<BitmapPostProcessor> mPostprocessors;

    public MultiPostProcessor(List<BitmapPostProcessor> list, Bitmap.Config config) {
        this.mBitmapConfig = config;
        this.mPostprocessors = list;
    }

    public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        CloseableReference closeableReference = null;
        try {
            CloseableReference closeableReference2 = null;
            CloseableReference closeableReference3 = null;
            for (BitmapPostProcessor bitmapPostProcessor : this.mPostprocessors) {
                try {
                    Bitmap.Config config = this.mBitmapConfig;
                    if (config == null) {
                        config = bitmap.getConfig();
                    }
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    if (config == null) {
                        config = BasePostprocessor.FALLBACK_BITMAP_CONFIGURATION;
                    }
                    closeableReference2 = platformBitmapFactory.createBitmapInternal(width, height, config);
                    if (((Bitmap) closeableReference2.get()).getConfig() == bitmap.getConfig()) {
                        Bitmaps.copyBitmap((Bitmap) closeableReference2.get(), bitmap);
                    } else {
                        new Canvas((Bitmap) closeableReference2.get()).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                    }
                    bitmapPostProcessor.process(closeableReference3 != null ? (Bitmap) closeableReference3.get() : bitmap, (Bitmap) closeableReference2.get());
                    CloseableReference.closeSafely(closeableReference3);
                    closeableReference3 = CloseableReference.cloneOrNull(closeableReference2);
                } catch (Throwable th) {
                    th = th;
                    closeableReference = closeableReference2;
                    CloseableReference.closeSafely(closeableReference);
                    throw th;
                }
            }
            CloseableReference<Bitmap> cloneOrNull = CloseableReference.cloneOrNull(closeableReference2);
            CloseableReference.closeSafely(closeableReference2);
            return cloneOrNull;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public String getName() {
        StringBuilder sb = new StringBuilder();
        for (BitmapPostProcessor bitmapPostProcessor : this.mPostprocessors) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(bitmapPostProcessor.getName());
        }
        sb.insert(0, "MultiPostProcessor (");
        sb.append(")");
        return sb.toString();
    }

    public CacheKey getPostprocessorCacheKey() {
        LinkedList linkedList = new LinkedList();
        Iterator<BitmapPostProcessor> it = this.mPostprocessors.iterator();
        while (it.hasNext()) {
            linkedList.push(new SimpleCacheKey(it.next().getPostprocessorCacheKey()));
        }
        return new MultiCacheKey(linkedList);
    }
}
