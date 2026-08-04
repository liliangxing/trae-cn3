# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactsRenderer.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $chatSessionId:Ljava/lang/String;
.field final synthetic $cliType:Ljava/lang/String;
.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $messageId:Ljava/lang/String;
.field final synthetic $path:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;


.method constructor <init>(java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 8
    # ins_size=8
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->$cliType Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->$chatSessionId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->$path Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->$conversationId Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->$messageId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v7, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 11
    # ins_size=3
    new-instance v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;
    iget-object v1, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->$cliType Ljava/lang/String;
    iget-object v2, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->$chatSessionId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->$path Ljava/lang/String;
    iget-object v4, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v5, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->$conversationId Ljava/lang/String;
    iget-object v6, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->$messageId Ljava/lang/String;
    move-object v0, v9
    move-object v7, v10
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/coroutines/Continuation;
    return-object v9
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +016h
    if-eq v1, v3, +010h
    if-ne v1, v2, +006h
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +5fh
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +32h
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v13, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->$cliType Ljava/lang/String;
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-static v13, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v13
    if-eqz v13, +025h
    new-instance v13, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    const/4 v5, 0
    const/4 v6, 0
    const-wide/16 v7, 0
    const/4 v9, 0
    const/16 v10, 15
    const/4 v11, 0
    move-object v4, v13
    invoke-direct/range v4 ... v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSessionClient; Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSandboxStatusSource; J Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iget-object v1, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->$chatSessionId Ljava/lang/String;
    iget-object v2, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->$path Ljava/lang/String;
    sget-object v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;->ENSURE_SANDBOX_READY Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;
    move-object v5, v12
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v3, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->label I
    invoke-virtual v13, v1, v2, v4, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->resolve(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v0, +003h
    return-object v0
    check-cast v13, Ljava/lang/String;
    goto +21h
    sget-object v13, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->Companion Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;
    iget-object v1, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->$path Ljava/lang/String;
    invoke-virtual v13, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;->fromPreviewPath(Ljava/lang/String;)Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    move-result-object v13
    iget-object v1, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->getLocalRequestPath()Ljava/lang/String;
    move-result-object v13
    iget-object v3, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->$conversationId Ljava/lang/String;
    iget-object v4, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->$messageId Ljava/lang/String;
    move-object v5, v12
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v2, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;->label I
    invoke-static v1, v13, v3, v4, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->access$fetchHtmlDownloadUrlWithRetry(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v0, +003h
    return-object v0
    check-cast v13, Ljava/lang/String;
    return-object v13
.end method
