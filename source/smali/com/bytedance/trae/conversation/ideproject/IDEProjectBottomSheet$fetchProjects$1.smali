# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "IDEProjectBottomSheet.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cliId:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;


.method constructor <init>(com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1;->this$0 Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1;->$cliId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1;->this$0 Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1;->$cliId Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1;-><init>(Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v9, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1;->label I
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +010h
    if-ne v1, v3, +006h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +28h
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v10, Lcom/bytedance/trae/conversation/network/IGetProjectApi;->Companion Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1$result$1;
    iget-object v5, v9, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1;->$cliId Ljava/lang/String;
    invoke-direct v1, v5, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1$result$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    move-object v6, v9
    check-cast v6, Lkotlin/coroutines/Continuation;
    const/4 v7, 1
    const/4 v8, 0
    iput v3, v9, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1;->label I
    move-object v3, v10
    invoke-static/range v3 ... v8, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->safeCall$default(Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion; Ljava/util/Map; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v0, +003h
    return-object v0
    check-cast v10, Lcom/bytedance/trae/network/response/HttpDataResult;
    iget-object v0, v9, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1;->this$0 Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->isAdded()Z
    move-result v0
    if-nez v0, +005h
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
    instance-of v0, v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v0, +034h
    sget-object v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectListPolicy;->INSTANCE Lcom/bytedance/trae/conversation/ideproject/IDEProjectListPolicy;
    check-cast v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v10
    if-eqz v10, +00eh
    invoke-virtual v10, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/conversation/network/ListProjectsData;
    if-eqz v10, +006h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/ListProjectsData;->getProjects()Ljava/util/List;
    move-result-object v2
    if-nez v2, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectListPolicy;->visibleProjects(Ljava/util/List;)Ljava/util/List;
    move-result-object v10
    invoke-interface v10, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +008h
    iget-object v10, v9, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1;->this$0 Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;
    invoke-static v10, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->access$showEmpty(Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;)V
    goto +10h
    iget-object v0, v9, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1;->this$0 Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;
    invoke-static v0, v10, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->access$showContent(Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet; Ljava/util/List;)V
    goto +ah
    instance-of v10, v10, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v10, +00ah
    iget-object v10, v9, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$fetchProjects$1;->this$0 Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;
    invoke-static v10, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->access$showEmpty(Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;)V
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
    new-instance v10, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v10, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v10
.end method
