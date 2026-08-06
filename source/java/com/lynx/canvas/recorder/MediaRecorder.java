package com.lynx.canvas.recorder;

import android.view.Surface;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonMediaRecorder;
import com.lynx.canvas.KryptonMediaRecorderService;
import java.nio.ByteBuffer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class MediaRecorder implements KryptonMediaRecorder.Listener {
    public static final String TAG = "KryptonMediaRecorder";
    private final KryptonApp mKryptonApp;
    private volatile long mNativePtr;
    private KryptonMediaRecorder mRecorderImpl;

    private native void nativeNotifyClipEndWithError(long j, String str);

    private native void nativeNotifyClipEndWithResult(long j, String str, String str2, float f, long j2);

    private native void nativeNotifyFlushRecord(long j);

    private native void nativeNotifyStartError(long j, String str);

    private native void nativeNotifyStopWithError(long j, String str);

    private native void nativeNotifyStopWithResult(long j, String str, String str2, float f, long j2);

    static MediaRecorder create(long j, KryptonApp kryptonApp) {
        return new MediaRecorder(j, kryptonApp);
    }

    MediaRecorder(long j, KryptonApp kryptonApp) {
        this.mNativePtr = j;
        this.mKryptonApp = kryptonApp;
        KryptonMediaRecorder createMediaRecorder = createMediaRecorder();
        this.mRecorderImpl = createMediaRecorder;
        createMediaRecorder.setListener(this);
    }

    private KryptonMediaRecorder createMediaRecorder() {
        KryptonMediaRecorderService kryptonMediaRecorderService = (KryptonMediaRecorderService) this.mKryptonApp.getService(KryptonMediaRecorderService.class);
        if (kryptonMediaRecorderService == null) {
            KryptonLLog.m2560e("KryptonMediaRecorder", "media recorder service not found");
            return null;
        }
        KryptonMediaRecorder createMediaRecorder = kryptonMediaRecorderService.createMediaRecorder();
        if (createMediaRecorder != null) {
            return createMediaRecorder;
        }
        KryptonLLog.m2560e("KryptonMediaRecorder", "service create media recorder return null");
        return null;
    }

    void configVideo(String str, int i, int i2, int i3, int i4, int i5) {
        this.mRecorderImpl.configVideo(str, i, i2, i3, i4, i5);
    }

    void configAudio(int i, int i2, int i3) {
        KryptonLLog.m2561i("KryptonMediaRecorder", "use audio");
        this.mRecorderImpl.configAudio(i, i2, i3);
    }

    Surface startRecord() {
        KryptonLLog.m2561i("KryptonMediaRecorder", "start record");
        return this.mRecorderImpl.startRecord();
    }

    void stopRecord() {
        KryptonLLog.m2561i("KryptonMediaRecorder", "stop record");
        this.mRecorderImpl.stopRecord();
    }

    void pauseRecord() {
        KryptonLLog.m2561i("KryptonMediaRecorder", "pause record");
        this.mRecorderImpl.pauseRecord();
    }

    void resumeRecord() {
        KryptonLLog.m2561i("KryptonMediaRecorder", "resume record");
        this.mRecorderImpl.resumeRecord();
    }

    synchronized void destroy(boolean z) {
        KryptonLLog.m2561i("KryptonMediaRecorder", WebViewContainer.EVENT_destroy);
        this.mNativePtr = 0L;
        this.mRecorderImpl.destroy(z);
    }

    long lastPresentationTime() {
        return this.mRecorderImpl.lastPresentationTime();
    }

    void onAudioSample(ByteBuffer byteBuffer, int i) {
        this.mRecorderImpl.onAudioSample(byteBuffer, i);
    }

    boolean clipVideo(long[] jArr) {
        KryptonLLog.m2561i("KryptonMediaRecorder", "clip video");
        return this.mRecorderImpl.clipVideo(jArr);
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder.Listener
    public synchronized void onRecordStartError(KryptonMediaRecorder kryptonMediaRecorder, String str) {
        if (this.mNativePtr != 0) {
            KryptonLLog.m2563w("KryptonMediaRecorder", "on recorder start error " + str);
            nativeNotifyStartError(this.mNativePtr, str);
        }
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder.Listener
    public synchronized void onRecordStopWithError(KryptonMediaRecorder kryptonMediaRecorder, String str) {
        if (this.mNativePtr != 0) {
            KryptonLLog.m2563w("KryptonMediaRecorder", "on recorder stop with error " + str);
            nativeNotifyStopWithError(this.mNativePtr, str);
        }
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder.Listener
    public synchronized void onRecordStop(KryptonMediaRecorder kryptonMediaRecorder, String str, String str2, float f, long j) {
        if (this.mNativePtr != 0) {
            KryptonLLog.m2561i("KryptonMediaRecorder", "on recorder stop with result. duration:" + f + ", size:" + j);
            nativeNotifyStopWithResult(this.mNativePtr, str, str2, f, j);
        }
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder.Listener
    public synchronized void onRecordFlush(KryptonMediaRecorder kryptonMediaRecorder) {
        if (this.mNativePtr != 0) {
            nativeNotifyFlushRecord(this.mNativePtr);
        }
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder.Listener
    public synchronized void onClipVideoEndWithError(KryptonMediaRecorder kryptonMediaRecorder, String str) {
        if (this.mNativePtr != 0) {
            KryptonLLog.m2563w("KryptonMediaRecorder", "on recorder clip end with error " + str);
            nativeNotifyClipEndWithError(this.mNativePtr, str);
        }
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder.Listener
    public synchronized void onClipVideoEnd(KryptonMediaRecorder kryptonMediaRecorder, String str, String str2, float f, long j) {
        if (this.mNativePtr != 0) {
            KryptonLLog.m2561i("KryptonMediaRecorder", "on recorder clip end with result. duration:" + f + ", size:" + j);
            nativeNotifyClipEndWithResult(this.mNativePtr, str, str2, f, j);
        }
    }
}
