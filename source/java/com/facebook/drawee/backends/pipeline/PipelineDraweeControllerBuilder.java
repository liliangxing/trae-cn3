package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import android.net.Uri;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.FrescoOptUtil;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableDrawable;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class PipelineDraweeControllerBuilder extends AbstractDraweeControllerBuilder<PipelineDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo> {

    @Nullable
    private ImmutableList<DrawableFactory> mCustomDrawableFactories;

    @Nullable
    private ImageOriginListener mImageOriginListener;

    @Nullable
    private ImagePerfDataListener mImagePerfDataListener;
    private final ImagePipeline mImagePipeline;
    private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

    public PipelineDraweeControllerBuilder(Context context, PipelineDraweeControllerFactory pipelineDraweeControllerFactory, ImagePipeline imagePipeline, Set<ControllerListener> set) {
        super(context, set);
        this.mImagePipeline = imagePipeline;
        this.mPipelineDraweeControllerFactory = pipelineDraweeControllerFactory;
        setGlobalControllerListeners(pipelineDraweeControllerFactory.getGlobalControllerListeners());
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public PipelineDraweeControllerBuilder setUri(@Nullable Uri uri) {
        if (uri == null) {
            return (PipelineDraweeControllerBuilder) super.setImageRequest(null);
        }
        return (PipelineDraweeControllerBuilder) super.setImageRequest(ImageRequestBuilder.newBuilderWithSource(uri).setRotationOptions(RotationOptions.autoRotateAtRenderTime()).build());
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public SimpleDraweeControllerBuilder setUri(Uri uri, String str, String str2) {
        if (uri == null) {
            return super.setImageRequest(null);
        }
        return super.setImageRequest(ImageRequestBuilder.newBuilderWithSource(uri).setPublicKey(str).setUrlKey(str2).setRotationOptions(RotationOptions.autoRotateAtRenderTime()).build());
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public SimpleDraweeControllerBuilder setUris(List<Uri> list) {
        if (list == null || list.isEmpty()) {
            return super.setImageRequest(null);
        }
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(list.get(0));
        int size = list.size();
        if (size > 1) {
            newBuilderWithSource.setBackup(list.subList(1, size));
        }
        newBuilderWithSource.setRotationOptions(RotationOptions.autoRotateAtRenderTime());
        return super.setImageRequest(newBuilderWithSource.build());
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public PipelineDraweeControllerBuilder setUri(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            return (PipelineDraweeControllerBuilder) super.setImageRequest(ImageRequest.fromUri(str));
        }
        return setUri(Uri.parse(str));
    }

    public PipelineDraweeControllerBuilder setCustomDrawableFactories(@Nullable ImmutableList<DrawableFactory> immutableList) {
        this.mCustomDrawableFactories = immutableList;
        return getThis();
    }

    public PipelineDraweeControllerBuilder setCustomDrawableFactories(DrawableFactory... drawableFactoryArr) {
        Preconditions.checkNotNull(drawableFactoryArr);
        return setCustomDrawableFactories(ImmutableList.m412of((Object[]) drawableFactoryArr));
    }

    public PipelineDraweeControllerBuilder setCustomDrawableFactory(DrawableFactory drawableFactory) {
        Preconditions.checkNotNull(drawableFactory);
        return setCustomDrawableFactories(ImmutableList.m412of((Object[]) new DrawableFactory[]{drawableFactory}));
    }

    public PipelineDraweeControllerBuilder setImageOriginListener(@Nullable ImageOriginListener imageOriginListener) {
        this.mImageOriginListener = imageOriginListener;
        return getThis();
    }

    public PipelineDraweeControllerBuilder setPerfDataListener(@Nullable ImagePerfDataListener imagePerfDataListener) {
        this.mImagePerfDataListener = imagePerfDataListener;
        return getThis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public PipelineDraweeController obtainController() {
        PipelineDraweeController newController;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("PipelineDraweeControllerBuilder#obtainController");
        }
        try {
            DraweeController oldController = getOldController();
            String generateUniqueControllerId = generateUniqueControllerId();
            if (oldController instanceof PipelineDraweeController) {
                newController = (PipelineDraweeController) oldController;
                newController.setReuseController(true);
            } else {
                newController = this.mPipelineDraweeControllerFactory.newController();
                newController.setReuseController(false);
            }
            newController.setRetainPreviousImageOnFailure(getRetainPreviousImageOnFailure());
            newController.initialize(obtainDataSourceSupplier(newController, generateUniqueControllerId), generateUniqueControllerId, getCacheKey(), getCallerContext(), this.mCustomDrawableFactories, this.mImageOriginListener, (ImageRequest) getImageRequest());
            newController.initializePerformanceMonitoring(this.mImagePerfDataListener);
            return newController;
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    private CacheKey getCacheKey() {
        ImageRequest[] firstAvailableImageRequests;
        ImageRequest imageRequest = getImageRequest();
        CacheKeyFactory cacheKeyFactory = this.mImagePipeline.getCacheKeyFactory();
        if (imageRequest == null && (isOptFirstAvailableCache() != null ? isOptFirstAvailableCache().booleanValue() : FrescoOptUtil.isOptFirstAvailableCache()) && (firstAvailableImageRequests = getFirstAvailableImageRequests()) != null && firstAvailableImageRequests.length > 0) {
            imageRequest = firstAvailableImageRequests[0];
        }
        if (cacheKeyFactory == null || imageRequest == null) {
            return null;
        }
        if (imageRequest.getPostprocessor() != null) {
            return cacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, getCallerContext());
        }
        return cacheKeyFactory.getBitmapCacheKey(imageRequest, getCallerContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public DataSource<CloseableReference<CloseableImage>> getDataSourceForRequest(DraweeController draweeController, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        Uri sourceUri = imageRequest.getSourceUri();
        if (UriUtil.isLocalResourceUri(sourceUri) || UriUtil.isQualifiedResourceUri(sourceUri)) {
            try {
                int resourceIdFromUri = UriUtil.getResourceIdFromUri(this.mContext, sourceUri);
                if (isXmlFormat(resourceIdFromUri)) {
                    return DataSources.immediateDataSource(CloseableReference.m496of(new CloseableDrawable(AppCompatResources.getDrawable(this.mContext, resourceIdFromUri))));
                }
            } catch (Exception unused) {
            }
        }
        return this.mImagePipeline.fetchDecodedImage(imageRequest, obj, convertCacheLevelToRequestLevel(cacheLevel), getRequestListener(draweeController), Priority.getHigherPriority(Priority.HIGH, imageRequest != null ? imageRequest.getPriority() : Priority.HIGH));
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public PipelineDraweeControllerBuilder transMultiImageRequestsToImageRequest(ImageRequest[] imageRequestArr, boolean z) {
        ImageRequest imageRequest = imageRequestArr[0];
        if (UriUtil.isNetworkUri(imageRequest.getSourceUri())) {
            if (imageRequestArr.length > 1) {
                ImageRequestBuilder fromRequest = ImageRequestBuilder.fromRequest(imageRequest);
                ArrayList arrayList = new ArrayList();
                for (int i = 1; i < imageRequestArr.length; i++) {
                    arrayList.add(imageRequestArr[i].getSourceUri());
                }
                fromRequest.setBackup(arrayList);
                imageRequest = fromRequest.build();
            }
            return setImageRequest(imageRequest);
        }
        return setImageRequests(imageRequestArr, z);
    }

    @Nullable
    protected RequestListener getRequestListener(DraweeController draweeController) {
        if (draweeController instanceof PipelineDraweeController) {
            return ((PipelineDraweeController) draweeController).getRequestListener();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static /* synthetic */ class C02051 {

        /* renamed from: $SwitchMap$com$facebook$drawee$controller$AbstractDraweeControllerBuilder$CacheLevel */
        static final /* synthetic */ int[] f357x8d44a530;

        static {
            int[] iArr = new int[AbstractDraweeControllerBuilder.CacheLevel.values().length];
            f357x8d44a530 = iArr;
            try {
                iArr[AbstractDraweeControllerBuilder.CacheLevel.FULL_FETCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f357x8d44a530[AbstractDraweeControllerBuilder.CacheLevel.DISK_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f357x8d44a530[AbstractDraweeControllerBuilder.CacheLevel.BITMAP_MEMORY_CACHE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static ImageRequest.RequestLevel convertCacheLevelToRequestLevel(AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        int i = C02051.f357x8d44a530[cacheLevel.ordinal()];
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

    private boolean isXmlFormat(int i) {
        TypedValue typedValue = new TypedValue();
        this.mContext.getResources().getValue(i, typedValue, true);
        String obj = typedValue.string == null ? null : typedValue.string.toString();
        if (obj == null) {
            return false;
        }
        return obj.endsWith(".xml");
    }
}
