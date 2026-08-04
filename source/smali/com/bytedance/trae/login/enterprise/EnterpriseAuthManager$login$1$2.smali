# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$login$1$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "EnterpriseAuthManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $callback:Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback;
.field  label:I


.method constructor <init>(com.bytedance.trae.login.enterprise.EnterpriseAuthManager$Callback  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$login$1$2;->$callback Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$login$1$2;
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$login$1$2;->$callback Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$login$1$2;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$login$1$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$login$1$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$login$1$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$login$1$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$login$1$2;->label I
    if-nez v0, +019h
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v3, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$login$1$2;->$callback Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback;
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_login_failed I
    invoke-virtual v0, v1, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-interface v3, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback;->onFailure(Ljava/lang/String;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
    new-instance v3, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v3, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v3
.end method
