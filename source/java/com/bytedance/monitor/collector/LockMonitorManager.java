package com.bytedance.monitor.collector;

import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.ExceptionLogData;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.perf.monitor.ReportConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LockMonitorManager {
    private static final int DEFAULT_SIZE = 100;
    private static final String DELIMITER = "&#&";
    private static final String KEY_IS_ALL_THREAD = "is_all_thread";
    private static final String KEY_IS_LOCK = "is_lock";
    private static final String KEY_RAW_DUMP_INFO = "raw_dump_info";
    private static final String LOCK_THREAD_NAME = "lock_handler_time";
    private static final String STACK_THREAD_NAME = "lock_stack_fetch";
    private static final String TAG = "LockMonitorManager";
    private static final int bufferSize = 100;
    private static boolean isAllThread;
    private static volatile String lastJavaStack;
    private static volatile String lastOwnerJavaStack;
    private static volatile boolean openFetchStack;
    private static int position;
    private static LockInfo[] lockInfoQueue = new LockInfo[100];
    private static final BlockingQueue<String> sStackBlockingQueue = new LinkedBlockingQueue();
    private static final BlockingQueue<String> sOwnerStackBlockingQueue = new LinkedBlockingQueue();
    private static ExecutorService sLockHandler = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.bytedance.monitor.collector.LockMonitorManager.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(LockMonitorManager.LOCK_THREAD_NAME);
            return thread;
        }
    });
    private static ExecutorService sStackFetcher = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.bytedance.monitor.collector.LockMonitorManager.2
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            Process.setThreadPriority(-20);
            thread.setName(LockMonitorManager.STACK_THREAD_NAME);
            return thread;
        }
    });
    private static volatile boolean isLockMonitoring = false;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface LockInfoFetchListener {
        void onData(List<LockInfo> list);
    }

    public static void startLockDetect() {
        startLockDetect(30L);
    }

    public static void startLockDetect(long j) {
        if (isLockMonitoring) {
            return;
        }
        isLockMonitoring = true;
        if (ApmContext.isMainProcessSimple()) {
            PerfMonitorManager.getInstance().startLockDetect(j, false);
        }
    }

    public static void startLockDetect(long j, boolean z) {
        if (isLockMonitoring) {
            return;
        }
        isLockMonitoring = true;
        isAllThread = z;
        if (ApmContext.isMainProcessSimple()) {
            PerfMonitorManager.getInstance().startLockDetect(j, z);
        }
    }

    public static void endLockDetect(JSONObject jSONObject) {
        if (isLockMonitoring) {
            isLockMonitoring = false;
            try {
                jSONObject.put(KEY_IS_LOCK, true);
                jSONObject.put(KEY_IS_ALL_THREAD, isAllThread);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (ApmContext.isMainProcessSimple()) {
                reportLockInfo(jSONObject);
                PerfMonitorManager.getInstance().endLockDetect();
            }
        }
    }

    public static void reportLockInfo(final JSONObject jSONObject) {
        dumpLockInfo(new LockInfoFetchListener() { // from class: com.bytedance.monitor.collector.LockMonitorManager.3
            @Override // com.bytedance.monitor.collector.LockMonitorManager.LockInfoFetchListener
            public void onData(List<LockInfo> list) {
                if (list == null) {
                    return;
                }
                if (ApmContext.isDebugMode()) {
                    Log.d(LockMonitorManager.TAG, "dumpLockInfo size -> " + list.size());
                }
                for (LockInfo lockInfo : list) {
                    try {
                        JSONObject packJsonData = LockMonitorManager.packJsonData(lockInfo, jSONObject);
                        if (packJsonData != null) {
                            if (ApmContext.isDebugMode()) {
                                Log.d(LockMonitorManager.TAG, "lock report LockInfo: " + lockInfo);
                            }
                            ExceptionLogData exceptionLogData = new ExceptionLogData(ReportConst.MONITOR_TYPE_BLOCK, packJsonData, lockInfo.timestamp);
                            exceptionLogData.forceSample();
                            CommonDataPipeline.getInstance().handle(exceptionLogData);
                        }
                    } catch (Throwable th) {
                        Log.e(LockMonitorManager.TAG, "onData: parse lock info failed: " + th.getLocalizedMessage());
                    }
                }
            }
        });
    }

    public static void dumpLockInfo(final LockInfoFetchListener lockInfoFetchListener) {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.monitor.collector.LockMonitorManager.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    LockInfoFetchListener lockInfoFetchListener2 = LockInfoFetchListener.this;
                    if (lockInfoFetchListener2 != null) {
                        lockInfoFetchListener2.onData(LockMonitorManager.dumpLockInfo());
                    } else {
                        lockInfoFetchListener2.onData(null);
                    }
                } catch (Throwable unused) {
                    LockInfoFetchListener.this.onData(null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject packJsonData(LockInfo lockInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(ReportConst.KEY_TIMESTAMP, lockInfo.timestamp);
            jSONObject2.put("crash_time", lockInfo.timestamp);
            jSONObject2.put(ReportConst.KEY_IS_MAIN_PROCESS, ApmContext.isMainProcess());
            jSONObject2.put(ReportConst.KEY_PROCESS_NAME, ApmContext.getCurrentProcessName());
            jSONObject2.put(ReportConst.KEY_BLOCK_DURATION, lockInfo.duration);
            jSONObject2.put(KEY_RAW_DUMP_INFO, lockInfo.rawAtrace);
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(lockInfo.completeBlockStackInfo)) {
                sb.append(lockInfo.completeBlockStackInfo.replace("\t", "")).append("\n");
            }
            sb.append("-OwnerThread: ").append(lockInfo.getOwnerThreadName()).append("\n");
            sb.append("-OwnerStack: ").append(lockInfo.getOwnerStackInfo()).append("\n");
            sb.append("-WaiterStack: ").append(lockInfo.getBlockStackInfo()).append("\n");
            sb.append("-RawAtrace: ").append(lockInfo.rawAtrace).append("\n");
            sb.append("-LockThread: ").append(lockInfo.getLockThreadName()).append("\n");
            if (lockInfo.topActivityName != null) {
                sb.append("-Activity: ").append(lockInfo.topActivityName).append("\n");
            }
            JSONObject perfFiltersJson = PerfFilterManager.getInstance().getPerfFiltersJson();
            perfFiltersJson.put(ReportConst.KEY_BLOCK_STACK_TYPE, ReportConst.KEY_STACK);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                perfFiltersJson.put(next, jSONObject.get(next));
            }
            jSONObject2.put(ReportConst.KEY_FILTER, perfFiltersJson);
            jSONObject2.put(ReportConst.KEY_STACK, sb.toString());
            jSONObject2.put(ReportConst.KEY_EVENT_TYPE, ReportConst.EXCEPTION_EVENT_TYPE_LAG);
            return jSONObject2;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setOpenFetchStack(boolean z) {
        openFetchStack = z;
        if (z) {
            return;
        }
        lastJavaStack = null;
        lastOwnerJavaStack = null;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class LockInfo {
        private static final String INFO_BEGIN = "monitor contention with owner";
        private String blockStackInfo;
        private String completeBlockStackInfo;
        public final long duration;
        private String lockThreadName;
        private String ownerStackInfo;
        private String ownerThreadName;
        public final String rawAtrace;
        public final long timestamp;
        private String topActivityName;

        private LockInfo(long j, long j2, String str, String str2) {
            this.topActivityName = "unknown";
            this.timestamp = j;
            this.duration = j2;
            this.rawAtrace = str;
            this.lockThreadName = str2;
            parseAtrace(str);
            ActivityLifecycleService activityLifecycleService = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
            if (activityLifecycleService != null) {
                String topActivityClassName = activityLifecycleService.getTopActivityClassName();
                if (TextUtils.isEmpty(topActivityClassName)) {
                    return;
                }
                this.topActivityName = topActivityClassName;
            }
        }

        private void parseAtrace(String str) {
            String substring = str.substring(str.indexOf(INFO_BEGIN));
            this.ownerThreadName = substring.substring(30, substring.indexOf("(") - 1);
            int indexOf = substring.indexOf(" at ");
            if (indexOf != -1) {
                String substring2 = substring.substring(indexOf + 5, substring.indexOf("waiters=", indexOf));
                String substring3 = substring2.substring(substring2.indexOf(" "));
                this.ownerStackInfo = substring3.substring(1, substring3.indexOf("(")) + substring3.substring(substring3.indexOf(")") + 1, substring3.lastIndexOf(")") + 1);
            }
            String substring4 = substring.substring(substring.indexOf("blocking from") + 14);
            String substring5 = substring4.substring(substring4.indexOf(" ") + 1);
            this.blockStackInfo = substring5.substring(0, substring5.indexOf("(")) + substring5.substring(substring5.indexOf(")") + 1, substring5.lastIndexOf(")") + 1);
        }

        public String getBlockStackInfo() {
            return this.blockStackInfo;
        }

        public String getOwnerStackInfo() {
            return this.ownerStackInfo;
        }

        public String getOwnerThreadName() {
            return this.ownerThreadName;
        }

        public String getLockThreadName() {
            return this.lockThreadName;
        }

        static LockInfo createLockInfo(String str) {
            String str2;
            String str3;
            String str4 = null;
            if (str == null || str.isEmpty()) {
                return null;
            }
            Log.d("lockDetect", "" + str);
            String[] split = str.split(LockMonitorManager.DELIMITER);
            if (split.length != 4) {
                Log.d("lockDetect", "spiltData != 4" + str);
                return null;
            }
            long parseLong = Long.parseLong(split[0]);
            long parseLong2 = Long.parseLong(split[1]);
            String str5 = split[2];
            LockInfo lockInfo = new LockInfo(parseLong, parseLong2, str5, split[3]);
            if (LockMonitorManager.openFetchStack) {
                synchronized (LockMonitorManager.sStackBlockingQueue) {
                    try {
                        str3 = (String) LockMonitorManager.sStackBlockingQueue.poll(200L, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        str3 = null;
                    }
                    if (str3 != null || LockMonitorManager.lastJavaStack == null) {
                        String unused = LockMonitorManager.lastJavaStack = str3;
                    } else {
                        str3 = LockMonitorManager.lastJavaStack;
                    }
                    if (!LockMonitorManager.sStackBlockingQueue.isEmpty()) {
                        LockMonitorManager.sStackBlockingQueue.clear();
                    }
                }
                synchronized (LockMonitorManager.sOwnerStackBlockingQueue) {
                    try {
                        str4 = (String) LockMonitorManager.sOwnerStackBlockingQueue.poll(200L, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    if (str4 != null || LockMonitorManager.lastOwnerJavaStack == null) {
                        String unused2 = LockMonitorManager.lastOwnerJavaStack = str3;
                    } else {
                        str4 = LockMonitorManager.lastOwnerJavaStack;
                    }
                    if (!LockMonitorManager.sOwnerStackBlockingQueue.isEmpty()) {
                        LockMonitorManager.sOwnerStackBlockingQueue.clear();
                    }
                }
                str2 = str4;
                str4 = str3;
            } else {
                str2 = null;
            }
            if (str4 != null && str5.contains(Util.getTopMethodName(str4))) {
                lockInfo.setJavaStack(str4);
            }
            if (str2 != null) {
                lockInfo.setOwnerJavaStack(str2);
            }
            return lockInfo;
        }

        public String toString() {
            return "LockInfo{timestamp=" + this.timestamp + ", duration=" + this.duration + ", rawAtrace='" + this.rawAtrace + "', topActivityName='" + this.topActivityName + "', blockStackInfo='" + this.blockStackInfo + "', completeBlockStackInfo='" + this.completeBlockStackInfo + "', ownerStackInfo='" + this.ownerStackInfo + "', lockThreadName='" + this.lockThreadName + "', ownerThreadName='" + this.ownerThreadName + "'}";
        }

        public void setJavaStack(String str) {
            this.completeBlockStackInfo = str;
        }

        public void setOwnerJavaStack(String str) {
            if (str == null || str.isEmpty()) {
                return;
            }
            this.ownerStackInfo = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void enqueue(LockInfo lockInfo) {
        if (lockInfo == null) {
            return;
        }
        LockInfo[] lockInfoArr = lockInfoQueue;
        int i = position;
        lockInfoArr[i] = lockInfo;
        position = (i + 1) % 100;
    }

    private static void nativePut(final String str) {
        sLockHandler.execute(new Runnable() { // from class: com.bytedance.monitor.collector.LockMonitorManager.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final LockInfo createLockInfo = LockInfo.createLockInfo(str);
                    if (createLockInfo != null) {
                        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.monitor.collector.LockMonitorManager.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                LockMonitorManager.enqueue(createLockInfo);
                            }
                        });
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static void getOwnerStack(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        ThreadGroup threadGroup = Looper.getMainLooper().getThread().getThreadGroup();
        int activeCount = threadGroup.activeCount();
        int i = activeCount + (activeCount / 2);
        Thread[] threadArr = new Thread[i];
        threadGroup.enumerate(threadArr);
        for (int i2 = 0; i2 < i; i2++) {
            final Thread thread = threadArr[i2];
            if (thread == null) {
                return;
            }
            if (thread != Thread.currentThread() && thread.getName().contains(str) && openFetchStack) {
                sStackFetcher.execute(new Runnable() { // from class: com.bytedance.monitor.collector.LockMonitorManager.6
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            String stackToString = Util.stackToString(thread.getStackTrace());
                            synchronized (LockMonitorManager.sOwnerStackBlockingQueue) {
                                if (LockMonitorManager.sOwnerStackBlockingQueue.size() != 0) {
                                    LockMonitorManager.sOwnerStackBlockingQueue.clear();
                                }
                                LockMonitorManager.sOwnerStackBlockingQueue.put(stackToString);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getThreadStack(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        ThreadGroup threadGroup = Looper.getMainLooper().getThread().getThreadGroup();
        int activeCount = threadGroup.activeCount();
        int i = activeCount + (activeCount / 2);
        Thread[] threadArr = new Thread[i];
        threadGroup.enumerate(threadArr);
        for (int i2 = 0; i2 < i; i2++) {
            final Thread thread = threadArr[i2];
            if (thread == null) {
                return;
            }
            if (thread.getName().contains(str) && openFetchStack) {
                sStackFetcher.execute(new Runnable() { // from class: com.bytedance.monitor.collector.LockMonitorManager.7
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            String stackToString = Util.stackToString(thread.getStackTrace());
                            synchronized (LockMonitorManager.sStackBlockingQueue) {
                                if (LockMonitorManager.sStackBlockingQueue.size() != 0) {
                                    LockMonitorManager.sStackBlockingQueue.clear();
                                }
                                LockMonitorManager.sStackBlockingQueue.put(stackToString);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        }
    }

    private static void nativeGetJavaStack(String str, final String str2) {
        int indexOf;
        if (openFetchStack) {
            sStackFetcher.execute(new Runnable() { // from class: com.bytedance.monitor.collector.LockMonitorManager.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (LockMonitorManager.isAllThread) {
                            LockMonitorManager.getThreadStack(str2);
                            return;
                        }
                        String stackToString = Util.stackToString(Looper.getMainLooper().getThread().getStackTrace());
                        synchronized (LockMonitorManager.sStackBlockingQueue) {
                            if (LockMonitorManager.sStackBlockingQueue.size() != 0) {
                                LockMonitorManager.sStackBlockingQueue.clear();
                            }
                            LockMonitorManager.sStackBlockingQueue.put(stackToString);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
            if (str == null || str.isEmpty() || (indexOf = str.indexOf("monitor contention with owner")) <= 0 || indexOf >= str.length()) {
                return;
            }
            String substring = str.substring(indexOf);
            int indexOf2 = substring.indexOf("(") - 1;
            if (indexOf2 <= 0 || 30 >= substring.length() || indexOf2 >= substring.length() || 30 >= indexOf2) {
                return;
            }
            getOwnerStack(substring.substring(30, indexOf2));
        }
    }

    public static List<LockInfo> dumpLockInfo() {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 100; i++) {
            int i2 = (((position + 100) - i) - 1) % 100;
            LockInfo[] lockInfoArr = lockInfoQueue;
            LockInfo lockInfo = lockInfoArr[i2];
            lockInfoArr[i2] = null;
            if (lockInfo != null) {
                linkedList.add(lockInfo);
            }
        }
        return linkedList;
    }

    public static String dumpLockInfo(long j, long j2) {
        LockInfo[] lockInfoArr = new LockInfo[100];
        System.arraycopy(lockInfoQueue, 0, lockInfoArr, 0, 100);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 100; i++) {
            LockInfo lockInfo = lockInfoArr[((position + i) + 1) % 100];
            if (lockInfo != null) {
                if (lockInfo.timestamp < j2 || lockInfo.timestamp + lockInfo.duration > j) {
                    arrayList.add(lockInfo);
                }
                if (lockInfo.timestamp + lockInfo.duration < j) {
                    break;
                }
            }
        }
        return arrayList.toString();
    }
}
