# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator;
.field public final synthetic f$2:Ljava/lang/String;
.field public final synthetic f$3:Ljava/lang/String;
.field public final synthetic f$4:Lcom/bytedance/trae/im/model/ParsedToolCallInfo;


.method public synthetic constructor <init>(java.lang.String  com.bytedance.trae.conversation.chat.toolcall.cards.detail.FallbackDetailCardCreator  java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedToolCallInfo)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator$$ExternalSyntheticLambda0;->f$2 Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator$$ExternalSyntheticLambda0;->f$3 Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator$$ExternalSyntheticLambda0;->f$4 Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator$$ExternalSyntheticLambda0;->f$2 Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator$$ExternalSyntheticLambda0;->f$3 Ljava/lang/String;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator$$ExternalSyntheticLambda0;->f$4 Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-object v5, v7
    check-cast v5, Landroid/view/View;
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator;->$r8$lambda$0oTzrMMcQMCTmWuS6ey4g32d0r8(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Landroid/view/View;)Lkotlin/Unit;
    move-result-object v7
    return-object v7
.end method
