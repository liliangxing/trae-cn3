# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "InputPreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $isLocalWork:Z
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/InputPreviewActivity;


.method public static synthetic $r8$lambda$6QcN1Q-RPulnAxxYMcwG4gYdg_E(com.bytedance.trae.conversation.products.InputPreviewActivity  int  java.lang.String  long)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->invokeSuspend$lambda$0(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; I Ljava/lang/String; J)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.conversation.products.InputPreviewActivity  boolean  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->$isLocalWork Z
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$0(com.bytedance.trae.conversation.products.InputPreviewActivity  int  java.lang.String  long)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$hideLoadingDialog(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)V
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
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$openFileWithExternalApp(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String;)V
    goto +dh
    move-object v1, v0
    check-cast v1, Landroid/content/Context;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_doc_preview_download_failed I
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v1, v0, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->$isLocalWork Z
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Z Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 20
    # ins_size=2
    move-object/from16 v0, v18
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->label I
    const-string v3, "fileUrl"
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v2, +012h
    if-ne v2, v4, +008h
    invoke-static/range v19, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v19
    goto +3bh
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static/range v19, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getFileUrl$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +016h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getFileUrl$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v5
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +029h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$showLoadingDialog(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    move-object v6, v0
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput v4, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->label I
    invoke-static v2, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$fetchFileUrl(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    check-cast v2, Ljava/lang/String;
    move-object v1, v2
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v1
    if-nez v1, +07bh
    if-nez v2, +004h
    goto/16 +077h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$setFileUrl$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getNeedDecode$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Z
    move-result v13
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getFileDownloadHelper$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    move-result-object v6
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getFileUrl$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +007h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v5
    goto +2h
    move-object v8, v2
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getConversationId$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +009h
    const-string v2, "conversationId"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v5
    goto +2h
    move-object v9, v2
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->$isLocalWork Z
    if-eqz v2, +00dh
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getOidId$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +014h
    const-string v2, "oidId"
    goto +bh
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getFileName$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +009h
    const-string v2, "fileName"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v5
    goto +2h
    move-object v10, v2
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    check-cast v2, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v2, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v2
    move-object v7, v1
    check-cast v7, Landroid/content/Context;
    move-object v11, v2
    check-cast v11, Lkotlinx/coroutines/CoroutineScope;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    new-instance v12, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1$$ExternalSyntheticLambda0;
    invoke-direct v12, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)V
    const-wide/16 v14, 0
    const/16 v16, 128
    const/16 v17, 0
    invoke-static/range v6 ... v17, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->saveFileAndLoading$default(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; Z J I Ljava/lang/Object;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$hideLoadingDialog(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$showError(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method
