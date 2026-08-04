# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/google/gson/JsonElement;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:Lcom/google/gson/JsonArray;
.field public final synthetic f$3:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator;


.method public synthetic constructor <init>(com.google.gson.JsonElement  java.lang.String  com.google.gson.JsonArray  com.bytedance.trae.conversation.chat.toolcall.cards.detail.AskUserQuestionCardCreator)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator$$ExternalSyntheticLambda0;->f$0 Lcom/google/gson/JsonElement;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator$$ExternalSyntheticLambda0;->f$1 Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator$$ExternalSyntheticLambda0;->f$2 Lcom/google/gson/JsonArray;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator$$ExternalSyntheticLambda0;->f$3 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator$$ExternalSyntheticLambda0;->f$0 Lcom/google/gson/JsonElement;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator$$ExternalSyntheticLambda0;->f$1 Ljava/lang/String;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator$$ExternalSyntheticLambda0;->f$2 Lcom/google/gson/JsonArray;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator$$ExternalSyntheticLambda0;->f$3 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator;
    check-cast v5, Landroid/content/Context;
    invoke-static v0, v1, v2, v3, v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator;->$r8$lambda$9zL3_SXPmNrhu3xBipKyJKhWNRA(Lcom/google/gson/JsonElement; Ljava/lang/String; Lcom/google/gson/JsonArray; Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator; Landroid/content/Context;)Landroid/widget/LinearLayout;
    move-result-object v5
    return-object v5
.end method
