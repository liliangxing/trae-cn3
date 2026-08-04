# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactsRenderer.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cardContainer:Landroid/view/View;
.field final synthetic $chatSessionId:Ljava/lang/String;
.field final synthetic $cliType:Ljava/lang/String;
.field final synthetic $contentContainer:Landroid/view/View;
.field final synthetic $context:Landroid/content/Context;
.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $dividerLine:Landroid/view/View;
.field final synthetic $file:Lcom/bytedance/trae/im/model/FileDiffInfo;
.field final synthetic $filePath:Ljava/lang/String;
.field final synthetic $headerRow:Landroid/view/View;
.field final synthetic $loadingView:Landroid/view/View;
.field final synthetic $messageId:Ljava/lang/String;
.field final synthetic $path:Ljava/lang/String;
.field final synthetic $subtitleView:Landroid/widget/TextView;
.field final synthetic $webView:Landroid/webkit/WebView;
.field  L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;


.method constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  android.content.Context  java.lang.String  com.bytedance.trae.im.model.FileDiffInfo  android.view.View  android.view.View  android.widget.TextView  android.view.View  android.view.View  android.view.View  android.webkit.WebView  kotlin.coroutines.Continuation)void
    .registers 21
    # ins_size=18
    move-object v0, v3
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$chatSessionId Ljava/lang/String;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$path Ljava/lang/String;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$messageId Ljava/lang/String;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$context Landroid/content/Context;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$filePath Ljava/lang/String;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$file Lcom/bytedance/trae/im/model/FileDiffInfo;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$contentContainer Landroid/view/View;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$headerRow Landroid/view/View;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$subtitleView Landroid/widget/TextView;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$dividerLine Landroid/view/View;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$cardContainer Landroid/view/View;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$loadingView Landroid/view/View;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$webView Landroid/webkit/WebView;
    const/4 v1, 2
    move-object/from16 v2, v20
    invoke-direct v3, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 23
    # ins_size=3
    move-object/from16 v0, v20
    move-object/from16 v18, v22
    new-instance v19, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;
    move-object/from16 v1, v19
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$chatSessionId Ljava/lang/String;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    iget-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$path Ljava/lang/String;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    iget-object v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$messageId Ljava/lang/String;
    iget-object v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$context Landroid/content/Context;
    iget-object v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$filePath Ljava/lang/String;
    iget-object v10, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$file Lcom/bytedance/trae/im/model/FileDiffInfo;
    iget-object v11, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$contentContainer Landroid/view/View;
    iget-object v12, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$headerRow Landroid/view/View;
    iget-object v13, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$subtitleView Landroid/widget/TextView;
    iget-object v14, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$dividerLine Landroid/view/View;
    iget-object v15, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$cardContainer Landroid/view/View;
    move-object/from16 v21, v1
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$loadingView Landroid/view/View;
    move-object/from16 v16, v1
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$webView Landroid/webkit/WebView;
    move-object/from16 v17, v1
    move-object/from16 v1, v21
    invoke-direct/range v1 ... v18, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Landroid/content/Context; Ljava/lang/String; Lcom/bytedance/trae/im/model/FileDiffInfo; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/webkit/WebView; Lkotlin/coroutines/Continuation;)V
    check-cast v19, Lkotlin/coroutines/Continuation;
    return-object v19
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 21
    # ins_size=2
    move-object/from16 v1, v19
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->label I
    const/4 v3, 5
    const/4 v4, 4
    const/4 v5, 3
    const/4 v6, 2
    const/4 v7, 0
    const/4 v8, 1
    if-eqz v0, +039h
    if-eq v0, v8, +02bh
    if-eq v0, v6, +021h
    if-eq v0, v5, +018h
    if-eq v0, v4, +011h
    if-ne v0, v3, +007h
    invoke-static/range v20, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +14dh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v20, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +140h
    invoke-static/range v20, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v20
    goto/16 +0d2h
    invoke-static/range v20, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0a0h
    move-exception v0
    goto/16 +0fdh
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lorg/json/JSONObject;
    invoke-static/range v20, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v9, v20
    move-object/from16 v16, v0
    goto +46h
    invoke-static/range v20, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$chatSessionId Ljava/lang/String;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$messageId Ljava/lang/String;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$file Lcom/bytedance/trae/im/model/FileDiffInfo;
    const-string v13, "chatSessionId"
    invoke-virtual v0, v13, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v9, "conversationId"
    invoke-virtual v0, v9, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v9, "messageId"
    invoke-virtual v0, v9, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v9, "path"
    invoke-virtual v12, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v0, v9, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$chatSessionId Ljava/lang/String;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$path Ljava/lang/String;
    iget-object v15, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$messageId Ljava/lang/String;
    move-object/from16 v17, v1
    check-cast v17, Lkotlin/coroutines/Continuation;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->L$0 Ljava/lang/Object;
    iput v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->label I
    move-object/from16 v16, v9
    invoke-static/range v11 ... v17, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->access$fetchHtmlArchiveUrl(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v2, -045h
    return-object v2
    move-object v0, v9
    check-cast v0, Ljava/lang/String;
    move-object v9, v0
    check-cast v9, Ljava/lang/CharSequence;
    if-eqz v9, +00ah
    invoke-interface v9, Ljava/lang/CharSequence;->length()I
    move-result v9
    if-nez v9, +003h
    goto +2h
    const/4 v8, 0
    if-eqz v8, +03dh
    sget-object v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v11, "fetch_html_url"
    iget-object v12, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    const-string v13, "failed"
    const-string v14, ""
    move-object/from16 v15, v16
    invoke-virtual/range v10 ... v15, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$1;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$contentContainer Landroid/view/View;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$headerRow Landroid/view/View;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$subtitleView Landroid/widget/TextView;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$dividerLine Landroid/view/View;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$cardContainer Landroid/view/View;
    const/4 v15, 0
    move-object v8, v4
    invoke-direct/range v8 ... v15, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    move-object v5, v1
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->L$0 Ljava/lang/Object;
    iput v6, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->label I
    invoke-static v0, v4, v5, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    sget-object v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v11, "fetch_html_url"
    iget-object v12, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    const-string/jumbo v13, success
    const-string v14, ""
    move-object/from16 v15, v16
    invoke-virtual/range v10 ... v15, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$context Landroid/content/Context;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    iget-object v15, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$filePath Ljava/lang/String;
    move-object/from16 v17, v1
    check-cast v17, Lkotlin/coroutines/Continuation;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->L$0 Ljava/lang/Object;
    iput v5, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->label I
    move-object v12, v0
    invoke-static/range v10 ... v17, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->access$downloadAndExtractHtml(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    move-object v9, v0
    check-cast v9, Ljava/io/File;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$loadingView Landroid/view/View;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$webView Landroid/webkit/WebView;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$contentContainer Landroid/view/View;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$headerRow Landroid/view/View;
    iget-object v15, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$subtitleView Landroid/widget/TextView;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$dividerLine Landroid/view/View;
    iget-object v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$cardContainer Landroid/view/View;
    const/16 v18, 0
    move-object/from16 v17, v8
    move-object v8, v5
    move-object/from16 v16, v6
    invoke-direct/range v8 ... v18, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;-><init>(Ljava/io/File; Landroid/view/View; Landroid/webkit/WebView; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Lkotlin/coroutines/Continuation;)V
    check-cast v5, Lkotlin/jvm/functions/Function2;
    move-object v6, v1
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->label I
    invoke-static v0, v5, v6, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +037h
    return-object v2
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v5, "loadHtmlContentAsync error"
    check-cast v0, Ljava/lang/Throwable;
    const-string v6, "AgentBlock"
    invoke-virtual v4, v6, v5, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$3;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$contentContainer Landroid/view/View;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$headerRow Landroid/view/View;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$subtitleView Landroid/widget/TextView;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$dividerLine Landroid/view/View;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->$cardContainer Landroid/view/View;
    const/4 v15, 0
    move-object v8, v4
    invoke-direct/range v8 ... v15, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$3;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    move-object v5, v1
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->L$0 Ljava/lang/Object;
    iput v3, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;->label I
    invoke-static v0, v4, v5, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0x27
    :try_start_0x3f
    :try_start_0x4a
    :try_start_0x57
    :try_start_0x6f
.end method
