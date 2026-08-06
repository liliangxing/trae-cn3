package com.facebook.imagepipeline.producers;

import android.media.MediaMetadataRetriever;
import com.facebook.common.logging.FLog;

/* loaded from: classes6.dex */
public class MediaMetadataRetrieverUtils {
    public static final String TAG = "MediaMetadataRetrieverUtils";
    private static final ThreadLocal<MediaMetadataRetriever> threadLocalRetriever = new ThreadLocal<MediaMetadataRetriever>() { // from class: com.facebook.imagepipeline.producers.MediaMetadataRetrieverUtils.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public MediaMetadataRetriever initialValue() {
            return new MediaMetadataRetriever();
        }
    };

    public static MediaMetadataRetriever getRetriever() {
        ThreadLocal<MediaMetadataRetriever> threadLocal = threadLocalRetriever;
        MediaMetadataRetriever mediaMetadataRetriever = threadLocal.get();
        if (mediaMetadataRetriever != null) {
            return mediaMetadataRetriever;
        }
        MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
        threadLocal.set(mediaMetadataRetriever2);
        return mediaMetadataRetriever2;
    }

    public static void releaseRetriever() {
        ThreadLocal<MediaMetadataRetriever> threadLocal = threadLocalRetriever;
        MediaMetadataRetriever mediaMetadataRetriever = threadLocal.get();
        if (mediaMetadataRetriever != null) {
            release(mediaMetadataRetriever);
            threadLocal.remove();
        }
    }

    public static void release(MediaMetadataRetriever mediaMetadataRetriever) {
        if (mediaMetadataRetriever != null) {
            try {
                mediaMetadataRetriever.release();
            } catch (Throwable th) {
                FLog.e(TAG, "release error", th);
            }
        }
    }
}
