# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SkillsViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $isLoadMore:Z
.field  L$0:Ljava/lang/Object;
.field  Z$0:Z
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/skill/SkillsViewModel;


.method constructor <init>(com.bytedance.trae.conversation.skill.SkillsViewModel  boolean  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->$isLoadMore Z
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->$isLoadMore Z
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;-><init>(Lcom/bytedance/trae/conversation/skill/SkillsViewModel; Z Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 18
    # ins_size=2
    move-object/from16 v0, v16
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->label I
    const/4 v3, 3
    const/4 v4, 2
    const-string/jumbo v5, 获取 Skill 列表失败
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 1
    if-eqz v2, +02eh
    if-eq v2, v8, +020h
    if-eq v2, v4, +015h
    if-ne v2, v3, +00bh
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->Z$0 Z
    invoke-static/range v17, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v3, v17
    goto/16 +189h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->Z$0 Z
    invoke-static/range v17, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v3, v17
    goto/16 +157h
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->Z$0 Z
    iget-object v9, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->L$0 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/conversation/skill/SkillRequestContext;
    invoke-static/range v17, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v10, v17
    goto +66h
    invoke-static/range v17, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v9, Lcom/bytedance/trae/conversation/skill/SkillRequestContext;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->getCliId()Ljava/lang/String;
    move-result-object v11
    iget-object v2, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->getWorkspaceFolder()Ljava/lang/String;
    move-result-object v12
    iget-object v2, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->getProjectId()Ljava/lang/String;
    move-result-object v13
    iget-object v2, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->getConfigName()Ljava/lang/String;
    move-result-object v14
    iget-object v2, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->getAgentType()Ljava/lang/String;
    move-result-object v15
    move-object v10, v9
    invoke-direct/range v10 ... v15, Lcom/bytedance/trae/conversation/skill/SkillRequestContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/skill/SkillRequestPolicy;->INSTANCE Lcom/bytedance/trae/conversation/skill/SkillRequestPolicy;
    invoke-virtual v2, v9, Lcom/bytedance/trae/conversation/skill/SkillRequestPolicy;->shouldUseHubApi(Lcom/bytedance/trae/conversation/skill/SkillRequestContext;)Z
    move-result v2
    if-eqz v2, +0f5h
    iget-object v10, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->getConversationId()Ljava/lang/String;
    move-result-object v10
    check-cast v10, Ljava/lang/CharSequence;
    if-eqz v10, +00bh
    invoke-interface v10, Ljava/lang/CharSequence;->length()I
    move-result v10
    if-nez v10, +003h
    goto +3h
    move v10, v6
    goto +2h
    move v10, v8
    if-nez v10, +0dfh
    sget-object v10, Lcom/bytedance/trae/im/service/ICreateTaskCheck;->Companion Lcom/bytedance/trae/im/service/ICreateTaskCheck$Companion;
    new-instance v11, Lcom/bytedance/trae/im/service/CreateTaskCheckRequest;
    iget-object v12, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->getConversationId()Ljava/lang/String;
    move-result-object v12
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v11, v12, Lcom/bytedance/trae/im/service/CreateTaskCheckRequest;-><init>(Ljava/lang/String;)V
    move-object v12, v0
    check-cast v12, Lkotlin/coroutines/Continuation;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->L$0 Ljava/lang/Object;
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->Z$0 Z
    iput v8, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->label I
    invoke-virtual v10, v11, v12, Lcom/bytedance/trae/im/service/ICreateTaskCheck$Companion;->createTaskCheckRawCall(Lcom/bytedance/trae/im/service/CreateTaskCheckRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v1, +003h
    return-object v1
    check-cast v10, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v11, v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v11, +090h
    check-cast v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v11
    const-wide/32 v13, 2900101
    cmp-long v11, v11, v13
    if-nez v11, +012h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->access$get_isDeviceOffline$p(Lcom/bytedance/trae/conversation/skill/SkillsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v1
    invoke-static v8, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v1, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    invoke-virtual v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v11
    const-wide/32 v13, 2900105
    cmp-long v11, v11, v13
    if-nez v11, +012h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->access$get_isDeviceProjectOffline$p(Lcom/bytedance/trae/conversation/skill/SkillsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v1
    invoke-static v8, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v1, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    invoke-virtual v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/im/service/CreateTaskCheckResponse;
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/bytedance/trae/im/service/CreateTaskCheckResponse;->getAvailable()Z
    move-result v11
    goto +2h
    move v11, v6
    if-nez v11, +012h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->access$get_isDeviceOffline$p(Lcom/bytedance/trae/conversation/skill/SkillsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v1
    invoke-static v8, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v1, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    invoke-virtual v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/im/service/CreateTaskCheckResponse;
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/bytedance/trae/im/service/CreateTaskCheckResponse;->getProjectId()Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v7
    if-eqz v11, +041h
    invoke-virtual v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v10
    invoke-virtual v10, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/im/service/CreateTaskCheckResponse;
    if-eqz v10, +007h
    invoke-virtual v10, Lcom/bytedance/trae/im/service/CreateTaskCheckResponse;->getProjectId()Ljava/lang/String;
    move-result-object v10
    goto +2h
    move-object v10, v7
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/skill/SkillRequestContext;->setProjectId(Ljava/lang/String;)V
    goto +2ah
    instance-of v1, v10, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v1, +021h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->access$get_error$p(Lcom/bytedance/trae/conversation/skill/SkillsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v1
    check-cast v10, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v10, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    move v6, v8
    if-eqz v6, +003h
    goto +2h
    move-object v5, v2
    invoke-virtual v1, v5, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    sget-object v10, Lcom/bytedance/trae/conversation/skill/SkillRequestPolicy;->INSTANCE Lcom/bytedance/trae/conversation/skill/SkillRequestPolicy;
    iget-object v11, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    invoke-static v11, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->access$getNextPageToken$p(Lcom/bytedance/trae/conversation/skill/SkillsViewModel;)Ljava/lang/String;
    move-result-object v11
    iget-boolean v12, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->$isLoadMore Z
    if-eqz v12, +003h
    goto +2h
    move-object v11, v7
    invoke-virtual v10, v9, v11, Lcom/bytedance/trae/conversation/skill/SkillRequestPolicy;->buildQuery(Lcom/bytedance/trae/conversation/skill/SkillRequestContext; Ljava/lang/String;)Ljava/util/Map;
    move-result-object v9
    if-eqz v2, +018h
    sget-object v3, Lcom/bytedance/trae/conversation/network/IGetSkillListApi;->Companion Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion;
    move-object v10, v0
    check-cast v10, Lkotlin/coroutines/Continuation;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->L$0 Ljava/lang/Object;
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->Z$0 Z
    iput v4, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->label I
    invoke-virtual v3, v9, v10, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion;->listSkillsFromHub(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v1, +003h
    return-object v1
    move v1, v2
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +21h
    sget-object v4, Lcom/bytedance/trae/conversation/network/IGetSkillListApi;->Companion Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion;
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v10
    new-instance v11, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1$result$1;
    invoke-direct v11, v9, v7, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1$result$1;-><init>(Ljava/util/Map; Lkotlin/coroutines/Continuation;)V
    check-cast v11, Lkotlin/jvm/functions/Function2;
    move-object v9, v0
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->L$0 Ljava/lang/Object;
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->Z$0 Z
    iput v3, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->label I
    invoke-virtual v4, v10, v11, v9, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion;->safeCall(Ljava/util/Map; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v1, +003h
    return-object v1
    move v1, v2
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v2, v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v2, +080h
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v3
    if-nez v3, +00eh
    if-eqz v1, +00dh
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v3
    const-wide/16 v9, 200
    cmp-long v1, v3, v9
    if-nez v1, +003h
    move v6, v8
    if-eqz v6, +053h
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/network/ListSkillsData;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/ListSkillsData;->getAllItems()Ljava/util/List;
    move-result-object v2
    goto +2h
    move-object v2, v7
    if-nez v2, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    iget-object v3, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/ListSkillsData;->getNextPageToken()Ljava/lang/String;
    move-result-object v7
    invoke-static v3, v7, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->access$setNextPageToken$p(Lcom/bytedance/trae/conversation/skill/SkillsViewModel; Ljava/lang/String;)V
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->$isLoadMore Z
    if-eqz v1, +026h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->access$get_skills$p(Lcom/bytedance/trae/conversation/skill/SkillsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v1
    iget-object v3, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->access$get_skills$p(Lcom/bytedance/trae/conversation/skill/SkillsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v3
    invoke-virtual v3, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/util/List;
    if-nez v3, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/util/Collection;
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v3, v2, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection; Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v2
    invoke-virtual v1, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    goto +5ch
    iget-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->access$get_skills$p(Lcom/bytedance/trae/conversation/skill/SkillsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v1
    invoke-virtual v1, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    goto +52h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->access$get_error$p(Lcom/bytedance/trae/conversation/skill/SkillsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v1
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto +2h
    move-object v5, v2
    invoke-virtual v1, v5, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    goto +40h
    instance-of v2, v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v2, +040h
    if-eqz v1, +01fh
    iget-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    move-object v2, v3
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getErrorBody()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->access$isDeviceOfflineError(Lcom/bytedance/trae/conversation/skill/SkillsViewModel; Ljava/lang/String;)Z
    move-result v1
    if-eqz v1, +010h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->access$get_isDeviceOffline$p(Lcom/bytedance/trae/conversation/skill/SkillsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v1
    invoke-static v8, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v1, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    goto +1dh
    iget-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->access$get_error$p(Lcom/bytedance/trae/conversation/skill/SkillsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v1
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    move v6, v8
    if-eqz v6, +003h
    goto +2h
    move-object v5, v2
    invoke-virtual v1, v5, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
.end method
