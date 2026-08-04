# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/network/HubNetConnection$connect$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "HubNetConnection.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cfg:Lcom/bytedance/trae/network/FrontierConfig;
.field final synthetic $listener:Lcom/bytedance/trae/network/HubConnectionListener;
.field final synthetic $reason:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/network/HubNetConnection;


.method public static synthetic $r8$lambda$9c-y2PFNBOyRrUDnLH_P8na9LXE(com.bytedance.trae.network.HubNetConnection  com.bytedance.trae.network.FrontierConfig  com.bytedance.trae.network.HubConnectionListener)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->invokeSuspend$lambda$2(Lcom/bytedance/trae/network/HubNetConnection; Lcom/bytedance/trae/network/FrontierConfig; Lcom/bytedance/trae/network/HubConnectionListener;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$N96cjqB8H8z4g0DLgadnfLhTC9s(com.bytedance.trae.network.HubConnectionListener)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->invokeSuspend$lambda$1(Lcom/bytedance/trae/network/HubConnectionListener;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$fZVBuoxKkzyexS2jC1ejBu0PYio(com.bytedance.trae.network.HubNetConnection  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->invokeSuspend$lambda$0(Lcom/bytedance/trae/network/HubNetConnection; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.network.HubNetConnection  java.lang.String  com.bytedance.trae.network.FrontierConfig  com.bytedance.trae.network.HubConnectionListener  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    iput-object v2, v0, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->$reason Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->$cfg Lcom/bytedance/trae/network/FrontierConfig;
    iput-object v4, v0, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->$listener Lcom/bytedance/trae/network/HubConnectionListener;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$0(com.bytedance.trae.network.HubNetConnection  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/network/HubNetConnection;->access$startConnectedTransport(Lcom/bytedance/trae/network/HubNetConnection; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final invokeSuspend$lambda$1(com.bytedance.trae.network.HubConnectionListener)kotlin.Unit
    .registers 1
    # ins_size=1
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/trae/network/HubConnectionListener;->onRegisterSuccess()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final invokeSuspend$lambda$2(com.bytedance.trae.network.HubNetConnection  com.bytedance.trae.network.FrontierConfig  com.bytedance.trae.network.HubConnectionListener)kotlin.Unit
    .registers 6
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/network/NetworkMonitor;->INSTANCE Lcom/bytedance/trae/network/NetworkMonitor;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    check-cast v1, Landroid/content/Context;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/NetworkMonitor;->init(Landroid/content/Context;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "HubNetConnection"
    const-string v2, "connect: registerApp failed, keeping transport and scheduling registration retry"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v3, v4, v5, Lcom/bytedance/trae/network/HubNetConnection;->access$awaitNetworkRecoveryAndRetry(Lcom/bytedance/trae/network/HubNetConnection; Lcom/bytedance/trae/network/FrontierConfig; Lcom/bytedance/trae/network/HubConnectionListener;)V
    goto +4h
    invoke-static Lcom/bytedance/services/apm/api/EnsureManager;->ensureNotReachHere()V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
    :try_start_0x0
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/network/HubNetConnection$connect$2;
    iget-object v1, v6, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    iget-object v2, v6, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->$reason Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->$cfg Lcom/bytedance/trae/network/FrontierConfig;
    iget-object v4, v6, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->$listener Lcom/bytedance/trae/network/HubConnectionListener;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/network/HubNetConnection$connect$2;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Ljava/lang/String; Lcom/bytedance/trae/network/FrontierConfig; Lcom/bytedance/trae/network/HubConnectionListener; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/HubNetConnection$connect$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v8, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3fh
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v9, v8, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    iget-object v1, v8, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->$reason Ljava/lang/String;
    new-instance v3, Lcom/bytedance/trae/network/HubNetConnection$connect$2$$ExternalSyntheticLambda0;
    invoke-direct v3, v9, v1, Lcom/bytedance/trae/network/HubNetConnection$connect$2$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Ljava/lang/String;)V
    new-instance v9, Lcom/bytedance/trae/network/HubNetConnection$connect$2$2;
    iget-object v1, v8, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    iget-object v4, v8, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->$cfg Lcom/bytedance/trae/network/FrontierConfig;
    const/4 v5, 0
    invoke-direct v9, v1, v4, v5, Lcom/bytedance/trae/network/HubNetConnection$connect$2$2;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lcom/bytedance/trae/network/FrontierConfig; Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/jvm/functions/Function1;
    iget-object v1, v8, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->$listener Lcom/bytedance/trae/network/HubConnectionListener;
    new-instance v4, Lcom/bytedance/trae/network/HubNetConnection$connect$2$$ExternalSyntheticLambda1;
    invoke-direct v4, v1, Lcom/bytedance/trae/network/HubNetConnection$connect$2$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/network/HubConnectionListener;)V
    iget-object v1, v8, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->this$0 Lcom/bytedance/trae/network/HubNetConnection;
    iget-object v5, v8, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->$cfg Lcom/bytedance/trae/network/FrontierConfig;
    iget-object v6, v8, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->$listener Lcom/bytedance/trae/network/HubConnectionListener;
    new-instance v7, Lcom/bytedance/trae/network/HubNetConnection$connect$2$$ExternalSyntheticLambda2;
    invoke-direct v7, v1, v5, v6, Lcom/bytedance/trae/network/HubNetConnection$connect$2$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lcom/bytedance/trae/network/FrontierConfig; Lcom/bytedance/trae/network/HubConnectionListener;)V
    move-object v1, v8
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v2, v8, Lcom/bytedance/trae/network/HubNetConnection$connect$2;->label I
    invoke-static v3, v9, v4, v7, v1, Lcom/bytedance/trae/network/HubNetConnectionKt;->startTransportThenRegister(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v0, +003h
    return-object v0
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
.end method
