# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;
.super Ljava/lang/Object;
.source "BillingUpgradePromptEngine.kt"

.field private attempts:I
.field private pendingPromptData:Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
.field private pendingRestored:Z
.field private preparation:Lkotlinx/coroutines/Deferred;
.field private promptShownInProcess:Z
.field private terminal:Z


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
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;-><init>(I Z Z Z Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData; Lkotlinx/coroutines/Deferred; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(int  boolean  boolean  boolean  com.bytedance.trae.conversation.billing.BillingUpgradePromptData  kotlinx.coroutines.Deferred)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->attempts I
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->terminal Z
    iput-boolean v3, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->promptShownInProcess Z
    iput-boolean v4, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->pendingRestored Z
    iput-object v5, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->pendingPromptData Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->preparation Lkotlinx/coroutines/Deferred;
    return-void 
.end method

.method public synthetic constructor <init>(int  boolean  boolean  boolean  com.bytedance.trae.conversation.billing.BillingUpgradePromptData  kotlinx.coroutines.Deferred  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    const/4 v0, 0
    if-eqz v12, +004h
    move v12, v0
    goto +2h
    move v12, v5
    and-int/lit8 v5, v11, 2
    if-eqz v5, +004h
    move v1, v0
    goto +2h
    move v1, v6
    and-int/lit8 v5, v11, 4
    if-eqz v5, +004h
    move v2, v0
    goto +2h
    move v2, v7
    and-int/lit8 v5, v11, 8
    if-eqz v5, +003h
    goto +2h
    move v0, v8
    and-int/lit8 v5, v11, 16
    const/4 v6, 0
    if-eqz v5, +004h
    move-object v3, v6
    goto +2h
    move-object v3, v9
    and-int/lit8 v5, v11, 32
    if-eqz v5, +004h
    move-object v11, v6
    goto +2h
    move-object v11, v10
    move-object v5, v4
    move v6, v12
    move v7, v1
    move v8, v2
    move v9, v0
    move-object v10, v3
    invoke-direct/range v5 ... v11, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;-><init>(I Z Z Z Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData; Lkotlinx/coroutines/Deferred;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine$Entry  int  boolean  boolean  boolean  com.bytedance.trae.conversation.billing.BillingUpgradePromptData  kotlinx.coroutines.Deferred  int  java.lang.Object)com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine$Entry
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +004h
    iget v5, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->attempts I
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    iget-boolean v6, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->terminal Z
    move v12, v6
    and-int/lit8 v6, v11, 4
    if-eqz v6, +004h
    iget-boolean v7, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->promptShownInProcess Z
    move v0, v7
    and-int/lit8 v6, v11, 8
    if-eqz v6, +004h
    iget-boolean v8, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->pendingRestored Z
    move v1, v8
    and-int/lit8 v6, v11, 16
    if-eqz v6, +004h
    iget-object v9, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->pendingPromptData Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    move-object v2, v9
    and-int/lit8 v6, v11, 32
    if-eqz v6, +004h
    iget-object v10, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->preparation Lkotlinx/coroutines/Deferred;
    move-object v3, v10
    move-object v6, v4
    move v7, v5
    move v8, v12
    move v9, v0
    move v10, v1
    move-object v11, v2
    move-object v12, v3
    invoke-virtual/range v6 ... v12, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->copy(I Z Z Z Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData; Lkotlinx/coroutines/Deferred;)Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;
    move-result-object v4
    return-object v4
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->attempts I
    return v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->terminal Z
    return v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->promptShownInProcess Z
    return v0
.end method

.method public final component4()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->pendingRestored Z
    return v0
.end method

.method public final component5()com.bytedance.trae.conversation.billing.BillingUpgradePromptData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->pendingPromptData Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    return-object v0
.end method

.method public final component6()kotlinx.coroutines.Deferred
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->preparation Lkotlinx/coroutines/Deferred;
    return-object v0
.end method

.method public final copy(int  boolean  boolean  boolean  com.bytedance.trae.conversation.billing.BillingUpgradePromptData  kotlinx.coroutines.Deferred)com.bytedance.trae.conversation.billing.BillingUpgradePromptEngine$Entry
    .registers 15
    # ins_size=7
    new-instance v7, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;
    move-object v0, v7
    move v1, v9
    move v2, v10
    move v3, v11
    move v4, v12
    move-object v5, v13
    move-object v6, v14
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;-><init>(I Z Z Z Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData; Lkotlinx/coroutines/Deferred;)V
    return-object v7
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;
    iget v1, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->attempts I
    iget v3, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->attempts I
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->terminal Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->terminal Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->promptShownInProcess Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->promptShownInProcess Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->pendingRestored Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->pendingRestored Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->pendingPromptData Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->pendingPromptData Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->preparation Lkotlinx/coroutines/Deferred;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->preparation Lkotlinx/coroutines/Deferred;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAttempts()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->attempts I
    return v0
.end method

.method public final getPendingPromptData()com.bytedance.trae.conversation.billing.BillingUpgradePromptData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->pendingPromptData Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    return-object v0
.end method

.method public final getPendingRestored()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->pendingRestored Z
    return v0
.end method

.method public final getPreparation()kotlinx.coroutines.Deferred
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->preparation Lkotlinx/coroutines/Deferred;
    return-object v0
.end method

.method public final getPromptShownInProcess()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->promptShownInProcess Z
    return v0
.end method

.method public final getTerminal()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->terminal Z
    return v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget v0, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->attempts I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->terminal Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->promptShownInProcess Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->pendingRestored Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->pendingPromptData Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->preparation Lkotlinx/coroutines/Deferred;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public final setAttempts(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->attempts I
    return-void 
.end method

.method public final setPendingPromptData(com.bytedance.trae.conversation.billing.BillingUpgradePromptData)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->pendingPromptData Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    return-void 
.end method

.method public final setPendingRestored(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->pendingRestored Z
    return-void 
.end method

.method public final setPreparation(kotlinx.coroutines.Deferred)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->preparation Lkotlinx/coroutines/Deferred;
    return-void 
.end method

.method public final setPromptShownInProcess(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->promptShownInProcess Z
    return-void 
.end method

.method public final setTerminal(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->terminal Z
    return-void 
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Entry(attempts="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->attempts I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", terminal="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->terminal Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", promptShownInProcess="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->promptShownInProcess Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", pendingRestored="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->pendingRestored Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", pendingPromptData="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->pendingPromptData Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptData;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", preparation="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptEngine$Entry;->preparation Lkotlinx/coroutines/Deferred;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
