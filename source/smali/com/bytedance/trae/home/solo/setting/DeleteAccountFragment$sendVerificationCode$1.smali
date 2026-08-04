# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DeleteAccountFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $email:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;


.method constructor <init>(java.lang.String  com.bytedance.trae.home.solo.setting.DeleteAccountFragment  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->$email Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->$email Ljava/lang/String;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    const-string/jumbo v0, sendEmailCode failed: 
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->label I
    const-string v3, "getString(...)"
    const/4 v4, 0
    const-string v5, "btnSendCode"
    const/4 v6, 0
    const/4 v7, 1
    if-eqz v2, +016h
    if-ne v2, v7, +00ch
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +22h
    move-exception v10
    goto/16 +0b5h
    move-exception v10
    goto/16 +073h
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v10, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;->Companion Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;
    iget-object v2, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->$email Ljava/lang/String;
    move-object v8, v9
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput v7, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->label I
    invoke-virtual v10, v2, v8, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->sendEmailCode(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v1, +003h
    return-object v1
    check-cast v10, Lcom/bytedance/trae/home/solo/setting/EmailSendCodeResponse;
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/setting/EmailSendCodeResponse;->getErrorCode()I
    move-result v1
    if-eqz v1, +01fh
    iget-object v1, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/setting/EmailSendCodeResponse;->getDescription()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +013h
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/setting/EmailSendCodeResponse;->getMessage()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +00dh
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    sget v2, Lcom/bytedance/trae/home/R$string;->trae_delete_send_code_failed I
    invoke-virtual v10, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$showToast(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Ljava/lang/String;)V
    goto +14h
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    sget v1, Lcom/bytedance/trae/home/R$string;->trae_delete_send_code_success I
    invoke-virtual v10, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v10, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$showToast(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Ljava/lang/String;)V
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$startSendCodeCountdown(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)V
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v10, v6, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$setLoading$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Z)V
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$getSendCodeCountdown$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)I
    move-result v10
    if-gtz v10, +04fh
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$getBtnSendCode$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)Landroid/widget/TextView;
    move-result-object v10
    if-nez v10, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v10
    invoke-virtual v4, v7, Landroid/widget/TextView;->setEnabled(Z)V
    goto +3dh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "DeleteAccountFragment"
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v8, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v1, v2, v10, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_delete_send_code_failed I
    invoke-virtual v10, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v10, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$showToast(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Ljava/lang/String;)V
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v10, v6, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$setLoading$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Z)V
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$getSendCodeCountdown$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)I
    move-result v10
    if-gtz v10, +00bh
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$getBtnSendCode$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)Landroid/widget/TextView;
    move-result-object v10
    if-nez v10, -03eh
    goto -44h
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v0, v6, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$setLoading$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Z)V
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$getSendCodeCountdown$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)I
    move-result v0
    if-gtz v0, +012h
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$sendVerificationCode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$getBtnSendCode$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)Landroid/widget/TextView;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v0
    invoke-virtual v4, v7, Landroid/widget/TextView;->setEnabled(Z)V
    throw v10
    :try_start_0x14
    :try_start_0x29
    :try_start_0x8f
.end method
