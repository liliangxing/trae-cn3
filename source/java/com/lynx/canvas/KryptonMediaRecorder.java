package com.lynx.canvas;

import android.view.Surface;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public interface KryptonMediaRecorder {

    /* loaded from: classes6.dex */
    public interface Listener {
        void onClipVideoEnd(KryptonMediaRecorder kryptonMediaRecorder, String str, String str2, float f, long j);

        void onClipVideoEndWithError(KryptonMediaRecorder kryptonMediaRecorder, String str);

        void onRecordFlush(KryptonMediaRecorder kryptonMediaRecorder);

        void onRecordStartError(KryptonMediaRecorder kryptonMediaRecorder, String str);

        void onRecordStop(KryptonMediaRecorder kryptonMediaRecorder, String str, String str2, float f, long j);

        void onRecordStopWithError(KryptonMediaRecorder kryptonMediaRecorder, String str);
    }

    boolean clipVideo(long[] jArr);

    void configAudio(int i, int i2, int i3);

    void configVideo(String str, int i, int i2, int i3, int i4, int i5);

    void destroy(boolean z);

    long lastPresentationTime();

    void onAudioSample(ByteBuffer byteBuffer, int i);

    void pauseRecord();

    void resumeRecord();

    void setListener(Listener listener);

    Surface startRecord();

    void stopRecord();
}
