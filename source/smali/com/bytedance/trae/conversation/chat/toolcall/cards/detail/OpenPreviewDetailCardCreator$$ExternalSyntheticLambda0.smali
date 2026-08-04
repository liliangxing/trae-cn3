# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
.field public final synthetic f$3:Lcom/bytedance/trae/im/model/ParsedToolCallInfo;


.method public synthetic constructor <init>(java.lang.String  com.bytedance.trae.conversation.chat.toolcall.cards.detail.OpenPreviewDetailCardCreator  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext  com.bytedance.trae.im.model.ParsedToolCallInfo)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator$$ExternalSyntheticLambda0;->f$2 Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator$$ExternalSyntheticLambda0;->f$3 Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator$$ExternalSyntheticLambda0;->f$2 Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator$$ExternalSyntheticLambda0;->f$3 Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    check-cast v5, Landroid/view/View;
    invoke-static v0, v1, v2, v3, v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator;->$r8$lambda$0HSD9txBv-V_mSetWpo8IpsVSMU(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Landroid/view/View;)Lkotlin/Unit;
    move-result-object v5
    return-object v5
.end method
