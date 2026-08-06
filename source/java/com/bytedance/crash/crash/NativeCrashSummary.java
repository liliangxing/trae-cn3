package com.bytedance.crash.crash;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.config.ConfigManager;
import com.bytedance.crash.coredump.CoredumpAdapter;
import com.bytedance.crash.dumper.BuildId;
import com.bytedance.crash.dumper.JavaStack;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.game.GameScriptStack;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.UByte$;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NativeCrashSummary extends CrashSummary {
    public static final String FILE_NAME = CrashType.NATIVE + ".summary";
    private final String mSigLine;
    private final int mStartPid;

    NativeCrashSummary(String str, long j, long j2, long j3, String str2, String str3, int i, int i2, int i3, String str4) {
        super(new File(str).getParentFile(), CrashType.NATIVE, j, j2, j3, str2, str3, i, i2);
        this.mStartPid = i3;
        this.mSigLine = str4;
        this.mStackTrace = loadStackTrace();
    }

    public static NativeCrashSummary load(File file) {
        if (file.getName().equals(FILE_NAME)) {
            return NativeBridge.loadNativeCrashSummary(file.getAbsolutePath());
        }
        return null;
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    protected String loadStackTrace() {
        return this.mSigLine + NativeBridge.loadNativeCrashBacktrace(this.mDirectory.getAbsolutePath());
    }

    private static String parseSignalType(String str) {
        try {
            Matcher matcher = Pattern.compile("\\(([A-Z_]+)\\)").matcher(str);
            ArrayList arrayList = new ArrayList(2);
            while (matcher.find() && arrayList.size() < 2) {
                arrayList.add(matcher.group(1));
            }
            return UByte$.ExternalSyntheticBackport0.m("_", arrayList);
        } catch (Throwable unused) {
            return "SIG_PARSE_ERR";
        }
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    protected void appendSpecialFilter(JSONObject jSONObject) {
        JSONObject jSONObject2 = JSONUtils.get(jSONObject, "filters");
        JSONUtils.append(jSONObject2, "coredump_send_cfg_valid", Boolean.valueOf(new File(new File(Global.getRootDirectory(), "configs"), MonitorManager.getAppMonitorAid() + ConfigManager.CONFIG_SUFFIX).exists()));
        JSONUtils.append(jSONObject2, "has_java_stack", String.valueOf(jSONObject.opt("java_data") != null));
        JSONUtils.append(jSONObject2, "malloc_type", NativeBridge.getMallocType());
        String str = this.mSigLine;
        if (str != null) {
            JSONUtils.append(jSONObject2, "native_reason", parseSignalType(str));
        }
        JSONUtils.put(jSONObject2, "fork_crash", String.valueOf(this.mStartPid != this.mPid));
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    protected void assemblySpecialCrashBody(CrashBody crashBody, Header header) {
        JSONObject optJSONObject = crashBody.getJson().optJSONObject("filters");
        crashBody.put("is_root", Boolean.valueOf(optJSONObject != null && optJSONObject.optBoolean("is_root")));
        crashBody.put(CrashBody.START_PID, Integer.valueOf(this.mStartPid));
        BuildId.putCrashBuildIdToJson(crashBody.getJson(), this.mDirectory, true);
        crashBody.put(CrashBody.IS_NATIVE_CRASH, 1);
        if (CoredumpAdapter.getCoredumpUUID() != null) {
            crashBody.put("coredump_ver", Integer.valueOf(CoredumpAdapter.isCoredumpExists() ? 1 : 0));
            crashBody.put("core_dump_uuid", CoredumpAdapter.getCoredumpUUID());
        }
        JavaStack.pushStackCapturedAtNative(crashBody.getJson(), this.mDirectory);
        GameScriptStack.putTo(crashBody.getJson(), this.mDirectory);
    }
}
