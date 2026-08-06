package com.lynx.tasm.p001ui.image;

import android.content.Context;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.lynx.tasm.p001ui.image.LynxAbstractDraweeControllerBuilder;
import com.lynx.tasm.p001ui.image.fresco.LynxUIThreadImmediateExecutor;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxDraweeControllerBuilder extends LynxAbstractDraweeControllerBuilder<LynxDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo> {
    private DrawableFactory mDrawableFactory;

    @Nullable
    private ImageOriginListener mImageOriginListener;
    private final ImagePipeline mImagePipeline;

    /* JADX INFO: Access modifiers changed from: protected */
    public LynxDraweeControllerBuilder(Context context, DrawableFactory drawableFactory) {
        super(context);
        this.mImagePipeline = Fresco.getImagePipeline();
        this.mDrawableFactory = drawableFactory;
    }

    @Override // com.lynx.tasm.p001ui.image.LynxAbstractDraweeControllerBuilder
    protected LynxAbstractDraweeController obtainController() {
        LynxDraweeController newController;
        LynxAbstractDraweeController oldController = getOldController();
        String generateUniqueControllerId = generateUniqueControllerId();
        if (oldController instanceof LynxDraweeController) {
            newController = (LynxDraweeController) oldController;
        } else {
            newController = newController();
        }
        newController.initialize(obtainDataSourceSupplier(newController, generateUniqueControllerId), generateUniqueControllerId, getCallerContext(), this.mImageOriginListener);
        return newController;
    }

    public LynxDraweeController newController() {
        UiThreadImmediateExecutorService uiThreadImmediateExecutorService;
        AsyncDeferredReleaser asyncDeferredReleaser = AsyncDeferredReleaser.getInstance();
        DrawableFactory drawableFactory = this.mDrawableFactory;
        if (this.mEnableAsyncCallback) {
            uiThreadImmediateExecutorService = LynxUIThreadImmediateExecutor.getInstance();
        } else {
            uiThreadImmediateExecutorService = UiThreadImmediateExecutorService.getInstance();
        }
        return new LynxDraweeController(asyncDeferredReleaser, drawableFactory, uiThreadImmediateExecutorService, this.mImagePipeline.getBitmapMemoryCache());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.p001ui.image.LynxAbstractDraweeControllerBuilder
    public DataSource<CloseableReference<CloseableImage>> getDataSourceForRequest(LynxAbstractDraweeController lynxAbstractDraweeController, String str, ImageRequest imageRequest, Object obj, LynxAbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.mImagePipeline.fetchDecodedImage(imageRequest, obj, convertCacheLevelToRequestLevel(cacheLevel), getRequestListener(lynxAbstractDraweeController));
    }

    @Nullable
    protected RequestListener getRequestListener(LynxAbstractDraweeController lynxAbstractDraweeController) {
        if (lynxAbstractDraweeController instanceof LynxDraweeController) {
            return ((LynxDraweeController) lynxAbstractDraweeController).getRequestListener();
        }
        return null;
    }

    public LynxDraweeControllerBuilder setImageOriginListener(@Nullable ImageOriginListener imageOriginListener) {
        this.mImageOriginListener = imageOriginListener;
        return getThis();
    }

    @Override // com.lynx.tasm.p001ui.image.LynxAbstractDraweeControllerBuilder
    public LynxDraweeControllerBuilder reset() {
        this.mImageOriginListener = null;
        return (LynxDraweeControllerBuilder) super.reset();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.lynx.tasm.ui.image.LynxDraweeControllerBuilder$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static /* synthetic */ class C02321 {

        /* renamed from: $SwitchMap$com$lynx$tasm$ui$image$LynxAbstractDraweeControllerBuilder$CacheLevel */
        static final /* synthetic */ int[] f22x8538778a;

        static {
            int[] iArr = new int[LynxAbstractDraweeControllerBuilder.CacheLevel.values().length];
            f22x8538778a = iArr;
            try {
                iArr[LynxAbstractDraweeControllerBuilder.CacheLevel.FULL_FETCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22x8538778a[LynxAbstractDraweeControllerBuilder.CacheLevel.DISK_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22x8538778a[LynxAbstractDraweeControllerBuilder.CacheLevel.BITMAP_MEMORY_CACHE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static ImageRequest.RequestLevel convertCacheLevelToRequestLevel(LynxAbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        int i = C02321.f22x8538778a[cacheLevel.ordinal()];
        if (i == 1) {
            return ImageRequest.RequestLevel.FULL_FETCH;
        }
        if (i == 2) {
            return ImageRequest.RequestLevel.DISK_CACHE;
        }
        if (i == 3) {
            return ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE;
        }
        throw new RuntimeException("Cache level" + cacheLevel + "is not supported. ");
    }
}
