# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactsRenderer.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cardContainer:Landroid/view/View;
.field final synthetic $chatSessionId:Ljava/lang/String;
.field final synthetic $cliType:Ljava/lang/String;
.field final synthetic $contentContainer:Landroid/view/View;
.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $dividerLine:Landroid/view/View;
.field final synthetic $headerRow:Landroid/view/View;
.field final synthetic $loadingView:Landroid/view/View;
.field final synthetic $markdownTextView:Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
.field final synthetic $messageId:Ljava/lang/String;
.field final synthetic $path:Ljava/lang/String;
.field final synthetic $subtitleView:Landroid/widget/TextView;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;


.method constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.view.View  android.view.View  android.widget.TextView  android.view.View  android.view.View  android.view.View  com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView  kotlin.coroutines.Continuation)void
    .registers 15
    # ins_size=15
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$chatSessionId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$path Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$messageId Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$contentContainer Landroid/view/View;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$headerRow Landroid/view/View;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$subtitleView Landroid/widget/TextView;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$dividerLine Landroid/view/View;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$cardContainer Landroid/view/View;
    iput-object v12, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$loadingView Landroid/view/View;
    iput-object v13, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$markdownTextView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    const/4 v1, 2
    invoke-direct v0, v1, v14, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 20
    # ins_size=3
    move-object/from16 v0, v17
    new-instance v16, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$chatSessionId Ljava/lang/String;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$path Ljava/lang/String;
    iget-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$messageId Ljava/lang/String;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    iget-object v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$contentContainer Landroid/view/View;
    iget-object v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$headerRow Landroid/view/View;
    iget-object v10, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$subtitleView Landroid/widget/TextView;
    iget-object v11, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$dividerLine Landroid/view/View;
    iget-object v12, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$cardContainer Landroid/view/View;
    iget-object v13, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$loadingView Landroid/view/View;
    iget-object v14, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$markdownTextView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    move-object/from16 v1, v16
    move-object/from16 v15, v19
    invoke-direct/range v1 ... v15, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Lkotlin/coroutines/Continuation;)V
    check-cast v16, Lkotlin/coroutines/Continuation;
    return-object v16
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 19
    # ins_size=2
    move-object/from16 v1, v17
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->label I
    const/4 v3, 5
    const/4 v4, 4
    const/4 v5, 3
    const/4 v6, 2
    const/4 v7, 1
    if-eqz v0, +032h
    if-eq v0, v7, +027h
    if-eq v0, v6, +021h
    if-eq v0, v5, +018h
    if-eq v0, v4, +011h
    if-ne v0, v3, +007h
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0f3h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0e6h
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v18
    goto/16 +07ch
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +60h
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v18
    goto +1fh
    move-exception v0
    goto/16 +0a0h
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$chatSessionId Ljava/lang/String;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$path Ljava/lang/String;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$messageId Ljava/lang/String;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    move-object v14, v1
    check-cast v14, Lkotlin/coroutines/Continuation;
    iput v7, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->label I
    invoke-virtual/range v8 ... v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->fetchFileUrl(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->getUrl()Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    if-eqz v8, +00ah
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-nez v8, +003h
    goto +2h
    const/4 v7, 0
    if-eqz v7, +02ch
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$1;
    iget-object v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$contentContainer Landroid/view/View;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$headerRow Landroid/view/View;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$subtitleView Landroid/widget/TextView;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$dividerLine Landroid/view/View;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$cardContainer Landroid/view/View;
    const/4 v14, 0
    move-object v7, v4
    invoke-direct/range v7 ... v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    move-object v5, v1
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v6, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->label I
    invoke-static v0, v4, v5, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    sget-object v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->getUrl()Ljava/lang/String;
    move-result-object v0
    iget-object v7, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    move-object v8, v1
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput v5, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->label I
    invoke-virtual v6, v0, v7, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->fetchTextContent(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    move-object v6, v0
    check-cast v6, Ljava/lang/String;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v16, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$loadingView Landroid/view/View;
    iget-object v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$markdownTextView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$contentContainer Landroid/view/View;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$headerRow Landroid/view/View;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$subtitleView Landroid/widget/TextView;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$dividerLine Landroid/view/View;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$cardContainer Landroid/view/View;
    const/4 v15, 0
    move-object/from16 v5, v16
    invoke-direct/range v5 ... v15, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;-><init>(Ljava/lang/String; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Lkotlin/coroutines/Continuation;)V
    move-object/from16 v5, v16
    check-cast v5, Lkotlin/jvm/functions/Function2;
    move-object v6, v1
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->label I
    invoke-static v0, v5, v6, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +035h
    return-object v2
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v5, "loadMarkdownContentAsync error"
    check-cast v0, Ljava/lang/Throwable;
    const-string v6, "AgentBlock"
    invoke-virtual v4, v6, v5, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$3;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$contentContainer Landroid/view/View;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$headerRow Landroid/view/View;
    iget-object v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$subtitleView Landroid/widget/TextView;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$dividerLine Landroid/view/View;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->$cardContainer Landroid/view/View;
    const/4 v11, 0
    move-object v4, v12
    invoke-direct/range v4 ... v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$3;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Lkotlin/coroutines/Continuation;)V
    check-cast v12, Lkotlin/jvm/functions/Function2;
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v3, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;->label I
    invoke-static v0, v12, v4, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0x26
    :try_start_0x42
.end method
