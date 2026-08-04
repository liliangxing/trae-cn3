# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation$WhenMappings;
.super Ljava/lang/Object;
.source "TocCreditsObservation.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I
.field public static final synthetic $EnumSwitchMapping$1:[I


.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;->values()[Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;->PromptEligible Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;->ordinal()I
    move-result v2
    aput v1, v0, v2
    const/4 v2, 2
    sget-object v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;->SilentRecovery Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationMode;->ordinal()I
    move-result v3
    aput v2, v0, v3
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-static Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;->values()[Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v3, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;->Tea Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;->ordinal()I
    move-result v3
    aput v1, v0, v3
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;->Slardar Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;->ordinal()I
    move-result v1
    aput v2, v0, v1
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/TocCreditsObservation$WhenMappings;->$EnumSwitchMapping$1 [I
    return-void 
    :try_start_0x8
    :try_start_0x11
    :try_start_0x22
    :try_start_0x2a
.end method
