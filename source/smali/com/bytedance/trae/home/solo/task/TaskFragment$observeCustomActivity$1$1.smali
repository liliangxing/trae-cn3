# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $ivOperationIcon:Lcom/facebook/drawee/view/SimpleDraweeView;
.field final synthetic $titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskFragment;


.method constructor <init>(com.bytedance.trae.common.widget.TraeTitleBar  com.facebook.drawee.view.SimpleDraweeView  com.bytedance.trae.home.solo.task.TaskFragment  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1;->$titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1;->$ivOperationIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1;
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1;->$titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1;->$ivOperationIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1;-><init>(Lcom/bytedance/trae/common/widget/TraeTitleBar; Lcom/facebook/drawee/view/SimpleDraweeView; Lcom/bytedance/trae/home/solo/task/TaskFragment; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +32h
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v8, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->Companion Lcom/bytedance/trae/conversation/network/CustomActivityRepository$Companion;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/network/CustomActivityRepository;
    move-result-object v8
    invoke-virtual v8, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->getFirstBanner()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v8
    check-cast v8, Lkotlinx/coroutines/flow/Flow;
    new-instance v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;
    iget-object v3, v7, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1;->$titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iget-object v4, v7, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1;->$ivOperationIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    iget-object v5, v7, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    const/4 v6, 0
    invoke-direct v1, v3, v4, v5, v6, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;-><init>(Lcom/bytedance/trae/common/widget/TraeTitleBar; Lcom/facebook/drawee/view/SimpleDraweeView; Lcom/bytedance/trae/home/solo/task/TaskFragment; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v3, v7
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v7, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1;->label I
    invoke-static v8, v1, v3, Lkotlinx/coroutines/flow/FlowKt;->collectLatest(Lkotlinx/coroutines/flow/Flow; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
.end method
