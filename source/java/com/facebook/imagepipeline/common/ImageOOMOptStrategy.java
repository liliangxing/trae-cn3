package com.facebook.imagepipeline.common;

/* loaded from: classes6.dex */
public abstract class ImageOOMOptStrategy {
    public static ImageOOMOptStrategy FRESCO_DEFAULT_STRATEGY = new ImageOOMOptStrategy() { // from class: com.facebook.imagepipeline.common.ImageOOMOptStrategy.1
        @Override // com.facebook.imagepipeline.common.ImageOOMOptStrategy
        public boolean isEnableAnimatedOOMOpt() {
            return true;
        }

        @Override // com.facebook.imagepipeline.common.ImageOOMOptStrategy
        public boolean isEnablePostProcessorOOMOpt() {
            return true;
        }

        @Override // com.facebook.imagepipeline.common.ImageOOMOptStrategy
        public void optMemoryWhenAnimatedOOM() {
        }

        @Override // com.facebook.imagepipeline.common.ImageOOMOptStrategy
        public void optMemoryWhenOOM() {
        }

        @Override // com.facebook.imagepipeline.common.ImageOOMOptStrategy
        public void optMemoryWhenPostProcessorOOM() {
        }
    };
    private static ImageOOMOptStrategy sStrategy;

    public abstract boolean isEnableAnimatedOOMOpt();

    public boolean isEnableOOMOpt() {
        return true;
    }

    public abstract boolean isEnablePostProcessorOOMOpt();

    public abstract void optMemoryWhenAnimatedOOM();

    public abstract void optMemoryWhenOOM();

    public abstract void optMemoryWhenPostProcessorOOM();

    public static ImageOOMOptStrategy getStrategy() {
        return sStrategy;
    }

    public static void setStrategy(ImageOOMOptStrategy imageOOMOptStrategy) {
        sStrategy = imageOOMOptStrategy;
    }
}
