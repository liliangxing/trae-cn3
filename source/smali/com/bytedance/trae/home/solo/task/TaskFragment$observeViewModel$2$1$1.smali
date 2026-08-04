# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskFragment.kt"

.implements Lkotlin/jvm/functions/Function3;

.field synthetic L$0:Ljava/lang/Object;
.field synthetic Z$0:Z
.field  label:I


.method constructor <init>(kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=2
    const/4 v0, 3
    invoke-direct v1, v0, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object  java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=4
    check-cast v1, Ljava/lang/Boolean;
    invoke-virtual v1, Ljava/lang/Boolean;->booleanValue()Z
    move-result v1
    check-cast v2, Ljava/lang/String;
    check-cast v3, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$1;->invoke(Z Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(boolean  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$1;
    invoke-direct v0, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$1;-><init>(Lkotlin/coroutines/Continuation;)V
    iput-boolean v2, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$1;->Z$0 Z
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$1;->L$0 Ljava/lang/Object;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v0, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$1;->label I
    if-nez v0, +014h
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-boolean v2, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$1;->Z$0 Z
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2$1$1;->L$0 Ljava/lang/Object;
    check-cast v0, Ljava/lang/String;
    invoke-static v2, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    return-object v2
    new-instance v2, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v2, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v2
.end method
