package com.bytedance.ies.bullet.redirect.data;

import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.redirect.AnnieXRedirectImplProcessor;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.bytedance.sdk.xbridge.cn.runtime.utils.JsonUtils;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RedirectReportInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0010J\b\u0010\u0016\u001a\u00020\u0017H\u0002R\u0015\u0010\u0003\u001a\u00060\u0004R\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0015\u0010\u0007\u001a\u00060\bR\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u000b\u001a\u00060\fR\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/data/RedirectReportInfo;", "", "()V", "category", "Lcom/bytedance/ies/bullet/redirect/data/RedirectReportInfo$Category;", "getCategory", "()Lcom/bytedance/ies/bullet/redirect/data/RedirectReportInfo$Category;", "extras", "Lcom/bytedance/ies/bullet/redirect/data/RedirectReportInfo$Extra;", "getExtras", "()Lcom/bytedance/ies/bullet/redirect/data/RedirectReportInfo$Extra;", "metric", "Lcom/bytedance/ies/bullet/redirect/data/RedirectReportInfo$Metric;", "getMetric", "()Lcom/bytedance/ies/bullet/redirect/data/RedirectReportInfo$Metric;", "reportError", "", "code", "", "errMsg", "", "reportSuccess", "shouldReport", "", "Category", "Companion", "Extra", "Metric", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RedirectReportInfo {
    public static final String DEFAULT_BID = "Annie";
    public static final String EVENT_ERROR = "annie_schema_redirect_error";
    public static final String EVENT_STATUS = "annie_schema_redirect_status";
    private final Category category = new Category();
    private final Extra extras = new Extra();
    private final Metric metric = new Metric();

    /* compiled from: RedirectReportInfo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001e\u0010-\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0015\"\u0004\b/\u0010\u0017¨\u00060"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/data/RedirectReportInfo$Category;", "", "(Lcom/bytedance/ies/bullet/redirect/data/RedirectReportInfo;)V", "configType", "", "getConfigType", "()Ljava/lang/String;", "setConfigType", "(Ljava/lang/String;)V", "configVersion", "getConfigVersion", "setConfigVersion", "defaultSchema", "getDefaultSchema", "setDefaultSchema", "entry", "getEntry", "setEntry", "errorCode", "", "getErrorCode", "()I", "setErrorCode", "(I)V", "errorMessage", "getErrorMessage", "setErrorMessage", "loopIndex", "getLoopIndex", "setLoopIndex", "originSchema", "getOriginSchema", "setOriginSchema", "resolvedSchema", "getResolvedSchema", "setResolvedSchema", "ruleTypes", "Lorg/json/JSONArray;", "getRuleTypes", "()Lorg/json/JSONArray;", "setRuleTypes", "(Lorg/json/JSONArray;)V", "sdkVersion", "getSdkVersion", "setSdkVersion", "statusCode", "getStatusCode", "setStatusCode", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public final class Category {

        @SerializedName(CDNLoader.DIAGNOSE_ERROR_CODE)
        private int errorCode;

        @SerializedName("loop_index")
        private int loopIndex;

        @SerializedName("status_code")
        private int statusCode;

        @SerializedName("origin_schema")
        private String originSchema = "";

        @SerializedName("resolved_schema")
        private String resolvedSchema = "";

        @SerializedName("config_type")
        private String configType = "";

        @SerializedName("config_version")
        private String configVersion = "";

        @SerializedName(CommonConstants.SDK_VERSION)
        private String sdkVersion = "";

        @SerializedName("entry")
        private String entry = "";

        @SerializedName("default_schema")
        private String defaultSchema = "";

        @SerializedName("rule_types")
        private JSONArray ruleTypes = new JSONArray();

        @SerializedName(CDNLoader.DIAGNOSE_ERROR_MESSAGE)
        private String errorMessage = "";

        public Category() {
        }

        public final int getStatusCode() {
            return this.statusCode;
        }

        public final void setStatusCode(int i) {
            this.statusCode = i;
        }

        public final String getOriginSchema() {
            return this.originSchema;
        }

        public final void setOriginSchema(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.originSchema = str;
        }

        public final String getResolvedSchema() {
            return this.resolvedSchema;
        }

        public final void setResolvedSchema(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.resolvedSchema = str;
        }

        public final String getConfigType() {
            return this.configType;
        }

        public final void setConfigType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.configType = str;
        }

        public final String getConfigVersion() {
            return this.configVersion;
        }

        public final void setConfigVersion(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.configVersion = str;
        }

        public final String getSdkVersion() {
            return this.sdkVersion;
        }

        public final void setSdkVersion(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.sdkVersion = str;
        }

        public final String getEntry() {
            return this.entry;
        }

        public final void setEntry(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.entry = str;
        }

        public final String getDefaultSchema() {
            return this.defaultSchema;
        }

        public final void setDefaultSchema(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.defaultSchema = str;
        }

        public final int getLoopIndex() {
            return this.loopIndex;
        }

        public final void setLoopIndex(int i) {
            this.loopIndex = i;
        }

        public final JSONArray getRuleTypes() {
            return this.ruleTypes;
        }

        public final void setRuleTypes(JSONArray jSONArray) {
            Intrinsics.checkNotNullParameter(jSONArray, "<set-?>");
            this.ruleTypes = jSONArray;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final void setErrorCode(int i) {
            this.errorCode = i;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final void setErrorMessage(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.errorMessage = str;
        }
    }

    /* compiled from: RedirectReportInfo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/data/RedirectReportInfo$Metric;", "", "(Lcom/bytedance/ies/bullet/redirect/data/RedirectReportInfo;)V", LynxTimingPerformanceReportProcessor.KEY_DURATION, "", "getDuration", "()J", "setDuration", "(J)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public final class Metric {

        @SerializedName(LynxTimingPerformanceReportProcessor.KEY_DURATION)
        private long duration;

        public Metric() {
        }

        public final long getDuration() {
            return this.duration;
        }

        public final void setDuration(long j) {
            this.duration = j;
        }
    }

    /* compiled from: RedirectReportInfo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/data/RedirectReportInfo$Extra;", "", "(Lcom/bytedance/ies/bullet/redirect/data/RedirectReportInfo;)V", "entryConfig", "", "getEntryConfig", "()Ljava/lang/String;", "setEntryConfig", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public final class Extra {

        @SerializedName("entry_config")
        private String entryConfig = "";

        public Extra() {
        }

        public final String getEntryConfig() {
            return this.entryConfig;
        }

        public final void setEntryConfig(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.entryConfig = str;
        }
    }

    public final Category getCategory() {
        return this.category;
    }

    public final Extra getExtras() {
        return this.extras;
    }

    public final Metric getMetric() {
        return this.metric;
    }

    public final void reportSuccess() {
        if (shouldReport()) {
            this.category.setStatusCode(1);
            String json = JsonUtils.INSTANCE.toJson(this.category);
            String json2 = JsonUtils.INSTANCE.toJson(this.metric);
            String json3 = JsonUtils.INSTANCE.toJson(this.extras);
            HybridLogger.i$default(HybridLogger.INSTANCE, AnnieXRedirectImplProcessor.TAG, "report Success: \n category: " + json + ";\n metric: " + json2 + ";\n extras: " + json3 + ";\n", null, null, 12, null);
            HybridMultiMonitor.getInstance().customReport(new CustomInfo.Builder(EVENT_STATUS).setBid(DEFAULT_BID).setCategory(new JSONObject(json)).setMetric(new JSONObject(json2)).setExtra(new JSONObject(json3)).setSample(1).build());
        }
    }

    public static /* synthetic */ void reportError$default(RedirectReportInfo redirectReportInfo, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        redirectReportInfo.reportError(i, str);
    }

    public final void reportError(int code, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        if (shouldReport()) {
            this.category.setStatusCode(0);
            this.category.setErrorCode(code);
            this.category.setErrorMessage(errMsg);
            String json = JsonUtils.INSTANCE.toJson(this.category);
            String json2 = JsonUtils.INSTANCE.toJson(this.metric);
            String json3 = JsonUtils.INSTANCE.toJson(this.extras);
            HybridLogger.i$default(HybridLogger.INSTANCE, AnnieXRedirectImplProcessor.TAG, "report Error: \n category: " + json + ";\n metric: " + json2 + ";\n extras: " + json3 + ";\n", null, null, 12, null);
            HybridMultiMonitor.getInstance().customReport(new CustomInfo.Builder(EVENT_STATUS).setBid(DEFAULT_BID).setCategory(new JSONObject(json)).setMetric(new JSONObject(json2)).setExtra(new JSONObject(json3)).setSample(1).build());
            HybridMultiMonitor.getInstance().customReport(new CustomInfo.Builder(EVENT_ERROR).setBid(DEFAULT_BID).setCategory(new JSONObject(json)).setMetric(new JSONObject(json2)).setExtra(new JSONObject(json3)).setSample(0).build());
        }
    }

    private final boolean shouldReport() {
        return !Intrinsics.areEqual(this.category.getOriginSchema(), AnnieXRedirectImplProcessor.initUrl);
    }
}
