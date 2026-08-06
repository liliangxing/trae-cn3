package com.lynx.canvas;

import com.lynx.canvas.KryptonFrameService;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class KryptonVSyncMonitor {
    private WeakReference<KryptonApp> mApp;

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnBeforeVSyncEndTrigger(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnVSyncTrigger(long j, long j2);

    public KryptonVSyncMonitor(KryptonApp kryptonApp) {
        this.mApp = new WeakReference<>(kryptonApp);
    }

    public void requestVSync(final long j) {
        KryptonFrameService kryptonFrameService;
        KryptonApp kryptonApp = this.mApp.get();
        if (kryptonApp == null || (kryptonFrameService = (KryptonFrameService) kryptonApp.getService(KryptonFrameService.class)) == null) {
            return;
        }
        kryptonFrameService.requestVSync(new KryptonFrameService.FrameCallback() { // from class: com.lynx.canvas.KryptonVSyncMonitor.1
            @Override // com.lynx.canvas.KryptonFrameService.FrameCallback
            public void doFrame(long j2) {
                KryptonVSyncMonitor.nativeOnVSyncTrigger(j, j2);
            }
        });
    }

    public void registerBeforeAnimationEnd(final long j) {
        KryptonFrameService kryptonFrameService;
        KryptonApp kryptonApp = this.mApp.get();
        if (kryptonApp == null || (kryptonFrameService = (KryptonFrameService) kryptonApp.getService(KryptonFrameService.class)) == null) {
            return;
        }
        kryptonFrameService.registerBeforeVSyncEndListener(new KryptonFrameService.FrameCallback() { // from class: com.lynx.canvas.KryptonVSyncMonitor.2
            @Override // com.lynx.canvas.KryptonFrameService.FrameCallback
            public void doFrame(long j2) {
                KryptonVSyncMonitor.nativeOnBeforeVSyncEndTrigger(j, j2);
            }
        });
    }
}
