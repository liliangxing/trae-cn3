# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "MultiImagePreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $fileName:Ljava/lang/String;
.field final synthetic $url:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.MultiImagePreviewActivity  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;->$fileName Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;->$url Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;->$fileName Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;->$url Ljava/lang/String;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 13
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2ch
    new-instance v12, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v12, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v12
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v12
    check-cast v12, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1$cacheFile$1;
    iget-object v3, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    iget-object v4, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;->$url Ljava/lang/String;
    iget-object v5, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;->$fileName Ljava/lang/String;
    const/4 v6, 0
    invoke-direct v1, v3, v4, v5, v6, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1$cacheFile$1;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v3, v11
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;->label I
    invoke-static v12, v1, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v0, +003h
    return-object v0
    move-object v2, v12
    check-cast v2, Ljava/io/File;
    if-nez v2, +013h
    iget-object v12, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    move-object v0, v12
    check-cast v0, Landroid/content/Context;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_doc_preview_download_failed I
    invoke-virtual v12, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->getString(I)Ljava/lang/String;
    move-result-object v12
    invoke-static v0, v12, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; Ljava/lang/String;)V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
    iget-object v12, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v12, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getFileDownloadHelper$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    move-result-object v0
    iget-object v12, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    move-object v1, v12
    check-cast v1, Landroid/content/Context;
    const-string v3, ""
    iget-object v4, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;->$fileName Ljava/lang/String;
    check-cast v12, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v12, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v12
    move-object v5, v12
    check-cast v5, Lkotlinx/coroutines/CoroutineScope;
    iget-object v12, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v12, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getDownloadFinishCallback$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Lkotlin/jvm/functions/Function3;
    move-result-object v6
    const-wide/16 v7, 0
    const/16 v9, 64
    const/4 v10, 0
    invoke-static/range v0 ... v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->copyCachedFileAndLoading$default(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Ljava/io/File; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; J I Ljava/lang/Object;)V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
.end method
