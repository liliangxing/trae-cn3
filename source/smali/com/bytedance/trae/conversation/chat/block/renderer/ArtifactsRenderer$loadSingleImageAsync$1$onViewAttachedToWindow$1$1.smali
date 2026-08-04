# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactsRenderer.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $container:Landroid/widget/FrameLayout;
.field final synthetic $draweeView:Lcom/facebook/drawee/view/SimpleDraweeView;
.field final synthetic $imageUri:Landroid/net/Uri;
.field final synthetic $maxSizePx:I
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;


.method constructor <init>(android.net.Uri  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  com.facebook.drawee.view.SimpleDraweeView  android.widget.FrameLayout  int  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;->$imageUri Landroid/net/Uri;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;->$draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;->$container Landroid/widget/FrameLayout;
    iput v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;->$maxSizePx I
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;->$imageUri Landroid/net/Uri;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;->$draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;->$container Landroid/widget/FrameLayout;
    iget v5, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;->$maxSizePx I
    move-object v0, v8
    move-object v6, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;-><init>(Landroid/net/Uri; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Lcom/facebook/drawee/view/SimpleDraweeView; Landroid/widget/FrameLayout; I Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;->label I
    if-nez v0, +01fh
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;->$imageUri Landroid/net/Uri;
    if-eqz v5, +00eh
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;->$draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;->$container Landroid/widget/FrameLayout;
    iget v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;->$maxSizePx I
    invoke-static v0, v1, v2, v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->access$setImageWithResize(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Lcom/facebook/drawee/view/SimpleDraweeView; Landroid/widget/FrameLayout; I Landroid/net/Uri;)V
    goto +8h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1;->$draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    sget v0, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_image_break I
    invoke-virtual v5, v0, Lcom/facebook/drawee/view/SimpleDraweeView;->setImageResource(I)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
.end method
