# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;
.super Ljava/lang/Object;
.source "UserEntStatusApi.kt"

.field public static final $stable:I
.field private final code:Ljava/lang/Integer;
.field private final isDollarUsageBilling:Ljava/lang/Boolean;
.field private final isPayFreshman:Ljava/lang/Boolean;
.field private final message:Ljava/lang/String;
.field private final trialStatus:Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;
.field private final userEntitlementPackList:Ljava/util/List;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 10
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 63
    const/4 v8, 0
    move-object v0, v9
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;-><init>(Ljava/util/List; Ljava/lang/Boolean; Ljava/lang/Boolean; Lcom/bytedance/trae/home/solo/setting/EntTrialStatus; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.util.List  java.lang.Boolean  java.lang.Boolean  com.bytedance.trae.home.solo.setting.EntTrialStatus  java.lang.Integer  java.lang.String)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->userEntitlementPackList Ljava/util/List;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->isPayFreshman Ljava/lang/Boolean;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->isDollarUsageBilling Ljava/lang/Boolean;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->trialStatus Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->code Ljava/lang/Integer;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->message Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.util.List  java.lang.Boolean  java.lang.Boolean  com.bytedance.trae.home.solo.setting.EntTrialStatus  java.lang.Integer  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 14
    # ins_size=9
    and-int/lit8 v13, v12, 1
    const/4 v0, 0
    if-eqz v13, +004h
    move-object v13, v0
    goto +2h
    move-object v13, v6
    and-int/lit8 v6, v12, 2
    if-eqz v6, +004h
    move-object v1, v0
    goto +2h
    move-object v1, v7
    and-int/lit8 v6, v12, 4
    if-eqz v6, +004h
    move-object v2, v0
    goto +2h
    move-object v2, v8
    and-int/lit8 v6, v12, 8
    if-eqz v6, +004h
    move-object v3, v0
    goto +2h
    move-object v3, v9
    and-int/lit8 v6, v12, 16
    if-eqz v6, +004h
    move-object v4, v0
    goto +2h
    move-object v4, v10
    and-int/lit8 v6, v12, 32
    if-eqz v6, +004h
    move-object v12, v0
    goto +2h
    move-object v12, v11
    move-object v6, v5
    move-object v7, v13
    move-object v8, v1
    move-object v9, v2
    move-object v10, v3
    move-object v11, v4
    invoke-direct/range v6 ... v12, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;-><init>(Ljava/util/List; Ljava/lang/Boolean; Ljava/lang/Boolean; Lcom/bytedance/trae/home/solo/setting/EntTrialStatus; Ljava/lang/Integer; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.UserEntStatusResponse  java.util.List  java.lang.Boolean  java.lang.Boolean  com.bytedance.trae.home.solo.setting.EntTrialStatus  java.lang.Integer  java.lang.String  int  java.lang.Object)com.bytedance.trae.home.solo.setting.UserEntStatusResponse
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +004h
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->userEntitlementPackList Ljava/util/List;
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    iget-object v6, v4, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->isPayFreshman Ljava/lang/Boolean;
    move-object v12, v6
    and-int/lit8 v6, v11, 4
    if-eqz v6, +004h
    iget-object v7, v4, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->isDollarUsageBilling Ljava/lang/Boolean;
    move-object v0, v7
    and-int/lit8 v6, v11, 8
    if-eqz v6, +004h
    iget-object v8, v4, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->trialStatus Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;
    move-object v1, v8
    and-int/lit8 v6, v11, 16
    if-eqz v6, +004h
    iget-object v9, v4, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->code Ljava/lang/Integer;
    move-object v2, v9
    and-int/lit8 v6, v11, 32
    if-eqz v6, +004h
    iget-object v10, v4, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->message Ljava/lang/String;
    move-object v3, v10
    move-object v6, v4
    move-object v7, v5
    move-object v8, v12
    move-object v9, v0
    move-object v10, v1
    move-object v11, v2
    move-object v12, v3
    invoke-virtual/range v6 ... v12, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->copy(Ljava/util/List; Ljava/lang/Boolean; Ljava/lang/Boolean; Lcom/bytedance/trae/home/solo/setting/EntTrialStatus; Ljava/lang/Integer; Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;
    move-result-object v4
    return-object v4
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->userEntitlementPackList Ljava/util/List;
    return-object v0
.end method

.method public final component2()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->isPayFreshman Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component3()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->isDollarUsageBilling Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component4()com.bytedance.trae.home.solo.setting.EntTrialStatus
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->trialStatus Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;
    return-object v0
.end method

.method public final component5()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->code Ljava/lang/Integer;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->message Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.util.List  java.lang.Boolean  java.lang.Boolean  com.bytedance.trae.home.solo.setting.EntTrialStatus  java.lang.Integer  java.lang.String)com.bytedance.trae.home.solo.setting.UserEntStatusResponse
    .registers 15
    # ins_size=7
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;
    move-object v0, v7
    move-object v1, v9
    move-object v2, v10
    move-object v3, v11
    move-object v4, v12
    move-object v5, v13
    move-object v6, v14
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;-><init>(Ljava/util/List; Ljava/lang/Boolean; Ljava/lang/Boolean; Lcom/bytedance/trae/home/solo/setting/EntTrialStatus; Ljava/lang/Integer; Ljava/lang/String;)V
    return-object v7
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->userEntitlementPackList Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->userEntitlementPackList Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->isPayFreshman Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->isPayFreshman Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->isDollarUsageBilling Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->isDollarUsageBilling Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->trialStatus Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->trialStatus Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->code Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->code Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->message Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->message Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCode()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->code Ljava/lang/Integer;
    return-object v0
.end method

.method public final getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->message Ljava/lang/String;
    return-object v0
.end method

.method public final getTrialStatus()com.bytedance.trae.home.solo.setting.EntTrialStatus
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->trialStatus Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;
    return-object v0
.end method

.method public final getUserEntitlementPackList()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->userEntitlementPackList Ljava/util/List;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->userEntitlementPackList Ljava/util/List;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->isPayFreshman Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->isDollarUsageBilling Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->trialStatus Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->code Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->message Ljava/lang/String;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isDollarUsageBilling()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->isDollarUsageBilling Ljava/lang/Boolean;
    return-object v0
.end method

.method public final isPayFreshman()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->isPayFreshman Ljava/lang/Boolean;
    return-object v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "UserEntStatusResponse(userEntitlementPackList="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->userEntitlementPackList Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isPayFreshman="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->isPayFreshman Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isDollarUsageBilling="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->isDollarUsageBilling Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", trialStatus="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->trialStatus Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", code="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->code Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", message="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;->message Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
