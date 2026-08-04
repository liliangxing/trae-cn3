# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$Companion$DIFF_CALLBACK$1;
.super Landroidx/recyclerview/widget/DiffUtil$ItemCallback;
.source "ChatMessageAdapter.kt"


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroidx/recyclerview/widget/DiffUtil$ItemCallback;-><init>()V
    return-void 
.end method

.method private final sameAssistantTask(com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 6
    # ins_size=3
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +046h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v0
    if-nez v0, +003h
    goto +3eh
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v4
    if-eqz v4, +039h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getTaskId()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +033h
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    const/4 v2, 0
    if-eqz v0, +003h
    goto +2h
    move-object v4, v2
    if-nez v4, +003h
    goto +21h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v5
    if-eqz v5, +01ch
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getTaskId()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +016h
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +003h
    move-object v2, v5
    if-nez v2, +003h
    goto +6h
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    return v4
    return v1
.end method

.method public areContentsTheSame(com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 13
    # ins_size=3
    const-string v0, "oldItem"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "newItem"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getSourcePhase()Lcom/bytedance/trae/im/model/MessageSourcePhase;
    move-result-object v0
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v1
    const-string v2, ", sourcePhase="
    const/4 v3, 1
    const-string v4, ", sameRef="
    const-string v5, "AgentDataFlow"
    const/4 v6, 0
    if-eqz v1, +03bh
    sget-object v1, Lcom/bytedance/trae/im/model/MessageSourcePhase;->FETCHED Lcom/bytedance/trae/im/model/MessageSourcePhase;
    if-eq v0, v1, +037h
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v1
    if-eqz v1, +02eh
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v8, "[Node5] areContentsTheSame FORCE_FALSE: msgId="
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    if-ne v11, v12, +003h
    goto +2h
    move v3, v6
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v1, v5, v11, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return v6
    invoke-static v11, v12, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    sget-object v7, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v7, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v7
    if-eqz v7, +038h
    sget-object v7, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v9, "[Node5] areContentsTheSame result="
    invoke-direct v8, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, ": msgId="
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    if-ne v11, v12, +003h
    goto +2h
    move v3, v6
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v7, v5, v11, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return v1
.end method

.method public bridge synthetic areContentsTheSame(java.lang.Object  java.lang.Object)boolean
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$Companion$DIFF_CALLBACK$1;->areContentsTheSame(Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v1
    return v1
.end method

.method public areItemsTheSame(com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 5
    # ins_size=3
    const-string v0, "oldItem"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "newItem"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00bh
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$Companion$DIFF_CALLBACK$1;->sameAssistantTask(Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v3
    if-eqz v3, +003h
    goto +3h
    const/4 v3, 0
    goto +2h
    const/4 v3, 1
    return v3
.end method

.method public bridge synthetic areItemsTheSame(java.lang.Object  java.lang.Object)boolean
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$Companion$DIFF_CALLBACK$1;->areItemsTheSame(Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v1
    return v1
.end method

.method public getChangePayload(com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.im.model.ParsedChatMessage)java.lang.Object
    .registers 4
    # ins_size=3
    const-string v0, "oldItem"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "newItem"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v2
    if-eqz v2, +00ch
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v2
    if-eqz v2, +006h
    const-string/jumbo v2, streaming_update
    goto +2h
    const/4 v2, 0
    return-object v2
.end method

.method public bridge synthetic getChangePayload(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$Companion$DIFF_CALLBACK$1;->getChangePayload(Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/model/ParsedChatMessage;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method
