# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "HubNetConnection.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cfg:Lcom/bytedance/trae/network/FrontierConfig;
.field final synthetic $listener:Lcom/bytedance/trae/network/HubConnectionListener;
.field  J$0:J
.field  J$1:J
.field  J$2:J
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/network/HubNetConnection;


.method constructor <init>(com.bytedance.trae.network.HubNetConnection  com.bytedance.trae.network.FrontierConfig  com.bytedance.trae.network.HubConnectionListener  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    iput-object v2, v0, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->$cfg Lcom/bytedance/trae/network/FrontierConfig;
    iput-object v3, v0, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->$listener Lcom/bytedance/trae/network/HubConnectionListener;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 7
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;
    iget-object v1, v4, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    iget-object v2, v4, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->$cfg Lcom/bytedance/trae/network/FrontierConfig;
    iget-object v3, v4, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->$listener Lcom/bytedance/trae/network/HubConnectionListener;
    invoke-direct v0, v1, v2, v3, v6, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lcom/bytedance/trae/network/FrontierConfig; Lcom/bytedance/trae/network/HubConnectionListener; Lkotlin/coroutines/Continuation;)V
    iput-object v5, v0, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 26
    # ins_size=2
    move-object/from16 v0, v24
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->label I
    const/4 v3, 3
    const/4 v4, 2
    const/4 v5, 1
    const-string v6, "HubNetConnection"
    if-eqz v2, +04ch
    if-eq v2, v5, +03ah
    if-eq v2, v4, +026h
    if-ne v2, v3, +01ch
    iget-wide v8, v0, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->J$2 J
    iget-wide v10, v0, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->J$1 J
    iget-wide v12, v0, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->J$0 J
    iget-object v2, v0, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v25, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move v5, v3
    move-wide v14, v8
    move-object v3, v0
    move v9, v4
    move-object/from16 v4, v25
    move-wide/from16 v22, v10
    move-wide v10, v12
    move-wide/from16 v12, v22
    goto/16 +170h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget-wide v8, v0, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->J$2 J
    iget-wide v10, v0, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->J$1 J
    iget-wide v12, v0, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->J$0 J
    iget-object v2, v0, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v25, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v7, v0
    move-wide v14, v8
    move v9, v4
    goto/16 +132h
    iget-wide v8, v0, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->J$2 J
    iget-wide v10, v0, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->J$1 J
    iget-wide v12, v0, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->J$0 J
    iget-object v2, v0, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v25, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v3, v0
    goto/16 +084h
    invoke-static/range v25, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v8
    const-wide/32 v10, 180000
    const-wide/16 v12, 2000
    move-wide v14, v12
    move-wide v12, v10
    move-wide v10, v8
    move-object v9, v0
    invoke-static v2, Lkotlinx/coroutines/CoroutineScopeKt;->isActive(Lkotlinx/coroutines/CoroutineScope;)Z
    move-result v8
    if-eqz v8, +154h
    iget-object v8, v9, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v8, Lcom/bytedance/trae/network/HubNetConnection;->access$getTransportMode$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/TransportMode;
    move-result-object v8
    sget-object v3, Lcom/bytedance/trae/network/TransportMode;->SHUTDOWN Lcom/bytedance/trae/network/TransportMode;
    if-eq v8, v3, +14ah
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v16
    sub-long v7, v16, v10
    cmp-long v16, v7, v12
    if-ltz v16, +005h
    move/from16 v16, v5
    goto +3h
    const/16 v16, 0
    if-eqz v16, +053h
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    const-string/jumbo v5, retryRegisterApp: polling expired after 
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v7, v8, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, "ms, waiting for network recovery or "
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-wide/16 v7, 30000
    invoke-virtual v4, v7, v8, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, "ms backoff"
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v6, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/network/NetworkMonitor;->INSTANCE Lcom/bytedance/trae/network/NetworkMonitor;
    invoke-virtual v3, Lcom/bytedance/trae/network/NetworkMonitor;->isConnected()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v3
    move-object v4, v9
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput-object v2, v9, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->L$0 Ljava/lang/Object;
    iput-wide v10, v9, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->J$0 J
    iput-wide v12, v9, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->J$1 J
    iput-wide v14, v9, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->J$2 J
    const/4 v5, 1
    iput v5, v9, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->label I
    invoke-static v3, v7, v8, v4, Lcom/bytedance/trae/network/HubNetConnectionKt;->awaitNetworkRecoveryOrRetryDelay(Lkotlinx/coroutines/flow/StateFlow; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v1, +003h
    return-object v1
    move-object v3, v9
    move-wide v8, v14
    move-wide/from16 v22, v10
    move-wide v10, v12
    move-wide/from16 v12, v22
    move-wide v14, v8
    const/4 v9, 2
    goto/16 +09dh
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    const-string/jumbo v5, retryRegisterApp: elapsed=
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v7, v8, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, "ms, waiting for "
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v14, v15, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, "ms timer or network recovery"
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v6, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v4, 0
    const/4 v5, 0
    new-instance v7, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1$timerDeferred$1;
    const/4 v3, 0
    invoke-direct v7, v14, v15, v3, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1$timerDeferred$1;-><init>(J Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/jvm/functions/Function2;
    const/16 v18, 3
    const/16 v19, 0
    move-object v8, v2
    move-object/from16 v25, v9
    move-object v9, v4
    move-wide v3, v10
    move-object v10, v5
    move-object v11, v7
    move-wide/from16 v20, v12
    move/from16 v12, v18
    move-object/from16 v13, v19
    invoke-static/range v8 ... v13, Lkotlinx/coroutines/BuildersKt;->async$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Deferred;
    move-result-object v5
    const/4 v9, 0
    const/4 v10, 0
    new-instance v7, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1$networkDeferred$1;
    const/4 v8, 0
    invoke-direct v7, v8, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1$networkDeferred$1;-><init>(Lkotlin/coroutines/Continuation;)V
    move-object v11, v7
    check-cast v11, Lkotlin/jvm/functions/Function2;
    const/4 v12, 3
    const/4 v13, 0
    move-object v8, v2
    invoke-static/range v8 ... v13, Lkotlinx/coroutines/BuildersKt;->async$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Deferred;
    move-result-object v7
    new-instance v8, Lkotlinx/coroutines/selects/SelectImplementation;
    invoke-interface/range v25, Lkotlin/coroutines/Continuation;->getContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v9
    invoke-direct v8, v9, Lkotlinx/coroutines/selects/SelectImplementation;-><init>(Lkotlin/coroutines/CoroutineContext;)V
    move-object v9, v8
    check-cast v9, Lkotlinx/coroutines/selects/SelectBuilder;
    invoke-interface v5, Lkotlinx/coroutines/Deferred;->getOnAwait()Lkotlinx/coroutines/selects/SelectClause1;
    move-result-object v10
    new-instance v11, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1$1$1;
    const/4 v12, 0
    invoke-direct v11, v7, v12, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1$1$1;-><init>(Lkotlinx/coroutines/Deferred; Lkotlin/coroutines/Continuation;)V
    check-cast v11, Lkotlin/jvm/functions/Function2;
    invoke-interface v9, v10, v11, Lkotlinx/coroutines/selects/SelectBuilder;->invoke(Lkotlinx/coroutines/selects/SelectClause1; Lkotlin/jvm/functions/Function2;)V
    invoke-interface v7, Lkotlinx/coroutines/Deferred;->getOnAwait()Lkotlinx/coroutines/selects/SelectClause1;
    move-result-object v7
    new-instance v10, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1$1$2;
    invoke-direct v10, v5, v12, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1$1$2;-><init>(Lkotlinx/coroutines/Deferred; Lkotlin/coroutines/Continuation;)V
    check-cast v10, Lkotlin/jvm/functions/Function2;
    invoke-interface v9, v7, v10, Lkotlinx/coroutines/selects/SelectBuilder;->invoke(Lkotlinx/coroutines/selects/SelectClause1; Lkotlin/jvm/functions/Function2;)V
    move-object/from16 v7, v25
    iput-object v2, v7, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->L$0 Ljava/lang/Object;
    iput-wide v3, v7, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->J$0 J
    move-wide/from16 v10, v20
    iput-wide v10, v7, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->J$1 J
    iput-wide v14, v7, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->J$2 J
    const/4 v9, 2
    iput v9, v7, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->label I
    invoke-virtual v8, v7, Lkotlinx/coroutines/selects/SelectImplementation;->doSelect(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    move-wide v12, v3
    move-object v3, v7
    iget-object v4, v3, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    invoke-static v4, Lcom/bytedance/trae/network/HubNetConnection;->access$getTransportMode$p(Lcom/bytedance/trae/network/HubNetConnection;)Lcom/bytedance/trae/network/TransportMode;
    move-result-object v4
    sget-object v7, Lcom/bytedance/trae/network/TransportMode;->SHUTDOWN Lcom/bytedance/trae/network/TransportMode;
    if-eq v4, v7, +041h
    iget-object v4, v3, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    iget-object v7, v3, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->$cfg Lcom/bytedance/trae/network/FrontierConfig;
    move-object v8, v3
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput-object v2, v3, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->L$0 Ljava/lang/Object;
    iput-wide v12, v3, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->J$0 J
    iput-wide v10, v3, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->J$1 J
    iput-wide v14, v3, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->J$2 J
    const/4 v5, 3
    iput v5, v3, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->label I
    invoke-static v4, v7, v8, Lcom/bytedance/trae/network/HubNetConnection;->access$registerApp(Lcom/bytedance/trae/network/HubNetConnection; Lcom/bytedance/trae/network/FrontierConfig; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v1, -172h
    return-object v1
    check-cast v4, Ljava/lang/Boolean;
    invoke-virtual v4, Ljava/lang/Boolean;->booleanValue()Z
    move-result v4
    if-eqz v4, +012h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v2, retryRegisterApp: registerApp success
    invoke-virtual v1, v6, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->$listener Lcom/bytedance/trae/network/HubConnectionListener;
    if-eqz v1, +014h
    invoke-interface v1, Lcom/bytedance/trae/network/HubConnectionListener;->onRegisterSuccess()V
    goto +fh
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v7, retryRegisterApp: registerApp still failed, will retry
    invoke-virtual v4, v6, v7, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    move v4, v9
    move-object v9, v3
    move v3, v5
    const/4 v5, 1
    goto/16 -154h
    move-object v9, v3
    goto +3h
    move-object v7, v9
    move-object v9, v7
    iget-object v1, v9, Lcom/bytedance/trae/network/HubNetConnection$awaitNetworkRecoveryAndRetry$1;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    const/4 v2, 0
    invoke-static v1, v2, Lcom/bytedance/trae/network/HubNetConnection;->access$setNetworkRecoveryJob$p(Lcom/bytedance/trae/network/HubNetConnection; Lkotlinx/coroutines/Job;)V
    goto +4h
    invoke-static Lcom/bytedance/services/apm/api/EnsureManager;->ensureNotReachHere()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    :try_start_0x1f
    :try_start_0x41
    :try_start_0x53
    :try_start_0x60
.end method
