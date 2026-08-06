package com.bytedance.ies.bullet.service.base;

import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.ies.bullet.service.base.utils.Identifier;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IMonitorReportService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 ;2\u00020\u0001:\u0001;Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R\u001c\u0010$\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0010\"\u0004\b.\u0010\u0012R\u001e\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0010\"\u0004\b7\u0010\u0012R\u001c\u00108\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0010\"\u0004\b:\u0010\u0012¨\u0006<"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/ReportInfo;", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "", "url", "platform", "category", "Lorg/json/JSONObject;", "metrics", "highFrequency", "", SettingsManager.COMMON_SERVICE, "extra", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/Boolean;Lorg/json/JSONObject;Lorg/json/JSONObject;)V", "bizTag", "getBizTag", "()Ljava/lang/String;", "setBizTag", "(Ljava/lang/String;)V", "getCategory", "()Lorg/json/JSONObject;", "setCategory", "(Lorg/json/JSONObject;)V", "getCommon", "setCommon", "getEventName", "setEventName", "getExtra", "setExtra", "getHighFrequency", "()Ljava/lang/Boolean;", "setHighFrequency", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMetrics", "setMetrics", "monitorId", "getMonitorId", "setMonitorId", "pageIdentifier", "Lcom/bytedance/ies/bullet/service/base/utils/Identifier;", "getPageIdentifier", "()Lcom/bytedance/ies/bullet/service/base/utils/Identifier;", "setPageIdentifier", "(Lcom/bytedance/ies/bullet/service/base/utils/Identifier;)V", "getPlatform", "setPlatform", "sampleLevel", "", "getSampleLevel", "()Ljava/lang/Integer;", "setSampleLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUrl", "setUrl", "virtualAID", "getVirtualAID", "setVirtualAID", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class ReportInfo {
    public static final String PLATFORM_LYNX = "lynx";
    public static final String PLATFORM_UNKNOWN = "unknown";
    public static final String PLATFORM_WEB = "web";
    private String bizTag;
    private JSONObject category;
    private JSONObject common;
    private String eventName;
    private JSONObject extra;
    private Boolean highFrequency;
    private JSONObject metrics;
    private String monitorId;
    private Identifier pageIdentifier;
    private String platform;
    private Integer sampleLevel;
    private String url;
    private String virtualAID;

    public ReportInfo(String eventName, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, Boolean bool, JSONObject jSONObject3, JSONObject jSONObject4) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.eventName = eventName;
        this.url = str;
        this.platform = str2;
        this.category = jSONObject;
        this.metrics = jSONObject2;
        this.highFrequency = bool;
        this.common = jSONObject3;
        this.extra = jSONObject4;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final void setEventName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.eventName = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final void setPlatform(String str) {
        this.platform = str;
    }

    public final JSONObject getCategory() {
        return this.category;
    }

    public final void setCategory(JSONObject jSONObject) {
        this.category = jSONObject;
    }

    public final JSONObject getMetrics() {
        return this.metrics;
    }

    public final void setMetrics(JSONObject jSONObject) {
        this.metrics = jSONObject;
    }

    public /* synthetic */ ReportInfo(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, Boolean bool, JSONObject jSONObject3, JSONObject jSONObject4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : jSONObject, (i & 16) != 0 ? null : jSONObject2, (i & 32) != 0 ? false : bool, (i & 64) != 0 ? null : jSONObject3, (i & 128) == 0 ? jSONObject4 : null);
    }

    public final Boolean getHighFrequency() {
        return this.highFrequency;
    }

    public final void setHighFrequency(Boolean bool) {
        this.highFrequency = bool;
    }

    public final JSONObject getCommon() {
        return this.common;
    }

    public final void setCommon(JSONObject jSONObject) {
        this.common = jSONObject;
    }

    public final JSONObject getExtra() {
        return this.extra;
    }

    public final void setExtra(JSONObject jSONObject) {
        this.extra = jSONObject;
    }

    public final String getVirtualAID() {
        return this.virtualAID;
    }

    public final void setVirtualAID(String str) {
        this.virtualAID = str;
    }

    public final String getBizTag() {
        return this.bizTag;
    }

    public final void setBizTag(String str) {
        this.bizTag = str;
    }

    public final Identifier getPageIdentifier() {
        return this.pageIdentifier;
    }

    public final void setPageIdentifier(Identifier identifier) {
        this.pageIdentifier = identifier;
    }

    public final Integer getSampleLevel() {
        return this.sampleLevel;
    }

    public final void setSampleLevel(Integer num) {
        this.sampleLevel = num;
    }

    public final String getMonitorId() {
        return this.monitorId;
    }

    public final void setMonitorId(String str) {
        this.monitorId = str;
    }
}
