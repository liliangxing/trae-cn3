package com.bytedance.crash.anr;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.bdinstall.GWorker;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.crash.util.NumRanges;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AnrProfiler {
    private static final String FILE_NAME = "/anr_profiler";
    private long mNativeManager;

    public void start() {
        DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.anr.AnrProfiler.1
            @Override // java.lang.Runnable
            public void run() {
                if (AppMonitorConfigService.disableAnrProfiler()) {
                    return;
                }
                AnrProfiler.this.mNativeManager = NativeBridge.nAnrNativeProfilerStart();
                DefaultWorkThread.postDelayed(new Runnable() { // from class: com.bytedance.crash.anr.AnrProfiler.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnrProfiler.setMonitorJvm();
                    }
                }, WsConstants.EXIT_DELAY_TIME);
            }
        });
    }

    public static void startJvmLockMonitor(boolean z) {
        if (z) {
            DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.anr.AnrProfiler.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AppMonitorConfigService.disableAnrProfiler()) {
                        return;
                    }
                    try {
                        NativeBridge.startProfilerJavaLockMonitor();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public static synchronized void setMonitorJvm() {
        synchronized (AnrProfiler.class) {
            try {
                Thread thread = Looper.getMainLooper().getThread();
                Field declaredField = Thread.class.getDeclaredField("nativePeer");
                declaredField.setAccessible(true);
                int nAnrNativeProfilerJvmStart = NativeBridge.nAnrNativeProfilerJvmStart(declaredField.getLong(thread));
                int jvmMonitorState = NativeBridge.getJvmMonitorState();
                int apexVersion = NativeBridge.getApexVersion();
                AppMonitor appMonitor = MonitorManager.getAppMonitor();
                if (appMonitor != null) {
                    appMonitor.addTag("jvm_monitor_state", String.valueOf(jvmMonitorState));
                    appMonitor.addTag("apex_version", String.valueOf(apexVersion));
                }
                NpthLog.m227d("setMonitorJvm " + nAnrNativeProfilerJvmStart + ", " + jvmMonitorState);
            } catch (Throwable unused) {
            }
        }
    }

    public void stop() {
        long j = this.mNativeManager;
        if (j != 0) {
            NativeBridge.nAnrNativeProfilerStop(j);
        }
    }

    public void exit() {
        long j = this.mNativeManager;
        if (j != 0) {
            NativeBridge.nAnrNativeProfilerExit(j);
        }
    }

    public void dumpWithNativeInfo(File file, long j) {
        long j2 = this.mNativeManager;
        if (j2 != 0) {
            NativeBridge.nAnrNativeProfilerDump(j2, file + "/anr_profiler.inf", j);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class Parser {
        private static final String ANR_ML_FEATURES = "anr_ml_features";
        private static final String FILTER_PREFIX = "npth_profiler_";
        private static final String MEMORY_STREAM = "MEMORY_STREAM";
        private static final int PARAMS_ANR_INFO = 3;
        private static final int PARAMS_ANR_TIME = 0;
        private static final int PARAMS_HEAP_SIZE = 4;
        private static final int PARAMS_LEFT_TS = 2;
        private static final int PARAMS_LOGCAT_GC_SCORE = 8;
        private static final int PARAMS_MAX = 9;
        private static final int PARAMS_RIGHT_TS = 1;
        private static final int PARAMS_TRACE_FILE = 5;
        private static final int PARAMS_TRACE_STM = 7;
        private static final int PARAMS_TRACE_UTM = 6;
        private static final String SCHED_STREAM = "SCHED_STREAM";
        private static final String TAG_ANR_REASON = "ANR_REASON";
        private static final String TAG_ANR_TIME = "ANR_TIME";
        private static final String TAG_CPU_FREQS = "CPU_FREQS";
        private static final String TAG_CPU_JIFFS = "CPU_JIFFS";
        private static final String TAG_CPU_LOADS = "CPU_LOADS";
        private static final String TAG_CPU_SCHED = "CPU_SCHED";
        private static final String TAG_DURATION = "DURATION";
        private static final String TAG_GC_STATE = "GC_STATE";
        private static final String TAG_JVM_STATE = "JVM_STATE";
        private static final String TAG_PAGE_FAULT = "PAGE_FAULT";
        private static final String TAG_PROC_MEMORY = "PROC_MEMORY";
        private static final String TAG_SYS_MEMORY = "SYS_MEMORY";
        private boolean isSuccess = false;
        private final File mDirectory;

        private static Pair<Long, Long> getLongestMsgRange(JSONObject jSONObject) {
            long j;
            long j2;
            JSONObject optJSONObject;
            JSONObject optJSONObject2 = jSONObject.optJSONObject(CrashBody.LOGCAT_ANR_INFO);
            if (optJSONObject2 != null) {
                long optLong = optJSONObject2.optLong("cost");
                j2 = optJSONObject2.optLong("longMsgEnd");
                if (optLong >= 1000 && j2 > optLong) {
                    j = j2 - optLong;
                    if (j == -1 && (optJSONObject = jSONObject.optJSONObject("history_details")) != null) {
                        j = optJSONObject.optLong("longestMsgStartWallTime");
                        j2 = optJSONObject.optLong("longestMsgEndWallTime");
                    }
                    return new Pair<>(Long.valueOf(j), Long.valueOf(j2));
                }
            }
            j = -1;
            j2 = -1;
            if (j == -1) {
                j = optJSONObject.optLong("longestMsgStartWallTime");
                j2 = optJSONObject.optLong("longestMsgEndWallTime");
            }
            return new Pair<>(Long.valueOf(j), Long.valueOf(j2));
        }

        long[] buildPriorParameters(JSONObject jSONObject, AnrTraceParser anrTraceParser, AnrInfoParser anrInfoParser) {
            long[] jArr = new long[9];
            jArr[0] = jSONObject.optLong("crash_time");
            Pair<Long, Long> longestMsgRange = getLongestMsgRange(jSONObject);
            jArr[2] = ((Long) longestMsgRange.first).longValue();
            jArr[1] = ((Long) longestMsgRange.second).longValue();
            if (anrInfoParser.isValid()) {
                jArr[3] = anrInfoParser.mCloserCpuUsage != null ? 4294967296L | ((int) anrInfoParser.mCloserCpuUsage.mKswapdTotalRatio) : 4294967296L;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("app_memory_info");
            long optLong = (optJSONObject == null || !optJSONObject.has("max_memory")) ? 0L : (optJSONObject.optLong("max_memory") / 1024) / 1024;
            if (optLong <= 0 || optLong > 1024) {
                optLong = (Runtime.getRuntime().maxMemory() / 1024) / 1024;
            }
            jArr[4] = optLong;
            if (anrTraceParser.hasMainStack()) {
                jArr[5] = (anrTraceParser.isWaitForGc() ? 2L : 0L) | 1 | (anrTraceParser.isPerformingGc() ? 4L : 0L) | (anrTraceParser.isLockedByJava() ? 8L : 0L) | (anrTraceParser.isLockedByNative() ? 16L : 0L);
                jArr[6] = anrTraceParser.getUserTick();
                jArr[7] = anrTraceParser.getSysTick();
            }
            jArr[8] = jSONObject.optJSONObject(CrashBody.LOGCAT_GC_INFO) != null ? r9.optInt("gcScore") : 0;
            return jArr;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Parser(File file, JSONObject jSONObject, AnrTraceParser anrTraceParser, AnrInfoParser anrInfoParser) {
            this.mDirectory = file;
            NativeBridge.nAnrNativeProfilerFormat(file + "/anr_profiler.inf", buildPriorParameters(jSONObject, anrTraceParser, anrInfoParser));
        }

        private void pushCpuSchedToFilters(JSONObject jSONObject, String str) {
            char c;
            Matcher matcher = Pattern.compile("^ Exec \\d+\\.\\d+\\((\\d+)%\\), Wait (.*), Sleep (.*), IOWait (.*)$").matcher(str);
            if (matcher.find()) {
                char c2 = 4;
                if (matcher.groupCount() != 4) {
                    return;
                }
                NumRanges numRanges = new NumRanges("%");
                numRanges.set(new Long[]{0L, 1L, 10L, 25L, 50L, 75L, 100L});
                JSONUtils.put(jSONObject, "npth_profiler_exec_ratio", numRanges.get(Integer.parseInt(matcher.group(1))));
                String[] strArr = {"wait_ratio", "sleep_ratio", "iowait_ratio"};
                int i = 0;
                while (i < 3) {
                    String group = matcher.group(i + 2);
                    String str2 = "---";
                    if ("---".equals(group)) {
                        c = c2;
                    } else {
                        Matcher matcher2 = Pattern.compile("^\\d+\\.\\d+\\((\\d+)%\\)$").matcher(group);
                        if (matcher2.find() && matcher2.groupCount() == 1) {
                            if (i == 2) {
                                c = 4;
                                numRanges.set(new Long[]{0L, 1L, 5L, 10L, 25L, 50L, 75L, 100L});
                            } else {
                                c = 4;
                            }
                            str2 = numRanges.get(Integer.parseInt(matcher2.group(1)));
                            JSONUtils.put(jSONObject, FILTER_PREFIX + strArr[i], str2);
                            i++;
                            c2 = c;
                        } else {
                            c = 4;
                        }
                    }
                    JSONUtils.put(jSONObject, FILTER_PREFIX + strArr[i], str2);
                    i++;
                    c2 = c;
                }
            }
        }

        private void pushCpuLoadsToFilters(JSONObject jSONObject, String str) {
            Matcher matcher = Pattern.compile("^ (\\d+)\\.\\d{2} \\(.*\\)$").matcher(str);
            if (matcher.find() && matcher.groupCount() == 1) {
                int parseInt = Integer.parseInt(matcher.group(1));
                NumRanges numRanges = new NumRanges("");
                numRanges.set(new Long[]{0L, 4L, 10L, 30L, 60L, 100L, 150L, 200L});
                JSONUtils.put(jSONObject, "npth_profiler_loads", numRanges.get(parseInt));
            }
        }

        private void pushCpuFrequenciesToFilters(JSONObject jSONObject, String str) {
            int i;
            Matcher matcher = Pattern.compile("^ (\\d{1,2})% (.+)$").matcher(str);
            if (!matcher.find()) {
                JSONUtils.put(jSONObject, "npth_profiler_cpu_efficiency", "unavailable");
                return;
            }
            int parseInt = Integer.parseInt(matcher.group(1));
            NumRanges numRanges = new NumRanges("%");
            numRanges.set(0L, 100L, 10L);
            JSONUtils.put(jSONObject, "npth_profiler_cpu_efficiency", numRanges.get(parseInt));
            Matcher matcher2 = Pattern.compile("\\[(\\d+\\.\\d+)-\\d+\\.\\d+\\]\\{([\\d-]+)\\}(?:,\\\\s*)?").matcher(matcher.group(2));
            double d = 0.0d;
            while (matcher2.find()) {
                double parseDouble = Double.parseDouble(matcher2.group(1));
                String group = matcher2.group(2);
                if (group == null || !group.contains("-")) {
                    i = 1;
                } else {
                    String[] split = group.split("-");
                    i = (Integer.parseInt(split[1]) - Integer.parseInt(split[0])) + 1;
                }
                d += parseDouble * i;
            }
            JSONUtils.put(jSONObject, "npth_profiler_cpu_total_power", Long.valueOf((long) d));
        }

        private void pushCpuJiffiesToFilters(JSONObject jSONObject, String str) {
            Matcher matcher = Pattern.compile("^ Thread \\d+ = (\\d+) \\+ (\\d+), Process \\d+ = (\\d+) \\+ (\\d+)$").matcher(str);
            if (matcher.find() && matcher.groupCount() == 4) {
                int parseInt = Integer.parseInt(matcher.group(1));
                int parseInt2 = Integer.parseInt(matcher.group(2));
                int parseInt3 = Integer.parseInt(matcher.group(3));
                int parseInt4 = Integer.parseInt(matcher.group(4));
                NumRanges numRanges = new NumRanges("%");
                numRanges.set(new Long[]{0L, 1L, 10L, 25L, 50L, 75L, 100L});
                int i = parseInt4 + parseInt3;
                if (i != 0) {
                    JSONUtils.put(jSONObject, "npth_profiler_jiff_thread_ratio", numRanges.get(((parseInt + parseInt2) * 100) / i));
                }
                if (parseInt2 + parseInt != 0) {
                    JSONUtils.put(jSONObject, "npth_profiler_jiff_thread_user_ratio", numRanges.get((parseInt * 100) / r4));
                }
                if (i != 0) {
                    JSONUtils.put(jSONObject, "npth_profiler_jiff_process_user_ratio", numRanges.get((parseInt3 * 100) / i));
                }
            }
        }

        private void pushPageFaultToFilters(JSONObject jSONObject, String str) {
            Matcher matcher = Pattern.compile("^ Thread (\\d+) (\\d+), Process (\\d+) (\\d+)$").matcher(str);
            if (matcher.find() && matcher.groupCount() == 4) {
                NumRanges numRanges = new NumRanges("");
                int i = 0;
                numRanges.set(new Long[]{0L, 1L, 10L, 100L, 1000L, Long.valueOf(GWorker.INTERVAL), 100000L});
                String[] strArr = {"thread_minor", "thread_major", "process_minor", "process_major"};
                while (i < 4) {
                    int i2 = i + 1;
                    JSONUtils.put(jSONObject, "npth_profiler_fault_" + strArr[i], numRanges.get(Long.parseLong(matcher.group(i2))));
                    i = i2;
                }
            }
        }

        private void pushProcessMemoryToFilters(JSONObject jSONObject, String str) {
            Matcher matcher = Pattern.compile("^ VSS \\d+\\([+-]\\d+\\)MB, RSS (\\d+)\\([+-]\\d+\\)MB, SWAP (\\d+)\\([+-]\\d+\\)MB$").matcher(str);
            if (matcher.find() && matcher.groupCount() == 2) {
                long parseLong = Long.parseLong(matcher.group(1)) + Long.parseLong(matcher.group(2));
                NumRanges numRanges = new NumRanges("MB");
                numRanges.set(new Long[]{0L, 1L, 64L, 128L, 256L, 512L, 768L, 1024L, 1536L, 2048L});
                JSONUtils.put(jSONObject, "npth_profiler_procram_total", numRanges.get(parseLong));
            }
        }

        private void pushSystemMemoryToFilters(JSONObject jSONObject, String str) {
            Matcher matcher = Pattern.compile("^ Total (\\d+)MB, Used \\d+\\([+-]\\d+\\)MB, Free \\d+\\([+-]\\d+\\)MB, Swapped (\\d+)\\(([+-])(\\d+)\\)MB$").matcher(str);
            if (matcher.find() && matcher.groupCount() == 4) {
                long parseLong = Long.parseLong(matcher.group(1));
                long parseLong2 = Long.parseLong(matcher.group(2));
                String group = matcher.group(3);
                long parseLong3 = Long.parseLong(matcher.group(4));
                JSONUtils.put(jSONObject, "npth_profiler_sysram_total_size", ((parseLong / 1024) + 1) + "GB");
                NumRanges numRanges = new NumRanges("MB");
                numRanges.set(new Long[]{0L, 1L, 128L, 256L, 512L, 1024L, 1536L, 2048L, 3072L, 4096L});
                JSONUtils.put(jSONObject, "npth_profiler_sysram_swapped_size", numRanges.get(parseLong2));
                numRanges.set(new Long[]{0L, 1L, 16L, 32L, 64L, 128L, 256L, 512L});
                JSONUtils.put(jSONObject, "npth_profiler_sysram_swapped_delta", group + " " + numRanges.get(parseLong3));
            }
        }

        private void pushGcStateToFilters(JSONObject jSONObject, String str) {
            Matcher matcher = Pattern.compile("^ JavaHeap \\d+MB, Time (\\d+)\\.(\\d+), BlockTime (\\d+)\\.(\\d+), Count (\\d+), BlockCount (\\d+), MainWaitGcTime (\\d+)\\.(\\d+), MainGcTime (\\d+)\\.(\\d+)$").matcher(str);
            if (matcher.find() && matcher.groupCount() == 10) {
                long parseLong = (Long.parseLong(matcher.group(1)) * 1000) + Long.parseLong(matcher.group(2));
                long parseLong2 = (Long.parseLong(matcher.group(3)) * 1000) + Long.parseLong(matcher.group(4));
                long parseLong3 = Long.parseLong(matcher.group(5));
                long parseLong4 = Long.parseLong(matcher.group(6));
                long parseLong5 = (Long.parseLong(matcher.group(7)) * 1000) + Long.parseLong(matcher.group(8));
                long parseLong6 = (Long.parseLong(matcher.group(9)) * 1000) + Long.parseLong(matcher.group(10));
                NumRanges numRanges = new NumRanges("ms");
                numRanges.set(new Long[]{0L, 1L, 500L, 1000L, 1500L, 2000L, Long.valueOf(WsConstants.EXIT_DELAY_TIME), Long.valueOf(PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS)});
                JSONUtils.put(jSONObject, "npth_profiler_gc_time", numRanges.get(parseLong));
                JSONUtils.put(jSONObject, "npth_profiler_gc_block_time", numRanges.get(parseLong2));
                JSONUtils.put(jSONObject, "npth_profiler_main_wait_gc_time", numRanges.get(parseLong5));
                JSONUtils.put(jSONObject, "npth_profiler_main_gc_time", numRanges.get(parseLong6));
                NumRanges numRanges2 = new NumRanges("");
                numRanges2.set(new Long[]{0L, 1L, 5L, 10L, 50L, 100L});
                JSONUtils.put(jSONObject, "npth_profiler_gc_count", numRanges2.get(parseLong3));
                JSONUtils.put(jSONObject, "npth_profiler_gc_block_count", numRanges2.get(parseLong4));
            }
        }

        private void pushJvmStateToFilters(JSONObject jSONObject, String str) {
            Matcher matcher = Pattern.compile("^ JavaLock (.*)$").matcher(str);
            if (matcher.find() && matcher.groupCount() == 1) {
                JSONUtils.put(jSONObject, "npth_profiler_java_lock_owner", matcher.group(1));
            }
        }

        private void pushAnrReasonToFilters(JSONObject jSONObject, String str) {
            JSONUtils.put(jSONObject, "npth_profiler_anr_reason", str.trim());
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:21:0x00e0. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        public void pushToFilters(JSONObject jSONObject) {
            File file = new File(this.mDirectory + "/anr_profiler.txt");
            if (!file.exists()) {
                return;
            }
            BufferedReader bufferedReader = null;
            String str = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                Object[] objArr = false;
                String str2 = null;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            String[] split = readLine.split(">");
                            char c = 2;
                            if (split.length == 2) {
                                String trim = split[0].trim();
                                try {
                                    switch (trim.hashCode()) {
                                        case -1771995437:
                                            if (trim.equals(TAG_SYS_MEMORY)) {
                                                c = '\n';
                                                break;
                                            }
                                            break;
                                        case -1427608066:
                                            if (trim.equals(TAG_ANR_REASON)) {
                                                c = '\b';
                                                break;
                                            }
                                            break;
                                        case -1276471214:
                                            if (trim.equals(TAG_PAGE_FAULT)) {
                                                c = 5;
                                                break;
                                            }
                                            break;
                                        case -1209385580:
                                            if (trim.equals(TAG_DURATION)) {
                                                c = 0;
                                                break;
                                            }
                                            break;
                                        case -892691330:
                                            if (trim.equals(MEMORY_STREAM)) {
                                                c = '\f';
                                                break;
                                            }
                                            break;
                                        case -523188726:
                                            if (trim.equals(TAG_PROC_MEMORY)) {
                                                c = '\t';
                                                break;
                                            }
                                            break;
                                        case -315273688:
                                            if (trim.equals(SCHED_STREAM)) {
                                                c = 11;
                                                break;
                                            }
                                            break;
                                        case 1317675854:
                                            if (trim.equals(TAG_GC_STATE)) {
                                                c = 6;
                                                break;
                                            }
                                            break;
                                        case 1367485235:
                                            if (trim.equals(TAG_JVM_STATE)) {
                                                c = 7;
                                                break;
                                            }
                                            break;
                                        case 2060837732:
                                            if (trim.equals(TAG_CPU_FREQS)) {
                                                c = 4;
                                                break;
                                            }
                                            break;
                                        case 2064264317:
                                            if (trim.equals(TAG_CPU_JIFFS)) {
                                                c = 3;
                                                break;
                                            }
                                            break;
                                        case 2066285238:
                                            if (trim.equals(TAG_CPU_LOADS)) {
                                                c = 1;
                                                break;
                                            }
                                            break;
                                        case 2072399136:
                                            if (trim.equals(TAG_CPU_SCHED)) {
                                                break;
                                            }
                                            break;
                                    }
                                    c = 65535;
                                    switch (c) {
                                        case 0:
                                            Pair aNRTime = AnrProfiler.getANRTime(split[1]);
                                            if (aNRTime == null) {
                                                break;
                                            } else {
                                                String str3 = (String) aNRTime.second;
                                                try {
                                                    str = (String) aNRTime.first;
                                                } catch (Throwable unused) {
                                                }
                                                str2 = str3;
                                                break;
                                            }
                                        case 1:
                                            pushCpuLoadsToFilters(jSONObject, split[1]);
                                            break;
                                        case 2:
                                            pushCpuSchedToFilters(jSONObject, split[1]);
                                            break;
                                        case 3:
                                            pushCpuJiffiesToFilters(jSONObject, split[1]);
                                            break;
                                        case 4:
                                            pushCpuFrequenciesToFilters(jSONObject, split[1]);
                                            break;
                                        case 5:
                                            pushPageFaultToFilters(jSONObject, split[1]);
                                            break;
                                        case 6:
                                            pushGcStateToFilters(jSONObject, split[1]);
                                            break;
                                        case 7:
                                            pushJvmStateToFilters(jSONObject, split[1]);
                                            break;
                                        case '\b':
                                            pushAnrReasonToFilters(jSONObject, split[1]);
                                            pushProcessMemoryToFilters(jSONObject, split[1]);
                                            break;
                                        case '\t':
                                            pushProcessMemoryToFilters(jSONObject, split[1]);
                                            break;
                                        case '\n':
                                            pushSystemMemoryToFilters(jSONObject, split[1]);
                                            break;
                                        case 11:
                                            objArr = true;
                                            break;
                                        case '\f':
                                            objArr = false;
                                            break;
                                    }
                                } catch (Throwable unused2) {
                                }
                            } else if (objArr != false) {
                                pushSchedStream(jSONObject, readLine, str, str2);
                            }
                        } else {
                            FileSystemUtils.close(bufferedReader2);
                            return;
                        }
                    } catch (Throwable unused3) {
                        bufferedReader = bufferedReader2;
                        FileSystemUtils.close(bufferedReader);
                        return;
                    }
                }
            } catch (Throwable unused4) {
            }
        }

        public void pushToCrashBody(JSONObject jSONObject, File file) {
            String readUtf8File = FileSystemUtils.readUtf8File(new File(file, "anr_ml_features.json"));
            if (readUtf8File != null) {
                try {
                    JSONUtils.combineJson(jSONObject, new JSONObject(readUtf8File));
                } catch (Throwable unused) {
                }
            }
            try {
                String readFile = FileUtils.readFile(new File(file, "/anr_profiler.txt"));
                JSONUtils.put(jSONObject, "anr_profiler", readFile);
                if (readFile.isEmpty() || readFile.length() <= 10) {
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("filters");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                    jSONObject.put("filters", optJSONObject);
                }
                JSONUtils.put(optJSONObject, "has_anr_profiler", "true");
            } catch (Throwable unused2) {
            }
        }

        private static String getTime(String str) {
            String str2 = null;
            try {
                str2 = str.trim().split(" ")[1];
                return TextUtils.isEmpty(str2) ? "" : str2.substring(0, 8);
            } catch (Exception unused) {
                return str2;
            }
        }

        private void pushSchedStream(JSONObject jSONObject, String str, String str2, String str3) {
            if (this.isSuccess) {
                return;
            }
            try {
                String[] split = str.trim().split(" ");
                String str4 = split[0];
                int parseInt = Integer.parseInt(split[3]);
                if (str4.startsWith(str2)) {
                    if (jSONObject.has("lifecycle_from_adj")) {
                        boolean optBoolean = jSONObject.optBoolean(Constants.IS_BACKGROUND_ADJ);
                        boolean z = parseInt > 200;
                        StringBuilder sb = new StringBuilder();
                        String str5 = "b";
                        sb.append(z ? "b" : "f");
                        sb.append("_");
                        if (!optBoolean) {
                            str5 = "f";
                        }
                        sb.append(str5);
                        jSONObject.put("anr_process_lifecycle", sb);
                    }
                    try {
                        jSONObject.put("npth_profiler_main_nice", String.valueOf(split[4]));
                    } catch (Throwable unused) {
                    }
                    try {
                        jSONObject.put("npth_profiler_main_group", split[2]);
                    } catch (Throwable unused2) {
                    }
                    try {
                        jSONObject.put("npth_profiler_process_adj", split[3]);
                    } catch (Throwable unused3) {
                    }
                    this.isSuccess = true;
                    return;
                }
                if (!str4.startsWith(str3)) {
                    return;
                }
                try {
                    jSONObject.put(Constants.IS_BACKGROUND_ADJ, parseInt > 200);
                    jSONObject.put("lifecycle_from_adj", 1);
                } catch (Throwable unused4) {
                }
            } catch (Throwable th) {
                NpthMonitor.reportInnerException("pushLifecycleFilters", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Pair<String, String> getANRTime(String str) {
        try {
            int indexOf = str.indexOf(40);
            int lastIndexOf = str.lastIndexOf(41);
            int indexOf2 = str.indexOf("to");
            return new Pair<>(str.substring(indexOf + 12, indexOf2 - 5), str.substring(indexOf2 + 14, lastIndexOf - 4));
        } catch (Exception e) {
            NpthMonitor.reportInnerException("getANRTime", e);
            return null;
        }
    }
}
