package com.bytedance.memory.handler;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.IOOMCallback;
import com.bytedance.memory.dump.DumpFileProvider;
import com.bytedance.memory.dump.HeapDumper;
import com.bytedance.memory.event.EventUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MemoryWidgetOomCallBack implements IOOMCallback {
    public void onCrash(CrashType crashType, Throwable th, Thread thread, long j) {
        try {
            EventUtils.uploadCategoryEvent("onCrash");
            if (DumpFileProvider.getInstance().pendingHeapMarkFileExist()) {
                return;
            }
            HeapDumper.getInstance().dumpHeap(j);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
