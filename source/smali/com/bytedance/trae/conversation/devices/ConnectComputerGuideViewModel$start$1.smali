# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConnectComputerGuideViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;


.method constructor <init>(com.bytedance.trae.conversation.devices.ConnectComputerGuideViewModel  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;->this$0 Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;->this$0 Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;-><init>(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +021h
    if-eq v1, v3, +015h
    if-ne v1, v2, +00bh
    iget-object v1, v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v9, v1
    goto +1ah
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    iget-object v1, v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v4, v1
    move-object v1, v8
    goto +26h
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v9, v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;->L$0 Ljava/lang/Object;
    check-cast v9, Lkotlinx/coroutines/CoroutineScope;
    move-object v1, v8
    invoke-static v9, Lkotlinx/coroutines/CoroutineScopeKt;->isActive(Lkotlinx/coroutines/CoroutineScope;)Z
    move-result v4
    if-eqz v4, +070h
    iget-object v4, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;->this$0 Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;
    invoke-static v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->access$getDiscovery$p(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;)Lcom/bytedance/trae/conversation/devices/BindingDeviceDiscovery;
    move-result-object v4
    move-object v5, v1
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;->L$0 Ljava/lang/Object;
    iput v3, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;->label I
    invoke-interface v4, v5, Lcom/bytedance/trae/conversation/devices/BindingDeviceDiscovery;->refresh(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v0, +003h
    return-object v0
    move-object v7, v4
    move-object v4, v9
    move-object v9, v7
    check-cast v9, Lcom/bytedance/trae/conversation/DeviceDiscoveryRefreshResult;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;->this$0 Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;
    invoke-static v5, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->access$get_state$p(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v5
    invoke-virtual v9, Lcom/bytedance/trae/conversation/DeviceDiscoveryRefreshResult;->isSuccess()Z
    move-result v6
    if-eqz v6, +013h
    iget-object v6, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;->this$0 Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;
    invoke-static v6, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->access$getStateMachine$p(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;)Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;
    move-result-object v6
    invoke-virtual v9, Lcom/bytedance/trae/conversation/DeviceDiscoveryRefreshResult;->getDevices()Ljava/util/List;
    move-result-object v9
    invoke-virtual v6, v9, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->onRefreshSucceeded(Ljava/util/List;)Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/conversation/devices/BindingGuideState;
    goto +bh
    iget-object v9, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;->this$0 Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;
    invoke-static v9, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->access$getStateMachine$p(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;)Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;
    move-result-object v9
    invoke-virtual v9, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->onRefreshFailed()Lcom/bytedance/trae/conversation/devices/BindingGuideState;
    move-result-object v9
    invoke-interface v5, v9, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v9, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;->this$0 Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;
    invoke-static v9, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->access$get_state$p(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v9
    invoke-interface v9, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/conversation/devices/BindingGuideState;
    invoke-interface v9, Lcom/bytedance/trae/conversation/devices/BindingGuideState;->getDisplayState()Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;
    move-result-object v9
    instance-of v9, v9, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$Succeeded;
    if-eqz v9, +003h
    goto +17h
    iget-object v9, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;->this$0 Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;
    invoke-static v9, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->access$getPollIntervalMs$p(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;)J
    move-result-wide v5
    move-object v9, v1
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;->L$0 Ljava/lang/Object;
    iput v2, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;->label I
    invoke-static v5, v6, v9, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v0, +003h
    return-object v0
    move-object v9, v4
    goto -73h
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
.end method
