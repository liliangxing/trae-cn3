# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/MessageManager;
.super Ljava/lang/Object;
.source "MessageManager.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/MessageManager;
.field private static final conversationListeners:Ljava/util/List;
.field private static final listeners:Ljava/util/List;
.field private static final revertListeners:Ljava/util/List;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/MessageManager;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/MessageManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/MessageManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/MessageManager;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    sput-object v0, Lcom/bytedance/trae/conversation/chat/MessageManager;->listeners Ljava/util/List;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    sput-object v0, Lcom/bytedance/trae/conversation/chat/MessageManager;->conversationListeners Ljava/util/List;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    sput-object v0, Lcom/bytedance/trae/conversation/chat/MessageManager;->revertListeners Ljava/util/List;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final addDeleteConversationListener(com.bytedance.trae.conversation.chat.MessageManager$IDeleteConversation)void
    .registers 4
    # ins_size=2
    const-string v0, "listener"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/MessageManager;->conversationListeners Ljava/util/List;
    invoke-interface v0, v3, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +005h
    invoke-interface v0, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final addDeleteMessageListener(com.bytedance.trae.conversation.chat.MessageManager$IDeleteMessage)void
    .registers 4
    # ins_size=2
    const-string v0, "listener"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/MessageManager;->listeners Ljava/util/List;
    invoke-interface v0, v3, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +005h
    invoke-interface v0, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final addRevertMessageListener(com.bytedance.trae.conversation.chat.MessageManager$IRevertMessage)void
    .registers 4
    # ins_size=2
    const-string v0, "listener"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/MessageManager;->revertListeners Ljava/util/List;
    invoke-interface v0, v3, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +005h
    invoke-interface v0, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final notifyConversationDeleted(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string v0, "conversationId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/MessageManager;->conversationListeners Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/MessageManager$IDeleteConversation;
    invoke-interface v1, v3, Lcom/bytedance/trae/conversation/chat/MessageManager$IDeleteConversation;->onMessageDeleted(Ljava/lang/String;)V
    goto -fh
    return-void 
.end method

.method public final notifyMessageDeleted(java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=3
    const-string v0, "conversationId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/MessageManager;->listeners Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/MessageManager$IDeleteMessage;
    invoke-interface v1, v3, v4, Lcom/bytedance/trae/conversation/chat/MessageManager$IDeleteMessage;->onMessageDeleted(Ljava/lang/String; Ljava/lang/String;)V
    goto -fh
    return-void 
.end method

.method public final notifyMessageReverted(java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 6
    # ins_size=4
    const-string v0, "conversationId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/MessageManager;->revertListeners Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/MessageManager$IRevertMessage;
    invoke-interface v1, v3, v4, v5, Lcom/bytedance/trae/conversation/chat/MessageManager$IRevertMessage;->onMessageReverted(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    goto -fh
    return-void 
.end method

.method public final removeDeleteConversationListener(com.bytedance.trae.conversation.chat.MessageManager$IDeleteConversation)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/MessageManager;->conversationListeners Ljava/util/List;
    invoke-interface v0, v2, Ljava/util/List;->remove(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final removeDeleteMessageListener(com.bytedance.trae.conversation.chat.MessageManager$IDeleteMessage)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/MessageManager;->listeners Ljava/util/List;
    invoke-interface v0, v2, Ljava/util/List;->remove(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final removeRevertMessageListener(com.bytedance.trae.conversation.chat.MessageManager$IRevertMessage)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/MessageManager;->revertListeners Ljava/util/List;
    invoke-interface v0, v2, Ljava/util/List;->remove(Ljava/lang/Object;)Z
    return-void 
.end method
