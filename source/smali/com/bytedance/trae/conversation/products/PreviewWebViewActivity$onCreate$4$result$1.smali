# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4$result$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "PreviewWebViewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $chatSessionId:Ljava/lang/String;
.field final synthetic $cliType:Ljava/lang/String;
.field final synthetic $rawUrl:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.PreviewWebViewActivity  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4$result$1;->this$0 Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4$result$1;->$rawUrl Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4$result$1;->$chatSessionId Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4$result$1;->$cliType Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4$result$1;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4$result$1;->this$0 Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4$result$1;->$rawUrl Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4$result$1;->$chatSessionId Ljava/lang/String;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4$result$1;->$cliType Ljava/lang/String;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4$result$1;-><init>(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4$result$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4$result$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4$result$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4$result$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4$result$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +20h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4$result$1;->this$0 Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4$result$1;->$rawUrl Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4$result$1;->$chatSessionId Ljava/lang/String;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4$result$1;->$cliType Ljava/lang/String;
    move-object v5, v6
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v2, v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$onCreate$4$result$1;->label I
    invoke-static v7, v1, v3, v4, v5, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->access$resolvePreviewUrl(Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    return-object v7
.end method
