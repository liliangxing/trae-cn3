# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactsRenderer.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $context:Landroid/content/Context;
.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $fileDownloadHelper:Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
.field final synthetic $target:Ljava/lang/String;
.field final synthetic $url:Lkotlin/jvm/internal/Ref$ObjectRef;
.field  label:I


.method constructor <init>(com.bytedance.trae.conversation.products.FileDownloadHelper  android.content.Context  kotlin.jvm.internal.Ref$ObjectRef  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;->$fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;->$context Landroid/content/Context;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;->$url Lkotlin/jvm/internal/Ref$ObjectRef;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;->$conversationId Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;->$target Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;->$fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;->$context Landroid/content/Context;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;->$url Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;->$conversationId Ljava/lang/String;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;->$target Ljava/lang/String;
    move-object v0, v8
    move-object v6, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;-><init>(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +36h
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v1, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;->$fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iget-object v13, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;->$context Landroid/content/Context;
    invoke-virtual v13, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v13
    const-string v3, "getApplicationContext(...)"
    invoke-static v13, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v3, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;->$url Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v3, v3, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v3, Ljava/lang/String;
    iget-object v4, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;->$conversationId Ljava/lang/String;
    iget-object v5, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;->$target Ljava/lang/String;
    const/4 v6, 1
    const-wide/16 v7, 0
    move-object v9, v12
    check-cast v9, Lkotlin/coroutines/Continuation;
    const/16 v10, 32
    const/4 v11, 0
    iput v2, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;->label I
    move-object v2, v13
    invoke-static/range v1 ... v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadToCache$default(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v0, +003h
    return-object v0
    return-object v13
.end method
