package com.bytedance.crash.coredump;

import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.bdinstall.GWorker;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.config.LogPathConfig;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.crash.CrashSummary;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.dumper.LocaleInfo;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.IoUtil;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import io.reactivex.annotations.SchedulerSupport;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CoredumpAdapter {
    private static final String CORE_CONFIG_FILE = "core.config";
    public static final String CORE_DUMP_DELETE = "coredump_delete";
    public static final String HAVE_CORE_DUMP = "may_have_core_dump";
    private static final String LOG_TAG = "NPTH_COREDUMP";
    private static File mConfigFile = null;
    private static CoreDumpConfig mCoreConfig = null;
    private static String mCoreDeleteCause = "disable";
    private static File mCoreDir = null;
    private static final String mCoreLocalTestConfig = "1#all#all#null#lib#SIG#0#0#7#";
    private static String mCoredumpAsyncMode = null;
    private static String mCoredumpDone = null;
    private static String mCoredumpReturnCode = null;
    private static String mCoredumpSize = "0";
    private static String mCoredumpTime = null;
    private static String mCoredumpUUID = "none";
    private static boolean mIsInit;

    public static String getDumpSize() {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(mCoredumpSize.trim()));
            if (valueOf.longValue() >= 1048576) {
                return Long.valueOf(valueOf.longValue() / 1048576).toString() + "MB";
            }
            return valueOf.toString() + "KB";
        } catch (Throwable unused) {
            return "0";
        }
    }

    public static String getDumpSizeRange() {
        try {
            long parseLong = Long.parseLong(mCoredumpSize.trim());
            if (parseLong < 1048576) {
                return "size < 1MB";
            }
            long j = parseLong / 1048576;
            return j <= 50 ? "1~50MB" : j <= 100 ? "51~100MB" : j <= 200 ? "101~200MB" : j <= 300 ? "201~300MB" : j <= 400 ? "301~400MB" : j <= 500 ? "401~500MB" : j <= 1000 ? "501MB~1GB" : "size > 1GB";
        } catch (Throwable unused) {
            return "0";
        }
    }

    public static String getCoredumpMissReason() {
        return mCoreDeleteCause;
    }

    public static String getCoredumpUUID() {
        return mCoredumpUUID;
    }

    public static void deleteCoreDir() {
        File file = mCoreDir;
        if (file != null) {
            FileUtils.deleteFile(file);
        }
    }

    public static void updateConfig(CoreDumpConfig coreDumpConfig) {
        if (coreDumpConfig == null) {
            return;
        }
        mCoreConfig = coreDumpConfig;
        NpthLog.m234i("NPTH_CORE", "updateConfig init");
        init();
    }

    public static void init() {
        try {
            if (!mIsInit && checkCoredumpEnable()) {
                mIsInit = true;
                File coreDumpPath = LogPathConfig.getCoreDumpPath();
                if (!coreDumpPath.exists()) {
                    coreDumpPath.mkdirs();
                }
                NativeBridge.coredumpNativeInit(new File(coreDumpPath, CrashManager.getProcessDirectoryName()).toString());
                NpthLog.m234i(LOG_TAG, "Coredump Init ok");
            }
        } catch (Exception unused) {
        }
    }

    public static File getDirectory(File file) {
        if (file == null) {
            return null;
        }
        return new File(LogPathConfig.getNpthRootPath(), "asdawd/" + file.getAbsolutePath().split("/")[r4.length - 1]);
    }

    private static boolean checkCoredumpEnable() {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (RuntimeConfig.isLocalTest()) {
            writeConfig(mCoreLocalTestConfig);
            return true;
        }
        CoreDumpConfig coreDumpConfig = mCoreConfig;
        if (coreDumpConfig != null && coreDumpConfig.isEnable()) {
            writeConfig(mCoreConfig.getCoreDumpConfig());
            return true;
        }
        mCoreDeleteCause = "config init exception";
        return false;
    }

    private static void writeConfig(String str) {
        if (str == null) {
            return;
        }
        try {
            File file = new File(Global.getConfigDir(), CORE_CONFIG_FILE);
            mConfigFile = file;
            if (!file.exists()) {
                mConfigFile.createNewFile();
            }
            NpthLog.m234i(LOG_TAG, "Core Init enable");
            FileUtils.writeFile(mConfigFile, str, false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean isCoredumpExists() {
        File[] listFiles;
        if (mCoreDir == null || "0".equals(mCoredumpSize) || (listFiles = mCoreDir.listFiles()) == null) {
            return false;
        }
        for (File file : listFiles) {
            try {
                if (file.getName().startsWith("core-") && file.length() > 0 && Long.valueOf(Long.parseLong(mCoredumpSize.trim())).longValue() == file.length()) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static boolean checkCoredumpUpload(AppMonitor appMonitor, File file, JSONObject jSONObject) {
        CoreDumpConfig coreDumpConfig;
        try {
        } catch (Throwable th) {
            mCoreDeleteCause = "check coredump upload error";
            th.printStackTrace();
            NpthLog.m235w("corefile upload failed:" + th);
            NpthMonitor.reportInnerException(th);
        }
        if (mCoredumpSize != null && appMonitor != null && file.exists()) {
            String[] split = file.getAbsolutePath().split("/");
            mCoredumpUUID = split[split.length - 1];
            File file2 = new File(LogPathConfig.getNpthRootPath(), "asdawd/" + mCoredumpUUID);
            mCoreDir = file2;
            if (!file2.exists()) {
                JSONUtils.append(jSONObject, CORE_DUMP_DELETE, "core_dir_null");
                return false;
            }
            if (!RuntimeConfig.isLocalTest() && (coreDumpConfig = mCoreConfig) != null && !coreDumpConfig.isUploadEnable()) {
                mCoreDeleteCause = "config no init";
                JSONUtils.append(jSONObject, CORE_DUMP_DELETE, "config no init");
                FileUtils.deleteFile(mCoreDir);
            }
            return true;
        }
        return false;
    }

    public String getCoreDeleteCause() {
        return mCoreDeleteCause;
    }

    private static Map<String, String> readMetricsFromTombstone(File file) {
        HashMap hashMap;
        BufferedReader bufferedReader = null;
        HashMap hashMap2 = null;
        if (file == null) {
            return null;
        }
        File file2 = new File(file, "tombstone.txt");
        if (!file2.exists() || file2.length() == 0) {
            return null;
        }
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
            while (true) {
                boolean z = false;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            IoUtil.close(bufferedReader2);
                            return hashMap2;
                        }
                        if (!z) {
                            if (readLine.equals("metrics:")) {
                                z = true;
                            }
                        } else {
                            if (readLine.startsWith("--- --- --- ")) {
                                break;
                            }
                            int indexOf = readLine.indexOf(58);
                            if (indexOf != -1) {
                                String substring = readLine.substring(0, indexOf);
                                String trim = readLine.substring(indexOf + 1).trim();
                                if (!substring.isEmpty() && !trim.isEmpty()) {
                                    if (hashMap2 == null) {
                                        hashMap2 = new HashMap();
                                    }
                                    hashMap2.put(substring, trim);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        HashMap hashMap3 = hashMap2;
                        bufferedReader = bufferedReader2;
                        hashMap = hashMap3;
                        try {
                            NpthLog.m235w("Failed to read metrics from tombstone." + th);
                            IoUtil.close(bufferedReader);
                            return hashMap;
                        } catch (Throwable th2) {
                            IoUtil.close(bufferedReader);
                            throw th2;
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            hashMap = null;
        }
    }

    private static String getTimeRange(String str) {
        try {
            long parseLong = Long.parseLong(str);
            return parseLong <= 50 ? "0~50ms" : parseLong <= 100 ? "50~100ms" : parseLong <= 150 ? "100~150ms" : parseLong <= 200 ? "150~200ms" : parseLong <= 300 ? "200~300ms" : parseLong <= 400 ? "300~400ms" : parseLong <= 500 ? "400~500ms" : parseLong <= 700 ? "500~700ms" : parseLong <= 1000 ? "700~1000ms" : parseLong <= 1500 ? "1000~1500ms" : parseLong <= 2000 ? "1500~2000ms" : parseLong <= WsConstants.EXIT_DELAY_TIME ? "2000~3000ms" : parseLong <= 4000 ? "3000~4000ms" : parseLong <= PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS ? "4000~5000ms" : parseLong <= 7000 ? "5000~7000ms" : parseLong <= GWorker.INTERVAL ? "7000~10000ms" : "> 10000ms";
        } catch (Throwable unused) {
            return SchedulerSupport.NONE;
        }
    }

    private static String getCrashFramesCountRange(String str) {
        try {
            long parseLong = Long.parseLong(str);
            return parseLong > 200 ? "(200 - MAX)" : parseLong > 150 ? "(150 - 200]" : parseLong > 100 ? "(100 - 150]" : parseLong > 70 ? "(70 - 100]" : parseLong > 50 ? "(50 - 70]" : parseLong > 40 ? "(40 - 50]" : parseLong > 30 ? "(30 - 40]" : parseLong > 20 ? "(20 - 30]" : parseLong > 15 ? "(15 - 20]" : parseLong > 10 ? "(10 - 15]" : parseLong > 5 ? "(5 - 10]" : parseLong > 1 ? "(1 - 5]" : str;
        } catch (Throwable unused) {
            return SchedulerSupport.NONE;
        }
    }

    private static String getAllFramesCountRange(String str) {
        try {
            long parseLong = Long.parseLong(str);
            return parseLong > PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS ? "(5000 - MAX)" : parseLong > 4000 ? "(4000 - 5000]" : parseLong > WsConstants.EXIT_DELAY_TIME ? "(3000 - 4000]" : parseLong > 2000 ? "(2000 - 3000]" : parseLong > 1500 ? "(1500 - 2000]" : parseLong > 1000 ? "(1000 - 1500]" : parseLong > 500 ? "(500 - 1000]" : parseLong > 1 ? "(1 - 500]" : str;
        } catch (Throwable unused) {
            return SchedulerSupport.NONE;
        }
    }

    private static String getOrDefault(Map<String, String> map, String str, String str2) {
        String str3;
        return (map == null || (str3 = map.get(str)) == null || str3.isEmpty()) ? str2 : str3;
    }

    private static String getOrNone(Map<String, String> map, String str) {
        return getOrDefault(map, str, SchedulerSupport.NONE);
    }

    private static void appendMetric(JSONObject jSONObject, Map<String, String> map, String str) {
        JSONUtils.append(jSONObject, str, getOrNone(map, str));
    }

    private static void appendMetrics(JSONObject jSONObject, Map<String, String> map, String[] strArr) {
        for (String str : strArr) {
            JSONUtils.append(jSONObject, str, getOrNone(map, str));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0243, code lost:
    
        if (r14 == null) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean upload(AppMonitor appMonitor, CrashSummary crashSummary, File file, JSONObject jSONObject) {
        String str;
        boolean z;
        String str2;
        String str3;
        File file2;
        String str4;
        if (crashSummary.getCrashType() != CrashType.NATIVE) {
            return false;
        }
        Map<String, String> readMetricsFromTombstone = readMetricsFromTombstone(file);
        appendMetrics(jSONObject, readMetricsFromTombstone, new String[]{"unwind_return_code", "unwind_to_entrypoint", "unwind_last_name", "dumper_has_stack", "dumper_has_dex", "dump_crash_thread_done", "tombstone_done", "dumper_warning_code", "dumper_all_done", "has_protector"});
        JSONUtils.append(jSONObject, "has_dumper_metrics", (Object) true);
        String orNone = getOrNone(readMetricsFromTombstone, "crash_frames_count");
        JSONUtils.append(jSONObject, "crash_frames_count", orNone);
        JSONUtils.append(jSONObject, "crash_frames_count_range", getCrashFramesCountRange(orNone));
        String orNone2 = getOrNone(readMetricsFromTombstone, "all_frames_count");
        JSONUtils.append(jSONObject, "all_frames_count", orNone2);
        JSONUtils.append(jSONObject, "all_frames_count_range", getAllFramesCountRange(orNone2));
        String orNone3 = getOrNone(readMetricsFromTombstone, "tombstone_time");
        JSONUtils.append(jSONObject, "tombstone_time", orNone3);
        JSONUtils.append(jSONObject, "tombstone_time_range", getTimeRange(orNone3));
        String orNone4 = getOrNone(readMetricsFromTombstone, "dumper_total_time");
        JSONUtils.append(jSONObject, "dumper_total_time", orNone4);
        JSONUtils.append(jSONObject, "dumper_total_time_range", getTimeRange(orNone4));
        String orNone5 = getOrNone(readMetricsFromTombstone, "minidump_done");
        File file3 = new File(file, "minidump");
        appendMetric(jSONObject, readMetricsFromTombstone, "minidump_enabled");
        JSONUtils.append(jSONObject, "minidump_done", orNone5);
        JSONUtils.append(jSONObject, "has_minidump", String.valueOf(file3.exists()));
        String orNone6 = getOrNone(readMetricsFromTombstone, "minidump_time");
        JSONUtils.append(jSONObject, "minidump_time", orNone6);
        JSONUtils.append(jSONObject, "minidump_time_range", getTimeRange(orNone6));
        appendMetric(jSONObject, readMetricsFromTombstone, "coredump_enabled");
        mCoredumpSize = getOrDefault(readMetricsFromTombstone, "coredump_size", "0");
        mCoredumpAsyncMode = getOrNone(readMetricsFromTombstone, "coredump_async_mode");
        mCoredumpReturnCode = getOrNone(readMetricsFromTombstone, "coredump_return_code");
        mCoredumpTime = getOrNone(readMetricsFromTombstone, "coredump_time");
        try {
            mCoredumpDone = String.valueOf(Long.parseLong(mCoredumpReturnCode) == 0);
        } catch (Throwable unused) {
            mCoredumpDone = SchedulerSupport.NONE;
        }
        if (!checkCoredumpUpload(appMonitor, file, jSONObject)) {
            if (jSONObject.length() > 0) {
                JSONUtils.append(jSONObject, "coredump_miss", (Object) true);
            }
            JSONUtils.append(jSONObject, HAVE_CORE_DUMP, "false");
            return false;
        }
        if (isCoredumpExists()) {
            File file4 = null;
            try {
                if ("wifi".equals(LocaleInfo.getNetworkAccessType())) {
                    try {
                        file2 = new File(LogPathConfig.getNpthRootPath(), "asdawd/coredump.zip");
                    } catch (Throwable th) {
                        th = th;
                        str3 = "corefile upload failed:";
                        str = "coredump_miss";
                        str2 = CORE_DUMP_DELETE;
                    }
                    try {
                        try {
                            FileUtils.zip(mCoreDir.getAbsolutePath(), file2.getAbsolutePath());
                        } catch (Throwable th2) {
                            NpthMonitor.reportInnerException(th2);
                        }
                        Header assemblyCrashHeader = crashSummary.assemblyCrashHeader(appMonitor);
                        String coreDumpUrl = NetConfig.getCoreDumpUrl();
                        String jSONObject2 = assemblyCrashHeader.getJson().toString();
                        str = "coredump_miss";
                        try {
                            JSONObject put = new JSONObject().put("event_type", "raphael_file");
                            str4 = CORE_DUMP_DELETE;
                            str3 = "corefile upload failed:";
                            try {
                                boolean uploadCoreFile = CrashUploader.uploadCoreFile("coredump", coreDumpUrl, jSONObject2, put.put("timestamp", System.currentTimeMillis()).put("uuid", mCoredumpUUID).toString(), file2);
                                try {
                                    if (uploadCoreFile) {
                                        mCoreDeleteCause = "corefile upload";
                                        JSONUtils.append(jSONObject, HAVE_CORE_DUMP, (Object) true);
                                        JSONUtils.append(jSONObject, "coredump_no_upload", "false");
                                        JSONUtils.append(jSONObject, "coredump_real_size", getDumpSize());
                                        JSONUtils.append(jSONObject, "coredump_size_range", getDumpSizeRange());
                                        JSONUtils.append(jSONObject, "coredump_async_mode", mCoredumpAsyncMode);
                                        JSONUtils.append(jSONObject, "coredump_return_code", mCoredumpReturnCode);
                                        JSONUtils.append(jSONObject, "coredump_done", mCoredumpDone);
                                        JSONUtils.append(jSONObject, "coredump_time", mCoredumpTime);
                                        JSONUtils.append(jSONObject, "coredump_time_range", getTimeRange(mCoredumpTime));
                                        NpthLog.m233i("corefile upload");
                                    } else {
                                        mCoreDeleteCause = "corefile upload exception";
                                    }
                                    z = uploadCoreFile;
                                    file4 = file2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    z = uploadCoreFile;
                                    file4 = file2;
                                    str2 = str4;
                                    try {
                                        JSONUtils.append(jSONObject, str2, "execption");
                                        th.printStackTrace();
                                        NpthLog.m235w(str3 + th);
                                        NpthMonitor.reportInnerException(th);
                                    } finally {
                                        if (file4 != null) {
                                            FileUtils.deleteFile(file4);
                                        }
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                file4 = file2;
                                str2 = str4;
                                z = false;
                                JSONUtils.append(jSONObject, str2, "execption");
                                th.printStackTrace();
                                NpthLog.m235w(str3 + th);
                                NpthMonitor.reportInnerException(th);
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            str3 = "corefile upload failed:";
                            str2 = CORE_DUMP_DELETE;
                            file4 = file2;
                            z = false;
                            JSONUtils.append(jSONObject, str2, "execption");
                            th.printStackTrace();
                            NpthLog.m235w(str3 + th);
                            NpthMonitor.reportInnerException(th);
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        str3 = "corefile upload failed:";
                        str = "coredump_miss";
                        str2 = CORE_DUMP_DELETE;
                        file4 = file2;
                        z = false;
                        JSONUtils.append(jSONObject, str2, "execption");
                        th.printStackTrace();
                        NpthLog.m235w(str3 + th);
                        NpthMonitor.reportInnerException(th);
                    }
                } else {
                    str4 = CORE_DUMP_DELETE;
                    str3 = "corefile upload failed:";
                    str = "coredump_miss";
                    try {
                        mCoreDeleteCause = "network is not wifi";
                        z = false;
                    } catch (Throwable th7) {
                        th = th7;
                        str2 = str4;
                        z = false;
                        JSONUtils.append(jSONObject, str2, "execption");
                        th.printStackTrace();
                        NpthLog.m235w(str3 + th);
                        NpthMonitor.reportInnerException(th);
                    }
                }
                try {
                    str2 = str4;
                    try {
                        JSONUtils.append(jSONObject, str2, mCoreDeleteCause);
                    } catch (Throwable th8) {
                        th = th8;
                        JSONUtils.append(jSONObject, str2, "execption");
                        th.printStackTrace();
                        NpthLog.m235w(str3 + th);
                        NpthMonitor.reportInnerException(th);
                    }
                } catch (Throwable th9) {
                    th = th9;
                    str2 = str4;
                    JSONUtils.append(jSONObject, str2, "execption");
                    th.printStackTrace();
                    NpthLog.m235w(str3 + th);
                    NpthMonitor.reportInnerException(th);
                }
            } catch (Throwable th10) {
                th = th10;
                str2 = CORE_DUMP_DELETE;
                str3 = "corefile upload failed:";
                str = "coredump_miss";
            }
        } else {
            str = "coredump_miss";
            z = false;
        }
        if (!z) {
            if (jSONObject.length() > 0) {
                JSONUtils.append(jSONObject, str, (Object) true);
            }
            JSONUtils.append(jSONObject, HAVE_CORE_DUMP, "false");
        }
        return z;
    }
}
