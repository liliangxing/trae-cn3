# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskViewModel$tasks$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskViewModel.kt"

.implements Lkotlin/jvm/functions/Function6;

.field synthetic L$0:Ljava/lang/Object;
.field synthetic L$1:Ljava/lang/Object;
.field synthetic L$2:Ljava/lang/Object;
.field synthetic L$3:Ljava/lang/Object;
.field synthetic Z$0:Z
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskViewModel;


.method constructor <init>(com.bytedance.trae.home.solo.task.TaskViewModel  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$tasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    const/4 v1, 6
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object  java.lang.Object  java.lang.Object  java.lang.Object  java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=7
    move-object v1, v8
    check-cast v1, Ljava/util/List;
    move-object v2, v9
    check-cast v2, Lcom/bytedance/trae/home/solo/task/FilterOption;
    check-cast v10, Ljava/lang/Boolean;
    invoke-virtual v10, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    move-object v4, v11
    check-cast v4, Ljava/lang/String;
    move-object v5, v12
    check-cast v5, Ljava/util/List;
    move-object v6, v13
    check-cast v6, Lkotlin/coroutines/Continuation;
    move-object v0, v7
    invoke-virtual/range v0 ... v6, Lcom/bytedance/trae/home/solo/task/TaskViewModel$tasks$1;->invoke(Ljava/util/List; Lcom/bytedance/trae/home/solo/task/FilterOption; Z Ljava/lang/String; Ljava/util/List; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    return-object v8
.end method

.method public final invoke(java.util.List  com.bytedance.trae.home.solo.task.FilterOption  boolean  java.lang.String  java.util.List  kotlin.coroutines.Continuation)java.lang.Object
    .registers 9
    # ins_size=7
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$tasks$1;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$tasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-direct v0, v1, v8, Lcom/bytedance/trae/home/solo/task/TaskViewModel$tasks$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$tasks$1;->L$0 Ljava/lang/Object;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$tasks$1;->L$1 Ljava/lang/Object;
    iput-boolean v5, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$tasks$1;->Z$0 Z
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$tasks$1;->L$2 Ljava/lang/Object;
    iput-object v7, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$tasks$1;->L$3 Ljava/lang/Object;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v0, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$tasks$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    return-object v3
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$tasks$1;->label I
    if-nez v0, +0aah
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$tasks$1;->L$0 Ljava/lang/Object;
    check-cast v6, Ljava/util/List;
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$tasks$1;->L$1 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/home/solo/task/FilterOption;
    iget-boolean v1, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$tasks$1;->Z$0 Z
    iget-object v2, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$tasks$1;->L$2 Ljava/lang/Object;
    check-cast v2, Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$tasks$1;->L$3 Ljava/lang/Object;
    check-cast v3, Ljava/util/List;
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    const/4 v4, 1
    if-eqz v1, +013h
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    move v1, v4
    goto +2h
    const/4 v1, 0
    if-eqz v1, +006h
    if-eqz v3, +004h
    goto/16 +070h
    instance-of v1, v0, Lcom/bytedance/trae/home/solo/task/FilterOption$All;
    if-eqz v1, +003h
    goto +64h
    instance-of v1, v0, Lcom/bytedance/trae/home/solo/task/FilterOption$Cloud;
    if-eqz v1, +02bh
    check-cast v6, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +014h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/home/solo/task/TaskModel;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskModel;->isLocal()Z
    move-result v2
    xor-int/2addr v2, v4
    if-eqz v2, -012h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -17h
    move-object v6, v0
    check-cast v6, Ljava/util/List;
    goto +37h
    instance-of v1, v0, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;
    if-eqz v1, +03bh
    check-cast v6, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +01eh
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/home/solo/task/TaskModel;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->getCliId()Ljava/lang/String;
    move-result-object v3
    move-object v4, v0
    check-cast v4, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;->getCliId()Ljava/lang/String;
    move-result-object v4
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -01ch
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -21h
    move-object v6, v1
    check-cast v6, Ljava/util/List;
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$tasks$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v0, v6, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$sortedForTaskList(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Ljava/util/List;)Ljava/util/List;
    move-result-object v3
    return-object v3
    new-instance v6, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v6, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v6
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
.end method
