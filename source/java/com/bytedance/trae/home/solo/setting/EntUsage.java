package com.bytedance.trae.home.solo.setting;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserEntStatusApi.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b*\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010-\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010.\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010/\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u009e\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nHÇ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u00104\u001a\u000205H×\u0001J\t\u00106\u001a\u000207H×\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0018\u0010\u0014R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0007\u0010\u0019R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u001a\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001f\u0010\u001cR\u001a\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b \u0010\u001cR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b!\u0010\u001cR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\"\u0010\u001cR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b#\u0010\u001c¨\u00068"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/EntUsage;", "", "advancedModelRequestUsage", "", "autoCompletionUsage", "premiumModelFastRequestUsage", "premiumModelSlowRequestUsage", "isFlashConsuming", "", "autoCompletionAmount", "", "advancedModelAmount", "premiumModelFastAmount", "premiumModelSlowAmount", "basicUsageAmount", "bonusUsageAmount", "creditsAmount", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getAdvancedModelRequestUsage", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAutoCompletionUsage", "getPremiumModelFastRequestUsage", "getPremiumModelSlowRequestUsage", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAutoCompletionAmount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAdvancedModelAmount", "getPremiumModelFastAmount", "getPremiumModelSlowAmount", "getBasicUsageAmount", "getBonusUsageAmount", "getCreditsAmount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lcom/bytedance/trae/home/solo/setting/EntUsage;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class EntUsage {
    public static final int $stable = 0;

    @SerializedName("advanced_model_amount")
    private final Double advancedModelAmount;

    @SerializedName("advanced_model_request_usage")
    private final Long advancedModelRequestUsage;

    @SerializedName("auto_completion_amount")
    private final Double autoCompletionAmount;

    @SerializedName("auto_completion_usage")
    private final Long autoCompletionUsage;

    @SerializedName("basic_usage_amount")
    private final Double basicUsageAmount;

    @SerializedName("bonus_usage_amount")
    private final Double bonusUsageAmount;

    @SerializedName("credits_amount")
    private final Double creditsAmount;

    @SerializedName("is_flash_consuming")
    private final Boolean isFlashConsuming;

    @SerializedName("premium_model_fast_amount")
    private final Double premiumModelFastAmount;

    @SerializedName("premium_model_fast_request_usage")
    private final Long premiumModelFastRequestUsage;

    @SerializedName("premium_model_slow_amount")
    private final Double premiumModelSlowAmount;

    @SerializedName("premium_model_slow_request_usage")
    private final Long premiumModelSlowRequestUsage;

    public EntUsage() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getAdvancedModelRequestUsage() {
        return this.advancedModelRequestUsage;
    }

    /* renamed from: component10, reason: from getter */
    public final Double getBasicUsageAmount() {
        return this.basicUsageAmount;
    }

    /* renamed from: component11, reason: from getter */
    public final Double getBonusUsageAmount() {
        return this.bonusUsageAmount;
    }

    /* renamed from: component12, reason: from getter */
    public final Double getCreditsAmount() {
        return this.creditsAmount;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getAutoCompletionUsage() {
        return this.autoCompletionUsage;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getPremiumModelFastRequestUsage() {
        return this.premiumModelFastRequestUsage;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getPremiumModelSlowRequestUsage() {
        return this.premiumModelSlowRequestUsage;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getIsFlashConsuming() {
        return this.isFlashConsuming;
    }

    /* renamed from: component6, reason: from getter */
    public final Double getAutoCompletionAmount() {
        return this.autoCompletionAmount;
    }

    /* renamed from: component7, reason: from getter */
    public final Double getAdvancedModelAmount() {
        return this.advancedModelAmount;
    }

    /* renamed from: component8, reason: from getter */
    public final Double getPremiumModelFastAmount() {
        return this.premiumModelFastAmount;
    }

    /* renamed from: component9, reason: from getter */
    public final Double getPremiumModelSlowAmount() {
        return this.premiumModelSlowAmount;
    }

    public final EntUsage copy(Long advancedModelRequestUsage, Long autoCompletionUsage, Long premiumModelFastRequestUsage, Long premiumModelSlowRequestUsage, Boolean isFlashConsuming, Double autoCompletionAmount, Double advancedModelAmount, Double premiumModelFastAmount, Double premiumModelSlowAmount, Double basicUsageAmount, Double bonusUsageAmount, Double creditsAmount) {
        return new EntUsage(advancedModelRequestUsage, autoCompletionUsage, premiumModelFastRequestUsage, premiumModelSlowRequestUsage, isFlashConsuming, autoCompletionAmount, advancedModelAmount, premiumModelFastAmount, premiumModelSlowAmount, basicUsageAmount, bonusUsageAmount, creditsAmount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntUsage)) {
            return false;
        }
        EntUsage entUsage = (EntUsage) other;
        return Intrinsics.areEqual(this.advancedModelRequestUsage, entUsage.advancedModelRequestUsage) && Intrinsics.areEqual(this.autoCompletionUsage, entUsage.autoCompletionUsage) && Intrinsics.areEqual(this.premiumModelFastRequestUsage, entUsage.premiumModelFastRequestUsage) && Intrinsics.areEqual(this.premiumModelSlowRequestUsage, entUsage.premiumModelSlowRequestUsage) && Intrinsics.areEqual(this.isFlashConsuming, entUsage.isFlashConsuming) && Intrinsics.areEqual((Object) this.autoCompletionAmount, (Object) entUsage.autoCompletionAmount) && Intrinsics.areEqual((Object) this.advancedModelAmount, (Object) entUsage.advancedModelAmount) && Intrinsics.areEqual((Object) this.premiumModelFastAmount, (Object) entUsage.premiumModelFastAmount) && Intrinsics.areEqual((Object) this.premiumModelSlowAmount, (Object) entUsage.premiumModelSlowAmount) && Intrinsics.areEqual((Object) this.basicUsageAmount, (Object) entUsage.basicUsageAmount) && Intrinsics.areEqual((Object) this.bonusUsageAmount, (Object) entUsage.bonusUsageAmount) && Intrinsics.areEqual((Object) this.creditsAmount, (Object) entUsage.creditsAmount);
    }

    public int hashCode() {
        Long l = this.advancedModelRequestUsage;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.autoCompletionUsage;
        int hashCode2 = (hashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.premiumModelFastRequestUsage;
        int hashCode3 = (hashCode2 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.premiumModelSlowRequestUsage;
        int hashCode4 = (hashCode3 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Boolean bool = this.isFlashConsuming;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Double d = this.autoCompletionAmount;
        int hashCode6 = (hashCode5 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.advancedModelAmount;
        int hashCode7 = (hashCode6 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.premiumModelFastAmount;
        int hashCode8 = (hashCode7 + (d3 == null ? 0 : d3.hashCode())) * 31;
        Double d4 = this.premiumModelSlowAmount;
        int hashCode9 = (hashCode8 + (d4 == null ? 0 : d4.hashCode())) * 31;
        Double d5 = this.basicUsageAmount;
        int hashCode10 = (hashCode9 + (d5 == null ? 0 : d5.hashCode())) * 31;
        Double d6 = this.bonusUsageAmount;
        int hashCode11 = (hashCode10 + (d6 == null ? 0 : d6.hashCode())) * 31;
        Double d7 = this.creditsAmount;
        return hashCode11 + (d7 != null ? d7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EntUsage(advancedModelRequestUsage=");
        sb.append(this.advancedModelRequestUsage).append(", autoCompletionUsage=").append(this.autoCompletionUsage).append(", premiumModelFastRequestUsage=").append(this.premiumModelFastRequestUsage).append(", premiumModelSlowRequestUsage=").append(this.premiumModelSlowRequestUsage).append(", isFlashConsuming=").append(this.isFlashConsuming).append(", autoCompletionAmount=").append(this.autoCompletionAmount).append(", advancedModelAmount=").append(this.advancedModelAmount).append(", premiumModelFastAmount=").append(this.premiumModelFastAmount).append(", premiumModelSlowAmount=").append(this.premiumModelSlowAmount).append(", basicUsageAmount=").append(this.basicUsageAmount).append(", bonusUsageAmount=").append(this.bonusUsageAmount).append(", creditsAmount=");
        sb.append(this.creditsAmount).append(')');
        return sb.toString();
    }

    public EntUsage(Long l, Long l2, Long l3, Long l4, Boolean bool, Double d, Double d2, Double d3, Double d4, Double d5, Double d6, Double d7) {
        this.advancedModelRequestUsage = l;
        this.autoCompletionUsage = l2;
        this.premiumModelFastRequestUsage = l3;
        this.premiumModelSlowRequestUsage = l4;
        this.isFlashConsuming = bool;
        this.autoCompletionAmount = d;
        this.advancedModelAmount = d2;
        this.premiumModelFastAmount = d3;
        this.premiumModelSlowAmount = d4;
        this.basicUsageAmount = d5;
        this.bonusUsageAmount = d6;
        this.creditsAmount = d7;
    }

    public /* synthetic */ EntUsage(Long l, Long l2, Long l3, Long l4, Boolean bool, Double d, Double d2, Double d3, Double d4, Double d5, Double d6, Double d7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) != 0 ? null : l3, (i & 8) != 0 ? null : l4, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : d, (i & 64) != 0 ? null : d2, (i & 128) != 0 ? null : d3, (i & 256) != 0 ? null : d4, (i & 512) != 0 ? null : d5, (i & 1024) != 0 ? null : d6, (i & 2048) == 0 ? d7 : null);
    }

    public final Long getAdvancedModelRequestUsage() {
        return this.advancedModelRequestUsage;
    }

    public final Long getAutoCompletionUsage() {
        return this.autoCompletionUsage;
    }

    public final Long getPremiumModelFastRequestUsage() {
        return this.premiumModelFastRequestUsage;
    }

    public final Long getPremiumModelSlowRequestUsage() {
        return this.premiumModelSlowRequestUsage;
    }

    public final Boolean isFlashConsuming() {
        return this.isFlashConsuming;
    }

    public final Double getAutoCompletionAmount() {
        return this.autoCompletionAmount;
    }

    public final Double getAdvancedModelAmount() {
        return this.advancedModelAmount;
    }

    public final Double getPremiumModelFastAmount() {
        return this.premiumModelFastAmount;
    }

    public final Double getPremiumModelSlowAmount() {
        return this.premiumModelSlowAmount;
    }

    public final Double getBasicUsageAmount() {
        return this.basicUsageAmount;
    }

    public final Double getBonusUsageAmount() {
        return this.bonusUsageAmount;
    }

    public final Double getCreditsAmount() {
        return this.creditsAmount;
    }
}
