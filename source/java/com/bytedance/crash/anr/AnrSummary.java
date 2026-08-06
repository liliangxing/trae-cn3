package com.bytedance.crash.anr;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.GlobalSwitch;
import com.bytedance.crash.anr.AnrDumper;
import com.bytedance.crash.anr.AnrProfiler;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.crash.CrashSummary;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.dumper.EvilDumpFile;
import com.bytedance.crash.dumper.JavaStack;
import com.bytedance.crash.dumper.Logcat;
import com.bytedance.crash.dumper.ProcessState;
import com.bytedance.crash.dumper.tools.StringDumper;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.CustomLong;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.looper.LooperMessageParser;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.terminate.AnrHistoryProcessExitParser;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AnrSummary extends CrashSummary {
    private static final String CRASH_TIME_TAG = "crash_time=";
    private static final String FROM_SIG_TAG = "by_signal=";
    public static final String NO_STACK_ANR = "at InvalidStack.NoStackAvailable(Invalid.java:1).\n";
    private static final String PID_TAG = "pid=";
    private static final String PROCESS_NAME_TAG = "process_name=";
    private static final String START_TIME_TAG = "start_time=";
    private static final String START_UP_TIME_TAG = "start_up_time=";
    private static final String TRIGGER_TAG = "trigger=";
    private AnrInfoParser mAnrInfoParser;
    private AnrProfiler.Parser mAnrProfilerParser;
    private final AnrTraceParser mAnrTraceParser;
    private final boolean mBySignal;
    private LooperMessageParser mLooperManagerParser;
    private String mMainStack;
    private final int mTrigger;
    public static final String FILE_NAME = CrashType.ANR + ".summary";
    private static final Pattern sContentPattern = Pattern.compile("^start_time=(\\d+)\\nstart_up_time=(\\d+)\\ncrash_time=(\\d+)\\nprocess_name=(.*)\\npid=(\\d+)\\nby_signal=(true|false)\\n(?:trigger=(\\d+)\\n?)?");

    protected AnrSummary(File file, long j, long j2, long j3, String str, int i, int i2, boolean z) {
        super(file, CrashType.ANR, j, j2, j3, str, PullConfiguration.PROCESS_NAME_MAIN, i, i);
        this.mBySignal = z;
        this.mTrigger = i2;
        this.mAnrTraceParser = new AnrTraceParser(file, i);
        this.mStackTrace = loadStackTrace();
    }

    private static AnrSummary load(File file) {
        String readUtf8File = FileSystemUtils.readUtf8File(file);
        if (TextUtils.isEmpty(readUtf8File)) {
            return null;
        }
        try {
            Matcher matcher = sContentPattern.matcher(readUtf8File);
            if (!matcher.find()) {
                return null;
            }
            long parseLong = Long.parseLong(matcher.group(1));
            long parseLong2 = Long.parseLong(matcher.group(2));
            long parseLong3 = Long.parseLong(matcher.group(3));
            String group = matcher.group(4);
            int parseInt = Integer.parseInt(matcher.group(5));
            boolean parseBoolean = Boolean.parseBoolean(matcher.group(6));
            return new AnrSummary(file.getParentFile(), parseLong, parseLong2, parseLong3, group, parseInt, matcher.group(7) != null ? Integer.parseInt(matcher.group(7)) : 9999, parseBoolean);
        } catch (Throwable th) {
            NpthMonitor.reportInnerException("NPTH_ANR_ERROR_LOAD", th);
            return null;
        }
    }

    public static AnrSummary loadFromDirectory(File file) {
        return load(new File(file, FILE_NAME));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void dump(File file, long j, boolean z, int i) {
        StringDumper stringDumper = new StringDumper(file + "/" + FILE_NAME);
        String processName = App.getProcessName();
        long appStartTime = Global.getAppStartTime();
        stringDumper.append(START_TIME_TAG).append(appStartTime).append('\n').append(START_UP_TIME_TAG).append(Global.getAppStartUpTime()).append('\n').append(CRASH_TIME_TAG).append(j).append('\n').append(PROCESS_NAME_TAG).append(processName).append('\n').append(PID_TAG).append(Process.myPid()).append('\n').append(FROM_SIG_TAG).append(z).append('\n').append(TRIGGER_TAG).append(i).append('\n').release();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean hasSummaryFile(File file) {
        return new File(file, FILE_NAME).exists();
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public boolean upload(AppMonitor appMonitor, JSONObject jSONObject) {
        boolean upload = super.upload(appMonitor, jSONObject);
        if (!GlobalSwitch.isAnrMonitorOpt() && !upload) {
            FileSystemUtils.deleteAll(this.mDirectory);
        }
        return upload;
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    protected String loadStackTrace() {
        JSONObject jSONObject = new JSONObject();
        String mainStack = this.mAnrTraceParser.getMainStack();
        this.mMainStack = mainStack;
        if (TextUtils.isEmpty(mainStack)) {
            this.mMainStack = JavaStack.getMainStack(this.mDirectory);
        }
        if (TextUtils.isEmpty(this.mMainStack)) {
            this.mMainStack = "at InvalidStack.NoStackAvailable(Invalid.java:1).\n";
        }
        try {
            jSONObject.put("mainStackFromTrace", this.mMainStack);
            jSONObject.put("invalid", this.mMainStack == "at InvalidStack.NoStackAvailable(Invalid.java:1).\n");
            jSONObject.put("is_new_stack", 10);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    protected void assemblySpecialCrashBody(CrashBody crashBody, Header header) {
        try {
            crashBody.put("is_anr", 1);
            this.mAnrTraceParser.pushToCrashBody(crashBody.getJson());
            AnrInfoParser anrInfoParser = new AnrInfoParser(this.mDirectory);
            this.mAnrInfoParser = anrInfoParser;
            anrInfoParser.pushToCrashBody(crashBody.getJson());
            LooperMessageParser.pushToCrashBody(crashBody.getJson());
            Logcat.pushToAnrFeature(crashBody.getJson());
            AnrProfiler.Parser parser = new AnrProfiler.Parser(this.mDirectory, crashBody.getJson(), this.mAnrTraceParser, this.mAnrInfoParser);
            this.mAnrProfilerParser = parser;
            parser.pushToCrashBody(crashBody.getJson(), this.mDirectory);
            appendMainStackToCustom(crashBody.getJson());
            AnrHistoryProcessExitParser.parseProcessExitReason(crashBody.getJson());
        } catch (Throwable th) {
            NpthMonitor.reportInnerException(th);
        }
        if (!this.mAnrInfoParser.isValid() || this.mMainStack == "at InvalidStack.NoStackAvailable(Invalid.java:1).\n") {
            JSONUtils.put(header.getJson(), "aid", 2010);
            return;
        }
        if (GlobalSwitch.isFilterNotAnr()) {
            String optString = crashBody.getJson().optString(Constants.EXIT_REASON);
            if (TextUtils.isEmpty(optString) || optString.contains("6")) {
                return;
            }
            JSONUtils.put(header.getJson(), "aid", 2010);
        }
    }

    private void appendMainStackToCustom(JSONObject jSONObject) {
        if (JavaStack.isStackFromTrace(jSONObject.optString("data"))) {
            String mainStack = JavaStack.getMainStack(this.mDirectory);
            if (TextUtils.isEmpty(mainStack)) {
                return;
            }
            String[] split = mainStack.split("\n");
            JSONArray jSONArray = new JSONArray();
            for (String str : split) {
                jSONArray.put(str);
            }
            CustomLong.add(jSONObject, "main_stack_2nd", jSONArray);
        }
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    protected void appendSpecialFilter(JSONObject jSONObject) {
        JSONObject jSONObject2 = JSONUtils.get(jSONObject, "filters");
        JSONUtils.put(jSONObject2, "by_signal", this.mBySignal ? "true" : "false");
        JSONUtils.put(jSONObject2, "anr_trigger", Integer.valueOf(this.mTrigger));
        this.mAnrTraceParser.pushToFilters(jSONObject, jSONObject2);
        AnrInfoParser anrInfoParser = this.mAnrInfoParser;
        if (anrInfoParser != null) {
            anrInfoParser.pushToFilter(jSONObject2);
        }
        AnrProfiler.Parser parser = this.mAnrProfilerParser;
        if (parser != null) {
            parser.pushToFilters(jSONObject2);
        }
        LooperMessageParser.pushToFilters(jSONObject, jSONObject2);
        AnrDumper.ConfigDump.push(this.mDirectory, jSONObject2);
        EvilDumpFile.push(this.mDirectory, jSONObject2);
        ProcessState.pushFilters(this.mDirectory, jSONObject, jSONObject2);
        AnrHistoryProcessExitParser.pushToFilters(jSONObject, jSONObject2);
        JSONUtils.put(jSONObject2, "malloc_type", NativeBridge.getMallocType());
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    protected void loadCrashInfo(JSONObject jSONObject, JSONObject jSONObject2, File file) {
        AnrDumper.loadCrashInfo(jSONObject, jSONObject2, file);
    }
}
