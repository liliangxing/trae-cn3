package com.bytedance.lynx.service.image.decoder;

import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MovieAnimatedImage implements AnimatedImage {
    private final int mDuration;
    private int[] mFrameDurations;
    private MovieFrame[] mFrames;
    private final int mLoopCount;
    private final int mSizeInBytes;

    public AnimatedImage cloneOrNull() {
        return null;
    }

    public void dispose() {
    }

    public boolean doesRenderSupportScaling() {
        return true;
    }

    public int getDecodeStatus() {
        return 0;
    }

    public MovieAnimatedImage(MovieFrame[] movieFrameArr, int i, int i2, int i3) {
        this.mFrames = movieFrameArr;
        this.mSizeInBytes = i;
        this.mDuration = i2;
        this.mLoopCount = i3;
        this.mFrameDurations = new int[movieFrameArr.length];
        int length = movieFrameArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.mFrameDurations[i4] = this.mFrames[i4].getDurationMs();
        }
    }

    public int getWidth() {
        return this.mFrames[0].getWidth();
    }

    public int getHeight() {
        return this.mFrames[0].getHeight();
    }

    public int getFrameCount() {
        return this.mFrames.length;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int[] getFrameDurations() {
        return this.mFrameDurations;
    }

    public int getLoopCount() {
        return this.mLoopCount;
    }

    public AnimatedImageFrame getFrame(int i) {
        return this.mFrames[i];
    }

    public int getSizeInBytes() {
        return this.mSizeInBytes;
    }

    public AnimatedDrawableFrameInfo getFrameInfo(int i) {
        MovieFrame movieFrame = this.mFrames[i];
        return new AnimatedDrawableFrameInfo(i, movieFrame.getXOffset(), movieFrame.getYOffset(), movieFrame.getWidth(), movieFrame.getHeight(), AnimatedDrawableFrameInfo.BlendOperation.BLEND_WITH_PREVIOUS, this.mFrames[i].getDisposalMode());
    }

    public ImageFormat getImageFormat() {
        return DefaultImageFormats.GIF;
    }
}
