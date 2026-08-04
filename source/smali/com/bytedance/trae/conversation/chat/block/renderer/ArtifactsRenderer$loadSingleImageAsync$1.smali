# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;
.super Ljava/lang/Object;
.source "ArtifactsRenderer.kt"

.implements Landroid/view/View$OnAttachStateChangeListener;

.field final synthetic $chatSessionId:Ljava/lang/String;
.field final synthetic $cliType:Ljava/lang/String;
.field final synthetic $container:Landroid/widget/FrameLayout;
.field final synthetic $context:Landroid/content/Context;
.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $draweeView:Lcom/facebook/drawee/view/SimpleDraweeView;
.field final synthetic $file:Lcom/bytedance/trae/im/model/FileDiffInfo;
.field final synthetic $maxSizePx:I
.field final synthetic $messageId:Ljava/lang/String;
.field private job:Lkotlinx/coroutines/Job;
.field private final scope:Lkotlinx/coroutines/CoroutineScope;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;


.method constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.content.Context  com.bytedance.trae.im.model.FileDiffInfo  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.facebook.drawee.view.SimpleDraweeView  android.widget.FrameLayout  int)void
    .registers 11
    # ins_size=11
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->$context Landroid/content/Context;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->$file Lcom/bytedance/trae/im/model/FileDiffInfo;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->$cliType Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->$chatSessionId Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->$conversationId Ljava/lang/String;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->$messageId Ljava/lang/String;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->$draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->$container Landroid/widget/FrameLayout;
    iput v10, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->$maxSizePx I
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    invoke-static Lkotlinx/coroutines/CoroutineScopeKt;->MainScope()Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->scope Lkotlinx/coroutines/CoroutineScope;
    return-void 
.end method

.method public onViewAttachedToWindow(android.view.View)void
    .registers 21
    # ins_size=2
    move-object/from16 v0, v19
    const-string/jumbo v1, v
    move-object/from16 v2, v20
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->job Lkotlinx/coroutines/Job;
    if-eqz v1, +007h
    const/4 v2, 1
    const/4 v3, 0
    invoke-static v1, v3, v2, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v5, 0
    const/4 v6, 0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;
    iget-object v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->$context Landroid/content/Context;
    iget-object v10, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->$file Lcom/bytedance/trae/im/model/FileDiffInfo;
    iget-object v11, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->$cliType Ljava/lang/String;
    iget-object v12, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->$chatSessionId Ljava/lang/String;
    iget-object v13, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->$conversationId Ljava/lang/String;
    iget-object v14, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->$messageId Ljava/lang/String;
    iget-object v15, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->$draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->$container Landroid/widget/FrameLayout;
    iget v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->$maxSizePx I
    const/16 v18, 0
    move-object v7, v1
    move-object/from16 v16, v2
    move/from16 v17, v3
    invoke-direct/range v7 ... v18, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/content/Context; Lcom/bytedance/trae/im/model/FileDiffInfo; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/facebook/drawee/view/SimpleDraweeView; Landroid/widget/FrameLayout; I Lkotlin/coroutines/Continuation;)V
    move-object v7, v1
    check-cast v7, Lkotlin/jvm/functions/Function2;
    const/4 v8, 3
    const/4 v9, 0
    invoke-static/range v4 ... v9, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->job Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public onViewDetachedFromWindow(android.view.View)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, v
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;->job Lkotlinx/coroutines/Job;
    if-eqz v3, +007h
    const/4 v0, 1
    const/4 v1, 0
    invoke-static v3, v1, v0, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    return-void 
.end method
