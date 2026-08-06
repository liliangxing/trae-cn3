package com.bytedance.memory.dump;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.memory.api.MemoryApi;
import com.bytedance.memory.common.MemoryUtils;
import com.bytedance.memory.common.MemoryWidgetGlobal;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DumpFileProvider {
    private static final String HEAP_SUFFIX = ".heap";
    private static final String PENDING_HEAP_DUMP_NAME_PREFIX = "festival";
    private static final String PENDING_HEAP_DUMP_NAME_SUFFIX = ".jpg";
    private static volatile DumpFileProvider sProvider;
    private final String APP_DIR;
    private final File CACHE_FOLDER;
    private final File NPTH_HPROF_FOLDER;
    private final File PENDING_HEAP_FILE;
    private final File PENDING_HEAP_MARK_FILE;
    private final File SHRINK_FOLDER;
    private final File WIDGET_FOLDER;
    private final Context mContext;

    public String getAPPDIR() {
        return this.APP_DIR;
    }

    public File getShrinkFolder() {
        return this.SHRINK_FOLDER;
    }

    public File getNpthFolder() {
        return this.NPTH_HPROF_FOLDER;
    }

    public File getCacheFolder() {
        return this.CACHE_FOLDER;
    }

    public File getWidgetFolder() {
        return this.WIDGET_FOLDER;
    }

    private DumpFileProvider(Context context) {
        this.mContext = context;
        String savePath = MemoryApi.getInstance().getSavePath();
        if (!TextUtils.isEmpty(savePath)) {
            this.APP_DIR = new File(savePath).getAbsolutePath();
        } else {
            this.APP_DIR = context.getExternalFilesDir(null).getParentFile().getAbsolutePath();
        }
        String currentProcessName = ApmContext.getCurrentProcessName();
        if (currentProcessName != null) {
            this.WIDGET_FOLDER = new File(this.APP_DIR + "/memorywidgets", currentProcessName);
            this.NPTH_HPROF_FOLDER = new File(this.APP_DIR + "/memory", currentProcessName);
        } else {
            this.WIDGET_FOLDER = new File(this.APP_DIR + "/memorywidgets", context.getPackageName());
            this.NPTH_HPROF_FOLDER = new File(this.APP_DIR + "/memory", context.getPackageName());
        }
        if (!this.WIDGET_FOLDER.exists()) {
            this.WIDGET_FOLDER.mkdirs();
        }
        if (!this.NPTH_HPROF_FOLDER.exists()) {
            this.NPTH_HPROF_FOLDER.mkdirs();
        }
        File file = new File(this.WIDGET_FOLDER, "cache");
        this.CACHE_FOLDER = file;
        if (!file.exists()) {
            file.mkdirs();
        }
        this.PENDING_HEAP_FILE = new File(this.WIDGET_FOLDER, "festival.jpg");
        this.PENDING_HEAP_MARK_FILE = new File(this.WIDGET_FOLDER, "festival.jpg.heap");
        File file2 = new File(this.WIDGET_FOLDER, MemoryWidgetGlobal.WIDGET_SHRINK_NAME);
        this.SHRINK_FOLDER = file2;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        deleteOld();
    }

    private void deleteOld() {
        try {
            MemoryUtils.deleteFile(new File(this.APP_DIR, MemoryWidgetGlobal.OLD_WIDGET_DIR_NAME));
        } catch (Exception unused) {
        }
    }

    public boolean pendingHeapMarkFileExist() {
        return new File(this.WIDGET_FOLDER, "festival.jpg.heap").exists();
    }

    public File getPendingHeapMarkFile() {
        return this.PENDING_HEAP_MARK_FILE;
    }

    public File getPendingHeapFile() {
        return this.PENDING_HEAP_FILE;
    }

    public void deletePendingHeapFile() {
        if (this.PENDING_HEAP_FILE.exists()) {
            this.PENDING_HEAP_FILE.delete();
        }
    }

    public static DumpFileProvider getInstance() {
        if (sProvider == null) {
            synchronized (DumpFileProvider.class) {
                if (sProvider == null) {
                    sProvider = new DumpFileProvider(MemoryApi.getInstance().getContext());
                }
            }
        }
        return sProvider;
    }

    public File newHeapDumpFile() {
        return this.PENDING_HEAP_FILE;
    }
}
