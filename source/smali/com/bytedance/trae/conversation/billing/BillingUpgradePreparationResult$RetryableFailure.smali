# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;
.super Ljava/lang/Object;
.source "BillingUpgradePreparation.kt"

.implements Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult;

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;
    invoke-direct v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public equals(java.lang.Object)boolean
    .registers 4
    # ins_size=2
    const/4 v0, 1
    if-ne v2, v3, +003h
    return v0
    instance-of v1, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;
    if-nez v1, +004h
    const/4 v3, 0
    return v3
    check-cast v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePreparationResult$RetryableFailure;
    return v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    const v0, 839115845
    return v0
.end method

.method public toString()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "RetryableFailure"
    return-object v0
.end method
