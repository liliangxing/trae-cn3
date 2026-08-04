# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/OnboardingState;
.super Ljava/lang/Object;
.source "CliListRepository.kt"

.field private final hasConversation:Z
.field private final hasRegisteredIDE:Z
.field private final hasRegisteredWork:Z


.method public constructor <init>(boolean  boolean  boolean)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/OnboardingState;->hasRegisteredWork Z
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/OnboardingState;->hasRegisteredIDE Z
    iput-boolean v3, v0, Lcom/bytedance/trae/conversation/OnboardingState;->hasConversation Z
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.OnboardingState  boolean  boolean  boolean  int  java.lang.Object)com.bytedance.trae.conversation.OnboardingState
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/OnboardingState;->hasRegisteredWork Z
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/OnboardingState;->hasRegisteredIDE Z
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-boolean v3, v0, Lcom/bytedance/trae/conversation/OnboardingState;->hasConversation Z
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/OnboardingState;->copy(Z Z Z)Lcom/bytedance/trae/conversation/OnboardingState;
    move-result-object v0
    return-object v0
.end method

.method public final component1()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/OnboardingState;->hasRegisteredWork Z
    return v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/OnboardingState;->hasRegisteredIDE Z
    return v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/OnboardingState;->hasConversation Z
    return v0
.end method

.method public final copy(boolean  boolean  boolean)com.bytedance.trae.conversation.OnboardingState
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/conversation/OnboardingState;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/OnboardingState;-><init>(Z Z Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/OnboardingState;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/OnboardingState;
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/OnboardingState;->hasRegisteredWork Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/OnboardingState;->hasRegisteredWork Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/OnboardingState;->hasRegisteredIDE Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/OnboardingState;->hasRegisteredIDE Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/OnboardingState;->hasConversation Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/OnboardingState;->hasConversation Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getHasConversation()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/OnboardingState;->hasConversation Z
    return v0
.end method

.method public final getHasRegisteredIDE()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/OnboardingState;->hasRegisteredIDE Z
    return v0
.end method

.method public final getHasRegisteredWork()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/OnboardingState;->hasRegisteredWork Z
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/OnboardingState;->hasRegisteredWork Z
    invoke-static v0, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/OnboardingState;->hasRegisteredIDE Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/OnboardingState;->hasConversation Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "OnboardingState(hasRegisteredWork="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/OnboardingState;->hasRegisteredWork Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", hasRegisteredIDE="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/OnboardingState;->hasRegisteredIDE Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", hasConversation="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/OnboardingState;->hasConversation Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
