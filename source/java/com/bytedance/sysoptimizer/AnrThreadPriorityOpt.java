package com.bytedance.sysoptimizer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Debug;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.GetHeldByThreadOpt;
import com.bytedance.sysoptimizer.anr.AnrListener;
import com.bytedance.sysoptimizer.anr.AnrManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: classes5.dex */
public class AnrThreadPriorityOpt {
    private static final String TAG = "AnrThreadPriorityOpt";
    private static final String THREAD_PRIORTY_INTENT = "debug_thread_priorty_intent";
    private static List<String> sThreadPriortyWhiteList = new ArrayList();
    private static HashMap<Integer, Integer> lastThreadPriortyMap = new HashMap<>();
    private static DebugBroadcastReceiver myBroadcastReceiver = new DebugBroadcastReceiver();
    private static volatile boolean sInit = false;
    private static boolean sDebug = false;
    private static boolean sEnableLockOpt = false;
    private static AnrListener mAnrListener = new AnrListener() { // from class: com.bytedance.sysoptimizer.AnrThreadPriorityOpt.1
        volatile boolean isOpt = false;

        @Override // com.bytedance.sysoptimizer.anr.AnrListener
        public void onAnrChange(boolean z, int i, AnrManager.AnrReason anrReason) {
            try {
                if (z) {
                    if (this.isOpt) {
                        return;
                    }
                    this.isOpt = true;
                    Log.d(AnrThreadPriorityOpt.TAG, "ANR coming...setThreadPriorty");
                    HashMap unused = AnrThreadPriorityOpt.lastThreadPriortyMap = AnrThreadPriorityOpt.getAllThreadPriorty();
                    Log.d(AnrThreadPriorityOpt.TAG, "lastThreadPriortyMap size:" + AnrThreadPriorityOpt.lastThreadPriortyMap.size());
                    AnrThreadPriorityOpt.setThreadPriorty(AnrThreadPriorityOpt.lastThreadPriortyMap);
                    if (AnrThreadPriorityOpt.sEnableLockOpt) {
                        try {
                            GetHeldByThreadOpt.ThreadData threadDataForLockMonitor = GetHeldByThreadOpt.getThreadDataForLockMonitor(Looper.getMainLooper().getThread());
                            if (threadDataForLockMonitor.thread != null && !threadDataForLockMonitor.deadLock) {
                                Log.d(AnrThreadPriorityOpt.TAG, "main thread block thread tid:" + threadDataForLockMonitor.tid + ", setThreadPriorty -20");
                                int threadPriority = Process.getThreadPriority(threadDataForLockMonitor.tid);
                                if (threadPriority > -16) {
                                    AnrThreadPriorityOpt.lastThreadPriortyMap.put(Integer.valueOf(threadDataForLockMonitor.tid), Integer.valueOf(threadPriority));
                                    Process.setThreadPriority(threadDataForLockMonitor.tid, -16);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (AnrThreadPriorityOpt.sDebug) {
                        AnrThreadPriorityOpt.getAllThreadPriorty();
                    }
                    Log.d(AnrThreadPriorityOpt.TAG, "lastThreadPriortyMap size:" + AnrThreadPriorityOpt.lastThreadPriortyMap.size());
                    return;
                }
                this.isOpt = false;
                Log.d(AnrThreadPriorityOpt.TAG, "ANR restore...restoreThreadPriorty");
                Log.d(AnrThreadPriorityOpt.TAG, "lastThreadPriortyMap size:" + AnrThreadPriorityOpt.lastThreadPriortyMap.size());
                AnrThreadPriorityOpt.restoreThreadPriorty(AnrThreadPriorityOpt.lastThreadPriortyMap);
                if (AnrThreadPriorityOpt.sDebug) {
                    AnrThreadPriorityOpt.getAllThreadPriorty();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };

    public static void init(Context context, List<String> list, boolean z) {
        if (!sInit) {
            sInit = true;
            sDebug = z;
            if (list != null) {
                sThreadPriortyWhiteList = list;
            }
            localTestDebug(context, Boolean.valueOf(z));
            AnrManager.getInstance().registerListener(mAnrListener);
            Log.d(TAG, "init sucess");
            return;
        }
        Log.d(TAG, "already init");
    }

    public static void enableLockOpt(Boolean bool) {
        sEnableLockOpt = bool.booleanValue();
    }

    private static String getThreadName(int i) {
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
        } catch (IOException e) {
            e.printStackTrace();
            return "Unknown";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void restoreThreadPriorty(HashMap<Integer, Integer> hashMap) {
        if (hashMap == null || hashMap.size() <= 0) {
            return;
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int intValue = entry.getKey().intValue();
            int intValue2 = entry.getValue().intValue();
            Log.d(TAG, "restore tid: " + intValue + ", lastPriorty priorty: " + intValue2);
            try {
                if (Process.getThreadPriority(intValue) == 0) {
                    Process.setThreadPriority(intValue, intValue2);
                }
            } catch (Throwable unused) {
            }
        }
        hashMap.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setThreadPriorty(HashMap<Integer, Integer> hashMap) {
        if (hashMap == null || hashMap.size() <= 0) {
            return;
        }
        int myPid = Process.myPid();
        Iterator<Map.Entry<Integer, Integer>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            int intValue = it.next().getKey().intValue();
            Log.d(TAG, "set tid: " + intValue + ", priorty: 0");
            if (myPid == intValue) {
                try {
                    Process.setThreadPriority(intValue, -20);
                } catch (Throwable unused) {
                }
            } else if (Process.getThreadPriority(intValue) < 0) {
                Process.setThreadPriority(intValue, 0);
            }
        }
    }

    public static HashMap<Integer, Integer> getAllThreadPriorty() {
        File[] listFiles;
        long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        File file = new File("/proc/self/task");
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                try {
                    int parseInt = Integer.parseInt(file2.getName());
                    int threadPriority = Process.getThreadPriority(parseInt);
                    if (threadPriority < 0) {
                        String threadName = getThreadName(parseInt);
                        if (!sThreadPriortyWhiteList.contains(threadName)) {
                            hashMap.put(Integer.valueOf(parseInt), Integer.valueOf(threadPriority));
                            Log.d(TAG, "tid:" + parseInt + ", priorty:" + threadPriority + ", thread name:" + threadName);
                        } else {
                            Log.d(TAG, "tid:" + parseInt + ", priorty:" + threadPriority + ", WhiteList thread name:" + threadName);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Log.d(TAG, "use cpu time:" + ((Debug.threadCpuTimeNanos() - threadCpuTimeNanos) / 1000000));
        return hashMap;
    }

    private static void localTestDebug(Context context, Boolean bool) {
        if (bool.booleanValue()) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(THREAD_PRIORTY_INTENT);
            INVOKEVIRTUAL_com_bytedance_sysoptimizer_AnrThreadPriorityOpt_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(context, myBroadcastReceiver, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class DebugBroadcastReceiver extends BroadcastReceiver {
        private static final String TAG = "AnrOptTaskReceiver";

        private DebugBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.d(TAG, "Received broadcast: " + action);
            if (action != null) {
                action.hashCode();
                if (action.equals(AnrThreadPriorityOpt.THREAD_PRIORTY_INTENT)) {
                    AnrThreadPriorityOpt.getAllThreadPriorty();
                } else {
                    Log.d(TAG, "Unhandled broadcast: " + action);
                }
            }
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    public static Intent INVOKEVIRTUAL_com_bytedance_sysoptimizer_AnrThreadPriorityOpt_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}
