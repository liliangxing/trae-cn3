# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "InputPreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/InputPreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.InputPreviewActivity  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ah
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    move-object v1, v3
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v2, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;->label I
    invoke-static v4, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$fetchFileUrl(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v0, +003h
    return-object v0
    check-cast v4, Ljava/lang/String;
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v0
    if-nez v0, +0abh
    if-nez v4, +004h
    goto/16 +0a7h
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v0, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$setFileUrl$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "preview:"
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v1, "InputPreviewActivity"
    invoke-virtual v0, v1, v4, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getFileType$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    move-result-object v4
    const/4 v0, 0
    if-nez v4, +008h
    const-string v4, "fileType"
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v0
    sget-object v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->ordinal()I
    move-result v4
    aget v4, v1, v4
    const-string v1, "fileUrl"
    packed-switch v4, +0000079h
    new-instance v4, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v4, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v4
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getFileUrl$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v2
    invoke-static v4, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$showDownloadWithUrl(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String;)V
    goto +55h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getFileUrl$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v2
    invoke-static v4, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$downloadAndShowTxt(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String;)V
    goto +44h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getFileUrl$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v2
    invoke-static v4, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$downloadAndShowTxt(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String;)V
    goto +33h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getFileUrl$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v2
    invoke-static v4, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$showCodePreview(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String;)V
    goto +22h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getFileUrl$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v2
    invoke-static v4, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$loadMarkdownPreview(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String;)V
    goto +11h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getFileUrl$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v2
    invoke-static v4, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$showImagePreview(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$showError(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    packed-switch-payload 1 2 3 4 5 6
.end method
