# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository$getThirdPartyToken$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ThirdPartyTokenRepository.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $type:Ljava/lang/String;
.field  label:I


.method constructor <init>(java.lang.String  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository$getThirdPartyToken$2;->$type Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository$getThirdPartyToken$2;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository$getThirdPartyToken$2;->$type Ljava/lang/String;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository$getThirdPartyToken$2;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository$getThirdPartyToken$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository$getThirdPartyToken$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository$getThirdPartyToken$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository$getThirdPartyToken$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository$getThirdPartyToken$2;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +29h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v6, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;
    invoke-static v6, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;->access$createService(Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;)Lcom/bytedance/trae/conversation/network/IThirdPartyTokenApi;
    move-result-object v6
    new-instance v1, Lcom/bytedance/trae/conversation/network/GetThirdPartyTokenRequest;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository$getThirdPartyToken$2;->$type Ljava/lang/String;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/network/GetThirdPartyTokenRequest;-><init>(Ljava/util/List;)V
    move-object v3, v5
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v5, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository$getThirdPartyToken$2;->label I
    invoke-interface v6, v1, v3, Lcom/bytedance/trae/conversation/network/IThirdPartyTokenApi;->getThirdPartyToken(Lcom/bytedance/trae/conversation/network/GetThirdPartyTokenRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    check-cast v6, Lcom/bytedance/retrofit2/SsResponse;
    sget-object v0, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;
    invoke-static v0, v6, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;->access$parseEnvelopeOrThrow(Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository; Lcom/bytedance/retrofit2/SsResponse;)Lcom/bytedance/trae/conversation/network/ThirdPartyTokenEnvelope;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenEnvelope;->getResult()Ljava/util/List;
    move-result-object v6
    const/4 v0, 0
    if-eqz v6, +038h
    check-cast v6, Ljava/lang/Iterable;
    iget-object v1, v5, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository$getThirdPartyToken$2;->$type Ljava/lang/String;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +014h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenResult;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenResult;->getType()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v1, v2, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v4
    if-eqz v4, -015h
    goto +2h
    move-object v3, v0
    check-cast v3, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenResult;
    if-eqz v3, +013h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenResult;->getAccessToken()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +00dh
    move-object v1, v6
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/2addr v1, v2
    if-eqz v1, +003h
    move-object v0, v6
    return-object v0
.end method
