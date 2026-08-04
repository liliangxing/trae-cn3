# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactsRenderer.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cardContainer:Landroid/view/View;
.field final synthetic $cliType:Ljava/lang/String;
.field final synthetic $content:Ljava/lang/String;
.field final synthetic $contentContainer:Landroid/view/View;
.field final synthetic $dividerLine:Landroid/view/View;
.field final synthetic $downloadExtras:Lorg/json/JSONObject;
.field final synthetic $headerRow:Landroid/view/View;
.field final synthetic $loadingView:Landroid/view/View;
.field final synthetic $subtitleView:Landroid/widget/TextView;
.field final synthetic $textView:Landroid/widget/TextView;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;


.method constructor <init>(java.lang.String  java.lang.String  org.json.JSONObject  android.view.View  android.widget.TextView  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.view.View  android.view.View  android.widget.TextView  android.view.View  android.view.View  kotlin.coroutines.Continuation)void
    .registers 13
    # ins_size=13
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$content Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$cliType Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$downloadExtras Lorg/json/JSONObject;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$loadingView Landroid/view/View;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$textView Landroid/widget/TextView;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$contentContainer Landroid/view/View;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$headerRow Landroid/view/View;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$subtitleView Landroid/widget/TextView;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$dividerLine Landroid/view/View;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$cardContainer Landroid/view/View;
    const/4 v1, 2
    invoke-direct v0, v1, v12, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 16
    # ins_size=3
    new-instance v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;
    iget-object v1, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$content Ljava/lang/String;
    iget-object v2, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$cliType Ljava/lang/String;
    iget-object v3, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$downloadExtras Lorg/json/JSONObject;
    iget-object v4, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$loadingView Landroid/view/View;
    iget-object v5, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$textView Landroid/widget/TextView;
    iget-object v6, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v7, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$contentContainer Landroid/view/View;
    iget-object v8, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$headerRow Landroid/view/View;
    iget-object v9, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$subtitleView Landroid/widget/TextView;
    iget-object v10, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$dividerLine Landroid/view/View;
    iget-object v11, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$cardContainer Landroid/view/View;
    move-object v0, v14
    move-object v12, v15
    invoke-direct/range v0 ... v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;-><init>(Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject; Landroid/view/View; Landroid/widget/TextView; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Lkotlin/coroutines/Continuation;)V
    check-cast v14, Lkotlin/coroutines/Continuation;
    return-object v14
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->label I
    if-nez v0, +05fh
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$content Ljava/lang/String;
    check-cast v14, Ljava/lang/CharSequence;
    const/4 v0, 0
    if-eqz v14, +00bh
    invoke-interface v14, Ljava/lang/CharSequence;->length()I
    move-result v14
    if-nez v14, +003h
    goto +3h
    move v14, v0
    goto +2h
    const/4 v14, 1
    if-nez v14, +028h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v2, "fetch_file_content"
    iget-object v3, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$cliType Ljava/lang/String;
    const-string/jumbo v4, success
    const-string v5, ""
    iget-object v6, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$downloadExtras Lorg/json/JSONObject;
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$loadingView Landroid/view/View;
    const/16 v1, 8
    invoke-virtual v14, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$textView Landroid/widget/TextView;
    invoke-virtual v14, v0, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$textView Landroid/widget/TextView;
    iget-object v0, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$content Ljava/lang/String;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v14, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto +1fh
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v2, "fetch_file_content"
    iget-object v3, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$cliType Ljava/lang/String;
    const-string v4, "failed"
    const-string v5, ""
    iget-object v6, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$downloadExtras Lorg/json/JSONObject;
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    iget-object v7, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v8, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$contentContainer Landroid/view/View;
    iget-object v9, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$headerRow Landroid/view/View;
    iget-object v10, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$subtitleView Landroid/widget/TextView;
    iget-object v11, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$dividerLine Landroid/view/View;
    iget-object v12, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2;->$cardContainer Landroid/view/View;
    invoke-static/range v7 ... v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->access$collapseToFileCard(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View;)V
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
.end method
