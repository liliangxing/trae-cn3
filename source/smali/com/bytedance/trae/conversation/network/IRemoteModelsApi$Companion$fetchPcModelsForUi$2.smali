# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "IRemoteModelsApi.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cliId:Ljava/lang/String;
.field final synthetic $cliType:Lcom/bytedance/trae/im/service/CliType;
.field final synthetic $forceRefresh:Z
.field final synthetic $functions:Ljava/util/List;
.field final synthetic $ideVersion:Ljava/lang/String;
.field final synthetic $trigger:Ljava/lang/String;
.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  label:I


.method constructor <init>(java.lang.String  com.bytedance.trae.im.service.CliType  java.lang.String  java.util.List  boolean  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 8
    # ins_size=8
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$trigger Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$cliType Lcom/bytedance/trae/im/service/CliType;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$cliId Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$functions Ljava/util/List;
    iput-boolean v5, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$forceRefresh Z
    iput-object v6, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$ideVersion Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v7, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 11
    # ins_size=3
    new-instance v9, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;
    iget-object v1, v8, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$trigger Ljava/lang/String;
    iget-object v2, v8, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$cliType Lcom/bytedance/trae/im/service/CliType;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$cliId Ljava/lang/String;
    iget-object v4, v8, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$functions Ljava/util/List;
    iget-boolean v5, v8, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$forceRefresh Z
    iget-object v6, v8, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$ideVersion Ljava/lang/String;
    move-object v0, v9
    move-object v7, v10
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;-><init>(Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/util/List; Z Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/coroutines/Continuation;
    return-object v9
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 24
    # ins_size=2
    move-object/from16 v0, v22
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->label I
    const-string v3, ", cliType="
    const/4 v4, 2
    const/4 v5, 0
    const-string v6, ", ideVersion="
    const-string v7, ", cliId="
    const/4 v8, 1
    const-string v9, "IRemoteModelsApi"
    if-eqz v2, +027h
    if-eq v2, v8, +01bh
    if-ne v2, v4, +011h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->L$1 Ljava/lang/Object;
    check-cast v1, Ljava/lang/String;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;
    invoke-static/range v23, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v4, v23
    goto/16 +0f7h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;
    invoke-static/range v23, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v10, v23
    goto +70h
    invoke-static/range v23, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$getModelListMemoryCache$p()Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;
    move-result-object v2
    sget-object v10, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-static v10, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$currentModelListUserId(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;)Ljava/lang/String;
    move-result-object v10
    invoke-virtual v2, v10, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->captureOwner(Ljava/lang/String;)Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;
    move-result-object v2
    sget-object v10, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v11, Ljava/lang/StringBuilder;
    const-string v12, "fetchPcModelsForUi: start, trigger="
    invoke-direct v11, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v12, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$trigger Ljava/lang/String;
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    iget-object v12, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$cliType Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    iget-object v12, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$cliId Ljava/lang/String;
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v12, ", functions="
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    iget-object v12, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$functions Ljava/util/List;
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v12, ", forceRefresh="
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    iget-boolean v12, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$forceRefresh Z
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    iget-object v12, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$ideVersion Ljava/lang/String;
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v10, v9, v11, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v10, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    iget-object v11, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$cliId Ljava/lang/String;
    move-object v12, v0
    check-cast v12, Lkotlin/coroutines/Continuation;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->L$0 Ljava/lang/Object;
    iput v8, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->label I
    invoke-static v10, v11, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$resolvePcCliInfo(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v1, +003h
    return-object v1
    check-cast v10, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$PcCliInfo;
    if-nez v10, +014h
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v2, "fetchPcModelsForUi: empty cliId and no single online local cli, fallback auto"
    invoke-virtual v1, v9, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v1
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    return-object v1
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$PcCliInfo;->getId()Ljava/lang/String;
    move-result-object v11
    iget-object v12, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$cliId Ljava/lang/String;
    check-cast v12, Ljava/lang/CharSequence;
    invoke-static v12, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v12
    if-eqz v12, +016h
    sget-object v12, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v13, Ljava/lang/StringBuilder;
    const-string v14, "fetchPcModelsForUi: resolved empty cliId to online local cli, cliId="
    invoke-direct v13, v14, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v12, v9, v13, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v12, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$ideVersion Ljava/lang/String;
    if-eqz v12, +010h
    move-object v13, v12
    check-cast v13, Ljava/lang/CharSequence;
    invoke-static v13, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v13
    xor-int/2addr v13, v8
    if-eqz v13, +003h
    goto +2h
    move-object v12, v5
    if-nez v12, +030h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$PcCliInfo;->getIdeVersion()Ljava/lang/String;
    move-result-object v10
    if-eqz v10, +010h
    move-object v12, v10
    check-cast v12, Ljava/lang/CharSequence;
    invoke-static v12, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v12
    xor-int/2addr v12, v8
    if-eqz v12, +003h
    goto +2h
    move-object v10, v5
    move-object v12, v10
    goto +2h
    move-object v12, v5
    if-nez v12, +019h
    sget-object v10, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    move-object v12, v0
    check-cast v12, Lkotlin/coroutines/Continuation;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->L$0 Ljava/lang/Object;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->L$1 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->label I
    invoke-static v10, v11, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$findCliIdeVersion(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v1, +003h
    return-object v1
    move-object v1, v11
    move-object v12, v4
    check-cast v12, Ljava/lang/String;
    move-object v11, v1
    sget-object v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-static v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$minSupportedIdeVersion(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;)Ljava/lang/String;
    move-result-object v1
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v10, Ljava/lang/StringBuilder;
    const-string v13, "fetchPcModelsForUi: minIdeVersion="
    invoke-direct v10, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    iget-object v10, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$cliType Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v3, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v10, ", trigger="
    invoke-virtual v3, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    iget-object v10, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$trigger Ljava/lang/String;
    invoke-virtual v3, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v4, v9, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/conversation/network/IdeVersionGate;->INSTANCE Lcom/bytedance/trae/conversation/network/IdeVersionGate;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$cliType Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v3, v4, v12, v1, Lcom/bytedance/trae/conversation/network/IdeVersionGate;->shouldBlockCliModelList(Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String;)Z
    move-result v3
    if-eqz v3, +043h
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "fetchPcModelsForUi: unsupported cliType="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v4, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$cliType Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", minVersion="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", fallback auto"
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v9, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v1
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    return-object v1
    new-instance v1, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-direct v1, Lcom/bytedance/ttnet/http/RequestContext;-><init>()V
    iput-boolean v8, v1, Lcom/bytedance/ttnet/http/RequestContext;->force_handle_response Z
    sget-object v13, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v14, "models"
    const-class v15, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi;
    const/16 v16, 0
    sget-object v3, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v4, Lcom/bytedance/trae/network/HostType;->AI Lcom/bytedance/trae/network/HostType;
    invoke-virtual v3, v4, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v17
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 52
    const/16 v21, 0
    invoke-static/range v13 ... v21, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$functions Ljava/util/List;
    iget-boolean v10, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$forceRefresh Z
    invoke-interface v3, v11, v4, v10, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi;->getPcModels(Ljava/lang/String; Ljava/util/List; Z Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v1
    invoke-interface v1, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v1
    sget-object v3, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-virtual v1, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-virtual v1, Lcom/bytedance/retrofit2/SsResponse;->errorBody()Lcom/bytedance/retrofit2/mime/TypedInput;
    move-result-object v10
    invoke-static v3, v4, v10, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$readBody(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Ljava/lang/String; Lcom/bytedance/retrofit2/mime/TypedInput;)Ljava/lang/String;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v10, Ljava/lang/StringBuilder;
    const-string v13, "fetchPcModelsForUi: httpCode="
    invoke-direct v10, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v14
    invoke-virtual v10, v14, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v14, ", bodyLen="
    invoke-virtual v10, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    if-eqz v3, +007h
    invoke-virtual v3, Ljava/lang/String;->length()I
    move-result v14
    goto +2h
    const/4 v14, -1
    invoke-virtual v10, v14, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v4, v9, v10, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    iget-object v10, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;->$functions Ljava/util/List;
    invoke-static v4, v11, v10, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$pcCacheKey(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Ljava/lang/String; Ljava/util/List;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v10
    const/16 v14, 200
    const-string v15, ", body="
    if-ne v10, v14, +13eh
    move-object v10, v3
    check-cast v10, Ljava/lang/CharSequence;
    if-eqz v10, +00bh
    invoke-static v10, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v10
    if-eqz v10, +003h
    goto +3h
    const/4 v10, 0
    goto +2h
    move v10, v8
    if-eqz v10, +004h
    goto/16 +12bh
    sget-object v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-static v1, v3, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$parseBizCode(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v1
    const/16 v10, 800
    if-eqz v1, +092h
    move-object v13, v1
    check-cast v13, Ljava/lang/Number;
    invoke-virtual v13, Ljava/lang/Number;->intValue()I
    move-result v13
    sget-object v14, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-static v14, v13, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$isSuccessBizCode(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; I)Z
    move-result v13
    xor-int/2addr v13, v8
    if-eqz v13, +003h
    move-object v5, v1
    if-eqz v5, +07fh
    check-cast v5, Ljava/lang/Number;
    invoke-virtual v5, Ljava/lang/Number;->intValue()I
    move-result v1
    sget-object v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-static v2, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$isExpectedPcModelListBizCode(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; I)Z
    move-result v2
    if-eqz v2, +033h
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v8, "fetchPcModelsForUi: expected pc model list bizCode="
    invoke-direct v5, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-static v3, v10, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v5, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v9, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    goto +29h
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "fetchPcModelsForUi: bizCode="
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-static v3, v10, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v5, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v9, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "fetchPcModelsForUi_biz_"
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v2, v4, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$getCachedModelsOrAuto(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Ljava/lang/String; Ljava/lang/String;)Ljava/util/List;
    move-result-object v1
    return-object v1
    sget-object v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    sget-object v5, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-static v5, v3, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$parseModels(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Ljava/lang/String;)Ljava/util/List;
    move-result-object v5
    invoke-static v1, v5, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$normalizeModels(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Ljava/util/List;)Ljava/util/List;
    move-result-object v1
    sget-object v5, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-static v5, v2, v4, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$putModelsCache(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner; Ljava/lang/String; Ljava/util/List;)Z
    move-result v2
    if-nez v2, +00bh
    sget-object v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    const-string v2, "fetchPcModelsForUi_account_changed"
    invoke-static v1, v4, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$getCachedModelsOrAuto(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Ljava/lang/String; Ljava/lang/String;)Ljava/util/List;
    move-result-object v1
    return-object v1
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "fetchPcModelsForUi: parsedCount="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", names="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    move-object v5, v1
    check-cast v5, Ljava/lang/Iterable;
    const/4 v6, 6
    invoke-static v5, v6, Lkotlin/collections/CollectionsKt;->take(Ljava/lang/Iterable; I)Ljava/util/List;
    move-result-object v5
    check-cast v5, Ljava/lang/Iterable;
    new-instance v6, Ljava/util/ArrayList;
    const/16 v7, 10
    invoke-static v5, v7, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v7
    invoke-direct v6, v7, Ljava/util/ArrayList;-><init>(I)V
    check-cast v6, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +010h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v7
    invoke-interface v6, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v6, Ljava/util/List;
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v9, v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v2
    if-gt v2, v8, +01ah
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "fetchPcModelsForUi: only auto model parsed, body="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static v3, v10, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v9, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v1
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v9, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "fetchPcModelsForUi_http_"
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v1
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v2, v4, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->access$getCachedModelsOrAuto(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Ljava/lang/String; Ljava/lang/String;)Ljava/util/List;
    move-result-object v1
    return-object v1
.end method
