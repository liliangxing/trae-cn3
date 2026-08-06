package com.bytedance.crash.anr;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.crash.NpthCore;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.runtime.DefaultWorkThread;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AnrSignalMonitor {
    /* JADX INFO: Access modifiers changed from: package-private */
    public void stop() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void start() {
        initOnMainThread();
        initOnSubThread();
    }

    private void initOnMainThread() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.crash.anr.AnrSignalMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                NativeBridge.anrInitOnMainThread();
            }
        });
    }

    private void initOnSubThread() {
        DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.anr.AnrSignalMonitor.2
            @Override // java.lang.Runnable
            public void run() {
                new Thread(new Runnable() { // from class: com.bytedance.crash.anr.AnrSignalMonitor.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NativeBridge.set64Bit(Header.is64BitDevice());
                        NativeBridge.setAnrDumpAsync(NpthCore.getDumpAnrAsync());
                        NativeBridge.anrEnterMonitorLooper();
                    }
                }, "NPTH-AnrMonitor").start();
            }
        });
    }
}
