package com.bytedance.crash.anr;

import android.app.ActivityManager;
import android.text.TextUtils;
import com.bytedance.android.monitorV2.constant.MonitorConstant;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.util.DateUtils;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.ies.argus.bean.ArgusConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AnrInfoParser {
    public static final String ANR_INFO = "anr_info";
    private static final String FILE_NAME = "anr_info.txt";
    private static final String FOOTER = "-----------------------end----------------------------";
    private static final String HEADER = "|------------- processErrorStateInfo--------------|\n";
    private static final String REASON_BROADCAST_OF_INTENT = "Broadcast of Intent";
    private static final String REASON_EXECUTING_SERVICE = "executing service";
    private static final String REASON_INPUT_DISPATCHING_TIMED_OUT = "Input dispatching timed out";
    private static final String REASON_KEY_DISPATCHING_TIMED_OUT = "keyDispatchingTimedOut";
    private static final String REASON_NOT_CALL_FOREGROUND = "not then call Service.startForeground";
    private static final String TAG_CONDITION = "condition: ";
    private static final String TAG_LOAD = "Load: ";
    private static final String TAG_LONG_MSG = "longMsg : ";
    private static final String TAG_PID = "pid: ";
    private static final String TAG_PROCESS_NAME = "processName: ";
    private static final String TAG_SHORT_MSG = "shortMsg : ";
    private static final String TAG_TAG = "tag: ";
    private static final String TAG_UID = "uid: ";
    private static final String UNKNOWN = "unknown";
    private String mAnrProcessName;
    private int mAnrProcessPid;
    CpuUsage mCloserCpuUsage;
    private final String mContent;
    CpuUsage mFirstCpuUsage;
    private final boolean mIsCurrentProcess;
    private final float[] mLoads;
    private int mLongMsgBegin;
    private int mLongMsgEnd;
    private String mReason;
    CpuUsage mSecondCpuUsage;
    private String mShortMsg;
    private String mTag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getFileName() {
        return FILE_NAME;
    }

    public AnrInfoParser(String str) {
        this.mLoads = new float[]{-1.0f, -1.0f, -1.0f};
        this.mContent = str;
        this.mIsCurrentProcess = false;
        parseAnrInfoContent(str);
    }

    public AnrInfoParser(File file) {
        this.mLoads = new float[]{-1.0f, -1.0f, -1.0f};
        String readUtf8File = FileSystemUtils.readUtf8File(new File(file, FILE_NAME));
        if (readUtf8File != null && !readUtf8File.isEmpty()) {
            if (readUtf8File.equals(AnrManager.SILENT_ANR_NO_ANR_INFO)) {
                this.mReason = Constants.SILENT_ANR;
            } else if (readUtf8File.equals(AnrManager.CLOSE_ANR_INFO)) {
                this.mReason = "Not report anrInfo";
            } else {
                int parseAnrInfoContent = parseAnrInfoContent(readUtf8File);
                if (parseAnrInfoContent < 0) {
                    NpthLog.m229e("NPTH", "Anr Info Parse Error:" + parseAnrInfoContent);
                }
                this.mReason = getAnrReasonFromShortMessage();
            }
            this.mTag = getTagFromShortMsg();
        }
        this.mContent = readUtf8File;
        this.mIsCurrentProcess = !new File(file, AnrInfoMonitor.ANR_FROM_EXTERNAL).exists();
    }

    public static String parseAnrInfoHideOthersApp(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (String str3 : str.split("\n")) {
                int indexOf = str3.indexOf(47);
                int indexOf2 = str3.indexOf(": ");
                if (indexOf != -1 && indexOf2 != -1 && indexOf < indexOf2) {
                    String substring = str3.substring(indexOf, indexOf2);
                    if (!substring.contains(str2) && (substring.contains("com.") || substring.contains(".google"))) {
                        str3 = str3.replace(substring, "/*.*.*");
                    }
                }
                sb.append(str3).append("\n");
            }
            return sb.toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String format(ActivityManager.ProcessErrorStateInfo processErrorStateInfo) {
        return "|------------- processErrorStateInfo--------------|\ncondition: " + processErrorStateInfo.condition + "\nprocessName: " + processErrorStateInfo.processName + "\npid: " + processErrorStateInfo.pid + "\nuid: " + processErrorStateInfo.uid + "\ntag: " + processErrorStateInfo.tag + "\nshortMsg : " + processErrorStateInfo.shortMsg + "\nlongMsg : " + processErrorStateInfo.longMsg + "\n-----------------------end----------------------------";
    }

    private static boolean equalString(String str, String str2) {
        if (str == null || str2 == null) {
            return str == null && str2 == null;
        }
        return str.equals(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSameProcessErrorStateInfo(ActivityManager.ProcessErrorStateInfo processErrorStateInfo, ActivityManager.ProcessErrorStateInfo processErrorStateInfo2) {
        return processErrorStateInfo.condition == processErrorStateInfo2.condition && processErrorStateInfo.pid == processErrorStateInfo2.pid && processErrorStateInfo.uid == processErrorStateInfo2.uid && equalString(processErrorStateInfo.processName, processErrorStateInfo2.processName) && equalString(processErrorStateInfo.tag, processErrorStateInfo2.tag) && equalString(processErrorStateInfo.shortMsg, processErrorStateInfo2.shortMsg) && equalString(processErrorStateInfo.longMsg, processErrorStateInfo2.longMsg);
    }

    String getContent() {
        return this.mContent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isValid() {
        return !TextUtils.isEmpty(this.mContent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pushToCrashBody(JSONObject jSONObject) {
        long anrTime = getAnrTime();
        long optLong = jSONObject.optLong("crash_time");
        if (anrTime > 0 && anrTime < optLong) {
            JSONUtils.put(jSONObject, "crash_time", Long.valueOf(anrTime));
        }
        JSONUtils.put(jSONObject, ANR_INFO, getContent());
        pushAttribute(jSONObject);
        pushFeature(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAnrProcessPid() {
        return this.mAnrProcessPid;
    }

    long getAnrTime() {
        CpuUsage cpuUsage = this.mCloserCpuUsage;
        if (cpuUsage != null) {
            return cpuUsage.getAnrTime();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class LineParser {
        String mLine;
        int mPos = 0;

        LineParser(String str) {
            this.mLine = str;
        }

        void setPos(int i) {
            this.mPos = i;
        }

        int getPos() {
            return this.mPos;
        }

        void incPos(int i) {
            this.mPos += i;
        }

        String parse(String str, String str2) {
            int i = this.mPos;
            if (str != null) {
                int indexOf = this.mLine.indexOf(str, i);
                if (indexOf < 0) {
                    return null;
                }
                this.mPos = indexOf + str.length();
            }
            if (str2 != null) {
                int indexOf2 = this.mLine.indexOf(str2, this.mPos);
                if (indexOf2 < 0) {
                    this.mPos = i;
                    return null;
                }
                String substring = this.mLine.substring(this.mPos, indexOf2);
                this.mPos = indexOf2 + str2.length();
                return substring;
            }
            String substring2 = this.mLine.substring(this.mPos);
            this.mPos = this.mLine.length() - 1;
            return substring2;
        }
    }

    int parseAnrInfoContent(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str) || !str.startsWith(HEADER) || !str.endsWith(FOOTER)) {
            return -1;
        }
        try {
            LineParser lineParser = new LineParser(str);
            lineParser.setPos(52);
            if (lineParser.parse(TAG_CONDITION, "\n") == null) {
                return -2;
            }
            String parse = lineParser.parse(TAG_PROCESS_NAME, "\n");
            if (parse == null) {
                return -3;
            }
            this.mAnrProcessName = parse;
            String parse2 = lineParser.parse(TAG_PID, "\n");
            if (parse2 == null) {
                return -4;
            }
            try {
                this.mAnrProcessPid = Integer.parseInt(parse2);
                if (lineParser.parse(TAG_UID, "\n") == null) {
                    return -6;
                }
                String parse3 = lineParser.parse(TAG_TAG, "\n");
                if (parse3 == null) {
                    return -7;
                }
                this.mTag = parse3;
                int indexOf2 = str.indexOf(TAG_SHORT_MSG, lineParser.getPos());
                if (indexOf2 < 0) {
                    return -8;
                }
                int i = indexOf2 + 11;
                int indexOf3 = str.indexOf(10, i);
                if (indexOf3 < 0) {
                    return -9;
                }
                int indexOf4 = str.indexOf(TAG_LONG_MSG, indexOf3);
                if (indexOf4 < 0) {
                    return -10;
                }
                this.mLongMsgBegin = indexOf4 + 10;
                this.mShortMsg = str.substring(i, indexOf4 - 1);
                int length = str.length() - 54;
                this.mLongMsgEnd = length;
                if (length != 0) {
                    int i2 = this.mLongMsgBegin;
                    while (true) {
                        if (i2 >= this.mLongMsgEnd || (indexOf = str.indexOf("\n", i2)) < 0) {
                            break;
                        }
                        int[] cpuUsageLinePos = getCpuUsageLinePos(str, i2);
                        if (cpuUsageLinePos != null) {
                            CpuUsage cpuUsage = new CpuUsage(str, cpuUsageLinePos);
                            if (cpuUsage.mValid) {
                                if (this.mFirstCpuUsage == null) {
                                    this.mFirstCpuUsage = cpuUsage;
                                    cpuUsage.parseAllProcessLine();
                                } else if (this.mSecondCpuUsage == null) {
                                    this.mSecondCpuUsage = cpuUsage;
                                    cpuUsage.parseAllProcessLine();
                                    break;
                                }
                            }
                            i2 = cpuUsageLinePos[3] + 1;
                        } else {
                            i2 = indexOf + 1;
                        }
                    }
                    CpuUsage cpuUsage2 = this.mFirstCpuUsage;
                    this.mCloserCpuUsage = cpuUsage2;
                    if (this.mSecondCpuUsage != null && cpuUsage2.mHeaderAgo && Math.abs(this.mCloserCpuUsage.mHeaderFromMs + this.mCloserCpuUsage.mHeaderToMs) > Math.abs(this.mSecondCpuUsage.mHeaderFromMs + this.mSecondCpuUsage.mHeaderToMs)) {
                        this.mCloserCpuUsage = this.mSecondCpuUsage;
                    }
                    CpuUsage cpuUsage3 = this.mCloserCpuUsage;
                    if (cpuUsage3 != null) {
                        cpuUsage3.parseSpecialProcess();
                    }
                }
                String parse4 = lineParser.parse(TAG_LOAD, "\n");
                if (parse4 != null) {
                    String[] split = parse4.split("/");
                    if (this.mLoads.length == split.length) {
                        for (int i3 = 0; i3 < split.length; i3++) {
                            this.mLoads[i3] = safeFloat(split[i3].trim()).floatValue();
                        }
                    }
                }
                return 0;
            } catch (Throwable unused) {
                return -5;
            }
        } catch (Throwable th) {
            NpthMonitor.reportInnerException("NPTH_ANR_ERROR", th);
            return -11;
        }
    }

    private static Float safeFloat(String str) {
        try {
            return Float.valueOf(str);
        } catch (Exception unused) {
            return Float.valueOf(-1.0f);
        }
    }

    private static String cpuRange(float f) {
        return f < 0.0f ? "invalid" : f > 100.0f ? "> 100" : new String[]{"0~10", "10~20", "20~30", "30~40", "40~50", "50~60", "60~70", "70~80", "80~90", "90~100"}[((int) f) / 10];
    }

    private static String faultsPageRange(float f) {
        if (f < 0.0f) {
            return "invalid";
        }
        float[] fArr = {2000.0f, 3000.0f, 4000.0f, 5000.0f, 10000.0f, 20000.0f, 30000.0f, 40000.0f, 50000.0f, 60000.0f, 70000.0f, 80000.0f, 90000.0f, 100000.0f, 150000.0f, 200000.0f, 300000.0f, 400000.0f, 500000.0f};
        String[] strArr = {"0~2k", "2k~3k", "3k~4k", "4k~5k", "5k~1w", "1w~2w", "2w~3w", "3w~4w", "4w~5w", "5w~6w", "7w~8w", "8w~9w", "9w~10w", "10w~15w", "15w~20w", "20w~30w", "30w~40w", "40w~50w", "> 50w"};
        for (int i = 0; i < 19; i++) {
            if (f <= fArr[i]) {
                return strArr[i];
            }
        }
        return strArr[18];
    }

    ProcessCpuUsage getTopProcessInfo(CpuUsage cpuUsage) {
        if (cpuUsage.mProcessList.size() != 0) {
            return cpuUsage.mProcessList.get(0);
        }
        return null;
    }

    ProcessCpuUsage getAnrProcessInfo(CpuUsage cpuUsage) {
        Iterator<ProcessCpuUsage> it = cpuUsage.mProcessList.iterator();
        while (it.hasNext()) {
            ProcessCpuUsage next = it.next();
            if (next.mPid == this.mAnrProcessPid) {
                return next;
            }
        }
        return null;
    }

    public void pushToFilter(JSONObject jSONObject) {
        try {
            jSONObject.put("anr_tag", this.mTag);
            jSONObject.put(Constants.ANR_REASON, this.mReason);
            jSONObject.put("is_current_process", this.mIsCurrentProcess);
            jSONObject.put("input_timeout_type", getInputTimeoutReason());
            if (!TextUtils.isEmpty(this.mContent) && !this.mContent.equals(AnrManager.SILENT_ANR_NO_ANR_INFO)) {
                jSONObject.put("has_anrinfo", "true");
            } else {
                jSONObject.put("has_anrinfo", "false");
            }
            CpuUsage cpuUsage = this.mFirstCpuUsage;
            jSONObject.put("anr_has_ago", String.valueOf(cpuUsage != null && cpuUsage.mHeaderAgo));
            jSONObject.put("success_end_anrinfo", String.valueOf(this.mFirstCpuUsage != null));
            jSONObject.put("anr_cpu_load_1", cpuRange(this.mLoads[0]));
            jSONObject.put("anr_cpu_load_5", cpuRange(this.mLoads[1]));
            jSONObject.put("anr_cpu_load_15", cpuRange(this.mLoads[2]));
            CpuUsage cpuUsage2 = this.mFirstCpuUsage;
            if (cpuUsage2 != null) {
                jSONObject.put("anr_cpu_total", cpuRange((float) cpuUsage2.mFooterTotal));
                jSONObject.put("anr_cpu_user", cpuRange((float) this.mFirstCpuUsage.mFooterUser));
                jSONObject.put("anr_cpu_kernel", cpuRange((float) this.mFirstCpuUsage.mFooterKernel));
                jSONObject.put("anr_cpu_iowait", cpuRange((float) this.mFirstCpuUsage.mFooterIowait));
                ProcessCpuUsage anrProcessInfo = getAnrProcessInfo(this.mFirstCpuUsage);
                if (anrProcessInfo != null) {
                    jSONObject.put("anr_app_cpu_total", cpuRange((float) anrProcessInfo.mTotalRatio));
                    jSONObject.put("anr_app_cpu_user", cpuRange((float) anrProcessInfo.mUserRatio));
                    jSONObject.put("anr_app_cpu_kernel", cpuRange((float) anrProcessInfo.mKernelRatio));
                    jSONObject.put("anr_faults_minor", faultsPageRange((float) anrProcessInfo.mMinor));
                    jSONObject.put("anr_faults_major", faultsPageRange((float) anrProcessInfo.mMajor));
                }
                ProcessCpuUsage topProcessInfo = getTopProcessInfo(this.mFirstCpuUsage);
                if (topProcessInfo != null) {
                    jSONObject.put("anr_top_cpu_process", topProcessInfo.mProcessName);
                    return;
                }
                return;
            }
            if (this.mSecondCpuUsage != null) {
                jSONObject.put("anr_cpu_total", cpuRange((float) cpuUsage2.mFooterTotal));
                jSONObject.put("anr_cpu_user", cpuRange((float) this.mFirstCpuUsage.mFooterUser));
                jSONObject.put("anr_cpu_kernel", cpuRange((float) this.mFirstCpuUsage.mFooterKernel));
                jSONObject.put("anr_cpu_iowait", cpuRange((float) this.mFirstCpuUsage.mFooterIowait));
                ProcessCpuUsage anrProcessInfo2 = getAnrProcessInfo(this.mSecondCpuUsage);
                if (anrProcessInfo2 != null) {
                    jSONObject.put("anr_app_cpu_total", cpuRange((float) anrProcessInfo2.mTotalRatio));
                    jSONObject.put("anr_app_cpu_user", cpuRange((float) anrProcessInfo2.mUserRatio));
                    jSONObject.put("anr_app_cpu_kernel", cpuRange((float) anrProcessInfo2.mKernelRatio));
                    jSONObject.put("anr_faults_minor", faultsPageRange((float) anrProcessInfo2.mMinor));
                    jSONObject.put("anr_faults_major", faultsPageRange((float) anrProcessInfo2.mMajor));
                }
                ProcessCpuUsage topProcessInfo2 = getTopProcessInfo(this.mFirstCpuUsage);
                if (topProcessInfo2 != null) {
                    jSONObject.put("anr_top_cpu_process", topProcessInfo2.mProcessName);
                }
            }
        } catch (Throwable th) {
            NpthLog.m233i(th);
        }
    }

    public void pushFeature(JSONObject jSONObject) {
        JSONObject jSONObject2 = JSONUtils.get(jSONObject, "features_str");
        JSONObject jSONObject3 = JSONUtils.get(jSONObject, "features_num");
        CpuUsage cpuUsage = this.mCloserCpuUsage;
        if (cpuUsage != null) {
            cpuUsage.putToFeature(jSONObject3, jSONObject2);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("app_memory_info");
        if (optJSONObject != null) {
            long optLong = optJSONObject.optLong("max_memory");
            long optLong2 = optJSONObject.optLong("free_memory");
            long optLong3 = optJSONObject.optLong("total_memory");
            if (optLong > 0) {
                JSONUtils.put(jSONObject3, "java_heap_usage", Long.valueOf(((optLong3 - optLong2) * 100) / optLong));
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(MonitorConstant.BLANK_MEMORY_INFO);
        if (optJSONObject2 != null) {
            JSONUtils.put(jSONObject3, "total_pss", Long.valueOf(optJSONObject2.optLong("totalPss") / 1048576));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void pushAttribute(JSONObject jSONObject) {
        int i;
        JSONObject jSONObject2 = JSONUtils.get(jSONObject, "anr_atribute");
        JSONObject jSONObject3 = new JSONObject();
        try {
            putLoadsToJObject(jSONObject3);
            CpuUsage cpuUsage = this.mFirstCpuUsage;
            if (cpuUsage != null) {
                cpuUsage.putFooterToAttribute(jSONObject3, true);
            }
            CpuUsage cpuUsage2 = this.mSecondCpuUsage;
            if (cpuUsage2 != null) {
                cpuUsage2.putFooterToAttribute(jSONObject3, false);
            }
            CpuUsage cpuUsage3 = this.mCloserCpuUsage;
            if (cpuUsage3 != null) {
                cpuUsage3.putSpecialProcessToAttribute(jSONObject3);
                ProcessCpuUsage topProcess = this.mCloserCpuUsage.getTopProcess();
                if (topProcess != null) {
                    jSONObject3.put("top_cpu_process_name", topProcess.mProcessName);
                    i = this.mAnrProcessName.equals(topProcess.mProcessName);
                    jSONObject3.put("top_cpu_process_is_anrapp", i);
                    jSONObject3.put("process_name", this.mAnrProcessName);
                    jSONObject2.put("cpu", jSONObject3);
                }
            }
            i = -1;
            jSONObject3.put("top_cpu_process_is_anrapp", i);
            jSONObject3.put("process_name", this.mAnrProcessName);
            jSONObject2.put("cpu", jSONObject3);
        } catch (Throwable th) {
            NpthLog.m233i(th);
        }
    }

    private String getAnrReasonFromShortMessage() {
        if (TextUtils.isEmpty(this.mShortMsg) || ArgusConstants.NULL_PLACE_HOLDER.equals(this.mShortMsg)) {
            return "unknown";
        }
        if (this.mShortMsg.startsWith("ANR ")) {
            if (this.mShortMsg.startsWith(REASON_INPUT_DISPATCHING_TIMED_OUT, 4)) {
                return getInputANRReason(this.mShortMsg);
            }
            return this.mShortMsg.startsWith(REASON_EXECUTING_SERVICE, 4) ? REASON_EXECUTING_SERVICE : this.mShortMsg.startsWith(REASON_BROADCAST_OF_INTENT, 4) ? REASON_BROADCAST_OF_INTENT : this.mShortMsg.startsWith(REASON_KEY_DISPATCHING_TIMED_OUT, 4) ? REASON_KEY_DISPATCHING_TIMED_OUT : this.mShortMsg.contains(REASON_NOT_CALL_FOREGROUND) ? REASON_NOT_CALL_FOREGROUND : replaceNumbersWithX(this.mShortMsg.substring(4));
        }
        return this.mShortMsg;
    }

    public static String replaceNumbersWithX(String str) {
        if (str == null) {
            return null;
        }
        try {
            return str.replaceAll("\\d+", "xxx");
        } catch (Throwable unused) {
            return str;
        }
    }

    private static String getInputANRReason(String str) {
        return (str.contains("Waiting to send non-key event") && str.contains("finished processing certain input events that were delivered")) ? "Input dispatching timed out (Waiting to send non-key event because the touched window has not finished processing certain input events that were delivered to it over xxms ago.  Wait queue length: xx.  Wait queue head age: xxms.)" : str.contains("Application does not have a focused window") ? "Input dispatching timed out (Application does not have a focused window)" : str.contains("Waiting because no window has focus but there is a focused") ? "Input dispatching timed out (Waiting because no window has focus but there is a focused application that may eventually add a window when it finishes starting up.)" : str.contains("window's input channel is full.") ? "Input dispatching timed out (Waiting because the touched window input channel is full.Outbound queue length: XXX.Wait queue length: XX.)" : REASON_INPUT_DISPATCHING_TIMED_OUT;
    }

    private String getTagFromShortMsg() {
        String trim;
        if (!TextUtils.isEmpty(this.mTag) && !ArgusConstants.NULL_PLACE_HOLDER.equals(this.mTag)) {
            return this.mTag;
        }
        if (TextUtils.isEmpty(this.mShortMsg) || ArgusConstants.NULL_PLACE_HOLDER.equals(this.mShortMsg)) {
            return "unknown";
        }
        if (this.mShortMsg.contains(REASON_EXECUTING_SERVICE)) {
            String str = this.mShortMsg;
            trim = str.substring(str.indexOf("service ") + 8).trim();
            String[] split = trim.split("/");
            if (split.length > 1) {
                trim = split[split.length - 1];
            }
        } else {
            if (!this.mShortMsg.contains(REASON_BROADCAST_OF_INTENT)) {
                return "unknown";
            }
            String str2 = this.mShortMsg;
            trim = str2.substring(str2.indexOf("{") + 1, this.mShortMsg.indexOf("}")).trim();
            String[] split2 = trim.split("/");
            if (split2.length > 1) {
                trim = split2[split2.length - 1];
            }
        }
        return trim;
    }

    String getInputTimeoutReason() {
        String str = this.mReason;
        if (str == null || !str.equals(REASON_INPUT_DISPATCHING_TIMED_OUT)) {
            return "invalid";
        }
        String lowerCase = this.mShortMsg.toLowerCase();
        return (lowerCase.contains("no window has focus but there is a focused application") || lowerCase.contains("does not have a focused window")) ? "no focused window" : lowerCase.contains("waiting to send non-key event because the touched window has not finished") ? "non-key event not finished" : lowerCase.contains("waiting to send key event because the focused window has not finished") ? "key event not finished" : lowerCase.contains("window is paused") ? "window is paused" : lowerCase.contains("window’s input channel is not registered") ? "input channel not registered" : lowerCase.contains("window’s input connection is") ? "window being removed" : lowerCase.contains("window’s input channel is full") ? "input channel is full" : lowerCase.contains("is not responding. waited") ? "activity is not responding" : "invalid";
    }

    void putLoadsToJObject(JSONObject jSONObject) {
        String str;
        int indexOf;
        int i = this.mLongMsgBegin;
        while (i < this.mLongMsgEnd && (indexOf = this.mContent.indexOf("\n", i)) >= 0) {
            if (this.mContent.startsWith(TAG_LOAD, i)) {
                str = this.mContent.substring(i + 6, indexOf);
                break;
            }
            i = indexOf + 1;
        }
        str = null;
        if (str != null) {
            String[] split = str.split(" / ");
            if (split.length == 3) {
                try {
                    double parseDouble = Double.parseDouble(split[0].trim());
                    double parseDouble2 = Double.parseDouble(split[1].trim());
                    double parseDouble3 = Double.parseDouble(split[2].trim());
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(parseDouble);
                    jSONArray.put(parseDouble2);
                    jSONArray.put(parseDouble3);
                    jSONObject.put("load", jSONArray);
                } catch (Throwable unused) {
                }
            }
        }
    }

    private static int[] getCpuUsageLinePos(String str, int i) {
        int[] iArr = new int[4];
        while (true) {
            int indexOf = str.indexOf("\n", i);
            if (indexOf < 0) {
                return null;
            }
            if (str.startsWith("CPU usage from", i)) {
                iArr[0] = i;
                iArr[1] = indexOf;
                int indexOf2 = str.indexOf("% TOTAL: ", indexOf + 1);
                if (indexOf2 > 0) {
                    int lastIndexOf = str.lastIndexOf(10, indexOf2) + 1;
                    int indexOf3 = str.indexOf(10, indexOf2);
                    if (lastIndexOf > 0 && indexOf3 > 0) {
                        iArr[2] = lastIndexOf;
                        iArr[3] = indexOf3;
                        return iArr;
                    }
                }
                return null;
            }
            i = indexOf + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class CpuUsage {
        String mContent;
        int mFooterBegin;
        int mFooterEnd;
        double mFooterIowait;
        double mFooterIrq;
        double mFooterKernel;
        double mFooterSoftirq;
        double mFooterTotal;
        double mFooterUser;
        boolean mHeaderAgo;
        int mHeaderBegin;
        int mHeaderEnd;
        long mHeaderFromMs;
        String mHeaderFromTime;
        long mHeaderToMs;
        String mHeaderToTime;
        double mKswapdTotalRatio;
        double mKworkTotalRatio;
        double mLmkdTotalRatio;
        double mMmcqdTotalRatio;
        double mSystemServerTotalRatio;
        boolean mValid;
        ArrayList<ProcessCpuUsage> mProcessList = new ArrayList<>();
        ArrayList<Double> mDex2oatTotalRatioList = new ArrayList<>();

        CpuUsage(String str, int[] iArr) {
            this.mContent = str;
            boolean z = false;
            this.mHeaderBegin = iArr[0];
            this.mHeaderEnd = iArr[1];
            this.mFooterBegin = iArr[2];
            this.mFooterEnd = iArr[3];
            if (parseHeaderLine() && parseFooterLine()) {
                z = true;
            }
            this.mValid = z;
        }

        long getAnrTime() {
            long j = 0;
            try {
                long parseDateMs = DateUtils.parseDateMs(this.mHeaderFromTime);
                if (this.mHeaderAgo) {
                    j = parseDateMs + this.mHeaderFromMs;
                } else {
                    j = parseDateMs - this.mHeaderFromMs;
                }
            } catch (Throwable unused) {
            }
            return j;
        }

        boolean parseHeaderLine() {
            String parse;
            String parse2;
            String parse3;
            String parse4;
            LineParser lineParser = new LineParser(this.mContent.substring(this.mHeaderBegin, this.mHeaderEnd));
            String parse5 = lineParser.parse("CPU usage from ", "ms");
            if (parse5 == null || (parse = lineParser.parse(" to ", "ms")) == null || (parse2 = lineParser.parse(" ", " ")) == null || (parse3 = lineParser.parse("(", " t")) == null || (parse4 = lineParser.parse("o ", ")")) == null) {
                return false;
            }
            try {
                this.mHeaderFromMs = Long.parseLong(parse5);
                this.mHeaderToMs = Long.parseLong(parse);
                this.mHeaderAgo = "ago".equals(parse2);
                this.mHeaderFromTime = parse3;
                this.mHeaderToTime = parse4;
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }

        boolean parseFooterLine() {
            LineParser lineParser = new LineParser(this.mContent.substring(this.mFooterBegin, this.mFooterEnd));
            String parse = lineParser.parse(null, "% TOTAL:");
            if (parse == null) {
                return false;
            }
            String parse2 = lineParser.parse(" ", "% user");
            if (parse2 != null) {
                lineParser.incPos(2);
            }
            String parse3 = lineParser.parse(" ", "% kernel");
            if (parse3 != null) {
                lineParser.incPos(2);
            }
            String parse4 = lineParser.parse(" ", "% iowait");
            if (parse4 != null) {
                lineParser.incPos(2);
            }
            String parse5 = lineParser.parse(" ", "% irq");
            if (parse5 != null) {
                lineParser.incPos(2);
            }
            String parse6 = lineParser.parse(" ", "% softirq");
            if (parse6 == null) {
                lineParser.incPos(2);
            }
            try {
                this.mFooterTotal = Double.parseDouble(parse);
                double d = 0.0d;
                this.mFooterUser = parse2 == null ? 0.0d : Double.parseDouble(parse2);
                this.mFooterKernel = parse3 == null ? 0.0d : Double.parseDouble(parse3);
                this.mFooterIowait = parse4 == null ? 0.0d : Double.parseDouble(parse4);
                this.mFooterIrq = parse5 == null ? 0.0d : Double.parseDouble(parse5);
                if (parse6 != null) {
                    d = Double.parseDouble(parse6);
                }
                this.mFooterSoftirq = d;
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }

        void parseAllProcessLine() {
            int indexOf;
            ProcessCpuUsage processCpuUsage;
            int i = this.mHeaderEnd + 1;
            while (i < this.mFooterBegin && (indexOf = this.mContent.indexOf("\n", i)) >= 0) {
                if (indexOf - i <= 4 || this.mContent.charAt(i + 2) != ' ') {
                    try {
                        processCpuUsage = parseOneProcessLine(this.mContent, i, indexOf);
                    } catch (Throwable unused) {
                        processCpuUsage = null;
                    }
                    if (processCpuUsage == null) {
                        continue;
                    } else if (processCpuUsage.mTotalRatio < 1.0d) {
                        return;
                    } else {
                        this.mProcessList.add(processCpuUsage);
                    }
                }
                i = indexOf + 1;
            }
        }

        ProcessCpuUsage getTopProcess() {
            if (this.mProcessList.size() != 0) {
                return this.mProcessList.get(0);
            }
            return null;
        }

        ProcessCpuUsage getAnrProcess() {
            Iterator<ProcessCpuUsage> it = this.mProcessList.iterator();
            while (it.hasNext()) {
                ProcessCpuUsage next = it.next();
                if (next.mPid == AnrInfoParser.this.mAnrProcessPid) {
                    return next;
                }
            }
            return null;
        }

        void putSpecialProcessToAttribute(JSONObject jSONObject) {
            try {
                jSONObject.put("kswapd", this.mKswapdTotalRatio);
                jSONObject.put("mmcqd", this.mMmcqdTotalRatio);
                jSONObject.put("kwork", this.mKworkTotalRatio);
                jSONObject.put("system_server", this.mSystemServerTotalRatio);
                jSONObject.put("lmkd", this.mLmkdTotalRatio);
                if (this.mDex2oatTotalRatioList.isEmpty()) {
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                Iterator<Double> it = this.mDex2oatTotalRatioList.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put("dex2oat", jSONArray);
            } catch (Throwable unused) {
            }
        }

        void putToFeature(JSONObject jSONObject, JSONObject jSONObject2) {
            JSONUtils.put(jSONObject, "cpu_total", Double.valueOf(this.mFooterTotal));
            JSONUtils.put(jSONObject, "cpu_user", Double.valueOf(this.mFooterUser));
            JSONUtils.put(jSONObject, "cpu_kernel", Double.valueOf(this.mFooterKernel));
            JSONUtils.put(jSONObject, "cpu_iowait", Double.valueOf(this.mFooterIowait));
            JSONUtils.put(jSONObject, "cpu_irq", Double.valueOf(this.mFooterIrq));
            JSONUtils.put(jSONObject, "cpu_softirq", Double.valueOf(this.mFooterSoftirq));
            ProcessCpuUsage topProcess = getTopProcess();
            if (topProcess != null) {
                JSONUtils.put(jSONObject2, "top_cpu_process_name", topProcess.mProcessName);
            }
            ProcessCpuUsage anrProcess = getAnrProcess();
            if (anrProcess != null) {
                JSONUtils.put(jSONObject, "cpu_app_total", Double.valueOf(anrProcess.mTotalRatio));
                JSONUtils.put(jSONObject, "cpu_app_user", Double.valueOf(anrProcess.mUserRatio));
                JSONUtils.put(jSONObject, "cpu_app_kernel", Double.valueOf(anrProcess.mKernelRatio));
                JSONUtils.put(jSONObject, "minor_rate", Long.valueOf(anrProcess.mMinor));
                JSONUtils.put(jSONObject, "major_rate", Long.valueOf(anrProcess.mMajor));
            }
            try {
                jSONObject.put("cpu_kswapd", this.mKswapdTotalRatio);
                jSONObject.put("cpu_mmcqd", this.mMmcqdTotalRatio);
                jSONObject.put("cpu_kwork", this.mKworkTotalRatio);
                jSONObject.put("cpu_system_server", this.mSystemServerTotalRatio);
                jSONObject.put("cpu_lmkd", this.mLmkdTotalRatio);
                Iterator<Double> it = this.mDex2oatTotalRatioList.iterator();
                float f = 0.0f;
                while (it.hasNext()) {
                    f = (float) (f + it.next().doubleValue());
                }
                jSONObject.put("cpu_dex2oat", f);
            } catch (Throwable unused) {
            }
        }

        void putFooterToAttribute(JSONObject jSONObject, boolean z) {
            try {
                jSONObject.put(z ? "user" : "user2", this.mFooterUser);
                jSONObject.put(z ? "sys" : "sys2", this.mFooterKernel);
                jSONObject.put(z ? "iowait" : "iowait2", this.mFooterIowait);
                jSONObject.put(z ? "irq" : "irq2", this.mFooterIrq);
                jSONObject.put(z ? "softirq" : "softirq2", this.mFooterSoftirq);
                ProcessCpuUsage anrProcess = getAnrProcess();
                if (anrProcess != null) {
                    jSONObject.put(z ? "minor" : "minor2", anrProcess.mMinor);
                    jSONObject.put(z ? "major" : "major2", anrProcess.mMajor);
                }
                jSONObject.put(z ? "before_cpu_list" : "after_cpu_list", getProcessList());
            } catch (Throwable unused) {
            }
        }

        JSONObject getProcessList() {
            JSONObject jSONObject = new JSONObject();
            Iterator<ProcessCpuUsage> it = this.mProcessList.iterator();
            while (it.hasNext()) {
                ProcessCpuUsage next = it.next();
                JSONUtils.put(jSONObject, String.valueOf(next.mPid), JSONUtils.put(JSONUtils.put(new JSONObject(), "process_name", next.mProcessName), "cpu", Double.valueOf(next.mTotalRatio)));
            }
            return jSONObject;
        }

        ProcessCpuUsage parseOneProcessLine(String str, int i, int i2) {
            int i3;
            int indexOf;
            int i4 = i + 2;
            int indexOf2 = str.indexOf(37, i4);
            ProcessCpuUsage processCpuUsage = null;
            if (indexOf2 >= 0 && indexOf2 <= i2) {
                double parseDouble = Double.parseDouble(str.substring(i4, indexOf2));
                int i5 = indexOf2 + 2;
                int indexOf3 = str.indexOf(47, i5);
                if (indexOf3 >= 0 && indexOf3 <= i2) {
                    int parseInt = Integer.parseInt(str.substring(i5, indexOf3));
                    int i6 = indexOf3 + 1;
                    int indexOf4 = str.indexOf(": ", i6);
                    if (indexOf4 >= 0 && indexOf4 <= i2) {
                        processCpuUsage = new ProcessCpuUsage(parseInt, str.substring(i6, indexOf4), parseDouble);
                        if (parseInt == AnrInfoParser.this.mAnrProcessPid && (indexOf = str.indexOf("% user + ", (i3 = indexOf4 + 2))) >= 0 && indexOf <= i2) {
                            processCpuUsage.mUserRatio = Double.parseDouble(str.substring(i3, indexOf));
                            int i7 = indexOf + 9;
                            int indexOf5 = str.indexOf("% kernel", i7);
                            if (indexOf5 >= 0 && indexOf5 <= i2) {
                                processCpuUsage.mKernelRatio = Double.parseDouble(str.substring(i7, indexOf5));
                                int indexOf6 = str.indexOf("faults: ", indexOf5);
                                if (indexOf6 >= 0 && indexOf6 <= i2) {
                                    int i8 = indexOf6 + 8;
                                    int indexOf7 = str.indexOf(" minor", i8);
                                    if (indexOf7 > 0 && indexOf7 < i2) {
                                        processCpuUsage.mMinor = Long.parseLong(str.substring(i8, indexOf7));
                                        i8 = indexOf7 + 7;
                                    }
                                    int indexOf8 = str.indexOf(" major", i8);
                                    if (indexOf8 > 0 && indexOf8 < i2) {
                                        processCpuUsage.mMajor = Long.parseLong(str.substring(i8, indexOf8));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return processCpuUsage;
        }

        void parseSpecialProcess() {
            Iterator<ProcessCpuUsage> it = this.mProcessList.iterator();
            while (it.hasNext()) {
                ProcessCpuUsage next = it.next();
                String str = next.mProcessName;
                double d = next.mTotalRatio;
                if (str.contains("kworker")) {
                    this.mKworkTotalRatio += d;
                } else if (str.contains("kswapd")) {
                    this.mKswapdTotalRatio += d;
                } else if (str.contains("mmcqd")) {
                    this.mMmcqdTotalRatio += d;
                } else if (str.contains("system_server")) {
                    this.mSystemServerTotalRatio += d;
                } else if (str.contains("lmkd")) {
                    this.mLmkdTotalRatio += d;
                } else if (str.contains("dex2oat")) {
                    this.mDex2oatTotalRatioList.add(Double.valueOf(d));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class ProcessCpuUsage {
        double mKernelRatio;
        long mMajor;
        long mMinor;
        int mPid;
        String mProcessName;
        double mTotalRatio;
        double mUserRatio;

        ProcessCpuUsage(int i, String str, double d) {
            this.mPid = i;
            this.mProcessName = str;
            this.mTotalRatio = d;
        }
    }
}
