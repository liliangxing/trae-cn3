package com.facebook.imagepipeline.cache;

/* loaded from: classes6.dex */
public abstract class ImageDynamicCacheStrategy {
    public static ImageDynamicCacheStrategy FRESCO_DEFAULT_STRATEGY = new ImageDynamicCacheStrategy() { // from class: com.facebook.imagepipeline.cache.ImageDynamicCacheStrategy.1
        @Override // com.facebook.imagepipeline.cache.ImageDynamicCacheStrategy
        public int AdjustAnimBitmapMemoryCacheSize(int i) {
            return i;
        }

        @Override // com.facebook.imagepipeline.cache.ImageDynamicCacheStrategy
        public int AdjustBigBitmapMemoryCacheSize(int i) {
            return i;
        }

        @Override // com.facebook.imagepipeline.cache.ImageDynamicCacheStrategy
        public int AdjustEncodeMemoryCacheSize(int i) {
            return i;
        }

        @Override // com.facebook.imagepipeline.cache.ImageDynamicCacheStrategy
        public int AdjustNormalBitmapMemoryCacheSize(int i) {
            return i;
        }

        @Override // com.facebook.imagepipeline.cache.ImageDynamicCacheStrategy
        public int AdjustPrefetchBitmapMemoryCacheSize(int i) {
            return i;
        }
    };
    private static ImageDynamicCacheStrategy sStrategy;

    public abstract int AdjustAnimBitmapMemoryCacheSize(int i);

    public abstract int AdjustBigBitmapMemoryCacheSize(int i);

    public abstract int AdjustEncodeMemoryCacheSize(int i);

    public abstract int AdjustNormalBitmapMemoryCacheSize(int i);

    public abstract int AdjustPrefetchBitmapMemoryCacheSize(int i);

    public static ImageDynamicCacheStrategy getStrategy() {
        return sStrategy;
    }

    public static void setStrategy(ImageDynamicCacheStrategy imageDynamicCacheStrategy) {
        sStrategy = imageDynamicCacheStrategy;
    }
}
