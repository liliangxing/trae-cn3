package com.bytedance.trae.home.solo.setting;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserEntStatusApi.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b7\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bß\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010;\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010=\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010>\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010@\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010A\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJæ\u0001\u0010C\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÇ\u0001¢\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020\b2\b\u0010F\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010G\u001a\u00020\u0011H×\u0001J\t\u0010H\u001a\u00020IH×\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u001aR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001e\u0010\u001aR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\"\u0010 R\u001a\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b#\u0010 R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b$\u0010 R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b%\u0010\u001aR\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b&\u0010\u001aR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b'\u0010 R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b(\u0010 R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b,\u0010 R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b-\u0010 R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b.\u0010 R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b/\u0010 R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b0\u0010\u001a¨\u0006J"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/EntQuota;", "", "advancedModelRequestLimit", "", "autoCompletionLimit", "premiumModelFastRequestLimit", "premiumModelSlowRequestLimit", "enableSuperModel", "", "enableSoloBuilder", "enableSoloCoder", "enableSoloBuilderV1", "basicUsageLimit", "bonusUsageLimit", "enableEarlyAccess", "enableSoloAgent", "soloAgentParallelLimit", "", "enableSoloWeb", "enableSoloLite", "noBonusQuota", "enableRalphLoop", "creditsLimit", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;)V", "getAdvancedModelRequestLimit", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAutoCompletionLimit", "getPremiumModelFastRequestLimit", "getPremiumModelSlowRequestLimit", "getEnableSuperModel", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableSoloBuilder", "getEnableSoloCoder", "getEnableSoloBuilderV1", "getBasicUsageLimit", "getBonusUsageLimit", "getEnableEarlyAccess", "getEnableSoloAgent", "getSoloAgentParallelLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEnableSoloWeb", "getEnableSoloLite", "getNoBonusQuota", "getEnableRalphLoop", "getCreditsLimit", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;)Lcom/bytedance/trae/home/solo/setting/EntQuota;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class EntQuota {
    public static final int $stable = 0;

    @SerializedName("advanced_model_request_limit")
    private final Long advancedModelRequestLimit;

    @SerializedName("auto_completion_limit")
    private final Long autoCompletionLimit;

    @SerializedName("basic_usage_limit")
    private final Long basicUsageLimit;

    @SerializedName("bonus_usage_limit")
    private final Long bonusUsageLimit;

    @SerializedName("credits_limit")
    private final Long creditsLimit;

    @SerializedName("enable_early_access")
    private final Boolean enableEarlyAccess;

    @SerializedName("enable_ralph_loop")
    private final Boolean enableRalphLoop;

    @SerializedName("enable_solo_agent")
    private final Boolean enableSoloAgent;

    @SerializedName("enable_solo_builder")
    private final Boolean enableSoloBuilder;

    @SerializedName("enable_solo_builder_v1")
    private final Boolean enableSoloBuilderV1;

    @SerializedName("enable_solo_coder")
    private final Boolean enableSoloCoder;

    @SerializedName("enable_solo_lite")
    private final Boolean enableSoloLite;

    @SerializedName("enable_solo_web")
    private final Boolean enableSoloWeb;

    @SerializedName("enable_super_model")
    private final Boolean enableSuperModel;

    @SerializedName("no_bonus_quota")
    private final Boolean noBonusQuota;

    @SerializedName("premium_model_fast_request_limit")
    private final Long premiumModelFastRequestLimit;

    @SerializedName("premium_model_slow_request_limit")
    private final Long premiumModelSlowRequestLimit;

    @SerializedName("solo_agent_parallel_limit")
    private final Integer soloAgentParallelLimit;

    public EntQuota() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getAdvancedModelRequestLimit() {
        return this.advancedModelRequestLimit;
    }

    /* renamed from: component10, reason: from getter */
    public final Long getBonusUsageLimit() {
        return this.bonusUsageLimit;
    }

    /* renamed from: component11, reason: from getter */
    public final Boolean getEnableEarlyAccess() {
        return this.enableEarlyAccess;
    }

    /* renamed from: component12, reason: from getter */
    public final Boolean getEnableSoloAgent() {
        return this.enableSoloAgent;
    }

    /* renamed from: component13, reason: from getter */
    public final Integer getSoloAgentParallelLimit() {
        return this.soloAgentParallelLimit;
    }

    /* renamed from: component14, reason: from getter */
    public final Boolean getEnableSoloWeb() {
        return this.enableSoloWeb;
    }

    /* renamed from: component15, reason: from getter */
    public final Boolean getEnableSoloLite() {
        return this.enableSoloLite;
    }

    /* renamed from: component16, reason: from getter */
    public final Boolean getNoBonusQuota() {
        return this.noBonusQuota;
    }

    /* renamed from: component17, reason: from getter */
    public final Boolean getEnableRalphLoop() {
        return this.enableRalphLoop;
    }

    /* renamed from: component18, reason: from getter */
    public final Long getCreditsLimit() {
        return this.creditsLimit;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getAutoCompletionLimit() {
        return this.autoCompletionLimit;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getPremiumModelFastRequestLimit() {
        return this.premiumModelFastRequestLimit;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getPremiumModelSlowRequestLimit() {
        return this.premiumModelSlowRequestLimit;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getEnableSuperModel() {
        return this.enableSuperModel;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getEnableSoloBuilder() {
        return this.enableSoloBuilder;
    }

    /* renamed from: component7, reason: from getter */
    public final Boolean getEnableSoloCoder() {
        return this.enableSoloCoder;
    }

    /* renamed from: component8, reason: from getter */
    public final Boolean getEnableSoloBuilderV1() {
        return this.enableSoloBuilderV1;
    }

    /* renamed from: component9, reason: from getter */
    public final Long getBasicUsageLimit() {
        return this.basicUsageLimit;
    }

    public final EntQuota copy(Long advancedModelRequestLimit, Long autoCompletionLimit, Long premiumModelFastRequestLimit, Long premiumModelSlowRequestLimit, Boolean enableSuperModel, Boolean enableSoloBuilder, Boolean enableSoloCoder, Boolean enableSoloBuilderV1, Long basicUsageLimit, Long bonusUsageLimit, Boolean enableEarlyAccess, Boolean enableSoloAgent, Integer soloAgentParallelLimit, Boolean enableSoloWeb, Boolean enableSoloLite, Boolean noBonusQuota, Boolean enableRalphLoop, Long creditsLimit) {
        return new EntQuota(advancedModelRequestLimit, autoCompletionLimit, premiumModelFastRequestLimit, premiumModelSlowRequestLimit, enableSuperModel, enableSoloBuilder, enableSoloCoder, enableSoloBuilderV1, basicUsageLimit, bonusUsageLimit, enableEarlyAccess, enableSoloAgent, soloAgentParallelLimit, enableSoloWeb, enableSoloLite, noBonusQuota, enableRalphLoop, creditsLimit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntQuota)) {
            return false;
        }
        EntQuota entQuota = (EntQuota) other;
        return Intrinsics.areEqual(this.advancedModelRequestLimit, entQuota.advancedModelRequestLimit) && Intrinsics.areEqual(this.autoCompletionLimit, entQuota.autoCompletionLimit) && Intrinsics.areEqual(this.premiumModelFastRequestLimit, entQuota.premiumModelFastRequestLimit) && Intrinsics.areEqual(this.premiumModelSlowRequestLimit, entQuota.premiumModelSlowRequestLimit) && Intrinsics.areEqual(this.enableSuperModel, entQuota.enableSuperModel) && Intrinsics.areEqual(this.enableSoloBuilder, entQuota.enableSoloBuilder) && Intrinsics.areEqual(this.enableSoloCoder, entQuota.enableSoloCoder) && Intrinsics.areEqual(this.enableSoloBuilderV1, entQuota.enableSoloBuilderV1) && Intrinsics.areEqual(this.basicUsageLimit, entQuota.basicUsageLimit) && Intrinsics.areEqual(this.bonusUsageLimit, entQuota.bonusUsageLimit) && Intrinsics.areEqual(this.enableEarlyAccess, entQuota.enableEarlyAccess) && Intrinsics.areEqual(this.enableSoloAgent, entQuota.enableSoloAgent) && Intrinsics.areEqual(this.soloAgentParallelLimit, entQuota.soloAgentParallelLimit) && Intrinsics.areEqual(this.enableSoloWeb, entQuota.enableSoloWeb) && Intrinsics.areEqual(this.enableSoloLite, entQuota.enableSoloLite) && Intrinsics.areEqual(this.noBonusQuota, entQuota.noBonusQuota) && Intrinsics.areEqual(this.enableRalphLoop, entQuota.enableRalphLoop) && Intrinsics.areEqual(this.creditsLimit, entQuota.creditsLimit);
    }

    public int hashCode() {
        Long l = this.advancedModelRequestLimit;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.autoCompletionLimit;
        int hashCode2 = (hashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.premiumModelFastRequestLimit;
        int hashCode3 = (hashCode2 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.premiumModelSlowRequestLimit;
        int hashCode4 = (hashCode3 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Boolean bool = this.enableSuperModel;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.enableSoloBuilder;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.enableSoloCoder;
        int hashCode7 = (hashCode6 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.enableSoloBuilderV1;
        int hashCode8 = (hashCode7 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Long l5 = this.basicUsageLimit;
        int hashCode9 = (hashCode8 + (l5 == null ? 0 : l5.hashCode())) * 31;
        Long l6 = this.bonusUsageLimit;
        int hashCode10 = (hashCode9 + (l6 == null ? 0 : l6.hashCode())) * 31;
        Boolean bool5 = this.enableEarlyAccess;
        int hashCode11 = (hashCode10 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.enableSoloAgent;
        int hashCode12 = (hashCode11 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Integer num = this.soloAgentParallelLimit;
        int hashCode13 = (hashCode12 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool7 = this.enableSoloWeb;
        int hashCode14 = (hashCode13 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Boolean bool8 = this.enableSoloLite;
        int hashCode15 = (hashCode14 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
        Boolean bool9 = this.noBonusQuota;
        int hashCode16 = (hashCode15 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
        Boolean bool10 = this.enableRalphLoop;
        int hashCode17 = (hashCode16 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
        Long l7 = this.creditsLimit;
        return hashCode17 + (l7 != null ? l7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EntQuota(advancedModelRequestLimit=");
        sb.append(this.advancedModelRequestLimit).append(", autoCompletionLimit=").append(this.autoCompletionLimit).append(", premiumModelFastRequestLimit=").append(this.premiumModelFastRequestLimit).append(", premiumModelSlowRequestLimit=").append(this.premiumModelSlowRequestLimit).append(", enableSuperModel=").append(this.enableSuperModel).append(", enableSoloBuilder=").append(this.enableSoloBuilder).append(", enableSoloCoder=").append(this.enableSoloCoder).append(", enableSoloBuilderV1=").append(this.enableSoloBuilderV1).append(", basicUsageLimit=").append(this.basicUsageLimit).append(", bonusUsageLimit=").append(this.bonusUsageLimit).append(", enableEarlyAccess=").append(this.enableEarlyAccess).append(", enableSoloAgent=");
        sb.append(this.enableSoloAgent).append(", soloAgentParallelLimit=").append(this.soloAgentParallelLimit).append(", enableSoloWeb=").append(this.enableSoloWeb).append(", enableSoloLite=").append(this.enableSoloLite).append(", noBonusQuota=").append(this.noBonusQuota).append(", enableRalphLoop=").append(this.enableRalphLoop).append(", creditsLimit=").append(this.creditsLimit).append(')');
        return sb.toString();
    }

    public EntQuota(Long l, Long l2, Long l3, Long l4, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Long l5, Long l6, Boolean bool5, Boolean bool6, Integer num, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Long l7) {
        this.advancedModelRequestLimit = l;
        this.autoCompletionLimit = l2;
        this.premiumModelFastRequestLimit = l3;
        this.premiumModelSlowRequestLimit = l4;
        this.enableSuperModel = bool;
        this.enableSoloBuilder = bool2;
        this.enableSoloCoder = bool3;
        this.enableSoloBuilderV1 = bool4;
        this.basicUsageLimit = l5;
        this.bonusUsageLimit = l6;
        this.enableEarlyAccess = bool5;
        this.enableSoloAgent = bool6;
        this.soloAgentParallelLimit = num;
        this.enableSoloWeb = bool7;
        this.enableSoloLite = bool8;
        this.noBonusQuota = bool9;
        this.enableRalphLoop = bool10;
        this.creditsLimit = l7;
    }

    public /* synthetic */ EntQuota(Long l, Long l2, Long l3, Long l4, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Long l5, Long l6, Boolean bool5, Boolean bool6, Integer num, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Long l7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) != 0 ? null : l3, (i & 8) != 0 ? null : l4, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : bool2, (i & 64) != 0 ? null : bool3, (i & 128) != 0 ? null : bool4, (i & 256) != 0 ? null : l5, (i & 512) != 0 ? null : l6, (i & 1024) != 0 ? null : bool5, (i & 2048) != 0 ? null : bool6, (i & 4096) != 0 ? null : num, (i & 8192) != 0 ? null : bool7, (i & 16384) != 0 ? null : bool8, (i & 32768) != 0 ? null : bool9, (i & 65536) != 0 ? null : bool10, (i & 131072) != 0 ? null : l7);
    }

    public final Long getAdvancedModelRequestLimit() {
        return this.advancedModelRequestLimit;
    }

    public final Long getAutoCompletionLimit() {
        return this.autoCompletionLimit;
    }

    public final Long getPremiumModelFastRequestLimit() {
        return this.premiumModelFastRequestLimit;
    }

    public final Long getPremiumModelSlowRequestLimit() {
        return this.premiumModelSlowRequestLimit;
    }

    public final Boolean getEnableSuperModel() {
        return this.enableSuperModel;
    }

    public final Boolean getEnableSoloBuilder() {
        return this.enableSoloBuilder;
    }

    public final Boolean getEnableSoloCoder() {
        return this.enableSoloCoder;
    }

    public final Boolean getEnableSoloBuilderV1() {
        return this.enableSoloBuilderV1;
    }

    public final Long getBasicUsageLimit() {
        return this.basicUsageLimit;
    }

    public final Long getBonusUsageLimit() {
        return this.bonusUsageLimit;
    }

    public final Boolean getEnableEarlyAccess() {
        return this.enableEarlyAccess;
    }

    public final Boolean getEnableSoloAgent() {
        return this.enableSoloAgent;
    }

    public final Integer getSoloAgentParallelLimit() {
        return this.soloAgentParallelLimit;
    }

    public final Boolean getEnableSoloWeb() {
        return this.enableSoloWeb;
    }

    public final Boolean getEnableSoloLite() {
        return this.enableSoloLite;
    }

    public final Boolean getNoBonusQuota() {
        return this.noBonusQuota;
    }

    public final Boolean getEnableRalphLoop() {
        return this.enableRalphLoop;
    }

    public final Long getCreditsLimit() {
        return this.creditsLimit;
    }
}
