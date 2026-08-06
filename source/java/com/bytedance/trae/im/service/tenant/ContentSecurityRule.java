package com.bytedance.trae.im.service.tenant;

import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TenantUserConfigModels.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\b\u0086\b\u0018\u0000 22\u00020\u0001:\u00012B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bHÂ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010*\u001a\u00020\u000eHÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bHÂ\u0003J\u0084\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\u000e2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\bHÖ\u0001J\t\u00101\u001a\u00020\u0005HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0017R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001bR\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u000b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b8F¢\u0006\u0006\u001a\u0004\b\"\u0010 ¨\u00063"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;", "", "rawRuleId", "Lcom/google/gson/JsonElement;", "tenantId", "", "ruleName", "ruleType", "", "sceneType", "rawExecutionPoints", "", ReportConstant.COMMON_ACTION_TYPE, "isEnabled", "", "rawRuleDetails", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;", "<init>", "(Lcom/google/gson/JsonElement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;ZLjava/util/List;)V", "getTenantId", "()Ljava/lang/String;", "getRuleName", "getRuleType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSceneType", "getActionType", "()Z", "ruleId", "getRuleId", "executionPoints", "getExecutionPoints", "()Ljava/util/List;", "ruleDetails", "getRuleDetails", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/google/gson/JsonElement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;ZLjava/util/List;)Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;", "equals", "other", "hashCode", "toString", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class ContentSecurityRule {
    public static final int ACTION_TYPE_BLOCK = 1;
    public static final int ACTION_TYPE_DESENSITIZE = 2;
    public static final int EXECUTION_POINT_PRE = 1;
    public static final int SCENE_TYPE_CHAT = 1;

    @SerializedName("action_type")
    private final Integer actionType;

    @SerializedName("is_enabled")
    private final boolean isEnabled;

    @SerializedName("execution_points")
    private final List<Integer> rawExecutionPoints;

    @SerializedName("rule_details")
    private final List<ContentSecurityRuleDetail> rawRuleDetails;

    @SerializedName("rule_id")
    private final JsonElement rawRuleId;

    @SerializedName("rule_name")
    private final String ruleName;

    @SerializedName("rule_type")
    private final Integer ruleType;

    @SerializedName("scene_type")
    private final Integer sceneType;

    @SerializedName("tenant_id")
    private final String tenantId;

    public ContentSecurityRule() {
        this(null, null, null, null, null, null, null, false, null, 511, null);
    }

    /* renamed from: component1, reason: from getter */
    private final JsonElement getRawRuleId() {
        return this.rawRuleId;
    }

    private final List<Integer> component6() {
        return this.rawExecutionPoints;
    }

    private final List<ContentSecurityRuleDetail> component9() {
        return this.rawRuleDetails;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTenantId() {
        return this.tenantId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRuleName() {
        return this.ruleName;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getRuleType() {
        return this.ruleType;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getSceneType() {
        return this.sceneType;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getActionType() {
        return this.actionType;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public final ContentSecurityRule copy(JsonElement rawRuleId, String tenantId, String ruleName, Integer ruleType, Integer sceneType, List<Integer> rawExecutionPoints, Integer actionType, boolean isEnabled, List<ContentSecurityRuleDetail> rawRuleDetails) {
        return new ContentSecurityRule(rawRuleId, tenantId, ruleName, ruleType, sceneType, rawExecutionPoints, actionType, isEnabled, rawRuleDetails);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContentSecurityRule)) {
            return false;
        }
        ContentSecurityRule contentSecurityRule = (ContentSecurityRule) other;
        return Intrinsics.areEqual(this.rawRuleId, contentSecurityRule.rawRuleId) && Intrinsics.areEqual(this.tenantId, contentSecurityRule.tenantId) && Intrinsics.areEqual(this.ruleName, contentSecurityRule.ruleName) && Intrinsics.areEqual(this.ruleType, contentSecurityRule.ruleType) && Intrinsics.areEqual(this.sceneType, contentSecurityRule.sceneType) && Intrinsics.areEqual(this.rawExecutionPoints, contentSecurityRule.rawExecutionPoints) && Intrinsics.areEqual(this.actionType, contentSecurityRule.actionType) && this.isEnabled == contentSecurityRule.isEnabled && Intrinsics.areEqual(this.rawRuleDetails, contentSecurityRule.rawRuleDetails);
    }

    public int hashCode() {
        JsonElement jsonElement = this.rawRuleId;
        int hashCode = (jsonElement == null ? 0 : jsonElement.hashCode()) * 31;
        String str = this.tenantId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.ruleName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.ruleType;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.sceneType;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        List<Integer> list = this.rawExecutionPoints;
        int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num3 = this.actionType;
        int hashCode7 = (((hashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31) + Boolean.hashCode(this.isEnabled)) * 31;
        List<ContentSecurityRuleDetail> list2 = this.rawRuleDetails;
        return hashCode7 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "ContentSecurityRule(rawRuleId=" + this.rawRuleId + ", tenantId=" + this.tenantId + ", ruleName=" + this.ruleName + ", ruleType=" + this.ruleType + ", sceneType=" + this.sceneType + ", rawExecutionPoints=" + this.rawExecutionPoints + ", actionType=" + this.actionType + ", isEnabled=" + this.isEnabled + ", rawRuleDetails=" + this.rawRuleDetails + ')';
    }

    public ContentSecurityRule(JsonElement jsonElement, String str, String str2, Integer num, Integer num2, List<Integer> list, Integer num3, boolean z, List<ContentSecurityRuleDetail> list2) {
        this.rawRuleId = jsonElement;
        this.tenantId = str;
        this.ruleName = str2;
        this.ruleType = num;
        this.sceneType = num2;
        this.rawExecutionPoints = list;
        this.actionType = num3;
        this.isEnabled = z;
        this.rawRuleDetails = list2;
    }

    public /* synthetic */ ContentSecurityRule(JsonElement jsonElement, String str, String str2, Integer num, Integer num2, List list, Integer num3, boolean z, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jsonElement, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : num3, (i & 128) != 0 ? false : z, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) == 0 ? list2 : null);
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public final String getRuleName() {
        return this.ruleName;
    }

    public final Integer getRuleType() {
        return this.ruleType;
    }

    public final Integer getSceneType() {
        return this.sceneType;
    }

    public final Integer getActionType() {
        return this.actionType;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final String getRuleId() {
        String stringOrNumber;
        stringOrNumber = TenantUserConfigModelsKt.stringOrNumber(this.rawRuleId);
        return stringOrNumber;
    }

    public final List<Integer> getExecutionPoints() {
        List<Integer> list = this.rawExecutionPoints;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final List<ContentSecurityRuleDetail> getRuleDetails() {
        List<ContentSecurityRuleDetail> list = this.rawRuleDetails;
        return list == null ? CollectionsKt.emptyList() : list;
    }
}
