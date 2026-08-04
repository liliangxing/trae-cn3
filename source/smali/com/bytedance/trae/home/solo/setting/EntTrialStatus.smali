# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;
.super Ljava/lang/Object;
.source "UserEntStatusApi.kt"

.field public static final $stable:I
.field private final isEligibleForTrial:Ljava/lang/Boolean;
.field private final isInTrial:Ljava/lang/Boolean;
.field private final trialEndTime:Ljava/lang/Long;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 7
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 7
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;-><init>(Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.Boolean  java.lang.Boolean  java.lang.Long)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->isInTrial Ljava/lang/Boolean;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->isEligibleForTrial Ljava/lang/Boolean;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->trialEndTime Ljava/lang/Long;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.Boolean  java.lang.Boolean  java.lang.Long  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=6
    and-int/lit8 v6, v5, 1
    const/4 v0, 0
    if-eqz v6, +003h
    move-object v2, v0
    and-int/lit8 v6, v5, 2
    if-eqz v6, +003h
    move-object v3, v0
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    move-object v4, v0
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;-><init>(Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.EntTrialStatus  java.lang.Boolean  java.lang.Boolean  java.lang.Long  int  java.lang.Object)com.bytedance.trae.home.solo.setting.EntTrialStatus
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->isInTrial Ljava/lang/Boolean;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->isEligibleForTrial Ljava/lang/Boolean;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->trialEndTime Ljava/lang/Long;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->copy(Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long;)Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->isInTrial Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component2()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->isEligibleForTrial Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component3()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->trialEndTime Ljava/lang/Long;
    return-object v0
.end method

.method public final copy(java.lang.Boolean  java.lang.Boolean  java.lang.Long)com.bytedance.trae.home.solo.setting.EntTrialStatus
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;-><init>(Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->isInTrial Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->isInTrial Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->isEligibleForTrial Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->isEligibleForTrial Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->trialEndTime Ljava/lang/Long;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->trialEndTime Ljava/lang/Long;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getTrialEndTime()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->trialEndTime Ljava/lang/Long;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->isInTrial Ljava/lang/Boolean;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->isEligibleForTrial Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->trialEndTime Ljava/lang/Long;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isEligibleForTrial()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->isEligibleForTrial Ljava/lang/Boolean;
    return-object v0
.end method

.method public final isInTrial()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->isInTrial Ljava/lang/Boolean;
    return-object v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "EntTrialStatus(isInTrial="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->isInTrial Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isEligibleForTrial="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->isEligibleForTrial Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", trialEndTime="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;->trialEndTime Ljava/lang/Long;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
