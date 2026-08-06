package com.bytedance.reparo.secondary;

import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.bytedance.notification.Constants;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.reparo.core.PatchEventReporter;
import com.bytedance.reparo.core.ReparoPatch;
import com.bytedance.reparo.core.common.event.Event;
import com.bytedance.reparo.core.exception.JavaLoadException;
import com.bytedance.reparo.core.exception.PatchDownloadException;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.reparo.core.exception.PatchInstallException;
import com.bytedance.reparo.core.exception.PatchLoadException;
import com.bytedance.reparo.core.exception.SoLoadException;
import com.bytedance.reparo.core.parse.PatchRecordInfo;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AppMonitorService {
    private static final String LOG_TYPE = "bd_better_monitor";
    private static final String TAG = "AppMonitorService";
    private static long sLastReportListTime = -1;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Code {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static class Download {
            static final int DOWNLOAD_MD5_NOT_MATCH = 12001;
            static final int DOWNLOAD_START = 10000;
            static final int DOWNLOAD_SUCCESS = 11000;
            static final int DOWNLOAD_TIMEOUT = 12006;
            static final int DOWNLOAD_UNKNOWN_ERROR = 12000;

            Download() {
            }

            static int parseErrorCode(Throwable th) {
                if (th != null && (th instanceof PatchDownloadException)) {
                    if (((PatchDownloadException) th).getErrorCode() == 1) {
                        return DOWNLOAD_MD5_NOT_MATCH;
                    }
                    if (th.getCause() instanceof SocketTimeoutException) {
                        return DOWNLOAD_TIMEOUT;
                    }
                }
                return DOWNLOAD_UNKNOWN_ERROR;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static class Install {
            static final int SIGNATURE_VERIFY_FAILED = 12007;

            Install() {
            }

            public static int parseErrorCode(PatchException patchException) {
                if (patchException != null && (patchException instanceof PatchInstallException) && patchException.getErrorCode() == 1) {
                    return SIGNATURE_VERIFY_FAILED;
                }
                return 12000;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static class Load {
            static final int LOAD_JAVA_FAILED = 22008;
            static final int LOAD_SO_FAILED = 22010;
            static final int LOAD_START = 20000;
            static final int LOAD_SUCCESS = 21000;
            static final int LOAD_UNKNOWN_ERROR = 22000;
            static final int SO_MD5_VERIFY_FAILED = 22009;

            Load() {
            }

            static int parseErrorCode(PatchException patchException) {
                if (patchException != null && (patchException instanceof PatchLoadException)) {
                    if (patchException instanceof JavaLoadException) {
                        return LOAD_JAVA_FAILED;
                    }
                    if (patchException instanceof SoLoadException) {
                        return patchException.getErrorCode() == 300 ? SO_MD5_VERIFY_FAILED : LOAD_SO_FAILED;
                    }
                }
                return LOAD_UNKNOWN_ERROR;
            }
        }
    }

    private static SDKMonitor getMonitor() {
        return MonitorService.getMonitor();
    }

    public static void reportLocalPatchList() {
        reportLocalPatchList(false, -1);
    }

    private static void reportLocalPatchList(boolean z, int i) {
        try {
            reportLocalPatchListImpl(z, i);
        } catch (Throwable th) {
            Logger.m327e(TAG, "report local patch list failed. ", th);
        }
    }

    private static void reportLocalPatchListImpl(boolean z, int i) throws JSONException {
        if (ReparoPatch.getInstance().hasInit()) {
            JSONArray jSONArray = new JSONArray();
            for (PatchRecordInfo patchRecordInfo : ReparoPatch.getInstance().queryLocalPatches().keySet()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("better_name", patchRecordInfo.getPatchId());
                jSONObject.putOpt("version_code", patchRecordInfo.getPatchVersion());
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            long currentTimeMillis = System.currentTimeMillis();
            jSONObject2.putOpt(ReportConst.KEY_TIMESTAMP, Long.valueOf(currentTimeMillis));
            jSONObject2.putOpt("betters", jSONArray);
            if (z) {
                if (sLastReportListTime == -1) {
                    sLastReportListTime = currentTimeMillis;
                }
                jSONObject2.putOpt("last_report_list_time", Long.valueOf(sLastReportListTime));
                sLastReportListTime = currentTimeMillis;
            }
            if (i != -1) {
                jSONObject2.putOpt("status", Integer.valueOf(i));
            }
            getMonitor().monitorCommonLog(LOG_TYPE, jSONObject2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void report(Event event) {
        String step = event.getStep();
        step.hashCode();
        char c = 65535;
        switch (step.hashCode()) {
            case -638342497:
                if (step.equals("patch_download")) {
                    c = 0;
                    break;
                }
                break;
            case 1275480701:
                if (step.equals(PatchEventReporter.STEP_LOAD)) {
                    c = 1;
                    break;
                }
                break;
            case 1890919588:
                if (step.equals(PatchEventReporter.STEP_PATCH_INSTALL)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                reportDownloadEvent(event);
                return;
            case 1:
                reportLoadEvent(event);
                return;
            case 2:
                reportInstallEvent(event);
                return;
            default:
                return;
        }
    }

    private static void reportDownloadEvent(Event event) {
        if (event.isSuccess()) {
            reportLocalPatchList(true, 11000);
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap<String, Object> categoryMap = event.getCategoryMap();
            jSONObject.putOpt(ReportConst.KEY_TIMESTAMP, Long.valueOf(currentTimeMillis));
            jSONObject.putOpt("better_name", categoryMap.get("patch_id"));
            jSONObject.putOpt("version_code", categoryMap.get("patch_version"));
            if (event.isSuccess()) {
                jSONObject.putOpt("status", 11000);
                long duration = event.getDuration();
                if (duration != -1) {
                    jSONObject.putOpt(LynxTimingPerformanceReportProcessor.KEY_DURATION, Long.valueOf(duration));
                }
            } else {
                jSONObject.putOpt("status", Integer.valueOf(Code.Download.parseErrorCode(event.getException())));
                jSONObject.putOpt(Constants.EVENT_PARAMS_KEY_ERROR_MSG, event.getErrorMsg());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        getMonitor().monitorCommonLog(LOG_TYPE, jSONObject);
    }

    private static void reportInstallEvent(Event event) {
        if (event.isSuccess()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap<String, Object> categoryMap = event.getCategoryMap();
            event.getMetricsMap();
            event.getExtraMap();
            jSONObject.putOpt(ReportConst.KEY_TIMESTAMP, Long.valueOf(currentTimeMillis));
            jSONObject.putOpt("better_name", categoryMap.get("patch_id"));
            jSONObject.putOpt("version_code", categoryMap.get("patch_version"));
            jSONObject.putOpt("status", Integer.valueOf(Code.Install.parseErrorCode(event.getException())));
            jSONObject.putOpt(Constants.EVENT_PARAMS_KEY_ERROR_MSG, event.getErrorMsg());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        getMonitor().monitorCommonLog(LOG_TYPE, jSONObject);
    }

    private static void reportLoadEvent(Event event) {
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap<String, Object> categoryMap = event.getCategoryMap();
            jSONObject.putOpt(ReportConst.KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
            jSONObject.putOpt("better_name", categoryMap.get("patch_id"));
            jSONObject.putOpt("version_code", categoryMap.get("patch_version"));
            if (event.isSuccess()) {
                jSONObject.putOpt("status", 21000);
                long duration = event.getDuration();
                if (duration != -1) {
                    jSONObject.putOpt(LynxTimingPerformanceReportProcessor.KEY_DURATION, Long.valueOf(duration));
                }
            } else {
                jSONObject.putOpt("status", Integer.valueOf(Code.Load.parseErrorCode(event.getException())));
                jSONObject.putOpt(Constants.EVENT_PARAMS_KEY_ERROR_MSG, event.getErrorMsg());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        getMonitor().monitorCommonLog(LOG_TYPE, jSONObject);
    }
}
