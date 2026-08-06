package com.bytedance.crash.dumper;

import android.text.TextUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.bdinstall.GWorker;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.crash.util.NumRanges;
import io.reactivex.annotations.SchedulerSupport;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Logcat {
    private static final String FILE_NAME = "logcat.txt";
    private static final int LOG_TYPE_ANR = 0;
    private static final int LOG_TYPE_FINISH_GC = 1;
    private static final int LOG_TYPE_IGNORE = -1;
    private static final int LOG_TYPE_WAIT_GC = 2;
    private static final int MAX_SIZE = 524288;
    private static final int TIME_STAMP_POS_END = 18;

    public static void npthDump(File file, boolean z) {
        try {
            NativeBridge.dumpLogcat(file.getAbsolutePath(), 1, z);
        } catch (Throwable unused) {
        }
    }

    public static boolean isLogcatExists(File file) {
        try {
            File file2 = new File(file, FILE_NAME);
            if (!file2.exists() || file2.isDirectory()) {
                return false;
            }
            return file2.length() >= 50;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void pushTo(JSONObject jSONObject, File file) {
        File file2 = new File(file, FILE_NAME);
        if (!file2.exists() || file2.isDirectory() || file2.length() < 50) {
            npthDump(file, false);
            file2 = new File(file, FILE_NAME);
            if (!file2.exists() || file2.isDirectory()) {
                return;
            }
        }
        int length = (int) file2.length();
        JSONArray jSONArray = new JSONArray();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (length < MAX_SIZE) {
                            jSONArray.put(readLine);
                        }
                        length -= readLine.length() + 1;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        try {
                            NpthLog.m233i(th);
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (jSONArray.length() == 0) {
                            }
                        } catch (Throwable th2) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException unused) {
                                }
                            }
                            throw th2;
                        }
                    }
                }
                bufferedReader2.close();
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException unused2) {
        }
        if (jSONArray.length() == 0) {
            try {
                jSONObject.put(Constants.LOGCAT, jSONArray);
            } catch (JSONException unused3) {
            }
        }
    }

    private static long getTimeStampFromLog(long j, String str) {
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(String.format("%tY", new Date(j)) + "-" + str.substring(0, 18));
        } catch (Throwable unused) {
            date = null;
        }
        if (date != null) {
            return date.getTime();
        }
        return -1L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0068, code lost:
    
        if (r7.equals("m") == false) goto L16;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0080. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long parseSpecialTimeFormat(String str) {
        long j;
        if (str == null || str.isEmpty()) {
            return -1L;
        }
        boolean startsWith = str.startsWith("-");
        if (startsWith || str.startsWith("+")) {
            str = str.substring(1);
        }
        Matcher matcher = Pattern.compile("(\\d+)([dhms]+)").matcher(str);
        long j2 = 0;
        while (matcher.find()) {
            long parseLong = Long.parseLong(matcher.group(1));
            char c = 2;
            String group = matcher.group(2);
            group.hashCode();
            switch (group.hashCode()) {
                case 100:
                    if (group.equals("d")) {
                        c = 0;
                        break;
                    }
                    break;
                case 104:
                    if (group.equals("h")) {
                        c = 1;
                        break;
                    }
                    break;
                case 109:
                    break;
                case 115:
                    if (group.equals("s")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3494:
                    if (group.equals("ms")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            c = 65535;
            switch (c) {
                case 0:
                    j = 86400000;
                    parseLong *= j;
                    j2 += parseLong;
                    break;
                case 1:
                    j = 3600000;
                    parseLong *= j;
                    j2 += parseLong;
                    break;
                case 2:
                    j = 60000;
                    parseLong *= j;
                    j2 += parseLong;
                    break;
                case 3:
                    j = 1000;
                    parseLong *= j;
                    j2 += parseLong;
                    break;
                case 4:
                    j2 += parseLong;
                    break;
            }
        }
        return startsWith ? -j2 : j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static float parseRegularTimeFormat(String str) {
        if (str != null && str.length() >= 2) {
            char c = 0;
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    i = -1;
                    break;
                }
                if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != '.') {
                    break;
                }
                i++;
            }
            if (i == -1) {
                return 0.0f;
            }
            try {
                String substring = str.substring(0, i);
                String substring2 = str.substring(i);
                float parseFloat = Float.parseFloat(substring);
                int hashCode = substring2.hashCode();
                if (hashCode == 115) {
                    if (substring2.equals("s")) {
                        c = 3;
                        if (c != 0) {
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                } else if (hashCode == 3494) {
                    if (substring2.equals("ms")) {
                        c = 2;
                        if (c != 0) {
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                } else if (hashCode != 3525) {
                    if (hashCode == 3742 && substring2.equals("us")) {
                        c = 1;
                        if (c != 0) {
                            return parseFloat / 1000000.0f;
                        }
                        if (c == 1) {
                            return parseFloat / 1000.0f;
                        }
                        if (c == 2) {
                            return parseFloat;
                        }
                        if (c != 3) {
                            return 0.0f;
                        }
                        return parseFloat * 1000.0f;
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                } else {
                    if (substring2.equals("ns")) {
                        if (c != 0) {
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return 0.0f;
    }

    private static boolean shouldDropCurrentLog(AnrLogInfo anrLogInfo, long j, long j2, long j3) {
        long j4 = j - TraceStatsConsts.PAGE_LOAD_MAX_LIMIT_MS;
        long j5 = j - GWorker.INTERVAL;
        if (j2 < j4) {
            return true;
        }
        long j6 = anrLogInfo.cost;
        return j6 <= 0 ? j3 < 2000 : j3 <= j6 || j2 < j5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class AnrLogInfo {
        private static final int STAGE_DROPPED = 3;
        private static final int STAGE_FOUND = 1;
        private static final int STAGE_NONE = 0;
        private static final int STAGE_PARSED_LOG = 2;
        private static final int STAGE_PARSED_MSG = 4;
        String lastKey;
        String lastValue;
        String target;
        long what;
        long when;
        long cost = 0;
        long msgEnd = 0;
        int anrLogStage = 0;

        AnrLogInfo() {
        }

        void clearMsgInfo() {
            this.when = -1L;
            this.what = -1L;
            this.target = null;
            this.lastKey = null;
            this.lastValue = null;
        }

        String getAnrLogTag() {
            int i = this.anrLogStage;
            return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "wrong" : "parsed_msg" : "dropped" : "parsed_log" : "found" : SchedulerSupport.NONE;
        }

        JSONObject toJson() {
            if (this.cost == 0) {
                return null;
            }
            int i = this.anrLogStage;
            if (i != 2 && i != 4) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cost", this.cost);
                jSONObject.put("longMsgEnd", this.msgEnd);
                if (this.anrLogStage == 4) {
                    jSONObject.put("when", this.when);
                    jSONObject.put("what", this.what);
                    jSONObject.put("target", this.target);
                    JSONUtils.put(jSONObject, this.lastKey, this.lastValue);
                }
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        void setStage(int i) {
            if (i > this.anrLogStage) {
                this.anrLogStage = i;
            }
        }
    }

    private static void parseAnrLog(AnrLogInfo anrLogInfo, long j, long j2, String str) {
        String str2;
        long j3;
        int i;
        String str3;
        String str4;
        if (str.contains("Blocked msg")) {
            anrLogInfo.setStage(1);
            try {
                Matcher matcher = Pattern.compile(".*?Blocked msg = (\\{.*?\\}) , cost\\s+=\\s+(\\d+)\\s+ms").matcher(str);
                if (matcher.find()) {
                    anrLogInfo.setStage(2);
                    String group = matcher.group(1);
                    long parseInt = Integer.parseInt(matcher.group(2));
                    if (shouldDropCurrentLog(anrLogInfo, j, j2, parseInt)) {
                        anrLogInfo.setStage(3);
                        return;
                    }
                    anrLogInfo.msgEnd = j2;
                    anrLogInfo.cost = parseInt;
                    anrLogInfo.clearMsgInfo();
                    if (group != null) {
                        Matcher matcher2 = Pattern.compile(".*?when=(\\S+)\\s+what=(\\d+)\\s+target=(\\S+)\\s+(.*?)=(.*?)\\}$").matcher(group);
                        if (matcher2.find()) {
                            j3 = parseSpecialTimeFormat(matcher2.group(1));
                            i = Integer.parseInt(matcher2.group(2));
                            str2 = matcher2.group(3);
                            str4 = matcher2.group(4);
                            str3 = matcher2.group(5);
                            anrLogInfo.setStage(4);
                            anrLogInfo.when = j3;
                            anrLogInfo.what = i;
                            anrLogInfo.target = str2;
                            anrLogInfo.lastKey = str4;
                            anrLogInfo.lastValue = str3;
                        }
                    }
                    str2 = null;
                    j3 = -1;
                    i = -1;
                    str3 = null;
                    str4 = null;
                    anrLogInfo.when = j3;
                    anrLogInfo.what = i;
                    anrLogInfo.target = str2;
                    anrLogInfo.lastKey = str4;
                    anrLogInfo.lastValue = str3;
                }
            } catch (Throwable th) {
                NpthMonitor.reportInnerException("parseAnrLogException", th);
            }
        }
    }

    private static void parseGcLog(LogcatGcInfo logcatGcInfo, long j, int i, long j2, long j3, long j4, String str) {
        if (j2 > PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS + j || j2 < j - 30000) {
            return;
        }
        if (i != 1) {
            if (i == 2) {
                Matcher matcher = Pattern.compile("WaitForGcToComplete blocked \\S+ on (\\S+) for (\\S+)").matcher(str);
                if (matcher.find()) {
                    String group = matcher.group(1);
                    long parseRegularTimeFormat = parseRegularTimeFormat(matcher.group(2));
                    logcatGcInfo.recordGcCause(group, parseRegularTimeFormat);
                    if (j3 == j4) {
                        logcatGcInfo.mainWait++;
                        logcatGcInfo.mainWait += parseRegularTimeFormat;
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        logcatGcInfo.gcCount++;
        Matcher matcher2 = Pattern.compile("(\\S+)\\s+.*?GC freed.*?paused \\S+ total (\\S+)").matcher(str);
        if (matcher2.find()) {
            String group2 = matcher2.group(1);
            float parseRegularTimeFormat2 = parseRegularTimeFormat(matcher2.group(2));
            logcatGcInfo.gcCost = ((float) logcatGcInfo.gcCost) + parseRegularTimeFormat2;
            if (!"Background".equals(group2)) {
                logcatGcInfo.blockGcCost = ((float) logcatGcInfo.blockGcCost) + parseRegularTimeFormat2;
                logcatGcInfo.blockGcCount++;
            }
            if (j3 == j4) {
                logcatGcInfo.mainPerform = ((float) logcatGcInfo.mainPerform) + parseRegularTimeFormat2;
            }
        }
    }

    private static int getLogContentType(String str) {
        if (str.contains("ANR_LOG")) {
            return 0;
        }
        if (str.contains("GC freed")) {
            return 1;
        }
        return str.contains("WaitForGcToComplete blocked") ? 2 : -1;
    }

    private static String getCostRange(long j) {
        NumRanges numRanges = new NumRanges("ms");
        numRanges.set(new Long[]{0L, 1000L, 2000L, Long.valueOf(WsConstants.EXIT_DELAY_TIME), Long.valueOf(PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS), 7000L, Long.valueOf(GWorker.INTERVAL)});
        return numRanges.get(j);
    }

    private static String getCountRange(int i) {
        NumRanges numRanges = new NumRanges("");
        numRanges.set(new Long[]{0L, 1L, 5L, 10L, 20L});
        return numRanges.get(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class LogcatGcInfo {
        long duration;
        long blockGcCost = 0;
        long gcCost = 0;
        long mainWait = 0;
        long mainPerform = 0;
        int blockGcCount = 0;
        int gcCount = 0;
        int mainWaitCount = 0;
        int mainPerformCount = 0;
        long logcatGcScore = 0;
        String blockGcCause = null;
        long blockGcCauseCost = 0;
        Map<String, Long> blockGcCauseMap = new HashMap();

        LogcatGcInfo(long j) {
            this.duration = j;
        }

        void recordGcCause(String str, long j) {
            Long l = this.blockGcCauseMap.get(str);
            if (l == null) {
                this.blockGcCauseMap.put(str, Long.valueOf(j));
            } else {
                this.blockGcCauseMap.put(str, Long.valueOf(l.longValue() + j));
            }
        }

        String getLongestGcCause() {
            String str = this.blockGcCause;
            if (str != null) {
                return str;
            }
            for (Map.Entry<String, Long> entry : this.blockGcCauseMap.entrySet()) {
                if (entry.getValue().longValue() > this.blockGcCauseCost) {
                    this.blockGcCauseCost = entry.getValue().longValue();
                    this.blockGcCause = entry.getKey();
                }
            }
            return this.blockGcCause;
        }

        JSONObject toJson() {
            if (this.gcCount == 0 || this.mainWait == 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("blockGcCost", this.blockGcCost);
                jSONObject.put("blockGcCount", this.blockGcCount);
                jSONObject.put("gcCount", this.gcCount);
                jSONObject.put("gcCost", this.gcCost);
                jSONObject.put("mainWaitCount", this.mainWaitCount);
                jSONObject.put("mainWait", this.mainWait);
                jSONObject.put("mainPerformCount", this.mainPerformCount);
                jSONObject.put("mainPerform", this.mainPerform);
                jSONObject.put("blockGcCause", getLongestGcCause());
                jSONObject.put("blockGcCauseCost", this.blockGcCauseCost);
                jSONObject.put("gcScore", calLogcatGcScore());
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        long calLogcatGcScore() {
            long j = this.duration;
            if (j == 0) {
                return 0L;
            }
            long j2 = ((this.mainPerform + this.mainWait) * 100) / j;
            long j3 = (this.blockGcCost * 100) / j;
            long j4 = (this.gcCost * 25) / j;
            this.logcatGcScore = j2;
            if (j2 <= 30) {
                this.logcatGcScore = j2 + j3;
            }
            if (j3 <= 30) {
                this.logcatGcScore += j4;
            }
            if (this.logcatGcScore > 500) {
                this.logcatGcScore = 500L;
            }
            return this.logcatGcScore;
        }
    }

    public static void pushToAnrFeature(JSONObject jSONObject) {
        int i;
        int i2;
        int i3;
        LogcatGcInfo logcatGcInfo;
        long j;
        String string;
        String group;
        long parseLong;
        long j2;
        long j3;
        JSONArray optJSONArray = jSONObject.optJSONArray(Constants.LOGCAT);
        JSONObject optJSONObject = jSONObject.optJSONObject("filters");
        long optLong = jSONObject.optLong("crash_time");
        int optInt = jSONObject.optInt("pid");
        if (optJSONArray == null || optJSONArray.length() == 0 || optJSONObject == null) {
            return;
        }
        LogcatGcInfo logcatGcInfo2 = new LogcatGcInfo(30000L);
        AnrLogInfo anrLogInfo = new AnrLogInfo();
        int i4 = 1;
        int length = optJSONArray.length() - 1;
        while (length > 0) {
            try {
                string = optJSONArray.getString(length);
            } catch (Exception e) {
                e = e;
                i = i4;
                i2 = length;
                i3 = optInt;
                logcatGcInfo = logcatGcInfo2;
                j = optLong;
            }
            if (!TextUtils.isEmpty(string)) {
                long timeStampFromLog = getTimeStampFromLog(optLong, string);
                String substring = string.substring(19);
                int logContentType = getLogContentType(substring);
                if (logContentType != -1) {
                    Matcher matcher = Pattern.compile("(\\d+)\\s+(\\d+) \\S\\s+[\\s\\S]*:([\\s\\S]*)").matcher(substring);
                    if (matcher.find()) {
                        String group2 = matcher.group(i4);
                        try {
                            String group3 = matcher.group(2);
                            group = matcher.group(3);
                            parseLong = group2 != null ? Long.parseLong(group2) : 0L;
                            if (group3 != null) {
                                j3 = Long.parseLong(group3);
                                j2 = 0;
                            } else {
                                j2 = 0;
                                j3 = 0;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            i2 = length;
                            i3 = optInt;
                            logcatGcInfo = logcatGcInfo2;
                            j = optLong;
                            i = 1;
                        }
                        if (parseLong != j2 && optInt == parseLong && group != null) {
                            if (logContentType == 0) {
                                parseAnrLog(anrLogInfo, optLong, timeStampFromLog, group);
                            } else {
                                i2 = length;
                                i = 1;
                                long j4 = parseLong;
                                i3 = optInt;
                                logcatGcInfo = logcatGcInfo2;
                                long j5 = j3;
                                j = optLong;
                                try {
                                    parseGcLog(logcatGcInfo2, optLong, logContentType, timeStampFromLog, j4, j5, group);
                                } catch (Exception e3) {
                                    e = e3;
                                    NpthLog.m232e(new RuntimeException(e));
                                    length = i2 - 1;
                                    optLong = j;
                                    optInt = i3;
                                    logcatGcInfo2 = logcatGcInfo;
                                    i4 = i;
                                }
                                length = i2 - 1;
                                optLong = j;
                                optInt = i3;
                                logcatGcInfo2 = logcatGcInfo;
                                i4 = i;
                            }
                        }
                        i2 = length;
                        i3 = optInt;
                        logcatGcInfo = logcatGcInfo2;
                        j = optLong;
                        i = 1;
                        length = i2 - 1;
                        optLong = j;
                        optInt = i3;
                        logcatGcInfo2 = logcatGcInfo;
                        i4 = i;
                    }
                }
            }
            i = i4;
            i2 = length;
            i3 = optInt;
            logcatGcInfo = logcatGcInfo2;
            j = optLong;
            length = i2 - 1;
            optLong = j;
            optInt = i3;
            logcatGcInfo2 = logcatGcInfo;
            i4 = i;
        }
        LogcatGcInfo logcatGcInfo3 = logcatGcInfo2;
        long j6 = 0;
        try {
            JSONUtils.put(jSONObject, CrashBody.LOGCAT_GC_INFO, logcatGcInfo3.toJson());
            if (logcatGcInfo3.blockGcCause != null) {
                optJSONObject.put("logcat_gc_cause", logcatGcInfo3.blockGcCause);
                optJSONObject.put("logcat_gc_cause_cost", getCostRange(logcatGcInfo3.blockGcCauseCost));
                optJSONObject.put("logcat_gc_count_range", getCountRange(logcatGcInfo3.blockGcCount));
                optJSONObject.put("logcat_gc_total_cost_range", getCostRange(logcatGcInfo3.blockGcCost));
                if (logcatGcInfo3.blockGcCount != 0) {
                    j6 = logcatGcInfo3.blockGcCost / logcatGcInfo3.blockGcCount;
                }
                optJSONObject.put("logcat_gc_avg_cost_range", getCostRange(j6));
            }
            JSONUtils.put(jSONObject, CrashBody.LOGCAT_ANR_INFO, anrLogInfo.toJson());
            JSONUtils.put(optJSONObject, "anr_log_tag", anrLogInfo.getAnrLogTag());
        } catch (Throwable unused) {
        }
    }
}
