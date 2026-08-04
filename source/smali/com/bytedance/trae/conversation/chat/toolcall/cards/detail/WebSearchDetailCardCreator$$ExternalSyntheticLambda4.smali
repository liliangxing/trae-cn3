# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;
.field public final synthetic f$1:Landroid/content/Context;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$WebSearchResult;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.toolcall.cards.detail.WebSearchDetailCardCreator  android.content.Context  com.bytedance.trae.conversation.chat.toolcall.cards.detail.WebSearchDetailCardCreator$WebSearchResult)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$$ExternalSyntheticLambda4;->f$0 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$$ExternalSyntheticLambda4;->f$1 Landroid/content/Context;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$$ExternalSyntheticLambda4;->f$2 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$WebSearchResult;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$$ExternalSyntheticLambda4;->f$0 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$$ExternalSyntheticLambda4;->f$1 Landroid/content/Context;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$$ExternalSyntheticLambda4;->f$2 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$WebSearchResult;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;->$r8$lambda$mpJdbaO6ESQShiIJRdAfMNGN-vg(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator$WebSearchResult; Landroid/view/View;)V
    return-void 
.end method
