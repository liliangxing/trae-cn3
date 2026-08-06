package com.facebook.imagepipeline.animated.base;

/* loaded from: classes6.dex */
public abstract class BaseAnimatedImage implements AnimatedImage {
    protected int mDecodeStatus = 0;

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public AnimatedImage cloneOrNull() {
        return null;
    }

    public void setDecodeStatus(int i) {
        this.mDecodeStatus = i;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getDecodeStatus() {
        return this.mDecodeStatus;
    }
}
