package com.bytedance.memory.heap;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.core.MonitorSharedPreferences;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.memory.api.MemoryApi;
import com.bytedance.memory.common.MemoryExecutorSupplier;
import com.bytedance.memory.common.MemoryLog;
import com.bytedance.memory.common.MemoryUtils;
import com.bytedance.memory.common.ZipUtil;
import com.bytedance.memory.dump.DumpFileProvider;
import com.bytedance.memory.event.EventUtils;
import com.bytedance.memory.shrink.MemoryShrinker;
import com.bytedance.memory.upload.MemoryNetApi;
import com.bytedance.push.utils.RomVersionParamHelper;
import com.bytedance.services.apm.api.EnsureManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class HeapSaver {
    private static final String CURRENT_TIME = "currentTime";
    private static final String DUMP_DURATION_MS = "dumpDurationMs";
    private static final String GC_DURATION_MS = "gcDurationMs";
    private static final String HAS_SHRINK = "hasShrink";
    private static final String HEAP_DUMP_FILE_PATH = "heapDumpFilePath";
    private static final String HEAP_DUMP_FILE_SIZE = "heapDumpFileSize";
    public static final String HPROF_TYPE = "hprof_type";
    public static final int HPROF_TYPE_DUM_AND_SHRINK = 4;
    public static final int HPROF_TYPE_JAVA_SHRINK = 2;
    public static final int HPROF_TYPE_JAVA_SHRINK_V2 = 5;
    public static final int HPROF_TYPE_NATIVE_SHRINK = 3;
    public static final int HPROF_TYPE_ORIGIN = 1;
    private static final String IS_DEBUG = "isDebug";
    private static final String KEY_HEAP_DUMP_FILE_PATH = "filePath";
    private static final String KEY_UPDATE_VERSION_CODE = "updateVersionCode";
    private static final String LAST_DUMP_TIME = "lastDumpTime";
    private static final String LATEST_FILE_PATH = "latestFilePath";
    private static final String LATEST_ORIGIN_FILE_PATH = "latestOriginFilePath";
    public static final String NPHT_HPROF = "npth.jpg";
    public static final String NPHT_HPROF_MINI = "npth_mini.jpg";
    private static final int PENDING_FILE_THRESHOLD_SIZE = 31457280;
    private static final String REFERENCE_NAME = "referenceName";
    private static final String SHRINK_FILE_PATH = "shrinkFilePath";
    public static final String SHRINK_TYPE_MINI = ".mini.hprof";
    private static final String SP_NAME = "MemoryWidgetSp";
    private static final String WATCH_DURATION_MS = "watchDurationMs";
    private static volatile HeapSaver sHeapSaver;
    private volatile HeapDump mCacheHeapDump;
    private Context mContext;
    private boolean mDumpThisTime;
    private volatile boolean mIsShrinking;
    private volatile SharedPreferences mPreferences = null;

    public static HeapSaver getInstance() {
        if (sHeapSaver == null) {
            synchronized (HeapSaver.class) {
                if (sHeapSaver == null) {
                    sHeapSaver = new HeapSaver(MemoryApi.getInstance().getContext());
                }
            }
        }
        return sHeapSaver;
    }

    private HeapSaver(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public boolean isDumpThisTime() {
        return this.mDumpThisTime;
    }

    public HeapDump getCacheHeapDump() {
        return this.mCacheHeapDump;
    }

    private void setCacheHeapDump(HeapDump heapDump) {
        this.mCacheHeapDump = heapDump;
    }

    public boolean canAnalyse() {
        return getCacheHeapDump() != null || DumpFileProvider.getInstance().pendingHeapMarkFileExist();
    }

    public void updateLastDumpTime(long j) {
        this.mDumpThisTime = true;
        getSp().edit().putLong(LAST_DUMP_TIME, j).commit();
    }

    public long getLastDumpTime() {
        return getSp().getLong(LAST_DUMP_TIME, 0L);
    }

    public void setShrinked(boolean z) {
        getSp().edit().putBoolean(HAS_SHRINK, z).commit();
    }

    public boolean hasShrinked() {
        return getSp().getBoolean(HAS_SHRINK, false);
    }

    public void setLatestZipPath(String str) {
        getSp().edit().putString(LATEST_FILE_PATH, str).commit();
    }

    public String getLatestZipPath() {
        return getSp().getString(LATEST_FILE_PATH, "");
    }

    public void setUpdateVersionCode(String str) {
        getSp().edit().putString(KEY_UPDATE_VERSION_CODE, str).commit();
    }

    public String getUpdateVersionCode() {
        return getSp().getString(KEY_UPDATE_VERSION_CODE, "");
    }

    public void setHprofType(int i) {
        getSp().edit().putInt(HPROF_TYPE, i).commit();
    }

    public int getHprofType() {
        return getSp().getInt(HPROF_TYPE, 1);
    }

    public long getCrashTime() {
        if (getInstance().getCacheHeapDump() != null) {
            return getInstance().getCacheHeapDump().currentTime;
        }
        return System.currentTimeMillis();
    }

    public boolean lessThanThreshold() {
        return System.currentTimeMillis() - getSp().getLong(LAST_DUMP_TIME, 0L) < 28800000;
    }

    public SharedPreferences getSp() {
        if (this.mPreferences == null) {
            synchronized (this) {
                if (this.mPreferences == null) {
                    this.mPreferences = MonitorSharedPreferences.getSharedPreferences(this.mContext, SP_NAME + ApmContext.getCurrentProcessName());
                }
            }
        }
        return this.mPreferences;
    }

    private String getHeapDumpFilePath() {
        return getSp().getString(KEY_HEAP_DUMP_FILE_PATH, "");
    }

    private void setHeapDumpFilePath(String str) {
        getSp().edit().putString(KEY_HEAP_DUMP_FILE_PATH, str).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteHeapDumpFilePath() {
        setHeapDumpFilePath("");
    }

    public void shrink() {
        long currentTimeMillis;
        if (this.mIsShrinking) {
            EventUtils.uploadCategoryEvent("shrink_error_isShrinking");
            return;
        }
        if (getInstance().hasShrinked()) {
            MemoryLog.m101i("HeapSaver shrink hasShrinked", new Object[0]);
            MemoryNetApi.uploadFile();
            return;
        }
        if (DumpFileProvider.getInstance().pendingHeapMarkFileExist()) {
            String updateVersionCode = getInstance().getUpdateVersionCode();
            if (DumpFileProvider.getInstance().getPendingHeapFile().length() <= 31457280 || TextUtils.isEmpty(updateVersionCode)) {
                MemoryLog.m101i("HeapSaver shrink return deleteCache. updateVersionCode:" + updateVersionCode, new Object[0]);
                EventUtils.uploadCategoryEvent("shrink_error_dumpInvalid");
                getInstance().deleteCache();
                return;
            }
            this.mIsShrinking = true;
            Process.setThreadPriority(10);
            if (getInstance().getCacheHeapDump() != null) {
                currentTimeMillis = getInstance().getCacheHeapDump().currentTime;
            } else {
                currentTimeMillis = System.currentTimeMillis();
            }
            File pendingHeapFile = DumpFileProvider.getInstance().getPendingHeapFile();
            String substring = pendingHeapFile.getName().substring(0, pendingHeapFile.getName().lastIndexOf(LibrarianImpl.Constants.DOT));
            if (EventUtils.getMemoryEventNoDebug(EventUtils.MEMORY_UPLOAD_ORIGIN)) {
                dealOriginMode(updateVersionCode, currentTimeMillis, pendingHeapFile, substring);
            } else {
                dealShrinkMode(updateVersionCode, currentTimeMillis, pendingHeapFile);
            }
            DumpFileProvider.getInstance().deletePendingHeapFile();
            this.mIsShrinking = false;
            Process.setThreadPriority(0);
            MemoryNetApi.uploadFile();
            return;
        }
        EventUtils.uploadCategoryEvent("shrink_error_HeapFileNotExist");
    }

    private void dealShrinkMode(String str, long j, File file) {
        MemoryLog.m101i("shrink begin with path %s, length %s ", file.getPath(), Long.valueOf(file.length()));
        File realShrink = realShrink(file);
        if (realShrink == null || (realShrink.length() < 31457280 && getInstance().getHprofType() == 2)) {
            MemoryLog.m101i("shrink failed deleteCache", new Object[0]);
            getInstance().deleteCache();
            return;
        }
        MemoryLog.m101i("shrink succeed", new Object[0]);
        EventUtils.uploadCategoryEvent(EventUtils.SHRINK_COMPRESS_BEGIN);
        long currentTimeMillis = System.currentTimeMillis();
        File compressFile = ZipUtil.compressFile(realShrink, true);
        EventUtils.uploadMetricEvent(EventUtils.SHRINK_COMPRESS_TIME, System.currentTimeMillis() - currentTimeMillis);
        EventUtils.uploadCategoryEvent(EventUtils.SHRINK_COMPRESS_END);
        EventUtils.uploadMetricEvent(EventUtils.SHRINK_COMPRESS_SIZE, compressFile.length() / 1024);
        File file2 = new File(compressFile.getParent(), new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date(j)) + RomVersionParamHelper.SEPARATOR + str + "_shrink.zip");
        if (compressFile.exists()) {
            compressFile.renameTo(file2);
        }
        getInstance().setShrinked(true);
        getInstance().setLatestZipPath(file2.getAbsolutePath());
    }

    private void dealOriginMode(String str, long j, File file, String str2) {
        File file2 = new File(DumpFileProvider.getInstance().getWidgetFolder(), "dump.hprof");
        if (file.getPath().contains("jpg")) {
            file.renameTo(file2);
        }
        File file3 = new File(DumpFileProvider.getInstance().getCacheFolder(), str2.replace("dump", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date(j))) + RomVersionParamHelper.SEPARATOR + str + "_origin.zip");
        EventUtils.uploadCategoryEvent(EventUtils.ORIGIN_COMPRESS_BEGIN);
        long currentTimeMillis = System.currentTimeMillis();
        ZipUtil.compressFile(file2, file3);
        MemoryLog.m101i("compress origin file succeed", new Object[0]);
        EventUtils.uploadMetricEvent(EventUtils.ORIGIN_COMPRESS_TIME, System.currentTimeMillis() - currentTimeMillis);
        EventUtils.uploadCategoryEvent(EventUtils.ORIGIN_COMPRESS_END);
        EventUtils.uploadMetricEvent(EventUtils.ORIGIN_COMPRESS_SIZE, file3.length() / 1024);
        if (file2.exists()) {
            file2.delete();
        }
        getInstance().setHprofType(1);
        getInstance().setShrinked(true);
        getInstance().setLatestZipPath(file3.getAbsolutePath());
    }

    private File realShrink(File file) {
        try {
            if (!file.exists()) {
                return null;
            }
            File shrinkFolder = DumpFileProvider.getInstance().getShrinkFolder();
            if (!shrinkFolder.exists()) {
                shrinkFolder.mkdirs();
            }
            return MemoryShrinker.shrink(file, new File(shrinkFolder, "dump.hprof"));
        } catch (Throwable th) {
            EventUtils.uploadCategoryEvent("realShrink_error");
            EnsureManager.ensureNotReachHere(th, "realShrink failed");
            th.printStackTrace();
            return null;
        }
    }

    public void deleteCache() {
        MemoryExecutorSupplier.NORMAL_SERVICE.execute(new Runnable() { // from class: com.bytedance.memory.heap.HeapSaver.1
            @Override // java.lang.Runnable
            public void run() {
                HeapSaver.this.mCacheHeapDump = null;
                MemoryUtils.deleteFile(DumpFileProvider.getInstance().getWidgetFolder());
                HeapSaver.this.deleteHeapDumpFilePath();
                HeapSaver.getInstance().setLatestZipPath("");
                HeapSaver.getInstance().setUpdateVersionCode("");
                HeapSaver.getInstance().setHprofType(0);
            }
        }, "HeapSaver-deleteCache");
    }

    public void checkCacheIfExist() {
        if (this.mCacheHeapDump != null) {
            return;
        }
        String heapDumpFilePath = getHeapDumpFilePath();
        if (TextUtils.isEmpty(heapDumpFilePath)) {
            return;
        }
        HeapDump loadHeap = loadHeap(heapDumpFilePath);
        MemoryLog.m101i("cache heapdump %s", loadHeap);
        setCacheHeapDump(loadHeap);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public File saveHeap(HeapDump heapDump) {
        FileOutputStream fileOutputStream;
        setCacheHeapDump(heapDump);
        File pendingHeapMarkFile = DumpFileProvider.getInstance().getPendingHeapMarkFile();
        if (pendingHeapMarkFile.exists()) {
            pendingHeapMarkFile.delete();
        }
        MemoryLog.m101i("analyzedHeapFile.getHeapDumpFilePath() %s", pendingHeapMarkFile.getPath());
        setHeapDumpFilePath(pendingHeapMarkFile.getPath());
        JSONObject jSONObject = new JSONObject();
        FileOutputStream fileOutputStream2 = null;
        try {
            transHeapToJson(heapDump, jSONObject);
            fileOutputStream = new FileOutputStream(pendingHeapMarkFile);
            try {
                try {
                    fileOutputStream.write(jSONObject.toString().getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                    return pendingHeapMarkFile;
                } catch (Exception e) {
                    e = e;
                    EventUtils.uploadCategoryEvent("dumpHeap_saveHeapDump_error");
                    MemoryLog.m100d(e, "Could not save leak analysis result to disk.", new Object[0]);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileOutputStream2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x006c: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:34:0x006c */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private HeapDump loadHeap(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        File file = new File(str);
        FileInputStream fileInputStream3 = null;
        if (!file.exists()) {
            deleteHeapDumpFilePath();
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                fileInputStream = new FileInputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream.read();
                        if (read == -1) {
                            break;
                        }
                        sb.append((char) read);
                    } catch (Exception e) {
                        e = e;
                        if (file.delete()) {
                            MemoryLog.m100d(e, "Could not read result file %s, deleted it.", file);
                        } else {
                            MemoryLog.m100d(e, "Could not read result file %s, could not delete it either.", file);
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        return null;
                    }
                }
                JSONObject jSONObject = new JSONObject(sb.toString());
                HeapDump transJsonToHeap = transJsonToHeap(jSONObject, new File(jSONObject.optString(HEAP_DUMP_FILE_PATH)));
                this.mCacheHeapDump = transJsonToHeap;
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                }
                return transJsonToHeap;
            } catch (Throwable th) {
                th = th;
                fileInputStream3 = fileInputStream2;
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream3 != null) {
            }
            throw th;
        }
    }

    private HeapDump transJsonToHeap(JSONObject jSONObject, File file) {
        return HeapDump.newBuilder().heapDumpFile(file).currentTime(jSONObject.optLong(CURRENT_TIME)).heapDumpFileSize(jSONObject.optLong(HEAP_DUMP_FILE_SIZE)).referenceName(jSONObject.optString(REFERENCE_NAME)).isDebug(jSONObject.optBoolean(IS_DEBUG)).gcDurationMs(jSONObject.optLong(GC_DURATION_MS)).watchDurationMs(jSONObject.optLong(WATCH_DURATION_MS)).heapDumpDurationMs(jSONObject.optLong(DUMP_DURATION_MS)).shrinkFilePath(jSONObject.optString(SHRINK_FILE_PATH)).build();
    }

    private void transHeapToJson(HeapDump heapDump, JSONObject jSONObject) throws JSONException {
        jSONObject.put(HEAP_DUMP_FILE_PATH, heapDump.heapDumpFile.getPath());
        jSONObject.put(SHRINK_FILE_PATH, heapDump.shrinkFilePath);
        jSONObject.put(HEAP_DUMP_FILE_SIZE, heapDump.heapDumpFile.length());
        jSONObject.put(REFERENCE_NAME, heapDump.referenceName);
        jSONObject.put(IS_DEBUG, heapDump.isDebug);
        jSONObject.put(GC_DURATION_MS, heapDump.gcDurationMs);
        jSONObject.put(WATCH_DURATION_MS, heapDump.watchDurationMs);
        jSONObject.put(DUMP_DURATION_MS, heapDump.heapDumpDurationMs);
        jSONObject.put(CURRENT_TIME, heapDump.currentTime);
    }
}
