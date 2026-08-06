package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.os.CancellationSignal;
import android.util.Size;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LocalContentUriThumbnailProducer implements Producer<CloseableReference<CloseableImage>> {
    private static final String CREATED_THUMBNAIL = "createdThumbnail";
    public static final String PRODUCER_NAME = "LocalThumbnailBitmapProducer";
    private final ContentResolver mContentResolver;
    private final Executor mExecutor;

    public LocalContentUriThumbnailProducer(Executor executor, ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        final ProducerListener listener = producerContext.getListener();
        final String id = producerContext.getId();
        final ImageRequest imageRequest = producerContext.getImageRequest();
        final CancellationSignal cancellationSignal = new CancellationSignal();
        final StatefulProducerRunnable<CloseableReference<CloseableImage>> statefulProducerRunnable = new StatefulProducerRunnable<CloseableReference<CloseableImage>>(consumer, listener, PRODUCER_NAME, id) { // from class: com.facebook.imagepipeline.producers.LocalContentUriThumbnailProducer.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void onSuccess(@Nullable CloseableReference<CloseableImage> closeableReference) {
                super.onSuccess((C03241) closeableReference);
                listener.onUltimateProducerReached(id, LocalContentUriThumbnailProducer.PRODUCER_NAME, closeableReference != null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void onFailure(Exception exc) {
                super.onFailure(exc);
                listener.onUltimateProducerReached(id, LocalContentUriThumbnailProducer.PRODUCER_NAME, false);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.executors.StatefulRunnable
            @Nullable
            public CloseableReference<CloseableImage> getResult() throws IOException {
                Bitmap loadThumbnail = LocalContentUriThumbnailProducer.this.mContentResolver.loadThumbnail(imageRequest.getSourceUri(), new Size(imageRequest.getPreferredWidth(), imageRequest.getPreferredHeight()), cancellationSignal);
                if (loadThumbnail == null) {
                    return null;
                }
                return CloseableReference.m496of(new CloseableStaticBitmap(loadThumbnail, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void onCancellation() {
                super.onCancellation();
                cancellationSignal.cancel();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public Map<String, String> getExtraMapOnSuccess(@Nullable CloseableReference<CloseableImage> closeableReference) {
                return ImmutableMap.m414of(LocalContentUriThumbnailProducer.CREATED_THUMBNAIL, String.valueOf(closeableReference != null));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void disposeResult(@Nullable CloseableReference<CloseableImage> closeableReference) {
                CloseableReference.closeSafely(closeableReference);
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.LocalContentUriThumbnailProducer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                statefulProducerRunnable.cancel();
            }
        });
        this.mExecutor.execute(statefulProducerRunnable);
    }
}
