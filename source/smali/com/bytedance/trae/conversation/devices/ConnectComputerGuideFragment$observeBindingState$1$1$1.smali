# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$observeBindingState$1$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConnectComputerGuideFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;


.method constructor <init>(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$observeBindingState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$observeBindingState$1$1$1;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$observeBindingState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$observeBindingState$1$1$1;-><init>(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$observeBindingState$1$1$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public final invoke(com.bytedance.trae.conversation.devices.BindingGuideState  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$observeBindingState$1$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$observeBindingState$1$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$observeBindingState$1$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/devices/BindingGuideState;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$observeBindingState$1$1$1;->invoke(Lcom/bytedance/trae/conversation/devices/BindingGuideState; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$observeBindingState$1$1$1;->label I
    if-nez v0, +02dh
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$observeBindingState$1$1$1;->L$0 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/conversation/devices/BindingGuideState;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$observeBindingState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    invoke-interface v3, Lcom/bytedance/trae/conversation/devices/BindingGuideState;->getDisplayState()Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;
    move-result-object v1
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->access$renderBindingState(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment; Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;)V
    invoke-interface v3, Lcom/bytedance/trae/conversation/devices/BindingGuideState;->getDisplayState()Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;
    move-result-object v3
    instance-of v3, v3, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$Succeeded;
    if-eqz v3, +012h
    iget-object v3, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$observeBindingState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    invoke-static v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->access$getPairingEventTracker$p(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;)Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;
    move-result-object v3
    if-eqz v3, +005h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;->onPairingSucceeded()V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$observeBindingState$1$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    invoke-static v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->access$scheduleSuccessCompletion(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
    new-instance v3, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v3, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v3
.end method
