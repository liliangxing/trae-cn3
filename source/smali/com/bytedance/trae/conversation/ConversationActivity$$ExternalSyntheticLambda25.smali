# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda25;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/ConversationActivity;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/widget/ChatMode;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.ConversationActivity  com.bytedance.trae.conversation.widget.ChatMode)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda25;->f$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda25;->f$1 Lcom/bytedance/trae/conversation/widget/ChatMode;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda25;->f$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda25;->f$1 Lcom/bytedance/trae/conversation/widget/ChatMode;
    check-cast v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->$r8$lambda$nkqxBwZYStdiVDA2zFLc7ezWInY(Lcom/bytedance/trae/conversation/ConversationActivity; Lcom/bytedance/trae/conversation/widget/ChatMode; Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
