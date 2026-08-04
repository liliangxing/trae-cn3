# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator;
.field public final synthetic f$1:Lcom/bytedance/trae/im/model/ParsedToolCallInfo;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.toolcall.cards.detail.EnvironmentSetupDetailCardCreator  com.bytedance.trae.im.model.ParsedToolCallInfo)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    check-cast v3, Landroid/view/View;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator;->$r8$lambda$ySp_EHfmRpZVc3UwrNOshS5GlWw(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Landroid/view/View;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
