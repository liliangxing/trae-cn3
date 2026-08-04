# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda5;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.ConversationViewModel)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda5;->f$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda5;->f$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    check-cast v2, Ljava/lang/String;
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->$r8$lambda$HDpXcdYGkve2Fbx6SmAP7XtqD-8(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
