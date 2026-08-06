package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CloseableAnimatedImage extends CloseableImage {
    private AnimatedImageResult mImageResult;
    private final ImageDecodeOptions mOptions;

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public boolean isStateful() {
        return true;
    }

    public CloseableAnimatedImage(AnimatedImageResult animatedImageResult, ImageDecodeOptions imageDecodeOptions) {
        this.mImageResult = animatedImageResult;
        this.mOptions = imageDecodeOptions;
    }

    public CloseableAnimatedImage(AnimatedImageResult animatedImageResult, ImageDecodeOptions imageDecodeOptions, ImageFormat imageFormat) {
        this.mImageResult = animatedImageResult;
        this.mOptions = imageDecodeOptions;
        this.mImageFormat = imageFormat;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public void setSourceUri(String str) {
        AnimatedImageResult animatedImageResult = this.mImageResult;
        if (animatedImageResult != null) {
            animatedImageResult.setSourceUri(str);
        }
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public String getSourceUri() {
        AnimatedImageResult animatedImageResult = this.mImageResult;
        if (animatedImageResult != null) {
            return animatedImageResult.getSourceUri();
        }
        return null;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getWidth() {
        return isClosed() ? 0 : this.mImageResult.getImage().getWidth();
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getHeight() {
        return isClosed() ? 0 : this.mImageResult.getImage().getHeight();
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            AnimatedImageResult animatedImageResult = this.mImageResult;
            if (animatedImageResult == null) {
                return;
            }
            this.mImageResult = null;
            animatedImageResult.dispose();
        }
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public synchronized boolean isClosed() {
        return this.mImageResult == null;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public synchronized int getSizeInBytes() {
        return isClosed() ? 0 : this.mImageResult.getImage().getSizeInBytes();
    }

    public synchronized AnimatedImageResult getImageResult() {
        return this.mImageResult;
    }

    @Nullable
    public synchronized AnimatedImage getImage() {
        return isClosed() ? null : this.mImageResult.getImage();
    }

    public ImageDecodeOptions getOptions() {
        return this.mOptions;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getImageCount() {
        return this.mImageResult.getImage().getFrameCount();
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public CloseableImage cloneOrNull() {
        AnimatedImage cloneOrNull;
        AnimatedImage image = getImage();
        if (image == null || (cloneOrNull = image.cloneOrNull()) == null) {
            return null;
        }
        return getCloseableImage(this.mOptions, cloneOrNull, getImageFormat());
    }

    private CloseableImage getCloseableImage(ImageDecodeOptions imageDecodeOptions, AnimatedImage animatedImage, ImageFormat imageFormat) {
        AnimatedImageResult imageResult = getImageResult();
        int frameForPreview = imageResult.getFrameForPreview();
        CloseableReference<Bitmap> previewBitmap = imageResult.getPreviewBitmap();
        ArrayList arrayList = new ArrayList(frameForPreview);
        for (int i = 0; i < frameForPreview; i++) {
            try {
                arrayList.add(imageResult.getDecodedFrame(i));
            } finally {
                CloseableReference.closeSafely(previewBitmap);
                CloseableReference.closeSafely(arrayList);
            }
        }
        return new CloseableAnimatedImage(AnimatedImageResult.newBuilder(animatedImage).setPreviewBitmap(previewBitmap).setFrameForPreview(frameForPreview).setDecodedFrames(arrayList).setAnimHeifIndividualCacheForCurrentRequestEnabled(imageDecodeOptions.animatedHeifIndividualCacheEnabled).build(), imageDecodeOptions, imageFormat);
    }
}
