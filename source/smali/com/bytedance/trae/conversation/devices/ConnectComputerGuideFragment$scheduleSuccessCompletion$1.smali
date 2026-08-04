# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$scheduleSuccessCompletion$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConnectComputerGuideFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;


.method public static synthetic $r8$lambda$iW1spzCUWkuWhxla2aSRNg5DE30(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$scheduleSuccessCompletion$1;->invokeSuspend$lambda$0(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$scheduleSuccessCompletion$1;->this$0 Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$0(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->access$completeConnectionSuccess(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$scheduleSuccessCompletion$1;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$scheduleSuccessCompletion$1;->this$0 Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$scheduleSuccessCompletion$1;-><init>(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$scheduleSuccessCompletion$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$scheduleSuccessCompletion$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$scheduleSuccessCompletion$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$scheduleSuccessCompletion$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$scheduleSuccessCompletion$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2bh
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$scheduleSuccessCompletion$1;->this$0 Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v7
    invoke-interface v7, Landroidx/lifecycle/LifecycleOwner;->getLifecycle()Landroidx/lifecycle/Lifecycle;
    move-result-object v7
    iget-object v1, v6, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$scheduleSuccessCompletion$1;->this$0 Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    new-instance v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$scheduleSuccessCompletion$1$$ExternalSyntheticLambda0;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$scheduleSuccessCompletion$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;)V
    move-object v1, v6
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v2, v6, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$scheduleSuccessCompletion$1;->label I
    const-wide/16 v4, 2000
    invoke-static v7, v4, v5, v3, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessLifecycleKt;->runConnectionSuccessWhenResumed(Landroidx/lifecycle/Lifecycle; J Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method
