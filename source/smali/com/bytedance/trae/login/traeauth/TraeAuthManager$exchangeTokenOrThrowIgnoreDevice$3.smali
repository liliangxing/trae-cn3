# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$3;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TraeAuthManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $callback:Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
.field  label:I


.method constructor <init>(com.bytedance.trae.login.traeauth.TraeAuthManager$TraeAuthCallback  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$3;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$3;
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$3;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$3;-><init>(Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$3;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$3;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$3;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$3;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$3;->label I
    if-nez v0, +015h
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v3, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$3;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    if-eqz v3, +00ch
    const-string v0, "401"
    const-string v1, ""
    invoke-interface v3, v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;->onFailure(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto +2h
    const/4 v3, 0
    return-object v3
    new-instance v3, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v3, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v3
.end method
