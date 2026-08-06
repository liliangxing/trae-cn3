package com.bytedance.memory.dump;

import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.apm.util.FileUtils;
import com.bytedance.crash.Npth;
import com.bytedance.memory.api.MemoryApi;
import com.bytedance.memory.common.MemoryExecutorSupplier;
import com.bytedance.memory.common.MemoryLog;
import com.bytedance.memory.common.MemoryWidgetGlobal;
import com.bytedance.memory.common.ZipUtil;
import com.bytedance.memory.event.EventUtils;
import com.bytedance.memory.heap.HeapDump;
import com.bytedance.memory.heap.HeapSaver;
import com.bytedance.memory.model.MemoryWidgetConfig;
import com.bytedance.memory.watcher.MemoryChecker;
import com.bytedance.services.apm.api.EnsureManager;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class HeapDumper {
    private static final float DUMP_VALUE = 1.5f;
    private static final File RETRY_LATER = null;
    private static DumpFileProvider mProvider;
    private static volatile HeapDumper sHeapDumper;
    private long mCrashTime = System.currentTimeMillis();
    private Context mContext = MemoryApi.getInstance().getContext();

    private HeapDumper() {
    }

    public static HeapDumper getInstance() {
        if (sHeapDumper == null) {
            synchronized (HeapDumper.class) {
                if (sHeapDumper == null) {
                    sHeapDumper = new HeapDumper();
                    mProvider = DumpFileProvider.getInstance();
                }
            }
        }
        return sHeapDumper;
    }

    public void dumpHeap(long j) {
        dumpHeap(j, MemoryApi.getInstance().getInitConfig().getRunStrategy() != 2 ? 1 : 2);
    }

    public void dumpHeap(long j, final int i) {
        this.mCrashTime = j;
        HeapSaver.getInstance().getSp();
        if (MemoryApi.getInstance().getInitConfig().getRunStrategy() == 2) {
            MemoryExecutorSupplier.NORMAL_SERVICE.execute(new Runnable() { // from class: com.bytedance.memory.dump.HeapDumper.1
                @Override // java.lang.Runnable
                public void run() {
                    HeapDumper.this.dumpHeapInner(i);
                }
            }, "HeapDumper-dumpHeap");
        } else {
            dumpHeapInner(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dumpHeapInner(int i) {
        try {
            if (checkStorage()) {
                dumpAndSave(i);
                MemoryChecker.getInstance().finishDump();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkStorage() {
        try {
            long externalStorageSize = getExternalStorageSize();
            long runtimeMaxMemory = CommonMonitorUtil.getRuntimeMaxMemory();
            return externalStorageSize > 0 && runtimeMaxMemory > 0 && ((float) externalStorageSize) > ((float) runtimeMaxMemory) * DUMP_VALUE;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private long getExternalStorageSize() {
        try {
            if (!TextUtils.isEmpty(MemoryApi.getInstance().getSavePath())) {
                return getFileTotalSize(new File(MemoryApi.getInstance().getSavePath()));
            }
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return getFileTotalSize(FileUtils.getExternalRootDir(ApmContext.getContext()));
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long getFileTotalSize(File file) {
        try {
            return new StatFs(file.getPath()).getAvailableBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private void dumpAndSave(int i) {
        File realDump;
        EventUtils.uploadCategoryEvent("dumpAndSave");
        long nanoTime = System.nanoTime();
        File newHeapDumpFile = mProvider.newHeapDumpFile();
        File file = RETRY_LATER;
        if (newHeapDumpFile == file) {
            EventUtils.uploadCategoryEvent("dumpAndSave_error_noHeapInfoFile");
            return;
        }
        File parentFile = newHeapDumpFile.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        long currentTimeMillis = System.currentTimeMillis();
        EventUtils.uploadCategoryEventImmediate(EventUtils.DUMP_BEGIN);
        MemoryWidgetConfig.DumpShrinkConfig dumpAndShrinkConfig = MemoryApi.getInstance().getInitConfig().getDumpAndShrinkConfig();
        if (dumpAndShrinkConfig != null && !EventUtils.getDumpEventNoDebug(EventUtils.CLOSE_NATIVE_DUMP_AND_SHRINK)) {
            File file2 = new File(DumpFileProvider.getInstance().getShrinkFolder(), HeapSaver.SHRINK_TYPE_MINI);
            if (dumpAndShrinkConfig.dumpAndShrinkHprof(file2)) {
                realDump = compressSaveFile(file2);
            } else {
                realDump = realDump(newHeapDumpFile, i);
                HeapSaver.getInstance().setShrinked(false);
            }
        } else {
            realDump = realDump(newHeapDumpFile, i);
            HeapSaver.getInstance().setShrinked(false);
        }
        EventUtils.uploadCategoryEventImmediate(EventUtils.DUMP_END);
        EventUtils.uploadMetricEvent(EventUtils.DUMP_TIME, System.currentTimeMillis() - currentTimeMillis);
        if (realDump == file) {
            return;
        }
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
        EventUtils.uploadCategoryEvent("dumpAndSave_saveHeapDump");
        saveHeapDump(realDump, millis);
        HeapSaver.getInstance().updateLastDumpTime(System.currentTimeMillis());
    }

    private HeapDump saveHeapDump(File file, long j) {
        HeapDump build = HeapDump.newBuilder().heapDumpFile(file).gcDurationMs(0L).currentTime(this.mCrashTime).heapDumpFileSize(file.length()).debug(MemoryWidgetGlobal.DEBUG).heapDumpDurationMs(j).build();
        MemoryLog.m101i(build.toString(), new Object[0]);
        HeapSaver.getInstance().saveHeap(build);
        return build;
    }

    private File realDump(File file, int i) {
        try {
            if (i == 2) {
                MemoryLog.m101i("Native dump", new Object[0]);
                Npth.dumpHprof(file.getAbsolutePath());
                MemoryLog.m101i("Native dump exist ? " + new File(file.getAbsolutePath()).exists(), new Object[0]);
            } else {
                Debug.dumpHprofData(file.getAbsolutePath());
            }
            HeapSaver.getInstance().setUpdateVersionCode(ApmContext.getHeaderInner().optString("update_version_code"));
            return file;
        } catch (Exception e) {
            EventUtils.uploadCategoryEvent("realDump_error");
            EnsureManager.ensureNotReachHere(e, "Could not realDump heap");
            return RETRY_LATER;
        }
    }

    private File compressSaveFile(File file) {
        String optString = ApmContext.getHeaderInner().optString("update_version_code");
        HeapSaver.getInstance().setUpdateVersionCode(optString);
        File file2 = new File(file.getParent(), optString + "_shrink.zip");
        ZipUtil.compressFile(file, file2);
        if (file.exists()) {
            file.delete();
        }
        HeapSaver.getInstance().setShrinked(true);
        HeapSaver.getInstance().setLatestZipPath(file2.getAbsolutePath());
        HeapSaver.getInstance().setHprofType(4);
        return file2;
    }
}
