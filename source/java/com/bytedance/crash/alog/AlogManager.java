package com.bytedance.crash.alog;

import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.NpthAlogApi;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.Net;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AlogManager {
    public static final String ERR_NO_AID = "no_aid";
    public static final String ERR_NO_DID = "no_did";
    public static final String ERR_SUCCESS = "success";
    public static final String ERR_UNKNOWN = "unknown";
    private static Controller sController;
    private static final HashMap<String, CrashRecord> sCrashRecords = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface Controller {
        List<String> collect(long j, String str);

        void flush();

        boolean isInit();
    }

    public static void setInnerController(String str, IALogCrashObserver iALogCrashObserver, IAlogUploadStrategy iAlogUploadStrategy) {
        if (TextUtils.isEmpty(str) || sController != null) {
            return;
        }
        sController = new InnerController(str, iALogCrashObserver, iAlogUploadStrategy);
    }

    public static void setExternalController() {
        if (NpthAlogApi.getAlogFilesInit() && NpthAlogApi.sAlogFlushInit()) {
            sController = new ExternalController();
        }
    }

    public static boolean isInit() {
        Controller controller = sController;
        return controller != null && controller.isInit();
    }

    public static void flushData() {
        if (isInit()) {
            sController.flush();
        }
    }

    public static List<String> collectAlog(long j, String str) {
        if (isInit()) {
            return sController.collect(j, str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class InnerController implements Controller {
        private final File mAlogFilesDir;
        private final IAlogUploadStrategy mAlogUploadStrategy;
        private final IALogCrashObserver mLogCrashObserver;

        @Override // com.bytedance.crash.alog.AlogManager.Controller
        public boolean isInit() {
            return true;
        }

        InnerController(String str, IALogCrashObserver iALogCrashObserver, IAlogUploadStrategy iAlogUploadStrategy) {
            this.mAlogFilesDir = new File(str);
            this.mLogCrashObserver = iALogCrashObserver;
            this.mAlogUploadStrategy = iAlogUploadStrategy;
        }

        @Override // com.bytedance.crash.alog.AlogManager.Controller
        public List<String> collect(long j, String str) {
            if (!this.mAlogFilesDir.exists()) {
                return null;
            }
            IAlogUploadStrategy iAlogUploadStrategy = this.mAlogUploadStrategy;
            if (iAlogUploadStrategy instanceof DefaultAlogUploadStrategy) {
                iAlogUploadStrategy = new DefaultAlogUploadStrategy(str);
            }
            try {
                return iAlogUploadStrategy.getUploadAlogFiles(this.mAlogFilesDir.getAbsolutePath(), j);
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // com.bytedance.crash.alog.AlogManager.Controller
        public void flush() {
            IALogCrashObserver iALogCrashObserver = this.mLogCrashObserver;
            if (iALogCrashObserver != null) {
                try {
                    iALogCrashObserver.flushAlogDataToFile();
                } catch (Throwable th) {
                    NpthMonitor.reportInnerException(th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class ExternalController implements Controller {
        ExternalController() {
        }

        @Override // com.bytedance.crash.alog.AlogManager.Controller
        public List<String> collect(long j, String str) {
            try {
                return NpthAlogApi.getAlogFiles(j, str);
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // com.bytedance.crash.alog.AlogManager.Controller
        public void flush() {
            try {
                NpthAlogApi.flushAlogSync();
            } catch (Throwable unused) {
            }
        }

        @Override // com.bytedance.crash.alog.AlogManager.Controller
        public boolean isInit() {
            try {
                return NpthAlogApi.isAlogInit();
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class CrashRecord {
        final List<Long> mCrashTimeList;
        boolean mIsLunch;
        final String mProcessName;

        CrashRecord(String str, long j, CrashType crashType) {
            ArrayList arrayList = new ArrayList();
            this.mCrashTimeList = arrayList;
            this.mProcessName = str;
            arrayList.add(Long.valueOf(j));
            if (crashType == CrashType.LAUNCH) {
                this.mIsLunch = true;
            }
        }

        void append(long j, CrashType crashType) {
            this.mCrashTimeList.add(Long.valueOf(j));
            if (crashType == CrashType.LAUNCH) {
                this.mIsLunch = true;
            }
        }
    }

    public static void record(String str, long j, long j2, CrashType crashType) {
        HashMap<String, CrashRecord> hashMap = sCrashRecords;
        synchronized (hashMap) {
            CrashRecord crashRecord = hashMap.get(str + j);
            if (crashRecord == null) {
                hashMap.put(str + j, new CrashRecord(str, j2, crashType));
            } else {
                crashRecord.append(j2, crashType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void uploadAlogRecord(AppMonitor appMonitor) {
        HashMap hashMap;
        HashMap<String, CrashRecord> hashMap2 = sCrashRecords;
        synchronized (hashMap2) {
            hashMap = new HashMap(hashMap2);
            hashMap2.clear();
        }
        Iterator it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            CrashRecord crashRecord = (CrashRecord) hashMap.get((String) it.next());
            if (crashRecord != null && !crashRecord.mCrashTimeList.isEmpty()) {
                HashSet hashSet = new HashSet();
                Iterator<Long> it2 = crashRecord.mCrashTimeList.iterator();
                while (it2.hasNext()) {
                    List<String> collectAlog = collectAlog(it2.next().longValue(), crashRecord.mProcessName);
                    if (collectAlog != null) {
                        hashSet.addAll(collectAlog);
                    }
                }
                if (!hashSet.isEmpty()) {
                    String uploadAlog = uploadAlog(appMonitor, new ArrayList(hashSet), crashRecord.mProcessName);
                    NpthMonitor.Event event = new NpthMonitor.Event("alog_check");
                    Object[] objArr = new Object[6];
                    objArr[0] = "check_result";
                    objArr[1] = uploadAlog;
                    objArr[2] = Header.KEY_CRASH_TYPE;
                    objArr[3] = crashRecord.mIsLunch ? "lunch" : "normal";
                    objArr[4] = "alog_inited";
                    objArr[5] = isInit() ? "true" : "uncertain";
                    event.addCategories(objArr).upload();
                }
            }
        }
    }

    private static String uploadAlog(AppMonitor appMonitor, List<String> list, String str) {
        int i;
        try {
            i = Integer.parseInt(appMonitor.getAppId());
        } catch (Throwable unused) {
            i = 0;
        }
        if (i <= 0) {
            return "no_aid";
        }
        try {
            String deviceId = appMonitor.getDeviceId("0");
            if (TextUtils.isEmpty(deviceId)) {
                return "no_did";
            }
            return CrashUploader.uploadAlogFiles(UploaderUrl.appendAlogUrlParams(NetConfig.getAlogUploadUrl(), i, deviceId, appMonitor.getVersionName(), appMonitor.getUpdateVersionCode()), i, deviceId, str, list) ? "success" : "unknown";
        } catch (Throwable th) {
            NpthMonitor.reportInnerException(th);
            return "unknown";
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    static class UploadTask implements Runnable {
        private AppMonitor mAppMonitor;
        private final int MAX_CHECK_TIMES = 60;
        private int mCheckTimes = 0;

        UploadTask(AppMonitor appMonitor) {
            this.mAppMonitor = appMonitor;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlogManager.isInit() && Net.isNetworkAvailable()) {
                AlogManager.uploadAlogRecord(this.mAppMonitor);
                return;
            }
            int i = this.mCheckTimes;
            this.mCheckTimes = i + 1;
            if (i < 60) {
                DefaultWorkThread.postDelayed(this, 2000L);
            }
        }
    }

    public static void setAlogFlushFunction(long j) {
        NativeBridge.setAlogFlushFunction(j);
    }

    public static void upload(AppMonitor appMonitor) {
        try {
            new UploadTask(appMonitor).run();
        } catch (Exception e) {
            NpthMonitor.reportInnerException("NPTH_ANR_ERROR_AlogManager", e);
        }
    }
}
