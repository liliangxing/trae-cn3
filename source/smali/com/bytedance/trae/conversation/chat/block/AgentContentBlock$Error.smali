# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;
.super Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
.source "AgentContentBlock.kt"

.field private final displayMessage:Ljava/lang/String;
.field private final displayTitle:Ljava/lang/String;
.field private final error:Lcom/bytedance/trae/im/model/ParsedError;
.field private final level:Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
.field private final showInfoIcon:Z


.method public constructor <init>(com.bytedance.trae.im.model.ParsedError  java.lang.String  com.bytedance.trae.conversation.chat.error.AgentErrorLevel  java.lang.String  boolean)void
    .registers 7
    # ins_size=6
    const-string v0, "error"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "displayMessage"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "level"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->error Lcom/bytedance/trae/im/model/ParsedError;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->displayMessage Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->displayTitle Ljava/lang/String;
    iput-boolean v6, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->showInfoIcon Z
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.im.model.ParsedError  java.lang.String  com.bytedance.trae.conversation.chat.error.AgentErrorLevel  java.lang.String  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 8
    if-eqz v13, +003h
    const/4 v10, 0
    move-object v4, v10
    and-int/lit8 v10, v12, 16
    if-eqz v10, +003h
    const/4 v11, 0
    move v5, v11
    move-object v0, v6
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;-><init>(Lcom/bytedance/trae/im/model/ParsedError; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/String; Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Error  com.bytedance.trae.im.model.ParsedError  java.lang.String  com.bytedance.trae.conversation.chat.error.AgentErrorLevel  java.lang.String  boolean  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.AgentContentBlock$Error
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->error Lcom/bytedance/trae/im/model/ParsedError;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget-object v5, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->displayMessage Ljava/lang/String;
    move-object v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-object v6, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    move-object v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-object v7, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->displayTitle Ljava/lang/String;
    move-object v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget-boolean v8, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->showInfoIcon Z
    move v2, v8
    move-object v5, v3
    move-object v6, v4
    move-object v7, v10
    move-object v8, v0
    move-object v9, v1
    move v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->copy(Lcom/bytedance/trae/im/model/ParsedError; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/String; Z)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;
    move-result-object v3
    return-object v3
.end method

.method public final component1()com.bytedance.trae.im.model.ParsedError
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->error Lcom/bytedance/trae/im/model/ParsedError;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->displayMessage Ljava/lang/String;
    return-object v0
.end method

.method public final component3()com.bytedance.trae.conversation.chat.error.AgentErrorLevel
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->displayTitle Ljava/lang/String;
    return-object v0
.end method

.method public final component5()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->showInfoIcon Z
    return v0
.end method

.method public final copy(com.bytedance.trae.im.model.ParsedError  java.lang.String  com.bytedance.trae.conversation.chat.error.AgentErrorLevel  java.lang.String  boolean)com.bytedance.trae.conversation.chat.block.AgentContentBlock$Error
    .registers 13
    # ins_size=6
    const-string v0, "error"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "displayMessage"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "level"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;
    move-object v1, v0
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    move-object v5, v11
    move v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;-><init>(Lcom/bytedance/trae/im/model/ParsedError; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel; Ljava/lang/String; Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->error Lcom/bytedance/trae/im/model/ParsedError;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->error Lcom/bytedance/trae/im/model/ParsedError;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->displayMessage Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->displayMessage Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->displayTitle Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->displayTitle Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->showInfoIcon Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->showInfoIcon Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getDisplayMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->displayMessage Ljava/lang/String;
    return-object v0
.end method

.method public final getDisplayTitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->displayTitle Ljava/lang/String;
    return-object v0
.end method

.method public final getError()com.bytedance.trae.im.model.ParsedError
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->error Lcom/bytedance/trae/im/model/ParsedError;
    return-object v0
.end method

.method public final getLevel()com.bytedance.trae.conversation.chat.error.AgentErrorLevel
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    return-object v0
.end method

.method public final getShowInfoIcon()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->showInfoIcon Z
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->error Lcom/bytedance/trae/im/model/ParsedError;
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedError;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->displayMessage Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->displayTitle Ljava/lang/String;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->showInfoIcon Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Error(error="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->error Lcom/bytedance/trae/im/model/ParsedError;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", displayMessage="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->displayMessage Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", level="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->level Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", displayTitle="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->displayTitle Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", showInfoIcon="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;->showInfoIcon Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
