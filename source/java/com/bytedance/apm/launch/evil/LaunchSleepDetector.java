package com.bytedance.apm.launch.evil;

import android.os.Looper;
import android.os.Process;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.ExceptionTypeName;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.ExceptionLogData;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.launch.LaunchSceneHelper;
import com.bytedance.apm.thread.ApmHandlerThread;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.StackUtils;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LaunchSleepDetector {
    private static final long DETECT_INTERVAL = 10;
    private static final String LAUNCH_SLEEP_DETECTOR = "launch_sleep_detector";
    private static final String NATIVE_POLL_ONCE = "MessageQueue.nativePollOnce";
    private static final String PROC_FILE_PATH = "/proc/%d/task/%d/status";
    private static final String REPORT_TAG = "is_launch_sleep";
    private static boolean alreadyAdd;
    private static volatile boolean isStart;
    private static State lastState = State.NONE;
    private static long lastSwitchers = -1;
    private static long currentSleepCost = 0;
    private static String currentSleepStack = "";
    private static long TIMER_TO_STOP_DEFAULT = 8000;
    private static long totalSleepCost = 0;
    private static ExecutorService sSleepDetect = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.bytedance.apm.launch.evil.LaunchSleepDetector.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(LaunchSleepDetector.LAUNCH_SLEEP_DETECTOR);
            return thread;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public enum State {
        NONE,
        SLEEP,
        NOT_SLEEP,
        DISK_SLEEP
    }

    public static void startDetect() {
        if (LaunchSceneHelper.getFirstActivityIntent() == null || isStart) {
            return;
        }
        isStart = true;
        final String format = String.format(Locale.US, PROC_FILE_PATH, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myPid()));
        sSleepDetect.execute(new Runnable() { // from class: com.bytedance.apm.launch.evil.LaunchSleepDetector.2
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10L);
                    } catch (Throwable unused) {
                    }
                    if (!LaunchSleepDetector.isStart) {
                        return;
                    }
                    BufferedReader bufferedReader = null;
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(format), 100);
                        try {
                            State state = State.NONE;
                            long j = 0;
                            while (true) {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (readLine.contains("State:")) {
                                    if (readLine.contains("sleeping")) {
                                        state = State.SLEEP;
                                    } else if (readLine.contains("disk")) {
                                        state = State.DISK_SLEEP;
                                    } else {
                                        state = State.NOT_SLEEP;
                                    }
                                } else if (readLine.contains("nonvoluntary_ctxt_switches")) {
                                    j += Long.parseLong(readLine.substring(readLine.lastIndexOf("\t") + 1));
                                    break;
                                } else if (readLine.contains("voluntary_ctxt_switches")) {
                                    j += Long.parseLong(readLine.substring(readLine.lastIndexOf("\t") + 1));
                                }
                            }
                            if (state != LaunchSleepDetector.lastState || state != State.SLEEP || j != LaunchSleepDetector.lastSwitchers) {
                                if (LaunchSleepDetector.alreadyAdd) {
                                    LaunchSleepDetector.reportLongSleepData(LaunchSleepDetector.currentSleepCost, LaunchSleepDetector.currentSleepStack);
                                    LaunchSleepDetector.totalSleepCost += LaunchSleepDetector.currentSleepCost;
                                    long unused2 = LaunchSleepDetector.currentSleepCost = 0L;
                                    String unused3 = LaunchSleepDetector.currentSleepStack = "";
                                }
                                boolean unused4 = LaunchSleepDetector.alreadyAdd = false;
                            } else {
                                if (!LaunchSleepDetector.alreadyAdd) {
                                    String unused5 = LaunchSleepDetector.currentSleepStack = StackUtils.getStackTraces(Looper.getMainLooper().getThread().getStackTrace());
                                    boolean unused6 = LaunchSleepDetector.alreadyAdd = true;
                                }
                                if (LaunchSleepDetector.currentSleepStack.contains(LaunchSleepDetector.NATIVE_POLL_ONCE)) {
                                    String unused7 = LaunchSleepDetector.currentSleepStack = "";
                                }
                                LaunchSleepDetector.currentSleepCost += 10;
                            }
                            State unused8 = LaunchSleepDetector.lastState = state;
                            long unused9 = LaunchSleepDetector.lastSwitchers = j;
                            try {
                                bufferedReader2.close();
                            } catch (Throwable unused10) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            try {
                                LaunchAnalysisContext.getInstance().logE("error to parse /proc/stats file: " + th.getLocalizedMessage());
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                            } catch (Throwable th2) {
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable unused11) {
                                    }
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            }
        });
        ApmHandlerThread.getDefaultMainHandler().postDelayed(new Runnable() { // from class: com.bytedance.apm.launch.evil.LaunchSleepDetector.3
            @Override // java.lang.Runnable
            public void run() {
                LaunchSleepDetector.stopDetect();
            }
        }, TIMER_TO_STOP_DEFAULT);
    }

    public static void stopDetect() {
        if (isStart) {
            isStart = false;
            lastState = State.NONE;
            lastSwitchers = -1L;
            currentSleepCost = 0L;
            currentSleepStack = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportLongSleepData(final long j, final String str) {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.launch.evil.LaunchSleepDetector.4
            @Override // java.lang.Runnable
            public void run() {
                if (j == 0 || str.isEmpty()) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("timestamp", System.currentTimeMillis());
                    jSONObject.put("crash_time", System.currentTimeMillis());
                    jSONObject.put("is_main_process", ApmContext.isMainProcess());
                    jSONObject.put("process_name", ApmContext.getCurrentProcessName());
                    jSONObject.put(CommonKey.KEY_BLOCK_DURATION, j);
                    StringBuilder sb = new StringBuilder("SleepInfo:\n-Sleep Time ");
                    sb.append(j).append("ms\n-Sleep Stack\n").append(str).append("\n");
                    jSONObject.put("stack", sb.toString());
                    jSONObject.put("event_type", ExceptionTypeName.EXCEPTION_EVENT_TYPE_LAG);
                    JSONObject perfFiltersJson = PerfFilterManager.getInstance().getPerfFiltersJson();
                    perfFiltersJson.put(CommonKey.KEY_BLOCK_STACK_TYPE, "stack");
                    perfFiltersJson.put(LaunchSleepDetector.REPORT_TAG, "true");
                    jSONObject.put("filters", perfFiltersJson);
                    LaunchAnalysisContext.getInstance().logD("sleep report json: " + jSONObject);
                    CommonDataPipeline.getInstance().handle(new ExceptionLogData("block_monitor", jSONObject));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
