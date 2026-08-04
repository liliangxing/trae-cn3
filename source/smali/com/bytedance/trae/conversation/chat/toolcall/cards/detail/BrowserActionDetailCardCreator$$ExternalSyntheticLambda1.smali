# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator;
.field public final synthetic f$1:Ljava/util/List;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.toolcall.cards.detail.BrowserActionDetailCardCreator  java.util.List)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$$ExternalSyntheticLambda1;->f$1 Ljava/util/List;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$$ExternalSyntheticLambda1;->f$1 Ljava/util/List;
    check-cast v3, Landroid/content/Context;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator;->$r8$lambda$OOi28Ow7g25c7OVOozlBnH2I1RE(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator; Ljava/util/List; Landroid/content/Context;)Landroid/view/View;
    move-result-object v3
    return-object v3
.end method
