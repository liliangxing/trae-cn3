package com.bytedance.crash.resource;

import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.config.NpthBuildConfig;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.event.EnsureReportData;
import com.bytedance.crash.general.RomInfoHelper;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.resource.utils.GuardFile;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.crash.util.NumRanges;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.librarian.Librarian;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class ResourceMonitorAdapter {
    private static final int DIRS_LIMIT_UNEXPECTED = 15;
    public static final int RET_OK = 0;
    private static final String TAG = "ResourceMonitorAdapter: ";
    protected String mConfigDir;
    protected File mConfigFile;
    protected GuardFile mGuardFile;
    protected String mLogDir;
    protected File mReportDir;
    protected boolean mSoLoaded = false;
    protected boolean mHasInited = false;

    protected void executeMonitor() {
    }

    protected boolean initBeforeExecute() {
        return true;
    }

    protected boolean initBeforeSoLoad() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startMonitor(ResourceMonitorConfig resourceMonitorConfig) {
        if (resourceMonitorConfig != null && initMonitor(resourceMonitorConfig) && initBeforeExecute()) {
            this.mGuardFile.deleteGurardFile();
            if (resourceMonitorConfig.getResourceType() != 4) {
                DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.resource.ResourceMonitorAdapter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ResourceMonitorAdapter.this.clearFilesIfNeed();
                    }
                });
                dumpHeader();
            }
            executeMonitor();
        }
    }

    private synchronized boolean initMonitor(ResourceMonitorConfig resourceMonitorConfig) {
        if (this.mHasInited) {
            return false;
        }
        this.mHasInited = true;
        if (Build.VERSION.SDK_INT >= resourceMonitorConfig.getmApiLevelMin() && Build.VERSION.SDK_INT <= resourceMonitorConfig.getmApiLevelMax()) {
            this.mConfigDir = Global.getConfigDir();
            File reportDir = resourceMonitorConfig.getReportDir();
            this.mReportDir = reportDir;
            if (reportDir != null && (reportDir.exists() || this.mReportDir.mkdir())) {
                this.mLogDir = this.mReportDir.getAbsolutePath() + "/" + CrashManager.getProcessDirectoryName();
                GuardFile guardFile = new GuardFile(this.mReportDir.getAbsolutePath(), resourceMonitorConfig.getGuardFileName(), 604800L);
                this.mGuardFile = guardFile;
                if (!guardFile.checkGuardFile()) {
                    return false;
                }
                if (!initBeforeSoLoad()) {
                    return false;
                }
                writeConfig(resourceMonitorConfig);
                if (!loadLibrary(resourceMonitorConfig)) {
                    NpthLog.m234i(TAG, "loadLibrary() failed!");
                    return false;
                }
                try {
                    if (this.mConfigDir != null) {
                        return NativeResourceMonitor.LoadNativeBridgeSoInit(Build.VERSION.SDK_INT, resourceMonitorConfig.getResourceType(), resourceMonitorConfig.getFullSoName(), getAppVersion(), this.mLogDir, this.mConfigDir) == 0;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return false;
            }
            NpthLog.m229e(TAG, "cannot create " + this.mReportDir);
            return false;
        }
        NpthLog.m229e(TAG, "Unsupported API!!!");
        return false;
    }

    public void dumpHeader() {
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        if (appMonitor == null || this.mLogDir == null) {
            return;
        }
        File file = new File(this.mLogDir, "summary.json");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            if (appMonitor.getVersionCode() != 0 && !TextUtils.isEmpty(appMonitor.getVersionName())) {
                jSONObject2.put("version_code", appMonitor.getVersionCode());
                jSONObject2.put("update_version_code", appMonitor.getUpdateVersionCode());
                jSONObject2.put("version_name", appMonitor.getVersionName());
                jSONObject2.put("app_version", appMonitor.getVersionName());
                jSONObject2.put("manifest_version_code", appMonitor.getManifestVersionCode());
            }
            jSONObject2.put("channel", appMonitor.getChannel());
            jSONObject2.put("os_api", RomInfoHelper.getOsApiLevel());
            jSONObject2.put("os_version", RomInfoHelper.getOsVersion());
            jSONObject2.put("sdk_version_name", NpthBuildConfig.VERSION_NAME);
            jSONObject2.put("sdk_version", 4020260);
            jSONObject2.put("app_start_time", Global.getAppStartTime());
            jSONObject3.put("is_64_runtime", NativeBridge.is64BitRuntime() ? "true" : "false");
            jSONObject3.put("sdk_version", NpthBuildConfig.VERSION_NAME);
            jSONObject.put("header", jSONObject2);
            jSONObject.put("filters", jSONObject3);
        } catch (Throwable unused) {
        }
        if (jSONObject.length() > 0) {
            FileSystemUtils.writeFile(file, jSONObject.toString());
        }
    }

    private static String getAppVersion() {
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        return appMonitor != null ? String.valueOf(appMonitor.getVersionCode()) : "unknown";
    }

    private boolean loadLibrary(ResourceMonitorConfig resourceMonitorConfig) {
        NpthLog.m234i(TAG, "loadLibrary...");
        if (!this.mSoLoaded) {
            try {
                Librarian.loadLibraryForModule(resourceMonitorConfig.getLibName(), Global.getContext());
                this.mSoLoaded = true;
            } catch (Throwable unused) {
            }
        }
        return this.mSoLoaded;
    }

    private void writeConfig(ResourceMonitorConfig resourceMonitorConfig) {
        if (resourceMonitorConfig == null) {
            return;
        }
        try {
            File file = new File(this.mConfigDir, resourceMonitorConfig.getConfigName());
            this.mConfigFile = file;
            if (!file.exists()) {
                this.mConfigFile.createNewFile();
            }
            NpthLog.m229e(TAG, "write Config");
            FileUtils.writeFile(this.mConfigFile, resourceMonitorConfig.toString(), false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void clearFilesIfNeed() {
        File[] listFiles;
        File file = this.mReportDir;
        if (file == null || this.mLogDir == null || (listFiles = file.listFiles()) == null || listFiles.length < 15) {
            return;
        }
        try {
            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.bytedance.crash.resource.ResourceMonitorAdapter.2
                @Override // java.util.Comparator
                public int compare(File file2, File file3) {
                    long lastModified = file2.lastModified() - file3.lastModified();
                    if (lastModified > 0) {
                        return 1;
                    }
                    return lastModified == 0 ? 0 : -1;
                }
            });
            for (int i = 0; i < listFiles.length - 15; i++) {
                File file2 = listFiles[i];
                if (!this.mLogDir.equals(file2.getAbsolutePath())) {
                    FileUtils.deleteFile(file2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class UploaderData {
        public String mJavaStack = "";
        public String mNativeStack = null;
        public String mThreadName = null;
        public String mAbortLine = null;
        public String mProcessName = null;
        public long mPid = 0;
        public long mTid = 0;
        public JSONArray mSoUUID = new JSONArray();
        public Map<String, String> filterData = new HashMap();
        public JSONObject extraDataInBody = new JSONObject();

        UploaderData() {
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static abstract class ResourceMonitorUploader {
        private static final int EXCEPTION_LIMIT = 10;
        private static final String TAG = "ResourceMonitorUploader: ";
        protected String mIgnorePath;
        protected AppMonitor mMonitor;
        protected File mReportDir;

        /* JADX INFO: Access modifiers changed from: protected */
        public static String getSizeRangeMB(long j) {
            return j <= 350 ? "~350MB" : (j <= 350 || j > 450) ? (j <= 450 || j > 550) ? (j <= 550 || j > 650) ? (j <= 650 || j > 750) ? (j <= 750 || j > 850) ? (j <= 850 || j > 950) ? (j <= 950 || j > 1050) ? (j <= 1050 || j > 1250) ? (j <= 1250 || j > 1450) ? (j <= 1450 || j > 1650) ? (j <= 1650 || j > 1850) ? (j <= 1850 || j > 2050) ? ">2.3G" : "1850MB~2050MB" : "1650MB~1850MB" : "1450MB~1650MB" : "1250MB~1450MB" : "1050MB~1250MB" : "950MB~1050MB" : "850MB~950MB" : "750MB~850MB" : "650MB~750MB" : "550MB~650MB" : "450MB~550MB" : "350MB~450MB";
        }

        protected abstract boolean parseReport(File file, UploaderData uploaderData);

        /* JADX INFO: Access modifiers changed from: protected */
        public ResourceMonitorUploader(AppMonitor appMonitor, File file) {
            this.mMonitor = appMonitor;
            this.mReportDir = file;
            this.mIgnorePath = file.getAbsolutePath() + "/" + CrashManager.getProcessDirectoryName();
        }

        public void uploadAll() {
            File[] listFiles = this.mReportDir.listFiles();
            if (listFiles == null) {
                return;
            }
            int length = listFiles.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                File file = listFiles[i2];
                if (!this.mIgnorePath.equals(file.getAbsolutePath()) && !file.isFile()) {
                    if (!FileUtils.isEmpty(file)) {
                        int i3 = i + 1;
                        if (i >= 10) {
                            i = i3;
                        } else {
                            UploaderData uploaderData = new UploaderData();
                            HashMap hashMap = new HashMap();
                            try {
                                if (parseReport(file, uploaderData)) {
                                    packFilterData(hashMap, uploaderData);
                                    NativeBridge.parseSmaps(file.getAbsolutePath());
                                    nativeCustomizeExceptionUpload(file, hashMap, uploaderData);
                                } else {
                                    FileUtils.deleteFile(file);
                                }
                            } finally {
                                try {
                                    FileUtils.deleteFile(file);
                                    i = i3;
                                } finally {
                                }
                            }
                            FileUtils.deleteFile(file);
                            i = i3;
                        }
                    }
                }
            }
        }

        public void updateHeader(File file, JSONObject jSONObject, JSONObject jSONObject2) {
            File file2 = new File(file, "summary.json");
            File file3 = new File(file, "crash_time");
            String readUtf8File = FileSystemUtils.readUtf8File(file2);
            String readUtf8File2 = FileSystemUtils.readUtf8File(file3);
            JSONObject optJSONObject = jSONObject2.optJSONObject("filters");
            if (readUtf8File != null) {
                try {
                    JSONObject jSONObject3 = new JSONObject(readUtf8File);
                    JSONUtils.combineJson(jSONObject, jSONObject3.optJSONObject("header"));
                    JSONUtils.combineJson(optJSONObject, jSONObject3.optJSONObject("filters"));
                    jSONObject2.put("app_start_time", jSONObject.opt("app_start_time"));
                } catch (Throwable unused) {
                    return;
                }
            }
            if (readUtf8File2 != null) {
                long parseLong = Long.parseLong(readUtf8File2) * 1000;
                jSONObject2.put("crash_time", parseLong);
                jSONObject2.put("timestamp", parseLong);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static int getLineIndex(JSONArray jSONArray, int i, String str) {
            while (i < jSONArray.length()) {
                String optString = jSONArray.optString(i, null);
                if (optString != null && optString.startsWith(str)) {
                    return i;
                }
                i++;
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static String buildIDToUUID(String str) {
            StringBuilder sb = new StringBuilder();
            try {
                if (str.length() < 16) {
                    sb.append(str);
                } else {
                    sb.append(str.charAt(6));
                    sb.append(str.charAt(7));
                    sb.append(str.charAt(4));
                    sb.append(str.charAt(5));
                    sb.append(str.charAt(2));
                    sb.append(str.charAt(3));
                    sb.append(str.charAt(0));
                    sb.append(str.charAt(1));
                    sb.append(str.charAt(10));
                    sb.append(str.charAt(11));
                    sb.append(str.charAt(8));
                    sb.append(str.charAt(9));
                    sb.append(str.charAt(14));
                    sb.append(str.charAt(15));
                    sb.append(str.charAt(12));
                    sb.append(str.charAt(13));
                    if (str.length() >= 32) {
                        sb.append((CharSequence) str, 16, 32);
                        sb.append('0');
                    }
                }
            } catch (Throwable unused) {
            }
            return sb.toString().toUpperCase();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static String getSizeRangeMultiUnit(long j) {
            long j2;
            String str;
            Long[] lArr = {0L, 1L, 16L, 128L, 512L, 1024L};
            if (j < 1024) {
                lArr = new Long[]{0L, 16L, 64L, 128L, 256L, 512L, 1024L};
                str = "KB";
                j2 = j;
            } else {
                j2 = j / 1024;
                str = "MB";
            }
            NumRanges numRanges = new NumRanges(str);
            numRanges.set(lArr);
            return numRanges.get(j2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static String getSizeRange(String str, String str2) {
            if (str == null) {
                return PreloadConfig.KEY_OTHER;
            }
            if (str2 == null || str2.length() == 0) {
                str2 = "B";
            }
            str2.hashCode();
            if (str2.equals("GB")) {
                return "1GB+";
            }
            if (!str2.equals("MB")) {
                return "0~1MB";
            }
            try {
                int parseInt = Integer.parseInt(str.substring(0, str.indexOf(46)));
                return parseInt < 200 ? "0~200MB" : parseInt < 500 ? "200~500MB" : parseInt < 800 ? "500~800MB" : "800~1024MB(1G)";
            } catch (Throwable unused) {
                return PreloadConfig.KEY_OTHER;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void nativeCustomizeExceptionUploadInner(EnsureReportData ensureReportData, File file, UploaderData uploaderData) {
            try {
                JSONObject json = Header.createEventHeader(this.mMonitor, System.currentTimeMillis(), CrashType.NATIVE_CUSTOMIZE, (int) uploaderData.mPid).getJson();
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                JSONObject jsonObject = ensureReportData.toJsonObject(this.mMonitor);
                jSONArray.put(jsonObject);
                jSONObject.put("data", jSONArray);
                jSONObject.put(CrashBody.CRASH_LIB_UUID, uploaderData.mSoUUID);
                JSONUtils.combineJson(jSONObject, uploaderData.extraDataInBody);
                jSONObject.put("header", json);
                updateHeader(file, json, jsonObject);
                if (CrashUploader.uploadNativeExceptionLog(UploaderUrl.appendUrlParamsByHeader(NetConfig.getExceptionZipUploadUrl(), json), jSONObject.toString(), file)) {
                    NpthLog.m227d("ResourceMonitorUploader: upload success");
                    FileUtils.deleteFile(file);
                }
            } catch (Exception unused) {
            }
        }

        private void nativeCustomizeExceptionUpload(final File file, Map<String, String> map, final UploaderData uploaderData) {
            AppMonitor appMonitor = this.mMonitor;
            if (appMonitor == null || appMonitor.getEnsureDeliver() == null) {
                return;
            }
            if (uploaderData.mPid == 0) {
                uploaderData.mPid = Process.myPid();
            }
            final EnsureReportData ensureReportData = new EnsureReportData(uploaderData.mJavaStack, uploaderData.mNativeStack, uploaderData.mAbortLine, map, uploaderData.mThreadName, "1", "native_exception", (int) uploaderData.mPid);
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                nativeCustomizeExceptionUploadInner(ensureReportData, file, uploaderData);
            } else {
                DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ResourceMonitorUploader.this.nativeCustomizeExceptionUploadInner(ensureReportData, file, uploaderData);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void packFilterData(Map<String, String> map, UploaderData uploaderData) {
            if (map == null || uploaderData == null) {
                return;
            }
            map.putAll(uploaderData.filterData);
        }
    }
}
