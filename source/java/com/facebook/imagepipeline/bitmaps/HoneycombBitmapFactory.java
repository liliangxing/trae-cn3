package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.platform.PlatformDecoder;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HoneycombBitmapFactory extends PlatformBitmapFactory {
    private static final String TAG = "HoneycombBitmapFactory";
    private boolean mImmutableBitmapFallback;
    private final EmptyJpegGenerator mJpegGenerator;
    private final PlatformDecoder mPurgeableDecoder;

    public HoneycombBitmapFactory(EmptyJpegGenerator emptyJpegGenerator, PlatformDecoder platformDecoder) {
        this.mJpegGenerator = emptyJpegGenerator;
        this.mPurgeableDecoder = platformDecoder;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public CloseableReference<Bitmap> createBitmapInternal(int i, int i2, Bitmap.Config config) {
        if (this.mImmutableBitmapFallback) {
            return createFallbackBitmap(i, i2, config);
        }
        CloseableReference<PooledByteBuffer> generate = this.mJpegGenerator.generate((short) i, (short) i2);
        try {
            EncodedImage encodedImage = new EncodedImage(generate);
            encodedImage.setImageFormat(DefaultImageFormats.JPEG);
            try {
                CloseableReference<Bitmap> decodeJPEGFromEncodedImage = this.mPurgeableDecoder.decodeJPEGFromEncodedImage(encodedImage, config, null, generate.get().size());
                if (!decodeJPEGFromEncodedImage.get().isMutable()) {
                    CloseableReference.closeSafely(decodeJPEGFromEncodedImage);
                    this.mImmutableBitmapFallback = true;
                    FLog.wtf(TAG, "Immutable bitmap returned by decoder");
                    return createFallbackBitmap(i, i2, config);
                }
                decodeJPEGFromEncodedImage.get().setHasAlpha(true);
                decodeJPEGFromEncodedImage.get().eraseColor(0);
                return decodeJPEGFromEncodedImage;
            } finally {
                EncodedImage.closeSafely(encodedImage);
            }
        } finally {
            generate.close();
        }
    }

    private static CloseableReference<Bitmap> createFallbackBitmap(int i, int i2, Bitmap.Config config) {
        return CloseableReference.m497of(Bitmap.createBitmap(i, i2, config), SimpleBitmapReleaser.getInstance());
    }
}
