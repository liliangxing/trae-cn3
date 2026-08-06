package com.bytedance.memory.handler;

import android.os.Debug;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.IOOMCallback;
import com.bytedance.crash.Npth;
import com.bytedance.memory.api.MemoryApi;
import com.bytedance.memory.common.MemoryExecutorSupplier;
import com.bytedance.memory.common.MemoryLog;
import com.bytedance.memory.dump.DumpFileController;
import com.bytedance.memory.dump.DumpFileProvider;
import com.bytedance.memory.dump.HeapDumper;
import com.bytedance.memory.event.EventUtils;
import com.bytedance.memory.heap.HeapSaver;
import com.bytedance.memory.model.MemoryWidgetConfig;
import com.bytedance.platform.thread.Constants;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class NpthHprofManager {
    private long mDumpTime;
    private volatile boolean mInited;

    private NpthHprofManager() {
    }

    public static NpthHprofManager getInstance() {
        return Holder.sInstance;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class Holder {
        private static final NpthHprofManager sInstance = new NpthHprofManager();

        private Holder() {
        }
    }

    public void init() {
        try {
            if (this.mInited) {
                return;
            }
            this.mInited = true;
            registerCrashCallBack();
            AsyncEventManager.getInstance().postDelay(new Runnable() { // from class: com.bytedance.memory.handler.NpthHprofManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        NpthHprofManager.this.checkFileExpired();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, Constants.TASK_WAIT_THRESHOLD);
            MemoryLog.m101i("registerCrashCallBack", new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void registerCrashCallBack() {
        Npth.registerHprofCallback(new IOOMCallback() { // from class: com.bytedance.memory.handler.NpthHprofManager.2
            public void onCrash(CrashType crashType, Throwable th, Thread thread, long j) {
                MemoryLog.m101i("onCrash callback", new Object[0]);
                if (th == null || (th instanceof OutOfMemoryError) || !HeapDumper.getInstance().checkStorage()) {
                    return;
                }
                NpthHprofManager.this.dumpHprof();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dumpHprof() {
        File file;
        try {
            if (System.currentTimeMillis() - this.mDumpTime < 60000) {
                return;
            }
            this.mDumpTime = System.currentTimeMillis();
            EventUtils.uploadCategoryEventImmediate(EventUtils.NPTH_DUMP_BEGIN);
            MemoryWidgetConfig.DumpShrinkConfig dumpAndShrinkConfig = MemoryApi.getInstance().getInitConfig().getDumpAndShrinkConfig();
            File npthFolder = DumpFileProvider.getInstance().getNpthFolder();
            if (dumpAndShrinkConfig != null && !EventUtils.getDumpEventNoDebug(EventUtils.CLOSE_NATIVE_DUMP_AND_SHRINK)) {
                file = new File(npthFolder, HeapSaver.NPHT_HPROF_MINI);
                if (file.exists()) {
                    file.delete();
                }
                if (!dumpAndShrinkConfig.dumpAndShrinkHprof(file)) {
                    file = new File(npthFolder, HeapSaver.NPHT_HPROF);
                    if (file.exists()) {
                        file.delete();
                    }
                    Debug.dumpHprofData(file.getAbsolutePath());
                }
            } else {
                file = new File(npthFolder, HeapSaver.NPHT_HPROF);
                if (file.exists()) {
                    file.delete();
                }
                Debug.dumpHprofData(file.getAbsolutePath());
            }
            EventUtils.uploadCategoryEventImmediate(EventUtils.NPTH_DUMP_END);
            MemoryLog.m101i("onCrash dump finish:" + file.getAbsolutePath(), new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkFileExpired() {
        if (EventUtils.getMemoryEventNoDebug(EventUtils.CLOSE_NPTH_HPROF_EXPIRED)) {
            return;
        }
        MemoryExecutorSupplier.NORMAL_SERVICE.execute(new Runnable() { // from class: com.bytedance.memory.handler.NpthHprofManager.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    File npthFolder = DumpFileProvider.getInstance().getNpthFolder();
                    if (npthFolder != null && npthFolder.exists() && npthFolder.isDirectory()) {
                        DumpFileController.getInstance().deleteExpireFile(npthFolder);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }, "checkFileExpired");
    }
}
