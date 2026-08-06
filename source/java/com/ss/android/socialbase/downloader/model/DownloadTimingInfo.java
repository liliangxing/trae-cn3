package com.ss.android.socialbase.downloader.model;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class DownloadTimingInfo {
    public long afterOnPrepareTime;
    public long afterOnStartTime;
    public long beforeOnEndCallbackTime;
    public long beforeOnPrepareTime;
    public long beforeOnStartTime;
    public long beforeThreadExecuteTime;
    public long buildDownloadInfoTime;
    public long callDownloadTime;
    public long doDownloadTime;
    public long endDownloadTime;
    public long threadExecuteTime;
    public long tryDownloadTime;

    public JSONObject obtainDurationStats() {
        JSONObject jSONObject = new JSONObject();
        try {
            long j = this.callDownloadTime;
            jSONObject.put(MonitorConstants.BUILD_DOWNLOAD_INFO, j > 0 ? this.buildDownloadInfoTime - j : 0L);
            long j2 = this.buildDownloadInfoTime;
            jSONObject.put(MonitorConstants.TRY_DOWNLOAD, j2 > 0 ? this.tryDownloadTime - j2 : 0L);
            jSONObject.put(MonitorConstants.DO_DOWNLOAD, this.doDownloadTime - this.tryDownloadTime);
            jSONObject.put(MonitorConstants.BEFORE_THREAD_EXECUTE, this.beforeThreadExecuteTime - this.doDownloadTime);
            jSONObject.put(MonitorConstants.THREAD_EXECUTE, this.threadExecuteTime - this.beforeThreadExecuteTime);
            jSONObject.put(MonitorConstants.BEFORE_ON_PREPARE, this.beforeOnPrepareTime - this.threadExecuteTime);
            jSONObject.put(MonitorConstants.AFTER_ON_PREPARE, this.afterOnPrepareTime - this.beforeOnPrepareTime);
            jSONObject.put(MonitorConstants.BEFORE_ON_START, this.beforeOnStartTime - this.afterOnPrepareTime);
            jSONObject.put(MonitorConstants.AFTER_ON_START, this.afterOnStartTime - this.beforeOnStartTime);
            jSONObject.put(MonitorConstants.BEFORE_ON_FINISH, this.beforeOnEndCallbackTime - this.afterOnStartTime);
            jSONObject.put(MonitorConstants.AFTER_ON_FINISH, this.endDownloadTime - this.beforeOnEndCallbackTime);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public JSONObject obtainOriginStats() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MonitorConstants.CALL_DOWNLOAD, this.callDownloadTime);
            jSONObject.put(MonitorConstants.BUILD_DOWNLOAD_INFO, this.buildDownloadInfoTime);
            jSONObject.put(MonitorConstants.TRY_DOWNLOAD, this.tryDownloadTime);
            jSONObject.put(MonitorConstants.DO_DOWNLOAD, this.doDownloadTime);
            jSONObject.put(MonitorConstants.BEFORE_THREAD_EXECUTE, this.beforeThreadExecuteTime);
            jSONObject.put(MonitorConstants.THREAD_EXECUTE, this.threadExecuteTime);
            jSONObject.put(MonitorConstants.BEFORE_ON_PREPARE, this.beforeOnPrepareTime);
            jSONObject.put(MonitorConstants.AFTER_ON_PREPARE, this.afterOnPrepareTime);
            jSONObject.put(MonitorConstants.BEFORE_ON_START, this.beforeOnStartTime);
            jSONObject.put(MonitorConstants.AFTER_ON_START, this.afterOnStartTime);
            jSONObject.put(MonitorConstants.BEFORE_ON_FINISH, this.beforeOnEndCallbackTime);
            jSONObject.put(MonitorConstants.AFTER_ON_FINISH, System.currentTimeMillis());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public DownloadTimingInfo copy() {
        DownloadTimingInfo downloadTimingInfo = new DownloadTimingInfo();
        downloadTimingInfo.callDownloadTime = this.callDownloadTime;
        downloadTimingInfo.buildDownloadInfoTime = this.buildDownloadInfoTime;
        downloadTimingInfo.tryDownloadTime = this.tryDownloadTime;
        downloadTimingInfo.doDownloadTime = this.doDownloadTime;
        downloadTimingInfo.beforeThreadExecuteTime = this.beforeThreadExecuteTime;
        downloadTimingInfo.threadExecuteTime = this.threadExecuteTime;
        downloadTimingInfo.beforeOnPrepareTime = this.beforeOnPrepareTime;
        downloadTimingInfo.afterOnPrepareTime = this.afterOnPrepareTime;
        downloadTimingInfo.beforeOnStartTime = this.beforeOnStartTime;
        downloadTimingInfo.afterOnStartTime = this.afterOnStartTime;
        downloadTimingInfo.beforeOnEndCallbackTime = this.beforeOnEndCallbackTime;
        downloadTimingInfo.endDownloadTime = System.currentTimeMillis();
        return downloadTimingInfo;
    }

    public void reset() {
        this.callDownloadTime = 0L;
        this.buildDownloadInfoTime = 0L;
        this.tryDownloadTime = 0L;
        this.doDownloadTime = 0L;
        this.beforeThreadExecuteTime = 0L;
        this.threadExecuteTime = 0L;
        this.beforeOnPrepareTime = 0L;
        this.afterOnPrepareTime = 0L;
        this.beforeOnStartTime = 0L;
        this.afterOnStartTime = 0L;
        this.beforeOnEndCallbackTime = 0L;
    }
}
