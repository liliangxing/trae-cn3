package com.bytedance.framwork.core.monitor;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.alog.DefaultAlogUploadStrategy;
import com.bytedance.apm.alog.IALogActiveUploadCallback;
import com.bytedance.apm.alog.IALogActiveUploadObserver;
import com.bytedance.apm.alog.IAlogUploadStrategy;
import com.bytedance.apm.alog.net.AlogUploadService;
import com.bytedance.apm.config.ApmStartConfig;
import com.bytedance.apm.core.IDynamicParams;
import com.bytedance.apm.entity.UploadRequest;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.FileUtils;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.ProcessUtils;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class MonitorCommon {
    private static final MonitorCommon sInstance = new MonitorCommon();
    private static volatile IAlogUploadStrategy sAlogUploadStrategy = new DefaultAlogUploadStrategy();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface IGetCommonParams {
        Map<String, String> getCommonParams();

        String getSessionId();

        long getUid();
    }

    @Deprecated
    public static void setDefaultReportUrlList(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        ApmDelegate.getInstance().setDefaultLogReportUrlsCompat(list);
    }

    @Deprecated
    public static void setConfigUrl(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        ApmDelegate.getInstance().setConfigUrlCompat(list);
    }

    @Deprecated
    public static void setExceptionUploadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ApmDelegate.getInstance().setExceptionLogReportUrlsCompat(Arrays.asList(str));
    }

    public static void setStopWhenInBackground(boolean z) {
        ApmContext.setStopWhenBackground(z);
    }

    @Deprecated
    public static MonitorCommon getInstance() {
        if (ApmDelegate.getInstance().isConfigReady()) {
            return sInstance;
        }
        return null;
    }

    @Deprecated
    public static boolean init(Context context, JSONObject jSONObject, final IGetCommonParams iGetCommonParams) {
        ApmDelegate.getInstance().start(ApmStartConfig.builder().params(jSONObject).dynamicParams(new IDynamicParams() { // from class: com.bytedance.framwork.core.monitor.MonitorCommon.1
            public Map<String, String> getCommonParams() {
                IGetCommonParams iGetCommonParams2 = IGetCommonParams.this;
                if (iGetCommonParams2 == null) {
                    return Collections.emptyMap();
                }
                return iGetCommonParams2.getCommonParams();
            }

            public String getSessionId() {
                IGetCommonParams iGetCommonParams2 = IGetCommonParams.this;
                return iGetCommonParams2 == null ? "" : iGetCommonParams2.getSessionId();
            }

            public long getUid() {
                IGetCommonParams iGetCommonParams2 = IGetCommonParams.this;
                if (iGetCommonParams2 == null) {
                    return 0L;
                }
                return iGetCommonParams2.getUid();
            }
        }).build());
        return true;
    }

    @Deprecated
    public static boolean Init(Context context, JSONObject jSONObject, IGetCommonParams iGetCommonParams) {
        return init(context, jSONObject, iGetCommonParams);
    }

    @Deprecated
    public static void activeUploadAlog(String str, long j, long j2, String str2, IALogActiveUploadObserver iALogActiveUploadObserver) {
        ApmAgent.activeUploadAlog(str, j, j2, str2, iALogActiveUploadObserver, (IALogActiveUploadCallback) null);
    }

    @Deprecated
    public static void activeUploadAlog(final String str, final long j, final long j2, final String str2, final com.bytedance.article.common.monitor.alog.IALogActiveUploadObserver iALogActiveUploadObserver) {
        AsyncEventManager.getInstance().submitTask(new Runnable() { // from class: com.bytedance.framwork.core.monitor.MonitorCommon.2
            @Override // java.lang.Runnable
            public void run() {
                MonitorCommon.tryUploadAlog(str, j, j2, str2, iALogActiveUploadObserver);
            }
        });
    }

    @Deprecated
    public boolean addHeaderInfo(String str, String str2) {
        return ApmContext.extendHeader(str, str2);
    }

    public static void tryUploadAlog(String str, long j, long j2, String str2, com.bytedance.article.common.monitor.alog.IALogActiveUploadObserver iALogActiveUploadObserver) {
        if (ApmContext.getContext() == null || TextUtils.isEmpty(str) || !new File(str).exists()) {
            return;
        }
        if (iALogActiveUploadObserver != null) {
            iALogActiveUploadObserver.flushAlogDataToFile();
        }
        activeUploadAlogInternal(str, j, j2, str2, null);
    }

    private static void activeUploadAlogInternal(String str, long j, long j2, String str2, IALogActiveUploadCallback iALogActiveUploadCallback) {
        boolean uploadAlogFiles;
        List uploadAlogFiles2 = sAlogUploadStrategy != null ? sAlogUploadStrategy.getUploadAlogFiles(ApmContext.getContext(), str, j, j2) : null;
        if (!ListUtils.isEmpty(uploadAlogFiles2)) {
            UploadRequest buildUploadRequest = buildUploadRequest(uploadAlogFiles2);
            if (!checkParamsForUploadRequest(buildUploadRequest)) {
                ApmAgent.monitorStatusRate("apm_event_stats_alog_fail", 5, (JSONObject) null);
                if (iALogActiveUploadCallback != null) {
                    iALogActiveUploadCallback.onCallback(false, (JSONObject) null);
                    return;
                }
                return;
            }
            String zipUploadFile = zipUploadFile(buildUploadRequest.getAlogFiles());
            if (TextUtils.isEmpty(zipUploadFile)) {
                uploadAlogFiles = AlogUploadService.uploadAlogFiles(buildUploadRequest.getAid(), buildUploadRequest.getDid(), buildUploadRequest.getProcessName(), buildUploadRequest.getAlogFiles(), str2, buildUploadRequest.getCommonParams());
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(zipUploadFile);
                uploadAlogFiles = AlogUploadService.uploadAlogFiles(buildUploadRequest.getAid(), buildUploadRequest.getDid(), buildUploadRequest.getProcessName(), arrayList, str2, buildUploadRequest.getCommonParams());
                new File(zipUploadFile).delete();
            }
            if (iALogActiveUploadCallback != null) {
                iALogActiveUploadCallback.onCallback(uploadAlogFiles, (JSONObject) null);
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("e_dir", str);
            jSONObject.put("e_start_time", j);
            jSONObject.put("e_end_time", j2);
            File file = new File(str);
            if (file.exists() && file.listFiles() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                for (File file2 : file.listFiles()) {
                    sb.append(file2.getName());
                    sb.append(",");
                }
                sb.append("]");
                jSONObject.put("e_file", sb.toString());
            } else {
                jSONObject.put("e_file", "null");
            }
        } catch (Exception unused) {
        }
        ApmAgent.monitorStatusRate("apm_event_stats_alog_fail", 4, jSONObject);
        if (iALogActiveUploadCallback != null) {
            try {
                iALogActiveUploadCallback.onCallback(false, (JSONObject) null);
            } catch (Exception unused2) {
            }
        }
    }

    private static String zipUploadFile(List<String> list) {
        File file = new File(list.get(0));
        File file2 = new File(file.getParent(), getZipFileName(file.getName()));
        if (file2.exists()) {
            file2.delete();
        }
        try {
            FileUtils.compress(file2.getAbsolutePath(), (String[]) list.toArray(new String[0]));
            return file2.getAbsolutePath();
        } catch (Exception unused) {
            return null;
        }
    }

    private static String getZipFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return str + ".zip";
        }
        return str.substring(0, lastIndexOf) + ".zip";
    }

    private static UploadRequest buildUploadRequest(List<String> list) {
        UploadRequest uploadRequest = new UploadRequest();
        JSONObject headerInner = ApmContext.getHeaderInner();
        if (headerInner != null) {
            uploadRequest.setAid(headerInner.optString(MonitorConstants.KEY_AID));
            uploadRequest.setDid(headerInner.optString("device_id"));
        }
        uploadRequest.setProcessName(ProcessUtils.getCurProcessName(ApmContext.getContext()).contains(":") ? ProcessUtils.getCurProcessName(ApmContext.getContext()) : "main");
        uploadRequest.setAlogFiles(list);
        uploadRequest.setCommonParams(headerInner);
        return uploadRequest;
    }

    private static boolean checkParamsForUploadRequest(UploadRequest uploadRequest) {
        return (TextUtils.isEmpty(uploadRequest.getAid()) || TextUtils.isEmpty(uploadRequest.getDid()) || TextUtils.isEmpty(uploadRequest.getProcessName()) || uploadRequest.getAlogFiles() == null || uploadRequest.getAlogFiles().size() == 0) ? false : true;
    }
}
