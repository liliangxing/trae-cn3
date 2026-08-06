package com.bytedance.trae.im.service.tenant;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TenantUserConfigModels.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;", "", "rawRuleDetailId", "Lcom/google/gson/JsonElement;", "ruleDetailName", "", "regexPattern", "replacement", "sequence", "", "<init>", "(Lcom/google/gson/JsonElement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getRuleDetailName", "()Ljava/lang/String;", "getRegexPattern", "getReplacement", "getSequence", "()I", "ruleDetailId", "getRuleDetailId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class ContentSecurityRuleDetail {

    @SerializedName("rule_detail_id")
    private final JsonElement rawRuleDetailId;

    @SerializedName("regex_pattern")
    private final String regexPattern;

    @SerializedName("replacement")
    private final String replacement;

    @SerializedName("rule_detail_name")
    private final String ruleDetailName;

    @SerializedName("sequence")
    private final int sequence;

    public ContentSecurityRuleDetail() {
        this(null, null, null, null, 0, 31, null);
    }

    /* renamed from: component1, reason: from getter */
    private final JsonElement getRawRuleDetailId() {
        return this.rawRuleDetailId;
    }

    public static /* synthetic */ ContentSecurityRuleDetail copy$default(ContentSecurityRuleDetail contentSecurityRuleDetail, JsonElement jsonElement, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            jsonElement = contentSecurityRuleDetail.rawRuleDetailId;
        }
        if ((i2 & 2) != 0) {
            str = contentSecurityRuleDetail.ruleDetailName;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            str2 = contentSecurityRuleDetail.regexPattern;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            str3 = contentSecurityRuleDetail.replacement;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            i = contentSecurityRuleDetail.sequence;
        }
        return contentSecurityRuleDetail.copy(jsonElement, str4, str5, str6, i);
    }

    /* renamed from: component2, reason: from getter */
    public final String getRuleDetailName() {
        return this.ruleDetailName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRegexPattern() {
        return this.regexPattern;
    }

    /* renamed from: component4, reason: from getter */
    public final String getReplacement() {
        return this.replacement;
    }

    /* renamed from: component5, reason: from getter */
    public final int getSequence() {
        return this.sequence;
    }

    public final ContentSecurityRuleDetail copy(JsonElement rawRuleDetailId, String ruleDetailName, String regexPattern, String replacement, int sequence) {
        return new ContentSecurityRuleDetail(rawRuleDetailId, ruleDetailName, regexPattern, replacement, sequence);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContentSecurityRuleDetail)) {
            return false;
        }
        ContentSecurityRuleDetail contentSecurityRuleDetail = (ContentSecurityRuleDetail) other;
        return Intrinsics.areEqual(this.rawRuleDetailId, contentSecurityRuleDetail.rawRuleDetailId) && Intrinsics.areEqual(this.ruleDetailName, contentSecurityRuleDetail.ruleDetailName) && Intrinsics.areEqual(this.regexPattern, contentSecurityRuleDetail.regexPattern) && Intrinsics.areEqual(this.replacement, contentSecurityRuleDetail.replacement) && this.sequence == contentSecurityRuleDetail.sequence;
    }

    public int hashCode() {
        JsonElement jsonElement = this.rawRuleDetailId;
        int hashCode = (jsonElement == null ? 0 : jsonElement.hashCode()) * 31;
        String str = this.ruleDetailName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.regexPattern;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.replacement;
        return ((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + Integer.hashCode(this.sequence);
    }

    public String toString() {
        return "ContentSecurityRuleDetail(rawRuleDetailId=" + this.rawRuleDetailId + ", ruleDetailName=" + this.ruleDetailName + ", regexPattern=" + this.regexPattern + ", replacement=" + this.replacement + ", sequence=" + this.sequence + ')';
    }

    public ContentSecurityRuleDetail(JsonElement jsonElement, String str, String str2, String str3, int i) {
        this.rawRuleDetailId = jsonElement;
        this.ruleDetailName = str;
        this.regexPattern = str2;
        this.replacement = str3;
        this.sequence = i;
    }

    public /* synthetic */ ContentSecurityRuleDetail(JsonElement jsonElement, String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : jsonElement, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) == 0 ? str3 : null, (i2 & 16) != 0 ? 0 : i);
    }

    public final String getRuleDetailName() {
        return this.ruleDetailName;
    }

    public final String getRegexPattern() {
        return this.regexPattern;
    }

    public final String getReplacement() {
        return this.replacement;
    }

    public final int getSequence() {
        return this.sequence;
    }

    public final String getRuleDetailId() {
        String stringOrNumber;
        stringOrNumber = TenantUserConfigModelsKt.stringOrNumber(this.rawRuleDetailId);
        return stringOrNumber;
    }
}
