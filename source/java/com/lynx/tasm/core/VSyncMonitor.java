package com.lynx.tasm.core;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.WindowManager;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.CallStackUtil;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class VSyncMonitor {
    public static final long DEFAULT_FRAME_TIME_NS = 16666666;
    private static DisplayManager.DisplayListener mDisplayListener = null;
    private static DisplayManager mDisplayManager = null;
    private static long mFrameRefreshTimeNS = -1;
    private static boolean mUseDisplayManager;
    private static WeakReference<WindowManager> mWindowManager;
    private static Choreographer sUIThreadChoreographer;

    private static native void nativeOnVSync(long j, long j2, long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class DisplayListener implements DisplayManager.DisplayListener {
        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }

        DisplayListener() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            if (i != 0 || VSyncMonitor.mDisplayManager == null) {
                return;
            }
            VSyncMonitor.updateFreshRate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateFreshRate() {
        try {
            mFrameRefreshTimeNS = 1.0E9f / mDisplayManager.getDisplay(0).getRefreshRate();
        } catch (RuntimeException e) {
            LLog.e("VSyncMonitor", "onDisplayChanged failed: " + CallStackUtil.getStackTraceStringTrimmed(e));
        }
    }

    public static void setCurrentWindowManager(WindowManager windowManager) {
        mWindowManager = new WeakReference<>(windowManager);
        mUseDisplayManager = false;
    }

    public static void setCurrentDisplayManager(DisplayManager displayManager) {
        if (displayManager != null) {
            mDisplayManager = displayManager;
            updateFreshRate();
            if (mDisplayListener == null) {
                mDisplayListener = new DisplayListener();
            }
            displayManager.registerDisplayListener(mDisplayListener, new Handler(Looper.getMainLooper()));
            mUseDisplayManager = true;
        }
    }

    public static void initUIThreadChoreographer() {
        if (sUIThreadChoreographer != null) {
            return;
        }
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.core.VSyncMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Choreographer unused = VSyncMonitor.sUIThreadChoreographer = Choreographer.getInstance();
                } catch (RuntimeException e) {
                    LLog.e("VSyncMonitor", "initUIThreadChoreographer failed: " + CallStackUtil.getStackTraceStringTrimmed(e));
                }
            }
        });
    }

    public static void request(final long j) {
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: com.lynx.tasm.core.VSyncMonitor.2
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j2) {
                VSyncMonitor.doFrame(j, j2);
            }
        });
    }

    public static void requestOnUIThread(final long j) {
        Choreographer choreographer = sUIThreadChoreographer;
        if (choreographer == null) {
            UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.core.VSyncMonitor.3
                @Override // java.lang.Runnable
                public void run() {
                    VSyncMonitor.initUIThreadChoreographer();
                    VSyncMonitor.requestOnUIThread(j);
                }
            });
        } else {
            choreographer.postFrameCallback(new Choreographer.FrameCallback() { // from class: com.lynx.tasm.core.VSyncMonitor.4
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j2) {
                    VSyncMonitor.doFrame(j, j2);
                }
            });
        }
    }

    private static long getRefreshRate() {
        if (!mUseDisplayManager) {
            try {
                mFrameRefreshTimeNS = DEFAULT_FRAME_TIME_NS;
                if (mWindowManager.get() != null) {
                    mFrameRefreshTimeNS = (long) (1.0E9d / r0.getDefaultDisplay().getRefreshRate());
                }
            } catch (RuntimeException e) {
                LLog.e("VSyncMonitor", "getRefreshRate failed: " + e.getMessage());
            }
        }
        return mFrameRefreshTimeNS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doFrame(long j, long j2) {
        nativeOnVSync(j, j2, j2 + getRefreshRate());
    }
}
