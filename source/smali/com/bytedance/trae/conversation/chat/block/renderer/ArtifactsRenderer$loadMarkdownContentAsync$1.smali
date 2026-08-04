# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;
.super Ljava/lang/Object;
.source "ArtifactsRenderer.kt"

.implements Landroid/view/View$OnAttachStateChangeListener;

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
.field private job:Lkotlinx/coroutines/Job;
.field private final scope:Lkotlinx/coroutines/CoroutineScope;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;


.method constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.view.View  android.view.View  android.widget.TextView  android.view.View  android.view.View  android.view.View  com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView)void
    .registers 14
    # ins_size=14
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$chatSessionId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$cliType Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$path Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$messageId Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$conversationId Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$contentContainer Landroid/view/View;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$headerRow Landroid/view/View;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$subtitleView Landroid/widget/TextView;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$dividerLine Landroid/view/View;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$cardContainer Landroid/view/View;
    iput-object v12, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$loadingView Landroid/view/View;
    iput-object v13, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$markdownTextView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    invoke-static Lkotlinx/coroutines/CoroutineScopeKt;->MainScope()Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->scope Lkotlinx/coroutines/CoroutineScope;
    return-void 
.end method

.method public onViewAttachedToWindow(android.view.View)void
    .registers 24
    # ins_size=2
    move-object/from16 v0, v22
    const-string/jumbo v1, v
    move-object/from16 v2, v23
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->job Lkotlinx/coroutines/Job;
    if-eqz v1, +007h
    const/4 v2, 1
    const/4 v3, 0
    invoke-static v1, v3, v2, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->scope Lkotlinx/coroutines/CoroutineScope;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;
    iget-object v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$chatSessionId Ljava/lang/String;
    iget-object v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$cliType Ljava/lang/String;
    iget-object v10, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$path Ljava/lang/String;
    iget-object v11, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$messageId Ljava/lang/String;
    iget-object v12, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$conversationId Ljava/lang/String;
    iget-object v13, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v14, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$contentContainer Landroid/view/View;
    iget-object v15, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$headerRow Landroid/view/View;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$subtitleView Landroid/widget/TextView;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$dividerLine Landroid/view/View;
    iget-object v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$cardContainer Landroid/view/View;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$loadingView Landroid/view/View;
    iget-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->$markdownTextView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    const/16 v21, 0
    move-object/from16 v18, v7
    move-object v7, v1
    move-object/from16 v16, v2
    move-object/from16 v17, v3
    move-object/from16 v19, v6
    move-object/from16 v20, v5
    invoke-direct/range v7 ... v21, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Lkotlin/coroutines/Continuation;)V
    move-object v7, v1
    check-cast v7, Lkotlin/jvm/functions/Function2;
    const/4 v8, 3
    const/4 v9, 0
    const/4 v1, 0
    move-object v5, v1
    const/4 v1, 0
    move-object v6, v1
    invoke-static/range v4 ... v9, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->job Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public onViewDetachedFromWindow(android.view.View)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, v
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;->job Lkotlinx/coroutines/Job;
    if-eqz v3, +007h
    const/4 v0, 1
    const/4 v1, 0
    invoke-static v3, v1, v0, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    return-void 
.end method
