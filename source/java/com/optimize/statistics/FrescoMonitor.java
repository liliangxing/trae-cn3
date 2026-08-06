package com.optimize.statistics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.optimize.statistics.ExceedTheLimitBitmapMonitor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FrescoMonitor {
    private static Context sContext;
    private static volatile IMonitorHook sMonitorHook;
    private static List<ImageTraceListener> sTraceListeners = new ArrayList();
    private static List<ImageExceedLimitTraceListener> sExceedTheLimitTraceListeners = new ArrayList();
    private static List<ImageSensibleTraceListener> sSensibleTraceListeners = new ArrayList();
    private static List<ImageWasteShowListener> sWasteShowListeners = new ArrayList();
    static final List<IMonitorHookV2> sMonitorHookV2s = new ArrayList();
    static final CopyOnWriteArrayList<IMonitorHookV2> sNewMonitorHookV2s = new CopyOnWriteArrayList<>();
    private static boolean sReportHitCacheEnabled = false;
    private static boolean sReportImageMonitorDataEnabled = false;
    private static boolean sEnableMonitorLog = true;
    private static boolean sEnableAllSourceUriReport = false;

    public static Context getContext() {
        return sContext;
    }

    public static void setContext(Context context) {
        sContext = context;
    }

    @Deprecated
    public static void setImageTraceListener(ImageTraceListener imageTraceListener) {
        addImageTraceListener(imageTraceListener);
    }

    public static void addImageTraceListener(ImageTraceListener imageTraceListener) {
        sTraceListeners.add(imageTraceListener);
    }

    public static void addImageExceedTheLimitTraceListener(ImageExceedLimitTraceListener imageExceedLimitTraceListener) {
        sExceedTheLimitTraceListeners.add(imageExceedLimitTraceListener);
    }

    public static void addImageSensibleTraceListener(ImageSensibleTraceListener imageSensibleTraceListener) {
        sSensibleTraceListeners.add(imageSensibleTraceListener);
    }

    public static void addImageWasteShowListener(ImageWasteShowListener imageWasteShowListener) {
        sWasteShowListeners.add(imageWasteShowListener);
    }

    public static void setMonitorHook(IMonitorHook iMonitorHook) {
        sMonitorHook = iMonitorHook;
    }

    public static void addMonitorHookV2(IMonitorHookV2 iMonitorHookV2) {
        if (FrescoCacheMonitorUtil.isOptListenerAnr()) {
            sNewMonitorHookV2s.add(iMonitorHookV2);
            return;
        }
        List<IMonitorHookV2> list = sMonitorHookV2s;
        synchronized (list) {
            list.add(iMonitorHookV2);
        }
    }

    public static void removeMonitorHookV2(IMonitorHookV2 iMonitorHookV2) {
        if (FrescoCacheMonitorUtil.isOptListenerAnr()) {
            sNewMonitorHookV2s.remove(iMonitorHookV2);
            return;
        }
        List<IMonitorHookV2> list = sMonitorHookV2s;
        synchronized (list) {
            list.remove(iMonitorHookV2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IMonitorHook getMonitorHook() {
        return sMonitorHook;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void onImageLoaded(boolean z, String str, JSONObject jSONObject) {
        if (!z) {
            Context context = sContext;
            if (context != null && !isNetworkAvailable(context)) {
                return;
            }
            if (MonitorUtils.getLogTypeSwitch(FrescoMonitorConst.MONITOR_IMAGE_ERROR_V2)) {
                MonitorUtils.monitorCommonLog(FrescoMonitorConst.MONITOR_IMAGE_ERROR_V2, jSONObject);
            }
        }
        for (ImageTraceListener imageTraceListener : sTraceListeners) {
            if (imageTraceListener != null) {
                imageTraceListener.onImageLoaded(z, str, jSONObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void onExceedLimitCallback(JSONObject jSONObject) {
        for (ImageExceedLimitTraceListener imageExceedLimitTraceListener : sExceedTheLimitTraceListeners) {
            if (imageExceedLimitTraceListener != null) {
                imageExceedLimitTraceListener.onExceedLimitCallback(jSONObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void onSensibleCallback(JSONObject jSONObject) {
        for (ImageSensibleTraceListener imageSensibleTraceListener : sSensibleTraceListeners) {
            if (imageSensibleTraceListener != null) {
                imageSensibleTraceListener.onSensibleCallback(jSONObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void onImageShowCallback(boolean z, JSONObject jSONObject) {
        for (ImageWasteShowListener imageWasteShowListener : sWasteShowListeners) {
            if (imageWasteShowListener != null) {
                imageWasteShowListener.onImageShowCallback(z, jSONObject);
            }
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isAvailable();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void imageNetCallBack(long j, long j2, String str, HttpRequestInfo httpRequestInfo, Throwable th, JSONObject jSONObject) {
        for (ImageTraceListener imageTraceListener : sTraceListeners) {
            if (imageTraceListener != null) {
                imageTraceListener.imageNetCallBack(j, j2, str, httpRequestInfo, th, jSONObject);
            }
        }
    }

    public static void setReportHitCacheEnabled(boolean z) {
        sReportHitCacheEnabled = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isReportHitCacheEnabled() {
        return sReportHitCacheEnabled;
    }

    public static void setReportImageMonitorDataEnabled(boolean z) {
        sReportImageMonitorDataEnabled = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isReportImageMonitorDataEnabled() {
        return sReportImageMonitorDataEnabled;
    }

    public static boolean isEnableMonitorLog() {
        return sEnableMonitorLog;
    }

    public static void setEnableMonitorLog(boolean z) {
        sEnableMonitorLog = z;
    }

    public static void setExceedTheLimitBitmapMonitorLimit(long j, int i, long j2) {
        ExceedTheLimitBitmapMonitor.setBitmapMonitorLimit(j, i, j2);
    }

    public static void setExceedTheLimitBitmapMonitorEnabled(boolean z) {
        ExceedTheLimitBitmapMonitor.setExceedTheLimitBitmapMonitorEnabled(z);
    }

    public static void setCustomExceedLimit(ExceedTheLimitBitmapMonitor.CustomExceedLimit customExceedLimit) {
        ExceedTheLimitBitmapMonitor.setCustomExceedLimit(customExceedLimit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isNeedReportAllSourceUriType() {
        return sEnableAllSourceUriReport;
    }

    public static void setEnableAllSourceUriReport(boolean z) {
        sEnableAllSourceUriReport = z;
    }
}
