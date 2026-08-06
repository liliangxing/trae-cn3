package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.memory.PoolFactory;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HoneycombBitmapCreator implements BitmapCreator {
    private final FlexByteArrayPool mFlexByteArrayPool;
    private final EmptyJpegGenerator mJpegGenerator;

    public HoneycombBitmapCreator(PoolFactory poolFactory) {
        this.mFlexByteArrayPool = poolFactory.getFlexByteArrayPool();
        this.mJpegGenerator = new EmptyJpegGenerator(poolFactory.getPooledByteBufferFactory());
    }

    @Override // com.facebook.common.webp.BitmapCreator
    public Bitmap createNakedBitmap(int i, int i2, Bitmap.Config config) {
        EncodedImage encodedImage;
        CloseableReference<PooledByteBuffer> generate = this.mJpegGenerator.generate((short) i, (short) i2);
        CloseableReference<byte[]> closeableReference = null;
        try {
            encodedImage = new EncodedImage(generate);
            try {
                encodedImage.setImageFormat(DefaultImageFormats.JPEG);
                BitmapFactory.Options bitmapFactoryOptions = getBitmapFactoryOptions(encodedImage.getSampleSize(), config);
                int size = generate.get().size();
                PooledByteBuffer pooledByteBuffer = generate.get();
                closeableReference = this.mFlexByteArrayPool.get(size + 2);
                byte[] bArr = closeableReference.get();
                pooledByteBuffer.read(0, bArr, 0, size);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, size, bitmapFactoryOptions);
                decodeByteArray.setHasAlpha(true);
                decodeByteArray.eraseColor(0);
                CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                EncodedImage.closeSafely(encodedImage);
                CloseableReference.closeSafely(generate);
                return decodeByteArray;
            } catch (Throwable th) {
                th = th;
                CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                EncodedImage.closeSafely(encodedImage);
                CloseableReference.closeSafely(generate);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            encodedImage = null;
        }
    }

    private static BitmapFactory.Options getBitmapFactoryOptions(int i, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i;
        options.inMutable = true;
        return options;
    }
}
