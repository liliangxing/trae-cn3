package com.ss.bytertc.base.media;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.bytedance.realx.base.RXLogging;
import com.ss.bytertc.base.media.RTCVSyncHelper;

/* loaded from: classes7.dex */
public class RTCVSyncHelper {
    public static Object registerVSyncCallback(long nativeCallbackHandle, String renderTaskUUID) {
        if (nativeCallbackHandle == 0) {
            return null;
        }
        final ChoreographerFrameCallback choreographerFrameCallback = new ChoreographerFrameCallback();
        choreographerFrameCallback.nativeCallbackHandle = nativeCallbackHandle;
        choreographerFrameCallback.renderTaskUUID = renderTaskUUID;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ss.bytertc.base.media.RTCVSyncHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RTCVSyncHelper.lambda$registerVSyncCallback$0(RTCVSyncHelper.ChoreographerFrameCallback.this);
            }
        });
        return choreographerFrameCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$registerVSyncCallback$0(ChoreographerFrameCallback choreographerFrameCallback) {
        Choreographer choreographer = Choreographer.getInstance();
        if (choreographer != null) {
            choreographer.postFrameCallback(choreographerFrameCallback);
        } else {
            RXLogging.e("RTCVSyncHelper", "Choreographer.getInstance() return null");
        }
    }

    public static void unregisterVSyncCallback(Object vsyncCallback) {
        if (vsyncCallback instanceof ChoreographerFrameCallback) {
            ((ChoreographerFrameCallback) vsyncCallback).resetCallback();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class ChoreographerFrameCallback implements Choreographer.FrameCallback {
        public long nativeCallbackHandle = 0;
        public String renderTaskUUID;

        ChoreographerFrameCallback() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long frameTimeNanos) {
            if (this.nativeCallbackHandle != 0) {
                Choreographer choreographer = Choreographer.getInstance();
                if (choreographer != null) {
                    choreographer.postFrameCallback(this);
                }
                RTCNativeFunctions.nativeNotifyVSyncDoFrame(this.nativeCallbackHandle, this.renderTaskUUID);
            }
        }

        public void resetCallback() {
            this.nativeCallbackHandle = 0L;
        }
    }
}
