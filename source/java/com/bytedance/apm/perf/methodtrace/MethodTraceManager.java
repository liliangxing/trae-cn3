package com.bytedance.apm.perf.methodtrace;

import android.os.Process;
import android.os.SystemClock;
import android.util.Base64;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.ExceptionLogData;
import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.bytedance.monitor.util.thread.AsyncTaskUtil;
import com.bytedance.monitor.util.thread.IAsyncTaskManager;
import com.bytedance.monitor.util.thread.TaskRunnable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class MethodTraceManager {
    private static final int BASE_CACHE_SIZE = 8192;
    private static final int BYTE_255 = 255;
    private static final int EVENT_METHOD_ENTER = 0;
    private static final int EVENT_METHOD_EXIT = 1;
    private static volatile MethodTraceManager sTraceManger;
    private List<Thread> mBusyThreads;
    private int mCacheIndex;
    private JSONObject mData;
    private HashMap<StackTraceElement, Integer> mMethodIdMap;
    private Set<Long> mOldThreadSet;
    private Map<Long, ThreadTraceItem> mThreadItemMap;
    private int mTimer;
    private byte[] mTraceCache;
    private long mTraceStartTime;
    private volatile boolean mIsRunning = false;
    private TaskRunnable mTraceTask = new TaskRunnable() { // from class: com.bytedance.apm.perf.methodtrace.MethodTraceManager.1
        public String getTaskName() {
            return "TraceWrapper-Sampling";
        }

        public AsyncTaskType getTaskType() {
            return AsyncTaskType.TIME_SENSITIVE;
        }

        public void run() {
            if (MethodTraceManager.this.mIsRunning) {
                try {
                    MethodTraceManager.access$110(MethodTraceManager.this);
                    if (MethodTraceManager.this.mTimer == 0) {
                        MethodTraceManager.this.stop();
                    } else {
                        MethodTraceManager.this.trace();
                        if (MethodTraceManager.this.mAsyncTaskManager != null) {
                            MethodTraceManager.this.mAsyncTaskManager.postDelayed(this, 5L);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    };
    private IAsyncTaskManager mAsyncTaskManager = AsyncTaskUtil.getAsyncTaskManagerInstance();

    private static byte getByte(int i, int i2) {
        return (byte) ((i >> i2) & 255);
    }

    private static byte getByte(long j, int i) {
        return (byte) ((j >> i) & 255);
    }

    static /* synthetic */ int access$110(MethodTraceManager methodTraceManager) {
        int i = methodTraceManager.mTimer;
        methodTraceManager.mTimer = i - 1;
        return i;
    }

    public static MethodTraceManager getInstance() {
        if (sTraceManger == null) {
            synchronized (MethodTraceManager.class) {
                if (sTraceManger == null) {
                    sTraceManger = new MethodTraceManager();
                }
            }
        }
        return sTraceManger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trace() {
        ThreadTraceItem threadTraceItem;
        HashSet hashSet = new HashSet();
        for (Thread thread : this.mBusyThreads) {
            if (thread != null && thread.isAlive()) {
                long id = thread.getId();
                ThreadTraceItem threadTraceItem2 = this.mThreadItemMap.get(Long.valueOf(id));
                if (threadTraceItem2 == null) {
                    ThreadTraceItem threadTraceItem3 = new ThreadTraceItem(thread.getName(), SystemClock.uptimeMillis() * 1000, null);
                    this.mThreadItemMap.put(Long.valueOf(thread.getId()), threadTraceItem3);
                    threadTraceItem = threadTraceItem3;
                } else {
                    threadTraceItem = threadTraceItem2;
                }
                compareStackTrace(id, threadTraceItem, thread.getStackTrace(), SystemClock.uptimeMillis() * 1000);
                this.mOldThreadSet.remove(Long.valueOf(id));
                hashSet.add(Long.valueOf(id));
            }
        }
        Iterator<Long> it = this.mOldThreadSet.iterator();
        while (it.hasNext()) {
            handleOldStack(it.next().longValue());
        }
        this.mOldThreadSet = hashSet;
    }

    public void start(List<Thread> list, JSONObject jSONObject) {
        if (this.mIsRunning) {
            return;
        }
        this.mBusyThreads = list;
        this.mData = jSONObject;
        this.mThreadItemMap = new HashMap();
        this.mTraceStartTime = SystemClock.uptimeMillis() * 1000;
        this.mMethodIdMap = new HashMap<>();
        this.mOldThreadSet = new HashSet();
        this.mIsRunning = true;
        initTraceCacheHeader();
        this.mTimer = 200;
        IAsyncTaskManager iAsyncTaskManager = this.mAsyncTaskManager;
        if (iAsyncTaskManager != null) {
            iAsyncTaskManager.post(this.mTraceTask);
        }
    }

    public void stopTrace() {
        IAsyncTaskManager iAsyncTaskManager;
        if (!this.mIsRunning || (iAsyncTaskManager = this.mAsyncTaskManager) == null) {
            return;
        }
        iAsyncTaskManager.post(AsyncTaskUtil.wrapTimeSensitiveTask("stop-trace", new Runnable() { // from class: com.bytedance.apm.perf.methodtrace.MethodTraceManager.2
            @Override // java.lang.Runnable
            public void run() {
                MethodTraceManager.this.stop();
            }
        }));
    }

    private void initTraceCacheHeader() {
        this.mTraceCache = new byte[8192];
        this.mCacheIndex = 0;
        append4Bytes(1464814675);
        append2Bytes(3);
        append2Bytes(18);
        append8Bytes(this.mTraceStartTime);
        append2Bytes(14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            IAsyncTaskManager iAsyncTaskManager = this.mAsyncTaskManager;
            if (iAsyncTaskManager != null) {
                iAsyncTaskManager.removeTask(this.mTraceTask);
            }
            Iterator<Long> it = this.mOldThreadSet.iterator();
            while (it.hasNext()) {
                handleOldStack(it.next().longValue());
            }
            if (this.mCacheIndex > 18) {
                sendTrace(logTrace());
            }
        }
    }

    private void sendTrace(String str) {
        try {
            this.mData.put("trace_data", str);
            CommonDataPipeline.getInstance().handle(new ExceptionLogData("cpu_trace", this.mData));
        } catch (JSONException unused) {
        }
    }

    private void compareStackTrace(long j, ThreadTraceItem threadTraceItem, StackTraceElement[] stackTraceElementArr, long j2) {
        int i = (int) (j2 - this.mTraceStartTime);
        int i2 = (int) (j2 - threadTraceItem.startTime);
        if (threadTraceItem.oldStack == null || threadTraceItem.oldStack.length == 0) {
            for (int length = stackTraceElementArr.length - 1; length >= 0; length--) {
                logMethodTraceEvent(j, i2, i, stackTraceElementArr[length], 0);
            }
            threadTraceItem.oldStack = stackTraceElementArr;
            this.mThreadItemMap.put(Long.valueOf(j), threadTraceItem);
            return;
        }
        int length2 = threadTraceItem.oldStack.length - 1;
        int length3 = stackTraceElementArr.length - 1;
        while (length2 >= 0 && length3 >= 0 && threadTraceItem.oldStack[length2].equals(stackTraceElementArr[length3])) {
            length2--;
            length3--;
        }
        for (int i3 = 0; i3 <= length2; i3++) {
            logMethodTraceEvent(j, i2, i, threadTraceItem.oldStack[i3], 1);
        }
        while (length3 >= 0) {
            logMethodTraceEvent(j, i2, i, stackTraceElementArr[length3], 0);
            length3--;
        }
        threadTraceItem.oldStack = stackTraceElementArr;
        this.mThreadItemMap.put(Long.valueOf(j), threadTraceItem);
    }

    private void handleOldStack(long j) {
        ThreadTraceItem threadTraceItem = this.mThreadItemMap.get(Long.valueOf(j));
        if (threadTraceItem == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() * 1000;
        int i = (int) (uptimeMillis - this.mTraceStartTime);
        int i2 = (int) (uptimeMillis - threadTraceItem.startTime);
        for (int i3 = 0; i3 < threadTraceItem.oldStack.length; i3++) {
            logMethodTraceEvent(j, i2, i, threadTraceItem.oldStack[i3], 1);
        }
        threadTraceItem.oldStack = null;
    }

    private void logMethodTraceEvent(long j, int i, int i2, StackTraceElement stackTraceElement, int i3) {
        int i4 = this.mCacheIndex;
        int i5 = i4 + 14;
        byte[] bArr = this.mTraceCache;
        if (i5 >= bArr.length) {
            byte[] bArr2 = new byte[bArr.length + 8192];
            System.arraycopy(bArr, 0, bArr2, 0, i4);
            this.mTraceCache = bArr2;
        }
        append2Bytes((int) j);
        append4Bytes((getTraceMethodId(stackTraceElement) << 2) | i3);
        append4Bytes(i);
        append4Bytes(i2);
    }

    private int getTraceMethodId(StackTraceElement stackTraceElement) {
        Integer num = this.mMethodIdMap.get(stackTraceElement);
        if (num == null) {
            num = Integer.valueOf(this.mMethodIdMap.size());
            HashMap<StackTraceElement, Integer> hashMap = this.mMethodIdMap;
            hashMap.put(stackTraceElement, Integer.valueOf(hashMap.size()));
        }
        return num.intValue();
    }

    private void append2Bytes(int i) {
        byte[] bArr = this.mTraceCache;
        int i2 = this.mCacheIndex;
        this.mCacheIndex = i2 + 1;
        bArr[i2] = getByte(i, 0);
        byte[] bArr2 = this.mTraceCache;
        int i3 = this.mCacheIndex;
        this.mCacheIndex = i3 + 1;
        bArr2[i3] = getByte(i, 8);
    }

    private void append4Bytes(int i) {
        append2Bytes(i);
        byte[] bArr = this.mTraceCache;
        int i2 = this.mCacheIndex;
        this.mCacheIndex = i2 + 1;
        bArr[i2] = getByte(i, 16);
        byte[] bArr2 = this.mTraceCache;
        int i3 = this.mCacheIndex;
        this.mCacheIndex = i3 + 1;
        bArr2[i3] = getByte(i, 24);
    }

    private void append8Bytes(long j) {
        append4Bytes((int) j);
        byte[] bArr = this.mTraceCache;
        int i = this.mCacheIndex;
        this.mCacheIndex = i + 1;
        bArr[i] = getByte(j, 32);
        byte[] bArr2 = this.mTraceCache;
        int i2 = this.mCacheIndex;
        this.mCacheIndex = i2 + 1;
        bArr2[i2] = getByte(j, 40);
        byte[] bArr3 = this.mTraceCache;
        int i3 = this.mCacheIndex;
        this.mCacheIndex = i3 + 1;
        bArr3[i3] = getByte(j, 48);
        byte[] bArr4 = this.mTraceCache;
        int i4 = this.mCacheIndex;
        this.mCacheIndex = i4 + 1;
        bArr4[i4] = getByte(j, 56);
    }

    private String logTrace() {
        StringBuilder sb = new StringBuilder(400);
        sb.append("*version\n3\ndata-file-overflow=false\nclock=dual\nelapsed-time-usec=");
        sb.append((SystemClock.uptimeMillis() * 1000) - this.mTraceStartTime).append("\nnum-method-calls=");
        sb.append(this.mMethodIdMap.size()).append("\nclock-call-overhead-nsec=zzz\nvm=art\npid=");
        sb.append(Process.myPid()).append("\n*threads\n");
        for (Map.Entry<Long, ThreadTraceItem> entry : this.mThreadItemMap.entrySet()) {
            sb.append(entry.getKey()).append("\t").append(entry.getValue().threadName).append("\n");
        }
        sb.append("*methods\n");
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        for (Map.Entry<StackTraceElement, Integer> entry2 : this.mMethodIdMap.entrySet()) {
            StackTraceElement key = entry2.getKey();
            sb2.append("\t0x").append(Integer.toHexString(entry2.getValue().intValue() << 2));
            sb3.append("\tat ").append(key.getClassName()).append(".").append(key.getMethodName()).append("(").append(key.getFileName()).append(":").append(key.getLineNumber()).append(")\n");
        }
        sb.append((CharSequence) sb2).append("\n").append((CharSequence) sb3);
        sb.append("*end\n");
        sb.append(Base64.encodeToString(this.mTraceCache, 0, this.mCacheIndex, 2));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class ThreadTraceItem {
        StackTraceElement[] oldStack;
        long startTime;
        String threadName;

        ThreadTraceItem(String str, long j, StackTraceElement[] stackTraceElementArr) {
            this.threadName = str;
            this.startTime = j;
            this.oldStack = stackTraceElementArr;
        }
    }
}
