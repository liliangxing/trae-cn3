# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.voice.ConversationStateMessage)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;
    check-cast v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1;->$r8$lambda$pAxFouyDVlNU-DNkbnZN2ZtAu7U(Lcom/bytedance/trae/conversation/voice/ConversationStateMessage; Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
