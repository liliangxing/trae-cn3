# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "MainActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $vm:Lcom/bytedance/trae/home/solo/task/TaskViewModel;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/MainActivity;


.method public static synthetic $r8$lambda$cM6SX6WY6EimD7H8yLkhur9Y3uc(com.bytedance.trae.home.MainActivity)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;->invokeSuspend$lambda$0(Lcom/bytedance/trae/home/MainActivity;)V
    return-void 
.end method

.method constructor <init>(com.bytedance.trae.home.solo.task.TaskViewModel  com.bytedance.trae.home.MainActivity  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;->$vm Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;->this$0 Lcom/bytedance/trae/home/MainActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$0(com.bytedance.trae.home.MainActivity)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/MainActivity;->access$dismissSplashAndNavigate(Lcom/bytedance/trae/home/MainActivity;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;
    iget-object v0, v2, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;->$vm Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    iget-object v1, v2, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;->this$0 Lcom/bytedance/trae/home/MainActivity;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lcom/bytedance/trae/home/MainActivity; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 12
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v10, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;->label I
    const/4 v2, 0
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v1, +016h
    if-eq v1, v4, +010h
    if-ne v1, v3, +006h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3dh
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1fh
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v11, v10, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;->$vm Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->getContentReady()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v11
    check-cast v11, Lkotlinx/coroutines/flow/Flow;
    new-instance v1, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1$1;
    invoke-direct v1, v2, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v5, v10
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v4, v10, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;->label I
    invoke-static v11, v1, v5, Lkotlinx/coroutines/flow/FlowKt;->first(Lkotlinx/coroutines/flow/Flow; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v0, +003h
    return-object v0
    sget-object v4, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;
    const-wide/16 v5, 0
    move-object v7, v10
    check-cast v7, Lkotlin/coroutines/Continuation;
    const/4 v8, 1
    const/4 v9, 0
    iput v3, v10, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;->label I
    invoke-static/range v4 ... v9, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->awaitReady$default(Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator; J Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v0, +003h
    return-object v0
    iget-object v11, v10, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;->this$0 Lcom/bytedance/trae/home/MainActivity;
    invoke-static v11, Lcom/bytedance/trae/home/MainActivity;->access$isSplashDismissed$p(Lcom/bytedance/trae/home/MainActivity;)Z
    move-result v11
    if-eqz v11, +013h
    iget-object v11, v10, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;->this$0 Lcom/bytedance/trae/home/MainActivity;
    invoke-static v11, Lcom/bytedance/trae/home/MainActivity;->access$getPendingNavigate$p(Lcom/bytedance/trae/home/MainActivity;)Lkotlin/jvm/functions/Function0;
    move-result-object v11
    iget-object v0, v10, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;->this$0 Lcom/bytedance/trae/home/MainActivity;
    invoke-static v0, v2, Lcom/bytedance/trae/home/MainActivity;->access$setPendingNavigate$p(Lcom/bytedance/trae/home/MainActivity; Lkotlin/jvm/functions/Function0;)V
    if-eqz v11, +038h
    invoke-interface v11, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    goto +33h
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v0
    iget-object v11, v10, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;->this$0 Lcom/bytedance/trae/home/MainActivity;
    invoke-static v11, Lcom/bytedance/trae/home/MainActivity;->access$getSplashShowTime$p(Lcom/bytedance/trae/home/MainActivity;)J
    move-result-wide v2
    sub-long/2addr v0, v2
    const-wide/16 v2, 800
    sub-long/2addr v2, v0
    const-wide/16 v0, 0
    invoke-static v2, v3, v0, v1, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v2
    cmp-long v11, v2, v0
    if-lez v11, +017h
    iget-object v11, v10, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;->this$0 Lcom/bytedance/trae/home/MainActivity;
    invoke-static v11, Lcom/bytedance/trae/home/MainActivity;->access$getHandler$p(Lcom/bytedance/trae/home/MainActivity;)Landroid/os/Handler;
    move-result-object v11
    iget-object v0, v10, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;->this$0 Lcom/bytedance/trae/home/MainActivity;
    new-instance v1, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1$$ExternalSyntheticLambda0;
    invoke-direct v1, v0, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/MainActivity;)V
    invoke-virtual v11, v1, v2, v3, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    move-result v11
    invoke-static v11, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    goto +6h
    iget-object v11, v10, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;->this$0 Lcom/bytedance/trae/home/MainActivity;
    invoke-static v11, Lcom/bytedance/trae/home/MainActivity;->access$dismissSplashAndNavigate(Lcom/bytedance/trae/home/MainActivity;)V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
.end method
