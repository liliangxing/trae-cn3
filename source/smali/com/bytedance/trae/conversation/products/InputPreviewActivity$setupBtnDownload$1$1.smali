# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "InputPreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $isLocalWork:Z
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/InputPreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.InputPreviewActivity  boolean  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;->$isLocalWork Z
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;->$isLocalWork Z
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Z Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ah
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    move-object v1, v13
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v2, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;->label I
    invoke-static v14, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$fetchFileUrl(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v0, +003h
    return-object v0
    check-cast v14, Ljava/lang/String;
    move-object v0, v14
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v0
    if-nez v0, +083h
    if-nez v14, +004h
    goto/16 +07fh
    iget-object v0, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v0, v14, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$setFileUrl$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String;)V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v14, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getFileDownloadHelper$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    move-result-object v0
    sget-object v14, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v14, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v14
    iget-object v1, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getFileUrl$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v1
    const/4 v2, 0
    if-nez v1, +009h
    const-string v1, "fileUrl"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    goto +2h
    move-object v3, v1
    iget-object v1, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getConversationId$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +009h
    const-string v1, "conversationId"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v2
    goto +2h
    move-object v4, v1
    iget-boolean v1, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;->$isLocalWork Z
    if-eqz v1, +00dh
    iget-object v1, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getOidId$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +014h
    const-string v1, "oidId"
    goto +bh
    iget-object v1, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getFileName$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +009h
    const-string v1, "fileName"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    goto +2h
    move-object v5, v1
    iget-object v1, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getNeedDecode$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Z
    move-result v7
    iget-object v1, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    check-cast v1, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v1, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    iget-object v2, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getDownloadFinishCallback$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Lkotlin/jvm/functions/Function3;
    move-result-object v6
    check-cast v14, Landroid/content/Context;
    move-object v8, v1
    check-cast v8, Lkotlinx/coroutines/CoroutineScope;
    const-wide/16 v9, 0
    const/16 v11, 128
    const/4 v12, 0
    move-object v1, v14
    move-object v2, v3
    move-object v3, v4
    move-object v4, v5
    move-object v5, v8
    move-wide v8, v9
    move v10, v11
    move-object v11, v12
    invoke-static/range v0 ... v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->saveFileAndLoading$default(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; Z J I Ljava/lang/Object;)V
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
    iget-object v14, v13, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v14, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$showError(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)V
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
.end method
