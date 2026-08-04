# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ForgotPasswordActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $code:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;


.method constructor <init>(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    iput-object v2, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;->$code Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;
    iget-object v0, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    iget-object v1, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;->$code Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;-><init>(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v9, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;->label I
    const/4 v2, 0
    const-string v3, "ForgotPasswordActivity"
    const/4 v4, 1
    const-string v5, ""
    const-string/jumbo v6, verifyCodeInput
    const/4 v7, 0
    if-eqz v1, +015h
    if-ne v1, v4, +00bh
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2ch
    move-exception v10
    goto +38h
    move-exception v10
    goto/16 +08eh
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v10
    check-cast v10, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1$1;
    iget-object v8, v9, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;->$code Ljava/lang/String;
    invoke-direct v1, v8, v7, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v8, v9
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput v4, v9, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;->label I
    invoke-static v10, v1, v8, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v0, +003h
    return-object v0
    iget-object v10, v9, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    iget-object v0, v9, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;->$code Ljava/lang/String;
    invoke-static v10, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$setVerificationCode$p(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Ljava/lang/String;)V
    iget-object v10, v9, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v10, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$goToStep3(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
    goto/16 +0a6h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v4, "getCodeInfo unexpected error: "
    invoke-direct v1, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v9, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v0, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$setStep2Loading(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Z)V
    iget-object v0, v9, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$getVerifyCodeInput$p(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v7
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v0, v5, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v9, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$getVerifyCodeInput$p(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v7, v0
    invoke-virtual v7, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->requestFocus()Z
    iget-object v0, v9, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    instance-of v10, v10, Ljava/io/IOException;
    if-eqz v10, +009h
    sget v10, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_network I
    invoke-virtual v0, v10, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->getString(I)Ljava/lang/String;
    move-result-object v10
    goto +7h
    sget v10, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_service I
    invoke-virtual v0, v10, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->getString(I)Ljava/lang/String;
    move-result-object v10
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v0, v10, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$showStep2Error(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Ljava/lang/String;)V
    goto +4dh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v4, "getCodeInfo failed: "
    invoke-direct v1, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v9, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v0, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$setStep2Loading(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Z)V
    iget-object v0, v9, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$getVerifyCodeInput$p(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v7
    move-object v1, v5
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v9, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$getVerifyCodeInput$p(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v7, v0
    invoke-virtual v7, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->requestFocus()Z
    iget-object v0, v9, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performVerifyCode$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-virtual v10, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;->getUserMessage()Ljava/lang/String;
    move-result-object v10
    if-nez v10, +003h
    goto +2h
    move-object v5, v10
    invoke-static v0, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$showStep2Error(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Ljava/lang/String;)V
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
    :try_start_0x14
    :try_start_0x28
.end method
