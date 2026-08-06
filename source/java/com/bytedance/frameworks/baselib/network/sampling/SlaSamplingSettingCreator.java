package com.bytedance.frameworks.baselib.network.sampling;

import android.text.TextUtils;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.sampling.SamplingSettingProvider;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class SlaSamplingSettingCreator {
    private static final Set<String> EVENT_LOG_TYPES;
    private static final String KEY_API_ALLOW_LIST = "api_allow_list";
    private static final String KEY_API_ALLOW_LIST_HOST_PATTERN = "api_allow_list_host_pattern";
    private static final String KEY_API_ALLOW_LIST_PATH_CONTAIN = "api_allow_list_path_contain";
    private static final String KEY_API_ALLOW_LIST_PATH_EQUAL = "api_allow_list_path_equal";
    private static final String KEY_API_ALLOW_LIST_PATH_PREFIX = "api_allow_list_path_prefix";
    private static final String KEY_API_ALLOW_LIST_PATH_REGEX = "api_allow_list_path_regexp";
    private static final String KEY_API_ALLOW_LIST_URL_REGEX = "api_allow_list_url_regexp";
    private static final String KEY_API_BLOCK_LIST = "api_block_list";
    private static final String KEY_ENABLE_API_ALL_UPLOAD = "enable_api_all_upload";
    private static final String KEY_ENABLE_BASE_API_ALL = "enable_base_api_all";
    private static final String KEY_EVENT_ALLOW_LOG_TYPE = "allow_log_type";
    private static final String TAG = "SlaSamplingSCreator";
    private static SamplingSettingProvider.SlaSamplingSetting sOriginSetting;
    private static double sTolerance;

    static {
        HashSet hashSet = new HashSet();
        EVENT_LOG_TYPES = hashSet;
        sTolerance = 1.0E-9d;
        hashSet.add("ttnet_high_lvl_conn");
        hashSet.add("multinetwork");
        hashSet.add("mpa_client");
        hashSet.add("ttnet_feedback_detect");
        hashSet.add("ttnet_exception_detect");
        hashSet.add("ttnet_stress_detect");
        hashSet.add("ttnet_polling_detect");
        hashSet.add("long_cost_net_task");
        hashSet.add("ws_all");
        hashSet.add("frontier_all");
        hashSet.add("frontier_msg");
        hashSet.add("user_msg");
        hashSet.add(CronetDataStorageAccess.STORE_IDC);
        hashSet.add("ttnet_route_select");
        hashSet.add("ws_ping");
        hashSet.add("frontier_online");
        hashSet.add("ttnet_all_log");
        hashSet.add("cookie_mismatch");
        hashSet.add("cronet_native_requestlog");
        hashSet.add("ttnet_debug_trace_info");
        hashSet.add("ttnet_http_dns_fail");
        hashSet.add("ttnet_tnc_update_result");
        hashSet.add("cronet_native_requestlog_empty");
        hashSet.add("frontier_qos");
        hashSet.add("ttnet_net_exp");
        hashSet.add("bad_request_diagnosis");
        hashSet.add("ttnet_raw_detect");
        hashSet.add("gna_raw_detect");
        hashSet.add("ttnet_network_environment");
        hashSet.add("game_network");
        hashSet.add("ttnet_zstd_stream");
        hashSet.add("ttnet_zstd_dict_error");
        hashSet.add("ttnet_load");
        hashSet.add("ttnet_insec_rect");
        hashSet.add("ttquiche_native_request_log");
        hashSet.add("otel_log");
    }

    private static boolean parseJSONObjectList(JSONObject jSONObject, String str, List<String> list) {
        JSONObject optJSONObject;
        if (jSONObject == null || TextUtils.isEmpty(str) || list == null || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            return false;
        }
        Iterator<String> keys = optJSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                list.add(next);
            }
        }
        return true;
    }

    private static void parseJSONArrayList(JSONObject jSONObject, String str, List<String> list) {
        JSONArray optJSONArray;
        if (jSONObject == null || TextUtils.isEmpty(str) || list == null || (optJSONArray = jSONObject.optJSONArray(str)) == null) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            String optString = optJSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                list.add(optString);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0144 A[Catch: Exception -> 0x0190, TryCatch #0 {Exception -> 0x0190, blocks: (B:5:0x000f, B:7:0x001d, B:9:0x0025, B:13:0x0038, B:15:0x0041, B:19:0x004b, B:22:0x005e, B:25:0x0072, B:28:0x0086, B:31:0x009a, B:34:0x00ae, B:37:0x00c3, B:40:0x00e4, B:43:0x00f1, B:44:0x013d, B:46:0x0144, B:48:0x014c, B:51:0x0164, B:53:0x016a, B:56:0x0170, B:58:0x0179, B:60:0x017f, B:62:0x0185, B:64:0x018c, B:77:0x002d, B:83:0x0199), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0162 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0179 A[Catch: Exception -> 0x0190, TryCatch #0 {Exception -> 0x0190, blocks: (B:5:0x000f, B:7:0x001d, B:9:0x0025, B:13:0x0038, B:15:0x0041, B:19:0x004b, B:22:0x005e, B:25:0x0072, B:28:0x0086, B:31:0x009a, B:34:0x00ae, B:37:0x00c3, B:40:0x00e4, B:43:0x00f1, B:44:0x013d, B:46:0x0144, B:48:0x014c, B:51:0x0164, B:53:0x016a, B:56:0x0170, B:58:0x0179, B:60:0x017f, B:62:0x0185, B:64:0x018c, B:77:0x002d, B:83:0x0199), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SamplingSettingProvider.SlaSamplingSetting create(JSONObject jSONObject, int i) {
        SamplingSettingProvider.SlaSamplingRule slaSamplingRule;
        SamplingSettingProvider.SlaEventLogSamplingRule slaEventLogSamplingRule;
        SamplingSettingProvider.SlaSamplingSetting slaSamplingSetting;
        SamplingSettingProvider.SlaSamplingSetting slaSamplingSetting2;
        boolean z;
        try {
            if (i <= 0 || jSONObject == null) {
                Logger.e(TAG, "create slaSamplingSetting failed, ".concat(jSONObject == null ? "jsonObject is null" : "appId is invalid"));
                return null;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(SlardarSettingsConsts.SETTING_NETWORK_IMAGE_MODULES);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("custom_event_settings");
            if (optJSONObject != null) {
                optJSONObject = optJSONObject.optJSONObject("network");
            }
            if ((optJSONObject != null && optJSONObject.length() > 0) || (optJSONObject2 != null && optJSONObject2.length() > 0)) {
                if (optJSONObject != null) {
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("api_allow_list");
                    if (optJSONObject3 != null && optJSONObject3.length() != 0) {
                        z = false;
                        ArrayList arrayList = new ArrayList();
                        parseJSONObjectList(optJSONObject, KEY_API_ALLOW_LIST_PATH_EQUAL, arrayList);
                        boolean z2 = (arrayList.isEmpty()) | false;
                        ArrayList arrayList2 = new ArrayList();
                        parseJSONObjectList(optJSONObject, KEY_API_ALLOW_LIST_PATH_PREFIX, arrayList2);
                        boolean z3 = z2 | (arrayList2.isEmpty());
                        ArrayList arrayList3 = new ArrayList();
                        parseJSONObjectList(optJSONObject, KEY_API_ALLOW_LIST_PATH_CONTAIN, arrayList3);
                        boolean z4 = z3 | (arrayList3.isEmpty());
                        ArrayList arrayList4 = new ArrayList();
                        parseJSONObjectList(optJSONObject, KEY_API_ALLOW_LIST_PATH_REGEX, arrayList4);
                        boolean z5 = z4 | (arrayList4.isEmpty());
                        ArrayList arrayList5 = new ArrayList();
                        parseJSONObjectList(optJSONObject, KEY_API_ALLOW_LIST_HOST_PATTERN, arrayList5);
                        boolean z6 = z5 | (arrayList5.isEmpty());
                        ArrayList arrayList6 = new ArrayList();
                        parseJSONObjectList(optJSONObject, KEY_API_ALLOW_LIST_URL_REGEX, arrayList6);
                        boolean z7 = z6 | (!arrayList6.isEmpty());
                        if (!z || z7) {
                            ArrayList arrayList7 = new ArrayList();
                            parseJSONArrayList(optJSONObject, "api_block_list", arrayList7);
                            slaSamplingRule = new SamplingSettingProvider.SlaSamplingRule(Math.abs(optJSONObject.optDouble("enable_base_api_all")) <= sTolerance, optJSONObject.optInt("enable_api_all_upload") != 1, (String[]) arrayList7.toArray(new String[0]), (String[]) arrayList.toArray(new String[0]), (String[]) arrayList3.toArray(new String[0]), (String[]) arrayList2.toArray(new String[0]), (String[]) arrayList4.toArray(new String[0]), (String[]) arrayList6.toArray(new String[0]), (String[]) arrayList5.toArray(new String[0]));
                            ArrayList arrayList8 = new ArrayList();
                            if (optJSONObject2 == null && parseJSONObjectList(optJSONObject2, "allow_log_type", arrayList8)) {
                                arrayList8.retainAll(EVENT_LOG_TYPES);
                                slaEventLogSamplingRule = new SamplingSettingProvider.SlaEventLogSamplingRule((String[]) arrayList8.toArray(new String[0]));
                            } else {
                                slaEventLogSamplingRule = null;
                            }
                            if (slaSamplingRule != null && slaEventLogSamplingRule == null) {
                                if (Logger.debug()) {
                                    Logger.d(TAG, "create slaSamplingSetting failed, api and event rule is null");
                                }
                                return null;
                            }
                            slaSamplingSetting = new SamplingSettingProvider.SlaSamplingSetting(i, slaSamplingRule, slaEventLogSamplingRule);
                            slaSamplingSetting2 = sOriginSetting;
                            if (slaSamplingSetting2 == null && slaSamplingSetting2.equals(slaSamplingSetting)) {
                                if (Logger.debug()) {
                                    Logger.d(TAG, "slaSamplingSetting same");
                                }
                                return null;
                            }
                            sOriginSetting = slaSamplingSetting;
                            return slaSamplingSetting;
                        }
                    }
                    z = true;
                    ArrayList arrayList9 = new ArrayList();
                    parseJSONObjectList(optJSONObject, KEY_API_ALLOW_LIST_PATH_EQUAL, arrayList9);
                    boolean z22 = (arrayList9.isEmpty()) | false;
                    ArrayList arrayList22 = new ArrayList();
                    parseJSONObjectList(optJSONObject, KEY_API_ALLOW_LIST_PATH_PREFIX, arrayList22);
                    boolean z32 = z22 | (arrayList22.isEmpty());
                    ArrayList arrayList32 = new ArrayList();
                    parseJSONObjectList(optJSONObject, KEY_API_ALLOW_LIST_PATH_CONTAIN, arrayList32);
                    boolean z42 = z32 | (arrayList32.isEmpty());
                    ArrayList arrayList42 = new ArrayList();
                    parseJSONObjectList(optJSONObject, KEY_API_ALLOW_LIST_PATH_REGEX, arrayList42);
                    boolean z52 = z42 | (arrayList42.isEmpty());
                    ArrayList arrayList52 = new ArrayList();
                    parseJSONObjectList(optJSONObject, KEY_API_ALLOW_LIST_HOST_PATTERN, arrayList52);
                    boolean z62 = z52 | (arrayList52.isEmpty());
                    ArrayList arrayList62 = new ArrayList();
                    parseJSONObjectList(optJSONObject, KEY_API_ALLOW_LIST_URL_REGEX, arrayList62);
                    boolean z72 = z62 | (!arrayList62.isEmpty());
                    if (!z) {
                    }
                    ArrayList arrayList72 = new ArrayList();
                    parseJSONArrayList(optJSONObject, "api_block_list", arrayList72);
                    slaSamplingRule = new SamplingSettingProvider.SlaSamplingRule(Math.abs(optJSONObject.optDouble("enable_base_api_all")) <= sTolerance, optJSONObject.optInt("enable_api_all_upload") != 1, (String[]) arrayList72.toArray(new String[0]), (String[]) arrayList9.toArray(new String[0]), (String[]) arrayList32.toArray(new String[0]), (String[]) arrayList22.toArray(new String[0]), (String[]) arrayList42.toArray(new String[0]), (String[]) arrayList62.toArray(new String[0]), (String[]) arrayList52.toArray(new String[0]));
                    ArrayList arrayList82 = new ArrayList();
                    if (optJSONObject2 == null) {
                    }
                    slaEventLogSamplingRule = null;
                    if (slaSamplingRule != null) {
                    }
                    slaSamplingSetting = new SamplingSettingProvider.SlaSamplingSetting(i, slaSamplingRule, slaEventLogSamplingRule);
                    slaSamplingSetting2 = sOriginSetting;
                    if (slaSamplingSetting2 == null) {
                    }
                    sOriginSetting = slaSamplingSetting;
                    return slaSamplingSetting;
                }
                slaSamplingRule = null;
                ArrayList arrayList822 = new ArrayList();
                if (optJSONObject2 == null) {
                }
                slaEventLogSamplingRule = null;
                if (slaSamplingRule != null) {
                }
                slaSamplingSetting = new SamplingSettingProvider.SlaSamplingSetting(i, slaSamplingRule, slaEventLogSamplingRule);
                slaSamplingSetting2 = sOriginSetting;
                if (slaSamplingSetting2 == null) {
                }
                sOriginSetting = slaSamplingSetting;
                return slaSamplingSetting;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
