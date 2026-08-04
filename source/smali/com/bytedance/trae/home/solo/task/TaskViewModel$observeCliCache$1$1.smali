# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskViewModel$observeCliCache$1$1;
.super Ljava/lang/Object;
.source "TaskViewModel.kt"

.implements Lkotlinx/coroutines/flow/FlowCollector;

.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskViewModel;


.method constructor <init>(com.bytedance.trae.home.solo.task.TaskViewModel)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$observeCliCache$1$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public bridge synthetic emit(java.lang.Object  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Ljava/util/List;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$observeCliCache$1$1;->emit(Ljava/util/List; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final emit(java.util.List  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$observeCliCache$1$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v2, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$applyDevices(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Ljava/util/List;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method
