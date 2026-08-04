# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DeviceActivateBottomSheet.kt"

.implements Lkotlin/jvm/functions/Function2;

.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;


.method constructor <init>(com.bytedance.trae.conversation.devices.DeviceActivateBottomSheet  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 19
    # ins_size=2
    move-object/from16 v0, v17
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v2, +021h
    if-eq v2, v4, +014h
    if-ne v2, v3, +00ah
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1bh
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v6, v18
    move-object v5, v0
    goto +23h
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    move-object v5, v0
    invoke-static v2, Lkotlinx/coroutines/CoroutineScopeKt;->isActive(Lkotlinx/coroutines/CoroutineScope;)Z
    move-result v6
    if-eqz v6, +0fch
    iget-object v6, v5, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;
    invoke-static v6, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->access$getRepository$p(Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;)Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v6
    move-object v7, v5
    check-cast v7, Lkotlin/coroutines/Continuation;
    iput-object v2, v5, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->L$0 Ljava/lang/Object;
    iput v4, v5, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->label I
    invoke-virtual v6, v7, Lcom/bytedance/trae/conversation/CliListRepository;->refreshDiscoverableDevices(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v1, +003h
    return-object v1
    check-cast v6, Lcom/bytedance/trae/conversation/DeviceDiscoveryRefreshResult;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/DeviceDiscoveryRefreshResult;->getDevices()Ljava/util/List;
    move-result-object v6
    sget-object v7, Lcom/bytedance/trae/conversation/devices/DeviceOfflineRecoveryPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/DeviceOfflineRecoveryPolicy;
    iget-object v8, v5, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;
    invoke-static v8, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->access$getTarget$p(Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;)Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    move-result-object v8
    invoke-virtual v7, v8, v6, Lcom/bytedance/trae/conversation/devices/DeviceOfflineRecoveryPolicy;->findRecoveredDevice(Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget; Ljava/util/List;)Lcom/bytedance/trae/conversation/devices/MobileDevice;
    move-result-object v7
    if-eqz v7, +0c4h
    sget-object v8, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v9, Ljava/lang/StringBuilder;
    const-string v10, "offline_device_recovered: target="
    invoke-direct v9, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v10, v5, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;
    invoke-static v10, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->access$getTarget$p(Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;)Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    move-result-object v10
    invoke-static v10, Lcom/bytedance/trae/conversation/devices/DeviceItemKt;->toDeviceLogSummary(Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;)Ljava/lang/String;
    move-result-object v10
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v10, ", deviceCount="
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-interface v6, Ljava/util/List;->size()I
    move-result v10
    invoke-virtual v9, v10, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    const-string v10, "DeviceActivateBottomSheet"
    invoke-virtual v8, v10, v9, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v8, v5, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;
    check-cast v8, Landroidx/fragment/app/Fragment;
    invoke-static v8, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigatorKt;->deviceFlowNavigator(Landroidx/fragment/app/Fragment;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;
    move-result-object v8
    iget-object v9, v5, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;
    invoke-static v9, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->access$getTarget$p(Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;)Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    move-result-object v9
    invoke-virtual v9, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->isPaired()Z
    move-result v9
    if-nez v9, +044h
    if-eqz v8, +042h
    new-instance v9, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;
    new-instance v15, Lcom/bytedance/trae/conversation/devices/BindingTarget;
    iget-object v10, v5, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;
    invoke-static v10, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->access$getTarget$p(Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;)Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    move-result-object v10
    invoke-virtual v10, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v11
    iget-object v10, v5, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;
    invoke-static v10, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->access$getTarget$p(Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;)Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    move-result-object v10
    invoke-virtual v10, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v10
    invoke-static v6, v10, Lcom/bytedance/trae/conversation/devices/DeviceBindingPolicyKt;->idsForProduct(Ljava/util/List; Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Ljava/util/Set;
    move-result-object v12
    iget-object v6, v5, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;
    invoke-static v6, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->access$getTarget$p(Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;)Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->getEnterFrom()Ljava/lang/String;
    move-result-object v13
    sget-object v14, Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;->UNBOUND_DEVICE Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getName()Ljava/lang/String;
    move-result-object v16
    move-object v10, v15
    move-object v7, v15
    move-object v15, v6
    invoke-direct/range v10 ... v16, Lcom/bytedance/trae/conversation/devices/BindingTarget;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/Set; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger; Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v9, v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;-><init>(Lcom/bytedance/trae/conversation/devices/BindingTarget;)V
    check-cast v9, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    invoke-interface v8, v9, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;->navigate(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;)V
    move v6, v4
    goto +3ah
    iget-object v6, v5, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;
    invoke-static v6, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->access$getTarget$p(Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;)Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->isPaired()Z
    move-result v6
    if-nez v6, +013h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->dismissAllowingStateLoss()V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->getOnUnpairedDeviceOnline()Lkotlin/jvm/functions/Function1;
    move-result-object v6
    if-eqz v6, -019h
    invoke-interface v6, v7, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto -1eh
    if-eqz v8, +016h
    invoke-interface v8, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;->onRouteBack()Z
    move-result v6
    if-eqz v6, +00eh
    iget-object v6, v5, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->getOnDismissListener()Lkotlin/jvm/functions/Function0;
    move-result-object v6
    if-eqz v6, -02dh
    invoke-interface v6, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    goto -32h
    const/4 v6, 0
    goto +7h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->dismissAllowingStateLoss()V
    goto -3ah
    if-eqz v6, +005h
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    move-object v6, v5
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput-object v2, v5, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->L$0 Ljava/lang/Object;
    iput v3, v5, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1$1;->label I
    const-wide/16 v7, 5000
    invoke-static v7, v8, v6, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v1, -0fdh
    return-object v1
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method
