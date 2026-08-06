package com.lynx.tasm.p001ui.image;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.controller.ForwardingControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.imagepipeline.request.ImageRequest;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class LynxAbstractDraweeController<T, INFO> implements DeferredReleaser.Releasable {
    private Object mCallerContext;
    private String mContentDescription;
    private ControllerListener<INFO> mControllerListener;
    private volatile DataSource<T> mDataSource;
    private final AsyncDeferredReleaser mDeferredReleaser;
    private Drawable mDrawable;
    private T mFetchedImage;
    private volatile boolean mHasFetchFailed;
    private String mId;
    private ImageRequest mImageRequest;
    private volatile boolean mIsAttached;
    private volatile boolean mIsRequestSubmitted;
    private boolean mJustConstructed = true;
    private String mRequestUrl;
    private boolean mRetainImageOnFailure;
    private boolean mRetainPreviousImageOnFailure;
    private SettableDraweeHierarchy mSettableDraweeHierarchy;
    private WeakReference<FlattenUIImage> mUI;
    protected final Executor mUiThreadImmediateExecutor;

    protected abstract Drawable createDrawable(T t);

    public abstract DataSource<T> getDataSource();

    protected abstract INFO getImageInfo(T t);

    public boolean isSameImageRequest(DraweeController draweeController) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onViewportVisibilityHint(boolean z) {
    }

    protected abstract void releaseDrawable(Drawable drawable);

    protected abstract void releaseImage(T t);

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class InternalForwardingListener<INFO> extends ForwardingControllerListener<INFO> {
        private InternalForwardingListener() {
        }

        public static <INFO> InternalForwardingListener<INFO> createInternal(ControllerListener<? super INFO> controllerListener, ControllerListener<? super INFO> controllerListener2) {
            InternalForwardingListener<INFO> internalForwardingListener = new InternalForwardingListener<>();
            internalForwardingListener.addListener(controllerListener);
            internalForwardingListener.addListener(controllerListener2);
            return internalForwardingListener;
        }
    }

    public LynxAbstractDraweeController(AsyncDeferredReleaser asyncDeferredReleaser, Executor executor, String str, Object obj) {
        this.mDeferredReleaser = asyncDeferredReleaser;
        this.mUiThreadImmediateExecutor = executor;
        init(str, obj);
    }

    private void init(String str, Object obj) {
        AsyncDeferredReleaser asyncDeferredReleaser;
        if (!this.mJustConstructed && (asyncDeferredReleaser = this.mDeferredReleaser) != null) {
            asyncDeferredReleaser.cancelDeferredRelease(this);
        }
        this.mIsAttached = false;
        releaseFetch();
        this.mRetainImageOnFailure = false;
        this.mControllerListener = null;
        if (this.mSettableDraweeHierarchy != null) {
            this.mSettableDraweeHierarchy = null;
        }
        this.mId = str;
        this.mCallerContext = obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize(String str, Object obj) {
        init(str, obj);
        this.mJustConstructed = false;
    }

    protected void initialize(String str, Object obj, ImageRequest imageRequest) {
        this.mImageRequest = imageRequest;
        init(str, obj);
        this.mJustConstructed = false;
    }

    public void release() {
        releaseFetch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeResource() {
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            releaseDrawable(drawable);
        }
        this.mDrawable = null;
        T t = this.mFetchedImage;
        if (t != null) {
            releaseImage(t);
            this.mFetchedImage = null;
        }
    }

    private void releaseFetch() {
        boolean z = this.mIsRequestSubmitted;
        this.mIsRequestSubmitted = false;
        this.mHasFetchFailed = false;
        final DataSource<T> dataSource = this.mDataSource;
        this.mDataSource = null;
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.ui.image.LynxAbstractDraweeController.1
            @Override // java.lang.Runnable
            public void run() {
                DataSource dataSource2 = dataSource;
                if (dataSource2 != null) {
                    dataSource2.close();
                }
                LynxAbstractDraweeController.this.closeResource();
            }
        });
        if (this.mContentDescription != null) {
            this.mContentDescription = null;
        }
        if (z) {
            getControllerListener().onRelease(this.mId);
        }
    }

    public String getId() {
        return this.mId;
    }

    public Object getCallerContext() {
        return this.mCallerContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRetainImageOnFailure(boolean z) {
        this.mRetainImageOnFailure = z;
    }

    public void setRetainPreviousImageOnFailure(boolean z) {
        this.mRetainPreviousImageOnFailure = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addControllerListener(ControllerListener<? super INFO> controllerListener) {
        InternalForwardingListener internalForwardingListener = this.mControllerListener;
        if (internalForwardingListener instanceof InternalForwardingListener) {
            internalForwardingListener.addListener(controllerListener);
        } else if (internalForwardingListener != null) {
            this.mControllerListener = InternalForwardingListener.createInternal(internalForwardingListener, controllerListener);
        } else {
            this.mControllerListener = controllerListener;
        }
    }

    public void removeControllerListener(ControllerListener<? super INFO> controllerListener) {
        InternalForwardingListener internalForwardingListener = this.mControllerListener;
        if (internalForwardingListener instanceof InternalForwardingListener) {
            internalForwardingListener.removeListener(controllerListener);
        } else if (internalForwardingListener == controllerListener) {
            this.mControllerListener = null;
        }
    }

    protected ControllerListener<INFO> getControllerListener() {
        ControllerListener<INFO> controllerListener = this.mControllerListener;
        return controllerListener == null ? BaseControllerListener.getNoOpListener() : controllerListener;
    }

    public DraweeHierarchy getHierarchy() {
        return this.mSettableDraweeHierarchy;
    }

    public void setHierarchy(DraweeHierarchy draweeHierarchy) {
        if (this.mIsRequestSubmitted) {
            this.mDeferredReleaser.cancelDeferredRelease(this);
            release();
        }
        if (this.mSettableDraweeHierarchy != null) {
            this.mSettableDraweeHierarchy = null;
        }
        if (draweeHierarchy != null) {
            Preconditions.checkArgument(draweeHierarchy instanceof SettableDraweeHierarchy);
            this.mSettableDraweeHierarchy = (SettableDraweeHierarchy) draweeHierarchy;
        }
    }

    public void onAttach() {
        this.mDeferredReleaser.cancelDeferredRelease(this);
        this.mIsAttached = true;
        if (this.mIsRequestSubmitted) {
            return;
        }
        submitRequest();
    }

    public void onDetach() {
        this.mIsAttached = false;
        this.mDeferredReleaser.scheduleDeferredRelease(this);
    }

    public Animatable getAnimatable() {
        Object obj = this.mDrawable;
        if (obj instanceof Animatable) {
            return (Animatable) obj;
        }
        return null;
    }

    protected void submitRequest() {
        getControllerListener().onSubmit(this.mId, this.mCallerContext);
        this.mIsRequestSubmitted = true;
        this.mHasFetchFailed = false;
        DataSource<T> dataSource = getDataSource();
        this.mDataSource = dataSource;
        final String str = this.mId;
        if (dataSource != null) {
            final boolean hasResult = dataSource.hasResult();
            dataSource.subscribe(new BaseDataSubscriber<T>() { // from class: com.lynx.tasm.ui.image.LynxAbstractDraweeController.2
                public void onNewResultImpl(DataSource<T> dataSource2) {
                    boolean isFinished = dataSource2.isFinished();
                    float progress = dataSource2.getProgress();
                    Object result = dataSource2.getResult();
                    if (result != null) {
                        LynxAbstractDraweeController.this.onNewResultInternal(str, dataSource2, result, progress, isFinished, hasResult);
                    } else if (isFinished) {
                        LynxAbstractDraweeController.this.onFailureInternal(str, dataSource2, new NullPointerException(), true);
                    }
                }

                public void onFailureImpl(DataSource<T> dataSource2) {
                    LynxAbstractDraweeController.this.onFailureInternal(str, dataSource2, dataSource2.getFailureCause(), true);
                }

                public void onProgressUpdate(DataSource<T> dataSource2) {
                    boolean isFinished = dataSource2.isFinished();
                    LynxAbstractDraweeController.this.onProgressUpdateInternal(str, dataSource2, dataSource2.getProgress(), isFinished);
                }
            }, this.mUiThreadImmediateExecutor);
        } else {
            LLog.i("LynxImage", "request after dataSource release url= " + this.mRequestUrl);
        }
    }

    private boolean checkCurrentUrlValidate(DataSource<T> dataSource, T t) {
        FlattenUIImage flattenUIImage;
        WeakReference<FlattenUIImage> weakReference = this.mUI;
        if (weakReference == null || (flattenUIImage = weakReference.get()) == null || TextUtils.equals(flattenUIImage.getSource(), this.mRequestUrl)) {
            return true;
        }
        if (t != null) {
            releaseImage(t);
        }
        if (dataSource != null) {
            dataSource.close();
        }
        LLog.i("LynxImage", "image check failed curUrl = " + flattenUIImage.getSource() + " preUrl = " + this.mRequestUrl);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNewResultInternal(String str, DataSource<T> dataSource, T t, float f, boolean z, boolean z2) {
        if (!isExpectedDataSource(str, dataSource)) {
            releaseImage(t);
            dataSource.close();
            return;
        }
        if (checkCurrentUrlValidate(dataSource, t)) {
            try {
                Drawable createDrawable = createDrawable(t);
                T t2 = this.mFetchedImage;
                Drawable drawable = this.mDrawable;
                this.mFetchedImage = t;
                this.mDrawable = createDrawable;
                try {
                    if (z) {
                        this.mDataSource = null;
                        SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
                        if (settableDraweeHierarchy != null) {
                            settableDraweeHierarchy.setImage(createDrawable, 1.0f, z2);
                        }
                        getControllerListener().onFinalImageSet(str, getImageInfo(t), getAnimatable());
                    } else {
                        SettableDraweeHierarchy settableDraweeHierarchy2 = this.mSettableDraweeHierarchy;
                        if (settableDraweeHierarchy2 != null) {
                            settableDraweeHierarchy2.setImage(createDrawable, f, z2);
                        }
                        getControllerListener().onIntermediateImageSet(str, getImageInfo(t));
                    }
                } finally {
                    if (drawable != null && drawable != createDrawable) {
                        releaseDrawable(drawable);
                    }
                    if (t2 != null && t2 != t) {
                        releaseImage(t2);
                    }
                }
            } catch (Exception e) {
                releaseImage(t);
                onFailureInternal(str, dataSource, e, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFailureInternal(String str, DataSource<T> dataSource, Throwable th, boolean z) {
        Drawable drawable;
        if (!isExpectedDataSource(str, dataSource)) {
            dataSource.close();
            return;
        }
        if (checkCurrentUrlValidate(dataSource, null)) {
            if (z) {
                this.mDataSource = null;
                this.mHasFetchFailed = true;
                SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
                if (settableDraweeHierarchy != null) {
                    if (this.mRetainImageOnFailure && (drawable = this.mDrawable) != null) {
                        settableDraweeHierarchy.setImage(drawable, 1.0f, true);
                    } else {
                        settableDraweeHierarchy.setFailure(th);
                    }
                }
                getControllerListener().onFailure(this.mId, th);
                return;
            }
            getControllerListener().onIntermediateImageFailed(this.mId, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProgressUpdateInternal(String str, DataSource<T> dataSource, float f, boolean z) {
        SettableDraweeHierarchy settableDraweeHierarchy;
        if (!isExpectedDataSource(str, dataSource)) {
            dataSource.close();
        } else {
            if (z || (settableDraweeHierarchy = this.mSettableDraweeHierarchy) == null) {
                return;
            }
            settableDraweeHierarchy.setProgress(f, false);
        }
    }

    private boolean isExpectedDataSource(String str, DataSource<T> dataSource) {
        if (dataSource == null && this.mDataSource == null) {
            return true;
        }
        return str.equals(this.mId) && dataSource == this.mDataSource && this.mIsRequestSubmitted;
    }

    protected int getImageHash(T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("isAttached", this.mIsAttached).add("isRequestSubmitted", this.mIsRequestSubmitted).add("hasFetchFailed", this.mHasFetchFailed).add("fetchedImage", getImageHash(this.mFetchedImage)).toString();
    }

    public boolean isAttached() {
        return this.mIsAttached;
    }

    public boolean isFetchFailed() {
        return this.mHasFetchFailed;
    }

    public ImageRequest getImageRequest() {
        return this.mImageRequest;
    }

    public void setImageRequest(ImageRequest imageRequest) {
        this.mImageRequest = imageRequest;
    }

    public void setUI(WeakReference<FlattenUIImage> weakReference) {
        this.mUI = weakReference;
    }

    public void setRequestUrl(String str) {
        this.mRequestUrl = str;
    }

    public String getContentDescription() {
        return this.mContentDescription;
    }

    public void setContentDescription(String str) {
        this.mContentDescription = str;
    }
}
