package com.lynx.animax.player;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.lynx.animax.util.AnimaXLog;

/* loaded from: classes6.dex */
public class CodecThreadManager {
    private static final String DEFAULT_THREAD_NAME = "Animax_Codec";
    private static final String TAG = "CodecThreadManager";
    private static CodecThreadManager sInstance;
    private HandlerThread mCodecThread;
    private Handler mCodecThreadHandler;

    private CodecThreadManager() {
    }

    public static synchronized CodecThreadManager getInstance() {
        CodecThreadManager codecThreadManager;
        synchronized (CodecThreadManager.class) {
            if (sInstance == null) {
                CodecThreadManager codecThreadManager2 = new CodecThreadManager();
                sInstance = codecThreadManager2;
                codecThreadManager2.init();
            }
            codecThreadManager = sInstance;
        }
        return codecThreadManager;
    }

    private void init() {
        if (this.mCodecThread == null) {
            HandlerThread handlerThread = new HandlerThread(DEFAULT_THREAD_NAME, -4);
            this.mCodecThread = handlerThread;
            handlerThread.start();
            this.mCodecThreadHandler = new Handler(this.mCodecThread.getLooper());
        }
    }

    public void runNowOrPostToCodecThread(Runnable runnable) {
        if (this.mCodecThreadHandler == null) {
            AnimaXLog.e(TAG, "Attempted to post to codec thread after it was released or not alive.");
        } else if (Looper.myLooper() == this.mCodecThreadHandler.getLooper()) {
            runnable.run();
        } else {
            this.mCodecThreadHandler.post(runnable);
        }
    }

    public void postAtFrontAndClearQueue(Runnable runnable) {
        Handler handler = this.mCodecThreadHandler;
        if (handler == null) {
            AnimaXLog.e(TAG, "Attempted to post to codec thread after it was released or not alive.");
        } else {
            handler.removeCallbacksAndMessages(null);
            this.mCodecThreadHandler.postAtFrontOfQueue(runnable);
        }
    }

    public void ensureOnCodecThread() {
        if (this.mCodecThreadHandler == null || Looper.myLooper() != this.mCodecThreadHandler.getLooper()) {
            throw new IllegalStateException("Must be called on codec thread (Animax_Codec), current: " + Thread.currentThread().getName());
        }
    }
}
