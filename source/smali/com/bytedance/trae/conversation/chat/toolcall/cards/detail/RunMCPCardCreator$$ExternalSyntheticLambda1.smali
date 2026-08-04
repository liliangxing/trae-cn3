# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;
.field public final synthetic f$1:Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
.field public final synthetic f$2:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.toolcall.cards.detail.RunMCPCardCreator  com.bytedance.trae.im.model.ParsedToolCallInfo  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator$$ExternalSyntheticLambda1;->f$2 Ljava/lang/String;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator$$ExternalSyntheticLambda1;->f$2 Ljava/lang/String;
    check-cast v4, Landroid/view/View;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;->$r8$lambda$fVld9UJb2zf66DZOj-me0jn0f38(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Ljava/lang/String; Landroid/view/View;)Lkotlin/Unit;
    move-result-object v4
    return-object v4
.end method
