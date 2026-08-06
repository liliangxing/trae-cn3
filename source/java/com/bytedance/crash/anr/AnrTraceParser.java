package com.bytedance.crash.anr;

import android.text.TextUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.bdinstall.GWorker;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.dumper.BuildId;
import com.bytedance.crash.dumper.JavaStack;
import com.bytedance.crash.dumper.ProcInfo;
import com.bytedance.crash.entity.CrashFilter;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import io.reactivex.annotations.SchedulerSupport;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AnrTraceParser {
    private static final String BACKUP_TRACE_FILE_NAME = "trace_by_child.txt";
    private static final int BACKUP_TRACE_FILE_SIZE_MIN = 1024;
    private static final String DEFAULT_NATIVE_STACK_HEADER = "backtrace: \n";
    private static final String FILE_NAME = "trace.txt";
    private static final String FILTER_ANR_DUMP_ASYNC = "anr_dump_async";
    private static final String TAG_NATIVE_BT_FAIL = "Unwind failed for thread";
    private final File mBackupTraceFile;
    private final File mDirectory;
    private final ExtraInfo mExtraInfo;
    private final ThreadBlock mMainThread;
    private final JavaHeapMemoryInfo mMemoryInfo;
    private final ArrayList<ThreadBlock> mSubThreadList;
    private final int mThreadCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File getTraceFile(File file) {
        return new File(file, FILE_NAME);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnrTraceParser(File file, int i) {
        ArrayList<ThreadBlock> arrayList = new ArrayList<>();
        this.mBackupTraceFile = new File(file, BACKUP_TRACE_FILE_NAME);
        ExtraInfo extraInfo = new ExtraInfo();
        JavaHeapMemoryInfo javaHeapMemoryInfo = new JavaHeapMemoryInfo();
        ThreadBlock parseTraceFile = parseTraceFile(file, i, arrayList, javaHeapMemoryInfo, extraInfo);
        this.mThreadCount = arrayList.size() + (parseTraceFile != null ? 1 : 0);
        this.mMainThread = parseTraceFile;
        this.mSubThreadList = arrayList;
        this.mMemoryInfo = javaHeapMemoryInfo;
        this.mExtraInfo = extraInfo;
        this.mDirectory = file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasMainStack() {
        return this.mMainThread != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getMainStack() {
        ThreadBlock threadBlock = this.mMainThread;
        if (threadBlock != null) {
            return threadBlock.getAllString();
        }
        return null;
    }

    private static HashMap<String, JSONArray> parseOtherNativeStack(File file) {
        BufferedReader bufferedReader = null;
        JSONArray jSONArray = null;
        if (file == null || !file.exists()) {
            return null;
        }
        HashMap<String, JSONArray> hashMap = new HashMap<>();
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (!TextUtils.isEmpty(readLine)) {
                        if (readLine.contains("sysTid")) {
                            String substring = readLine.substring(readLine.indexOf(61) + 1);
                            jSONArray = new JSONArray();
                            jSONArray.put(DEFAULT_NATIVE_STACK_HEADER);
                            hashMap.put(substring, jSONArray);
                        } else if (jSONArray != null) {
                            String trim = readLine.trim();
                            if (trim.startsWith("#")) {
                                jSONArray.put(trim);
                            }
                        }
                    }
                } catch (Throwable unused) {
                    bufferedReader = bufferedReader2;
                    FileSystemUtils.close(bufferedReader);
                    return hashMap;
                }
            }
            FileSystemUtils.close(bufferedReader2);
        } catch (Throwable unused2) {
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pushToCrashBody(JSONObject jSONObject) {
        JSONUtils.put(jSONObject, JavaStack.ALL_THREAD_STACKS, getSubThreadList());
        JSONUtils.put(jSONObject, "main_thread_cpu_tick", Long.valueOf(getSysTick() + getUserTick()));
        BuildId.putAnrBuildIDToJson(jSONObject, getTraceFile(this.mDirectory));
        try {
            if (jSONObject.optJSONObject("app_memory_info") != null || this.mMemoryInfo.maxMemory <= 0) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("app_memory_info", jSONObject2);
            jSONObject2.put("max_memory", this.mMemoryInfo.maxMemory);
            jSONObject2.put("free_memory", this.mMemoryInfo.freeMemory);
            jSONObject2.put("total_memory", this.mMemoryInfo.totalMemory);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pushToFilters(JSONObject jSONObject, JSONObject jSONObject2) {
        int i;
        boolean z;
        if (!this.mSubThreadList.isEmpty()) {
            JSONUtils.put(jSONObject2, "anr_replace_mainstack", "OnlyJavaStack");
        }
        ThreadBlock threadBlock = this.mMainThread;
        boolean z2 = false;
        if (threadBlock != null) {
            z = threadBlock.mIsUseBackupNativeStack;
            i = this.mMainThread.mNice;
        } else {
            i = -10;
            z = false;
        }
        long[] jArr = {0, 0, 0};
        Iterator<ThreadBlock> it = this.mSubThreadList.iterator();
        String str = "unknown";
        int i2 = 0;
        String str2 = "unknown";
        String str3 = str2;
        while (it.hasNext()) {
            ThreadBlock next = it.next();
            if ("RenderThread".equals(next.mThreadName)) {
                JSONUtils.put(jSONObject2, "anr_renderthread_nice", Integer.valueOf(next.mNice));
            } else if (next.mNice < i && next.mNice <= -16) {
                i2++;
            }
            z |= next.mIsUseBackupNativeStack;
            if (next.mUserTime > jArr[0]) {
                jArr[0] = next.mUserTime;
                str = next.mThreadName;
            }
            if (next.mSysTime > jArr[1]) {
                jArr[1] = next.mSysTime;
                str2 = next.mThreadName;
            }
            if (next.mUserTime + next.mSysTime > jArr[2]) {
                jArr[2] = next.mUserTime + next.mSysTime;
                str3 = next.mThreadName;
            }
        }
        JSONUtils.put(jSONObject2, "anr_trace_has_mainstack", Boolean.valueOf(hasMainStack()));
        JSONUtils.put(jSONObject2, "anr_trace_cost_time", this.mExtraInfo.timeRangeStr);
        JSONUtils.put(jSONObject2, "anr_trace_crash", Boolean.valueOf(this.mExtraInfo.dumpCrash));
        if (this.mExtraInfo.dumpSuccess && this.mMainThread != null && !this.mSubThreadList.isEmpty()) {
            z2 = true;
        }
        JSONUtils.put(jSONObject2, "anr_trace_done", Boolean.valueOf(z2));
        JSONUtils.put(jSONObject2, "anr_trace_thread_count", ProcInfo.getThreadCountRange(this.mSubThreadList.size() + 1));
        ThreadBlock threadBlock2 = this.mMainThread;
        if (threadBlock2 != null) {
            JSONUtils.put(jSONObject2, "anr_thread_state", threadBlock2.mVmState);
            JSONUtils.put(jSONObject2, "anr_locked_by_native", Boolean.valueOf(this.mMainThread.isLockedByNative()));
            JSONUtils.put(jSONObject2, "anr_locked_by_java", Boolean.valueOf(this.mMainThread.isLockedByJava()));
        }
        JSONUtils.put(jSONObject2, "max_utm_thread", str);
        JSONUtils.put(jSONObject2, "max_stm_thread", str2);
        JSONUtils.put(jSONObject2, "max_utm_stm_thread", str3);
        JSONUtils.put(jSONObject2, "anr_backup_native_stack", Boolean.valueOf(z));
        JSONUtils.put(jSONObject2, "anr_subthread_count_nice<=-16", Integer.valueOf(i2));
        JSONUtils.put(jSONObject2, "npth_is_wait_for_gc", Boolean.valueOf(isWaitForGc()));
        CrashFilter.appendJavaHeapFilters(jSONObject2, jSONObject);
        File file = this.mBackupTraceFile;
        if (file == null || !file.exists()) {
            JSONUtils.put(jSONObject2, FILTER_ANR_DUMP_ASYNC, "false");
            return;
        }
        if (this.mBackupTraceFile.length() > 1024) {
            JSONUtils.put(jSONObject2, FILTER_ANR_DUMP_ASYNC, "success");
        } else {
            JSONUtils.put(jSONObject2, FILTER_ANR_DUMP_ASYNC, "fail");
        }
        this.mBackupTraceFile.delete();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getUserTick() {
        ThreadBlock threadBlock = this.mMainThread;
        if (threadBlock != null) {
            return threadBlock.getUserTick();
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getSysTick() {
        ThreadBlock threadBlock = this.mMainThread;
        if (threadBlock != null) {
            return threadBlock.getSysTick();
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isLockedByJava() {
        ThreadBlock threadBlock = this.mMainThread;
        return threadBlock != null && threadBlock.isLockedByJava();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isLockedByNative() {
        ThreadBlock threadBlock = this.mMainThread;
        return threadBlock != null && threadBlock.isLockedByNative();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isPerformingGc() {
        ThreadBlock threadBlock = this.mMainThread;
        return threadBlock != null && "WaitingPerformingGc".equals(threadBlock.mVmState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isWaitForGc() {
        ThreadBlock threadBlock = this.mMainThread;
        if (threadBlock != null && "WaitingForGcToComplete".equals(threadBlock.mVmState)) {
            return true;
        }
        Iterator<ThreadBlock> it = this.mSubThreadList.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            ThreadBlock next = it.next();
            if (next.mIsAttached) {
                if ("WaitingForGcToComplete".equals(next.mVmState)) {
                    i++;
                }
                i2++;
            }
        }
        return i >= 5 || i * 4 > i2;
    }

    private JSONObject getSubThreadList() {
        JSONArray jSONArray = new JSONArray();
        Iterator<ThreadBlock> it = this.mSubThreadList.iterator();
        while (it.hasNext()) {
            ThreadBlock next = it.next();
            JSONArray jSONArray2 = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            for (int i = 1; i < next.mAllLines.size(); i++) {
                try {
                    jSONArray2.put(next.mAllLines.get(i));
                } catch (JSONException unused) {
                }
            }
            jSONObject.put("thread_name", next.mAllLines.get(0));
            jSONObject.put("thread_stack", jSONArray2);
            jSONArray.put(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("thread_stacks", jSONArray);
            jSONObject2.put("thread_all_count", this.mThreadCount);
        } catch (JSONException unused2) {
        }
        return jSONObject2;
    }

    public static ThreadBlock parseTraceFile(File file, int i, ArrayList<ThreadBlock> arrayList, JavaHeapMemoryInfo javaHeapMemoryInfo, ExtraInfo extraInfo) {
        File traceFile = getTraceFile(file);
        ThreadBlock threadBlock = null;
        if (traceFile.exists() && !traceFile.isDirectory()) {
            HashMap<String, JSONArray> parseOtherNativeStack = parseOtherNativeStack(new File(file, BACKUP_TRACE_FILE_NAME));
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(traceFile)));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (!readLine.isEmpty() && (extraInfo == null || !extraInfo.parse(readLine))) {
                            if (javaHeapMemoryInfo == null || !javaHeapMemoryInfo.parse(readLine)) {
                                if (readLine.charAt(0) == '\"' && readLine.contains(" prio=")) {
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add(readLine);
                                    while (true) {
                                        String readLine2 = bufferedReader.readLine();
                                        if (readLine2 == null || !readLine2.startsWith("  ")) {
                                            break;
                                        }
                                        arrayList2.add(readLine2);
                                    }
                                    ThreadBlock threadBlock2 = new ThreadBlock(arrayList2, parseOtherNativeStack);
                                    if (threadBlock2.parseAllLine()) {
                                        if (threadBlock2.mSysTid == i) {
                                            threadBlock = threadBlock2;
                                        } else {
                                            arrayList.add(threadBlock2);
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                FileSystemUtils.close(bufferedReader);
            } catch (FileNotFoundException unused2) {
            }
        }
        return threadBlock;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class ThreadBlock {
        private final ArrayList<String> mAllLines;
        HashMap<String, JSONArray> mBackupNativeStackMap;
        private int mCpuCore;
        private int mHeldByThread;
        private boolean mIsAttached;
        private boolean mIsUseBackupNativeStack;
        private int mNice;
        private long mRunningTime;
        private int mStackLineIndex;
        private long mSwitchCount;
        private String mSysState;
        private int mSysTid;
        private long mSysTime;
        private String mThreadName;
        private long mUserTime;
        private int mVmTid;
        private long mWaitingTime;
        private String mVmState = "";
        JSONArray mBackupNativeStack = null;

        ThreadBlock(ArrayList<String> arrayList, HashMap<String, JSONArray> hashMap) {
            this.mAllLines = arrayList;
            this.mBackupNativeStackMap = hashMap;
        }

        long getUserTick() {
            return this.mUserTime;
        }

        long getSysTick() {
            return this.mSysTime;
        }

        boolean isLockedByJava() {
            return this.mVmState.equals("TimedWaiting") || this.mVmState.equals("Waiting") || this.mVmState.equals("Blocked");
        }

        boolean isLockedByNative() {
            if (!this.mVmState.equals("Native")) {
                return false;
            }
            for (int i = this.mStackLineIndex; i < this.mAllLines.size(); i++) {
                String str = this.mAllLines.get(i);
                if (str.startsWith("  at")) {
                    return str.contains("BinderProxy.transactNative");
                }
                if (str.startsWith("  native: #") && (str.contains("__futex_wait_ex") || str.startsWith("talkWithDriver"))) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getAllString() {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.mAllLines.iterator();
            while (it.hasNext()) {
                sb.append(it.next()).append('\n');
            }
            return sb.toString();
        }

        private boolean parseThreadNameLine(String str) {
            Pattern compile = Pattern.compile("^\"(.*)\"(?: daemon)? prio=-?\\d+ (.*)$");
            Pattern compile2 = Pattern.compile("tid=(\\d+) ([a-zA-Z]+)$");
            Matcher matcher = compile.matcher(str);
            if (matcher.find() && matcher.groupCount() == 2) {
                this.mThreadName = matcher.group(1);
                String group = matcher.group(2);
                Matcher matcher2 = compile2.matcher(group);
                if (matcher2.find() && matcher2.groupCount() == 2) {
                    this.mVmTid = Integer.parseInt(matcher2.group(1));
                    this.mVmState = matcher2.group(2);
                    this.mIsAttached = true;
                } else if ("(not attached)".equals(group)) {
                    this.mIsAttached = false;
                }
                return true;
            }
            return false;
        }

        private boolean parseGroupLine(String str) {
            return str.startsWith("  | group=");
        }

        private boolean parseSysTidLine(String str) {
            Matcher matcher = Pattern.compile("^  \\| sysTid=(\\d+) nice=(-?)(\\d+) .*$").matcher(str);
            if (!matcher.find() || matcher.groupCount() != 3) {
                return false;
            }
            this.mSysTid = Integer.parseInt(matcher.group(1));
            this.mNice = Integer.parseInt(matcher.group(3));
            if ("-".equals(matcher.group(2))) {
                this.mNice *= -1;
            }
            HashMap<String, JSONArray> hashMap = this.mBackupNativeStackMap;
            if (hashMap != null) {
                this.mBackupNativeStack = hashMap.get(matcher.group(1));
            }
            return true;
        }

        private boolean parseSysStateLine(String str) {
            Matcher matcher = Pattern.compile("^  \\| state=([A-Z?]) schedstat=\\((.*)\\) utm=(\\d+) stm=(\\d+) core=(\\d+) HZ=\\d+$").matcher(str);
            if (!matcher.find() || matcher.groupCount() != 5) {
                return false;
            }
            this.mSysState = matcher.group(1);
            this.mUserTime = Long.parseLong(matcher.group(3));
            this.mSysTime = Long.parseLong(matcher.group(4));
            this.mCpuCore = Integer.parseInt(matcher.group(5));
            String group = matcher.group(2);
            if (group != null) {
                String[] split = group.trim().split(" ");
                if (split.length == 3) {
                    this.mRunningTime = Long.parseLong(split[0]);
                    this.mWaitingTime = Long.parseLong(split[1]);
                    this.mSwitchCount = Long.parseLong(split[2]);
                }
            }
            return true;
        }

        private boolean parseStackLine(String str) {
            return str.startsWith("  | stack=");
        }

        private boolean parseHeldMutexesLine(String str) {
            return str.startsWith("  | held mutexes=");
        }

        private int parseNativeFailLine(ArrayList<String> arrayList, int i) {
            if (i >= arrayList.size()) {
                return 0;
            }
            String str = arrayList.get(i);
            if (this.mBackupNativeStack == null || !str.contains(AnrTraceParser.TAG_NATIVE_BT_FAIL)) {
                return 0;
            }
            this.mIsUseBackupNativeStack = true;
            try {
                this.mAllLines.remove(i);
                int i2 = 0;
                while (i2 < this.mBackupNativeStack.length()) {
                    this.mAllLines.add(i, this.mBackupNativeStack.getString(i2));
                    i2++;
                    i++;
                }
                return this.mBackupNativeStack.length();
            } catch (Throwable unused) {
                return 0;
            }
        }

        private int findHeldByThreadVmTid(String str) {
            int indexOf;
            if (!str.startsWith("  - waiting to lock") || (indexOf = str.indexOf("held by thread ")) <= 0) {
                return -1;
            }
            return Integer.parseInt(str.substring(indexOf + 15));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean parseAllLine() {
            int i;
            if (this.mAllLines.size() <= 5 || !parseThreadNameLine(this.mAllLines.get(0))) {
                return false;
            }
            if (!this.mIsAttached) {
                i = 1;
            } else {
                if (!parseGroupLine(this.mAllLines.get(1))) {
                    return false;
                }
                i = 2;
            }
            int i2 = i + 1;
            if (!parseSysTidLine(this.mAllLines.get(i))) {
                return false;
            }
            int i3 = i2 + 1;
            if (!parseSysStateLine(this.mAllLines.get(i2))) {
                return false;
            }
            if (this.mIsAttached) {
                int i4 = i3 + 1;
                if (!parseStackLine(this.mAllLines.get(i3))) {
                    return false;
                }
                i3 = i4;
            }
            if (this.mIsAttached && parseHeldMutexesLine(this.mAllLines.get(i3))) {
                i3++;
            }
            this.mStackLineIndex = i3 + parseNativeFailLine(this.mAllLines, i3);
            return true;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class JavaHeapMemoryInfo {
        public long freeMemory;
        public long maxMemory;
        public long totalMemory;
        private String TAG_FREE_MEMORY = "Free memory ";
        private String TAG_TOTAL_MEMORY = "Total memory ";
        private String TAG_MAX_MEMORY = "Max memory ";

        public boolean parse(String str) {
            if (str.startsWith(this.TAG_FREE_MEMORY)) {
                long size = getSize(this.TAG_FREE_MEMORY.length(), str);
                if (size > 0) {
                    this.freeMemory = size;
                }
                return true;
            }
            if (str.startsWith(this.TAG_TOTAL_MEMORY)) {
                this.totalMemory = getSize(this.TAG_TOTAL_MEMORY.length(), str);
                return true;
            }
            if (!str.startsWith(this.TAG_MAX_MEMORY)) {
                return false;
            }
            this.maxMemory = getSize(this.TAG_MAX_MEMORY.length(), str);
            return true;
        }

        private long getSize(int i, String str) {
            char charAt;
            int i2 = 0;
            while (i < str.length() && (charAt = str.charAt(i)) >= '0' && charAt <= '9') {
                i2 = (i2 * 10) + (charAt - '0');
                i++;
            }
            return i2 * 1024 * 1024;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class ExtraInfo {
        public boolean dumpSuccess = false;
        public boolean dumpCrash = false;
        public String timeRangeStr = null;

        public boolean parse(String str) {
            if (str.startsWith("Dump cost time:")) {
                this.dumpSuccess = true;
                int indexOf = str.indexOf(58);
                if (indexOf != -1) {
                    this.timeRangeStr = getTimeRange(str.substring(indexOf + 1).trim());
                }
                return true;
            }
            if (!str.startsWith("Dump crash")) {
                return false;
            }
            this.dumpCrash = true;
            return true;
        }

        private static String getTimeRange(String str) {
            try {
                long parseLong = Long.parseLong(str);
                return parseLong <= 50 ? "0~50ms" : parseLong <= 100 ? "50~100ms" : parseLong <= 150 ? "100~150ms" : parseLong <= 200 ? "150~200ms" : parseLong <= 300 ? "200~300ms" : parseLong <= 400 ? "300~400ms" : parseLong <= 500 ? "400~500ms" : parseLong <= 700 ? "500~700ms" : parseLong <= 1000 ? "700~1000ms" : parseLong <= 1500 ? "1000~1500ms" : parseLong <= 2000 ? "1500~2000ms" : parseLong <= WsConstants.EXIT_DELAY_TIME ? "2000~3000ms" : parseLong <= 4000 ? "3000~4000ms" : parseLong <= PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS ? "4000~5000ms" : parseLong <= 7000 ? "5000~7000ms" : parseLong <= GWorker.INTERVAL ? "7000~10000ms" : "> 10000ms";
            } catch (Throwable unused) {
                return SchedulerSupport.NONE;
            }
        }
    }
}
