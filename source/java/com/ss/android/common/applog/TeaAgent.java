package com.ss.android.common.applog;

import android.accounts.Account;
import android.content.Context;
import com.ss.android.common.applog.AppLog;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TeaAgent {
    public static final String EVENT_V1_CATEGORY = "event_v1";
    private static final String TAG = "TeaAgent";

    public static void init(TeaConfig teaConfig) {
        TeaAgentHelper.init(teaConfig);
    }

    public static void tryWaitDeviceInit() {
        AppLog.tryWaitDeviceInit();
    }

    public static void clearDidAndIid(Context context, String str) {
        AppLog.clearDidAndIid(context, str);
    }

    public static void activeUser(Context context) {
        AppLog.activeUser(context);
    }

    public static void onQuit() {
        AppLog.onQuit();
    }

    public static void onAppQuit() {
        AppLog.onAppQuit();
    }

    public static void onActivityCreate(Context context) {
        AppLog.onActivityCreate(context);
    }

    public static void onActivityCreate(String str) {
        AppLog.onActivityCreate(str);
    }

    public static void onTaskResume(Context context) {
        AppLog.onTaskResume(context);
    }

    public static void onTaskPause(Context context) {
        AppLog.onTaskPause(context);
    }

    public static void onResume(Context context) {
        AppLog.onResume(context);
    }

    public static void onResume(Context context, String str, int i) {
        AppLog.onResume(context, str, i);
    }

    public static void onPause(Context context) {
        AppLog.onPause(context);
    }

    public static void onPause(Context context, String str, int i) {
        AppLog.onPause(context, str, i);
    }

    public static void onEvent(Context context, String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        onEvent(context, str, str2, str3, j, j2, false, jSONObject);
    }

    public static void onEvent(Context context, String str, String str2, String str3, long j, long j2, boolean z) {
        onEvent(context, str, str2, str3, j, j2, z, null);
    }

    public static void onEvent(Context context, String str, String str2, String str3, long j, long j2) {
        onEvent(context, str, str2, str3, j, j2, false, null);
    }

    public static void onEvent(Context context, String str, String str2) {
        onEvent(context, "event_v1", str, str2, 0L, 0L, false, null);
    }

    public static void onEvent(Context context, String str) {
        onEvent(context, "event_v1", str, null, 0L, 0L, false, null);
    }

    public static void onEvent(Context context, String str, String str2, String str3, long j, long j2, boolean z, JSONObject jSONObject) {
        AppLog.onEvent(context, str, str2, str3, j, j2, z, jSONObject);
    }

    public static void recordMiscLog(Context context, String str, JSONObject jSONObject) {
        AppLog.recordMiscLog(context, str, jSONObject);
    }

    public static void setDefaultUserAgent(String str) {
        AppLog.setDefaultUserAgent(str);
    }

    public static void setConfigUpdateListener(AppLog.ConfigUpdateListenerEnhanced configUpdateListenerEnhanced) {
        AppLog.setConfigUpdateListener(configUpdateListenerEnhanced);
    }

    public static void setSessionHook(AppLog.ILogSessionHook iLogSessionHook) {
        AppLog.setSessionHook(iLogSessionHook);
    }

    @Deprecated
    public static void addSessionHook(AppLog.ILogSessionHook iLogSessionHook) {
        AppLog.addSessionHook(iLogSessionHook);
    }

    public static void removeSessionHook(AppLog.ILogSessionHook iLogSessionHook) {
        AppLog.removeSessionHook(iLogSessionHook);
    }

    public static void setAccount(Context context, Account account) {
        AppLog.setAccount(context, account);
    }

    public static String getServerDeviceId() {
        return AppLog.getServerDeviceId();
    }

    public static String getClientUDID() {
        return AppLog.getClientId();
    }

    public static String getInstallId() {
        return AppLog.getInstallId();
    }

    public static void getSSIDs(Map<String, String> map) {
        AppLog.getSSIDs(map);
    }

    public static JSONObject getHeaderCopy() {
        return AppLog.getHeaderCopy();
    }

    public static String getSigHash(Context context) {
        return AppLog.getSigHash(context);
    }

    public static void setAbSDKVersion(String str) {
        AppLog.setAbSDKVersion(str);
    }

    public static String getAbSDKVersion() {
        return AppLog.getAbSDKVersion();
    }

    public static void registerGlobalEventCallback(GlobalEventCallback globalEventCallback) {
        AppLog.registerGlobalEventCallback(globalEventCallback);
    }

    public static String getAppVersionMinor() {
        return AppLog.getAppVersionMinor();
    }

    public static void setAppVersionMinor(String str) {
        AppLog.setAppVersionMinor(str);
    }

    public static void setSessionKey(String str) {
        AppLog.setSessionKey(str);
    }

    public static String getSessionKey() {
        return AppLog.getSessionKey();
    }
}
