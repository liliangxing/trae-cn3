package com.bytedance.crash.monitor;

import android.os.Build;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.crash.Ensure;
import com.bytedance.crash.Global;
import com.bytedance.crash.IExceptionTriggerCallback;
import com.bytedance.crash.UserDataCenter;
import com.bytedance.crash.anr.AnrDumper;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.anr.AnrProfiler;
import com.bytedance.crash.config.LogPathConfig;
import com.bytedance.crash.coredump.CoreDumpConfig;
import com.bytedance.crash.coredump.CoredumpAdapter;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.crash.JavaCrashHandler;
import com.bytedance.crash.crash.NativeCrashHandler;
import com.bytedance.crash.dumper.CustomFile;
import com.bytedance.crash.event.BizExceptionConfig;
import com.bytedance.crash.event.BizExceptionManager;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.looper.LooperMessageRecorder;
import com.bytedance.crash.protector.CrashProtector;
import com.bytedance.crash.repair.RepairAdapter;
import com.bytedance.crash.repair.RepairConfig;
import com.bytedance.crash.resource.ResourceMonitor;
import com.bytedance.crash.runtime.AllDefaultUrls;
import com.bytedance.crash.terminate.TerminateMonitor;
import com.bytedance.crash.upload.NetworkDisasterManager;
import com.bytedance.crash.upload.UploadLimitConfig;
import com.bytedance.crash.upload.UploadLimits;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.librarian.Librarian;
import io.reactivex.annotations.SchedulerSupport;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AppMonitorConfigService extends EventConfigService {
    private static final String BASE_KEY_ALLOW_SERVICE_NAME = "allow_service_name";
    protected static final String KEY_CORE_DUMP_CONFIG = "enable_coredump_config";
    protected static final String KEY_DISABLE_API_LEVEL_PROFILER = "disable_api_level_profiler";
    protected static final String KEY_ENABLE_API_LEVEL = "enable_api_level";
    protected static final String KEY_ENABLE_ASYNC_CORE_DUMP = "enable_async_coredump";
    protected static final String KEY_ENABLE_COREDUMP = "enable_coredump";
    protected static final String KEY_ENABLE_CORE_DUMP_UPLOAD = "upload_core_dump";
    protected static final String KEY_ENABLE_DEVICE_BRAND = "enable_device_brand";
    protected static final String KEY_ENABLE_KILL_HISTORY = "enable_kill_history_err";
    protected static final String KEY_ENABLE_KILL_HISTORY_FG = "enable_kill_history_fg";
    protected static final String KEY_GWP_ASAN_CONFIG = "gwp_asan_set_init_param";
    protected static final String KEY_REPAIR_DEBUG = "enable_debug_repair";
    protected static final String KEY_REPAIR_DELAYED_TIME = "repair_delayed_time";
    protected static final String KEY_REPAIR_PORTRAIT = "repair_portrait";
    protected static final String KEY_REPAIR_TYPE = "repair_type";
    protected static final String KEY_UPLOAD_BG_ANR = "enable_upload_bg_anr";
    private static final String LOG_TAG = "NPTH_CFG";
    protected static final String NPTH_FD_TRACKER_SETTING = "fd_track";
    private static JSONObject mFdTrackerSettings = null;
    private static JSONArray mGwpAsanSettings = null;
    private static boolean sDumpAnrInfoEnable = true;
    private static boolean sDumpCustomDataEnable = true;
    private static boolean sDumpLogcatEnable = true;
    private static boolean sDumpMessageEnable = true;
    private static boolean sDumpNativeInfoEnable = true;
    private static boolean sEnableSLIException = false;
    private static IExceptionTriggerCallback sExceptionTriggerCallback = null;
    private static boolean sIsUseLocalDomain = false;
    private static String sLastTriggerConfig = "none";
    private static boolean sSceneException;
    private static boolean sSoLoaded;
    protected CoreDumpConfig coreDumpConfig;
    protected RepairConfig repairConfig;
    protected UploadLimitConfig uploadLimitConfig;

    public static boolean enableAnrInfoReport() {
        return true;
    }

    public static boolean enableDumpMessage() {
        return true;
    }

    public static boolean enableLogcatReport() {
        return true;
    }

    public static boolean enableNativeInfo() {
        return true;
    }

    public static boolean enableUserCustomData() {
        return true;
    }

    public AppMonitorConfigService(CrashListener crashListener) {
        super(crashListener);
    }

    public CoreDumpConfig getCoreDumpConfig() {
        return this.coreDumpConfig;
    }

    public UploadLimitConfig getUploadLimitConfig() {
        return this.uploadLimitConfig;
    }

    public RepairConfig getRepairConfig() {
        return this.repairConfig;
    }

    @Override // com.bytedance.crash.monitor.EventConfigService, com.bytedance.crash.config.IConfigChangeListener
    public void onConfigChanged(JSONObject jSONObject) {
        super.onConfigChanged(jSONObject);
        JSONObject npthSimpleObject = getNpthSimpleObject(jSONObject);
        mFdTrackerSettings = getFdTrackObject(jSONObject);
        mGwpAsanSettings = npthSimpleObject.optJSONArray(KEY_GWP_ASAN_CONFIG);
        parseUploadDomain(jSONObject);
        parseBizException(jSONObject);
        if (npthSimpleObject != null) {
            Ensure.setUploadCustomJavaCrashEnable(npthSimpleObject.optInt("enable_upload_custom_java_crash") == 1);
            JavaCrashHandler.setDumpHistoryMessageEnable(npthSimpleObject.optInt("enable_dump_history_message_java") == 1);
            NativeCrashHandler.setDumpHistoryMessageEnable(npthSimpleObject.optInt("enable_dump_history_message_native") == 1);
            JavaCrashHandler.setDumpViewTreeEnable(npthSimpleObject.optInt("enable_dump_view_tree_java") == 1);
            NativeCrashHandler.setDumpViewTreeEnable(npthSimpleObject.optInt("enable_dump_view_tree_native") == 1);
            AnrDumper.setDumpViewTreeEnable(npthSimpleObject.optInt("enable_dump_view_tree_anr") == 1);
            parseDumpData(npthSimpleObject);
            npthSimpleObject.optInt("disable_looper_monitor");
            boolean z = npthSimpleObject.optInt("enable_npth_looper_monitor") == 1;
            boolean z2 = npthSimpleObject.optInt("disable_dump_trace_try_catch") == 1;
            if (z) {
                LooperMessageRecorder.getInstance().start();
            }
            parseAttributionConfig(npthSimpleObject);
            parseAnrConfig(npthSimpleObject);
            sEnableSLIException = npthSimpleObject.optInt("SLI_exception") == 1;
            sSceneException = npthSimpleObject.optInt("scene_exception") == 1;
            AnrProfiler.startJvmLockMonitor(npthSimpleObject.optInt("enable_profiler_java_lock_monitor") == 1);
            boolean z3 = npthSimpleObject.optInt("disable_anr_profiler") == 1;
            if (!z3) {
                z3 = isSupportApiLevel(npthSimpleObject.optJSONArray(KEY_DISABLE_API_LEVEL_PROFILER));
            }
            writeAnrProfilerConfig(z3);
            if (z2) {
                NativeBridge.setDumpTraceTryCatch(false);
            }
        }
        CrashProtector.updateConfig(getProtectorObject(jSONObject));
    }

    protected void writeAnrProfilerConfig(boolean z) {
        try {
            FileUtils.writeFile(new File(Global.getConfigDir(), "anr_profiler.config"), String.valueOf(z), false);
        } catch (Throwable unused) {
        }
    }

    public static boolean disableAnrProfiler() {
        try {
            return "true".equals(FileUtils.readFile(new File(Global.getConfigDir(), "anr_profiler.config")));
        } catch (Throwable unused) {
            return false;
        }
    }

    protected void parseNetDisaster(JSONObject jSONObject) {
        NetworkDisasterManager.setDisableNetDisaster(jSONObject.optInt("disable_network_disaster") == 1);
    }

    protected void parseCoredumpConfig(JSONObject jSONObject) {
        boolean z = jSONObject.optInt(KEY_ENABLE_COREDUMP) == 1;
        if (z) {
            this.coreDumpConfig = new CoreDumpConfig(jSONObject.optJSONArray(KEY_CORE_DUMP_CONFIG), z, jSONObject.optInt(KEY_ENABLE_CORE_DUMP_UPLOAD) == 1, jSONObject.optInt(KEY_ENABLE_ASYNC_CORE_DUMP) == 1);
            CoredumpAdapter.updateConfig(getCoreDumpConfig());
        }
    }

    protected void parseTombConfig(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("reg_memory_level_v2");
        if (optInt == 0) {
            return;
        }
        try {
            File file = new File(Global.getConfigDir(), "tomb.config");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileUtils.writeFile(file, "V002\n" + optInt, false);
        } catch (Throwable unused) {
        }
    }

    protected void parseAttributionConfig(JSONObject jSONObject) {
        parseTerminateConfig(jSONObject);
        parseSetPriorityMonitorConfig(jSONObject);
        if (isSupportApiLevel(jSONObject.optJSONArray(KEY_ENABLE_API_LEVEL)) && isSupportDeviceBrand(jSONObject.optJSONArray(KEY_ENABLE_DEVICE_BRAND))) {
            parseCoredumpConfig(jSONObject);
            ResourceMonitor.updateConfig(jSONObject, mFdTrackerSettings);
        }
        parseTombConfig(jSONObject);
        parseRepairConfig(jSONObject);
        parseCustomFile(jSONObject);
        parseHprof(jSONObject);
        parseNetDisaster(jSONObject);
        parseUploadLimits(jSONObject);
        UploadLimits.updateConfig(getUploadLimitConfig());
    }

    public static JSONArray getGwpAsanConfig() {
        return mGwpAsanSettings;
    }

    public static boolean enable_SLI_exception() {
        return sEnableSLIException;
    }

    public static boolean enable_scene_exception() {
        return sSceneException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseUploadLimits(JSONObject jSONObject) {
        NpthLog.m234i(LOG_TAG, "SimpleSettings:" + jSONObject);
        this.uploadLimitConfig = new UploadLimitConfig(jSONObject.optInt("crash_limit_issue"), jSONObject.optInt("crash_limit_all"), jSONObject.optInt("crash_limit_exception"), jSONObject.optInt("crash_limit_exception_md5"), jSONObject.optInt("crash_limit_exception_stack"));
    }

    protected void parseTerminateConfig(JSONObject jSONObject) {
        boolean z = jSONObject.optInt(KEY_ENABLE_KILL_HISTORY) == 1;
        boolean z2 = jSONObject.optInt(KEY_ENABLE_KILL_HISTORY_FG) == 1;
        if (z || z2 || UserDataCenter.isTerminateOpt()) {
            TerminateMonitor.init();
            TerminateMonitor.setUploadFlag(z, z2);
            TerminateMonitor.upload(MonitorManager.getAppMonitor());
        }
    }

    protected void parseRepairConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.repairConfig = new RepairConfig(jSONObject.optInt(KEY_REPAIR_TYPE), jSONObject.optInt(KEY_REPAIR_DELAYED_TIME), jSONObject.optInt(KEY_REPAIR_DEBUG) == 1, jSONObject.optJSONArray(KEY_REPAIR_PORTRAIT));
        RepairAdapter.updateConfig(getRepairConfig());
    }

    public static boolean isSupportDeviceBrand(JSONArray jSONArray) {
        if (jSONArray == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!jSONArray.toString().contains(SchedulerSupport.NONE) && !Build.BRAND.isEmpty() && !Build.BRAND.contains("ubia")) {
            if (jSONArray.toString().contains(WsChannelMultiProcessSharedProvider.ALL_TYPE)) {
                return true;
            }
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (Build.BRAND.equals(jSONArray.optString(i))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public static boolean isSupportApiLevel(JSONArray jSONArray) {
        if (jSONArray == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (jSONArray.toString().contains(SchedulerSupport.NONE)) {
            return false;
        }
        if (jSONArray.toString().contains(WsChannelMultiProcessSharedProvider.ALL_TYPE)) {
            return true;
        }
        if (jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                if (Build.VERSION.SDK_INT == Integer.parseInt(jSONArray.optString(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    protected void parseCustomFile(JSONObject jSONObject) {
        CustomFile.updateConfig(!(jSONObject.optInt("disable_crash_with_custom_files") == 1), jSONObject.optInt("crash_file_size_limit"));
    }

    protected void parseHprof(JSONObject jSONObject) {
        JavaCrashHandler.setHprofEnable(jSONObject.optInt("enable_hprof_all_java_crash") == 1);
    }

    private static boolean tlsMonitorLoadLibrary() {
        NpthLog.m234i(LOG_TAG, "loadLibrary...");
        if (!sSoLoaded) {
            try {
                Librarian.loadLibraryForModule("npth_tls_monitor", Global.getContext());
                sSoLoaded = true;
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public static void parseSetPriorityMonitorConfig(JSONObject jSONObject) {
        try {
            if (jSONObject.optInt("enable_setpriority_monitor") == 1) {
                JSONArray optJSONArray = jSONObject.optJSONArray("setpriority_params");
                NativeBridge.priorityMonitorInit(FileSystemUtils.createDirectory(LogPathConfig.getPrioMonitorPath(), CrashManager.getProcessDirectoryName()).toString());
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    return;
                }
                NativeBridge.setPriorityParams(optJSONArray.optBoolean(0), optJSONArray.optBoolean(1), optJSONArray.optInt(2));
            }
        } catch (Throwable unused) {
        }
    }

    private static JSONObject getNpthSimpleObject(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("custom_event_settings");
        if (optJSONObject == null) {
            return null;
        }
        return optJSONObject.optJSONObject(EventConfigService.NPTH_SIMPLE_SETTING);
    }

    private static JSONObject getFdTrackObject(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("custom_event_settings");
        if (optJSONObject == null) {
            return null;
        }
        return optJSONObject.optJSONObject(NPTH_FD_TRACKER_SETTING);
    }

    private static JSONObject getProtectorObject(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("exception_modules");
        if (optJSONObject == null) {
            return null;
        }
        return optJSONObject.optJSONObject("protector");
    }

    protected void parseAnrConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AnrManager.setUploadBackgroundANR(jSONObject.optInt(KEY_UPLOAD_BG_ANR) == 1);
    }

    public static void setUseLocalDomain(boolean z) {
        sIsUseLocalDomain = z;
    }

    private void parseUploadDomain(JSONObject jSONObject) {
        if (sIsUseLocalDomain) {
            return;
        }
        AllDefaultUrls.setDomainName(JSONUtils.getStringFromParent(jSONObject, "custom_event_settings", EventConfigService.NPTH_SIMPLE_SETTING, "crash_upload_domain"), JSONUtils.getArrayFromParent(jSONObject, "custom_event_settings", EventConfigService.NPTH_SIMPLE_SETTING, "crash_upload_domain_list"));
    }

    private void parseBizException(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("exception_modules");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("biz_exception")) == null) {
            return;
        }
        int optInt = optJSONObject.optInt("enable_upload", 0);
        HashSet hashSet = new HashSet();
        JSONObject optJSONObject3 = optJSONObject.optJSONObject("allow_log_type");
        if (optJSONObject3 != null) {
            Iterator<String> keys = optJSONObject3.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (optJSONObject3.optInt(next) == 1) {
                    hashSet.add(next);
                }
            }
        }
        BizExceptionManager.getInstance().setConfig(new BizExceptionConfig(optInt == 1, hashSet));
        doExceptionTriggerCallback(optJSONObject.optString("trigger"));
    }

    private static synchronized void doExceptionTriggerCallback(String str) {
        synchronized (AppMonitorConfigService.class) {
            if (!str.equals(sLastTriggerConfig)) {
                sLastTriggerConfig = str;
                IExceptionTriggerCallback iExceptionTriggerCallback = sExceptionTriggerCallback;
                if (iExceptionTriggerCallback != null) {
                    iExceptionTriggerCallback.onConfigChanged(str);
                }
            }
        }
    }

    public static synchronized void registerExceptionTriggerCallback(IExceptionTriggerCallback iExceptionTriggerCallback) {
        synchronized (AppMonitorConfigService.class) {
            sExceptionTriggerCallback = iExceptionTriggerCallback;
            if (iExceptionTriggerCallback != null && !sLastTriggerConfig.equals(SchedulerSupport.NONE)) {
                iExceptionTriggerCallback.onConfigChanged(sLastTriggerConfig);
            }
        }
    }

    private static void parseDumpData(JSONObject jSONObject) {
        if (jSONObject != null) {
            sDumpAnrInfoEnable = jSONObject.optInt("enable_anrinfo_report") == 1;
            sDumpCustomDataEnable = jSONObject.optInt("enable_user_custom_data") == 1;
            sDumpLogcatEnable = jSONObject.optInt("enable_logcat_report") == 1;
            sDumpNativeInfoEnable = jSONObject.optInt("enable_native_info") == 1;
            sDumpMessageEnable = jSONObject.optInt("enable_dump_message") == 1;
        }
    }
}
