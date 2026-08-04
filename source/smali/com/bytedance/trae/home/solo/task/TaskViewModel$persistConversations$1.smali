# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskViewModel$persistConversations$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $conversations:Ljava/util/List;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskViewModel;


.method constructor <init>(com.bytedance.trae.home.solo.task.TaskViewModel  java.util.List  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$persistConversations$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$persistConversations$1;->$conversations Ljava/util/List;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$persistConversations$1;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$persistConversations$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$persistConversations$1;->$conversations Ljava/util/List;
    invoke-direct v0, v1, v2, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$persistConversations$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Ljava/util/List; Lkotlin/coroutines/Continuation;)V
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$persistConversations$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$persistConversations$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$persistConversations$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$persistConversations$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$persistConversations$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$persistConversations$1;->label I
    if-nez v0, +03ah
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$persistConversations$1;->L$0 Ljava/lang/Object;
    check-cast v4, Lkotlinx/coroutines/CoroutineScope;
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$persistConversations$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$persistConversations$1;->$conversations Ljava/util/List;
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getConversationDao$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lcom/bytedance/trae/im/database/ConversationDao;
    move-result-object v4
    invoke-virtual v4, v0, Lcom/bytedance/trae/im/database/ConversationDao;->insertOrUpdateAll(Ljava/util/List;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    goto +ch
    move-exception v4
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v4
    if-eqz v4, +00bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v1, "TaskViewModel"
    const-string v2, "persistConversations error"
    invoke-virtual v0, v1, v2, v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
    :try_start_0x12
.end method
