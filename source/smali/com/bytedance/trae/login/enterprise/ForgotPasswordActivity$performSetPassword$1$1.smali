# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performSetPassword$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ForgotPasswordActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $newPassword:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;


.method constructor <init>(com.bytedance.trae.login.enterprise.ForgotPasswordActivity  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performSetPassword$1$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    iput-object v2, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performSetPassword$1$1;->$newPassword Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performSetPassword$1$1;
    iget-object v0, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performSetPassword$1$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    iget-object v1, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performSetPassword$1$1;->$newPassword Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performSetPassword$1$1;-><init>(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performSetPassword$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performSetPassword$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performSetPassword$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performSetPassword$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performSetPassword$1$1;->label I
    if-nez v0, +023h
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v4, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performSetPassword$1$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$getEmail$p(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +008h
    const-string v0, "email"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    iget-object v1, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performSetPassword$1$1;->$newPassword Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$performSetPassword$1$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$getVerificationCode$p(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v4, v0, v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->setUserPassword(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
.end method
