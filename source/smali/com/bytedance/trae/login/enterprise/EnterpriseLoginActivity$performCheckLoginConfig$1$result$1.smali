# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1$result$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "EnterpriseLoginActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $email:Ljava/lang/String;
.field  label:I


.method constructor <init>(java.lang.String  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1$result$1;->$email Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1$result$1;
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1$result$1;->$email Ljava/lang/String;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1$result$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1$result$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1$result$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1$result$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1$result$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1$result$1;->label I
    if-nez v0, +00eh
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$performCheckLoginConfig$1$result$1;->$email Ljava/lang/String;
    invoke-virtual v2, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->checkLoginConfig(Ljava/lang/String;)Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;
    move-result-object v2
    return-object v2
    new-instance v2, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v2, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v2
.end method
