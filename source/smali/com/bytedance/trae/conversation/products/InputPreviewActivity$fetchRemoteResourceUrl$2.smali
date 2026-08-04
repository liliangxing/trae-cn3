# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "InputPreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $resourceUri:Ljava/lang/String;
.field private synthetic L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/InputPreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.InputPreviewActivity  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;->$resourceUri Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;->$resourceUri Ljava/lang/String;
    invoke-direct v0, v1, v2, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=2
    const-string v0, "fetchRemoteResourceUrl missing url, resourceUri="
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;->label I
    const-string v3, "fileName"
    const-string v4, ", fileName="
    const-string v5, "InputPreviewActivity"
    const-string v6, "oidId"
    const/4 v7, 1
    const/4 v8, 0
    if-eqz v2, +018h
    if-ne v2, v7, +00eh
    iget-object v1, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;->L$1 Ljava/lang/Object;
    check-cast v1, Ljava/lang/String;
    iget-object v2, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +34h
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;->L$0 Ljava/lang/Object;
    check-cast v14, Lkotlinx/coroutines/CoroutineScope;
    iget-object v2, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    iget-object v14, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;->$resourceUri Ljava/lang/String;
    sget-object v9, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getResourceUploadApi(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    move-result-object v9
    new-instance v10, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;
    invoke-static v14, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v11
    sget-object v12, Lcom/bytedance/trae/conversation/fileupload/BizType;->RemoteResource Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-direct v10, v11, v12, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;-><init>(Ljava/util/List; Lcom/bytedance/trae/conversation/fileupload/BizType;)V
    iput-object v2, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;->L$0 Ljava/lang/Object;
    iput-object v14, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;->L$1 Ljava/lang/Object;
    iput v7, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;->label I
    invoke-virtual v9, v10, v13, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;->getResourceUrl(Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v1, +003h
    return-object v1
    move-object v1, v14
    move-object v14, v9
    check-cast v14, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlResponse;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlResponse;->getUrlMap()Ljava/util/Map;
    move-result-object v14
    invoke-interface v14, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Ljava/lang/String;
    if-nez v9, +01fh
    invoke-static v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getOidId$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v9
    if-nez v9, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v8
    invoke-interface v14, v9, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Ljava/lang/String;
    if-nez v9, +00dh
    invoke-static v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getExtraOidId$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v9
    invoke-interface v14, v9, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v14
    move-object v9, v14
    check-cast v9, Ljava/lang/String;
    move-object v14, v9
    check-cast v14, Ljava/lang/CharSequence;
    if-eqz v14, +00ah
    invoke-static v14, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v14
    if-eqz v14, +003h
    goto +2h
    const/4 v7, 0
    if-eqz v7, +03ah
    sget-object v14, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", oidId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-static v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getOidId$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v8
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-static v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getFileName$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v8
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v14, v5, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v9, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v14
    goto +ch
    move-exception v14
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v14, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v14
    invoke-static v14, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v14
    iget-object v0, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v14, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v1
    if-eqz v1, +040h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v9, "fetchRemoteResourceUrl failed, oidId="
    invoke-direct v7, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getOidId$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v9
    if-nez v9, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v8
    invoke-virtual v7, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-static v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getFileName$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v8
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, ", error="
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v1, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v5, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v14, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v8, v14
    return-object v8
    :try_start_0x1e
    :try_start_0x35
.end method
