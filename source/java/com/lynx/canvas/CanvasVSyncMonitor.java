package com.lynx.canvas;

import com.lynx.canvas.KryptonFrameService;

/* loaded from: classes6.dex */
public class CanvasVSyncMonitor {
    private KryptonFrameService mFrameService;

    private static native void nativeOnVSync(long j, long j2);

    public void setFrameService(KryptonFrameService kryptonFrameService) {
        this.mFrameService = kryptonFrameService;
    }

    public void requestVSync(final long j) {
        KryptonFrameService kryptonFrameService = this.mFrameService;
        if (kryptonFrameService != null) {
            kryptonFrameService.requestVSync(new KryptonFrameService.FrameCallback() { // from class: com.lynx.canvas.CanvasVSyncMonitor.1
                @Override // com.lynx.canvas.KryptonFrameService.FrameCallback
                public void doFrame(long j2) {
                    CanvasVSyncMonitor.doFrame(j, j2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doFrame(long j, long j2) {
        nativeOnVSync(j, j2);
    }
}
