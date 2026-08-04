# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchModelsForUi$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "IRemoteModelsApi.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $functions:Ljava/util/List;
.field final synthetic $trigger:Ljava/lang/String;
.field  label:I


.method constructor <init>(java.lang.String  java.util.List  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchModelsForUi$2;->$trigger Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchModelsForUi$2;->$functions Ljava/util/List;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchModelsForUi$2;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchModelsForUi$2;->$trigger Ljava/lang/String;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchModelsForUi$2;->$functions Ljava/util/List;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchModelsForUi$2;-><init>(Ljava/lang/String; Ljava/util/List; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchModelsForUi$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchModelsForUi$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchModelsForUi$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchModelsForUi$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchModelsForUi$2;->label I
    if-nez v0, +1e3h
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$getModelListMemoryCache$p()Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;
    move-result-object v13
    sget-object v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-static v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$currentModelListUserId(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v13, v0, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->captureOwner(Ljava/lang/String;)Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;
    move-result-object v13
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "fetchModelsForUi: start, trigger="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchModelsForUi$2;->$trigger Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", functions="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchModelsForUi$2;->$functions Ljava/util/List;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "IRemoteModelsApi"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-direct v0, Lcom/bytedance/ttnet/http/RequestContext;-><init>()V
    const/4 v1, 1
    iput-boolean v1, v0, Lcom/bytedance/ttnet/http/RequestContext;->force_handle_response Z
    sget-object v3, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v4, "models"
    const-class v5, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi;
    const/4 v6, 0
    sget-object v7, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v8, Lcom/bytedance/trae/network/HostType;->REMOTE Lcom/bytedance/trae/network/HostType;
    invoke-virtual v7, v8, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v7
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 52
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi;
    iget-object v4, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchModelsForUi$2;->$functions Ljava/util/List;
    invoke-interface v3, v4, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi;->getModels(Ljava/util/List; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    sget-object v3, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->errorBody()Lcom/bytedance/retrofit2/mime/TypedInput;
    move-result-object v5
    invoke-static v3, v4, v5, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$readBody(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Ljava/lang/String; Lcom/bytedance/retrofit2/mime/TypedInput;)Ljava/lang/String;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "fetchModelsForUi: httpCode="
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v7
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v7, ", bodyLen="
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    if-eqz v3, +007h
    invoke-virtual v3, Ljava/lang/String;->length()I
    move-result v7
    goto +2h
    const/4 v7, -1
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v2, v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    iget-object v5, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchModelsForUi$2;->$functions Ljava/util/List;
    invoke-static v4, v5, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$remoteCacheKey(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Ljava/util/List;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v5
    const/16 v7, 200
    const-string v8, ", body="
    if-ne v5, v7, +0feh
    move-object v5, v3
    check-cast v5, Ljava/lang/CharSequence;
    if-eqz v5, +00bh
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    if-eqz v5, +003h
    goto +3h
    const/4 v5, 0
    goto +2h
    move v5, v1
    if-eqz v5, +004h
    goto/16 +0ebh
    sget-object v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-static v0, v3, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$parseBizCode(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v0
    const/16 v5, 800
    if-eqz v0, +052h
    move-object v6, v0
    check-cast v6, Ljava/lang/Number;
    invoke-virtual v6, Ljava/lang/Number;->intValue()I
    move-result v6
    sget-object v7, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-static v7, v6, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$isSuccessBizCode(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; I)Z
    move-result v6
    xor-int/2addr v6, v1
    if-eqz v6, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +03eh
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->intValue()I
    move-result v13
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v6, "fetchModelsForUi: bizCode="
    invoke-direct v1, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v13, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-static v3, v5, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "fetchModelsForUi_biz_"
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v13, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-static v0, v4, v13, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$getCachedModelsOrAuto(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Ljava/lang/String; Ljava/lang/String;)Ljava/util/List;
    move-result-object v13
    return-object v13
    sget-object v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    sget-object v6, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-static v6, v3, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$parseModels(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Ljava/lang/String;)Ljava/util/List;
    move-result-object v6
    invoke-static v0, v6, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$normalizeModels(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    sget-object v6, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-static v6, v13, v4, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$putModelsCache(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner; Ljava/lang/String; Ljava/util/List;)Z
    move-result v13
    if-nez v13, +00bh
    sget-object v13, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    const-string v0, "fetchModelsForUi_account_changed"
    invoke-static v13, v4, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$getCachedModelsOrAuto(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Ljava/lang/String; Ljava/lang/String;)Ljava/util/List;
    move-result-object v13
    return-object v13
    sget-object v13, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v6, "fetchModelsForUi: parsedCount="
    invoke-direct v4, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v6
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", names="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    move-object v6, v0
    check-cast v6, Ljava/lang/Iterable;
    const/4 v7, 6
    invoke-static v6, v7, Lkotlin/collections/CollectionsKt;->take(Ljava/lang/Iterable; I)Ljava/util/List;
    move-result-object v6
    check-cast v6, Ljava/lang/Iterable;
    new-instance v7, Ljava/util/ArrayList;
    const/16 v8, 10
    invoke-static v6, v8, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v8
    invoke-direct v7, v8, Ljava/util/ArrayList;-><init>(I)V
    check-cast v7, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +010h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v8
    invoke-interface v7, v8, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v7, Ljava/util/List;
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v13, v2, v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v13
    if-gt v13, v1, +01ah
    sget-object v13, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v4, "fetchModelsForUi: only auto model parsed, body="
    invoke-direct v1, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static v3, v5, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v13, v2, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
    sget-object v13, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v5
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v13, v2, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v13, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "fetchModelsForUi_http_"
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v0
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v13, v4, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$getCachedModelsOrAuto(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Ljava/lang/String; Ljava/lang/String;)Ljava/util/List;
    move-result-object v13
    return-object v13
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
.end method
