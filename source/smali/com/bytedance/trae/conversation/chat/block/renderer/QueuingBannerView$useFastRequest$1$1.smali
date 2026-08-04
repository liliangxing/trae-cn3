# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "QueuingBannerView.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;


.method constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.QueuingBannerView  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$1;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$1;->label I
    if-nez v0, +018h
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;->getContext()Landroid/content/Context;
    move-result-object v3
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_network_disconnected I
    const/4 v1, 0
    invoke-static v3, v0, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v3
    invoke-virtual v3, Landroid/widget/Toast;->show()V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
    new-instance v3, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v3, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v3
.end method
