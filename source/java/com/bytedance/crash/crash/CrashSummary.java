package com.bytedance.crash.crash;

import com.bytedance.crash.CrashAgent;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.alog.AlogManager;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.coredump.CoredumpAdapter;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.dumper.MemoryInfo;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.CrashFilter;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.resource.ResourceMonitor;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.upload.CrashUploadHandler;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.Digest;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class CrashSummary implements Comparable {
    protected static final String SUFFIX = ".summary";
    private static final String UPLOAD_STATE = "upload_state.inf";
    protected final long mCrashTime;
    protected final CrashType mCrashType;
    protected final File mDirectory;
    protected final int mPid;
    protected final String mProcessName;
    protected String mStackTrace;
    protected final long mStartTime;
    protected final String mThreadName;
    protected final int mTid;
    protected final long sAppStartUpTime;

    protected abstract void appendSpecialFilter(JSONObject jSONObject);

    protected abstract void assemblySpecialCrashBody(CrashBody crashBody, Header header);

    protected JSONObject getOriginalBody(JSONObject jSONObject) {
        return jSONObject;
    }

    protected abstract String loadStackTrace();

    /* JADX INFO: Access modifiers changed from: protected */
    public CrashSummary(File file, CrashType crashType, long j, long j2, long j3, String str, String str2, int i, int i2) {
        this.mDirectory = file;
        this.mCrashType = crashType;
        this.mStartTime = j;
        this.sAppStartUpTime = j2;
        this.mCrashTime = j3;
        this.mProcessName = str;
        this.mThreadName = str2;
        this.mPid = i;
        this.mTid = i2;
    }

    public int getPid() {
        return this.mPid;
    }

    public int getTid() {
        return this.mTid;
    }

    public long getCrashTime() {
        return this.mCrashTime;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public String getProcessName() {
        return this.mProcessName;
    }

    public String getThreadName() {
        return this.mThreadName;
    }

    public CrashType getCrashType() {
        return this.mCrashType;
    }

    public String getStackTrace() {
        return this.mStackTrace;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        long j = this.mCrashTime - ((CrashSummary) obj).mCrashTime;
        if (j > 0) {
            return -1;
        }
        return j < 0 ? 1 : 0;
    }

    public Header assemblyCrashHeader(AppMonitor appMonitor) {
        return Header.createCrashHeader(appMonitor, this.mStartTime, this.mCrashTime, this.mCrashType, this.mPid, this.mDirectory);
    }

    public CrashBody assemblyCrashBody(AppMonitor appMonitor) {
        Header createCrashHeader = Header.createCrashHeader(appMonitor, this.mStartTime, this.mCrashTime, this.mCrashType, this.mPid, this.mDirectory);
        CrashBody crashBody = new CrashBody();
        try {
            crashBody.put("pid", Integer.valueOf(this.mPid));
            crashBody.put(CrashBody.TID, Integer.valueOf(this.mTid));
            crashBody.put("crash_time", Long.valueOf(this.mCrashTime));
            crashBody.put(CrashBody.CRASH_THREAD_NAME, this.mThreadName);
            crashBody.put("process_name", this.mProcessName);
            crashBody.put("app_start_time", Long.valueOf(this.mStartTime));
            crashBody.put(CrashBody.APP_START_UP_TIME, Long.valueOf(this.sAppStartUpTime));
            crashBody.put(Constants.KEY_HW_JIFFIES, Long.valueOf(createCrashHeader.getJiffy()));
            crashBody.put(Constants.HAS_DUMP, "true");
            JSONUtils.put(crashBody.getJson(), "business", Global.getBusiness());
            crashBody.put("data", this.mStackTrace);
            crashBody.put("crash_md5", Digest.getMD5(this.mStackTrace));
            crashBody.put("launch_mode", Integer.valueOf(ActivityLifecycle.getLaunchMode()));
            crashBody.put(CrashBody.LAUNCH_TIME, Long.valueOf(ActivityLifecycle.getLaunchTime()));
            crashBody.put("session_id", createCrashHeader.getJson().opt("session_id"));
            loadCrashInfo(crashBody.getJson(), createCrashHeader.getJson(), this.mDirectory);
            CrashFilter.appendCommonFilter(createCrashHeader.getJson(), crashBody.getJson(), this.mDirectory);
            assemblyCrashBodyAfterFilter(crashBody.getJson(), this.mDirectory);
            assemblySpecialCrashBody(crashBody, createCrashHeader);
            appendSpecialFilter(crashBody.getJson());
        } catch (Throwable th) {
            NpthLog.m233i(th);
            NpthMonitor.reportInnerException(th);
        }
        return crashBody.setHeader(createCrashHeader);
    }

    private static void assemblyCrashBodyAfterFilter(JSONObject jSONObject, File file) {
        NativeBridge.parseSmaps(file.getAbsolutePath());
        MemoryInfo.packTaggedMapsSize(jSONObject, file);
        ResourceMonitor.appendResourceMonitorData(jSONObject, file);
    }

    protected void loadCrashInfo(JSONObject jSONObject, JSONObject jSONObject2, File file) {
        CrashDumper.loadCrashInfo(jSONObject, jSONObject2, file);
    }

    public static CrashSummary loadFromDirectory(File file, boolean z) {
        File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.bytedance.crash.crash.CrashSummary.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return str.endsWith(CrashSummary.SUFFIX);
            }
        });
        if (listFiles == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : listFiles) {
            if (z) {
                NativeCrashSummary load = NativeCrashSummary.load(file2);
                if (load != null) {
                    arrayList.add(load);
                }
            } else {
                JavaCrashSummary load2 = JavaCrashSummary.load(file2);
                if (load2 != null) {
                    arrayList.add(load2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Collections.sort(arrayList, new Comparator<CrashSummary>() { // from class: com.bytedance.crash.crash.CrashSummary.2
            @Override // java.util.Comparator
            public int compare(CrashSummary crashSummary, CrashSummary crashSummary2) {
                return crashSummary2.compareTo(crashSummary);
            }
        });
        return (CrashSummary) arrayList.get(0);
    }

    public static CrashSummary loadFromDirectory(File file) {
        File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.bytedance.crash.crash.CrashSummary.3
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return str.endsWith(CrashSummary.SUFFIX);
            }
        });
        if (listFiles == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : listFiles) {
            NativeCrashSummary load = NativeCrashSummary.load(file2);
            if (load != null) {
                arrayList.add(load);
            }
            JavaCrashSummary load2 = JavaCrashSummary.load(file2);
            if (load2 != null) {
                arrayList.add(load2);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Collections.sort(arrayList, new Comparator<CrashSummary>() { // from class: com.bytedance.crash.crash.CrashSummary.4
            @Override // java.util.Comparator
            public int compare(CrashSummary crashSummary, CrashSummary crashSummary2) {
                return crashSummary2.compareTo(crashSummary);
            }
        });
        return (CrashSummary) arrayList.get(0);
    }

    boolean checkIfNeedUpload() {
        int i;
        File file = new File(this.mDirectory, UPLOAD_STATE);
        int i2 = 0;
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                i = fileInputStream.read();
                try {
                    fileInputStream.close();
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                i = 0;
            }
            if (i < 0 || i >= 2) {
                if (i >= 2) {
                    NpthMonitor.reportInnerException("upload failed, retry count is" + i + ".", new Exception());
                }
                return false;
            }
            i2 = i + 1;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(i2);
            fileOutputStream.close();
        } catch (Exception unused3) {
        }
        return true;
    }

    private void deleteDirectory() {
        NpthLog.m233i("delete directory=" + this.mDirectory.getAbsolutePath());
        FileSystemUtils.deleteAll(this.mDirectory);
        if (this.mDirectory.exists()) {
            FileSystemUtils.createFile(this.mDirectory, UPLOAD_STATE);
        }
    }

    private void setInnerAid(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("header");
        JSONUtils.put(jSONObject.optJSONObject("filters"), "aid", optJSONObject != null ? String.valueOf(optJSONObject.opt("aid")) : "");
        JSONUtils.put(optJSONObject, "aid", 2010);
    }

    public boolean upload(AppMonitor appMonitor, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (!checkIfNeedUpload()) {
            deleteDirectory();
            return false;
        }
        File file = new File(this.mDirectory, "upload.json");
        String readUtf8File = FileSystemUtils.readUtf8File(file);
        JSONObject jSONObject4 = null;
        if (readUtf8File != null) {
            try {
                jSONObject2 = new JSONObject(readUtf8File);
                try {
                    jSONObject4 = jSONObject2.optJSONObject("header");
                } catch (JSONException unused) {
                }
            } catch (JSONException unused2) {
                jSONObject2 = null;
            }
            jSONObject3 = jSONObject4;
            jSONObject4 = jSONObject2;
        } else {
            jSONObject3 = null;
        }
        if (jSONObject4 == null || jSONObject3 == null) {
            try {
                CrashBody assemblyCrashBody = assemblyCrashBody(appMonitor);
                jSONObject4 = assemblyCrashBody.getJson();
                jSONObject3 = assemblyCrashBody.getHeaderJson();
                JSONObject jSONObject5 = JSONUtils.get(jSONObject4, "filters");
                if (jSONObject != null) {
                    JSONUtils.combineJson(jSONObject5, jSONObject);
                }
                z = true;
            } catch (Throwable th) {
                th = th;
                z2 = false;
                NpthLog.m239w(th);
                NpthMonitor.reportInnerException("upload exception", th);
                z3 = z2;
                afterUpload(jSONObject4, z4, z3);
                NpthLog.m233i("uploadOne:" + this.mDirectory.getAbsolutePath() + ", success=" + z4);
                return z4;
            }
        } else {
            z = false;
        }
        z3 = beforeUpload(appMonitor, jSONObject4);
        if (!z3) {
            try {
                String jSONObject6 = jSONObject4.toString();
                if (z) {
                    FileSystemUtils.writeFile(file, jSONObject6);
                }
                String urlByCrashTypeAndHeader = UploaderUrl.getUrlByCrashTypeAndHeader(this.mCrashType, jSONObject3);
                NpthLog.m233i("uploadOne: " + this.mCrashType + " :" + urlByCrashTypeAndHeader);
                z4 = CrashUploader.uploadCrashLogWithAttachment(this.mCrashType.getName(), urlByCrashTypeAndHeader, jSONObject6, getAttachmentFileList()).isSuccess();
            } catch (Throwable th2) {
                z2 = z3;
                th = th2;
                NpthLog.m239w(th);
                NpthMonitor.reportInnerException("upload exception", th);
                z3 = z2;
                afterUpload(jSONObject4, z4, z3);
                NpthLog.m233i("uploadOne:" + this.mDirectory.getAbsolutePath() + ", success=" + z4);
                return z4;
            }
        }
        afterUpload(jSONObject4, z4, z3);
        NpthLog.m233i("uploadOne:" + this.mDirectory.getAbsolutePath() + ", success=" + z4);
        return z4;
    }

    private boolean beforeUpload(AppMonitor appMonitor, JSONObject jSONObject) {
        if (appMonitor.getUserDataCenter().beforeUpload(this.mCrashType, jSONObject)) {
            return true;
        }
        JSONObject originalBody = getOriginalBody(jSONObject);
        CrashAgent.monitorCrash(this.mCrashType, this.mCrashTime, originalBody);
        NpthCheckUtils.checkUploadData(this.mCrashType, this.mDirectory, originalBody, jSONObject.optJSONObject("header"));
        return false;
    }

    private void afterUpload(JSONObject jSONObject, boolean z, boolean z2) {
        if (z) {
            try {
                AlogManager.record(this.mProcessName, this.mStartTime, this.mCrashTime, this.mCrashType);
                CrashUploadHandler.afterUploadOne(this.mCrashType);
            } catch (Throwable unused) {
                return;
            }
        }
        if (z || z2) {
            deleteDirectory();
            CoredumpAdapter.deleteCoreDir();
        }
    }

    List<File> getAttachmentFileList() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = this.mDirectory.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                String name = file.getName();
                if (!name.endsWith(SUFFIX) && !name.endsWith(".json") && !name.endsWith(".inf")) {
                    arrayList.add(file);
                }
            }
        }
        return arrayList;
    }
}
