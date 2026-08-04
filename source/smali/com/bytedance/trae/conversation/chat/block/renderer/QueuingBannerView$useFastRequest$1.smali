# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "QueuingBannerView.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $messageId:Ljava/lang/String;
.field final synthetic $queueId:Ljava/lang/String;
.field final synthetic $taskId:Ljava/lang/String;
.field  L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;


.method constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.chat.block.renderer.QueuingBannerView  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->$conversationId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->$taskId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->$queueId Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->$messageId Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->$conversationId Ljava/lang/String;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->$taskId Ljava/lang/String;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->$queueId Ljava/lang/String;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->$messageId Ljava/lang/String;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;
    move-object v0, v8
    move-object v6, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 23
    # ins_size=2
    move-object/from16 v1, v21
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->label I
    const-string/jumbo v3, result
    const-string v4, "im_queue_banner_click"
    const/4 v5, 5
    const/4 v6, 4
    const/4 v7, 3
    const/4 v8, 2
    const/4 v9, 1
    const/4 v10, 0
    if-eqz v0, +034h
    if-eq v0, v9, +029h
    if-eq v0, v8, +023h
    if-eq v0, v7, +01ch
    if-eq v0, v6, +015h
    if-eq v0, v5, +00ah
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->L$0 Ljava/lang/Object;
    check-cast v0, Ljava/lang/Throwable;
    invoke-static/range v22, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0fch
    invoke-static/range v22, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0d7h
    invoke-static/range v22, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0b7h
    invoke-static/range v22, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +75h
    invoke-static/range v22, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v22
    goto +4eh
    move-exception v0
    goto/16 +0c8h
    invoke-static/range v22, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    iget-object v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->$queueId Ljava/lang/String;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->$messageId Ljava/lang/String;
    const-string v13, "queue_id"
    invoke-virtual v0, v13, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v11, "message_id"
    invoke-virtual v0, v11, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v0, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v11, toString(...)
    invoke-static v0, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v11, Lcom/bytedance/trae/im/service/ConfirmTaskRequest;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->$conversationId Ljava/lang/String;
    iget-object v15, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->$taskId Ljava/lang/String;
    const-string/jumbo v16, use_fast_request
    const-string v17, ""
    const-string v18, ""
    const-string v19, ""
    move-object v13, v11
    move-object/from16 v20, v0
    invoke-direct/range v13 ... v20, Lcom/bytedance/trae/im/service/ConfirmTaskRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IConfirmTaskApi;->Companion Lcom/bytedance/trae/im/service/IConfirmTaskApi$Companion;
    new-instance v12, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$result$1;
    invoke-direct v12, v11, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$result$1;-><init>(Lcom/bytedance/trae/im/service/ConfirmTaskRequest; Lkotlin/coroutines/Continuation;)V
    check-cast v12, Lkotlin/jvm/functions/Function2;
    move-object v11, v1
    check-cast v11, Lkotlin/coroutines/Continuation;
    iput v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->label I
    invoke-virtual v0, v12, v11, Lcom/bytedance/trae/im/service/IConfirmTaskApi$Companion;->safeCall(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v0, +02eh
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v7, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$1;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;
    invoke-direct v7, v9, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/jvm/functions/Function2;
    move-object v9, v1
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->label I
    invoke-static v0, v7, v9, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v7, Lorg/json/JSONObject;
    invoke-direct v7, Lorg/json/JSONObject;-><init>()V
    const/4 v8, 0
    invoke-virtual v7, v3, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v0, v4, v7, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    goto +2dh
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v8, Lorg/json/JSONObject;
    invoke-direct v8, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v8, v3, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v0, v4, v8, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$4;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;
    iget-object v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->$messageId Ljava/lang/String;
    invoke-direct v3, v4, v8, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$4;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v7, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->label I
    invoke-static v0, v3, v4, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$5;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;
    invoke-direct v3, v4, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$5;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v6, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->label I
    invoke-static v0, v3, v4, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v3
    check-cast v3, Lkotlin/coroutines/CoroutineContext;
    new-instance v4, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$5;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;
    invoke-direct v4, v6, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1$5;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    move-object v6, v1
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->L$0 Ljava/lang/Object;
    iput v5, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView$useFastRequest$1;->label I
    invoke-static v3, v4, v6, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v2, +003h
    return-object v2
    throw v0
    :try_start_0x35
    :try_start_0x4a
.end method
