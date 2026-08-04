# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$MsgList;
.super Lkotlin/collections/AbstractList;
.source "ConversationViewModel.kt"

.field private final delegate:Ljava/util/List;


.method public constructor <init>(java.util.List)void
    .registers 3
    # ins_size=2
    const-string v0, "delegate"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lkotlin/collections/AbstractList;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$MsgList;->delegate Ljava/util/List;
    return-void 
.end method

.method public bridge contains(com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 2
    # ins_size=2
    invoke-super v0, v1, Lkotlin/collections/AbstractList;->contains(Ljava/lang/Object;)Z
    move-result v1
    return v1
.end method

.method public final bridge contains(java.lang.Object)boolean
    .registers 3
    # ins_size=2
    instance-of v0, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-nez v0, +004h
    const/4 v2, 0
    return v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$MsgList;->contains(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v2
    return v2
.end method

.method public equals(java.lang.Object)boolean
    .registers 2
    # ins_size=2
    if-ne v0, v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    return v1
.end method

.method public get(int)com.bytedance.trae.im.model.ParsedChatMessage
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$MsgList;->delegate Ljava/util/List;
    invoke-interface v0, v2, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    return-object v2
.end method

.method public bridge synthetic get(int)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$MsgList;->get(I)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v1
    return-object v1
.end method

.method public final getDelegate()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$MsgList;->delegate Ljava/util/List;
    return-object v0
.end method

.method public getSize()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$MsgList;->delegate Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    invoke-static v1, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I
    move-result v0
    return v0
.end method

.method public bridge indexOf(com.bytedance.trae.im.model.ParsedChatMessage)int
    .registers 2
    # ins_size=2
    invoke-super v0, v1, Lkotlin/collections/AbstractList;->indexOf(Ljava/lang/Object;)I
    move-result v1
    return v1
.end method

.method public final bridge indexOf(java.lang.Object)int
    .registers 3
    # ins_size=2
    instance-of v0, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-nez v0, +004h
    const/4 v2, -1
    return v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$MsgList;->indexOf(Lcom/bytedance/trae/im/model/ParsedChatMessage;)I
    move-result v2
    return v2
.end method

.method public bridge lastIndexOf(com.bytedance.trae.im.model.ParsedChatMessage)int
    .registers 2
    # ins_size=2
    invoke-super v0, v1, Lkotlin/collections/AbstractList;->lastIndexOf(Ljava/lang/Object;)I
    move-result v1
    return v1
.end method

.method public final bridge lastIndexOf(java.lang.Object)int
    .registers 3
    # ins_size=2
    instance-of v0, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-nez v0, +004h
    const/4 v2, -1
    return v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$MsgList;->lastIndexOf(Lcom/bytedance/trae/im/model/ParsedChatMessage;)I
    move-result v2
    return v2
.end method
