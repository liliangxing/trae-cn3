# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;
.super Landroidx/lifecycle/ViewModel;
.source "ConnectComputerGuideViewModel.kt"

.field private static final Companion:Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$Companion;
.field public static final POLL_INTERVAL_MS:J
.field private final _state:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final discovery:Lcom/bytedance/trae/conversation/devices/BindingDeviceDiscovery;
.field private final pollIntervalMs:J
.field private pollingJob:Lkotlinx/coroutines/Job;
.field private final state:Lkotlinx/coroutines/flow/StateFlow;
.field private final stateMachine:Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->Companion Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$Companion;
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.devices.BindingTarget  com.bytedance.trae.conversation.devices.BindingDeviceDiscovery  long)void
    .registers 6
    # ins_size=5
    const-string/jumbo v0, target
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "discovery"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Landroidx/lifecycle/ViewModel;-><init>()V
    iput-object v3, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->discovery Lcom/bytedance/trae/conversation/devices/BindingDeviceDiscovery;
    iput-wide v4, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->pollIntervalMs J
    new-instance v3, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;
    invoke-direct v3, v2, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;-><init>(Lcom/bytedance/trae/conversation/devices/BindingTarget;)V
    iput-object v3, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->stateMachine Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->getCurrentState()Lcom/bytedance/trae/conversation/devices/BindingGuideState;
    move-result-object v2
    invoke-static v2, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->state Lkotlinx/coroutines/flow/StateFlow;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.conversation.devices.BindingTarget  com.bytedance.trae.conversation.devices.BindingDeviceDiscovery  long  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 2
    if-eqz v6, +006h
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DefaultBindingDeviceDiscovery;->INSTANCE Lcom/bytedance/trae/conversation/devices/DefaultBindingDeviceDiscovery;
    check-cast v2, Lcom/bytedance/trae/conversation/devices/BindingDeviceDiscovery;
    and-int/lit8 v5, v5, 4
    if-eqz v5, +004h
    const-wide/16 v3, 5000
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;-><init>(Lcom/bytedance/trae/conversation/devices/BindingTarget; Lcom/bytedance/trae/conversation/devices/BindingDeviceDiscovery; J)V
    return-void 
.end method

.method public static final synthetic access$getDiscovery$p(com.bytedance.trae.conversation.devices.ConnectComputerGuideViewModel)com.bytedance.trae.conversation.devices.BindingDeviceDiscovery
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->discovery Lcom/bytedance/trae/conversation/devices/BindingDeviceDiscovery;
    return-object v0
.end method

.method public static final synthetic access$getPollIntervalMs$p(com.bytedance.trae.conversation.devices.ConnectComputerGuideViewModel)long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->pollIntervalMs J
    return-wide v0
.end method

.method public static final synthetic access$getStateMachine$p(com.bytedance.trae.conversation.devices.ConnectComputerGuideViewModel)com.bytedance.trae.conversation.devices.BindingGuideStateMachine
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->stateMachine Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;
    return-object v0
.end method

.method public static final synthetic access$get_state$p(com.bytedance.trae.conversation.devices.ConnectComputerGuideViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public final consumeSucceededDevice()com.bytedance.trae.conversation.devices.MobileDevice
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->stateMachine Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/BindingGuideStateMachine;->consumeSucceededDevice()Lcom/bytedance/trae/conversation/devices/MobileDevice;
    move-result-object v0
    return-object v0
.end method

.method public final getState()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->state Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method protected onCleared()void
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->stop()V
    invoke-super v0, Landroidx/lifecycle/ViewModel;->onCleared()V
    return-void 
.end method

.method public final start()void
    .registers 8
    # ins_size=1
    iget-object v0, v7, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->pollingJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-interface v0, Lkotlinx/coroutines/Job;->isActive()Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    if-eqz v1, +003h
    return-void 
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$start$1;-><init>(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v7, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->pollingJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final stop()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->pollingJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v1, v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->pollingJob Lkotlinx/coroutines/Job;
    return-void 
.end method
