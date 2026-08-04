# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskFragment.kt"

.implements Lkotlin/jvm/functions/Function6;

.field synthetic L$0:Ljava/lang/Object;
.field synthetic L$1:Ljava/lang/Object;
.field synthetic Z$0:Z
.field synthetic Z$1:Z
.field synthetic Z$2:Z
.field  label:I


.method constructor <init>(kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=2
    const/4 v0, 6
    invoke-direct v1, v0, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object  java.lang.Object  java.lang.Object  java.lang.Object  java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=7
    move-object v1, v8
    check-cast v1, Ljava/util/List;
    check-cast v9, Ljava/lang/Boolean;
    invoke-virtual v9, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    check-cast v10, Ljava/lang/Boolean;
    invoke-virtual v10, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    move-object v4, v11
    check-cast v4, Ljava/lang/String;
    check-cast v12, Ljava/lang/Boolean;
    invoke-virtual v12, Ljava/lang/Boolean;->booleanValue()Z
    move-result v5
    move-object v6, v13
    check-cast v6, Lkotlin/coroutines/Continuation;
    move-object v0, v7
    invoke-virtual/range v0 ... v6, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$1;->invoke(Ljava/util/List; Z Z Ljava/lang/String; Z Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    return-object v8
.end method

.method public final invoke(java.util.List  boolean  boolean  java.lang.String  boolean  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=7
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$1;
    invoke-direct v0, v7, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$1;-><init>(Lkotlin/coroutines/Continuation;)V
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$1;->L$0 Ljava/lang/Object;
    iput-boolean v3, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$1;->Z$0 Z
    iput-boolean v4, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$1;->Z$1 Z
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$1;->L$1 Ljava/lang/Object;
    iput-boolean v6, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$1;->Z$2 Z
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v0, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v6, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$1;->label I
    if-nez v0, +01ch
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$1;->L$0 Ljava/lang/Object;
    move-object v1, v7
    check-cast v1, Ljava/util/List;
    iget-boolean v2, v6, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$1;->Z$0 Z
    iget-boolean v3, v6, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$1;->Z$1 Z
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$1;->L$1 Ljava/lang/Object;
    move-object v4, v7
    check-cast v4, Ljava/lang/String;
    iget-boolean v5, v6, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1$1$1;->Z$2 Z
    new-instance v7, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;
    move-object v0, v7
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;-><init>(Ljava/util/List; Z Z Ljava/lang/String; Z)V
    return-object v7
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
.end method
