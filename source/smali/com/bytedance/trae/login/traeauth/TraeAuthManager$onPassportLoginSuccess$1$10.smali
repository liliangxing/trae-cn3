# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$10;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TraeAuthManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $callback:Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
.field final synthetic $e:Ljava/lang/Exception;
.field  label:I


.method constructor <init>(com.bytedance.trae.login.traeauth.TraeAuthManager$TraeAuthCallback  java.lang.Exception  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$10;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    iput-object v2, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$10;->$e Ljava/lang/Exception;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$10;
    iget-object v0, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$10;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$10;->$e Ljava/lang/Exception;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$10;-><init>(Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Ljava/lang/Exception; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$10;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$10;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$10;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$10;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$10;->label I
    if-nez v0, +016h
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v3, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$10;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    const/4 v0, 0
    if-eqz v3, +00dh
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$10;->$e Ljava/lang/Exception;
    invoke-virtual v1, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v1
    invoke-interface v3, v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;->onFailure(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    new-instance v3, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v3, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v3
.end method
