package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.core.util.Pools;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.memory.BitmapPool;
import java.io.InputStream;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class PieDecoder extends OreoDecoder {
    private static final String TAG = "PieDecoder";

    @Nullable
    private final WebpBitmapFactory mWebpBitmapFactory;

    public PieDecoder(BitmapPool bitmapPool, int i, Pools.SynchronizedPool synchronizedPool) {
        super(bitmapPool, i, synchronizedPool);
        this.mWebpBitmapFactory = WebpSupportStatus.loadWebpBitmapFactoryIfExists();
    }

    @Override // com.facebook.imagepipeline.platform.DefaultDecoder
    protected Bitmap decodeBitmap(InputStream inputStream, BitmapFactory.Options options, int i, int i2, Bitmap bitmap) {
        Bitmap bitmap2;
        if ((Build.VERSION.SDK_INT == 28 || Build.VERSION.SDK_INT == 29) && this.mWebpBitmapFactory != null) {
            if (bitmap != null) {
                bitmap.reconfigure(i, i2, options.inPreferredConfig);
            }
            bitmap2 = this.mWebpBitmapFactory.decodeStream(inputStream, null, options);
        } else {
            bitmap2 = null;
        }
        return bitmap2 == null ? BitmapFactory.decodeStream(inputStream, null, options) : bitmap2;
    }

    @Override // com.facebook.imagepipeline.platform.OreoDecoder, com.facebook.imagepipeline.platform.DefaultDecoder
    public int getBitmapSize(int i, int i2, BitmapFactory.Options options) {
        return super.getBitmapSize(i, i2, options);
    }
}
