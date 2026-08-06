package com.ss.bytertc.engine.video;

import android.graphics.Bitmap;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.StreamIndex;

/* loaded from: classes7.dex */
public interface ISnapshotResultCallback {
    void onTakeLocalSnapshotResult(long taskId, StreamIndex streamIndex, Bitmap image, int errorCode);

    void onTakeRemoteSnapshotResult(long taskId, RemoteStreamKey streamKey, Bitmap image, int errorCode);
}
