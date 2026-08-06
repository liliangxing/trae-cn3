package com.bytedance.android.monitorV2.util;

import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.InternalWatcher;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.debug.MonitorDebugConfig;
import com.bytedance.android.monitorV2.experiment.HostExperimentManager;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidRegex;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingResponse;
import com.bytedance.android.monitorV2.hybridSetting.entity.LazyBidRegex;
import com.bytedance.android.monitorV2.hybridSetting.entity.SwitchConfig;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ConvertUtil {
    private static final String TAG = "HybridMonitor";

    public static HybridSettingResponse resToResponseStepOne(String str) {
        return resToResponseStepOne(JsonUtils.safeToJsonOb(str));
    }

    public static HybridSettingResponse resToResponseStepOne(JSONObject jSONObject) {
        HybridSettingResponse hybridSettingResponse = new HybridSettingResponse();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            hybridSettingResponse.updateTime = JsonUtils.safeOptLong(optJSONObject, "update_time");
            hybridSettingResponse.duration = JsonUtils.safeOptInt(optJSONObject, "duration");
            hybridSettingResponse.settingId = JsonUtils.safeOptLong(optJSONObject, "setting_id");
            hybridSettingResponse.switchConfig = toSwitchConfig(JsonUtils.safeOptLong(optJSONObject, "enable_switch"));
            hybridSettingResponse.allEventSample = toEventSampleMap(JsonUtils.safeOptJsonObj(optJSONObject, "all_event_sample"));
            hybridSettingResponse.hostWhiteSet = toHostWhiteSet(JsonUtils.safeOptJsonArray(optJSONObject, "host_list"));
            hybridSettingResponse.checkFilter = toCheckFilter(JsonUtils.safeOptJsonObj(optJSONObject, "check_filter"));
        } catch (Throwable th) {
            ExceptionUtil.handleException(ExceptionUtil.STARTUP_HANDLE, th);
        }
        return hybridSettingResponse;
    }

    public static HybridSettingResponse resToResponseStepTwo(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        HybridSettingResponse hybridSettingResponse = new HybridSettingResponse();
        try {
            JSONObject optJSONObject = JsonUtils.safeToJsonOb(str).optJSONObject("data");
            hybridSettingResponse.bidInfo = toBidInfo(JsonUtils.safeOptJsonObj(optJSONObject, ReportConst.Params.BID_INFO), JsonUtils.safeOptLong(optJSONObject, "setting_id"), false);
            MonitorLog.m26d(TAG, "monitor setting parse bid cost: " + (System.currentTimeMillis() - currentTimeMillis));
            HashMap hashMap = new HashMap();
            hashMap.put(InternalWatcher.PARAM_SETTING_PARSE_BID_COUNT, Long.valueOf(hybridSettingResponse.bidInfo.bidInfoMap.size()));
            hashMap.put(InternalWatcher.PARAM_SETTING_PARSE_REGEX_COUNT, Long.valueOf(hybridSettingResponse.bidInfo.regexList.size()));
            hashMap.put(InternalWatcher.PARAM_SETTING_PARSE_TIME, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            HashMap hashMap2 = new HashMap();
            hashMap2.put(InternalWatcher.PARAM_SETTING_PARSE_TYPE, "json");
            InternalWatcher.INSTANCE.notice(null, InternalWatcher.EVENT_SETTING_PARSE_PERF, hashMap2, hashMap);
        } catch (Throwable th) {
            ExceptionUtil.handleException(ExceptionUtil.STARTUP_HANDLE, th);
        }
        return hybridSettingResponse;
    }

    public static BidInfo toBidInfo(JSONObject jSONObject, long j, boolean z) {
        BidInfo bidInfo = new BidInfo();
        if (jSONObject == null) {
            return bidInfo;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                JSONObject safeOptJsonObj = JsonUtils.safeOptJsonObj(jSONObject, next);
                long safeOptLong = JsonUtils.safeOptLong(safeOptJsonObj, "hit_sample");
                BidInfo.BidConfig bidConfig = new BidInfo.BidConfig(next);
                bidConfig.hitSample = safeOptLong;
                bidConfig.settingId = j;
                bidConfig.eventNameSample = toEventSampleMap(JsonUtils.safeOptJsonObj(safeOptJsonObj, "event_name_sample"));
                bidInfo.bidInfoMap.put(next, convertSample(bidConfig, safeOptLong, 46));
                JSONArray optJSONArray = safeOptJsonObj.optJSONArray("regex_list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        try {
                            String optString = optJSONArray.optString(i);
                            if (z) {
                                bidInfo.regexList.add(new LazyBidRegex(next, optString));
                            } else {
                                bidInfo.regexList.add(new BidRegex(next, new Regex(optString)));
                            }
                        } catch (Throwable th) {
                            ExceptionUtil.handleException(ExceptionUtil.STARTUP_HANDLE, th);
                        }
                    }
                }
            } catch (Throwable th2) {
                ExceptionUtil.handleException(ExceptionUtil.STARTUP_HANDLE, th2);
            }
        }
        Collections.sort(bidInfo.regexList);
        return bidInfo;
    }

    public static SwitchConfig toSwitchConfig(long j) {
        SwitchConfig switchConfig = new SwitchConfig();
        switchConfig.mConfig = j;
        Switches.resetAll(j);
        return switchConfig;
    }

    public static Map<String, Integer> toEventSampleMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, Integer.valueOf(JsonUtils.safeOptInt(jSONObject, next)));
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(ExceptionUtil.STARTUP_HANDLE, th);
        }
        return hashMap;
    }

    public static Set<String> toHostWhiteSet(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        hashSet.add(jSONArray.optString(i));
                    }
                }
            } catch (Throwable th) {
                ExceptionUtil.handleException(th);
            }
        }
        return hashSet;
    }

    public static CheckFilter toCheckFilter(JSONObject jSONObject) {
        CheckFilter checkFilter = new CheckFilter();
        try {
            JSONObject safeOptJsonObj = JsonUtils.safeOptJsonObj(jSONObject, ReportConst.ReportCheck.FILTER);
            HashMap hashMap = new HashMap();
            for (String str : ReportConst.ReportCheck.FILTER_LIST) {
                hashMap.put(str, JsonUtils.jsonArrToList(JsonUtils.safeOptJsonArray(safeOptJsonObj, str)));
            }
            return new CheckFilter(hashMap, JsonUtils.jsonArrToList(JsonUtils.safeOptJsonArray(jSONObject, "category")), JsonUtils.safeOptStr(jSONObject, "id"));
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
            return checkFilter;
        }
    }

    public static BidInfo.BidConfig convertSample(BidInfo.BidConfig bidConfig, long j, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 != 0) {
                j >>= 1;
            }
            if (j % 2 == 1) {
                setSample(bidConfig, i2);
            }
        }
        return bidConfig;
    }

    public static void setSample(BidInfo.BidConfig bidConfig, int i) {
        switch (i) {
            case 0:
                bidConfig.custom_p0 = true;
                return;
            case 1:
                bidConfig.custom_p1 = true;
                return;
            case 2:
                bidConfig.custom_p2 = true;
                return;
            case 3:
                bidConfig.custom_p3 = true;
                return;
            case 4:
                bidConfig.custom_p4 = true;
                return;
            case 5:
                bidConfig.custom_p5 = true;
                return;
            case 6:
                bidConfig.custom_p6 = true;
                return;
            case 7:
                bidConfig.custom_p7 = true;
                return;
            case 8:
                bidConfig.custom_p8 = true;
                return;
            case 9:
                bidConfig.perf_web = true;
                return;
            case 10:
                bidConfig.ajax_web = true;
                return;
            case 11:
                bidConfig.static_perf_web = true;
                return;
            case 12:
                bidConfig.static_error_web = true;
                return;
            case 13:
                bidConfig.js_exception_web = true;
                return;
            case 14:
                bidConfig.blank_web = true;
                return;
            case 15:
                bidConfig.fetch_error_web = true;
                return;
            case 16:
                bidConfig.jsb_error_web = true;
                return;
            case 17:
                bidConfig.jsb_perf_web = true;
                return;
            case 18:
                bidConfig.falcon_perf_web = true;
                return;
            case 19:
                bidConfig.native_error_web = true;
                return;
            case 20:
                bidConfig.navigation_start_web = true;
                return;
            case 21:
                bidConfig.static_sri_web = true;
                return;
            case 22:
                bidConfig.performance_lynx = true;
                return;
            case 23:
                bidConfig.blank_lynx = true;
                return;
            case 24:
                bidConfig.fetch_error_lynx = true;
                return;
            case 25:
                bidConfig.jsb_error_lynx = true;
                return;
            case 26:
                bidConfig.jsb_perf_lynx = true;
                return;
            case 27:
                bidConfig.native_error_lynx = true;
                return;
            case 28:
                bidConfig.navigation_start_lynx = true;
                return;
            case 29:
                bidConfig.performance_reactnative = true;
                return;
            case 30:
                bidConfig.blank_reactnative = true;
                return;
            case 31:
                bidConfig.fetch_error_reactnative = true;
                return;
            case 32:
                bidConfig.jsb_error_reactnative = true;
                return;
            case 33:
                bidConfig.native_error_reactnative = true;
                return;
            case 34:
                bidConfig.container_error = true;
                return;
            case 35:
                bidConfig.js_exception_lynx = true;
                return;
            case 36:
                bidConfig.static_error_lynx = true;
                return;
            case 37:
                bidConfig.tea_switch = true;
                return;
            case 38:
                bidConfig.res_loader_perf_web = true;
                return;
            case 39:
                bidConfig.res_loader_perf_template_web = true;
                return;
            case 40:
                bidConfig.res_loader_error_web = true;
                return;
            case 41:
                bidConfig.res_loader_error_template_web = true;
                return;
            case 42:
                bidConfig.res_loader_perf_lynx = true;
                return;
            case 43:
                bidConfig.res_loader_perf_template_lynx = true;
                return;
            case 44:
                bidConfig.res_loader_error_lynx = true;
                return;
            case 45:
                bidConfig.res_loader_error_template_lynx = true;
                return;
            default:
                return;
        }
    }

    public static boolean isSampleForCustom(BidInfo.BidConfig bidConfig, int i) {
        boolean z;
        if (MonitorDebugConfig.isSampleOff()) {
            return true;
        }
        switch (i) {
            case 0:
                z = bidConfig.custom_p0;
                break;
            case 1:
                z = bidConfig.custom_p1;
                break;
            case 2:
                z = bidConfig.custom_p2;
                break;
            case 3:
                z = bidConfig.custom_p3;
                break;
            case 4:
                z = bidConfig.custom_p4;
                break;
            case 5:
                z = bidConfig.custom_p5;
                break;
            case 6:
                z = bidConfig.custom_p6;
                break;
            case 7:
                z = bidConfig.custom_p7;
                break;
            default:
                z = bidConfig.custom_p8;
                break;
        }
        if (!HostExperimentManager.INSTANCE.getEnablePreSample()) {
            MonitorLog.m29i("CustomMonitor", String.format("canSample level: %s, sampleHit: %b, use: %s", Integer.valueOf(i), Boolean.valueOf(z), bidConfig.bid));
        }
        return z;
    }

    public static boolean isSampleForLynx(String str, BidInfo.BidConfig bidConfig) {
        boolean z;
        if (MonitorDebugConfig.isSampleOff()) {
            return true;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1480388560:
                if (str.equals("performance")) {
                    c = 0;
                    break;
                }
                break;
            case -1323516222:
                if (str.equals("jsbPerf")) {
                    c = 1;
                    break;
                }
                break;
            case -892481938:
                if (str.equals(ReportConst.Event.STATIC)) {
                    c = 2;
                    break;
                }
                break;
            case -588767010:
                if (str.equals(ReportConst.Event.JSB_PER_V2)) {
                    c = 3;
                    break;
                }
                break;
            case 93819220:
                if (str.equals("blank")) {
                    c = 4;
                    break;
                }
                break;
            case 194292771:
                if (str.equals(ReportConst.Event.RES_LOADER_PERF_TEMPLATE)) {
                    c = 5;
                    break;
                }
                break;
            case 281935726:
                if (str.equals("fetchError")) {
                    c = 6;
                    break;
                }
                break;
            case 299602137:
                if (str.equals(ReportConst.Event.JS_EXCEPTION)) {
                    c = 7;
                    break;
                }
                break;
            case 831602183:
                if (str.equals("containerError")) {
                    c = '\b';
                    break;
                }
                break;
            case 1008268974:
                if (str.equals("navigationStart")) {
                    c = '\t';
                    break;
                }
                break;
            case 1157772918:
                if (str.equals(ReportConst.Event.RES_LOADER_PERF)) {
                    c = '\n';
                    break;
                }
                break;
            case 1521451035:
                if (str.equals(ReportConst.Event.RES_LOADER_ERROR)) {
                    c = 11;
                    break;
                }
                break;
            case 1727072305:
                if (str.equals("nativeError")) {
                    c = '\f';
                    break;
                }
                break;
            case 1830775838:
                if (str.equals(ReportConst.Event.RES_LOADER_ERROR_TEMPLATE)) {
                    c = '\r';
                    break;
                }
                break;
            case 1910899023:
                if (str.equals("jsbError")) {
                    c = 14;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                z = bidConfig.performance_lynx;
                break;
            case 1:
            case 3:
                z = bidConfig.jsb_perf_lynx;
                break;
            case 2:
                z = bidConfig.static_error_lynx;
                break;
            case 4:
                z = bidConfig.blank_lynx;
                break;
            case 5:
                z = bidConfig.res_loader_perf_template_lynx;
                break;
            case 6:
                z = bidConfig.fetch_error_lynx;
                break;
            case 7:
                z = bidConfig.js_exception_lynx;
                break;
            case '\b':
                z = bidConfig.container_error;
                break;
            case '\t':
                z = bidConfig.navigation_start_lynx;
                break;
            case '\n':
                z = bidConfig.res_loader_perf_lynx;
                break;
            case 11:
                z = bidConfig.res_loader_error_lynx;
                break;
            case '\f':
                z = bidConfig.native_error_lynx;
                break;
            case '\r':
                z = bidConfig.res_loader_error_template_lynx;
                break;
            case 14:
                z = bidConfig.jsb_error_lynx;
                break;
            default:
                z = false;
                break;
        }
        if (!HostExperimentManager.INSTANCE.getEnablePreSample()) {
            MonitorLog.m29i(TAG, String.format("sampling eventType: %s, sampleHit: %b, use: %s", str, Boolean.valueOf(z), bidConfig.bid));
        }
        return z;
    }

    public static boolean isReportForWebSample(String str, BidInfo.BidConfig bidConfig) {
        boolean z;
        if (MonitorDebugConfig.isSampleOff()) {
            return true;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1898518694:
                if (str.equals("falconPerf")) {
                    c = 0;
                    break;
                }
                break;
            case -1577087617:
                if (str.equals("resource_performance")) {
                    c = 1;
                    break;
                }
                break;
            case -1323516222:
                if (str.equals("jsbPerf")) {
                    c = 2;
                    break;
                }
                break;
            case -892481938:
                if (str.equals(ReportConst.Event.STATIC)) {
                    c = 3;
                    break;
                }
                break;
            case -588767010:
                if (str.equals(ReportConst.Event.JSB_PER_V2)) {
                    c = 4;
                    break;
                }
                break;
            case -109980519:
                if (str.equals(ReportConst.Event.STATIC_SRI)) {
                    c = 5;
                    break;
                }
                break;
            case 2994720:
                if (str.equals(ReportConst.Event.AJAX)) {
                    c = 6;
                    break;
                }
                break;
            case 3437289:
                if (str.equals("perf")) {
                    c = 7;
                    break;
                }
                break;
            case 93819220:
                if (str.equals("blank")) {
                    c = '\b';
                    break;
                }
                break;
            case 194292771:
                if (str.equals(ReportConst.Event.RES_LOADER_PERF_TEMPLATE)) {
                    c = '\t';
                    break;
                }
                break;
            case 281935726:
                if (str.equals("fetchError")) {
                    c = '\n';
                    break;
                }
                break;
            case 299602137:
                if (str.equals(ReportConst.Event.JS_EXCEPTION)) {
                    c = 11;
                    break;
                }
                break;
            case 831602183:
                if (str.equals("containerError")) {
                    c = '\f';
                    break;
                }
                break;
            case 1008268974:
                if (str.equals("navigationStart")) {
                    c = '\r';
                    break;
                }
                break;
            case 1157772918:
                if (str.equals(ReportConst.Event.RES_LOADER_PERF)) {
                    c = 14;
                    break;
                }
                break;
            case 1521451035:
                if (str.equals(ReportConst.Event.RES_LOADER_ERROR)) {
                    c = 15;
                    break;
                }
                break;
            case 1727072305:
                if (str.equals("nativeError")) {
                    c = 16;
                    break;
                }
                break;
            case 1830775838:
                if (str.equals(ReportConst.Event.RES_LOADER_ERROR_TEMPLATE)) {
                    c = 17;
                    break;
                }
                break;
            case 1910899023:
                if (str.equals("jsbError")) {
                    c = 18;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                z = bidConfig.falcon_perf_web;
                break;
            case 1:
                z = bidConfig.static_perf_web;
                break;
            case 2:
            case 4:
                z = bidConfig.jsb_perf_web;
                break;
            case 3:
                z = bidConfig.static_error_web;
                break;
            case 5:
                z = bidConfig.static_sri_web;
                break;
            case 6:
                z = bidConfig.ajax_web;
                break;
            case 7:
                z = bidConfig.perf_web;
                break;
            case '\b':
                z = bidConfig.blank_web;
                break;
            case '\t':
                z = bidConfig.res_loader_perf_template_web;
                break;
            case '\n':
                z = bidConfig.fetch_error_web;
                break;
            case 11:
                z = bidConfig.js_exception_web;
                break;
            case '\f':
                z = bidConfig.container_error;
                break;
            case '\r':
                z = bidConfig.navigation_start_web;
                break;
            case 14:
                z = bidConfig.res_loader_perf_web;
                break;
            case 15:
                z = bidConfig.res_loader_error_web;
                break;
            case 16:
                z = bidConfig.native_error_web;
                break;
            case 17:
                z = bidConfig.res_loader_error_template_web;
                break;
            case 18:
                z = bidConfig.jsb_error_web;
                break;
            default:
                z = false;
                break;
        }
        if (!HostExperimentManager.INSTANCE.getEnablePreSample()) {
            MonitorLog.m29i(TAG, String.format("sampling eventType: %s, sampleHit: %b, use: %s", str, Boolean.valueOf(z), bidConfig.bid));
        }
        return z;
    }

    public static boolean isSampleForContainer(String str, BidInfo.BidConfig bidConfig) {
        if (MonitorDebugConfig.isSampleOff()) {
            return true;
        }
        str.hashCode();
        if (str.equals("containerError")) {
            return bidConfig.container_error;
        }
        return false;
    }

    public static int isSampleForAllEventName(String str) {
        if (MonitorDebugConfig.isSampleOff()) {
            return 1;
        }
        Map<String, Integer> allEventSample = HybridMultiMonitor.getInstance().getHybridSettingManager().getAllEventSample();
        if (allEventSample.containsKey(str)) {
            return allEventSample.get(str).intValue();
        }
        return -1;
    }

    public static int isSampleForEventName(String str, String str2) {
        if (MonitorDebugConfig.isSampleOff()) {
            return 1;
        }
        Map<String, Integer> eventNameSample = HybridMultiMonitor.getInstance().getHybridSettingManager().getBidInfo().getEventNameSample(str);
        if (eventNameSample.containsKey(str2)) {
            return eventNameSample.get(str2).intValue();
        }
        return -1;
    }

    public static boolean isSampleForTea(String str) {
        if (MonitorDebugConfig.isSampleOff()) {
            return true;
        }
        return HybridMultiMonitor.getInstance().getHybridSettingManager().getBidInfo().get(str).tea_switch;
    }
}
