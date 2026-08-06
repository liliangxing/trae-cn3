package com.bytedance.android.monitorV2;

import com.bytedance.android.monitorV2.executor.HybridMonitorExecutor;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: InternalWatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010.\u001a\u00020/2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010-H\u0002J\u001e\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u0004JH\u00106\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u00042\u0006\u00107\u001a\u00020\u00042\u0016\b\u0002\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010-2\u0016\b\u0002\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010-R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R~\u0010*\u001ar\u0012\f\u0012\n ,*\u0004\u0018\u00010\u00040\u0004\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004 ,*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010+0+ ,*8\u0012\f\u0012\n ,*\u0004\u0018\u00010\u00040\u0004\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004 ,*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010+0+\u0018\u00010-0+X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/bytedance/android/monitorV2/InternalWatcher;", "", "()V", "CONFIG_URL_BASE64", "", "CONFIG_URL_OVERSEA_BASE64", "EVENT_BLANK_CHECK", "EVENT_BLANK_RESULT", "EVENT_INTERFACE_MONITOR", "EVENT_INTERNAL_ERROR", "EVENT_JSSDK_LOAD", "EVENT_PAGE_START", "EVENT_REGEX_PERF", "EVENT_REPEAT_PAGE_START", "EVENT_REPORT_CHECK", "EVENT_REPORT_CHECK_PLUS", "EVENT_SETTING_INIT", "EVENT_SETTING_PARSE_PERF", "EVENT_STARTUP_INIT", "EVENT_URL_LOAD", "INTERNAL_AID", "PARAM_COMMON_CONTAINER_NAME", "PARAM_COMMON_ENGINE_TYPE", "PARAM_COMMON_LYNX_VERSION", "PARAM_COMMON_URL", "PARAM_CONFIG_FROM_CLASS", "PARAM_REGEX_HIT_CACHE", "PARAM_REGEX_MATCH_TIME", "PARAM_REPEAT_PAGE_START_URL", "PARAM_SETTING_INIT_TIME", "PARAM_SETTING_INIT_TYPE", "PARAM_SETTING_PARSE_BID_COUNT", "PARAM_SETTING_PARSE_REGEX_COUNT", "PARAM_SETTING_PARSE_TIME", "PARAM_SETTING_PARSE_TYPE", "PARAM_SPEC_EFFECTIVE_PERCENT", "PARAM_SPEC_ERROR_DESC", "PARAM_SPEC_ERROR_MSG", "PARAM_SPEC_RESULT", "PARAM_SPEC_SETTING_ID", "REPORT_URL_BASE64", "REPORT_URL_OVERSEA_BASE64", "commonMap", "", "kotlin.jvm.PlatformType", "", "fillCommon", "Lorg/json/JSONObject;", SettingsManager.COMMON_SERVICE, "markCommon", "", "navigationId", "key", "value", SccResult.LABEL_NOTICE, "event", "categoryParams", "metricParams", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class InternalWatcher {
    public static final String CONFIG_URL_BASE64 = "aHR0cHM6Ly9tb24uc25zc2RrLmNvbS9tb25pdG9yL2FwcG1vbml0b3IvdjIvc2V0dGluZ3M=";
    public static final String CONFIG_URL_OVERSEA_BASE64 = "aHR0cHM6Ly9tb24uaXNuc3Nkay5jb20vbW9uaXRvci9hcHBtb25pdG9yL3YyL3NldHRpbmdz";
    public static final String EVENT_BLANK_CHECK = "blank_check";
    public static final String EVENT_BLANK_RESULT = "blank_result";
    public static final String EVENT_INTERFACE_MONITOR = "interface_monitor";
    public static final String EVENT_INTERNAL_ERROR = "internal_error";
    public static final String EVENT_JSSDK_LOAD = "jssdk_load";
    public static final String EVENT_PAGE_START = "page_start";
    public static final String EVENT_REGEX_PERF = "regex_perf";
    public static final String EVENT_REPEAT_PAGE_START = "repeat_page_start";
    public static final String EVENT_REPORT_CHECK = "report_check";
    public static final String EVENT_REPORT_CHECK_PLUS = "report_check_plus";
    public static final String EVENT_SETTING_INIT = "setting_init_perf";
    public static final String EVENT_SETTING_PARSE_PERF = "setting_parse_perf";
    public static final String EVENT_STARTUP_INIT = "startup_init";
    public static final String EVENT_URL_LOAD = "url_load";
    public static final String INTERNAL_AID = "8560";
    public static final String PARAM_COMMON_CONTAINER_NAME = "container_name";
    public static final String PARAM_COMMON_ENGINE_TYPE = "engine_type";
    public static final String PARAM_COMMON_LYNX_VERSION = "lynx_version";
    public static final String PARAM_COMMON_URL = "url";
    public static final String PARAM_CONFIG_FROM_CLASS = "config_from_class";
    public static final String PARAM_REGEX_HIT_CACHE = "hit_cache";
    public static final String PARAM_REGEX_MATCH_TIME = "regex_match_time";
    public static final String PARAM_REPEAT_PAGE_START_URL = "repeat_page_start_url";
    public static final String PARAM_SETTING_INIT_TIME = "setting_init_time";
    public static final String PARAM_SETTING_INIT_TYPE = "setting_init_type";
    public static final String PARAM_SETTING_PARSE_BID_COUNT = "bid_count";
    public static final String PARAM_SETTING_PARSE_REGEX_COUNT = "regex_count";
    public static final String PARAM_SETTING_PARSE_TIME = "setting_parse_time";
    public static final String PARAM_SETTING_PARSE_TYPE = "setting_parse_type";
    public static final String PARAM_SPEC_EFFECTIVE_PERCENT = "effective_percentage";
    public static final String PARAM_SPEC_ERROR_DESC = "error_desc";
    public static final String PARAM_SPEC_ERROR_MSG = "error_error_msg";
    public static final String PARAM_SPEC_RESULT = "result";
    public static final String PARAM_SPEC_SETTING_ID = "setting_id";
    public static final String REPORT_URL_BASE64 = "aHR0cHM6Ly9tb24uc25zc2RrLmNvbS9tb25pdG9yL2NvbGxlY3Qv";
    public static final String REPORT_URL_OVERSEA_BASE64 = "aHR0cHM6Ly9tb24uaXNuc3Nkay5jb20vbW9uaXRvci9jb2xsZWN0Lw==";
    public static final InternalWatcher INSTANCE = new InternalWatcher();
    private static final Map<String, Map<String, String>> commonMap = Collections.synchronizedMap(new LinkedHashMap());

    private InternalWatcher() {
    }

    public final void markCommon(String navigationId, String key, String value) {
        Intrinsics.checkNotNullParameter(navigationId, "navigationId");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Map<String, Map<String, String>> commonMap2 = commonMap;
        if (commonMap2.get(navigationId) == null) {
            Intrinsics.checkNotNullExpressionValue(commonMap2, "commonMap");
            commonMap2.put(navigationId, new LinkedHashMap());
            Map<String, String> map = commonMap2.get(navigationId);
            Intrinsics.checkNotNull(map);
            map.put("navigation_id", navigationId);
        }
        Map<String, String> map2 = commonMap2.get(navigationId);
        Intrinsics.checkNotNull(map2);
        map2.put(key, value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void notice$default(InternalWatcher internalWatcher, String str, String str2, Map map, Map map2, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        if ((i & 8) != 0) {
            map2 = null;
        }
        internalWatcher.notice(str, str2, map, map2);
    }

    public final void notice(final String navigationId, final String event, final Map<String, String> categoryParams, final Map<String, ? extends Object> metricParams) {
        Intrinsics.checkNotNullParameter(event, "event");
        HybridMonitorExecutor.INSTANCE.post(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.InternalWatcher$notice$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map map;
                JSONObject fillCommon;
                InternalWatcher internalWatcher = InternalWatcher.INSTANCE;
                map = InternalWatcher.commonMap;
                fillCommon = internalWatcher.fillCommon((Map) map.get(navigationId));
                Map<String, String> map2 = categoryParams;
                if (map2 != null) {
                    for (Map.Entry<String, String> entry : map2.entrySet()) {
                        fillCommon.put(entry.getKey(), entry.getValue());
                    }
                }
                JSONObject jSONObject = new JSONObject();
                Map<String, Object> map3 = metricParams;
                if (map3 != null) {
                    for (Map.Entry<String, Object> entry2 : map3.entrySet()) {
                        jSONObject.put(entry2.getKey(), entry2.getValue());
                    }
                }
                SDKMonitorUtils.getInstance(InternalWatcher.INTERNAL_AID).monitorEvent(event, fillCommon, jSONObject, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject fillCommon(Map<String, String> common) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sdk_version", AnnieXMonitorConstants.ANNIEX_VERSION);
        if (common != null) {
            for (Map.Entry<String, String> entry : common.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }
}
