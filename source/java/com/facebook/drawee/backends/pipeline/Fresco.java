package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.IAbstractDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweePlaceHolderConfig;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.core.IImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imageutils.FrescoSoLoader;
import com.fackbook.drawee.DefaultDraweeConfig;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class Fresco {
    private static final Class<?> TAG = Fresco.class;
    private static boolean sCanReInitialize = true;
    private static PipelineDraweeControllerBuilderSupplier sDraweeControllerBuilderSupplier;
    private static IAbstractDraweeControllerBuilder sIDraweeControllerBuilderSupplier;
    private static volatile boolean sIsInitialized;
    private static volatile boolean sIsLazyInit;

    private Fresco() {
    }

    public static void setIsLazyInit(boolean z) {
        sIsLazyInit = z;
    }

    public static boolean isLazyInit() {
        return sIsLazyInit;
    }

    public static void setCanReInitialize(boolean z) {
        sCanReInitialize = z;
    }

    public static void initialize(Context context) {
        initialize(context, null, null);
    }

    public static void initialize(Context context, @Nullable ImagePipelineConfig imagePipelineConfig) {
        initialize(context, imagePipelineConfig, null);
    }

    public static void initialize(Context context, @Nullable IImagePipelineConfig iImagePipelineConfig) {
        initialize(context, iImagePipelineConfig, null, null);
    }

    public static void initialize(Context context, @Nullable IImagePipelineConfig iImagePipelineConfig, @Nullable DraweeConfig draweeConfig, @Nullable Boolean bool) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("Fresco#initialize");
        }
        if (sIsLazyInit) {
            FLog.m422d(TAG, "I will not continue initialization，Because lazy loading is set up");
            return;
        }
        if (sIsInitialized) {
            FLog.m478w(TAG, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            sIsInitialized = true;
        }
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("Fresco.initialize->SoLoader.init");
            }
            FrescoSoLoader.initSoLoader(context);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        } catch (Exception e) {
            FLog.m481w(TAG, e, "Could not initialize SoLoader", new Object[0]);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        Context applicationContext = context.getApplicationContext();
        if (iImagePipelineConfig == null) {
            ImagePipelineFactory.initialize(applicationContext);
        } else {
            ImagePipelineFactory.initialize(iImagePipelineConfig, bool);
            getImagePipelineFactory().setSplitMemCache(FrescoCacheMonitorUtil.isSplitMemCache());
            getImagePipelineFactory().setEnableSingleCache(FrescoCacheMonitorUtil.isEnableSingleCache());
            getImagePipelineFactory().setEnableBigImgCache(FrescoCacheMonitorUtil.isEnableBigImgCache());
            getImagePipelineFactory().setBigImgSizeLimit(FrescoCacheMonitorUtil.getBigImgSizeLimit());
            getImagePipelineFactory().setSplitPrefetchCache(FrescoCacheMonitorUtil.isSplitPrefetchCache());
            getImagePipelineFactory().setNewLocalVideoThumbnailOptEnabled(FrescoCacheMonitorUtil.isNewLocalVideoThumbnailOptEnabled());
        }
        initializeDrawee(applicationContext, draweeConfig);
        if (Boolean.TRUE.equals(bool)) {
            tryInitDraweeControllerBuilderSupplier();
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public static void initialize(Context context, @Nullable ImagePipelineConfig imagePipelineConfig, @Nullable DraweeConfig draweeConfig) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("Fresco#initialize");
        }
        if (sIsLazyInit) {
            FLog.m422d(TAG, "I will not continue initialization，Because lazy loading is set up");
            return;
        }
        if (sIsInitialized) {
            FLog.m438e(TAG, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
            if (!sCanReInitialize) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                    return;
                }
                return;
            }
        } else {
            sIsInitialized = true;
        }
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("Fresco.initialize->SoLoader.init");
            }
            FrescoSoLoader.initSoLoader(context);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        } catch (Exception e) {
            FLog.m481w(TAG, e, "Could not initialize SoLoader", new Object[0]);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        Context applicationContext = context.getApplicationContext();
        if (imagePipelineConfig == null) {
            ImagePipelineFactory.initialize(applicationContext);
        } else {
            ImagePipelineFactory.initialize(imagePipelineConfig);
            getImagePipelineFactory().setSplitMemCache(FrescoCacheMonitorUtil.isSplitMemCache());
            getImagePipelineFactory().setEnableSingleCache(FrescoCacheMonitorUtil.isEnableSingleCache());
            getImagePipelineFactory().setEnableBigImgCache(FrescoCacheMonitorUtil.isEnableBigImgCache());
            getImagePipelineFactory().setBigImgSizeLimit(FrescoCacheMonitorUtil.getBigImgSizeLimit());
            getImagePipelineFactory().setSplitPrefetchCache(FrescoCacheMonitorUtil.isSplitPrefetchCache());
            getImagePipelineFactory().setNewLocalVideoThumbnailOptEnabled(FrescoCacheMonitorUtil.isNewLocalVideoThumbnailOptEnabled());
        }
        initializeDrawee(applicationContext, draweeConfig);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    private static void initializeDrawee(final Context context, @Nullable final DraweeConfig draweeConfig) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("Fresco.initializeDrawee");
        }
        IAbstractDraweeControllerBuilder iAbstractDraweeControllerBuilder = new IAbstractDraweeControllerBuilder() { // from class: com.facebook.drawee.backends.pipeline.Fresco.1
            private volatile PipelineDraweeControllerBuilderSupplier mPipelineDraweeControllerBuilderSupplier = null;

            @Override // com.facebook.drawee.controller.IAbstractDraweeControllerBuilder
            public Supplier<? extends AbstractDraweeControllerBuilder> getAbstractDraweeControllerBuilder() {
                if (this.mPipelineDraweeControllerBuilderSupplier == null) {
                    synchronized (this) {
                        if (this.mPipelineDraweeControllerBuilderSupplier == null) {
                            this.mPipelineDraweeControllerBuilderSupplier = new PipelineDraweeControllerBuilderSupplier(context, draweeConfig);
                        }
                    }
                }
                return this.mPipelineDraweeControllerBuilderSupplier;
            }

            @Override // com.facebook.drawee.controller.IAbstractDraweeControllerBuilder
            public DraweePlaceHolderConfig getDraweePlaceHolderConfig() {
                DraweeConfig draweeConfig2 = draweeConfig;
                if (draweeConfig2 != null) {
                    return draweeConfig2.getDraweePlaceHolderConfig();
                }
                return null;
            }
        };
        sIDraweeControllerBuilderSupplier = iAbstractDraweeControllerBuilder;
        SimpleDraweeView.initialize(iAbstractDraweeControllerBuilder);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    private static void tryInitDraweeControllerBuilderSupplier() {
        IAbstractDraweeControllerBuilder iAbstractDraweeControllerBuilder;
        if (sDraweeControllerBuilderSupplier == null && DefaultDraweeConfig.INSTANCE.getDraweeControllerBuilder() != null) {
            sDraweeControllerBuilderSupplier = (PipelineDraweeControllerBuilderSupplier) DefaultDraweeConfig.INSTANCE.getDraweeControllerBuilder();
        }
        if (sDraweeControllerBuilderSupplier != null || (iAbstractDraweeControllerBuilder = sIDraweeControllerBuilderSupplier) == null) {
            return;
        }
        sDraweeControllerBuilderSupplier = (PipelineDraweeControllerBuilderSupplier) iAbstractDraweeControllerBuilder.getAbstractDraweeControllerBuilder();
    }

    public static PipelineDraweeControllerBuilderSupplier getDraweeControllerBuilderSupplier() {
        tryInitDraweeControllerBuilderSupplier();
        return sDraweeControllerBuilderSupplier;
    }

    public static PipelineDraweeControllerBuilder newDraweeControllerBuilder() {
        tryInitDraweeControllerBuilderSupplier();
        return sDraweeControllerBuilderSupplier.get();
    }

    public static ImagePipelineFactory getImagePipelineFactory() {
        return ImagePipelineFactory.getInstance();
    }

    public static ImagePipeline getImagePipeline() {
        return getImagePipelineFactory().getImagePipeline();
    }

    public static void shutDown() {
        sDraweeControllerBuilderSupplier = null;
        SimpleDraweeView.shutDown();
        ImagePipelineFactory.shutDown();
    }

    public static boolean hasBeenInitialized() {
        if (isLazyInit()) {
            return sIsLazyInit;
        }
        return sIsInitialized;
    }
}
