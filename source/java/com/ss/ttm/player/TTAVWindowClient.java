package com.ss.ttm.player;

import android.graphics.Bitmap;
import android.view.Surface;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface TTAVWindowClient {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface SnapshotListener {
        void onResult(int result, Bitmap bitmap);
    }

    void bindExternal(ExternalInterface external);

    void bindMediaClient(MediaPlayerClient client);

    void setWindowUsage(int usage);

    void snapshotBitmap(boolean highQuality, SnapshotListener listener);

    void unbindExternal(ExternalInterface external);

    void unbindMediaClient(MediaPlayerClient client);

    void updateVideoSize(int width, int height);

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface ExternalInterface {
        void onNewWindowAvailable(Surface surface);

        void onWindowChanged(int width, int height);

        void onWindowDestroyed();

        default void snapshotBitmap(SnapshotListener listener) {
            listener.onResult(-1, null);
        }
    }
}
