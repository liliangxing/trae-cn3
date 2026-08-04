# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/OnboardingStateResult;
.super Ljava/lang/Object;
.source "CliListRepository.kt"

.field private final isSuccess:Z
.field private final state:Lcom/bytedance/trae/conversation/OnboardingState;


.method public constructor <init>(com.bytedance.trae.conversation.OnboardingState  boolean)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/OnboardingStateResult;->state Lcom/bytedance/trae/conversation/OnboardingState;
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/OnboardingStateResult;->isSuccess Z
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.OnboardingStateResult  com.bytedance.trae.conversation.OnboardingState  boolean  int  java.lang.Object)com.bytedance.trae.conversation.OnboardingStateResult
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/OnboardingStateResult;->state Lcom/bytedance/trae/conversation/OnboardingState;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/OnboardingStateResult;->isSuccess Z
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/OnboardingStateResult;->copy(Lcom/bytedance/trae/conversation/OnboardingState; Z)Lcom/bytedance/trae/conversation/OnboardingStateResult;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.OnboardingState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/OnboardingStateResult;->state Lcom/bytedance/trae/conversation/OnboardingState;
    return-object v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/OnboardingStateResult;->isSuccess Z
    return v0
.end method

.method public final copy(com.bytedance.trae.conversation.OnboardingState  boolean)com.bytedance.trae.conversation.OnboardingStateResult
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/OnboardingStateResult;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/OnboardingStateResult;-><init>(Lcom/bytedance/trae/conversation/OnboardingState; Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/OnboardingStateResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/OnboardingStateResult;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/OnboardingStateResult;->state Lcom/bytedance/trae/conversation/OnboardingState;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/OnboardingStateResult;->state Lcom/bytedance/trae/conversation/OnboardingState;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/OnboardingStateResult;->isSuccess Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/OnboardingStateResult;->isSuccess Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getState()com.bytedance.trae.conversation.OnboardingState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/OnboardingStateResult;->state Lcom/bytedance/trae/conversation/OnboardingState;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/OnboardingStateResult;->state Lcom/bytedance/trae/conversation/OnboardingState;
    if-nez v0, +004h
    const/4 v0, 0
    goto +5h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/OnboardingState;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/OnboardingStateResult;->isSuccess Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isSuccess()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/OnboardingStateResult;->isSuccess Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "OnboardingStateResult(state="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/OnboardingStateResult;->state Lcom/bytedance/trae/conversation/OnboardingState;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isSuccess="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/OnboardingStateResult;->isSuccess Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
