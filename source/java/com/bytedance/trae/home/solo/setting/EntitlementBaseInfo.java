package com.bytedance.trae.home.solo.setting;

import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserEntStatusApi.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010,\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010/\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0092\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÇ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u00106\u001a\u00020\u0006H×\u0001J\t\u00107\u001a\u00020\u0003H×\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001f\u0010\u001dR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\"\u0010\u001dR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b#\u0010\u0018R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b$\u0010\u001dR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b%\u0010\u0018¨\u00068"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;", "", "entitlementId", "", "userId", "productType", "", "quota", "Lcom/bytedance/trae/home/solo/setting/EntQuota;", "startTime", "", "endTime", "productExtra", "Lcom/bytedance/trae/home/solo/setting/EntProductExtra;", "chargeAmount", "currency", "productId", "entStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/trae/home/solo/setting/EntQuota;Ljava/lang/Long;Ljava/lang/Long;Lcom/bytedance/trae/home/solo/setting/EntProductExtra;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;)V", "getEntitlementId", "()Ljava/lang/String;", "getUserId", "getProductType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getQuota", "()Lcom/bytedance/trae/home/solo/setting/EntQuota;", "getStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndTime", "getProductExtra", "()Lcom/bytedance/trae/home/solo/setting/EntProductExtra;", "getChargeAmount", "getCurrency", "getProductId", "getEntStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/trae/home/solo/setting/EntQuota;Ljava/lang/Long;Ljava/lang/Long;Lcom/bytedance/trae/home/solo/setting/EntProductExtra;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;)Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class EntitlementBaseInfo {
    public static final int $stable = 0;

    @SerializedName("charge_amount")
    private final Long chargeAmount;

    @SerializedName("currency")
    private final Integer currency;

    @SerializedName("end_time")
    private final Long endTime;

    @SerializedName("ent_status")
    private final Integer entStatus;

    @SerializedName("entitlement_id")
    private final String entitlementId;

    @SerializedName("product_extra")
    private final EntProductExtra productExtra;

    @SerializedName("product_id")
    private final Long productId;

    @SerializedName("product_type")
    private final Integer productType;

    @SerializedName("quota")
    private final EntQuota quota;

    @SerializedName("start_time")
    private final Long startTime;

    @SerializedName("user_id")
    private final String userId;

    public EntitlementBaseInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEntitlementId() {
        return this.entitlementId;
    }

    /* renamed from: component10, reason: from getter */
    public final Long getProductId() {
        return this.productId;
    }

    /* renamed from: component11, reason: from getter */
    public final Integer getEntStatus() {
        return this.entStatus;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getProductType() {
        return this.productType;
    }

    /* renamed from: component4, reason: from getter */
    public final EntQuota getQuota() {
        return this.quota;
    }

    /* renamed from: component5, reason: from getter */
    public final Long getStartTime() {
        return this.startTime;
    }

    /* renamed from: component6, reason: from getter */
    public final Long getEndTime() {
        return this.endTime;
    }

    /* renamed from: component7, reason: from getter */
    public final EntProductExtra getProductExtra() {
        return this.productExtra;
    }

    /* renamed from: component8, reason: from getter */
    public final Long getChargeAmount() {
        return this.chargeAmount;
    }

    /* renamed from: component9, reason: from getter */
    public final Integer getCurrency() {
        return this.currency;
    }

    public final EntitlementBaseInfo copy(String entitlementId, String userId, Integer productType, EntQuota quota, Long startTime, Long endTime, EntProductExtra productExtra, Long chargeAmount, Integer currency, Long productId, Integer entStatus) {
        return new EntitlementBaseInfo(entitlementId, userId, productType, quota, startTime, endTime, productExtra, chargeAmount, currency, productId, entStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntitlementBaseInfo)) {
            return false;
        }
        EntitlementBaseInfo entitlementBaseInfo = (EntitlementBaseInfo) other;
        return Intrinsics.areEqual(this.entitlementId, entitlementBaseInfo.entitlementId) && Intrinsics.areEqual(this.userId, entitlementBaseInfo.userId) && Intrinsics.areEqual(this.productType, entitlementBaseInfo.productType) && Intrinsics.areEqual(this.quota, entitlementBaseInfo.quota) && Intrinsics.areEqual(this.startTime, entitlementBaseInfo.startTime) && Intrinsics.areEqual(this.endTime, entitlementBaseInfo.endTime) && Intrinsics.areEqual(this.productExtra, entitlementBaseInfo.productExtra) && Intrinsics.areEqual(this.chargeAmount, entitlementBaseInfo.chargeAmount) && Intrinsics.areEqual(this.currency, entitlementBaseInfo.currency) && Intrinsics.areEqual(this.productId, entitlementBaseInfo.productId) && Intrinsics.areEqual(this.entStatus, entitlementBaseInfo.entStatus);
    }

    public int hashCode() {
        String str = this.entitlementId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.userId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.productType;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        EntQuota entQuota = this.quota;
        int hashCode4 = (hashCode3 + (entQuota == null ? 0 : entQuota.hashCode())) * 31;
        Long l = this.startTime;
        int hashCode5 = (hashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.endTime;
        int hashCode6 = (hashCode5 + (l2 == null ? 0 : l2.hashCode())) * 31;
        EntProductExtra entProductExtra = this.productExtra;
        int hashCode7 = (hashCode6 + (entProductExtra == null ? 0 : entProductExtra.hashCode())) * 31;
        Long l3 = this.chargeAmount;
        int hashCode8 = (hashCode7 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Integer num2 = this.currency;
        int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l4 = this.productId;
        int hashCode10 = (hashCode9 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Integer num3 = this.entStatus;
        return hashCode10 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EntitlementBaseInfo(entitlementId=");
        sb.append(this.entitlementId).append(", userId=").append(this.userId).append(", productType=").append(this.productType).append(", quota=").append(this.quota).append(", startTime=").append(this.startTime).append(", endTime=").append(this.endTime).append(", productExtra=").append(this.productExtra).append(", chargeAmount=").append(this.chargeAmount).append(", currency=").append(this.currency).append(", productId=").append(this.productId).append(", entStatus=").append(this.entStatus).append(')');
        return sb.toString();
    }

    public EntitlementBaseInfo(String str, String str2, Integer num, EntQuota entQuota, Long l, Long l2, EntProductExtra entProductExtra, Long l3, Integer num2, Long l4, Integer num3) {
        this.entitlementId = str;
        this.userId = str2;
        this.productType = num;
        this.quota = entQuota;
        this.startTime = l;
        this.endTime = l2;
        this.productExtra = entProductExtra;
        this.chargeAmount = l3;
        this.currency = num2;
        this.productId = l4;
        this.entStatus = num3;
    }

    public /* synthetic */ EntitlementBaseInfo(String str, String str2, Integer num, EntQuota entQuota, Long l, Long l2, EntProductExtra entProductExtra, Long l3, Integer num2, Long l4, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : entQuota, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : l2, (i & 64) != 0 ? null : entProductExtra, (i & 128) != 0 ? null : l3, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : num2, (i & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? null : l4, (i & 1024) == 0 ? num3 : null);
    }

    public final String getEntitlementId() {
        return this.entitlementId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final Integer getProductType() {
        return this.productType;
    }

    public final EntQuota getQuota() {
        return this.quota;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final EntProductExtra getProductExtra() {
        return this.productExtra;
    }

    public final Long getChargeAmount() {
        return this.chargeAmount;
    }

    public final Integer getCurrency() {
        return this.currency;
    }

    public final Long getProductId() {
        return this.productId;
    }

    public final Integer getEntStatus() {
        return this.entStatus;
    }
}
