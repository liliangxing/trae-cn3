package com.bytedance.crash.crash;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.dumper.BuildId;
import com.bytedance.crash.dumper.tools.StringDumper;
import com.bytedance.crash.dumper.tools.ThrowableDumper;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.jni.NativeBridge;
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
public class JavaCrashSummary extends CrashSummary {
    private static final String CRASH_TIME_TAG = "crash_time=";
    private static final String LAUNCH_TAG = "launch=";
    private static final String OOM_TAG = "oom=";
    private static final String PID_TAG = "pid=";
    private static final String PROCESS_NAME_TAG = "process_name=";
    private static final String START_TIME_TAG = "start_time=";
    private static final String START_UP_TIME_TAG = "start_up_time=";
    private static final String THREAD_NAME_TAG = "thread_name=";
    private static final String THROWABLE_TAG = "throwable=";
    private static final String TID_TAG = "tid=";
    private final boolean mIsOom;
    private final String mThrowable;
    public static final String FILE_NAME = CrashType.JAVA + ".summary";
    private static final Pattern sContentPattern = Pattern.compile("^start_time=(\\d+)\\nstart_up_time=(\\d+)\\ncrash_time=(\\d+)\\nprocess_name=(.*)\\nthread_name=(.*)\\npid=(\\d+)\\ntid=(\\d+)\\noom=(\\d+)\\nlaunch=(\\d+)\\nthrowable=(.*)");

    private JavaCrashSummary(File file, long j, long j2, long j3, String str, String str2, int i, int i2, boolean z, String str3, boolean z2) {
        super(file, z2 ? CrashType.LAUNCH : CrashType.JAVA, j, j2, j3, str, str2, i, i2);
        this.mThrowable = str3;
        this.mIsOom = z;
        this.mStackTrace = loadStackTrace();
    }

    public static void dump(File file, Thread thread, Throwable th, long j, boolean z, boolean z2) {
        try {
            StringDumper stringDumper = new StringDumper(file.getAbsolutePath() + "/" + FILE_NAME);
            String processName = App.getProcessName();
            String name = thread.getName();
            long appStartTime = Global.getAppStartTime();
            StringDumper append = stringDumper.append(START_TIME_TAG).append(appStartTime).append('\n').append(START_UP_TIME_TAG).append(Global.getAppStartUpTime()).append('\n').append(CRASH_TIME_TAG).append(j).append('\n').append(PROCESS_NAME_TAG).append(processName).append('\n').append(THREAD_NAME_TAG).append(name).append('\n').append(PID_TAG).append(Process.myPid()).append('\n').append(TID_TAG).append(Process.myTid()).append('\n').append(OOM_TAG);
            int i = 1;
            StringDumper append2 = append.append(z2 ? 1 : 0).append('\n').append(LAUNCH_TAG);
            if (!z) {
                i = 0;
            }
            append2.append(i).append('\n').append(THROWABLE_TAG).append(th).append('\n').release();
            if (z) {
                try {
                    new File(file, "launch").createNewFile();
                } catch (Exception unused) {
                }
            }
        } catch (Throwable th2) {
            NpthMonitor.directReportInnerException("NPTH_DUMP_SUMMARY", th2);
        }
    }

    public static JavaCrashSummary load(File file) {
        String readUtf8File;
        if (!file.getName().equals(FILE_NAME) || (readUtf8File = FileSystemUtils.readUtf8File(file)) == null) {
            return null;
        }
        try {
            Matcher matcher = sContentPattern.matcher(readUtf8File);
            if (matcher.find() && matcher.groupCount() == 10) {
                String group = matcher.group(10);
                if (!TextUtils.isEmpty(group)) {
                    return new JavaCrashSummary(file.getParentFile(), Long.parseLong(matcher.group(1)), Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(3)), matcher.group(4), matcher.group(5), Integer.parseInt(matcher.group(6)), Integer.parseInt(matcher.group(7)), Integer.parseInt(matcher.group(8)) != 0, group, Integer.parseInt(matcher.group(9)) != 0);
                }
            }
        } catch (Throwable th) {
            NpthMonitor.reportInnerException("NPTH_JAVA_SUMMARY", th);
        }
        return null;
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    protected String loadStackTrace() {
        String load = ThrowableDumper.load(this.mDirectory);
        if (TextUtils.isEmpty(load)) {
            return this.mThrowable + "\n\tat InvalidStack.NoStackAvailable: " + (this.mIsOom ? "Is OOM" : "Not OOM") + " (SourceFile.java:-1).\n";
        }
        return load;
    }

    private static String extractCrashType(String str) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    String[] split = str.split("\n", 2);
                    if (split.length == 0) {
                        return null;
                    }
                    int indexOf = split[0].indexOf(58);
                    if (indexOf == -1) {
                        indexOf = split[0].indexOf(65306);
                    }
                    if (indexOf != -1) {
                        return split[0].substring(0, indexOf).trim();
                    }
                    return split[0].trim();
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    protected void assemblySpecialCrashBody(CrashBody crashBody, Header header) {
        BuildId.putCrashBuildIdToJson(crashBody.getJson(), this.mDirectory, false);
        crashBody.put("isOOM", Boolean.valueOf(this.mIsOom));
        crashBody.put("launch_did", GeneralInfoManager.getRandomDeviceId());
        if (this.mCrashType == CrashType.LAUNCH) {
            crashBody.put(Header.KEY_CRASH_TYPE, "java");
            crashBody.put("event_type", "start_crash");
            crashBody.put("stack", String.valueOf(crashBody.getJson().remove("data")));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", new JSONArray().put(crashBody.getJson()));
                crashBody.setJson(jSONObject);
                return;
            } catch (JSONException unused) {
                return;
            }
        }
        crashBody.put("isJava", 1);
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public JSONObject getOriginalBody(JSONObject jSONObject) {
        JSONArray optJSONArray;
        return (this.mCrashType != CrashType.LAUNCH || (optJSONArray = jSONObject.optJSONArray("data")) == null || optJSONArray.length() <= 0) ? jSONObject : optJSONArray.optJSONObject(0);
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    protected void appendSpecialFilter(JSONObject jSONObject) {
        String extractCrashType;
        if (this.mCrashType == CrashType.LAUNCH) {
            jSONObject = getOriginalBody(jSONObject);
        }
        JSONObject jSONObject2 = JSONUtils.get(jSONObject, "filters");
        if (new File(this.mDirectory, "ignore").exists()) {
            JSONUtils.put(jSONObject2, "has_ignore", String.valueOf(true));
        }
        if ((this.mCrashType == CrashType.LAUNCH || this.mCrashType == CrashType.JAVA) && (extractCrashType = extractCrashType(this.mStackTrace)) != null) {
            JSONUtils.put(jSONObject2, "java_reason", extractCrashType);
        }
        JSONUtils.put(jSONObject2, "malloc_type", NativeBridge.getMallocType());
        JSONUtils.put(jSONObject2, Constants.FROM_CUSTOM, false);
    }
}
