# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactsRenderer.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cardContainer:Landroid/view/View;
.field final synthetic $content:Ljava/lang/String;
.field final synthetic $contentContainer:Landroid/view/View;
.field final synthetic $dividerLine:Landroid/view/View;
.field final synthetic $headerRow:Landroid/view/View;
.field final synthetic $loadingView:Landroid/view/View;
.field final synthetic $markdownTextView:Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
.field final synthetic $subtitleView:Landroid/widget/TextView;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;


.method constructor <init>(java.lang.String  android.view.View  com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.view.View  android.view.View  android.widget.TextView  android.view.View  android.view.View  kotlin.coroutines.Continuation)void
    .registers 11
    # ins_size=11
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$content Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$loadingView Landroid/view/View;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$markdownTextView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$contentContainer Landroid/view/View;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$headerRow Landroid/view/View;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$subtitleView Landroid/widget/TextView;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$dividerLine Landroid/view/View;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$cardContainer Landroid/view/View;
    const/4 v1, 2
    invoke-direct v0, v1, v10, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 14
    # ins_size=3
    new-instance v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;
    iget-object v1, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$content Ljava/lang/String;
    iget-object v2, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$loadingView Landroid/view/View;
    iget-object v3, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$markdownTextView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    iget-object v4, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v5, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$contentContainer Landroid/view/View;
    iget-object v6, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$headerRow Landroid/view/View;
    iget-object v7, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$subtitleView Landroid/widget/TextView;
    iget-object v8, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$dividerLine Landroid/view/View;
    iget-object v9, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$cardContainer Landroid/view/View;
    move-object v0, v12
    move-object v10, v13
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;-><init>(Ljava/lang/String; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Lkotlin/coroutines/Continuation;)V
    check-cast v12, Lkotlin/coroutines/Continuation;
    return-object v12
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 16
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->label I
    if-nez v0, +067h
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$content Ljava/lang/String;
    check-cast v15, Ljava/lang/CharSequence;
    const/4 v0, 0
    if-eqz v15, +00bh
    invoke-interface v15, Ljava/lang/CharSequence;->length()I
    move-result v15
    if-nez v15, +003h
    goto +3h
    move v15, v0
    goto +2h
    const/4 v15, 1
    if-nez v15, +03fh
    iget-object v15, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$loadingView Landroid/view/View;
    const/16 v1, 8
    invoke-virtual v15, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$loadingView Landroid/view/View;
    invoke-virtual v15, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v15
    instance-of v1, v15, Landroid/view/View;
    if-eqz v1, +005h
    check-cast v15, Landroid/view/View;
    goto +2h
    const/4 v15, 0
    if-eqz v15, +00eh
    invoke-virtual v15, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v1
    if-eqz v1, +005h
    const/4 v2, -2
    iput v2, v1, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v15, Landroid/view/View;->requestLayout()V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$markdownTextView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    invoke-virtual v15, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setVisibility(I)V
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;
    iget-object v2, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$markdownTextView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    iget-object v15, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v0, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$content Ljava/lang/String;
    invoke-static v15, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->access$truncateForPreview(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    const/4 v4, 1
    const/4 v5, 0
    const/16 v6, 8
    const/4 v7, 0
    invoke-static/range v1 ... v7, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->setMarkdownContent$default(Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper; Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle; I Ljava/lang/Object;)V
    goto +10h
    iget-object v8, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v9, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$contentContainer Landroid/view/View;
    iget-object v10, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$headerRow Landroid/view/View;
    iget-object v11, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$subtitleView Landroid/widget/TextView;
    iget-object v12, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$dividerLine Landroid/view/View;
    iget-object v13, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2;->$cardContainer Landroid/view/View;
    invoke-static/range v8 ... v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->access$collapseToFileCard(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View;)V
    sget-object v15, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v15
    new-instance v15, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v15, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v15
.end method
