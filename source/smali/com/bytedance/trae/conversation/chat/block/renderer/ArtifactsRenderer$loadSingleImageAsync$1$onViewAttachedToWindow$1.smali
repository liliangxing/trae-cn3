# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactsRenderer.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $chatSessionId:Ljava/lang/String;
.field final synthetic $cliType:Ljava/lang/String;
.field final synthetic $container:Landroid/widget/FrameLayout;
.field final synthetic $context:Landroid/content/Context;
.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $draweeView:Lcom/facebook/drawee/view/SimpleDraweeView;
.field final synthetic $file:Lcom/bytedance/trae/im/model/FileDiffInfo;
.field final synthetic $maxSizePx:I
.field final synthetic $messageId:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;


.method constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.content.Context  com.bytedance.trae.im.model.FileDiffInfo  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.facebook.drawee.view.SimpleDraweeView  android.widget.FrameLayout  int  kotlin.coroutines.Continuation)void
    .registers 12
    # ins_size=12
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$context Landroid/content/Context;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$file Lcom/bytedance/trae/im/model/FileDiffInfo;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$chatSessionId Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$messageId Ljava/lang/String;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$container Landroid/widget/FrameLayout;
    iput v10, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$maxSizePx I
    const/4 v1, 2
    invoke-direct v0, v1, v11, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 15
    # ins_size=3
    new-instance v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;
    iget-object v1, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v2, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$context Landroid/content/Context;
    iget-object v3, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$file Lcom/bytedance/trae/im/model/FileDiffInfo;
    iget-object v4, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    iget-object v5, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$chatSessionId Ljava/lang/String;
    iget-object v6, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    iget-object v7, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$messageId Ljava/lang/String;
    iget-object v8, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    iget-object v9, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$container Landroid/widget/FrameLayout;
    iget v10, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$maxSizePx I
    move-object v0, v13
    move-object v11, v14
    invoke-direct/range v0 ... v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/content/Context; Lcom/bytedance/trae/im/model/FileDiffInfo; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/facebook/drawee/view/SimpleDraweeView; Landroid/widget/FrameLayout; I Lkotlin/coroutines/Continuation;)V
    check-cast v13, Lkotlin/coroutines/Continuation;
    return-object v13
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 13
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +018h
    if-eq v1, v3, +010h
    if-ne v1, v2, +006h
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +5eh
    new-instance v12, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v12, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v12
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +21h
    move-exception v12
    goto +45h
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v4, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$context Landroid/content/Context;
    iget-object v5, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$file Lcom/bytedance/trae/im/model/FileDiffInfo;
    iget-object v6, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    iget-object v7, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$chatSessionId Ljava/lang/String;
    iget-object v8, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    iget-object v9, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$messageId Ljava/lang/String;
    move-object v10, v11
    check-cast v10, Lkotlin/coroutines/Continuation;
    iput v3, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->label I
    move-object v3, v12
    invoke-static/range v3 ... v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->access$resolveImageUri(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/content/Context; Lcom/bytedance/trae/im/model/FileDiffInfo; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v0, +003h
    return-object v0
    move-object v4, v12
    check-cast v4, Landroid/net/Uri;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v12
    check-cast v12, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;
    iget-object v5, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v6, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    iget-object v7, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$container Landroid/widget/FrameLayout;
    iget v8, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->$maxSizePx I
    const/4 v9, 0
    move-object v3, v1
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;-><init>(Landroid/net/Uri; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Lcom/facebook/drawee/view/SimpleDraweeView; Landroid/widget/FrameLayout; I Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v3, v11
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;->label I
    invoke-static v12, v1, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v0, +00eh
    return-object v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "loadSingleImageAsync error"
    check-cast v12, Ljava/lang/Throwable;
    const-string v2, "AgentBlock"
    invoke-virtual v0, v2, v1, v12, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
    :try_start_0xe
    :try_start_0x1a
    :try_start_0x23
.end method
