# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;
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
.field final synthetic $messageId:Ljava/lang/String;
.field final synthetic $path:Ljava/lang/String;
.field final synthetic $subtitleView:Landroid/widget/TextView;
.field final synthetic $textView:Landroid/widget/TextView;
.field  L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;


.method constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.view.View  android.view.View  android.widget.TextView  android.view.View  android.view.View  android.view.View  android.widget.TextView  kotlin.coroutines.Continuation)void
    .registers 15
    # ins_size=15
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$chatSessionId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$path Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$messageId Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$contentContainer Landroid/view/View;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$headerRow Landroid/view/View;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$subtitleView Landroid/widget/TextView;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$dividerLine Landroid/view/View;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$cardContainer Landroid/view/View;
    iput-object v12, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$loadingView Landroid/view/View;
    iput-object v13, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$textView Landroid/widget/TextView;
    const/4 v1, 2
    invoke-direct v0, v1, v14, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 20
    # ins_size=3
    move-object/from16 v0, v17
    new-instance v16, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$chatSessionId Ljava/lang/String;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$path Ljava/lang/String;
    iget-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$messageId Ljava/lang/String;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    iget-object v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$contentContainer Landroid/view/View;
    iget-object v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$headerRow Landroid/view/View;
    iget-object v10, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$subtitleView Landroid/widget/TextView;
    iget-object v11, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$dividerLine Landroid/view/View;
    iget-object v12, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$cardContainer Landroid/view/View;
    iget-object v13, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$loadingView Landroid/view/View;
    iget-object v14, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$textView Landroid/widget/TextView;
    move-object/from16 v1, v16
    move-object/from16 v15, v19
    invoke-direct/range v1 ... v15, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Lkotlin/coroutines/Continuation;)V
    check-cast v16, Lkotlin/coroutines/Continuation;
    return-object v16
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 39
    # ins_size=2
    move-object/from16 v1, v37
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->label I
    const-string v3, "path"
    const-string v4, "messageId"
    const-string v5, "conversationId"
    const-string v6, "chatSessionId"
    const/4 v7, 5
    const/4 v8, 4
    const/4 v9, 3
    const/4 v10, 2
    const/4 v11, 0
    const/4 v12, 1
    if-eqz v0, +03dh
    if-eq v0, v12, +02fh
    if-eq v0, v10, +025h
    if-eq v0, v9, +018h
    if-eq v0, v8, +011h
    if-ne v0, v7, +007h
    invoke-static/range v38, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +195h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v38, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +188h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;
    invoke-static/range v38, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v7, v38
    goto/16 +0dbh
    invoke-static/range v38, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0adh
    move-exception v0
    goto/16 +140h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lorg/json/JSONObject;
    invoke-static/range v38, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v7, v38
    move-object/from16 v21, v0
    goto +42h
    invoke-static/range v38, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    iget-object v13, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$chatSessionId Ljava/lang/String;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    iget-object v15, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$messageId Ljava/lang/String;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$path Ljava/lang/String;
    invoke-virtual v0, v6, v13, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v0, v5, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v0, v4, v15, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v0, v3, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v16, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$chatSessionId Ljava/lang/String;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$path Ljava/lang/String;
    iget-object v15, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$messageId Ljava/lang/String;
    iget-object v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    move-object/from16 v22, v1
    check-cast v22, Lkotlin/coroutines/Continuation;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->L$0 Ljava/lang/Object;
    iput v12, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->label I
    move-object/from16 v17, v7
    move-object/from16 v18, v13
    move-object/from16 v19, v14
    move-object/from16 v20, v15
    move-object/from16 v21, v8
    invoke-virtual/range v16 ... v22, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->fetchFileUrl(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v2, -041h
    return-object v2
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->getUrl()Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/CharSequence;
    if-eqz v7, +00ah
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-nez v7, +003h
    goto +2h
    const/4 v12, 0
    if-eqz v12, +04bh
    sget-object v16, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v17, "fetch_file_url"
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    const-string v19, "failed"
    const-string v20, ""
    move-object/from16 v18, v0
    invoke-virtual/range v16 ... v21, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$1;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$contentContainer Landroid/view/View;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$headerRow Landroid/view/View;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$subtitleView Landroid/widget/TextView;
    iget-object v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$dividerLine Landroid/view/View;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$cardContainer Landroid/view/View;
    const/16 v23, 0
    move-object/from16 v16, v3
    move-object/from16 v17, v4
    move-object/from16 v18, v5
    move-object/from16 v19, v6
    move-object/from16 v20, v7
    move-object/from16 v21, v8
    move-object/from16 v22, v9
    invoke-direct/range v16 ... v23, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput-object v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->L$0 Ljava/lang/Object;
    iput v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->label I
    invoke-static v0, v3, v4, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    sget-object v16, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v17, "fetch_file_url"
    iget-object v7, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    const-string/jumbo v19, success
    const-string v20, ""
    move-object/from16 v18, v7
    invoke-virtual/range v16 ... v21, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->getUrl()Ljava/lang/String;
    move-result-object v8
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    move-object v12, v1
    check-cast v12, Lkotlin/coroutines/Continuation;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->L$0 Ljava/lang/Object;
    iput v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->label I
    invoke-virtual v7, v8, v10, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->fetchTextContent(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v2, +003h
    return-object v2
    move-object/from16 v25, v7
    check-cast v25, Ljava/lang/String;
    new-instance v7, Lorg/json/JSONObject;
    invoke-direct v7, Lorg/json/JSONObject;-><init>()V
    iget-object v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$chatSessionId Ljava/lang/String;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$messageId Ljava/lang/String;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$path Ljava/lang/String;
    invoke-virtual v7, v6, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v7, v5, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v7, v4, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v4, url
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper$FileUrlResult;->getUrl()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v7, v4, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v7, v3, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$loadingView Landroid/view/View;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$textView Landroid/widget/TextView;
    iget-object v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$contentContainer Landroid/view/View;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$headerRow Landroid/view/View;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$subtitleView Landroid/widget/TextView;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$dividerLine Landroid/view/View;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$cardContainer Landroid/view/View;
    const/16 v36, 0
    move-object/from16 v24, v3
    move-object/from16 v26, v4
    move-object/from16 v27, v7
    move-object/from16 v28, v5
    move-object/from16 v29, v6
    move-object/from16 v30, v8
    move-object/from16 v31, v9
    move-object/from16 v32, v10
    move-object/from16 v33, v12
    move-object/from16 v34, v13
    move-object/from16 v35, v14
    invoke-direct/range v24 ... v36, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;-><init>(Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject; Landroid/view/View; Landroid/widget/TextView; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput-object v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->L$0 Ljava/lang/Object;
    const/4 v5, 4
    iput v5, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->label I
    invoke-static v0, v3, v4, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +038h
    return-object v2
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v4, "loadTextContentAsync error"
    check-cast v0, Ljava/lang/Throwable;
    const-string v5, "AgentBlock"
    invoke-virtual v3, v5, v4, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$3;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$contentContainer Landroid/view/View;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$headerRow Landroid/view/View;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$subtitleView Landroid/widget/TextView;
    iget-object v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$dividerLine Landroid/view/View;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->$cardContainer Landroid/view/View;
    const/4 v10, 0
    move-object v3, v12
    invoke-direct/range v3 ... v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$3;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Lkotlin/coroutines/Continuation;)V
    check-cast v12, Lkotlin/jvm/functions/Function2;
    move-object v3, v1
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput-object v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->L$0 Ljava/lang/Object;
    const/4 v4, 5
    iput v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1;->label I
    invoke-static v0, v12, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0x2f
    :try_start_0x38
    :try_start_0x4b
    :try_start_0x56
    :try_start_0x63
    :try_start_0x6f
    :try_start_0x129
    :try_start_0x13f
.end method
