# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;
.super Ljava/lang/Object;
.source "ConversationActivity.kt"

.field private final chatMode:Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
.field private final eventContext:Lcom/bytedance/trae/conversation/tracker/AIEventContext;
.field private final sendContext:Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;


.method public constructor <init>(com.bytedance.trae.conversation.tracker.AIEventContext  com.bytedance.trae.conversation.tracker.AISendMessageContext  com.bytedance.trae.conversation.tracker.SoloChatMode)void
    .registers 5
    # ins_size=4
    const-string v0, "eventContext"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sendContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chatMode"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->eventContext Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->sendContext Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->chatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.ConversationActivity$PendingTriggerTracker  com.bytedance.trae.conversation.tracker.AIEventContext  com.bytedance.trae.conversation.tracker.AISendMessageContext  com.bytedance.trae.conversation.tracker.SoloChatMode  int  java.lang.Object)com.bytedance.trae.conversation.ConversationActivity$PendingTriggerTracker
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->eventContext Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->sendContext Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->chatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->copy(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Lcom/bytedance/trae/conversation/tracker/AISendMessageContext; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.tracker.AIEventContext
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->eventContext Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.conversation.tracker.AISendMessageContext
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->sendContext Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    return-object v0
.end method

.method public final component3()com.bytedance.trae.conversation.tracker.SoloChatMode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->chatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.conversation.tracker.AIEventContext  com.bytedance.trae.conversation.tracker.AISendMessageContext  com.bytedance.trae.conversation.tracker.SoloChatMode)com.bytedance.trae.conversation.ConversationActivity$PendingTriggerTracker
    .registers 5
    # ins_size=4
    const-string v0, "eventContext"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sendContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chatMode"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;-><init>(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Lcom/bytedance/trae/conversation/tracker/AISendMessageContext; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->eventContext Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->eventContext Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->sendContext Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->sendContext Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->chatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->chatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getChatMode()com.bytedance.trae.conversation.tracker.SoloChatMode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->chatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    return-object v0
.end method

.method public final getEventContext()com.bytedance.trae.conversation.tracker.AIEventContext
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->eventContext Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    return-object v0
.end method

.method public final getSendContext()com.bytedance.trae.conversation.tracker.AISendMessageContext
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->sendContext Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->eventContext Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/AIEventContext;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->sendContext Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->chatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "PendingTriggerTracker(eventContext="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->eventContext Lcom/bytedance/trae/conversation/tracker/AIEventContext;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", sendContext="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->sendContext Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", chatMode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$PendingTriggerTracker;->chatMode Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
