# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactFileUrlHelper.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $chatSessionId:Ljava/lang/String;
.field final synthetic $cliType:Ljava/lang/String;
.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $messageId:Ljava/lang/String;
.field final synthetic $path:Ljava/lang/String;
.field  label:I


.method constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->$cliType Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->$chatSessionId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->$path Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->$conversationId Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->$messageId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->$cliType Ljava/lang/String;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->$chatSessionId Ljava/lang/String;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->$path Ljava/lang/String;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->$conversationId Ljava/lang/String;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->$messageId Ljava/lang/String;
    move-object v0, v8
    move-object v6, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +016h
    if-eq v1, v3, +010h
    if-ne v1, v2, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +47h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +24h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->$cliType Ljava/lang/String;
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +017h
    sget-object v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->$chatSessionId Ljava/lang/String;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->$path Ljava/lang/String;
    move-object v4, v6
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v3, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->label I
    invoke-static v7, v1, v2, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->access$fetchRemoteFileUrl(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    check-cast v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;
    goto +17h
    sget-object v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->$path Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->$conversationId Ljava/lang/String;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->$messageId Ljava/lang/String;
    move-object v5, v6
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v2, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$fetchFileUrl$2;->label I
    invoke-static v7, v1, v3, v4, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->access$fetchLocalFileUrl(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    check-cast v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;
    return-object v7
.end method
