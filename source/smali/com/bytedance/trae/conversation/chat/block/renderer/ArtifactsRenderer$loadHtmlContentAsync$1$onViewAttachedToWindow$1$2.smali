# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactsRenderer.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cardContainer:Landroid/view/View;
.field final synthetic $contentContainer:Landroid/view/View;
.field final synthetic $dividerLine:Landroid/view/View;
.field final synthetic $entryFile:Ljava/io/File;
.field final synthetic $headerRow:Landroid/view/View;
.field final synthetic $loadingView:Landroid/view/View;
.field final synthetic $subtitleView:Landroid/widget/TextView;
.field final synthetic $webView:Landroid/webkit/WebView;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;


.method constructor <init>(java.io.File  android.view.View  android.webkit.WebView  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.view.View  android.view.View  android.widget.TextView  android.view.View  android.view.View  kotlin.coroutines.Continuation)void
    .registers 11
    # ins_size=11
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$entryFile Ljava/io/File;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$loadingView Landroid/view/View;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$webView Landroid/webkit/WebView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$contentContainer Landroid/view/View;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$headerRow Landroid/view/View;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$subtitleView Landroid/widget/TextView;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$dividerLine Landroid/view/View;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$cardContainer Landroid/view/View;
    const/4 v1, 2
    invoke-direct v0, v1, v10, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 14
    # ins_size=3
    new-instance v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;
    iget-object v1, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$entryFile Ljava/io/File;
    iget-object v2, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$loadingView Landroid/view/View;
    iget-object v3, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$webView Landroid/webkit/WebView;
    iget-object v4, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v5, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$contentContainer Landroid/view/View;
    iget-object v6, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$headerRow Landroid/view/View;
    iget-object v7, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$subtitleView Landroid/widget/TextView;
    iget-object v8, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$dividerLine Landroid/view/View;
    iget-object v9, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$cardContainer Landroid/view/View;
    move-object v0, v12
    move-object v10, v13
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;-><init>(Ljava/io/File; Landroid/view/View; Landroid/webkit/WebView; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Lkotlin/coroutines/Continuation;)V
    check-cast v12, Lkotlin/coroutines/Continuation;
    return-object v12
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->label I
    if-nez v0, +043h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$entryFile Ljava/io/File;
    if-eqz v8, +02ah
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$loadingView Landroid/view/View;
    const/16 v0, 8
    invoke-virtual v8, v0, Landroid/view/View;->setVisibility(I)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$webView Landroid/webkit/WebView;
    const/4 v0, 0
    invoke-virtual v8, v0, Landroid/webkit/WebView;->setVisibility(I)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$webView Landroid/webkit/WebView;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "file://"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$entryFile Ljava/io/File;
    invoke-virtual v1, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v8, v0, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V
    goto +10h
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$contentContainer Landroid/view/View;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$headerRow Landroid/view/View;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$subtitleView Landroid/widget/TextView;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$dividerLine Landroid/view/View;
    iget-object v6, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2;->$cardContainer Landroid/view/View;
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->access$collapseToFileCard(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
.end method
