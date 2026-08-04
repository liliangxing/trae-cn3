# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "VideoArtifactCardView.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $lastFrameUri:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;


.method constructor <init>(java.lang.String  com.bytedance.trae.conversation.chat.block.renderer.VideoArtifactCardView  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2;->$lastFrameUri Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2;->$lastFrameUri Ljava/lang/String;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2;->label I
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +010h
    if-ne v1, v3, +006h
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
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;
    iget-object v5, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2;->$lastFrameUri Ljava/lang/String;
    invoke-direct v1, v4, v5, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v4, v6
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v3, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2;->label I
    invoke-static v7, v1, v4, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    check-cast v7, Ljava/lang/String;
    if-eqz v7, +01eh
    move-object v0, v7
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/2addr v0, v3
    if-eqz v0, +003h
    move-object v2, v7
    if-eqz v2, +011h
    sget-object v7, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2;->$lastFrameUri Ljava/lang/String;
    invoke-virtual v7, v0, v2, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->put(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;
    invoke-static v7, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->access$loadLastFrame(Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView; Ljava/lang/String;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method
