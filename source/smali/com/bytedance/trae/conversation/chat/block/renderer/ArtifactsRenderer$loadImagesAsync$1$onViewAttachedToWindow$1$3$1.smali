# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactsRenderer.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $context:Landroid/content/Context;
.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $fileDownloadHelper:Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
.field final synthetic $fileExtras:Lorg/json/JSONObject;
.field final synthetic $imageViews:Ljava/util/List;
.field final synthetic $index:I
.field final synthetic $path:Ljava/lang/String;
.field final synthetic $url:Ljava/lang/String;
.field  label:I


.method constructor <init>(com.bytedance.trae.conversation.products.FileDownloadHelper  android.content.Context  java.lang.String  java.lang.String  java.lang.String  org.json.JSONObject  java.util.List  int  kotlin.coroutines.Continuation)void
    .registers 10
    # ins_size=10
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$context Landroid/content/Context;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$url Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$conversationId Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$path Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$fileExtras Lorg/json/JSONObject;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$imageViews Ljava/util/List;
    iput v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$index I
    const/4 v1, 2
    invoke-direct v0, v1, v9, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 13
    # ins_size=3
    new-instance v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;
    iget-object v1, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iget-object v2, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$context Landroid/content/Context;
    iget-object v3, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$url Ljava/lang/String;
    iget-object v4, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$conversationId Ljava/lang/String;
    iget-object v5, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$path Ljava/lang/String;
    iget-object v6, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$fileExtras Lorg/json/JSONObject;
    iget-object v7, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$imageViews Ljava/util/List;
    iget v8, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$index I
    move-object v0, v11
    move-object v9, v12
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;-><init>(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject; Ljava/util/List; I Lkotlin/coroutines/Continuation;)V
    check-cast v11, Lkotlin/coroutines/Continuation;
    return-object v11
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 16
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +016h
    if-eq v1, v3, +010h
    if-ne v1, v2, +006h
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +5ah
    new-instance v15, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v15, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v15
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2ah
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iget-object v1, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$context Landroid/content/Context;
    invoke-virtual v1, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v4
    const-string v1, "getApplicationContext(...)"
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v5, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$url Ljava/lang/String;
    iget-object v6, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$conversationId Ljava/lang/String;
    iget-object v7, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$path Ljava/lang/String;
    const/4 v8, 1
    const-wide/16 v9, 0
    move-object v11, v14
    check-cast v11, Lkotlin/coroutines/Continuation;
    const/16 v12, 32
    const/4 v13, 0
    iput v3, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->label I
    move-object v3, v15
    invoke-static/range v3 ... v13, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadToCache$default(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v15
    if-ne v15, v0, +003h
    return-object v0
    move-object v4, v15
    check-cast v4, Ljava/io/File;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v15
    check-cast v15, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;
    iget-object v5, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$fileExtras Lorg/json/JSONObject;
    iget-object v6, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$imageViews Ljava/util/List;
    iget v7, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->$index I
    const/4 v8, 0
    move-object v3, v1
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;-><init>(Ljava/io/File; Lorg/json/JSONObject; Ljava/util/List; I Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v3, v14
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;->label I
    invoke-static v15, v1, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v15
    if-ne v15, v0, +003h
    return-object v0
    sget-object v15, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v15
.end method
