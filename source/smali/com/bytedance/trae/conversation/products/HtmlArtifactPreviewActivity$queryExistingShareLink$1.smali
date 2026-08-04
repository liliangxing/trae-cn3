# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "HtmlArtifactPreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $isLocal:Z
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;


.method constructor <init>(boolean  com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->$isLocal Z
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->$isLocal Z
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;-><init>(Z Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->label I
    const-string v2, "active"
    const/4 v3, 2
    const/4 v4, 0
    const/4 v5, 1
    const/4 v6, 0
    if-eqz v1, +017h
    if-eq v1, v5, +011h
    if-ne v1, v3, +007h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0e8h
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +58h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-boolean v10, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->$isLocal Z
    const-string v1, "downloadTarget"
    if-eqz v10, +093h
    iget-object v10, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$getRealPath$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v10
    check-cast v10, Ljava/lang/CharSequence;
    iget-object v3, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-interface v10, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-nez v7, +004h
    move v7, v5
    goto +2h
    move v7, v4
    if-eqz v7, +018h
    invoke-static v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$getDownloadTarget$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    move-result-object v10
    if-nez v10, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v6
    invoke-virtual v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->getLocalRequestPath()Ljava/lang/String;
    move-result-object v10
    const-string v1, "package/"
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v10, v1, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v10
    check-cast v10, Ljava/lang/String;
    sget-object v1, Lcom/bytedance/trae/conversation/products/IShareLinkApi;->Companion Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;
    new-instance v3, Lcom/bytedance/trae/conversation/products/GetLocalShareLinkRequest;
    iget-object v7, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$getConversationId$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v7
    if-nez v7, +008h
    const-string v7, "conversationId"
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v6
    invoke-direct v3, v7, v10, Lcom/bytedance/trae/conversation/products/GetLocalShareLinkRequest;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    move-object v10, v9
    check-cast v10, Lkotlin/coroutines/Continuation;
    iput v5, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->label I
    invoke-virtual v1, v3, v10, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;->getLocalShareLink(Lcom/bytedance/trae/conversation/products/GetLocalShareLinkRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v0, +003h
    return-object v0
    check-cast v10, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v0, +0d7h
    check-cast v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v10
    invoke-virtual v10, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/conversation/products/GetLocalShareLinkData;
    if-eqz v10, +006h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/products/GetLocalShareLinkData;->getStatus()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +0bfh
    invoke-virtual v10, Lcom/bytedance/trae/conversation/products/GetLocalShareLinkData;->getShareUrl()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +008h
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    move v4, v5
    if-nez v4, +0aeh
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/products/GetLocalShareLinkData;->getShareUrl()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$setExistingShareUrl$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Ljava/lang/String;)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/products/GetLocalShareLinkData;->getShareId()Ljava/lang/String;
    move-result-object v10
    invoke-static v0, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$setExistingShareId$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Ljava/lang/String;)V
    goto/16 +09ah
    iget-object v10, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$getRemoteArchiveUrlResolver$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    move-result-object v10
    iget-object v7, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$getDownloadTarget$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    move-result-object v7
    if-nez v7, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v6
    invoke-virtual v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->getLocalRequestPath()Ljava/lang/String;
    move-result-object v1
    iget-object v7, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$getRemoteArchiveUrlResolver$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->getWorkSpace()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v10, v1, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->normalizeFilePath(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    sget-object v1, Lcom/bytedance/trae/conversation/products/IShareLinkApi;->Companion Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;
    iget-object v7, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$getChatSessionId$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v7
    if-nez v7, +008h
    const-string v7, "chatSessionId"
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v6
    move-object v8, v9
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput v3, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->label I
    invoke-virtual v1, v7, v10, v8, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;->getRemoteShareLink(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v0, +003h
    return-object v0
    check-cast v10, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v0, +054h
    check-cast v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v10
    invoke-virtual v10, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/conversation/products/ShareArtifactData;
    if-eqz v10, +006h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/products/ShareArtifactData;->getStatus()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +03ch
    invoke-virtual v10, Lcom/bytedance/trae/conversation/products/ShareArtifactData;->getShareSessionId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +008h
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    move v4, v5
    if-nez v4, +02bh
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/products/ShareArtifactData;->getShareSessionId()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$setExistingShareId$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Ljava/lang/String;)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    sget-object v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->Companion Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$Companion;->getShareHost()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v10, Lcom/bytedance/trae/conversation/products/ShareArtifactData;->getShareSessionId()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v1, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-static v0, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$setExistingShareUrl$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Ljava/lang/String;)V
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
.end method
