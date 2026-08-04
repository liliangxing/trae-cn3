# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DeleteAccountFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $code:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;


.method constructor <init>(java.lang.String  com.bytedance.trae.home.solo.setting.DeleteAccountFragment  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->$code Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->$code Ljava/lang/String;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 12
    # ins_size=2
    const-string/jumbo v0, verifyEmailCode failed: 
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->label I
    const-string v3, "getString(...)"
    const/4 v4, 2
    const-string v5, "btnVerify"
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 1
    if-eqz v2, +01ch
    if-eq v2, v8, +010h
    if-ne v2, v4, +006h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +6ah
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ah
    move-exception v11
    goto/16 +0a9h
    move-exception v11
    goto/16 +06fh
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v11, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;->Companion Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;
    iget-object v2, v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->$code Ljava/lang/String;
    move-object v9, v10
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput v8, v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->label I
    invoke-virtual v11, v2, v9, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->verifyEmailCode(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    check-cast v11, Lcom/bytedance/trae/home/solo/setting/EmailVerifyResponse;
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/EmailVerifyResponse;->getErrorCode()I
    move-result v2
    if-eqz v2, +01fh
    iget-object v1, v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/EmailVerifyResponse;->getDescription()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +013h
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/EmailVerifyResponse;->getMessage()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +00dh
    iget-object v11, v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    sget v2, Lcom/bytedance/trae/home/R$string;->trae_delete_verify_failed I
    invoke-virtual v11, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$showToast(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Ljava/lang/String;)V
    goto +20h
    iget-object v2, v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/EmailVerifyResponse;->getData()Lcom/bytedance/trae/home/solo/setting/VerifyTicketData;
    move-result-object v11
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/VerifyTicketData;->getTicket()Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v7
    invoke-static v2, v11, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$setVerifyToken$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Ljava/lang/String;)V
    iget-object v11, v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    move-object v2, v10
    check-cast v2, Lkotlin/coroutines/Continuation;
    iput v4, v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->label I
    invoke-static v11, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$performCancelCheckAndProceed(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    iget-object v11, v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v11, v6, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$setLoading$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Z)V
    iget-object v11, v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v11, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$getBtnVerify$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)Landroid/widget/TextView;
    move-result-object v11
    if-nez v11, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v7, v11
    invoke-virtual v7, v8, Landroid/widget/TextView;->setEnabled(Z)V
    goto +35h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "DeleteAccountFragment"
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v4, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v1, v2, v11, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v11, v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_delete_verify_failed I
    invoke-virtual v11, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v11, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$showToast(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Ljava/lang/String;)V
    iget-object v11, v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v11, v6, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$setLoading$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Z)V
    iget-object v11, v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v11, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$getBtnVerify$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)Landroid/widget/TextView;
    move-result-object v11
    if-nez v11, -036h
    goto -3ch
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
    iget-object v0, v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v0, v6, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$setLoading$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Z)V
    iget-object v0, v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$verifyEmailCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$getBtnVerify$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)Landroid/widget/TextView;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v7, v0
    invoke-virtual v7, v8, Landroid/widget/TextView;->setEnabled(Z)V
    throw v11
    :try_start_0x17
    :try_start_0x23
    :try_start_0x30
    :try_start_0x9a
.end method
