package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import com.facebook.common.executors.AbstractPriorityRunnable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ImageOOMOptStrategy;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessorRunner;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class PostprocessorProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String NAME = "PostprocessorProducer";
    static final String POSTPROCESSOR = "Postprocessor";
    public static final String STRATEGY_CENTER = "strategy_center";
    private final PlatformBitmapFactory mBitmapFactory;
    private final Executor mExecutor;
    private final Producer<CloseableReference<CloseableImage>> mInputProducer;

    public PostprocessorProducer(Producer<CloseableReference<CloseableImage>> producer, PlatformBitmapFactory platformBitmapFactory, Executor executor) {
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mBitmapFactory = platformBitmapFactory;
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        Consumer<CloseableReference<CloseableImage>> singleUsePostprocessorConsumer;
        ProducerListener listener = producerContext.getListener();
        Postprocessor postprocessor = producerContext.getImageRequest().getPostprocessor();
        PostprocessorConsumer postprocessorConsumer = new PostprocessorConsumer(consumer, listener, producerContext.getId(), postprocessor, producerContext);
        if (postprocessor instanceof RepeatedPostprocessor) {
            singleUsePostprocessorConsumer = new RepeatedPostprocessorConsumer(postprocessorConsumer, (RepeatedPostprocessor) postprocessor, producerContext);
        } else {
            singleUsePostprocessorConsumer = new SingleUsePostprocessorConsumer(postprocessorConsumer);
        }
        this.mInputProducer.produceResults(singleUsePostprocessorConsumer, producerContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class PostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        private boolean mIsClosed;
        private boolean mIsDirty;
        private boolean mIsPostProcessingRunning;
        private final ProducerListener mListener;
        private final Postprocessor mPostprocessor;
        private final ProducerContext mProducerContext;
        private final String mRequestId;

        @Nullable
        private CloseableReference<CloseableImage> mSourceImageRef;
        private int mStatus;

        public PostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> consumer, ProducerListener producerListener, String str, Postprocessor postprocessor, ProducerContext producerContext) {
            super(consumer);
            this.mSourceImageRef = null;
            this.mStatus = 0;
            this.mIsDirty = false;
            this.mIsPostProcessingRunning = false;
            this.mListener = producerListener;
            this.mRequestId = str;
            this.mPostprocessor = postprocessor;
            this.mProducerContext = producerContext;
            producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.1
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    PostprocessorConsumer.this.maybeNotifyOnCancellation();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            if (!CloseableReference.isValid(closeableReference)) {
                if (isLast(i)) {
                    maybeNotifyOnNewResult(null, i);
                    return;
                }
                return;
            }
            updateSourceImageRef(closeableReference, i);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onFailureImpl(Throwable th) {
            maybeNotifyOnFailure(th);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onCancellationImpl() {
            maybeNotifyOnCancellation();
        }

        private void updateSourceImageRef(@Nullable CloseableReference<CloseableImage> closeableReference, int i) {
            synchronized (this) {
                if (this.mIsClosed) {
                    return;
                }
                CloseableReference<CloseableImage> closeableReference2 = this.mSourceImageRef;
                this.mSourceImageRef = CloseableReference.cloneOrNull(closeableReference);
                this.mStatus = i;
                this.mIsDirty = true;
                boolean runningIfDirtyAndNotRunning = setRunningIfDirtyAndNotRunning();
                CloseableReference.closeSafely(closeableReference2);
                if (runningIfDirtyAndNotRunning) {
                    submitPostprocessing();
                }
            }
        }

        private void submitPostprocessing() {
            PostprocessorProducer.this.mExecutor.execute(new AbstractPriorityRunnable(Priority.getIntPriorityValue(this.mProducerContext.getPriority())) { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.2
                @Override // java.lang.Runnable
                public void run() {
                    CloseableReference closeableReference;
                    int i;
                    synchronized (PostprocessorConsumer.this) {
                        closeableReference = PostprocessorConsumer.this.mSourceImageRef;
                        i = PostprocessorConsumer.this.mStatus;
                        PostprocessorConsumer.this.mSourceImageRef = null;
                        PostprocessorConsumer.this.mIsDirty = false;
                    }
                    if (CloseableReference.isValid(closeableReference)) {
                        try {
                            PostprocessorConsumer.this.doPostprocessing(closeableReference, i);
                        } finally {
                            CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                        }
                    }
                    PostprocessorConsumer.this.clearRunningAndStartIfDirty();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRunningAndStartIfDirty() {
            boolean runningIfDirtyAndNotRunning;
            synchronized (this) {
                this.mIsPostProcessingRunning = false;
                runningIfDirtyAndNotRunning = setRunningIfDirtyAndNotRunning();
            }
            if (runningIfDirtyAndNotRunning) {
                submitPostprocessing();
            }
        }

        private synchronized boolean setRunningIfDirtyAndNotRunning() {
            if (this.mIsClosed || !this.mIsDirty || this.mIsPostProcessingRunning || !CloseableReference.isValid(this.mSourceImageRef)) {
                return false;
            }
            this.mIsPostProcessingRunning = true;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doPostprocessing(CloseableReference<CloseableImage> closeableReference, int i) {
            Preconditions.checkArgument(CloseableReference.isValid(closeableReference));
            if (!shouldPostprocess(closeableReference.get(), this.mPostprocessor)) {
                maybeNotifyOnNewResult(closeableReference, i);
                return;
            }
            HashMap hashMap = new HashMap();
            this.mListener.onProducerStart(this.mRequestId, PostprocessorProducer.NAME);
            try {
                try {
                    CloseableReference<CloseableImage> postprocessInternal = postprocessInternal(closeableReference.get(), hashMap);
                    ProducerListener producerListener = this.mListener;
                    String str = this.mRequestId;
                    producerListener.onProducerFinishWithSuccess(str, PostprocessorProducer.NAME, getExtraMap(producerListener, str, this.mPostprocessor, hashMap));
                    maybeNotifyOnNewResult(postprocessInternal, i);
                    CloseableReference.closeSafely(postprocessInternal);
                } catch (Exception e) {
                    ProducerListener producerListener2 = this.mListener;
                    String str2 = this.mRequestId;
                    producerListener2.onProducerFinishWithFailure(str2, PostprocessorProducer.NAME, e, getExtraMap(producerListener2, str2, this.mPostprocessor, hashMap));
                    maybeNotifyOnFailure(e);
                    CloseableReference.closeSafely((CloseableReference<?>) null);
                } catch (OutOfMemoryError e2) {
                    ImageOOMOptStrategy strategy = ImageOOMOptStrategy.getStrategy();
                    if (strategy != null && strategy.isEnablePostProcessorOOMOpt()) {
                        ProducerListener producerListener3 = this.mListener;
                        String str3 = this.mRequestId;
                        producerListener3.onProducerFinishWithSuccess(str3, PostprocessorProducer.NAME, getExtraMap(producerListener3, str3, this.mPostprocessor, hashMap));
                        maybeNotifyOnNewResult(closeableReference, i);
                        strategy.optMemoryWhenPostProcessorOOM();
                        CloseableReference.closeSafely((CloseableReference<?>) null);
                        return;
                    }
                    throw e2;
                }
            } catch (Throwable th) {
                CloseableReference.closeSafely((CloseableReference<?>) null);
                throw th;
            }
        }

        private Map<String, String> getExtraMap(ProducerListener producerListener, String str, Postprocessor postprocessor, Map<String, String> map) {
            if (!producerListener.requiresExtraMap(str)) {
                return null;
            }
            map.put(PostprocessorProducer.POSTPROCESSOR, postprocessor.getName());
            return Collections.unmodifiableMap(map);
        }

        private boolean shouldPostprocess(CloseableImage closeableImage) {
            return closeableImage instanceof CloseableStaticBitmap;
        }

        private boolean shouldPostprocess(CloseableImage closeableImage, Postprocessor postprocessor) {
            return closeableImage instanceof CloseableStaticBitmap;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0108  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x010a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private CloseableReference<CloseableImage> postprocessInternal(CloseableImage closeableImage, Map<String, String> map) {
            CloseableReference<Bitmap> process;
            CloseableReference<Bitmap> closeableReference;
            int i;
            int i2;
            ProducerContext producerContext;
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
            Bitmap underlyingBitmap = closeableStaticBitmap.getUnderlyingBitmap();
            Postprocessor postprocessor = this.mPostprocessor;
            try {
                if (!(postprocessor instanceof BasePostprocessor)) {
                    process = postprocessor.process(underlyingBitmap, PostprocessorProducer.this.mBitmapFactory);
                } else if (postprocessor != null && "SRPostProcessor".equalsIgnoreCase(postprocessor.getName())) {
                    float calScaleRatio = calScaleRatio(underlyingBitmap);
                    if (closeableStaticBitmap.getExtraMap() != null) {
                        map.putAll(closeableStaticBitmap.getExtraMap());
                    }
                    map.put("sr_stretch", String.valueOf(calScaleRatio));
                    process = ((BasePostprocessor) this.mPostprocessor).process(underlyingBitmap, PostprocessorProducer.this.mBitmapFactory, map);
                } else {
                    Postprocessor postprocessor2 = this.mPostprocessor;
                    if (postprocessor2 == null || !"IterativeBoxBlurPostProcessor".equalsIgnoreCase(postprocessor2.getName()) || !underlyingBitmap.getConfig().equals(Bitmap.Config.RGB_565) || (producerContext = this.mProducerContext) == null || producerContext.getImageRequest() == null || SimplayerImageStrategy.getStrategy() == null || SimplayerImageStrategy.getStrategy().getIntValue(1000, this.mProducerContext.getImageRequest().getSourceUri().toString(), 0) != 1) {
                        process = ((BasePostprocessor) this.mPostprocessor).process(underlyingBitmap, PostprocessorProducer.this.mBitmapFactory, map);
                    } else {
                        if (SimplayerImageStrategy.isOpenLog()) {
                            Log.d(SimplayerImageStrategy.TAG, "is IterativeBoxBlurPostProcessor, and bitmap is RGB_565, so skip postprocessor");
                        }
                        CloseableReference<Bitmap> cloneUnderlyingBitmapReference = closeableStaticBitmap.cloneUnderlyingBitmapReference();
                        if (SimplayerImageStrategy.isUploadLog() && map != null) {
                            try {
                                String str = map.get(PostprocessorProducer.STRATEGY_CENTER);
                                JSONObject jSONObject = str == null ? new JSONObject() : new JSONObject(str);
                                jSONObject.put("skip_post_processor", 1);
                                map.put(PostprocessorProducer.STRATEGY_CENTER, jSONObject.toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        closeableReference = cloneUnderlyingBitmapReference;
                        int rotationAngle = closeableStaticBitmap.getRotationAngle();
                        int exifOrientation = closeableStaticBitmap.getExifOrientation();
                        Rect regionToDecode = closeableStaticBitmap.getRegionToDecode();
                        Rect smartCrop = closeableStaticBitmap.getSmartCrop();
                        int sampleSize = closeableStaticBitmap.getSampleSize();
                        if (closeableImage.isRequestInternet()) {
                            if (closeableImage.isHitDiskCache()) {
                                i = 2;
                            } else if (closeableImage.isHitEncodeMemoryCache()) {
                                i2 = 1;
                            } else {
                                i = closeableImage.isHitBitmapMemoryCache() ? 3 : -1;
                            }
                            i2 = i;
                        } else {
                            i2 = 0;
                        }
                        return CloseableReference.m496of(new CloseableStaticBitmap(closeableReference, closeableImage.getQualityInfo(), rotationAngle, exifOrientation, regionToDecode, smartCrop, sampleSize, closeableImage.getImageFormat(), i2, map));
                    }
                }
                return CloseableReference.m496of(new CloseableStaticBitmap(closeableReference, closeableImage.getQualityInfo(), rotationAngle, exifOrientation, regionToDecode, smartCrop, sampleSize, closeableImage.getImageFormat(), i2, map));
            } finally {
                CloseableReference.closeSafely(closeableReference);
            }
            closeableReference = process;
            int rotationAngle2 = closeableStaticBitmap.getRotationAngle();
            int exifOrientation2 = closeableStaticBitmap.getExifOrientation();
            Rect regionToDecode2 = closeableStaticBitmap.getRegionToDecode();
            Rect smartCrop2 = closeableStaticBitmap.getSmartCrop();
            int sampleSize2 = closeableStaticBitmap.getSampleSize();
            if (closeableImage.isRequestInternet()) {
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0097, code lost:
        
            if (r9 < 2.0f) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00be, code lost:
        
            return 2.0f;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
        
            return 1.5f;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00b9, code lost:
        
            if (r9 <= 1.5f) goto L60;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private float calScaleRatio(Bitmap bitmap) {
            ProducerContext producerContext;
            SizeDeterminer sizeDeterminer;
            View view;
            if (bitmap == null || (producerContext = this.mProducerContext) == null || producerContext.getImageRequest() == null) {
                return 1.0f;
            }
            int targetWidth = this.mProducerContext.getImageRequest().getTargetWidth();
            int targetHeight = this.mProducerContext.getImageRequest().getTargetHeight();
            if ((targetWidth <= 0 || targetHeight <= 0) && (sizeDeterminer = this.mProducerContext.getImageRequest().getSizeDeterminer()) != null && (view = sizeDeterminer.getView()) != null && view.getWidth() > 0 && view.getHeight() > 0) {
                targetWidth = view.getWidth();
                targetHeight = view.getHeight();
            }
            if (targetWidth <= 0 || targetHeight <= 0) {
                return 1.0f;
            }
            float max = Math.max((targetWidth * 1.0f) / bitmap.getWidth(), (targetHeight * 1.0f) / bitmap.getHeight());
            if (FrescoCacheMonitorUtil.isSRAutoScaleLowerFirst()) {
                if (max <= 1.0f) {
                    return 1.0f;
                }
                if (max >= 1.2f) {
                    if (max >= 1.3f) {
                        if (max >= 1.4f) {
                            if (max >= 1.5f) {
                            }
                            return 1.4f;
                        }
                        return 1.3f;
                    }
                    return 1.2f;
                }
                return 1.1f;
            }
            if (max <= 1.0f) {
                return 1.0f;
            }
            if (max > 1.1f) {
                if (max > 1.2f) {
                    if (max > 1.3f) {
                        if (max > 1.4f) {
                        }
                        return 1.4f;
                    }
                    return 1.3f;
                }
                return 1.2f;
            }
            return 1.1f;
        }

        private void maybeNotifyOnNewResult(CloseableReference<CloseableImage> closeableReference, int i) {
            boolean isLast = isLast(i);
            if ((isLast || isClosed()) && !(isLast && close())) {
                return;
            }
            getConsumer().onNewResult(closeableReference, i);
        }

        private void maybeNotifyOnFailure(Throwable th) {
            if (close()) {
                getConsumer().onFailure(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void maybeNotifyOnCancellation() {
            if (close()) {
                getConsumer().onCancellation();
            }
        }

        private synchronized boolean isClosed() {
            return this.mIsClosed;
        }

        private boolean close() {
            synchronized (this) {
                if (this.mIsClosed) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.mSourceImageRef;
                this.mSourceImageRef = null;
                this.mIsClosed = true;
                CloseableReference.closeSafely(closeableReference);
                return true;
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    class SingleUsePostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        private SingleUsePostprocessorConsumer(PostprocessorConsumer postprocessorConsumer) {
            super(postprocessorConsumer);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            if (isNotLast(i)) {
                return;
            }
            getConsumer().onNewResult(closeableReference, i);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    class RepeatedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> implements RepeatedPostprocessorRunner {
        private boolean mIsClosed;

        @Nullable
        private CloseableReference<CloseableImage> mSourceImageRef;

        private RepeatedPostprocessorConsumer(PostprocessorConsumer postprocessorConsumer, RepeatedPostprocessor repeatedPostprocessor, ProducerContext producerContext) {
            super(postprocessorConsumer);
            this.mIsClosed = false;
            this.mSourceImageRef = null;
            repeatedPostprocessor.setCallback(this);
            producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.RepeatedPostprocessorConsumer.1
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    if (RepeatedPostprocessorConsumer.this.close()) {
                        RepeatedPostprocessorConsumer.this.getConsumer().onCancellation();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            if (isNotLast(i)) {
                return;
            }
            setSourceImageRef(closeableReference);
            updateInternal();
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onFailureImpl(Throwable th) {
            if (close()) {
                getConsumer().onFailure(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onCancellationImpl() {
            if (close()) {
                getConsumer().onCancellation();
            }
        }

        @Override // com.facebook.imagepipeline.request.RepeatedPostprocessorRunner
        public synchronized void update() {
            updateInternal();
        }

        private void updateInternal() {
            synchronized (this) {
                if (this.mIsClosed) {
                    return;
                }
                CloseableReference<CloseableImage> cloneOrNull = CloseableReference.cloneOrNull(this.mSourceImageRef);
                try {
                    getConsumer().onNewResult(cloneOrNull, 0);
                } finally {
                    CloseableReference.closeSafely(cloneOrNull);
                }
            }
        }

        private void setSourceImageRef(CloseableReference<CloseableImage> closeableReference) {
            synchronized (this) {
                if (this.mIsClosed) {
                    return;
                }
                CloseableReference<CloseableImage> closeableReference2 = this.mSourceImageRef;
                this.mSourceImageRef = CloseableReference.cloneOrNull(closeableReference);
                CloseableReference.closeSafely(closeableReference2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean close() {
            synchronized (this) {
                if (this.mIsClosed) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.mSourceImageRef;
                this.mSourceImageRef = null;
                this.mIsClosed = true;
                CloseableReference.closeSafely(closeableReference);
                return true;
            }
        }
    }
}
