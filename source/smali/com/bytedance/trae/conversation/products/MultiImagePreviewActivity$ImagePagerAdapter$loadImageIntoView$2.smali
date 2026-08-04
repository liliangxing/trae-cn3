# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "MultiImagePreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $holder:Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
.field final synthetic $path:Ljava/lang/String;
.field final synthetic $url:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
.field final synthetic this$1:Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;


.method constructor <init>(java.lang.String  com.bytedance.trae.conversation.products.MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder  com.bytedance.trae.conversation.products.MultiImagePreviewActivity$ImagePagerAdapter  com.bytedance.trae.conversation.products.MultiImagePreviewActivity  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->$path Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->$holder Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->this$1 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->$url Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->$path Ljava/lang/String;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->$holder Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->this$1 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->$url Ljava/lang/String;
    move-object v0, v8
    move-object v6, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder; Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter; Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +32h
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v8, Lcom/bytedance/trae/conversation/products/LocalArtifactPath;->INSTANCE Lcom/bytedance/trae/conversation/products/LocalArtifactPath;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->$path Ljava/lang/String;
    invoke-virtual v8, v1, Lcom/bytedance/trae/conversation/products/LocalArtifactPath;->requestTarget(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    new-instance v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->this$1 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->$url Ljava/lang/String;
    const/4 v6, 0
    invoke-direct v3, v4, v5, v8, v6, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2$cacheFile$1;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    move-object v8, v7
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput v2, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->label I
    invoke-static v1, v3, v8, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    check-cast v8, Ljava/io/File;
    iget-object v0, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->$holder Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->getBoundPath()Ljava/lang/String;
    move-result-object v0
    iget-object v1, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->$path Ljava/lang/String;
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +005h
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    if-eqz v8, +022h
    invoke-virtual v8, Ljava/io/File;->exists()Z
    move-result v0
    if-eqz v0, +01ch
    invoke-virtual v8, Ljava/io/File;->length()J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v0, v0, v2
    if-lez v0, +012h
    iget-object v0, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;->$holder Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
    invoke-static v8, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;
    move-result-object v8
    const-string v2, "fromFile(...)"
    invoke-static v8, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, v1, v8, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->access$loadUri(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter; Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder; Landroid/net/Uri;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
.end method
