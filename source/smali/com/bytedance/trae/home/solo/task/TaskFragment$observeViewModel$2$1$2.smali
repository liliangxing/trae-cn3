# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskFragment;


.method constructor <init>(com.bytedance.trae.home.solo.task.TaskFragment  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$2;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$2;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$2;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$2;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$2;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlin/Pair;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$2;->invoke(Lkotlin/Pair; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlin.Pair  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$2;->label I
    if-nez v0, +029h
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$2;->L$0 Ljava/lang/Object;
    check-cast v4, Lkotlin/Pair;
    invoke-virtual v4, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    invoke-virtual v4, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$2;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;
    move-result-object v1
    if-eqz v1, +007h
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$2;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    invoke-static v2, v1, v0, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment;->access$renderSearchHeader(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroid/view/View; Z Ljava/lang/String;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
.end method
