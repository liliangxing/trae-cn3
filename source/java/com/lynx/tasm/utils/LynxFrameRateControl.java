package com.lynx.tasm.utils;

import android.util.Log;
import android.view.Choreographer;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class LynxFrameRateControl {
    private static final long VSYNC_FRAME = 62;
    private Choreographer mChoreographer;
    private WeakReference<VSyncListener> mListener;
    private boolean mPreState;
    private boolean mRunning = false;
    private final Choreographer.FrameCallback mVSyncFrameCallback;

    /* loaded from: classes7.dex */
    public interface VSyncListener {
        void OnVSync(long j);
    }

    public LynxFrameRateControl(VSyncListener vSyncListener) {
        this.mListener = new WeakReference<>(vSyncListener);
        try {
            this.mChoreographer = Choreographer.getInstance();
        } catch (Throwable unused) {
            Log.e("lynx", "Choreographer.getInstance got exception");
        }
        this.mVSyncFrameCallback = new Choreographer.FrameCallback() { // from class: com.lynx.tasm.utils.LynxFrameRateControl.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                VSyncListener vSyncListener2;
                if (LynxFrameRateControl.this.mListener == null || (vSyncListener2 = (VSyncListener) LynxFrameRateControl.this.mListener.get()) == null) {
                    return;
                }
                try {
                    vSyncListener2.OnVSync(j);
                    LynxFrameRateControl.this.mChoreographer.postFrameCallback(LynxFrameRateControl.this.mVSyncFrameCallback);
                } catch (Throwable th) {
                    Log.e("LynxFrameRateControl", "VSync callback exception:" + th.toString());
                }
            }
        };
    }

    public void start() {
        if (this.mRunning) {
            return;
        }
        Choreographer choreographer = this.mChoreographer;
        if (choreographer != null) {
            try {
                choreographer.postFrameCallback(this.mVSyncFrameCallback);
            } catch (Throwable th) {
                Log.e("LynxFrameRateControl", "VSync postFrameCallback exception:" + th.toString());
            }
        }
        Log.d("LynxFrameRateControl", "real start");
        this.mRunning = true;
    }

    public void stop() {
        Log.d("LynxFrameRateControl", "stop");
        Choreographer choreographer = this.mChoreographer;
        if (choreographer != null) {
            try {
                choreographer.removeFrameCallback(this.mVSyncFrameCallback);
            } catch (Throwable th) {
                Log.e("LynxFrameRateControl", "VSync removeFrameCallback exception:" + th.toString());
            }
        }
        this.mRunning = false;
    }

    public void onScreenOff() {
        boolean z = this.mRunning;
        this.mPreState = z;
        if (z) {
            stop();
        }
    }

    public void onScreenOn() {
        if (this.mPreState) {
            start();
        }
    }
}
