# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;
.super Ljava/lang/Object;
.source "ArtifactsRenderer.kt"

.implements Landroid/view/View$OnAttachStateChangeListener;

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
.field private job:Lkotlinx/coroutines/Job;
.field private final scope:Lkotlinx/coroutines/CoroutineScope;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;


.method constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  android.content.Context  java.lang.String  com.bytedance.trae.im.model.FileDiffInfo  android.view.View  android.view.View  android.widget.TextView  android.view.View  android.view.View  android.view.View  android.webkit.WebView)void
    .registers 19
    # ins_size=17
    move-object v0, v2
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$chatSessionId Ljava/lang/String;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$cliType Ljava/lang/String;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$path Ljava/lang/String;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$conversationId Ljava/lang/String;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$messageId Ljava/lang/String;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$context Landroid/content/Context;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$filePath Ljava/lang/String;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$file Lcom/bytedance/trae/im/model/FileDiffInfo;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$contentContainer Landroid/view/View;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$headerRow Landroid/view/View;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$subtitleView Landroid/widget/TextView;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$dividerLine Landroid/view/View;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$cardContainer Landroid/view/View;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$loadingView Landroid/view/View;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$webView Landroid/webkit/WebView;
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    invoke-static Lkotlinx/coroutines/CoroutineScopeKt;->MainScope()Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->scope Lkotlinx/coroutines/CoroutineScope;
    return-void 
.end method

.method public onViewAttachedToWindow(android.view.View)void
    .registers 27
    # ins_size=2
    move-object/from16 v0, v25
    const-string/jumbo v1, v
    move-object/from16 v2, v26
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->job Lkotlinx/coroutines/Job;
    if-eqz v1, +007h
    const/4 v2, 1
    const/4 v3, 0
    invoke-static v1, v3, v2, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v5, 0
    const/4 v6, 0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;
    move-object v7, v1
    iget-object v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$chatSessionId Ljava/lang/String;
    iget-object v10, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$cliType Ljava/lang/String;
    iget-object v11, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$path Ljava/lang/String;
    iget-object v12, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$conversationId Ljava/lang/String;
    iget-object v13, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$messageId Ljava/lang/String;
    iget-object v14, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$context Landroid/content/Context;
    iget-object v15, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$filePath Ljava/lang/String;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$file Lcom/bytedance/trae/im/model/FileDiffInfo;
    move-object/from16 v16, v2
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$contentContainer Landroid/view/View;
    move-object/from16 v17, v2
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$headerRow Landroid/view/View;
    move-object/from16 v18, v2
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$subtitleView Landroid/widget/TextView;
    move-object/from16 v19, v2
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$dividerLine Landroid/view/View;
    move-object/from16 v20, v2
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$cardContainer Landroid/view/View;
    move-object/from16 v21, v2
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$loadingView Landroid/view/View;
    move-object/from16 v22, v2
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->$webView Landroid/webkit/WebView;
    move-object/from16 v23, v2
    const/16 v24, 0
    invoke-direct/range v7 ... v24, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Landroid/content/Context; Ljava/lang/String; Lcom/bytedance/trae/im/model/FileDiffInfo; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/webkit/WebView; Lkotlin/coroutines/Continuation;)V
    move-object v7, v1
    check-cast v7, Lkotlin/jvm/functions/Function2;
    const/4 v8, 3
    const/4 v9, 0
    invoke-static/range v4 ... v9, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->job Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public onViewDetachedFromWindow(android.view.View)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, v
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;->job Lkotlinx/coroutines/Job;
    if-eqz v3, +007h
    const/4 v0, 1
    const/4 v1, 0
    invoke-static v3, v1, v0, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    return-void 
.end method
