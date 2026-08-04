# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "LoginServiceImpl.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $onFail:Lkotlin/jvm/functions/Function1;
.field final synthetic $onSuccess:Lkotlin/jvm/functions/Function1;
.field  label:I


.method constructor <init>(kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1;->$onSuccess Lkotlin/jvm/functions/Function1;
    iput-object v2, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1;->$onFail Lkotlin/jvm/functions/Function1;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1;
    iget-object v0, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1;->$onSuccess Lkotlin/jvm/functions/Function1;
    iget-object v1, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1;->$onFail Lkotlin/jvm/functions/Function1;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 26
    # ins_size=2
    move-object/from16 v1, v24
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v0, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1;->label I
    const/4 v3, 0
    const/4 v4, 3
    const/4 v5, 2
    const/4 v6, 1
    if-eqz v0, +023h
    if-eq v0, v6, +018h
    if-eq v0, v5, +011h
    if-ne v0, v4, +007h
    invoke-static/range v25, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +107h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v25, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0fah
    invoke-static/range v25, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v25
    goto +15h
    move-exception v0
    goto/16 +0bbh
    invoke-static/range v25, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    move-object v7, v1
    check-cast v7, Lkotlin/coroutines/Continuation;
    iput v6, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1;->label I
    invoke-virtual v0, v7, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->listDevices(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    check-cast v0, Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/ListDevicesResult;->getDevices()Ljava/util/List;
    move-result-object v7
    if-nez v7, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v7
    check-cast v7, Ljava/lang/Iterable;
    new-instance v8, Ljava/util/ArrayList;
    const/16 v9, 10
    invoke-static v7, v9, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v9
    invoke-direct v8, v9, Ljava/util/ArrayList;-><init>(I)V
    check-cast v8, Ljava/util/Collection;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +068h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/login/traeauth/DeviceSummary;
    new-instance v15, Lcom/bytedance/trae/login/api/LoginDeviceInfo;
    invoke-virtual v9, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getDeviceId()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v9, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getDeviceName()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v9, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getDeviceType()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v9, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getPlatformCode()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v9, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getClientVersion()Ljava/lang/String;
    move-result-object v16
    invoke-virtual v9, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getDeviceModel()Ljava/lang/String;
    move-result-object v17
    invoke-virtual v9, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getOsVersion()Ljava/lang/String;
    move-result-object v18
    invoke-virtual v9, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getLastLoginIp()Ljava/lang/String;
    move-result-object v19
    invoke-virtual v9, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getStatus()Ljava/lang/String;
    move-result-object v20
    invoke-virtual v9, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getFirstBoundAt()Ljava/lang/Long;
    move-result-object v21
    invoke-virtual v9, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getLastActiveAt()Ljava/lang/Long;
    move-result-object v22
    invoke-virtual v9, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getCurrentDevice()Ljava/lang/Boolean;
    move-result-object v10
    invoke-static v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v4
    invoke-static v10, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    invoke-virtual v9, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getBoundProducts()Ljava/util/List;
    move-result-object v9
    if-nez v9, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v9
    move-object/from16 v23, v9
    move-object v10, v15
    move-object v9, v15
    move-object/from16 v15, v16
    move-object/from16 v16, v17
    move-object/from16 v17, v18
    move-object/from16 v18, v19
    move-object/from16 v19, v20
    move-object/from16 v20, v21
    move-object/from16 v21, v22
    move/from16 v22, v4
    invoke-direct/range v10 ... v23, Lcom/bytedance/trae/login/api/LoginDeviceInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Long; Z Ljava/util/List;)V
    invoke-interface v8, v9, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    const/4 v4, 3
    goto -6bh
    check-cast v8, Ljava/util/List;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v4
    check-cast v4, Lkotlin/coroutines/CoroutineContext;
    new-instance v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1$1;
    iget-object v7, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1;->$onSuccess Lkotlin/jvm/functions/Function1;
    invoke-direct v6, v7, v8, v0, v3, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1$1;-><init>(Lkotlin/jvm/functions/Function1; Ljava/util/List; Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lkotlin/coroutines/Continuation;)V
    check-cast v6, Lkotlin/jvm/functions/Function2;
    move-object v0, v1
    check-cast v0, Lkotlin/coroutines/Continuation;
    iput v5, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1;->label I
    invoke-static v4, v6, v0, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +039h
    return-object v2
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "listLoginDevices failed: "
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v6, "LoginServiceImpl"
    invoke-virtual v4, v6, v5, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v4
    check-cast v4, Lkotlin/coroutines/CoroutineContext;
    new-instance v5, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1$2;
    iget-object v6, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1;->$onFail Lkotlin/jvm/functions/Function1;
    invoke-direct v5, v6, v0, v3, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1$2;-><init>(Lkotlin/jvm/functions/Function1; Ljava/lang/Exception; Lkotlin/coroutines/Continuation;)V
    check-cast v5, Lkotlin/jvm/functions/Function2;
    move-object v0, v1
    check-cast v0, Lkotlin/coroutines/Continuation;
    const/4 v3, 3
    iput v3, v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$listLoginDevices$1;->label I
    invoke-static v4, v5, v0, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0x21
    :try_start_0x32
.end method
