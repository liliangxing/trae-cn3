# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.toolcall.cards.detail.SearchDetailCardCreator)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;
    check-cast v2, Landroid/content/Context;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;->$r8$lambda$hmtPxND1KO0UXQbmw-fftekWCyk(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator; Landroid/content/Context;)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method
