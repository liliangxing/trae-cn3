# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;
.field public final synthetic f$1:Ljava/util/List;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.toolcall.cards.detail.ViewFileDetailCardCreator  java.util.List)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$$ExternalSyntheticLambda0;->f$1 Ljava/util/List;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator$$ExternalSyntheticLambda0;->f$1 Ljava/util/List;
    check-cast v3, Landroid/content/Context;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;->$r8$lambda$IhOUVR-N_Lb40flObedGMLax5bE(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator; Ljava/util/List; Landroid/content/Context;)Landroid/view/View;
    move-result-object v3
    return-object v3
.end method
