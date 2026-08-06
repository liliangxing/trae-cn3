package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.util.Pools;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.decoder.DefaultImageDecoder;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class DefaultDecoder implements PlatformDecoder {
    private static final int DECODE_BUFFER_SIZE = 16384;
    private static boolean optPngDecode;
    private final BitmapPool mBitmapPool;
    final Pools.SynchronizedPool<ByteBuffer> mDecodeBuffers;

    @Nullable
    private final PreverificationHelper mPreverificationHelper;
    private static final Class<?> TAG = DefaultDecoder.class;
    private static final byte[] EOI_TAIL = {-1, -39};

    public abstract int getBitmapSize(int i, int i2, BitmapFactory.Options options);

    public static void setOptPngDecode(boolean z) {
        optPngDecode = z;
    }

    public DefaultDecoder(BitmapPool bitmapPool, int i, Pools.SynchronizedPool synchronizedPool) {
        this.mPreverificationHelper = Build.VERSION.SDK_INT >= 26 ? new PreverificationHelper() : null;
        this.mBitmapPool = bitmapPool;
        this.mDecodeBuffers = synchronizedPool;
        for (int i2 = 0; i2 < i; i2++) {
            this.mDecodeBuffers.release(ByteBuffer.allocate(16384));
        }
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect) {
        return decodeFromEncodedImageWithColorSpace(encodedImage, config, rect, false);
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i) {
        return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, config, rect, i, false);
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, boolean z) {
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
        boolean z2 = decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            if (optPngDecode && "PNG".equalsIgnoreCase(encodedImage.getImageFormat().toString()) && (encodedImage.hasAlpha() || encodedImage.is10Bit())) {
                decodeOptionsForStream.inPreferredConfig = Bitmap.Config.ARGB_8888;
            }
            return decodeFromStream(encodedImage.getInputStream(), decodeOptionsForStream, rect, z);
        } catch (RuntimeException e) {
            if (z2) {
                return decodeFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, z);
            }
            throw e;
        }
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i, boolean z) {
        boolean isCompleteAt = encodedImage.isCompleteAt(i);
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
        InputStream inputStream = encodedImage.getInputStream();
        Preconditions.checkNotNull(inputStream);
        if (encodedImage.getSize() > i) {
            inputStream = new LimitedInputStream(inputStream, i);
        }
        if (!isCompleteAt) {
            inputStream = new TailAppendingInputStream(inputStream, EOI_TAIL);
        }
        boolean z2 = decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return decodeFromStream(inputStream, decodeOptionsForStream, rect, z);
        } catch (RuntimeException e) {
            if (z2) {
                return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, i, z);
            }
            throw e;
        }
    }

    protected CloseableReference<Bitmap> decodeStaticImageFromStream(InputStream inputStream, BitmapFactory.Options options, @Nullable Rect rect) {
        return decodeFromStream(inputStream, options, rect, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v4, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private CloseableReference<Bitmap> decodeFromStream(InputStream inputStream, BitmapFactory.Options options, @Nullable Rect rect, boolean z) {
        Bitmap bitmap;
        BitmapRegionDecoder bitmapRegionDecoder;
        Bitmap decodeRegion;
        PreverificationHelper preverificationHelper;
        Preconditions.checkNotNull(inputStream);
        int i = options.outWidth;
        int i2 = options.outHeight;
        if (rect != null) {
            i = rect.width() / options.inSampleSize;
            i2 = rect.height() / options.inSampleSize;
        }
        int i3 = i;
        int i4 = i2;
        boolean z2 = Build.VERSION.SDK_INT >= 26 && (preverificationHelper = this.mPreverificationHelper) != null && preverificationHelper.shouldUseHardwareBitmapConfig(options.inPreferredConfig);
        if (rect == null && z2) {
            options.inMutable = false;
            bitmap = null;
        } else {
            if (rect != null && z2) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            }
            bitmap = this.mBitmapPool.get(getBitmapSize(i3, i4, options));
            if (bitmap == null) {
                throw new NullPointerException("BitmapPool.get returned null");
            }
        }
        options.inBitmap = bitmap;
        if (Build.VERSION.SDK_INT >= 26 && z) {
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        ByteBuffer byteBuffer = (ByteBuffer) this.mDecodeBuffers.acquire();
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(16384);
        }
        try {
            try {
                BitmapRegionDecoder array = byteBuffer.array();
                options.inTempStorage = array;
                if (rect != null) {
                    try {
                        if (bitmap != null) {
                            try {
                                bitmap.reconfigure(i3, i4, options.inPreferredConfig);
                                bitmapRegionDecoder = BitmapRegionDecoder.newInstance(inputStream, true);
                                try {
                                    decodeRegion = bitmapRegionDecoder.decodeRegion(rect, options);
                                    if (bitmapRegionDecoder != null) {
                                        bitmapRegionDecoder.recycle();
                                    }
                                } catch (IOException unused) {
                                    FLog.m440e(TAG, "Could not decode region %s, decoding full bitmap instead.", rect);
                                    if (bitmapRegionDecoder != null) {
                                        bitmapRegionDecoder.recycle();
                                    }
                                    decodeRegion = null;
                                    if (decodeRegion == null) {
                                    }
                                    this.mDecodeBuffers.release(byteBuffer);
                                    if (bitmap == null) {
                                    }
                                    return CloseableReference.m497of(decodeRegion, this.mBitmapPool);
                                }
                            } catch (IOException unused2) {
                                bitmapRegionDecoder = null;
                            } catch (Throwable th) {
                                th = th;
                                array = 0;
                                if (array != 0) {
                                    array.recycle();
                                }
                                throw th;
                            }
                            if (decodeRegion == null) {
                                try {
                                    inputStream.reset();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                decodeRegion = decodeBitmap(inputStream, options, i3, i4, bitmap);
                            }
                            this.mDecodeBuffers.release(byteBuffer);
                            if (bitmap == null && bitmap != decodeRegion) {
                                this.mBitmapPool.release(bitmap);
                                decodeRegion.recycle();
                                throw new IllegalStateException();
                            }
                            return CloseableReference.m497of(decodeRegion, this.mBitmapPool);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                decodeRegion = null;
                if (decodeRegion == null) {
                }
                this.mDecodeBuffers.release(byteBuffer);
                if (bitmap == null) {
                }
                return CloseableReference.m497of(decodeRegion, this.mBitmapPool);
            } catch (Throwable th3) {
                this.mDecodeBuffers.release(byteBuffer);
                throw th3;
            }
        } catch (IllegalArgumentException e2) {
            if (bitmap != null) {
                this.mBitmapPool.release(bitmap);
            }
            try {
                inputStream.reset();
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inMutable = true;
                options2.inSampleSize = options.inSampleSize;
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options2);
                if (decodeStream == null) {
                    throw e2;
                }
                CloseableReference<Bitmap> m497of = CloseableReference.m497of(decodeStream, SimpleBitmapReleaser.getInstance());
                this.mDecodeBuffers.release(byteBuffer);
                return m497of;
            } catch (IOException unused3) {
                throw e2;
            }
        } catch (OutOfMemoryError e3) {
            this.mBitmapPool.release(bitmap);
            throw e3;
        } catch (RuntimeException e4) {
            if (bitmap != null) {
                this.mBitmapPool.release(bitmap);
            }
            throw e4;
        }
    }

    protected Bitmap decodeBitmap(InputStream inputStream, BitmapFactory.Options options, int i, int i2, Bitmap bitmap) {
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    private static BitmapFactory.Options getDecodeOptionsForStream(EncodedImage encodedImage, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = encodedImage.getSampleSize();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(encodedImage.getInputStream(), null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            throw new IllegalArgumentException(DefaultImageDecoder.parseEncodedImageInfo(encodedImage));
        }
        options.inJustDecodeBounds = false;
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inMutable = true;
        return options;
    }
}
