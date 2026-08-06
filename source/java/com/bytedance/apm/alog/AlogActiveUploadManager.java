package com.bytedance.apm.alog;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.MonitorCoreExceptionManager;
import com.bytedance.apm.alog.net.AlogUploadService;
import com.bytedance.apm.constant.CommonConsts;
import com.bytedance.apm.entity.UploadRequest;
import com.bytedance.apm.util.FileUtils;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.ProcessUtils;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.ies.argus.bean.ArgusConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AlogActiveUploadManager {
    private static volatile IAlogUploadStrategy sAlogUploadStrategy;

    public static void init(Context context, IAlogUploadStrategy iAlogUploadStrategy) {
        if (sAlogUploadStrategy == null) {
            sAlogUploadStrategy = iAlogUploadStrategy;
        }
    }

    @Deprecated
    public static void activeUploadAlog(String str, long j, long j2, String str2, IALogActiveUploadObserver iALogActiveUploadObserver) {
        ApmAgent.activeUploadAlog(str, j, j2, str2, iALogActiveUploadObserver);
    }

    public static void tryUploadAlog(String str, long j, long j2, String str2, IALogActiveUploadObserver iALogActiveUploadObserver, IALogActiveUploadCallback iALogActiveUploadCallback) {
        String str3;
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        ApmAgent.monitorStatusRate("apm_event_stats_alog", 0, null);
        String str4 = str;
        AlogMonitor.log("begin upload alog:" + str + " startTime:" + j + " endTime:" + j2 + " scene:" + str2);
        boolean z = true;
        if (ApmContext.getContext() == null) {
            str3 = "apm context is null";
            i = 0;
        } else {
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(ApmContext.getAlogFilesDir())) {
                    str3 = "alog file dir is null";
                    i = 1;
                } else {
                    str4 = ApmContext.getAlogFilesDir();
                }
            }
            if (new File(str4).exists()) {
                if (iALogActiveUploadObserver != null) {
                    iALogActiveUploadObserver.flushAlogDataToFile();
                    AlogMonitor.log("flush alog data to file");
                } else {
                    ApmAgent.monitorStatusRate("apm_event_stats_alog_fail", 3, null);
                }
                activeUploadAlogInternal(str4, j, j2, str2, iALogActiveUploadCallback);
                str3 = "";
                i = -1;
                z = false;
            } else {
                str3 = "alog file dir do not exist";
                i = 2;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("info", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject result = AlogMonitor.getResult(!z, i, null, jSONObject);
        if (z && iALogActiveUploadCallback != null) {
            iALogActiveUploadCallback.onCallback(false, result);
        }
        if (z) {
            ApmAgent.monitorStatusRate("apm_event_stats_alog_fail", i, result);
        }
        AlogMonitor.log("upload end. ".concat(str3));
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(OaidModel.KEY_TIME, System.currentTimeMillis() - currentTimeMillis);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        ApmAgent.monitorEvent(CommonConsts.MONITOR_EVENT_STATS_ALOG_UPLOAD_TIME, null, jSONObject2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void activeUploadAlogInternal(String str, long j, long j2, String str2, final IALogActiveUploadCallback iALogActiveUploadCallback) {
        boolean z;
        boolean z2;
        if (sAlogUploadStrategy != null) {
            AlogMonitor.log("begin get alog file");
            List<String> uploadAlogFiles = sAlogUploadStrategy.getUploadAlogFiles(ApmContext.getContext(), str, j, j2);
            AlogMonitor.log("end get alog file:" + str);
            boolean isEmpty = ListUtils.isEmpty(uploadAlogFiles);
            Object obj = ArgusConstants.NULL_PLACE_HOLDER;
            if (!isEmpty) {
                UploadRequest buildUploadRequest = buildUploadRequest(uploadAlogFiles);
                if (!checkParamsForUploadRequest(buildUploadRequest)) {
                    ApmAgent.monitorStatusRate("apm_event_stats_alog_fail", 5, null);
                    if (iALogActiveUploadCallback != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("aid", buildUploadRequest.getAid());
                            jSONObject2.put("did", buildUploadRequest.getDid());
                            jSONObject2.put("processName", buildUploadRequest.getProcessName());
                            if (buildUploadRequest.getAlogFiles() != null) {
                                obj = Integer.valueOf(buildUploadRequest.getAlogFiles().size());
                            }
                            jSONObject2.put("alogSize", obj);
                            jSONObject.put("info", jSONObject2.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        iALogActiveUploadCallback.onCallback(false, AlogMonitor.getResult(false, 5, null, jSONObject));
                    }
                    AlogMonitor.log("upload param missed");
                    return;
                }
                AlogMonitor.log("alog file begin zip");
                String zipUploadFile = zipUploadFile(buildUploadRequest.getAlogFiles());
                AlogMonitor.log("alog file end zip");
                final int[] iArr = {0};
                AlogUploadService.AlogCallBack alogCallBack = new AlogUploadService.AlogCallBack() { // from class: com.bytedance.apm.alog.AlogActiveUploadManager.1
                    @Override // com.bytedance.apm.alog.net.AlogUploadService.AlogCallBack
                    public void onSuccess(boolean z3, int i, Exception exc, JSONObject jSONObject3) {
                        JSONObject result = AlogMonitor.getResult(z3, i, exc, jSONObject3);
                        AlogMonitor.log(result.toString());
                        int[] iArr2 = iArr;
                        int i2 = iArr2[0] + 1;
                        iArr2[0] = i2;
                        if (z3 || i2 >= 2) {
                            IALogActiveUploadCallback iALogActiveUploadCallback2 = iALogActiveUploadCallback;
                            if (iALogActiveUploadCallback2 != null) {
                                iALogActiveUploadCallback2.onCallback(z3, result);
                            }
                            if (!z3) {
                                ApmAgent.monitorStatusRate("apm_event_stats_alog_fail", i, result);
                            }
                            if (exc != null) {
                                MonitorCoreExceptionManager.getInstance().ensureNotReachHere(exc, "apm_event_stats_alog_fail");
                            }
                        }
                    }
                };
                if (TextUtils.isEmpty(zipUploadFile)) {
                    AlogMonitor.log("alog file upload origin file begin");
                    z2 = AlogUploadService.uploadAlogFiles(buildUploadRequest.getAid(), buildUploadRequest.getDid(), buildUploadRequest.getProcessName(), buildUploadRequest.getAlogFiles(), str2, buildUploadRequest.getCommonParams(), alogCallBack);
                    if (!z2) {
                        z2 = AlogUploadService.uploadAlogFiles(buildUploadRequest.getAid(), buildUploadRequest.getDid(), buildUploadRequest.getProcessName(), buildUploadRequest.getAlogFiles(), str2, buildUploadRequest.getCommonParams(), alogCallBack);
                    }
                    AlogMonitor.log("alog file upload origin file end. success :" + z2);
                } else {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(zipUploadFile);
                        AlogMonitor.log("alog file upload zip file begin");
                        z = AlogUploadService.uploadAlogFiles(buildUploadRequest.getAid(), buildUploadRequest.getDid(), buildUploadRequest.getProcessName(), arrayList, str2, buildUploadRequest.getCommonParams(), alogCallBack);
                        if (!z) {
                            try {
                                z = AlogUploadService.uploadAlogFiles(buildUploadRequest.getAid(), buildUploadRequest.getDid(), buildUploadRequest.getProcessName(), arrayList, str2, buildUploadRequest.getCommonParams(), alogCallBack);
                            } catch (Throwable th) {
                                th = th;
                                if (ApmContext.isDebugMode()) {
                                    th.printStackTrace();
                                }
                                AlogMonitor.log("alog file upload zip file end. success:" + z + " zip file:" + zipUploadFile);
                                new File(zipUploadFile).delete();
                                z2 = z;
                                if (z2) {
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z = false;
                    }
                    AlogMonitor.log("alog file upload zip file end. success:" + z + " zip file:" + zipUploadFile);
                    new File(zipUploadFile).delete();
                    z2 = z;
                }
                if (z2) {
                    return;
                }
                ApmAgent.monitorStatusRate(CommonConsts.MONITOR_EVENT_STATS_ALOG_UPLOAD_SUCCESS, 0, null);
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("info", "alog upload file failed,local file is null");
                jSONObject3.put("e_dir", str);
                jSONObject3.put("e_start_time", j);
                jSONObject3.put("e_end_time", j2);
                File file = new File(str);
                if (file.exists() && file.listFiles() != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[");
                    for (File file2 : file.listFiles()) {
                        sb.append(file2.getName());
                        sb.append(",");
                    }
                    sb.append("]");
                    jSONObject3.put("e_file", sb.toString());
                } else {
                    jSONObject3.put("e_file", ArgusConstants.NULL_PLACE_HOLDER);
                }
            } catch (Exception unused) {
            }
            JSONObject result = AlogMonitor.getResult(false, 4, null, jSONObject3);
            ApmAgent.monitorStatusRate("apm_event_stats_alog_fail", 4, result);
            if (iALogActiveUploadCallback != null) {
                try {
                    iALogActiveUploadCallback.onCallback(false, result);
                } catch (Exception unused2) {
                    return;
                }
            }
            AlogMonitor.log("alog upload file failed,local file is null");
            return;
        }
        ApmAgent.monitorStatusRate("apm_event_stats_alog_fail", 12, AlogMonitor.getResult(false, 12, null, null));
    }

    public static void uploadAlogFiles(List<String> list, String str, IALogActiveUploadCallback iALogActiveUploadCallback) {
        boolean uploadAlogFiles;
        if (list == null || list.isEmpty()) {
            return;
        }
        UploadRequest buildUploadRequest = buildUploadRequest(list);
        if (!checkParamsForUploadRequest(buildUploadRequest)) {
            ApmAgent.monitorStatusRate("apm_event_stats_alog_fail", 5, null);
            if (iALogActiveUploadCallback != null) {
                iALogActiveUploadCallback.onCallback(false, null);
                return;
            }
            return;
        }
        String zipUploadFile = zipUploadFile(buildUploadRequest.getAlogFiles());
        if (TextUtils.isEmpty(zipUploadFile)) {
            uploadAlogFiles = AlogUploadService.uploadAlogFiles(buildUploadRequest.getAid(), buildUploadRequest.getDid(), buildUploadRequest.getProcessName(), buildUploadRequest.getAlogFiles(), str, buildUploadRequest.getCommonParams());
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(zipUploadFile);
            uploadAlogFiles = AlogUploadService.uploadAlogFiles(buildUploadRequest.getAid(), buildUploadRequest.getDid(), buildUploadRequest.getProcessName(), arrayList, str, buildUploadRequest.getCommonParams());
            new File(zipUploadFile).delete();
        }
        if (iALogActiveUploadCallback != null) {
            iALogActiveUploadCallback.onCallback(uploadAlogFiles, null);
        }
    }

    private static String zipUploadFile(List<String> list) {
        File file = new File(list.get(0));
        File file2 = new File(file.getParent(), getZipFileName(file.getName()));
        if (file2.exists()) {
            file2.delete();
        }
        try {
            try {
                FileUtils.compress(file2.getAbsolutePath(), (String[]) list.toArray(new String[0]));
                return file2.getAbsolutePath();
            } catch (Exception unused) {
                if (!file2.exists()) {
                    return null;
                }
                file2.delete();
                return null;
            }
        } catch (Exception unused2) {
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
            uploadRequest.setAid(headerInner.optString("aid"));
            uploadRequest.setDid(headerInner.optString("device_id"));
        }
        uploadRequest.setProcessName(ProcessUtils.getCurProcessName(ApmContext.getContext()).contains(":") ? ProcessUtils.getCurProcessName(ApmContext.getContext()) : PullConfiguration.PROCESS_NAME_MAIN);
        uploadRequest.setAlogFiles(list);
        uploadRequest.setCommonParams(headerInner);
        return uploadRequest;
    }

    private static boolean checkParamsForUploadRequest(UploadRequest uploadRequest) {
        return (TextUtils.isEmpty(uploadRequest.getAid()) || TextUtils.isEmpty(uploadRequest.getDid()) || TextUtils.isEmpty(uploadRequest.getProcessName()) || uploadRequest.getAlogFiles() == null || uploadRequest.getAlogFiles().size() == 0) ? false : true;
    }
}
