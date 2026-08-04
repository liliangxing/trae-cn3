# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "MultiImagePreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $requestTargets:Ljava/util/Map;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;


.method constructor <init>(java.util.Map  com.bytedance.trae.conversation.products.MultiImagePreviewActivity  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1;->$requestTargets Ljava/util/Map;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1;->$requestTargets Ljava/util/Map;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1;-><init>(Ljava/util/Map; Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +4dh
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v8, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi;->Companion Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;
    new-instance v1, Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1;->$requestTargets Ljava/util/Map;
    invoke-interface v3, Ljava/util/Map;->values()Ljava/util/Collection;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->distinct(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v3
    iget-object v4, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getConversationId$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    if-nez v4, +008h
    const-string v4, "conversationId"
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v5
    iget-object v6, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v6, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getMessageId$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +008h
    const-string v6, "messageId"
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v5, v6
    invoke-static v2, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v6
    invoke-direct v1, v3, v4, v5, v6, Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean;)V
    move-object v3, v7
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1;->label I
    invoke-virtual v8, v1, v3, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;->getDownloadUrlRawCall(Lcom/bytedance/trae/im/service/GetDownloadUrlRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    return-object v8
.end method
