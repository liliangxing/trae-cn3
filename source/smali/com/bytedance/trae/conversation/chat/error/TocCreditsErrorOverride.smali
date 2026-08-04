# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;
.super Ljava/lang/Object;
.source "AgentErrorCodeRegistry.kt"

.field private final level:Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
.field private final messageResId:I
.field private final showInfoIcon:Z
.field private final titleResId:I


.method public constructor <init>(int  int  com.bytedance.trae.conversation.chat.error.AgentErrorLevel  boolean)void
    .registers 6
    # ins_size=5
    const-string v0, "level"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput v2, v1, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->messageResId I
    iput v3, v1, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->titleResId I
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    iput-boolean v5, v1, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->showInfoIcon Z
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.error.TocCreditsErrorOverride  int  int  com.bytedance.trae.conversation.chat.error.AgentErrorLevel  boolean  int  java.lang.Object)com.bytedance.trae.conversation.chat.error.TocCreditsErrorOverride
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget v1, v0, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->messageResId I
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget v2, v0, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->titleResId I
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-boolean v4, v0, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->showInfoIcon Z
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->copy(I I Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Z)Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;
    move-result-object v0
    return-object v0
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->messageResId I
    return v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->titleResId I
    return v0
.end method

.method public final component3()com.bytedance.trae.conversation.chat.error.AgentErrorLevel
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    return-object v0
.end method

.method public final component4()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->showInfoIcon Z
    return v0
.end method

.method public final copy(int  int  com.bytedance.trae.conversation.chat.error.AgentErrorLevel  boolean)com.bytedance.trae.conversation.chat.error.TocCreditsErrorOverride
    .registers 6
    # ins_size=5
    const-string v0, "level"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;-><init>(I I Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->messageResId I
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->messageResId I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->titleResId I
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->titleResId I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->showInfoIcon Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->showInfoIcon Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getLevel()com.bytedance.trae.conversation.chat.error.AgentErrorLevel
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    return-object v0
.end method

.method public final getMessageResId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->messageResId I
    return v0
.end method

.method public final getShowInfoIcon()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->showInfoIcon Z
    return v0
.end method

.method public final getTitleResId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->titleResId I
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->messageResId I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->titleResId I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->showInfoIcon Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TocCreditsErrorOverride(messageResId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->messageResId I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", titleResId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->titleResId I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", level="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", showInfoIcon="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;->showInfoIcon Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
