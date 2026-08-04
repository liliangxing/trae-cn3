# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "InputPreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $fileUrl:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/InputPreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.InputPreviewActivity  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1;->$fileUrl Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1;->$fileUrl Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1;->label I
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +29h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v7
    check-cast v7, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1$content$1;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    iget-object v5, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1;->$fileUrl Ljava/lang/String;
    invoke-direct v1, v4, v5, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1$content$1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v4, v6
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v2, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1;->label I
    invoke-static v7, v1, v4, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    check-cast v7, Ljava/lang/String;
    iget-object v0, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getProgressBar$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Landroid/widget/ProgressBar;
    move-result-object v0
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    if-eqz v7, +02bh
    iget-object v0, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getScrollTxt$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Landroid/widget/ScrollView;
    move-result-object v0
    if-nez v0, +009h
    const-string/jumbo v0, scrollTxt
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/ScrollView;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getTvTxt$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Landroid/widget/TextView;
    move-result-object v0
    if-nez v0, +009h
    const-string/jumbo v0, tvTxt
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v0
    check-cast v7, Ljava/lang/CharSequence;
    invoke-virtual v3, v7, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto +6h
    iget-object v7, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$showError(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method
