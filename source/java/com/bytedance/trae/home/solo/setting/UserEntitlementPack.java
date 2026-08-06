package com.bytedance.trae.home.solo.setting;

import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.timonbase.scene.PageDataManager;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserEntStatusApi.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b*\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010.\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010/\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00102\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0092\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÇ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u00109\u001a\u00020\tH×\u0001J\t\u0010:\u001a\u00020\u0005H×\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0006\u0010\u001aR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b$\u0010 R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b%\u0010 R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0012\u0010\u001aR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019¨\u0006;"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/UserEntitlementPack;", "", "entitlementBaseInfo", "Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;", "sourceId", "", "isLastPeriod", "", PageDataManager.EXTRA_STATUS, "", "nextBillingTime", "", "usage", "Lcom/bytedance/trae/home/solo/setting/EntUsage;", "yearlyExpireTime", "expireTime", "payGoPaidAmount", "", "isHide", "displayDesc", "<init>", "(Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;Lcom/bytedance/trae/home/solo/setting/EntUsage;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/String;)V", "getEntitlementBaseInfo", "()Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;", "getSourceId", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNextBillingTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUsage", "()Lcom/bytedance/trae/home/solo/setting/EntUsage;", "getYearlyExpireTime", "getExpireTime", "getPayGoPaidAmount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getDisplayDesc", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;Lcom/bytedance/trae/home/solo/setting/EntUsage;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/UserEntitlementPack;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class UserEntitlementPack {
    public static final int $stable = 0;

    @SerializedName("display_desc")
    private final String displayDesc;

    @SerializedName("entitlement_base_info")
    private final EntitlementBaseInfo entitlementBaseInfo;

    @SerializedName("expire_time")
    private final Long expireTime;

    @SerializedName("is_hide")
    private final Boolean isHide;

    @SerializedName("is_last_period")
    private final Boolean isLastPeriod;

    @SerializedName("next_billing_time")
    private final Long nextBillingTime;

    @SerializedName("pay_go_paid_amount")
    private final Double payGoPaidAmount;

    @SerializedName("source_id")
    private final String sourceId;

    @SerializedName(PageDataManager.EXTRA_STATUS)
    private final Integer status;

    @SerializedName("usage")
    private final EntUsage usage;

    @SerializedName("yearly_expire_time")
    private final Long yearlyExpireTime;

    public UserEntitlementPack() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* renamed from: component1, reason: from getter */
    public final EntitlementBaseInfo getEntitlementBaseInfo() {
        return this.entitlementBaseInfo;
    }

    /* renamed from: component10, reason: from getter */
    public final Boolean getIsHide() {
        return this.isHide;
    }

    /* renamed from: component11, reason: from getter */
    public final String getDisplayDesc() {
        return this.displayDesc;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSourceId() {
        return this.sourceId;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getIsLastPeriod() {
        return this.isLastPeriod;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getStatus() {
        return this.status;
    }

    /* renamed from: component5, reason: from getter */
    public final Long getNextBillingTime() {
        return this.nextBillingTime;
    }

    /* renamed from: component6, reason: from getter */
    public final EntUsage getUsage() {
        return this.usage;
    }

    /* renamed from: component7, reason: from getter */
    public final Long getYearlyExpireTime() {
        return this.yearlyExpireTime;
    }

    /* renamed from: component8, reason: from getter */
    public final Long getExpireTime() {
        return this.expireTime;
    }

    /* renamed from: component9, reason: from getter */
    public final Double getPayGoPaidAmount() {
        return this.payGoPaidAmount;
    }

    public final UserEntitlementPack copy(EntitlementBaseInfo entitlementBaseInfo, String sourceId, Boolean isLastPeriod, Integer status, Long nextBillingTime, EntUsage usage, Long yearlyExpireTime, Long expireTime, Double payGoPaidAmount, Boolean isHide, String displayDesc) {
        return new UserEntitlementPack(entitlementBaseInfo, sourceId, isLastPeriod, status, nextBillingTime, usage, yearlyExpireTime, expireTime, payGoPaidAmount, isHide, displayDesc);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserEntitlementPack)) {
            return false;
        }
        UserEntitlementPack userEntitlementPack = (UserEntitlementPack) other;
        return Intrinsics.areEqual(this.entitlementBaseInfo, userEntitlementPack.entitlementBaseInfo) && Intrinsics.areEqual(this.sourceId, userEntitlementPack.sourceId) && Intrinsics.areEqual(this.isLastPeriod, userEntitlementPack.isLastPeriod) && Intrinsics.areEqual(this.status, userEntitlementPack.status) && Intrinsics.areEqual(this.nextBillingTime, userEntitlementPack.nextBillingTime) && Intrinsics.areEqual(this.usage, userEntitlementPack.usage) && Intrinsics.areEqual(this.yearlyExpireTime, userEntitlementPack.yearlyExpireTime) && Intrinsics.areEqual(this.expireTime, userEntitlementPack.expireTime) && Intrinsics.areEqual(this.payGoPaidAmount, userEntitlementPack.payGoPaidAmount) && Intrinsics.areEqual(this.isHide, userEntitlementPack.isHide) && Intrinsics.areEqual(this.displayDesc, userEntitlementPack.displayDesc);
    }

    public int hashCode() {
        EntitlementBaseInfo entitlementBaseInfo = this.entitlementBaseInfo;
        int hashCode = (entitlementBaseInfo == null ? 0 : entitlementBaseInfo.hashCode()) * 31;
        String str = this.sourceId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.isLastPeriod;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.status;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.nextBillingTime;
        int hashCode5 = (hashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        EntUsage entUsage = this.usage;
        int hashCode6 = (hashCode5 + (entUsage == null ? 0 : entUsage.hashCode())) * 31;
        Long l2 = this.yearlyExpireTime;
        int hashCode7 = (hashCode6 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.expireTime;
        int hashCode8 = (hashCode7 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Double d = this.payGoPaidAmount;
        int hashCode9 = (hashCode8 + (d == null ? 0 : d.hashCode())) * 31;
        Boolean bool2 = this.isHide;
        int hashCode10 = (hashCode9 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str2 = this.displayDesc;
        return hashCode10 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UserEntitlementPack(entitlementBaseInfo=");
        sb.append(this.entitlementBaseInfo).append(", sourceId=").append(this.sourceId).append(", isLastPeriod=").append(this.isLastPeriod).append(", status=").append(this.status).append(", nextBillingTime=").append(this.nextBillingTime).append(", usage=").append(this.usage).append(", yearlyExpireTime=").append(this.yearlyExpireTime).append(", expireTime=").append(this.expireTime).append(", payGoPaidAmount=").append(this.payGoPaidAmount).append(", isHide=").append(this.isHide).append(", displayDesc=").append(this.displayDesc).append(')');
        return sb.toString();
    }

    public UserEntitlementPack(EntitlementBaseInfo entitlementBaseInfo, String str, Boolean bool, Integer num, Long l, EntUsage entUsage, Long l2, Long l3, Double d, Boolean bool2, String str2) {
        this.entitlementBaseInfo = entitlementBaseInfo;
        this.sourceId = str;
        this.isLastPeriod = bool;
        this.status = num;
        this.nextBillingTime = l;
        this.usage = entUsage;
        this.yearlyExpireTime = l2;
        this.expireTime = l3;
        this.payGoPaidAmount = d;
        this.isHide = bool2;
        this.displayDesc = str2;
    }

    public /* synthetic */ UserEntitlementPack(EntitlementBaseInfo entitlementBaseInfo, String str, Boolean bool, Integer num, Long l, EntUsage entUsage, Long l2, Long l3, Double d, Boolean bool2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : entitlementBaseInfo, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : entUsage, (i & 64) != 0 ? null : l2, (i & 128) != 0 ? null : l3, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : d, (i & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? null : bool2, (i & 1024) == 0 ? str2 : null);
    }

    public final EntitlementBaseInfo getEntitlementBaseInfo() {
        return this.entitlementBaseInfo;
    }

    public final String getSourceId() {
        return this.sourceId;
    }

    public final Boolean isLastPeriod() {
        return this.isLastPeriod;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Long getNextBillingTime() {
        return this.nextBillingTime;
    }

    public final EntUsage getUsage() {
        return this.usage;
    }

    public final Long getYearlyExpireTime() {
        return this.yearlyExpireTime;
    }

    public final Long getExpireTime() {
        return this.expireTime;
    }

    public final Double getPayGoPaidAmount() {
        return this.payGoPaidAmount;
    }

    public final Boolean isHide() {
        return this.isHide;
    }

    public final String getDisplayDesc() {
        return this.displayDesc;
    }
}
