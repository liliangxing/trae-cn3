# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactsRenderer.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $messageId:Ljava/lang/String;
.field final synthetic $targets:Ljava/util/List;
.field  label:I


.method constructor <init>(java.util.List  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$2;->$targets Ljava/util/List;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$2;->$conversationId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$2;->$messageId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$2;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$2;->$targets Ljava/util/List;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$2;->$conversationId Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$2;->$messageId Ljava/lang/String;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$2;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$2;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +29h
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v8, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi;->Companion Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;
    new-instance v1, Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$2;->$targets Ljava/util/List;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$2;->$conversationId Ljava/lang/String;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$2;->$messageId Ljava/lang/String;
    invoke-static v2, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v6
    invoke-direct v1, v3, v4, v5, v6, Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean;)V
    move-object v3, v7
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$2;->label I
    invoke-virtual v8, v1, v3, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;->getDownloadUrlRawCall(Lcom/bytedance/trae/im/service/GetDownloadUrlRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    return-object v8
.end method
