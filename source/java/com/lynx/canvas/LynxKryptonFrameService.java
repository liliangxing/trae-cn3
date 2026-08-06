package com.lynx.canvas;

import com.lynx.canvas.KryptonFrameService;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class LynxKryptonFrameService extends KryptonFrameService {
    private long mNativeFrameService;
    private ArrayList<KryptonFrameService.FrameCallback> mCallbacks = new ArrayList<>();
    private ArrayList<KryptonFrameService.FrameCallback> mBeforeVsyncEndCallbacks = new ArrayList<>();

    private native long nativeCreateFrameService(long j);

    private native void nativeDestroyFrameService(long j);

    private native void nativeDoRegisterBeforeVSyncEndListener(long j);

    private native void nativeDoRequestVSync(long j);

    @Override // com.lynx.canvas.KryptonFrameService
    public void setPreferredFramesPerSecond(long j) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LynxKryptonFrameService(long j) {
        this.mNativeFrameService = nativeCreateFrameService(j);
    }

    @Override // com.lynx.canvas.KryptonService
    public void onDestroy() {
        long j = this.mNativeFrameService;
        if (j != 0) {
            nativeDestroyFrameService(j);
            this.mNativeFrameService = 0L;
        }
    }

    @Override // com.lynx.canvas.KryptonFrameService
    public void requestVSync(KryptonFrameService.FrameCallback frameCallback) {
        if (frameCallback == null) {
            return;
        }
        this.mCallbacks.add(frameCallback);
        nativeDoRequestVSync(this.mNativeFrameService);
    }

    @Override // com.lynx.canvas.KryptonFrameService
    public void registerBeforeVSyncEndListener(KryptonFrameService.FrameCallback frameCallback) {
        this.mBeforeVsyncEndCallbacks.add(frameCallback);
        nativeDoRegisterBeforeVSyncEndListener(this.mNativeFrameService);
    }

    void OnVSync(long j) {
        ArrayList arrayList = new ArrayList(this.mCallbacks);
        this.mCallbacks.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((KryptonFrameService.FrameCallback) it.next()).doFrame(j);
        }
    }

    void OnBeforeVSyncEnd(long j) {
        Iterator<KryptonFrameService.FrameCallback> it = this.mBeforeVsyncEndCallbacks.iterator();
        while (it.hasNext()) {
            it.next().doFrame(j);
        }
    }
}
