# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/RenameConversationResponse;
.super Ljava/lang/Object;
.source "IRenameConversationService.kt"

.field private final conversation:Lcom/bytedance/trae/im/service/Conversation;


.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 1
    invoke-direct v2, v0, v1, v0, Lcom/bytedance/trae/im/service/RenameConversationResponse;-><init>(Lcom/bytedance/trae/im/service/Conversation; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.im.service.Conversation)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/service/RenameConversationResponse;->conversation Lcom/bytedance/trae/im/service/Conversation;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.im.service.Conversation  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/im/service/RenameConversationResponse;-><init>(Lcom/bytedance/trae/im/service/Conversation;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.RenameConversationResponse  com.bytedance.trae.im.service.Conversation  int  java.lang.Object)com.bytedance.trae.im.service.RenameConversationResponse
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/RenameConversationResponse;->conversation Lcom/bytedance/trae/im/service/Conversation;
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/service/RenameConversationResponse;->copy(Lcom/bytedance/trae/im/service/Conversation;)Lcom/bytedance/trae/im/service/RenameConversationResponse;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.im.service.Conversation
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/RenameConversationResponse;->conversation Lcom/bytedance/trae/im/service/Conversation;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.im.service.Conversation)com.bytedance.trae.im.service.RenameConversationResponse
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/im/service/RenameConversationResponse;
    invoke-direct v0, v2, Lcom/bytedance/trae/im/service/RenameConversationResponse;-><init>(Lcom/bytedance/trae/im/service/Conversation;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/im/service/RenameConversationResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/im/service/RenameConversationResponse;
    iget-object v1, v3, Lcom/bytedance/trae/im/service/RenameConversationResponse;->conversation Lcom/bytedance/trae/im/service/Conversation;
    iget-object v4, v4, Lcom/bytedance/trae/im/service/RenameConversationResponse;->conversation Lcom/bytedance/trae/im/service/Conversation;
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    return v2
    return v0
.end method

.method public final getConversation()com.bytedance.trae.im.service.Conversation
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/RenameConversationResponse;->conversation Lcom/bytedance/trae/im/service/Conversation;
    return-object v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/RenameConversationResponse;->conversation Lcom/bytedance/trae/im/service/Conversation;
    if-nez v0, +004h
    const/4 v0, 0
    goto +5h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->hashCode()I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "RenameConversationResponse(conversation="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/service/RenameConversationResponse;->conversation Lcom/bytedance/trae/im/service/Conversation;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
