# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;
.super Ljava/lang/Object;
.source "AgentErrorCodeRegistry.kt"

.field private final level:Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
.field private final message:Ljava/lang/String;
.field private final showInfoIcon:Z
.field private final title:Ljava/lang/String;


.method public constructor <init>(java.lang.String  com.bytedance.trae.conversation.chat.error.AgentErrorLevel  java.lang.String  boolean)void
    .registers 6
    # ins_size=5
    const-string v0, "message"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "level"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->message Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->title Ljava/lang/String;
    iput-boolean v5, v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->showInfoIcon Z
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  com.bytedance.trae.conversation.chat.error.AgentErrorLevel  java.lang.String  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 4
    if-eqz v6, +003h
    const/4 v3, 0
    and-int/lit8 v5, v5, 8
    if-eqz v5, +003h
    const/4 v4, 0
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/String; Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.error.AgentErrorCodeRegistry$DisplayResult  java.lang.String  com.bytedance.trae.conversation.chat.error.AgentErrorLevel  java.lang.String  boolean  int  java.lang.Object)com.bytedance.trae.conversation.chat.error.AgentErrorCodeRegistry$DisplayResult
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->message Ljava/lang/String;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->title Ljava/lang/String;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-boolean v4, v0, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->showInfoIcon Z
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->copy(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/String; Z)Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->message Ljava/lang/String;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.conversation.chat.error.AgentErrorLevel
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->title Ljava/lang/String;
    return-object v0
.end method

.method public final component4()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->showInfoIcon Z
    return v0
.end method

.method public final copy(java.lang.String  com.bytedance.trae.conversation.chat.error.AgentErrorLevel  java.lang.String  boolean)com.bytedance.trae.conversation.chat.error.AgentErrorCodeRegistry$DisplayResult
    .registers 6
    # ins_size=5
    const-string v0, "message"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "level"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/String; Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->message Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->message Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->title Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->title Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->showInfoIcon Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->showInfoIcon Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getLevel()com.bytedance.trae.conversation.chat.error.AgentErrorLevel
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    return-object v0
.end method

.method public final getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->message Ljava/lang/String;
    return-object v0
.end method

.method public final getShowInfoIcon()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->showInfoIcon Z
    return v0
.end method

.method public final getTitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->title Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->message Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->title Ljava/lang/String;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->showInfoIcon Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "DisplayResult(message="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->message Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", level="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", title="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->title Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", showInfoIcon="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;->showInfoIcon Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
