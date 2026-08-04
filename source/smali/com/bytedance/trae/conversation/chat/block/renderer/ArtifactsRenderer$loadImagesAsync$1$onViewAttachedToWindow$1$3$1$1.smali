# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactsRenderer.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cacheFile:Ljava/io/File;
.field final synthetic $fileExtras:Lorg/json/JSONObject;
.field final synthetic $imageViews:Ljava/util/List;
.field final synthetic $index:I
.field  label:I


.method constructor <init>(java.io.File  org.json.JSONObject  java.util.List  int  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;->$cacheFile Ljava/io/File;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;->$fileExtras Lorg/json/JSONObject;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;->$imageViews Ljava/util/List;
    iput v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;->$index I
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;->$cacheFile Ljava/io/File;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;->$fileExtras Lorg/json/JSONObject;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;->$imageViews Ljava/util/List;
    iget v4, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;->$index I
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;-><init>(Ljava/io/File; Lorg/json/JSONObject; Ljava/util/List; I Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;->label I
    if-nez v0, +060h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;->$cacheFile Ljava/io/File;
    if-eqz v8, +038h
    invoke-virtual v8, Ljava/io/File;->exists()Z
    move-result v8
    if-eqz v8, +032h
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;->$cacheFile Ljava/io/File;
    invoke-virtual v8, Ljava/io/File;->length()J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v8, v0, v2
    if-lez v8, +026h
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v1, "download_img"
    const-string v2, "local"
    const-string/jumbo v3, success
    const-string v4, ""
    iget-object v5, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;->$fileExtras Lorg/json/JSONObject;
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;->$imageViews Ljava/util/List;
    iget v0, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;->$index I
    invoke-interface v8, v0, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/facebook/drawee/view/SimpleDraweeView;
    iget-object v0, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;->$cacheFile Ljava/io/File;
    invoke-static v0, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;
    move-result-object v0
    invoke-virtual v8, v0, Lcom/facebook/drawee/view/SimpleDraweeView;->setImageURI(Landroid/net/Uri;)V
    goto +1fh
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v2, "download_img"
    const-string v3, "local"
    const-string v4, "failed"
    const-string v5, "download_error"
    iget-object v6, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;->$fileExtras Lorg/json/JSONObject;
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;->$imageViews Ljava/util/List;
    iget v0, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1;->$index I
    invoke-interface v8, v0, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/facebook/drawee/view/SimpleDraweeView;
    sget v0, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_image_break I
    invoke-virtual v8, v0, Lcom/facebook/drawee/view/SimpleDraweeView;->setImageResource(I)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
.end method
