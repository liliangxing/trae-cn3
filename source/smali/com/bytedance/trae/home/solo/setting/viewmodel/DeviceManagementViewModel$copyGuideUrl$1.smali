# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$copyGuideUrl$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DeviceManagementViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $url:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;


.method constructor <init>(com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementViewModel  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$copyGuideUrl$1;->this$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$copyGuideUrl$1;->$url Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$copyGuideUrl$1;
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$copyGuideUrl$1;->this$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$copyGuideUrl$1;->$url Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$copyGuideUrl$1;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$copyGuideUrl$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$copyGuideUrl$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$copyGuideUrl$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$copyGuideUrl$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$copyGuideUrl$1;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +016h
    if-eq v1, v3, +010h
    if-ne v1, v2, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3dh
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1dh
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$copyGuideUrl$1;->this$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
    invoke-static v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->access$get_effects$p(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v6
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$CopyToClipboard;
    iget-object v4, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$copyGuideUrl$1;->$url Ljava/lang/String;
    invoke-direct v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$CopyToClipboard;-><init>(Ljava/lang/String;)V
    move-object v4, v5
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$copyGuideUrl$1;->label I
    invoke-interface v6, v1, v4, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$copyGuideUrl$1;->this$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
    invoke-static v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->access$get_effects$p(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v6
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$ShowCopySuccessToast;->INSTANCE Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$ShowCopySuccessToast;
    move-object v3, v5
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$copyGuideUrl$1;->label I
    invoke-interface v6, v1, v3, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method
