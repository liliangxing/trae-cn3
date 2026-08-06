package com.bytedance.helios.statichook.config;

import android.util.Log;
import com.bytedance.helios.statichook.api.ActionInvoker;
import com.bytedance.upc.cache.ApiActionInvoker;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ApiHookConfig {
    private static String desc = "This class is used as a dictionary maintains.\nDictionary layout:\n    |---- key: API ID, an integer value\n    |---- value: {API ID, API name hash code,                   API related resource id(may be empty),                  API related resource name(maybe empty),                  permissions(maybe empty),                  permission type(anyOf/allOf, maybe empty),                  data types,                  monitor class hash code,                  invoke type (before or/and around)}\nIn runtime, TikTok will monitor these sensitive API usage according to this dictionary to make sure there is no misuse. For example *getDeviceId/getSSID...etc* is not allowed in TikTok. And the ActionInvokers are used to intercept the usage of these API";
    private static Map<String, ActionInvoker> invokers = Collections.EMPTY_MAP;
    private static Map<Integer, ApiHookDef> apiConfigs = Collections.EMPTY_MAP;
    private static String apiConfigVersion = "";
    private static final ActionInvoker[] EMPTY_INVOKERS = new ActionInvoker[0];

    private static void initInvokers() {
        HashMap hashMap = new HashMap(1);
        invokers = hashMap;
        hashMap.put("-5107019182865140624", new ApiActionInvoker());
    }

    public ApiHookConfig() {
        Log.d("Description", desc);
    }

    static {
        try {
            initInvokers();
            initApiConfig();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void initApiConfig() {
        apiConfigVersion = "";
        HashMap hashMap = new HashMap(9);
        apiConfigs = hashMap;
        hashMap.put(101601, new ApiHookDef(101601, "android.telephony.TelephonyManager.getImei", "", "", new String[0], 0, new String[0], new String[]{"-5107019182865140624"}, "around"));
        apiConfigs.put(101600, new ApiHookDef(101600, "android.telephony.TelephonyManager.getDeviceId", "", "", new String[0], 0, new String[0], new String[]{"-5107019182865140624"}, "around"));
        apiConfigs.put(102021, new ApiHookDef(102021, "android.telephony.TelephonyManager.getSimOperator", "", "", new String[0], 0, new String[0], new String[]{"-5107019182865140624"}, "around"));
        apiConfigs.put(101700, new ApiHookDef(101700, "android.net.wifi.WifiInfo.getMacAddress", "", "", new String[0], 0, new String[0], new String[]{"-5107019182865140624"}, "around"));
        apiConfigs.put(101701, new ApiHookDef(101701, "java.net.NetworkInterface.getHardwareAddress", "", "", new String[0], 0, new String[0], new String[]{"-5107019182865140624"}, "around"));
        apiConfigs.put(10000008, new ApiHookDef(10000008, "com.bytedance.bdinstall.oaid.Oaid.getOaidId", "", "", new String[0], 0, new String[0], new String[]{"-5107019182865140624"}, "around"));
        apiConfigs.put(10000009, new ApiHookDef(10000009, "com.ss.android.deviceregister.base.Oaid.getOaidId", "", "", new String[0], 0, new String[0], new String[]{"-5107019182865140624"}, "around"));
        apiConfigs.put(102003, new ApiHookDef(102003, "android.provider.Settings$System.getString", "", "", new String[0], 0, new String[0], new String[]{"-5107019182865140624"}, "around"));
        apiConfigs.put(102004, new ApiHookDef(102004, "android.provider.Settings$Secure.getString", "", "", new String[0], 0, new String[0], new String[]{"-5107019182865140624"}, "around"));
        for (ApiHookDef apiHookDef : apiConfigs.values()) {
            String[] actionInvokerNames = apiHookDef.getActionInvokerNames();
            ActionInvoker[] actionInvokerArr = new ActionInvoker[actionInvokerNames.length];
            for (int i = 0; i < actionInvokerNames.length; i++) {
                actionInvokerArr[i] = invokers.get(actionInvokerNames[i]);
            }
            apiHookDef.setActionInvokers(actionInvokerArr);
            apiHookDef.setActionInvokerNames(null);
        }
    }

    public static ActionInvoker[] getInvokersById(Integer num) {
        ApiHookDef apiHookDef = apiConfigs.get(num);
        if (apiHookDef != null) {
            return apiHookDef.getActionInvokers();
        }
        return EMPTY_INVOKERS;
    }

    public static Map<Integer, ApiHookDef> getApiConfigs() {
        return apiConfigs;
    }

    public static String getInvokerVersion() {
        return apiConfigVersion;
    }
}
