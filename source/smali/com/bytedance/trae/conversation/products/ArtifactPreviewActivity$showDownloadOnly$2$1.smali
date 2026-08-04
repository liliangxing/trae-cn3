# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactPreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;


.method public static synthetic $r8$lambda$Mwyfg5Z1d_or2gTF-RnQYeRVcTI(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  int  java.lang.String  long)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->invokeSuspend$lambda$0(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; I Ljava/lang/String; J)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$0(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  int  java.lang.String  long)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$hideLoadingDialog(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)V
    if-nez v1, +014h
    move-object v1, v2
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +006h
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$openFileWithExternalApp(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String;)V
    goto +dh
    move-object v1, v0
    check-cast v1, Landroid/content/Context;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_doc_preview_download_failed I
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v1, v0, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 18
    # ins_size=2
    move-object/from16 v0, v16
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->label I
    const-string v3, "fileUrl"
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v2, +012h
    if-ne v2, v4, +008h
    invoke-static/range v17, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v17
    goto +36h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static/range v17, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getFileUrl$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +016h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getFileUrl$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v5
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +024h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    move-object v6, v0
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput v4, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->label I
    invoke-static v2, v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$fetchFileUrl(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    check-cast v2, Ljava/lang/String;
    move-object v1, v2
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v1
    if-nez v1, +0a0h
    if-nez v2, +004h
    goto/16 +09ch
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$setFileUrl$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getCliType$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v1
    const-string v2, "cliType"
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v5
    sget-object v6, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v6, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v6
    invoke-static v1, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +01ch
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getCliType$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v5
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    const/4 v4, 0
    move v13, v4
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$showLoadingDialog(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getFileDownloadHelper$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    move-result-object v6
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getFileUrl$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +007h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v5
    goto +2h
    move-object v8, v2
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getChatSessionId$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +009h
    const-string v2, "chatSessionId"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v5
    goto +2h
    move-object v9, v2
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getPath$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +009h
    const-string v2, "path"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v5
    goto +2h
    move-object v10, v2
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    check-cast v2, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v2, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v2
    iget-object v3, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getCreatedTime$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)J
    move-result-wide v14
    move-object v7, v1
    check-cast v7, Landroid/content/Context;
    move-object v11, v2
    check-cast v11, Lkotlinx/coroutines/CoroutineScope;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    new-instance v12, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1$$ExternalSyntheticLambda0;
    invoke-direct v12, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)V
    invoke-virtual/range v6 ... v15, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->saveFileAndLoading(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; Z J)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$showError(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method
