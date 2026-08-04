# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/HubNetConnectionKt;
.super Ljava/lang/Object;
.source "HubNetConnection.kt"


.method public static final awaitNetworkRecovery(kotlinx.coroutines.flow.StateFlow  kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=2
    instance-of v0, v6, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecovery$1;
    if-eqz v0, +012h
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecovery$1;
    iget v1, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecovery$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v6, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecovery$1;->label I
    sub-int/2addr v6, v2
    iput v6, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecovery$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecovery$1;
    invoke-direct v0, v6, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecovery$1;-><init>(Lkotlin/coroutines/Continuation;)V
    iget-object v6, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecovery$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecovery$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v2, +01ah
    if-eq v2, v4, +010h
    if-ne v2, v3, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +4ah
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v6, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v6, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    iget-object v5, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecovery$1;->L$0 Ljava/lang/Object;
    check-cast v5, Lkotlinx/coroutines/flow/StateFlow;
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +25h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-interface v5, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/Boolean;
    invoke-virtual v6, Ljava/lang/Boolean;->booleanValue()Z
    move-result v6
    if-eqz v6, +017h
    move-object v6, v5
    check-cast v6, Lkotlinx/coroutines/flow/Flow;
    new-instance v2, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecovery$$inlined$filter$1;
    invoke-direct v2, v6, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecovery$$inlined$filter$1;-><init>(Lkotlinx/coroutines/flow/Flow;)V
    check-cast v2, Lkotlinx/coroutines/flow/Flow;
    iput-object v5, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecovery$1;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecovery$1;->label I
    invoke-static v2, v0, Lkotlinx/coroutines/flow/FlowKt;->first(Lkotlinx/coroutines/flow/Flow; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v1, +003h
    return-object v1
    check-cast v5, Lkotlinx/coroutines/flow/Flow;
    new-instance v6, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecovery$$inlined$filter$2;
    invoke-direct v6, v5, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecovery$$inlined$filter$2;-><init>(Lkotlinx/coroutines/flow/Flow;)V
    check-cast v6, Lkotlinx/coroutines/flow/Flow;
    const/4 v5, 0
    iput-object v5, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecovery$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecovery$1;->label I
    invoke-static v6, v0, Lkotlinx/coroutines/flow/FlowKt;->first(Lkotlinx/coroutines/flow/Flow; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v1, +003h
    return-object v1
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
.end method

.method public static final awaitNetworkRecoveryOrRetryDelay(kotlinx.coroutines.flow.StateFlow  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;
    const/4 v1, 0
    invoke-direct v0, v3, v4, v2, v1, Lcom/bytedance/trae/network/HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;-><init>(J Lkotlinx/coroutines/flow/StateFlow; Lkotlin/coroutines/Continuation;)V
    check-cast v0, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v5, Lkotlinx/coroutines/CoroutineScopeKt;->coroutineScope(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    if-ne v2, v3, +003h
    return-object v2
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method public static final buildRegisterAppRequest(com.bytedance.trae.network.FrontierConfig  boolean  java.lang.String  java.lang.String  java.lang.Long  java.lang.String  int  com.bytedance.trae.network.HubClientMetadata)com.bytedance.trae.network.RegisterAppRequest
    .registers 19
    # ins_size=8
    const-string v0, "config"
    move-object v1, v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "appRuntimeType"
    move-object/from16 v8, v16
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "clientMetadata"
    move-object/from16 v2, v18
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/network/RegisterAppRequest;
    const/4 v3, 0
    if-eqz v12, +004h
    move-object v4, v3
    goto +2h
    move-object v4, v13
    invoke-virtual/range v18, Lcom/bytedance/trae/network/HubClientMetadata;->getDeviceName()Ljava/lang/String;
    move-result-object v5
    if-eqz v12, +004h
    move-object v6, v14
    goto +2h
    move-object v6, v3
    if-eqz v12, +004h
    move-object v7, v3
    goto +5h
    const-string/jumbo v2, online
    move-object v7, v2
    invoke-virtual v11, Lcom/bytedance/trae/network/FrontierConfig;->getAppId()I
    move-result v9
    invoke-virtual v11, Lcom/bytedance/trae/network/FrontierConfig;->getProductId()I
    move-result v10
    move-object v1, v0
    move-object v2, v4
    move-object v3, v5
    move-object v4, v6
    move-object v5, v15
    move-object v6, v7
    move v7, v9
    move-object/from16 v8, v16
    move/from16 v9, v17
    invoke-direct/range v1 ... v10, Lcom/bytedance/trae/network/RegisterAppRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; I Ljava/lang/String; I I)V
    return-object v0
.end method

.method public static final startTransportThenRegister(kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.coroutines.Continuation)java.lang.Object
    .registers 9
    # ins_size=5
    instance-of v0, v8, Lcom/bytedance/trae/network/HubNetConnectionKt$startTransportThenRegister$1;
    if-eqz v0, +012h
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/network/HubNetConnectionKt$startTransportThenRegister$1;
    iget v1, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$startTransportThenRegister$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v8, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$startTransportThenRegister$1;->label I
    sub-int/2addr v8, v2
    iput v8, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$startTransportThenRegister$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/network/HubNetConnectionKt$startTransportThenRegister$1;
    invoke-direct v0, v8, Lcom/bytedance/trae/network/HubNetConnectionKt$startTransportThenRegister$1;-><init>(Lkotlin/coroutines/Continuation;)V
    iget-object v8, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$startTransportThenRegister$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$startTransportThenRegister$1;->label I
    const/4 v3, 1
    if-eqz v2, +01ah
    if-ne v2, v3, +010h
    iget-object v4, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$startTransportThenRegister$1;->L$1 Ljava/lang/Object;
    move-object v7, v4
    check-cast v7, Lkotlin/jvm/functions/Function0;
    iget-object v4, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$startTransportThenRegister$1;->L$0 Ljava/lang/Object;
    move-object v6, v4
    check-cast v6, Lkotlin/jvm/functions/Function0;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ch
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v5, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v5, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-interface v4, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    iput-object v6, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$startTransportThenRegister$1;->L$0 Ljava/lang/Object;
    iput-object v7, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$startTransportThenRegister$1;->L$1 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/network/HubNetConnectionKt$startTransportThenRegister$1;->label I
    invoke-interface v5, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    check-cast v8, Ljava/lang/Boolean;
    invoke-virtual v8, Ljava/lang/Boolean;->booleanValue()Z
    move-result v4
    if-eqz v4, +006h
    invoke-interface v6, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    goto +4h
    invoke-interface v7, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method
