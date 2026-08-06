package com.bytedance.crash.terminate;

import android.app.ApplicationExitInfo;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.anr.AnrInfoParser;
import com.bytedance.crash.config.NpthBuildConfig;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.RomUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CrashAccessibilityMonitor {
    private static final String ERR_ANR_INFO = "invalid";
    public static final String NO_STACK_ANR = "at ApplicationExit InvalidStack.NoStackAvailable(Invalid.java:1).\n";
    private static Map<String, List<CrashInfo>> mCrashMap = new HashMap();
    private static boolean sAnrReasonParsed;
    private static File sAppCrashExitDir;
    private static File sCrashHistoryDir;
    private static List<ApplicationExitInfo> sHistoryProcessExitReason;
    private static boolean sIsEnable;
    private static volatile boolean sIsInited;

    public static void setCrashAccessibilityEnable(boolean z) {
        sIsEnable = z;
    }

    public static void upload() {
        try {
            ArrayList<ApplicationExitInfo> arrayList = new ArrayList();
            Iterator<ApplicationExitInfo> it = sHistoryProcessExitReason.iterator();
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                ApplicationExitInfo next = it.next();
                if (next.getReason() == 6 || next.getReason() == 4 || next.getReason() == 5) {
                    List<CrashInfo> list = mCrashMap.get(next.getProcessName());
                    if (list == null) {
                        arrayList.add(next);
                    } else {
                        Iterator<CrashInfo> it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z = false;
                                break;
                            }
                            CrashInfo next2 = it2.next();
                            long timestamp = next.getTimestamp() - next2.crashTime;
                            if (getCrashType(next.getReason()).getName().equals(next2.crashType.getName()) && next.getPid() == next2.pid && timestamp > 0 && timestamp < 30000) {
                                break;
                            }
                        }
                        if (!z) {
                            arrayList.add(next);
                        }
                    }
                }
            }
            setExitReasonTime();
            for (ApplicationExitInfo applicationExitInfo : arrayList) {
                int i = C10061.$SwitchMap$com$bytedance$crash$CrashType[getCrashType(applicationExitInfo.getReason()).ordinal()];
                if (i == 1) {
                    uploadANR(applicationExitInfo);
                } else if (i == 2) {
                    uploadNativeCrash(applicationExitInfo);
                } else if (i == 3) {
                    uploadJavaCrash(applicationExitInfo);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.crash.terminate.CrashAccessibilityMonitor$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static /* synthetic */ class C10061 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$crash$CrashType;

        static {
            int[] iArr = new int[CrashType.values().length];
            $SwitchMap$com$bytedance$crash$CrashType = iArr;
            try {
                iArr[CrashType.ANR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$crash$CrashType[CrashType.NATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$crash$CrashType[CrashType.JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCrashInfo(CrashType crashType, String str, int i, long j) {
        List<ApplicationExitInfo> list = sHistoryProcessExitReason;
        if (list != null && list.size() != 0) {
            try {
                CrashInfo crashInfo = new CrashInfo(0 == true ? 1 : 0);
                if (crashType == CrashType.LAUNCH) {
                    crashInfo.crashType = CrashType.JAVA;
                } else {
                    crashInfo.crashType = crashType;
                }
                crashInfo.pid = i;
                crashInfo.crashTime = j;
                List<CrashInfo> list2 = mCrashMap.containsKey(str) ? mCrashMap.get(str) : null;
                if (list2 == null) {
                    list2 = new ArrayList<>();
                    mCrashMap.put(str, list2);
                }
                list2.add(crashInfo);
            } catch (Throwable unused) {
            }
        }
    }

    public static void getHistoryProcessExitReason() {
        if (isEnable() && !sAnrReasonParsed) {
            sAnrReasonParsed = true;
            init();
            if (!new File(sAppCrashExitDir, "lastReasonTime").exists()) {
                setExitReasonTime();
                return;
            }
            List<ApplicationExitInfo> processExitReasons = AppExitInfoUtils.getProcessExitReasons();
            if (processExitReasons == null) {
                return;
            }
            sHistoryProcessExitReason = new ArrayList();
            long lastExitReasonTime = getLastExitReasonTime();
            for (ApplicationExitInfo applicationExitInfo : processExitReasons) {
                if (applicationExitInfo.getTimestamp() < lastExitReasonTime) {
                    break;
                } else {
                    sHistoryProcessExitReason.add(applicationExitInfo);
                }
            }
            setExitReasonTime();
        }
    }

    private static long getLastExitReasonTime() {
        init();
        File file = new File(sAppCrashExitDir, "lastReasonTime");
        if (file.exists()) {
            try {
                return decodeWithCatch(FileUtils.readFile(file), -1L);
            } catch (IOException unused) {
            }
        }
        return -1L;
    }

    private static void setExitReasonTime() {
        try {
            FileUtils.writeFile(new File(sAppCrashExitDir, "lastReasonTime"), String.valueOf(System.currentTimeMillis()), false);
        } catch (Throwable unused) {
        }
    }

    private static void uploadNativeCrash(ApplicationExitInfo applicationExitInfo) {
        String str;
        if (AppExitInfoUtils.enableProcessExitReason()) {
            Header createHeaderWithoutCommon = Header.createHeaderWithoutCommon(MonitorManager.getAppMonitor(), applicationExitInfo.getTimestamp(), CrashType.NATIVE, applicationExitInfo.getPid());
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONUtils.put(jSONObject, "header", createHeaderWithoutCommon.getJson());
            try {
                jSONObject.put("filters", jSONObject2);
            } catch (Throwable unused) {
            }
            JSONUtils.put(jSONObject, CrashBody.IS_NATIVE_CRASH, 1);
            JSONUtils.put(jSONObject, "crash_time", Long.valueOf(applicationExitInfo.getTimestamp()));
            JSONUtils.put(jSONObject, Constants.HAS_DUMP, "true");
            JSONUtils.put(jSONObject, Constants.KEY_HW_JIFFIES, Long.valueOf(GeneralInfoManager.getJiffy()));
            JSONUtils.put(jSONObject, "data", "Signal 111(CRASH_FROM_EXIT)\n\n");
            JSONUtils.put(jSONObject2, "sdk_version", NpthBuildConfig.VERSION_NAME);
            JSONUtils.put(jSONObject2, "is_64_runtime", NativeBridge.is64BitRuntime() ? "true" : "false");
            String optString = createHeaderWithoutCommon.getJson().optString("cpu_abi");
            if (!TextUtils.isEmpty(optString)) {
                boolean contains = optString.contains("64");
                JSONUtils.put(jSONObject2, "is_x86_devices", Boolean.valueOf(optString.contains("86")));
                JSONUtils.put(jSONObject2, Constants.IS_64_DEVICES, Boolean.valueOf(contains));
            }
            JSONUtils.put(jSONObject2, "is_root", GeneralInfoManager.isRoot() ? "true" : "false");
            JSONUtils.put(jSONObject2, "kernel_version", createHeaderWithoutCommon.getJson().optString("kernel_version"));
            JSONUtils.put(jSONObject2, Constants.IS_HM_OS, String.valueOf(RomUtils.isHarmonyOs()));
            JSONUtils.put(jSONObject2, "is_root", GeneralInfoManager.isRoot() ? "true" : "false");
            JSONUtils.put(jSONObject2, Constants.EXIT_REASON, String.valueOf(applicationExitInfo.getReason()));
            JSONUtils.put(jSONObject2, "exit_status", String.valueOf(applicationExitInfo.getStatus()));
            JSONUtils.put(jSONObject2, "crash_from", "app_exit_history");
            JSONUtils.put(jSONObject2, "description", String.valueOf(applicationExitInfo.getDescription()));
            JSONUtils.put(jSONObject2, "importance", String.valueOf(applicationExitInfo.getImportance()));
            JSONUtils.put(jSONObject2, "pss", String.valueOf(applicationExitInfo.getPss()));
            JSONUtils.put(jSONObject2, "rss", String.valueOf(applicationExitInfo.getRss()));
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject.put("custom", jSONObject3);
            } catch (Throwable unused2) {
            }
            JSONUtils.put(jSONObject3, "app_info_description", applicationExitInfo.toString());
            try {
                str = readTrace(applicationExitInfo.getTraceInputStream());
            } catch (Throwable unused3) {
                str = null;
            }
            if (!TextUtils.isEmpty(str) && !str.contains("failed to read status response from tombstoned:")) {
                JSONUtils.put(jSONObject3, "native_crash_trace", str);
            }
            String urlByCrashTypeAndHeader = UploaderUrl.getUrlByCrashTypeAndHeader(CrashType.NATIVE, createHeaderWithoutCommon.getJson());
            ArrayList arrayList = new ArrayList();
            arrayList.add(sAppCrashExitDir);
            CrashUploader.uploadCrashLogWithAttachment(CrashType.NATIVE.getName(), urlByCrashTypeAndHeader, jSONObject.toString(), arrayList);
        }
    }

    private static void uploadJavaCrash(ApplicationExitInfo applicationExitInfo) {
        String str;
        if (AppExitInfoUtils.enableProcessExitReason()) {
            Header createHeaderWithoutCommon = Header.createHeaderWithoutCommon(MonitorManager.getAppMonitor(), applicationExitInfo.getTimestamp(), CrashType.JAVA, applicationExitInfo.getPid());
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONUtils.put(jSONObject, "header", createHeaderWithoutCommon.getJson());
            try {
                jSONObject.put("filters", jSONObject2);
            } catch (Throwable unused) {
            }
            try {
                str = readTrace(applicationExitInfo.getTraceInputStream());
            } catch (Throwable unused2) {
                str = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str);
            String str2 = NO_STACK_ANR;
            if (isEmpty || str.contains("failed to read status response from tombstoned:")) {
                str = NO_STACK_ANR;
            }
            JSONUtils.put(jSONObject, "isJava", 1);
            JSONUtils.put(jSONObject, "crash_time", Long.valueOf(applicationExitInfo.getTimestamp()));
            JSONUtils.put(jSONObject, Constants.HAS_DUMP, "true");
            JSONUtils.put(jSONObject, Constants.KEY_HW_JIFFIES, Long.valueOf(GeneralInfoManager.getJiffy()));
            if (!TextUtils.isEmpty(str)) {
                str2 = str;
            }
            JSONUtils.put(jSONObject, "data", str2);
            JSONUtils.put(jSONObject2, "sdk_version", NpthBuildConfig.VERSION_NAME);
            JSONUtils.put(jSONObject2, "is_64_runtime", NativeBridge.is64BitRuntime() ? "true" : "false");
            String optString = createHeaderWithoutCommon.getJson().optString("cpu_abi");
            if (!TextUtils.isEmpty(optString)) {
                boolean contains = optString.contains("64");
                JSONUtils.put(jSONObject2, "is_x86_devices", Boolean.valueOf(optString.contains("86")));
                JSONUtils.put(jSONObject2, Constants.IS_64_DEVICES, Boolean.valueOf(contains));
            }
            JSONUtils.put(jSONObject2, "is_root", GeneralInfoManager.isRoot() ? "true" : "false");
            JSONUtils.put(jSONObject2, "kernel_version", createHeaderWithoutCommon.getJson().optString("kernel_version"));
            JSONUtils.put(jSONObject2, Constants.IS_HM_OS, String.valueOf(RomUtils.isHarmonyOs()));
            JSONUtils.put(jSONObject2, "is_root", GeneralInfoManager.isRoot() ? "true" : "false");
            JSONUtils.put(jSONObject2, Constants.EXIT_REASON, String.valueOf(applicationExitInfo.getReason()));
            JSONUtils.put(jSONObject2, "exit_status", String.valueOf(applicationExitInfo.getStatus()));
            JSONUtils.put(jSONObject2, "crash_from", "app_exit_history");
            JSONUtils.put(jSONObject2, "description", String.valueOf(applicationExitInfo.getDescription()));
            JSONUtils.put(jSONObject2, "importance", String.valueOf(applicationExitInfo.getImportance()));
            JSONUtils.put(jSONObject2, "pss", String.valueOf(applicationExitInfo.getPss()));
            JSONUtils.put(jSONObject2, "rss", String.valueOf(applicationExitInfo.getRss()));
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject.put("custom", jSONObject3);
            } catch (Throwable unused3) {
            }
            JSONUtils.put(jSONObject3, "app_info_description", applicationExitInfo.toString());
            String urlByCrashTypeAndHeader = UploaderUrl.getUrlByCrashTypeAndHeader(CrashType.JAVA, createHeaderWithoutCommon.getJson());
            ArrayList arrayList = new ArrayList();
            arrayList.add(sAppCrashExitDir);
            CrashUploader.uploadCrashLogWithAttachment(CrashType.JAVA.getName(), urlByCrashTypeAndHeader, jSONObject.toString(), arrayList);
        }
    }

    private static void uploadANR(ApplicationExitInfo applicationExitInfo) {
        String str;
        if (AppExitInfoUtils.enableProcessExitReason()) {
            Header createHeaderWithoutCommon = Header.createHeaderWithoutCommon(MonitorManager.getAppMonitor(), applicationExitInfo.getTimestamp(), CrashType.ANR, applicationExitInfo.getPid());
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONUtils.put(jSONObject, "header", createHeaderWithoutCommon.getJson());
            try {
                jSONObject.put("filters", jSONObject2);
            } catch (Throwable unused) {
            }
            JSONUtils.put(jSONObject, "is_anr", 1);
            JSONUtils.put(jSONObject, "crash_time", Long.valueOf(applicationExitInfo.getTimestamp()));
            JSONUtils.put(jSONObject, Constants.HAS_DUMP, "true");
            String description = applicationExitInfo.getDescription();
            if (TextUtils.isEmpty(description)) {
                description = ERR_ANR_INFO;
            }
            JSONUtils.put(jSONObject, AnrInfoParser.ANR_INFO, description);
            JSONUtils.put(jSONObject, "app_start_time", Long.valueOf(applicationExitInfo.getTimestamp()));
            JSONUtils.put(jSONObject, Constants.KEY_HW_JIFFIES, Long.valueOf(GeneralInfoManager.getJiffy()));
            JSONObject jSONObject3 = new JSONObject();
            JSONUtils.put(jSONObject3, "thread_number", 1);
            JSONUtils.put(jSONObject3, "mainStackFromTrace", NO_STACK_ANR);
            JSONUtils.put(jSONObject3, "pid", Integer.valueOf(applicationExitInfo.getPid()));
            JSONUtils.put(jSONObject3, "package", applicationExitInfo.getProcessName());
            JSONUtils.put(jSONObject3, ERR_ANR_INFO, false);
            JSONUtils.put(jSONObject3, "is_new_stack", 10);
            JSONUtils.put(jSONObject3, "not_current", 1);
            JSONUtils.put(jSONObject3, "is_remote_process", 0);
            JSONUtils.put(jSONObject, "data", jSONObject3.toString());
            JSONUtils.put(jSONObject2, "sdk_version", NpthBuildConfig.VERSION_NAME);
            JSONUtils.put(jSONObject2, "is_64_runtime", NativeBridge.is64BitRuntime() ? "true" : "false");
            String optString = createHeaderWithoutCommon.getJson().optString("cpu_abi");
            if (!TextUtils.isEmpty(optString)) {
                boolean contains = optString.contains("64");
                JSONUtils.put(jSONObject2, "is_x86_devices", Boolean.valueOf(optString.contains("86")));
                JSONUtils.put(jSONObject2, Constants.IS_64_DEVICES, Boolean.valueOf(contains));
            }
            JSONUtils.put(jSONObject2, "is_root", GeneralInfoManager.isRoot() ? "true" : "false");
            JSONUtils.put(jSONObject2, "kernel_version", createHeaderWithoutCommon.getJson().optString("kernel_version"));
            JSONUtils.put(jSONObject2, Constants.IS_HM_OS, String.valueOf(RomUtils.isHarmonyOs()));
            JSONUtils.put(jSONObject2, Constants.EXIT_REASON, String.valueOf(applicationExitInfo.getReason()));
            JSONUtils.put(jSONObject2, "exit_status", String.valueOf(applicationExitInfo.getStatus()));
            JSONUtils.put(jSONObject2, "crash_from", "app_exit_history");
            JSONUtils.put(jSONObject2, "description", String.valueOf(applicationExitInfo.getDescription()));
            JSONUtils.put(jSONObject2, "importance", String.valueOf(applicationExitInfo.getImportance()));
            JSONUtils.put(jSONObject2, "pss", String.valueOf(applicationExitInfo.getPss()));
            JSONUtils.put(jSONObject2, "rss", String.valueOf(applicationExitInfo.getRss()));
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject.put("custom", jSONObject4);
            } catch (Throwable unused2) {
            }
            String description2 = applicationExitInfo.getDescription();
            if (description2 != null) {
                JSONUtils.put(jSONObject2, "description", description2);
                JSONUtils.put(jSONObject4, "description", description2);
                if (description2.contains("bg anr")) {
                    JSONUtils.put(jSONObject, Constants.IS_BACKGROUND, true);
                } else {
                    JSONUtils.put(jSONObject, Constants.IS_BACKGROUND, false);
                }
                if (description2.contains("Input dispatching timed out")) {
                    JSONUtils.put(jSONObject2, Constants.ANR_REASON, "Input dispatching timed out");
                    int indexOf = description2.indexOf("Activity");
                    int i = indexOf;
                    while (i > 0 && '/' != description2.charAt(i)) {
                        i--;
                    }
                    if (indexOf != i) {
                        String str2 = description2.substring(i + 1, indexOf) + "Activity";
                        JSONUtils.put(jSONObject2, ActivityLifecycle.LAST_RESUME_ACTIVITY, str2);
                        JSONUtils.put(jSONObject2, "anr_tag", str2);
                    }
                } else if (description2.contains("executing service")) {
                    JSONUtils.put(jSONObject2, Constants.ANR_REASON, "executing service");
                    int indexOf2 = description2.indexOf("Service");
                    int i2 = indexOf2;
                    while (i2 > 0 && '/' != description2.charAt(i2)) {
                        i2--;
                    }
                    if (indexOf2 != i2) {
                        JSONUtils.put(jSONObject2, "anr_tag", description2.substring(i2 + 1, indexOf2) + "Service");
                    }
                } else if (description2.contains("Broadcast of Intent")) {
                    JSONUtils.put(jSONObject2, Constants.ANR_REASON, "Broadcast of Intent");
                    int indexOf3 = description2.indexOf("{");
                    int indexOf4 = description2.indexOf("}");
                    if (indexOf3 != -1 && indexOf4 != -1) {
                        JSONUtils.put(jSONObject2, "anr_tag", description2.substring(indexOf3 + 1, indexOf4).trim());
                    }
                }
            }
            JSONUtils.put(jSONObject4, "importance", String.valueOf(applicationExitInfo.getImportance()));
            JSONUtils.put(jSONObject4, "pss", String.valueOf(applicationExitInfo.getPss()));
            JSONUtils.put(jSONObject4, "rss", String.valueOf(applicationExitInfo.getRss()));
            JSONUtils.put(jSONObject4, "app_info_description", applicationExitInfo.toString());
            try {
                str = readTrace(applicationExitInfo.getTraceInputStream());
            } catch (Throwable unused3) {
                str = null;
            }
            if (str != null) {
                JSONUtils.put(jSONObject4, "anr_trace_description", str);
            }
            String urlByCrashTypeAndHeader = UploaderUrl.getUrlByCrashTypeAndHeader(CrashType.ANR, createHeaderWithoutCommon.getJson());
            ArrayList arrayList = new ArrayList();
            arrayList.add(sAppCrashExitDir);
            CrashUploader.uploadCrashLogWithAttachment(CrashType.ANR.getName(), urlByCrashTypeAndHeader, jSONObject.toString(), arrayList);
        }
    }

    public static void init() {
        if (isEnable() && !sIsInited) {
            sIsInited = true;
            if (sAppCrashExitDir == null) {
                sAppCrashExitDir = new File(Global.getRootDirectory(), "crash_exit_history");
            }
            if (!sAppCrashExitDir.exists()) {
                sAppCrashExitDir.mkdirs();
            }
            if (sCrashHistoryDir == null) {
                sCrashHistoryDir = new File(sAppCrashExitDir, "history_crash_list");
            }
            if (sCrashHistoryDir.exists()) {
                return;
            }
            sCrashHistoryDir.mkdirs();
        }
    }

    public static String getExitDir() {
        init();
        File file = sCrashHistoryDir;
        return file == null ? "" : file.getAbsolutePath();
    }

    public static String readTrace(InputStream inputStream) {
        BufferedInputStream bufferedInputStream;
        if (inputStream == null) {
            return "";
        }
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
        } catch (Throwable unused) {
        }
        try {
            StringBuilder sb = new StringBuilder();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, 8192);
                if (read <= 0) {
                    break;
                }
                sb.append(new String(bArr, 0, read));
            }
            String sb2 = sb.toString();
            try {
                inputStream.close();
            } catch (Throwable unused2) {
            }
            try {
                bufferedInputStream.close();
            } catch (Throwable unused3) {
            }
            return sb2;
        } catch (Throwable unused4) {
            bufferedInputStream2 = bufferedInputStream;
            try {
                inputStream.close();
            } catch (Throwable unused5) {
            }
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (Throwable unused6) {
                }
            }
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class CrashInfo {
        long crashTime;
        CrashType crashType;
        int pid;

        private CrashInfo() {
        }

        /* synthetic */ CrashInfo(C10061 c10061) {
            this();
        }
    }

    private static boolean isEnable() {
        if (sIsEnable) {
            return AppExitInfoUtils.enableProcessExitReason();
        }
        return false;
    }

    public static long decodeWithCatch(String str, long j) {
        try {
            return Long.decode(str).longValue();
        } catch (Throwable unused) {
            return j;
        }
    }

    private static CrashType getCrashType(int i) {
        if (i == 6) {
            return CrashType.ANR;
        }
        if (i == 5) {
            return CrashType.NATIVE;
        }
        if (i == 4) {
            return CrashType.JAVA;
        }
        return CrashType.UNKNOWN;
    }
}
