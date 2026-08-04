# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactsRenderer.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $chatSessionId:Ljava/lang/String;
.field final synthetic $cliType:Ljava/lang/String;
.field final synthetic $context:Landroid/content/Context;
.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $files:Ljava/util/List;
.field final synthetic $imageViews:Ljava/util/List;
.field final synthetic $messageId:Ljava/lang/String;
.field  I$0:I
.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  L$2:Ljava/lang/Object;
.field  L$3:Ljava/lang/Object;
.field  L$4:Ljava/lang/Object;
.field  L$5:Ljava/lang/Object;
.field  L$6:Ljava/lang/Object;
.field  L$7:Ljava/lang/Object;
.field  L$8:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;


.method constructor <init>(java.lang.String  java.util.List  java.util.List  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.content.Context  kotlin.coroutines.Continuation)void
    .registers 10
    # ins_size=10
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$files Ljava/util/List;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$imageViews Ljava/util/List;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$chatSessionId Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$messageId Ljava/lang/String;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$context Landroid/content/Context;
    const/4 v1, 2
    invoke-direct v0, v1, v9, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 13
    # ins_size=3
    new-instance v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;
    iget-object v1, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    iget-object v2, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$files Ljava/util/List;
    iget-object v3, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$imageViews Ljava/util/List;
    iget-object v4, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$chatSessionId Ljava/lang/String;
    iget-object v5, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    iget-object v6, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$messageId Ljava/lang/String;
    iget-object v7, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v8, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$context Landroid/content/Context;
    move-object v0, v11
    move-object v9, v12
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;-><init>(Ljava/lang/String; Ljava/util/List; Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/content/Context; Lkotlin/coroutines/Continuation;)V
    check-cast v11, Lkotlin/coroutines/Continuation;
    return-object v11
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 40
    # ins_size=2
    move-object/from16 v1, v38
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->label I
    const-string v3, ""
    const/16 v4, 95
    const/4 v5, 3
    const-string v6, "messageId"
    const-string v7, "conversationId"
    const-string v8, "chatSessionId"
    const/4 v9, 4
    const/4 v10, 2
    const/4 v11, 0
    const/4 v12, 1
    if-eqz v2, +07bh
    if-eq v2, v12, +070h
    if-eq v2, v10, +057h
    if-eq v2, v5, +041h
    if-ne v2, v9, +037h
    iget v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->I$0 I
    iget-object v3, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$8 Ljava/lang/Object;
    check-cast v3, Ljava/util/Iterator;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$7 Ljava/lang/Object;
    check-cast v4, Landroid/content/Context;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$6 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$5 Ljava/lang/Object;
    check-cast v14, Ljava/lang/String;
    iget-object v15, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$4 Ljava/lang/Object;
    check-cast v15, Ljava/lang/String;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$3 Ljava/lang/Object;
    check-cast v9, Ljava/util/List;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$2 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$1 Ljava/lang/Object;
    check-cast v13, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$0 Ljava/lang/Object;
    check-cast v12, Ljava/util/List;
    invoke-static/range v39, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v33, v6
    move-object/from16 v34, v7
    move-object/from16 v17, v8
    move-object v8, v11
    const/4 v7, 2
    move-object v6, v5
    const/4 v5, 4
    goto/16 +40ah
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->I$0 I
    iget-object v3, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$2 Ljava/lang/Object;
    check-cast v3, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$1 Ljava/lang/Object;
    check-cast v9, Lorg/json/JSONObject;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$0 Ljava/lang/Object;
    check-cast v10, Ljava/util/List;
    invoke-static/range v39, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v4, v1
    goto/16 +25ch
    iget v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->I$0 I
    iget-object v3, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$2 Ljava/lang/Object;
    check-cast v3, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$1 Ljava/lang/Object;
    check-cast v9, Lorg/json/JSONObject;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$0 Ljava/lang/Object;
    check-cast v10, Ljava/util/List;
    invoke-static/range v39, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v4, v39
    move-object v12, v10
    move-object v10, v1
    goto/16 +1eah
    invoke-static/range v39, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v39
    goto +31h
    move-exception v0
    goto/16 +45bh
    invoke-static/range v39, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$cliType Ljava/lang/String;
    sget-object v9, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v9, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v9
    invoke-static v2, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +12dh
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v2
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    new-instance v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$1;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$chatSessionId Ljava/lang/String;
    invoke-direct v5, v9, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v5, Lkotlin/jvm/functions/Function2;
    move-object v9, v1
    check-cast v9, Lkotlin/coroutines/Continuation;
    const/4 v10, 1
    iput v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->label I
    invoke-static v2, v5, v9, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v0, +003h
    return-object v0
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult;
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    iget-object v5, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$chatSessionId Ljava/lang/String;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$messageId Ljava/lang/String;
    invoke-virtual v0, v8, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v0, v7, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v0, v6, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    instance-of v5, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v5, +09ah
    move-object v4, v2
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/service/ChatSessionResponse;
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getExplorerUrl()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v11
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/ChatSessionResponse;
    if-eqz v2, +006h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getWorkspacePath()Ljava/lang/String;
    move-result-object v11
    move-object v2, v4
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    const/4 v12, 0
    goto +2h
    const/4 v12, 1
    if-nez v12, +050h
    sget-object v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v13, "fetch_img_url"
    const-string v14, "remote"
    const-string/jumbo v15, success
    const-string v16, ""
    move-object/from16 v17, v0
    invoke-virtual/range v12 ... v17, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$files Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$imageViews Ljava/util/List;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const/4 v13, 0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +3c4h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    add-int/lit8 v7, v13, 1
    if-gez v13, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v6, Lcom/bytedance/trae/im/model/FileDiffInfo;
    invoke-virtual v6, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    move-object v6, v3
    invoke-static v2, v6, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->access$normalizeFilePath(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    invoke-static v2, v4, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->access$buildFileUrl(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    invoke-interface v5, v13, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-static v6, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v6
    invoke-virtual v8, v6, Lcom/facebook/drawee/view/SimpleDraweeView;->setImageURI(Landroid/net/Uri;)V
    move v13, v7
    goto -30h
    sget-object v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v13, "fetch_img_url"
    const-string v14, "remote"
    const-string v15, "failed"
    const-string/jumbo v16, url_is_null
    move-object/from16 v17, v0
    invoke-virtual/range v12 ... v17, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    goto/16 +387h
    instance-of v3, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v3, +032h
    sget-object v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v13, "fetch_img_url"
    const-string v14, "remote"
    const-string v15, "failed"
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    move-object v5, v2
    check-cast v5, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v5, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v5
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v16
    move-object/from16 v17, v0
    invoke-virtual/range v12 ... v17, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    goto +10h
    sget-object v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v13, "fetch_img_url"
    const-string v14, "remote"
    const-string v15, "failed"
    const-string v16, "other"
    move-object/from16 v17, v0
    invoke-virtual/range v12 ... v17, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$imageViews Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +336h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/facebook/drawee/view/SimpleDraweeView;
    sget v3, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_image_break I
    invoke-virtual v2, v3, Lcom/facebook/drawee/view/SimpleDraweeView;->setImageResource(I)V
    goto -11h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$files Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    new-instance v9, Ljava/util/ArrayList;
    const/16 v10, 10
    invoke-static v2, v10, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v10
    invoke-direct v9, v10, Ljava/util/ArrayList;-><init>(I)V
    check-cast v9, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v10
    if-eqz v10, +041h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/im/model/FileDiffInfo;
    invoke-virtual v10, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v10
    if-nez v10, +003h
    move-object v10, v3
    const-string v12, "/"
    const/4 v13, 2
    const/4 v14, 0
    invoke-static v10, v12, v14, v13, v11, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v12
    if-eqz v12, +016h
    new-instance v12, Ljava/lang/StringBuilder;
    invoke-direct v12, Ljava/lang/StringBuilder;-><init>()V
    const-string v13, "files"
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    goto +11h
    new-instance v12, Ljava/lang/StringBuilder;
    invoke-direct v12, Ljava/lang/StringBuilder;-><init>()V
    const-string v13, "files/"
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    goto -14h
    invoke-interface v9, v10, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -44h
    check-cast v9, Ljava/util/List;
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$chatSessionId Ljava/lang/String;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$messageId Ljava/lang/String;
    invoke-virtual v2, v8, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v2, v7, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v2, v6, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v3, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v3, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    move-object v10, v1
    const/4 v12, 4
    const/4 v14, 0
    if-ge v14, v12, +107h
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v12
    check-cast v12, Lkotlin/coroutines/CoroutineContext;
    new-instance v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$2;
    iget-object v15, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    iget-object v4, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$messageId Ljava/lang/String;
    invoke-direct v13, v9, v15, v4, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$result$2;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v13, Lkotlin/jvm/functions/Function2;
    move-object v4, v10
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput-object v9, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$0 Ljava/lang/Object;
    iput-object v2, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$1 Ljava/lang/Object;
    iput-object v3, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$2 Ljava/lang/Object;
    iput v14, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->I$0 I
    const/4 v15, 2
    iput v15, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->label I
    invoke-static v12, v13, v4, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v0, +003h
    return-object v0
    move-object v12, v9
    move-object v9, v2
    move v2, v14
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v13, v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v13, +08eh
    move-object v13, v4
    check-cast v13, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v13, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v13
    invoke-virtual v13, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Lcom/bytedance/trae/im/service/GetDownloadUrlData;
    if-eqz v13, +007h
    invoke-virtual v13, Lcom/bytedance/trae/im/service/GetDownloadUrlData;->getUrlMap()Ljava/util/Map;
    move-result-object v13
    goto +2h
    move-object v13, v11
    iput-object v13, v3, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    iget-object v13, v3, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v13, Ljava/util/Map;
    if-eqz v13, +00bh
    invoke-interface v13, Ljava/util/Map;->isEmpty()Z
    move-result v13
    if-eqz v13, +003h
    goto +3h
    const/4 v13, 0
    goto +2h
    const/4 v13, 1
    if-nez v13, +005h
    const/4 v13, 1
    goto/16 +0a8h
    move-object v13, v4
    check-cast v13, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v13, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v13
    invoke-virtual v13, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v13
    const-wide/16 v21, 202
    cmp-long v13, v13, v21
    if-nez v13, +025h
    move-object v4, v10
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput-object v12, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$0 Ljava/lang/Object;
    iput-object v9, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$1 Ljava/lang/Object;
    iput-object v3, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$2 Ljava/lang/Object;
    iput v2, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->I$0 I
    iput v5, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->label I
    const-wide/16 v13, 50
    invoke-static v13, v14, v4, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v0, +003h
    return-object v0
    move-object v4, v10
    move-object v10, v12
    const/4 v13, 1
    add-int/lit8 v14, v2, 1
    move-object v2, v9
    move-object v9, v10
    const/4 v12, 4
    move-object v10, v4
    const/16 v4, 95
    goto/16 -08fh
    const/4 v13, 1
    sget-object v21, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v22, "fetch_img_url"
    const-string v23, "local"
    const-string v24, "failed"
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    const-string v5, "code_"
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v4
    invoke-virtual v2, v4, v5, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v25
    move-object/from16 v26, v9
    invoke-virtual/range v21 ... v26, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    goto +47h
    const/4 v13, 1
    instance-of v2, v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v2, +034h
    sget-object v21, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v22, "fetch_img_url"
    const-string v23, "local"
    const-string v24, "failed"
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v5, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v5, 95
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v25
    move-object/from16 v26, v9
    invoke-virtual/range v21 ... v26, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    goto +10h
    sget-object v21, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v22, "fetch_img_url"
    const-string v23, "local"
    const-string v24, "failed"
    const-string v25, "other"
    move-object/from16 v26, v9
    invoke-virtual/range v21 ... v26, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    move-object/from16 v24, v9
    move-object v9, v12
    goto +4h
    const/4 v13, 1
    move-object/from16 v24, v2
    iget-object v2, v3, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v2, Ljava/util/Map;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/util/Map;->isEmpty()Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    move v2, v13
    if-nez v2, +152h
    new-instance v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-direct v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;-><init>()V
    iget-object v4, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$files Ljava/util/List;
    check-cast v4, Ljava/lang/Iterable;
    iget-object v5, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$imageViews Ljava/util/List;
    iget-object v12, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$chatSessionId Ljava/lang/String;
    iget-object v14, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$conversationId Ljava/lang/String;
    iget-object v15, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$messageId Ljava/lang/String;
    iget-object v13, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$context Landroid/content/Context;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    const/4 v11, 0
    move-object/from16 v35, v10
    move-object v10, v2
    move-object/from16 v2, v35
    move-object/from16 v36, v13
    move-object v13, v3
    move-object v3, v4
    move-object/from16 v4, v36
    move-object/from16 v37, v9
    move-object v9, v5
    move-object v5, v15
    move-object v15, v12
    move-object/from16 v12, v37
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v20
    if-eqz v20, +166h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v20
    add-int/lit8 v1, v11, 1
    if-gez v11, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v20, Lcom/bytedance/trae/im/model/FileDiffInfo;
    invoke-interface v12, v11, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v20
    move-object/from16 v39, v0
    move-object/from16 v0, v20
    check-cast v0, Ljava/lang/String;
    move/from16 v31, v1
    iget-object v1, v13, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v1, Ljava/util/Map;
    invoke-interface v1, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    move-object/from16 v32, v3
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v3, v8, v15, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v3, v7, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v3, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    move-object/from16 v33, v6
    const-string v6, "path"
    invoke-virtual v3, v6, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v6, url
    invoke-virtual v3, v6, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto +3h
    move-object/from16 v33, v6
    move-object v6, v1
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +00bh
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-nez v6, +003h
    goto +3h
    const/4 v6, 0
    goto +2h
    const/4 v6, 1
    if-nez v6, +096h
    sget-object v20, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v21, "fetch_img_url"
    const-string v22, "local"
    const-string/jumbo v23, success
    const-string v24, ""
    move-object/from16 v25, v3
    invoke-virtual/range v20 ... v25, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    const-string v6, "content://"
    move-object/from16 v18, v5
    move-object/from16 v34, v7
    move-object/from16 v17, v8
    const/4 v5, 0
    const/4 v7, 2
    const/4 v8, 0
    invoke-static v1, v6, v5, v7, v8, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +05dh
    const-string v6, "file://"
    invoke-static v1, v6, v5, v7, v8, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +003h
    goto +53h
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v6
    check-cast v6, Lkotlin/coroutines/CoroutineContext;
    new-instance v30, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;
    const/16 v29, 0
    move-object/from16 v20, v30
    move-object/from16 v21, v10
    move-object/from16 v22, v4
    move-object/from16 v23, v1
    move-object/from16 v24, v14
    move-object/from16 v25, v0
    move-object/from16 v26, v3
    move-object/from16 v27, v9
    move/from16 v28, v11
    invoke-direct/range v20 ... v29, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1;-><init>(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject; Ljava/util/List; I Lkotlin/coroutines/Continuation;)V
    move-object/from16 v0, v30
    check-cast v0, Lkotlin/jvm/functions/Function2;
    iput-object v12, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$0 Ljava/lang/Object;
    iput-object v13, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$1 Ljava/lang/Object;
    iput-object v10, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$2 Ljava/lang/Object;
    iput-object v9, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$3 Ljava/lang/Object;
    iput-object v15, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$4 Ljava/lang/Object;
    iput-object v14, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$5 Ljava/lang/Object;
    move-object/from16 v3, v18
    iput-object v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$6 Ljava/lang/Object;
    iput-object v4, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$7 Ljava/lang/Object;
    move-object/from16 v1, v32
    iput-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->L$8 Ljava/lang/Object;
    move/from16 v11, v31
    iput v11, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->I$0 I
    const/4 v5, 4
    iput v5, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->label I
    invoke-static v6, v0, v2, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    move-object/from16 v6, v39
    if-ne v0, v6, +003h
    return-object v6
    move-object v0, v6
    move-object v6, v3
    move-object v3, v1
    move-object v1, v2
    move v2, v11
    move v11, v2
    move-object v2, v1
    move-object v1, v6
    goto +46h
    move-object/from16 v6, v39
    move-object/from16 v3, v18
    move/from16 v16, v31
    move-object/from16 v0, v32
    const/4 v5, 4
    invoke-interface v9, v11, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-static v1, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v1
    invoke-virtual v11, v1, Lcom/facebook/drawee/view/SimpleDraweeView;->setImageURI(Landroid/net/Uri;)V
    move-object v1, v3
    goto +2ah
    move-object/from16 v6, v39
    move-object v1, v5
    move-object/from16 v34, v7
    move-object/from16 v17, v8
    move/from16 v16, v31
    move-object/from16 v0, v32
    const/4 v5, 4
    const/4 v7, 2
    const/4 v8, 0
    sget-object v20, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v21, "download_img"
    const-string v22, "local"
    const-string v23, "failed"
    const-string/jumbo v24, url_map_is_null
    move-object/from16 v25, v3
    invoke-virtual/range v20 ... v25, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    invoke-interface v9, v11, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/facebook/drawee/view/SimpleDraweeView;
    sget v11, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_image_break I
    invoke-virtual v3, v11, Lcom/facebook/drawee/view/SimpleDraweeView;->setImageResource(I)V
    move-object v3, v0
    move-object v0, v6
    move/from16 v11, v16
    move-object v5, v1
    move-object/from16 v8, v17
    move-object/from16 v6, v33
    move-object/from16 v7, v34
    move-object/from16 v1, v38
    goto/16 -124h
    sget-object v19, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v20, "download_img"
    const-string v21, "local"
    const-string v22, "failed"
    const-string/jumbo v23, url_map_is_null
    invoke-virtual/range v19 ... v24, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$files Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    iget-object v1, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;->$imageViews Ljava/util/List;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const/4 v13, 0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +027h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    add-int/lit8 v3, v13, 1
    if-gez v13, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v2, Lcom/bytedance/trae/im/model/FileDiffInfo;
    invoke-interface v1, v13, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/facebook/drawee/view/SimpleDraweeView;
    sget v4, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_image_break I
    invoke-virtual v2, v4, Lcom/facebook/drawee/view/SimpleDraweeView;->setImageResource(I)V
    move v13, v3
    goto -1fh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "loadImagesAsync error"
    check-cast v0, Ljava/lang/Throwable;
    const-string v3, "AgentBlock"
    invoke-virtual v1, v3, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0x47
    :try_start_0x6c
    :try_start_0x80
    :try_start_0x95
    :try_start_0xcc
    :try_start_0xd5
    :try_start_0x235
    :try_start_0x23e
    :try_start_0x304
    :try_start_0x350
    :try_start_0x3bc
    :try_start_0x3c7
    :try_start_0x3d5
.end method
