# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;
.super Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
.source "AgentContentBlock.kt"

.field private final error:Lcom/bytedance/trae/im/model/ParsedError;
.field private final isLatestAgent:Z
.field private final varargs onActionClick:Lkotlin/jvm/functions/Function1;
.field private final originMessage:Lcom/bytedance/trae/im/model/ParsedChatMessage;


.method public constructor <init>(com.bytedance.trae.im.model.ParsedError  boolean  com.bytedance.trae.im.model.ParsedChatMessage  kotlin.jvm.functions.Function1)void
    .registers 6
    # ins_size=5
    const-string v0, "error"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "originMessage"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->error Lcom/bytedance/trae/im/model/ParsedError;
    iput-boolean v3, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->isLatestAgent Z
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->originMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->onActionClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.im.model.ParsedError  boolean  com.bytedance.trae.im.model.ParsedChatMessage  kotlin.jvm.functions.Function1  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 2
    if-eqz v6, +003h
    const/4 v2, 0
    and-int/lit8 v5, v5, 8
    if-eqz v5, +003h
    const/4 v4, 0
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;-><init>(Lcom/bytedance/trae/im/model/ParsedError; Z Lcom/bytedance/trae/im/model/ParsedChatMessage; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.AgentContentBlock$FreeActivityQuotaError  com.bytedance.trae.im.model.ParsedError  boolean  com.bytedance.trae.im.model.ParsedChatMessage  kotlin.jvm.functions.Function1  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.AgentContentBlock$FreeActivityQuotaError
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->error Lcom/bytedance/trae/im/model/ParsedError;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->isLatestAgent Z
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->originMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->onActionClick Lkotlin/jvm/functions/Function1;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->copy(Lcom/bytedance/trae/im/model/ParsedError; Z Lcom/bytedance/trae/im/model/ParsedChatMessage; Lkotlin/jvm/functions/Function1;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.im.model.ParsedError
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->error Lcom/bytedance/trae/im/model/ParsedError;
    return-object v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->isLatestAgent Z
    return v0
.end method

.method public final component3()com.bytedance.trae.im.model.ParsedChatMessage
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->originMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    return-object v0
.end method

.method public final component4()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->onActionClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.im.model.ParsedError  boolean  com.bytedance.trae.im.model.ParsedChatMessage  kotlin.jvm.functions.Function1)com.bytedance.trae.conversation.chat.block.AgentContentBlock$FreeActivityQuotaError
    .registers 6
    # ins_size=5
    const-string v0, "error"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "originMessage"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;-><init>(Lcom/bytedance/trae/im/model/ParsedError; Z Lcom/bytedance/trae/im/model/ParsedChatMessage; Lkotlin/jvm/functions/Function1;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->error Lcom/bytedance/trae/im/model/ParsedError;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->error Lcom/bytedance/trae/im/model/ParsedError;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->isLatestAgent Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->isLatestAgent Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->originMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->originMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->onActionClick Lkotlin/jvm/functions/Function1;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->onActionClick Lkotlin/jvm/functions/Function1;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getError()com.bytedance.trae.im.model.ParsedError
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->error Lcom/bytedance/trae/im/model/ParsedError;
    return-object v0
.end method

.method public final getOnActionClick()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->onActionClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOriginMessage()com.bytedance.trae.im.model.ParsedChatMessage
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->originMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->error Lcom/bytedance/trae/im/model/ParsedError;
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedError;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->isLatestAgent Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->originMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->onActionClick Lkotlin/jvm/functions/Function1;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isLatestAgent()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->isLatestAgent Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "FreeActivityQuotaError(error="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->error Lcom/bytedance/trae/im/model/ParsedError;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isLatestAgent="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->isLatestAgent Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", originMessage="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->originMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", onActionClick="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;->onActionClick Lkotlin/jvm/functions/Function1;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
