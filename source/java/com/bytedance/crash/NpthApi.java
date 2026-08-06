package com.bytedance.crash;

import java.io.File;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NpthApi {
    private static IANRInfoCallback sCallback;
    private static NpthApi sImpl;
    private static RetraceDataCallback sRetraceDataCallback;

    /* loaded from: classes3.dex */
    public interface CustomDataCallback {
        Map<String, String> getData();
    }

    /* loaded from: classes3.dex */
    public interface IANRInfoCallback {
        File getFile();
    }

    /* loaded from: classes3.dex */
    public interface RetraceDataCallback {
        JSONObject getData();
    }

    protected void addANRInfoCallbackInner(IANRInfoCallback iANRInfoCallback) {
    }

    protected void addCustomInner(CustomDataCallback customDataCallback) {
    }

    protected void addCustomInner(CustomDataCallback customDataCallback, String str) {
    }

    protected void addTagsInner(Map<String, String> map) {
    }

    protected void checkInnerSo(String str) {
    }

    protected void checkInnerSo(String str, String str2) {
    }

    protected String getByTraceIDInner() {
        return "";
    }

    protected void registerSDK(String str, String str2) {
    }

    protected void startMonitorInner() {
    }

    protected void uploadKilledHistoryInner() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NpthApi() {
        sImpl = this;
        IANRInfoCallback iANRInfoCallback = sCallback;
        if (iANRInfoCallback != null) {
            addANRInfoCallbackInner(iANRInfoCallback);
        }
    }

    public static void startMonitor() {
        NpthApi npthApi = sImpl;
        if (npthApi != null) {
            npthApi.startMonitorInner();
        }
    }

    public static void addTags(Map<String, String> map) {
        NpthApi npthApi = sImpl;
        if (npthApi != null) {
            npthApi.addTagsInner(map);
        }
    }

    public static void addCustomData(CustomDataCallback customDataCallback) {
        NpthApi npthApi = sImpl;
        if (npthApi != null) {
            npthApi.addCustomInner(customDataCallback);
        }
    }

    public static void addCustomData(CustomDataCallback customDataCallback, String str) {
        NpthApi npthApi = sImpl;
        if (npthApi == null || customDataCallback == null) {
            return;
        }
        npthApi.addCustomInner(customDataCallback, str);
    }

    public static void addANRInfoCallback(IANRInfoCallback iANRInfoCallback) {
        NpthApi npthApi = sImpl;
        if (npthApi != null) {
            npthApi.addANRInfoCallbackInner(iANRInfoCallback);
        } else {
            sCallback = iANRInfoCallback;
        }
    }

    public static void uploadKilledHistory() {
        NpthApi npthApi = sImpl;
        if (npthApi != null) {
            npthApi.uploadKilledHistoryInner();
        }
    }

    public static void setRetraceData(RetraceDataCallback retraceDataCallback) {
        sRetraceDataCallback = retraceDataCallback;
    }

    public static JSONObject getRetraceParams() {
        RetraceDataCallback retraceDataCallback = sRetraceDataCallback;
        if (retraceDataCallback == null) {
            return null;
        }
        return retraceDataCallback.getData();
    }

    public static String getByTraceID() {
        NpthApi npthApi = sImpl;
        return npthApi == null ? "" : npthApi.getByTraceIDInner();
    }

    public static void checkInnerSoFile(String str) {
        NpthApi npthApi = sImpl;
        if (npthApi == null) {
            return;
        }
        npthApi.checkInnerSo(str);
    }

    public static void checkInnerSoFile(String str, String str2) {
        NpthApi npthApi = sImpl;
        if (npthApi == null) {
            return;
        }
        npthApi.checkInnerSo(str, str2);
    }

    public static void registerSDKVersion(String str, String str2) {
        NpthApi npthApi = sImpl;
        if (npthApi == null) {
            return;
        }
        npthApi.registerSDK(str, str2);
    }
}
