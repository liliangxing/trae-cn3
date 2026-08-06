package com.bytedance.crash.terminate;

import android.app.ApplicationExitInfo;
import android.os.Build;
import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.IExitReasonCallback;
import com.bytedance.crash.IExitReasonListCallback;
import com.bytedance.crash.NpthCore;
import com.bytedance.crash.alog.AlogManager;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.dumper.Logcat;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.tracker.ProcessTracker;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.IoUtil;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.IApmAgent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TerminateMonitor {
    public static final String EXIT_INFO_PATH = "exit_info";
    public static final String HAS_PROCESS_TRACK = "has_process_track";
    private static final String KILL_HISTORY_DIR = "killHistory";
    public static final String KILL_INFO_PATH = "kill_info";
    private static final String LOG_TAG = "TerminateMonitor";
    private static final int MAX_SIZE = 20;
    private static final String PROC = "proc";
    private static boolean mInit;
    private static File mProcDirectory;
    private static File mProcProcessDirectory;
    public static File mTerminateHistoryDirectory;
    public static File mTerminateInfoDirectory;
    private static String mlogcatStr;
    private static boolean uploadAll;
    private static boolean uploadFG;
    private static ConcurrentLinkedQueue<IExitReasonCallback> sExitReasonCallbacks = new ConcurrentLinkedQueue<>();
    private static ConcurrentLinkedQueue<IExitReasonListCallback> callbacks = new ConcurrentLinkedQueue<>();
    private static boolean sUploadEnd = false;
    private static boolean isClean = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isImportantKillHistory(int i) {
        return i >= 0 && i < 300;
    }

    public static void init() {
        File rootDirectory;
        if (mInit || (rootDirectory = Global.getRootDirectory()) == null) {
            return;
        }
        mInit = true;
        NpthLog.m234i("KillInfo", "init");
        initFile(rootDirectory);
    }

    public static void setUploadFlag(boolean z, boolean z2) {
        uploadAll = z;
        uploadFG = z2;
    }

    public static void registerExitReasonCallback(IExitReasonCallback iExitReasonCallback) {
        sExitReasonCallbacks.add(iExitReasonCallback);
    }

    public static void registerExitReasonList(IExitReasonListCallback iExitReasonListCallback) {
        callbacks.add(iExitReasonListCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void callExitReasonCallback(List<ApplicationExitInfo> list) {
        try {
            Iterator<IExitReasonListCallback> it = callbacks.iterator();
            while (it.hasNext()) {
                try {
                    it.next().findExitReasons(list);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void callExitReasonCallbacks(ApplicationExitInfo applicationExitInfo) {
        try {
            Iterator<IExitReasonCallback> it = sExitReasonCallbacks.iterator();
            while (it.hasNext()) {
                try {
                    it.next().findOneExitReason(applicationExitInfo);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private static void initFile(File file) {
        File createDirectory = FileSystemUtils.createDirectory(file, KILL_HISTORY_DIR);
        mTerminateHistoryDirectory = createDirectory;
        mTerminateInfoDirectory = FileSystemUtils.createDirectory(createDirectory, KILL_INFO_PATH);
        mProcDirectory = FileSystemUtils.createDirectory(mTerminateHistoryDirectory, PROC);
        mProcProcessDirectory = FileSystemUtils.createDirectory(mProcDirectory, App.getCurProcessName(Global.getContext()).replace(".", "_").replace(":", "-"));
        try {
            new File(mProcProcessDirectory, Process.myPid() + "_" + Global.getAppStartTime()).createNewFile();
        } catch (IOException e) {
            NpthLog.m232e(e);
        } catch (Throwable unused) {
        }
    }

    public static void forceUploadAll() {
        forceStart(MonitorManager.getAppMonitor(), true, true, true);
    }

    public static void forceStart(boolean z, boolean z2, boolean z3) {
        forceStart(MonitorManager.getAppMonitor(), z, z2, z3);
    }

    static void forceStart(final AppMonitor appMonitor, boolean z, final boolean z2, final boolean z3) {
        Runnable runnable;
        Runnable runnable2;
        try {
        } catch (Throwable unused) {
            runnable = new Runnable() { // from class: com.bytedance.crash.terminate.TerminateMonitor.2
                @Override // java.lang.Runnable
                public void run() {
                    TerminateMonitor.cleanLogcat();
                    TerminateMonitor.clearExitInfo();
                }
            };
        }
        if (NpthCore.isStopUpload() || sUploadEnd) {
            runnable2 = new Runnable() { // from class: com.bytedance.crash.terminate.TerminateMonitor.2
                @Override // java.lang.Runnable
                public void run() {
                    TerminateMonitor.cleanLogcat();
                    TerminateMonitor.clearExitInfo();
                }
            };
        } else if (appMonitor == null) {
            runnable2 = new Runnable() { // from class: com.bytedance.crash.terminate.TerminateMonitor.2
                @Override // java.lang.Runnable
                public void run() {
                    TerminateMonitor.cleanLogcat();
                    TerminateMonitor.clearExitInfo();
                }
            };
        } else {
            init();
            if (App.isMainProcess()) {
                sUploadEnd = true;
                final List<ApplicationExitInfo> parseExitReason = ExitReasonMonitor.parseExitReason();
                if (parseExitReason == null || parseExitReason.size() == 0) {
                    runnable2 = new Runnable() { // from class: com.bytedance.crash.terminate.TerminateMonitor.2
                        @Override // java.lang.Runnable
                        public void run() {
                            TerminateMonitor.cleanLogcat();
                            TerminateMonitor.clearExitInfo();
                        }
                    };
                } else {
                    if (z) {
                        DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.terminate.TerminateMonitor.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Iterator it = parseExitReason.iterator();
                                while (it.hasNext()) {
                                    TerminateMonitor.uploadOne(appMonitor, (ApplicationExitInfo) it.next(), z2, z3);
                                }
                            }
                        });
                        runnable = new Runnable() { // from class: com.bytedance.crash.terminate.TerminateMonitor.2
                            @Override // java.lang.Runnable
                            public void run() {
                                TerminateMonitor.cleanLogcat();
                                TerminateMonitor.clearExitInfo();
                            }
                        };
                        DefaultWorkThread.post(runnable);
                        return;
                    }
                    runnable2 = new Runnable() { // from class: com.bytedance.crash.terminate.TerminateMonitor.2
                        @Override // java.lang.Runnable
                        public void run() {
                            TerminateMonitor.cleanLogcat();
                            TerminateMonitor.clearExitInfo();
                        }
                    };
                }
            } else {
                runnable2 = new Runnable() { // from class: com.bytedance.crash.terminate.TerminateMonitor.2
                    @Override // java.lang.Runnable
                    public void run() {
                        TerminateMonitor.cleanLogcat();
                        TerminateMonitor.clearExitInfo();
                    }
                };
            }
        }
        DefaultWorkThread.post(runnable2);
    }

    public static void upload(final AppMonitor appMonitor) {
        Runnable runnable;
        Runnable runnable2;
        if (appMonitor == null || !mInit) {
            return;
        }
        try {
        } catch (Throwable th) {
            try {
                NpthLog.m229e(LOG_TAG, "upload exception:" + th);
                runnable = new Runnable() { // from class: com.bytedance.crash.terminate.TerminateMonitor.4
                    @Override // java.lang.Runnable
                    public void run() {
                        TerminateMonitor.cleanLogcat();
                        TerminateMonitor.clearExitInfo();
                    }
                };
            } catch (Throwable th2) {
                DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.terminate.TerminateMonitor.4
                    @Override // java.lang.Runnable
                    public void run() {
                        TerminateMonitor.cleanLogcat();
                        TerminateMonitor.clearExitInfo();
                    }
                });
                throw th2;
            }
        }
        if (!NpthCore.isStopUpload() && App.isMainProcess()) {
            if (!sUploadEnd) {
                sUploadEnd = true;
                final List<ApplicationExitInfo> parseExitReason = ExitReasonMonitor.parseExitReason();
                if (parseExitReason != null && parseExitReason.size() != 0) {
                    DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.terminate.TerminateMonitor.3
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                for (ApplicationExitInfo applicationExitInfo : parseExitReason) {
                                    if (Build.VERSION.SDK_INT >= 30) {
                                        int importance = applicationExitInfo.getImportance();
                                        if (!TerminateMonitor.uploadAll && !TerminateMonitor.isImportantKillHistory(importance)) {
                                        }
                                    }
                                    TerminateMonitor.uploadOne(appMonitor, applicationExitInfo, true, true);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    runnable = new Runnable() { // from class: com.bytedance.crash.terminate.TerminateMonitor.4
                        @Override // java.lang.Runnable
                        public void run() {
                            TerminateMonitor.cleanLogcat();
                            TerminateMonitor.clearExitInfo();
                        }
                    };
                    DefaultWorkThread.post(runnable);
                    return;
                }
                runnable2 = new Runnable() { // from class: com.bytedance.crash.terminate.TerminateMonitor.4
                    @Override // java.lang.Runnable
                    public void run() {
                        TerminateMonitor.cleanLogcat();
                        TerminateMonitor.clearExitInfo();
                    }
                };
            } else {
                runnable2 = new Runnable() { // from class: com.bytedance.crash.terminate.TerminateMonitor.4
                    @Override // java.lang.Runnable
                    public void run() {
                        TerminateMonitor.cleanLogcat();
                        TerminateMonitor.clearExitInfo();
                    }
                };
            }
            DefaultWorkThread.post(runnable2);
        }
        runnable2 = new Runnable() { // from class: com.bytedance.crash.terminate.TerminateMonitor.4
            @Override // java.lang.Runnable
            public void run() {
                TerminateMonitor.cleanLogcat();
                TerminateMonitor.clearExitInfo();
            }
        };
        DefaultWorkThread.post(runnable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cleanLogcat() {
        try {
            new File(mTerminateHistoryDirectory, "custom_data").listFiles(new FilenameFilter() { // from class: com.bytedance.crash.terminate.TerminateMonitor.5
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str) {
                    File file2 = new File(file, str);
                    if (!file2.isDirectory()) {
                        return false;
                    }
                    FileUtils.deleteFile(file2);
                    return false;
                }
            });
        } catch (Throwable unused) {
        }
    }

    private static boolean killCustomizeExceptionUpload(AppMonitor appMonitor, long j, JSONObject jSONObject, File file) {
        try {
            JSONObject json = Header.createEventHeader(appMonitor, j, CrashType.NATIVE_CUSTOMIZE, Process.myPid()).getJson();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            jSONObject2.put("data", jSONArray);
            jSONObject2.put("header", json);
            if (mlogcatStr != null) {
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(mlogcatStr);
                jSONObject2.put(Constants.LOGCAT, jSONArray2);
            }
            return CrashUploader.uploadNativeExceptionLog(UploaderUrl.appendUrlParamsByHeader(NetConfig.getExceptionZipUploadUrl(), json), jSONObject2.toString(), file);
        } catch (Exception unused) {
            return false;
        }
    }

    private static void dumpActivityInfo(File file, Map<String, String> map, AppExitInfo appExitInfo, long j) {
        BufferedReader bufferedReader;
        Throwable th;
        String str;
        int indexOf;
        try {
            File processTrackFile = ProcessTracker.getInstance().getProcessTrackFile(appExitInfo.getProcessName(), j);
            if (processTrackFile != null && processTrackFile.exists()) {
                File file2 = new File(file, "process_track.txt");
                String str2 = null;
                try {
                    FileUtils.copyAppend(processTrackFile, file2);
                    map.put("has_process_track", "true");
                    bufferedReader = new BufferedReader(new FileReader(file2));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            } else if (readLine.contains("onResume")) {
                                str2 = readLine;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            IoUtil.close(bufferedReader);
                            throw th;
                        }
                    }
                    if (str2 != null) {
                        String[] split = str2.split(" ", 3);
                        if (split.length > 1 && (indexOf = (str = split[1]).indexOf(".onResume")) > 0) {
                            map.put("scene", str.substring(0, indexOf));
                        }
                    }
                    IoUtil.close(bufferedReader);
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                }
            } else {
                map.put("has_process_track", "false");
            }
        } catch (Throwable th4) {
            NpthMonitor.directReportInnerException("dumpActivityInfo", th4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void uploadOne(AppMonitor appMonitor, ApplicationExitInfo applicationExitInfo, boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        final AppExitInfo appExitInfo = AppExitInfo.get(applicationExitInfo);
        boolean z3 = true;
        final long[] jArr = {0};
        try {
            new File(mProcDirectory, appExitInfo.getProcessName().replace(".", "_").replace(":", "-")).listFiles(new FilenameFilter() { // from class: com.bytedance.crash.terminate.TerminateMonitor.6
                private long diff = 2147483647L;

                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str) {
                    try {
                        String[] split = str.split("_");
                        int parseInt = Integer.parseInt(split[0]);
                        long parseLong = Long.parseLong(split[1]);
                        if (parseInt == AppExitInfo.this.getPid()) {
                            long timestamp = AppExitInfo.this.getTimestamp() - parseLong;
                            if (timestamp > 0 && timestamp < this.diff) {
                                jArr[0] = parseLong;
                                this.diff = timestamp;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    return false;
                }
            });
        } catch (Throwable unused) {
        }
        long j = jArr[0];
        if (j == 0) {
            return;
        }
        String nativeStack = appExitInfo.getNativeStack(j);
        hashMap.put(Constants.EXIT_REASON, appExitInfo.getReason());
        hashMap.put("exit_sub_reason", appExitInfo.getSubReason());
        hashMap.put("exit_description", appExitInfo.getDescription());
        hashMap.put("exit_status", String.valueOf(appExitInfo.getStatus()));
        hashMap.put("exit_pss", AppExitInfoUtils.memValueToRange(appExitInfo.getRealPss()));
        hashMap.put("exit_rss", AppExitInfoUtils.memValueToRange(appExitInfo.getRealRss()));
        hashMap.put("importance", String.valueOf(appExitInfo.getImportance()));
        hashMap.put("has_exit_info", "true");
        if (!((String) hashMap.get(Constants.EXIT_REASON)).equals("not obtained") && !((String) hashMap.get(Constants.EXIT_REASON)).equals("USER REQUESTED")) {
            z3 = false;
        }
        if (z3) {
            try {
                IApmAgent iApmAgent = (IApmAgent) ServiceManager.getService(IApmAgent.class);
                JSONObject jSONObject = new JSONObject();
                if (iApmAgent != null) {
                    jSONObject.put("reason", hashMap.get(Constants.EXIT_REASON));
                    iApmAgent.monitorEvent(AppExitInfoUtils.APP_EXIT, jSONObject, (JSONObject) null, (JSONObject) null);
                    return;
                }
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        JSONObject json = appExitInfo.toJson(jArr[0], nativeStack);
        try {
            File file = new File(mTerminateHistoryDirectory, "custom_data");
            file.mkdirs();
            File file2 = new File(file, appExitInfo.getTimestamp() + "_" + appExitInfo.getPid());
            if (!file2.exists()) {
                file2.mkdirs();
            }
            dumpActivityInfo(file2, hashMap, appExitInfo, jArr[0]);
            if (z2) {
                dumpLogcat(file2, hashMap);
            }
            dumpOsMemoryInfo(file2, hashMap);
            if (z) {
                dumpAlogInfo(applicationExitInfo, hashMap);
            }
            appExitInfo.appendFilters(json, hashMap);
            boolean killCustomizeExceptionUpload = killCustomizeExceptionUpload(appMonitor, appExitInfo.getTimestamp(), json, file2);
            if (killCustomizeExceptionUpload) {
                NpthLog.m234i("KillInfo ", "upload success:" + killCustomizeExceptionUpload);
                FileSystemUtils.deleteAll(file2);
            }
            FileSystemUtils.deleteAll(file2);
        } catch (Throwable th) {
            NpthLog.m235w("KillInfo:" + th);
        }
    }

    public static long decodeWithCatch(String str, long j) {
        try {
            return Long.decode(str).longValue();
        } catch (Throwable unused) {
            return j;
        }
    }

    private static boolean dumpLogcat(File file, Map<String, String> map) {
        try {
            Logcat.npthDump(file, true);
            if (!Logcat.isLogcatExists(file)) {
                return false;
            }
            String readFile = FileUtils.readFile(new File(file, "logcat.txt"));
            mlogcatStr = readFile;
            if (readFile.isEmpty() || mlogcatStr.length() <= 10) {
                return false;
            }
            map.put("has_logcat", "true");
            return true;
        } catch (Throwable th) {
            NpthLog.m235w("KillInfo:" + th);
            return false;
        }
    }

    private static boolean dumpOsMemoryInfo(File file, Map<String, String> map) {
        String readFile;
        try {
            NativeBridge.dumpMeminfo(file.getAbsolutePath(), true);
            File file2 = new File(file, "os_memory.txt");
            if (file2.exists() && file2.length() > 10 && (readFile = FileUtils.readFile(file2)) != null && readFile.contains("kB")) {
                map.put("has_os_memory", "true");
                return true;
            }
            map.put("has_os_memory", "false");
            return false;
        } catch (IOException e) {
            NpthLog.m235w("KillInfo:" + e);
            return false;
        }
    }

    private static void dumpAlogInfo(ApplicationExitInfo applicationExitInfo, Map<String, String> map) {
        try {
            AlogManager.record(applicationExitInfo.getProcessName(), 0L, applicationExitInfo.getTimestamp(), CrashType.NATIVE_CUSTOMIZE);
            map.put("has_alog", "true");
        } catch (Throwable th) {
            NpthLog.m235w("KillInfo:" + th);
        }
    }

    public static void put(JSONObject jSONObject, String str, Object obj) {
        JSONUtils.put(jSONObject, str, obj);
    }

    static void clearExitInfo() {
        if (mProcProcessDirectory.exists() && !isClean) {
            isClean = true;
            File[] listFiles = mProcProcessDirectory.listFiles(new FilenameFilter() { // from class: com.bytedance.crash.terminate.TerminateMonitor.7
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str) {
                    return str.split("_").length == 2;
                }
            });
            if (listFiles == null || listFiles.length <= 20) {
                return;
            }
            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.bytedance.crash.terminate.TerminateMonitor.8
                @Override // java.util.Comparator
                public int compare(File file, File file2) {
                    long lastModified = file.lastModified() - file2.lastModified();
                    if (lastModified > 0) {
                        return 1;
                    }
                    return lastModified == 0 ? 0 : -1;
                }
            });
            for (int i = 0; i < listFiles.length - 20; i++) {
                FileUtils.deleteFile(listFiles[i]);
            }
        }
    }
}
