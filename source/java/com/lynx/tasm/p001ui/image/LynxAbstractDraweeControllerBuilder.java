package com.lynx.tasm.p001ui.image;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.lynx.tasm.p001ui.image.LynxAbstractDraweeControllerBuilder;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class LynxAbstractDraweeControllerBuilder<BUILDER extends LynxAbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> {
    private boolean mAutoPlayAnimations;
    private Object mCallerContext;
    private String mContentDescription;
    protected final Context mContext;
    private ControllerListener<? super INFO> mControllerListener;
    private Supplier<DataSource<IMAGE>> mDataSourceSupplier;
    protected boolean mEnableAsyncCallback;
    private REQUEST mImageRequest;
    private REQUEST mLowResImageRequest;
    private LynxAbstractDraweeController mOldController;
    private boolean mRetainImageOnFailure;
    private boolean mRetainPreviousImageOnFailure;
    private static final ControllerListener<Object> sAutoPlayAnimationsListener = new BaseControllerListener<Object>() { // from class: com.lynx.tasm.ui.image.LynxAbstractDraweeControllerBuilder.1
        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException NO_REQUEST_EXCEPTION = new NullPointerException("No image request was specified!");
    private static final AtomicLong sIdCounter = new AtomicLong();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract DataSource<IMAGE> getDataSourceForRequest(LynxAbstractDraweeController lynxAbstractDraweeController, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    /* JADX INFO: Access modifiers changed from: protected */
    public final BUILDER getThis() {
        return this;
    }

    protected abstract LynxAbstractDraweeController obtainController();

    /* JADX INFO: Access modifiers changed from: protected */
    public LynxAbstractDraweeControllerBuilder(Context context) {
        this.mContext = context;
        init();
    }

    private void init() {
        this.mCallerContext = null;
        this.mImageRequest = null;
        this.mLowResImageRequest = null;
        this.mControllerListener = null;
        this.mAutoPlayAnimations = false;
        this.mOldController = null;
        this.mContentDescription = null;
    }

    public BUILDER reset() {
        init();
        return getThis();
    }

    public BUILDER setCallerContext(Object obj) {
        this.mCallerContext = obj;
        return getThis();
    }

    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public BUILDER setImageRequest(REQUEST request) {
        this.mImageRequest = request;
        return getThis();
    }

    public REQUEST getImageRequest() {
        return this.mImageRequest;
    }

    public BUILDER setLowResImageRequest(REQUEST request) {
        this.mLowResImageRequest = request;
        return getThis();
    }

    public REQUEST getLowResImageRequest() {
        return this.mLowResImageRequest;
    }

    public BUILDER setDataSourceSupplier(Supplier<DataSource<IMAGE>> supplier) {
        this.mDataSourceSupplier = supplier;
        return getThis();
    }

    public Supplier<DataSource<IMAGE>> getDataSourceSupplier() {
        return this.mDataSourceSupplier;
    }

    public BUILDER setRetainImageOnFailure(boolean z) {
        this.mRetainImageOnFailure = z;
        return getThis();
    }

    public boolean getRetainImageOnFailure() {
        return this.mRetainImageOnFailure;
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

    public ControllerListener<? super INFO> getControllerListener() {
        return this.mControllerListener;
    }

    public BUILDER setOldController(LynxAbstractDraweeController lynxAbstractDraweeController) {
        this.mOldController = lynxAbstractDraweeController;
        return getThis();
    }

    public LynxAbstractDraweeController getOldController() {
        return this.mOldController;
    }

    public LynxAbstractDraweeController build() {
        REQUEST request;
        if (this.mImageRequest == null && (request = this.mLowResImageRequest) != null) {
            this.mImageRequest = request;
            this.mLowResImageRequest = null;
        }
        return buildController();
    }

    protected LynxAbstractDraweeController buildController() {
        LynxAbstractDraweeController obtainController = obtainController();
        obtainController.setRetainImageOnFailure(getRetainImageOnFailure());
        maybeAttachListeners(obtainController);
        return obtainController;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String generateUniqueControllerId() {
        return String.valueOf(sIdCounter.getAndIncrement());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Supplier<DataSource<IMAGE>> obtainDataSourceSupplier(LynxAbstractDraweeController lynxAbstractDraweeController, String str) {
        Supplier<DataSource<IMAGE>> supplier = this.mDataSourceSupplier;
        if (supplier != null) {
            return supplier;
        }
        REQUEST request = this.mImageRequest;
        Supplier<DataSource<IMAGE>> dataSourceSupplierForRequest = request != null ? getDataSourceSupplierForRequest(lynxAbstractDraweeController, str, request) : null;
        if (dataSourceSupplierForRequest != null && this.mLowResImageRequest != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(dataSourceSupplierForRequest);
            arrayList.add(getDataSourceSupplierForRequest(lynxAbstractDraweeController, str, this.mLowResImageRequest));
            dataSourceSupplierForRequest = IncreasingQualityDataSourceSupplier.create(arrayList, false);
        }
        return dataSourceSupplierForRequest == null ? DataSources.getFailedDataSourceSupplier(NO_REQUEST_EXCEPTION) : dataSourceSupplierForRequest;
    }

    protected Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(LynxAbstractDraweeController lynxAbstractDraweeController, String str, REQUEST request) {
        return getDataSourceSupplierForRequest(lynxAbstractDraweeController, str, request, CacheLevel.FULL_FETCH);
    }

    protected Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(final LynxAbstractDraweeController lynxAbstractDraweeController, final String str, final REQUEST request, final CacheLevel cacheLevel) {
        final Object callerContext = getCallerContext();
        return new Supplier<DataSource<IMAGE>>() { // from class: com.lynx.tasm.ui.image.LynxAbstractDraweeControllerBuilder.2
            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: get, reason: merged with bridge method [inline-methods] */
            public DataSource<IMAGE> m4140get() {
                return LynxAbstractDraweeControllerBuilder.this.getDataSourceForRequest(lynxAbstractDraweeController, str, request, callerContext, cacheLevel);
            }

            public String toString() {
                return Objects.toStringHelper(this).add("request", request.toString()).toString();
            }
        };
    }

    protected void maybeAttachListeners(LynxAbstractDraweeController lynxAbstractDraweeController) {
        ControllerListener<? super INFO> controllerListener = this.mControllerListener;
        if (controllerListener != null) {
            lynxAbstractDraweeController.addControllerListener(controllerListener);
        }
        if (this.mAutoPlayAnimations) {
            lynxAbstractDraweeController.addControllerListener(sAutoPlayAnimationsListener);
        }
    }

    protected Context getContext() {
        return this.mContext;
    }

    public BUILDER setEnableAsyncCallback(boolean z) {
        this.mEnableAsyncCallback = z;
        return getThis();
    }
}
