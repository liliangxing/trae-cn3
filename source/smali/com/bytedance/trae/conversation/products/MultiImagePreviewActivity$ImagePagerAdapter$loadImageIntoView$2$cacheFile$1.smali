# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "MultiImagePreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $target:Ljava/lang/String;
.field final synthetic $url:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.MultiImagePreviewActivity  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;->$url Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;->$target Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;->$url Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;->$target Ljava/lang/String;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 16
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v14, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +61h
    new-instance v15, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v15, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v15
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v15, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getFileDownloadHelper$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    move-result-object v3
    sget-object v15, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v15, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v15
    invoke-virtual v15, Landroid/app/Application;->getApplicationContext()Landroid/content/Context;
    move-result-object v4
    const-string v15, "getApplicationContext(...)"
    invoke-static v4, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v5, v14, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;->$url Ljava/lang/String;
    iget-object v15, v14, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v15, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getChatSessionId$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Ljava/lang/String;
    move-result-object v15
    const/4 v1, 0
    if-nez v15, +008h
    const-string v15, "chatSessionId"
    invoke-static v15, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v1
    check-cast v15, Ljava/lang/CharSequence;
    iget-object v6, v14, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v15, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v7
    if-eqz v7, +010h
    invoke-static v6, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getConversationId$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Ljava/lang/String;
    move-result-object v15
    if-nez v15, +008h
    const-string v15, "conversationId"
    invoke-static v15, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v15
    move-object v15, v1
    move-object v6, v15
    check-cast v6, Ljava/lang/String;
    iget-object v7, v14, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;->$target Ljava/lang/String;
    const/4 v8, 1
    const-wide/16 v9, 0
    move-object v11, v14
    check-cast v11, Lkotlin/coroutines/Continuation;
    const/16 v12, 32
    const/4 v13, 0
    iput v2, v14, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;->label I
    invoke-static/range v3 ... v13, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadToCache$default(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v15
    if-ne v15, v0, +003h
    return-object v0
    return-object v15
.end method
