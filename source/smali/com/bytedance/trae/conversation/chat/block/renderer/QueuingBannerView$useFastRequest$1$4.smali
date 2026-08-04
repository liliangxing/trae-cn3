# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$4;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "QueuingBannerView.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $messageId:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;


.method constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.QueuingBannerView  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$4;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$4;->$messageId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$4;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$4;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$4;->$messageId Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$4;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$4;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$4;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$4;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$4;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$4;->label I
    if-nez v0, +04ah
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v3, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->INSTANCE Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/ExpressPassBenefitManager;->notifyBenefitEnable()V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$4;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getQueryItem()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getOriginMessage()Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v3
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$4;->$messageId Ljava/lang/String;
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +005h
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$4;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getQueryItem()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getOriginMessage()Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$4;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getQueryItem()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->getRequestUUid()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;->usePayRight(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$4;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;
    const/16 v0, 8
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->setVisibility(I)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
    new-instance v3, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v3, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v3
.end method
