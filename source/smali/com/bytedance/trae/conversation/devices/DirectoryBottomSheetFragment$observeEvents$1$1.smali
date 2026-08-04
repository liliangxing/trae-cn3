# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DirectoryBottomSheetFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;


.method constructor <init>(com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-eq v1, v2, +00ah
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +23h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-static v5, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->access$getViewModel(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->getEvents()Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v5
    new-instance v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1$1;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1$1;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;)V
    check-cast v1, Lkotlinx/coroutines/flow/FlowCollector;
    move-object v3, v4
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v4, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$observeEvents$1$1;->label I
    invoke-interface v5, v1, v3, Lkotlinx/coroutines/flow/SharedFlow;->collect(Lkotlinx/coroutines/flow/FlowCollector; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v0, +003h
    return-object v0
    new-instance v5, Lkotlin/KotlinNothingValueException;
    invoke-direct v5, Lkotlin/KotlinNothingValueException;-><init>()V
    throw v5
.end method
