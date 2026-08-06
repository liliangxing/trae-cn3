package com.bytedance.crash.alog;

import android.text.TextUtils;
import com.bytedance.crash.Ensure;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.entity.UploadRequest;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.upload.CrashUploadManager;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.List;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AlogUploadManager {
    public static final String ERR_NORMAL = "normal";
    public static final String ERR_NO_AID = "no_aid";
    public static final String ERR_NO_ALOG_FILES = "no_files";
    public static final String ERR_NO_DID = "no_did";
    public static final String ERR_NO_PROCESS = "no_process";
    public static final String ERR_UNKNOWN = "unknown";
    private static volatile AlogUploadManager sInstance;

    public static AlogUploadManager getInstance() {
        if (sInstance == null) {
            synchronized (AlogUploadManager.class) {
                if (sInstance == null) {
                    sInstance = new AlogUploadManager();
                }
            }
        }
        return sInstance;
    }

    public void flushData() {
        AlogManager.flushData();
    }

    public List<String> collectAlog(long j, String str, String str2) {
        return AlogManager.collectAlog(j, str);
    }

    public boolean isInit() {
        return AlogManager.isInit();
    }

    public static UploadRequest buildUploadRequest(List<String> list, String str) {
        String str2;
        String str3;
        UploadRequest uploadRequest = new UploadRequest();
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        if (appMonitor != null) {
            str2 = appMonitor.getAppId();
            str3 = appMonitor.getDeviceId("0");
        } else {
            str2 = "4444";
            str3 = "0";
        }
        String str4 = str2 != null ? str2 : "4444";
        String str5 = str3 != null ? str3 : "0";
        uploadRequest.setAid(str4);
        uploadRequest.setDid(str5);
        uploadRequest.setProcessName(str);
        uploadRequest.setAlogFiles(list);
        return uploadRequest;
    }

    public static String uploadAlog(List<String> list, String str) {
        NpthLog.m234i("npth", "upload alog " + str + ": " + list);
        try {
            UploadRequest buildUploadRequest = buildUploadRequest(list, str);
            String checkParamsForUploadRequest = checkParamsForUploadRequest(buildUploadRequest);
            return !checkParamsForUploadRequest.equals("normal") ? checkParamsForUploadRequest : CrashUploadManager.getInstance().uploadAlogFile(buildUploadRequest.getAid(), buildUploadRequest.getDid(), buildUploadRequest.getProcessName(), buildUploadRequest.getAlogFiles()) ? "normal" : "unknown";
        } catch (Throwable th) {
            Ensure.getInstance().ensureNotReachHereForce(Constants.NPTH_CATCH, th);
            return "unknown";
        }
    }

    private static String checkParamsForUploadRequest(UploadRequest uploadRequest) {
        return TextUtils.isEmpty(uploadRequest.getAid()) ? "no_aid" : TextUtils.isEmpty(uploadRequest.getDid()) ? "no_did" : TextUtils.isEmpty(uploadRequest.getProcessName()) ? ERR_NO_PROCESS : (uploadRequest.getAlogFiles() == null || uploadRequest.getAlogFiles().size() == 0) ? ERR_NO_ALOG_FILES : "normal";
    }

    public List<String> collectAlog(long j, String str) {
        return AlogManager.collectAlog(j, str);
    }

    public List<String> collectAlog(String str, long j, String str2, IAlogUploadStrategy iAlogUploadStrategy) {
        if (TextUtils.isEmpty(str) || !new File(str).exists() || iAlogUploadStrategy == null) {
            return null;
        }
        return iAlogUploadStrategy.getUploadAlogFiles(str, j);
    }
}
