package com.bytedance.timonbase.report;

import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.TMInjection;
import com.bytedance.timonbase.config.TMConfigService;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.timonbase.scene.ScenesDetector;
import com.bytedance.timonbase.utils.EnumUtils;
import com.bytedance.timonbase.utils.TMThreadUtils;
import com.bytedance.timonbase.version.TimonKitVersion;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: TMMetric.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001$B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\"\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u001c2\b\b\u0002\u0010#\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/timonbase/report/TMMetric;", "", "()V", "CONFIG_SYNC_STYLE", "", "EVENT_API_CALL", "EVENT_CONFIG_FETCHER", "EVENT_SILENT_INITIAL", "EVENT_TIMON_DYE_MARK", "EVENT_TIMON_INIT", "EVENT_TIMON_SERVICE_INIT", "INIT_THREAD", "IS_BASIC_MODE", "IS_BEFORE_AGREE_PRIVACY", "IS_TEEN_MODE", "METRIC_COST", "SENSITIVE_API_COUNT", "SENSITIVE_API_VERSION", "checkReportTimonDyeMark", "", "reportInit", "timer", "Lcom/bytedance/timonbase/report/TMMetric$TimingCounter;", "isInitInMainThread", "", "reportNetworkCall", "succeed", "retryCount", "", "errMsg", "reportServiceInit", "workType", "Lcom/bytedance/timonbase/utils/EnumUtils$WorkType;", "reportSilentInit", PageDataManager.EXTRA_STATUS, "msg", "TimingCounter", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TMMetric {
    private static final String CONFIG_SYNC_STYLE = "timon_config_sync_style";
    public static final String EVENT_API_CALL = "timon_api_call";
    private static final String EVENT_CONFIG_FETCHER = "timon_setting_fetcher";
    private static final String EVENT_SILENT_INITIAL = "timon_silent_initial";
    private static final String EVENT_TIMON_DYE_MARK = "timon_dye_mark";
    private static final String EVENT_TIMON_INIT = "timon_init";
    private static final String EVENT_TIMON_SERVICE_INIT = "timon_service_init";
    private static final String INIT_THREAD = "init_main_thread";
    public static final TMMetric INSTANCE = new TMMetric();
    private static final String IS_BASIC_MODE = "is_basic_mode";
    private static final String IS_BEFORE_AGREE_PRIVACY = "is_before_agree_privacy";
    private static final String IS_TEEN_MODE = "is_teen_mode";
    private static final String METRIC_COST = "main_cost";
    private static final String SENSITIVE_API_COUNT = "sensitive_api_count";
    private static final String SENSITIVE_API_VERSION = "sensitive_api_version";

    private TMMetric() {
    }

    public final void reportInit(TimingCounter timer, final boolean isInitInMainThread) {
        Intrinsics.checkParameterIsNotNull(timer, "timer");
        final JSONObject durationParams = timer.getDurationParams();
        TMThreadUtils.INSTANCE.async(new Function0<Unit>() { // from class: com.bytedance.timonbase.report.TMMetric$reportInit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m1063invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1063invoke() {
                Object obj;
                Object obj2;
                durationParams.put("timon_config_sync_style", TMEnv.INSTANCE.getSettingFetcherSource());
                durationParams.put("init_main_thread", isInitInMainThread);
                durationParams.put("is_teen_mode", false);
                JSONObject jSONObject = durationParams;
                Function0<Boolean> agreedPrivacyReferee = ScenesDetector.INSTANCE.getAgreedPrivacyReferee();
                if (agreedPrivacyReferee == null || (obj = (Boolean) agreedPrivacyReferee.invoke()) == null) {
                    obj = "no_privacy_window";
                }
                jSONObject.put("is_agreed_privacy", obj);
                JSONObject jSONObject2 = durationParams;
                Function0<Boolean> basicModeReferee = ScenesDetector.INSTANCE.getBasicModeReferee();
                if (basicModeReferee == null || (obj2 = (Boolean) basicModeReferee.invoke()) == null) {
                    obj2 = "no_basic_mode";
                }
                jSONObject2.put("is_basic_mode", obj2);
                durationParams.put("sensitive_api_version", ApiHookConfig.getInvokerVersion());
                durationParams.put("sensitive_api_count", ApiHookConfig.getApiConfigs().size());
                for (Map.Entry<String, String> entry : TimonKitVersion.getKitVersions().entrySet()) {
                    durationParams.put("service_" + entry.getKey(), entry.getValue());
                }
                TMDataCollector.reportAppLog$default(TMDataCollector.INSTANCE, "timon_init", durationParams, false, null, 8, null);
            }
        });
    }

    public final void reportServiceInit(TimingCounter timer, EnumUtils.WorkType workType) {
        Intrinsics.checkParameterIsNotNull(timer, "timer");
        Intrinsics.checkParameterIsNotNull(workType, "workType");
        final JSONObject durationParams = timer.getDurationParams();
        durationParams.put("service_work_type", workType.name());
        TMThreadUtils.INSTANCE.async(new Function0<Unit>() { // from class: com.bytedance.timonbase.report.TMMetric$reportServiceInit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m1064invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1064invoke() {
                TMDataCollector.reportAppLog$default(TMDataCollector.INSTANCE, "timon_service_init", durationParams, false, null, 8, null);
            }
        });
    }

    public static /* synthetic */ void reportSilentInit$default(TMMetric tMMetric, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        tMMetric.reportSilentInit(i, str);
    }

    public final void reportSilentInit(int status, String msg) {
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        final JSONObject jSONObject = new JSONObject();
        jSONObject.put(PageDataManager.EXTRA_STATUS, status);
        jSONObject.put("error_msg", msg);
        TMThreadUtils.INSTANCE.async(new Function0<Unit>() { // from class: com.bytedance.timonbase.report.TMMetric$reportSilentInit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m1065invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1065invoke() {
                TMDataCollector.reportAppLog$default(TMDataCollector.INSTANCE, "timon_silent_initial", jSONObject, false, null, 8, null);
            }
        });
    }

    public static /* synthetic */ void reportNetworkCall$default(TMMetric tMMetric, boolean z, int i, String str, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = "";
        }
        tMMetric.reportNetworkCall(z, i, str);
    }

    public final void reportNetworkCall(boolean succeed, int retryCount, String errMsg) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("succeed", succeed ? 1 : 0);
        jSONObject.put("retry_count", retryCount);
        jSONObject.put("error_message", errMsg);
        TMDataCollector.reportAppLog$default(TMDataCollector.INSTANCE, EVENT_CONFIG_FETCHER, jSONObject, false, null, 8, null);
    }

    public final void checkReportTimonDyeMark() {
        TMThreadUtils.INSTANCE.async(new Function0<Unit>() { // from class: com.bytedance.timonbase.report.TMMetric$checkReportTimonDyeMark$1
            public /* bridge */ /* synthetic */ Object invoke() {
                m1062invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1062invoke() {
                Gson gson = TMInjection.INSTANCE.getGson();
                JsonObject configJson = TMConfigService.INSTANCE.getConfigJson("data_collect_config");
                List list = (List) gson.fromJson(configJson != null ? configJson.get("mark") : null, List.class);
                if (list != null) {
                    TMEnv.INSTANCE.setTimonDyeMark(CollectionsKt.joinToString$default(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
                    TMDataCollector.reportAppLog$default(TMDataCollector.INSTANCE, "timon_dye_mark", new JSONObject(), false, null, 8, null);
                }
            }
        });
    }

    /* compiled from: TMMetric.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/timonbase/report/TMMetric$TimingCounter;", "", "name", "", "start", "", "params", "Lorg/json/JSONObject;", "(Ljava/lang/String;JLorg/json/JSONObject;)V", "getName", "()Ljava/lang/String;", "getParams", "()Lorg/json/JSONObject;", "getStart", "()J", "subStack", "Ljava/util/Stack;", "elapsed", "endSub", "", "getDurationParams", "startSub", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class TimingCounter {
        private final String name;
        private final JSONObject params;
        private final long start;
        private final Stack<TimingCounter> subStack;

        public TimingCounter() {
            this(null, 0L, null, 7, null);
        }

        public TimingCounter(String str, long j, JSONObject jSONObject) {
            Intrinsics.checkParameterIsNotNull(str, "name");
            Intrinsics.checkParameterIsNotNull(jSONObject, "params");
            this.name = str;
            this.start = j;
            this.params = jSONObject;
            this.subStack = new Stack<>();
        }

        public final String getName() {
            return this.name;
        }

        public /* synthetic */ TimingCounter(String str, long j, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? TMMetric.METRIC_COST : str, (i & 2) != 0 ? System.currentTimeMillis() : j, (i & 4) != 0 ? new JSONObject() : jSONObject);
        }

        public final long getStart() {
            return this.start;
        }

        public final JSONObject getParams() {
            return this.params;
        }

        public final void startSub(String name) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            this.subStack.push(new TimingCounter(name, 0L, null, 6, null));
        }

        public final void endSub() {
            if (this.subStack.isEmpty()) {
                return;
            }
            TimingCounter pop = this.subStack.pop();
            this.params.put("sub_" + pop.name, pop.elapsed());
        }

        public final JSONObject getDurationParams() {
            this.params.put(this.name, elapsed());
            return this.params;
        }

        public final long elapsed() {
            return System.currentTimeMillis() - this.start;
        }
    }
}
