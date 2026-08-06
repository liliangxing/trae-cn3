package com.facebook.animated.gif;

import com.facebook.common.internal.Preconditions;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.BaseAnimatedImage;
import com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imageutils.FrescoSoLoader;
import java.nio.ByteBuffer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class GifImage extends BaseAnimatedImage implements AnimatedImageDecoder {
    private static final int LOOP_COUNT_FOREVER = 0;
    private static final int LOOP_COUNT_MISSING = -1;
    private static final int MAX_ALLOWED_DIMENSION = 65534;
    private static volatile boolean sInitialized;
    private long mNativeContext;

    private static native GifImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer, int i, boolean z);

    private static native GifImage nativeCreateFromFileDescriptor(int i, int i2, boolean z);

    private static native GifImage nativeCreateFromNativeMemory(long j, int i, int i2, boolean z);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native GifFrame nativeGetFrame(int i);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    private native boolean nativeIsAnimated();

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public boolean doesRenderSupportScaling() {
        return false;
    }

    private static synchronized void ensure() {
        synchronized (GifImage.class) {
            if (!sInitialized) {
                sInitialized = true;
                FrescoSoLoader.loadLibrary("gifimage");
            }
        }
    }

    public static GifImage createFromByteArray(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.put(bArr);
        allocateDirect.rewind();
        return createFromByteBuffer(allocateDirect, ImageDecodeOptions.defaults());
    }

    public static GifImage createFromByteBuffer(ByteBuffer byteBuffer) {
        return createFromByteBuffer(byteBuffer, ImageDecodeOptions.defaults());
    }

    public static GifImage createFromByteBuffer(ByteBuffer byteBuffer, ImageDecodeOptions imageDecodeOptions) {
        ensure();
        byteBuffer.rewind();
        return nativeCreateFromDirectByteBuffer(byteBuffer, Integer.MAX_VALUE, false);
    }

    public static GifImage createFromNativeMemory(long j, int i, ImageDecodeOptions imageDecodeOptions) {
        ensure();
        Preconditions.checkArgument(j != 0);
        return nativeCreateFromNativeMemory(j, i, MAX_ALLOWED_DIMENSION, false);
    }

    public static GifImage createFromFileDescriptor(int i, ImageDecodeOptions imageDecodeOptions) {
        ensure();
        return nativeCreateFromFileDescriptor(i, Integer.MAX_VALUE, false);
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder
    public AnimatedImage decode(long j, int i) {
        return createFromNativeMemory(j, i, null);
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder
    public AnimatedImage decode(ByteBuffer byteBuffer) {
        return createFromByteBuffer(byteBuffer, null);
    }

    public GifImage() {
    }

    GifImage(long j) {
        this.mNativeContext = j;
    }

    protected void finalize() {
        nativeFinalize();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public void dispose() {
        nativeDispose();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getWidth() {
        return nativeGetWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getHeight() {
        return nativeGetHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getFrameCount() {
        return nativeGetFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getDuration() {
        return nativeGetDuration();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int[] getFrameDurations() {
        return nativeGetFrameDurations();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getLoopCount() {
        int nativeGetLoopCount = nativeGetLoopCount();
        if (nativeGetLoopCount == -1) {
            return 1;
        }
        if (nativeGetLoopCount != 0) {
            return nativeGetLoopCount + 1;
        }
        return 0;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public GifFrame getFrame(int i) {
        return nativeGetFrame(i);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getSizeInBytes() {
        return nativeGetSizeInBytes();
    }

    public boolean isAnimated() {
        return nativeIsAnimated();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public AnimatedDrawableFrameInfo getFrameInfo(int i) {
        GifFrame frame = getFrame(i);
        try {
            return new AnimatedDrawableFrameInfo(i, frame.getXOffset(), frame.getYOffset(), frame.getWidth(), frame.getHeight(), AnimatedDrawableFrameInfo.BlendOperation.BLEND_WITH_PREVIOUS, fromGifDisposalMethod(frame.getDisposalMode()));
        } finally {
            frame.dispose();
        }
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public ImageFormat getImageFormat() {
        return DefaultImageFormats.GIF;
    }

    private static AnimatedDrawableFrameInfo.DisposalMethod fromGifDisposalMethod(int i) {
        if (i == 0) {
            return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
        }
        if (i == 1) {
            return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
        }
        if (i == 2) {
            return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND;
        }
        if (i == 3) {
            return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS;
        }
        return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
    }
}
