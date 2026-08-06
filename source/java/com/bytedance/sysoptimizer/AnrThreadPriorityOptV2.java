package com.bytedance.sysoptimizer;

import android.os.Debug;
import android.os.Process;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class AnrThreadPriorityOptV2 {
    private static final AnrThreadPriorityOptV2 INSTANCE = new AnrThreadPriorityOptV2();
    private static final String TAG = "AnrThreadPriorityOptV2";
    private Map<String, Integer> mThreadPriorityMapForName = new HashMap();
    private List<ThreadPriorityData> mThreadPriorityDataList = new ArrayList();
    private volatile boolean mInitialized = false;
    private boolean mDebug = false;

    private AnrThreadPriorityOptV2() {
    }

    public static AnrThreadPriorityOptV2 getInstance() {
        return INSTANCE;
    }

    public void init(Map<String, Integer> map, boolean z) {
        if (!this.mInitialized) {
            this.mInitialized = true;
            this.mDebug = z;
            if (map != null) {
                this.mThreadPriorityMapForName = new HashMap(map);
            }
            Log.d(TAG, "init success");
            return;
        }
        Log.d(TAG, "already initialized");
    }

    private String getThreadName(int i) {
        File file = new File("/proc/self/task/" + i + "/comm");
        if (!file.exists()) {
            return "Unknown";
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                return readLine;
            } finally {
            }
        } catch (IOException unused) {
            Log.e(TAG, "Error reading thread name for tid: " + i);
            return "Unknown";
        }
    }

    public void restoreThreadPriority() {
        synchronized (this.mThreadPriorityDataList) {
            List<ThreadPriorityData> list = this.mThreadPriorityDataList;
            if (list != null) {
                for (ThreadPriorityData threadPriorityData : list) {
                    try {
                        int i = threadPriorityData.tid;
                        Process.setThreadPriority(i, threadPriorityData.originalPriority);
                        if (this.mDebug) {
                            Log.d(TAG, "Restoring thread priority: " + i + ", data: " + threadPriorityData + ", current priority: " + Process.getThreadPriority(i));
                        }
                    } catch (Throwable unused) {
                        Log.e(TAG, "Error restoring thread priority for tid: " + threadPriorityData.tid);
                    }
                }
            }
        }
    }

    public void setThreadPriority() {
        synchronized (this.mThreadPriorityDataList) {
            if (this.mThreadPriorityDataList != null) {
                List<ThreadPriorityData> allThreadPriority = getAllThreadPriority();
                this.mThreadPriorityDataList = allThreadPriority;
                for (ThreadPriorityData threadPriorityData : allThreadPriority) {
                    try {
                        int i = threadPriorityData.tid;
                        Process.setThreadPriority(i, threadPriorityData.expectedPriority);
                        if (this.mDebug) {
                            Log.d(TAG, "Setting thread priority: " + i + ", data: " + threadPriorityData + ", current priority: " + Process.getThreadPriority(i));
                        }
                    } catch (Throwable unused) {
                        Log.e(TAG, "Error setting thread priority for tid: " + threadPriorityData.tid);
                    }
                }
            }
        }
    }

    public List<ThreadPriorityData> getAllThreadPriority() {
        File[] listFiles;
        long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
        ArrayList arrayList = new ArrayList();
        File file = new File("/proc/self/task");
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                try {
                    int parseInt = Integer.parseInt(file2.getName());
                    int threadPriority = Process.getThreadPriority(parseInt);
                    if (threadPriority < 0) {
                        String threadName = getThreadName(parseInt);
                        Integer num = this.mThreadPriorityMapForName.get(threadName.replaceAll("\\d+", "*"));
                        if (num != null) {
                            arrayList.add(new ThreadPriorityData(threadName, parseInt, num.intValue(), threadPriority));
                        }
                    }
                } catch (NumberFormatException unused) {
                    Log.e(TAG, "Invalid thread ID in file name: " + file2.getName());
                } catch (Exception unused2) {
                    Log.e(TAG, "Error processing task file: " + file2.getName());
                }
            }
        }
        Log.d(TAG, "CPU time used: " + ((Debug.threadCpuTimeNanos() - threadCpuTimeNanos) / 1000000) + " ms");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class ThreadPriorityData {
        int expectedPriority;
        String name;
        int originalPriority;
        int tid;

        public ThreadPriorityData(String str, int i, int i2, int i3) {
            this.name = str;
            this.tid = i;
            this.expectedPriority = i2;
            this.originalPriority = i3;
        }

        public String toString() {
            return "ThreadPriorityData{name='" + this.name + "', tid=" + this.tid + ", expectedPriority=" + this.expectedPriority + ", originalPriority=" + this.originalPriority + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
