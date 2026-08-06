package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweePlaceHolderConfig;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements SimpleDraweeControllerBuilder {
    private boolean mAutoPlayAnimations;
    private final Set<ControllerListener> mBoundControllerListeners;

    @Nullable
    private Object mCallerContext;
    private String mContentDescription;
    protected final Context mContext;

    @Nullable
    private ControllerListener<? super INFO> mControllerListener;

    @Nullable
    private ControllerViewportVisibilityListener mControllerViewportVisibilityListener;

    @Nullable
    private Supplier<DataSource<IMAGE>> mDataSourceSupplier;
    private DraweePlaceHolderConfig mDraweePlaceHolderConfig;

    @Nullable
    private Set<ControllerListener> mGlobalControllerListeners;

    @Nullable
    private REQUEST mImageRequest;
    private boolean mKeepFirstAvailableRequest;

    @Nullable
    private REQUEST mLowResImageRequest;

    @Nullable
    private REQUEST[] mMultiImageRequests;

    @Nullable
    private DraweeController mOldController;
    private boolean mRetainImageOnFailure;
    private boolean mRetainPreviousImageOnFailure;
    private boolean mTapToRetryEnabled;
    private boolean mTryCacheOnlyFirst;
    private static final ControllerListener<Object> sAutoPlayAnimationsListener = new BaseControllerListener<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener
        public void onIntermediateImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            super.onIntermediateImageSet(str, obj, animatable);
            if (animatable == null || animatable.isRunning()) {
                return;
            }
            animatable.start();
        }
    };
    private static final NullPointerException NO_REQUEST_EXCEPTION = new NullPointerException("No image request was specified!");
    private static final AtomicLong sIdCounter = new AtomicLong();
    boolean mEnableHeaderBlurhash = true;

    @Nullable
    private Boolean mOptFirstAvailableCache = null;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract DataSource<IMAGE> getDataSourceForRequest(DraweeController draweeController, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    /* JADX INFO: Access modifiers changed from: protected */
    public final BUILDER getThis() {
        return this;
    }

    protected abstract AbstractDraweeController obtainController();

    public abstract BUILDER transMultiImageRequestsToImageRequest(REQUEST[] requestArr, boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDraweeControllerBuilder(Context context, Set<ControllerListener> set) {
        this.mContext = context;
        this.mBoundControllerListeners = set;
        init();
    }

    private void init() {
        this.mCallerContext = null;
        this.mImageRequest = null;
        this.mLowResImageRequest = null;
        this.mMultiImageRequests = null;
        this.mTryCacheOnlyFirst = true;
        this.mControllerListener = null;
        this.mControllerViewportVisibilityListener = null;
        this.mTapToRetryEnabled = false;
        this.mAutoPlayAnimations = false;
        this.mOldController = null;
        this.mContentDescription = null;
        this.mDataSourceSupplier = null;
    }

    public BUILDER reset() {
        init();
        return getThis();
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public BUILDER setCallerContext(Object obj) {
        this.mCallerContext = obj;
        return getThis();
    }

    @Nullable
    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public BUILDER setImageRequest(REQUEST request) {
        this.mImageRequest = request;
        return getThis();
    }

    @Nullable
    public REQUEST getImageRequest() {
        return this.mImageRequest;
    }

    public BUILDER setLowResImageRequest(REQUEST request) {
        this.mLowResImageRequest = request;
        return getThis();
    }

    @Nullable
    public REQUEST getLowResImageRequest() {
        return this.mLowResImageRequest;
    }

    public BUILDER setFirstAvailableImageRequests(REQUEST[] requestArr) {
        return setFirstAvailableImageRequests(requestArr, true);
    }

    public BUILDER setFirstAvailableImageRequests(REQUEST[] requestArr, boolean z) {
        Preconditions.checkArgument(requestArr == null || requestArr.length > 0, "No requests specified!");
        if (ImagePipelineConfig.useSingleImageRequest && !this.mKeepFirstAvailableRequest && requestArr != null && requestArr.length > 0) {
            return transMultiImageRequestsToImageRequest(requestArr, z);
        }
        this.mMultiImageRequests = requestArr;
        this.mTryCacheOnlyFirst = z;
        return getThis();
    }

    public BUILDER setImageRequests(REQUEST[] requestArr, boolean z) {
        this.mMultiImageRequests = requestArr;
        this.mTryCacheOnlyFirst = z;
        return getThis();
    }

    @Nullable
    public REQUEST[] getFirstAvailableImageRequests() {
        return this.mMultiImageRequests;
    }

    public BUILDER setDataSourceSupplier(@Nullable Supplier<DataSource<IMAGE>> supplier) {
        this.mDataSourceSupplier = supplier;
        return getThis();
    }

    @Nullable
    public Supplier<DataSource<IMAGE>> getDataSourceSupplier() {
        return this.mDataSourceSupplier;
    }

    public BUILDER setTapToRetryEnabled(boolean z) {
        this.mTapToRetryEnabled = z;
        return getThis();
    }

    public boolean getTapToRetryEnabled() {
        return this.mTapToRetryEnabled;
    }

    public BUILDER setRetainImageOnFailure(boolean z) {
        this.mRetainImageOnFailure = z;
        return getThis();
    }

    public boolean getRetainImageOnFailure() {
        return this.mRetainImageOnFailure;
    }

    public BUILDER setRetainPreviousImageOnFailure(boolean z) {
        this.mRetainPreviousImageOnFailure = z;
        return getThis();
    }

    public boolean getRetainPreviousImageOnFailure() {
        return this.mRetainPreviousImageOnFailure;
    }

    public BUILDER setAutoPlayAnimations(boolean z) {
        this.mAutoPlayAnimations = z;
        return getThis();
    }

    public boolean getAutoPlayAnimations() {
        return this.mAutoPlayAnimations;
    }

    public BUILDER setControllerListener(ControllerListener<? super INFO> controllerListener) {
        this.mControllerListener = controllerListener;
        return getThis();
    }

    public void setGlobalControllerListeners(Set<ControllerListener> set) {
        this.mGlobalControllerListeners = set;
    }

    @Nullable
    public ControllerListener<? super INFO> getControllerListener() {
        return this.mControllerListener;
    }

    public BUILDER setControllerViewportVisibilityListener(@Nullable ControllerViewportVisibilityListener controllerViewportVisibilityListener) {
        this.mControllerViewportVisibilityListener = controllerViewportVisibilityListener;
        return getThis();
    }

    @Nullable
    public ControllerViewportVisibilityListener getControllerViewportVisibilityListener() {
        return this.mControllerViewportVisibilityListener;
    }

    public BUILDER setContentDescription(String str) {
        this.mContentDescription = str;
        return getThis();
    }

    @Nullable
    public String getContentDescription() {
        return this.mContentDescription;
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public BUILDER setOldController(@Nullable DraweeController draweeController) {
        this.mOldController = draweeController;
        return getThis();
    }

    @Nullable
    public DraweeController getOldController() {
        return this.mOldController;
    }

    public BUILDER setDraweePlaceHolderConfig(DraweePlaceHolderConfig draweePlaceHolderConfig) {
        this.mDraweePlaceHolderConfig = draweePlaceHolderConfig;
        return getThis();
    }

    public DraweePlaceHolderConfig getDraweePlaceHolderConfig() {
        return this.mDraweePlaceHolderConfig;
    }

    public BUILDER setEnableHeaderBlurhash(boolean z) {
        this.mEnableHeaderBlurhash = z;
        return getThis();
    }

    public boolean getEnableHeaderBlurhash() {
        return this.mEnableHeaderBlurhash;
    }

    public BUILDER setKeepFirstAvailableRequest(boolean z) {
        this.mKeepFirstAvailableRequest = z;
        return getThis();
    }

    public boolean isKeepFirstAvailableRequest() {
        return this.mKeepFirstAvailableRequest;
    }

    public BUILDER setOptFirstAvailableCache(Boolean bool) {
        this.mOptFirstAvailableCache = bool;
        return getThis();
    }

    public Boolean isOptFirstAvailableCache() {
        return this.mOptFirstAvailableCache;
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public AbstractDraweeController build() {
        REQUEST[] requestArr;
        REQUEST request;
        validate();
        if (this.mImageRequest == null && this.mMultiImageRequests == null && (request = this.mLowResImageRequest) != null) {
            this.mImageRequest = request;
            this.mLowResImageRequest = null;
        }
        if (FrescoCacheMonitorUtil.isMultiUrlCacheOpt() && this.mImageRequest == null && (requestArr = this.mMultiImageRequests) != null && requestArr.length > 0) {
            this.mImageRequest = requestArr[0];
        }
        return buildController();
    }

    protected void validate() {
        boolean z = false;
        Preconditions.checkState(this.mMultiImageRequests == null || this.mImageRequest == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.mDataSourceSupplier == null || (this.mMultiImageRequests == null && this.mImageRequest == null && this.mLowResImageRequest == null)) {
            z = true;
        }
        Preconditions.checkState(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected AbstractDraweeController buildController() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeControllerBuilder#buildController");
        }
        AbstractDraweeController obtainController = obtainController();
        obtainController.setRetainImageOnFailure(getRetainImageOnFailure());
        obtainController.setContentDescription(getContentDescription());
        obtainController.setControllerViewportVisibilityListener(getControllerViewportVisibilityListener());
        maybeBuildAndSetRetryManager(obtainController);
        maybeAttachListeners(obtainController);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        obtainController.setEnableHeaderBlurhash(this.mEnableHeaderBlurhash);
        return obtainController;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String generateUniqueControllerId() {
        return String.valueOf(sIdCounter.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Supplier<DataSource<IMAGE>> obtainDataSourceSupplier(DraweeController draweeController, String str) {
        Supplier<DataSource<IMAGE>> firstAvailableDataSourceSupplier;
        Supplier<DataSource<IMAGE>> supplier = this.mDataSourceSupplier;
        if (supplier != null) {
            return supplier;
        }
        REQUEST request = this.mImageRequest;
        if (request != null) {
            firstAvailableDataSourceSupplier = getDataSourceSupplierForRequest(draweeController, str, request);
        } else {
            REQUEST[] requestArr = this.mMultiImageRequests;
            firstAvailableDataSourceSupplier = requestArr != null ? getFirstAvailableDataSourceSupplier(draweeController, str, requestArr, this.mTryCacheOnlyFirst) : null;
        }
        if (firstAvailableDataSourceSupplier != null && this.mLowResImageRequest != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(firstAvailableDataSourceSupplier);
            arrayList.add(getDataSourceSupplierForRequest(draweeController, str, this.mLowResImageRequest));
            firstAvailableDataSourceSupplier = IncreasingQualityDataSourceSupplier.create(arrayList, false);
        }
        return firstAvailableDataSourceSupplier == null ? DataSources.getFailedDataSourceSupplier(NO_REQUEST_EXCEPTION) : firstAvailableDataSourceSupplier;
    }

    protected Supplier<DataSource<IMAGE>> getFirstAvailableDataSourceSupplier(DraweeController draweeController, String str, REQUEST[] requestArr, boolean z) {
        ArrayList arrayList = new ArrayList(requestArr.length * 2);
        if (z) {
            if (FrescoCacheMonitorUtil.isMultiUrlCacheOpt()) {
                arrayList.add(getDataSourceSupplierForRequest(draweeController, str, requestArr[0], CacheLevel.BITMAP_MEMORY_CACHE));
            } else {
                for (REQUEST request : requestArr) {
                    arrayList.add(getDataSourceSupplierForRequest(draweeController, str, request, CacheLevel.BITMAP_MEMORY_CACHE));
                }
            }
        }
        for (REQUEST request2 : requestArr) {
            arrayList.add(getDataSourceSupplierForRequest(draweeController, str, request2));
        }
        return FirstAvailableDataSourceSupplier.create(arrayList);
    }

    protected Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(DraweeController draweeController, String str, REQUEST request) {
        return getDataSourceSupplierForRequest(draweeController, str, request, CacheLevel.FULL_FETCH);
    }

    protected Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(final DraweeController draweeController, final String str, final REQUEST request, final CacheLevel cacheLevel) {
        final Object callerContext = getCallerContext();
        return new AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>.CustomSupplier<DataSource<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder.CustomSupplier
            public REQUEST getRequest() {
                return (REQUEST) request;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<IMAGE> get() {
                DraweeController draweeController2 = draweeController;
                if (draweeController2 instanceof AbstractDraweeController) {
                    ControllerListener<INFO> controllerListener = ((AbstractDraweeController) draweeController2).getControllerListener();
                    Object imageRequest = AbstractDraweeControllerBuilder.this.getImageRequest();
                    if (FrescoCacheMonitorUtil.isOptMultiRequestSensible() && imageRequest == null) {
                        imageRequest = getRequest();
                    }
                    if (controllerListener != null && (controllerListener instanceof BaseControllerListener)) {
                        ((BaseControllerListener) controllerListener).onControllerStart((ImageRequest) imageRequest, System.currentTimeMillis());
                    }
                }
                return AbstractDraweeControllerBuilder.this.getDataSourceForRequest(draweeController, str, request, callerContext, cacheLevel);
            }

            public String toString() {
                return Objects.toStringHelper(this).add("request", request.toString()).toString();
            }
        };
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public abstract class CustomSupplier<D> implements Supplier<DataSource<IMAGE>> {
        public abstract REQUEST getRequest();

        public CustomSupplier() {
        }
    }

    protected void maybeAttachListeners(AbstractDraweeController abstractDraweeController) {
        Set<ControllerListener> set = this.mBoundControllerListeners;
        if (set != null) {
            Iterator<ControllerListener> it = set.iterator();
            while (it.hasNext()) {
                abstractDraweeController.addControllerListener(it.next());
            }
        }
        ControllerListener<? super INFO> controllerListener = this.mControllerListener;
        if (controllerListener != null) {
            abstractDraweeController.addControllerListener(controllerListener);
        }
        Set<ControllerListener> set2 = this.mGlobalControllerListeners;
        if (set2 != null && set2.size() != 0) {
            Iterator<ControllerListener> it2 = this.mGlobalControllerListeners.iterator();
            while (it2.hasNext()) {
                abstractDraweeController.addControllerListener(it2.next());
            }
        }
        if (this.mAutoPlayAnimations) {
            abstractDraweeController.addControllerListener(sAutoPlayAnimationsListener);
        }
    }

    protected void maybeBuildAndSetRetryManager(AbstractDraweeController abstractDraweeController) {
        if (this.mTapToRetryEnabled) {
            abstractDraweeController.getRetryManager().setTapToRetryEnabled(this.mTapToRetryEnabled);
            maybeBuildAndSetGestureDetector(abstractDraweeController);
        }
    }

    protected void maybeBuildAndSetGestureDetector(AbstractDraweeController abstractDraweeController) {
        if (abstractDraweeController.getGestureDetector() == null) {
            abstractDraweeController.setGestureDetector(GestureDetector.newInstance(this.mContext));
        }
    }

    protected Context getContext() {
        return this.mContext;
    }
}
