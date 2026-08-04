# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DirectoryViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $action:Ljava/lang/String;
.field final synthetic $id:Ljava/lang/String;
.field final synthetic $onSuccess:Lkotlin/jvm/functions/Function0;
.field final synthetic $path:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;


.method constructor <init>(java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.devices.DirectoryViewModel  kotlin.jvm.functions.Function0  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->$id Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->$path Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->$action Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->$onSuccess Lkotlin/jvm/functions/Function0;
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->$id Ljava/lang/String;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->$path Ljava/lang/String;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->$action Ljava/lang/String;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->$onSuccess Lkotlin/jvm/functions/Function0;
    move-object v0, v8
    move-object v6, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->label I
    const/4 v2, 3
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v1, +01ah
    if-eq v1, v4, +014h
    if-eq v1, v3, +00dh
    if-ne v1, v2, +003h
    goto +9h
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +09ah
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +27h
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v9, Lcom/bytedance/trae/conversation/network/AuthorizationResultRequest;
    iget-object v1, v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->$id Ljava/lang/String;
    iget-object v5, v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->$path Ljava/lang/String;
    iget-object v6, v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->$action Ljava/lang/String;
    iget-object v7, v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->getChatMode()Lcom/bytedance/trae/im/service/Mode;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v7
    invoke-direct v9, v1, v5, v6, v7, Lcom/bytedance/trae/conversation/network/AuthorizationResultRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/network/IGetProjectApi;->Companion Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;
    move-object v5, v8
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v4, v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->label I
    invoke-virtual v1, v9, v5, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->authorizationResultRawCall(Lcom/bytedance/trae/conversation/network/AuthorizationResultRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v0, +003h
    return-object v0
    check-cast v9, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v1, v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v1, +03dh
    check-cast v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v9
    invoke-virtual v9, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v1
    if-eqz v1, +00ah
    iget-object v9, v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->$onSuccess Lkotlin/jvm/functions/Function0;
    if-eqz v9, +05ah
    invoke-interface v9, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    goto +55h
    iget-object v1, v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_events$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$ShowToast;
    iget-object v4, v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-virtual v9, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v5
    invoke-virtual v9, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v9
    sget v7, Lcom/bytedance/trae/multilanguage/R$string;->trae_dir_submit_auth_failed I
    invoke-static v4, v5, v6, v9, v7, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$errorMessage(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; J Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v9
    invoke-direct v2, v9, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$ShowToast;-><init>(Ljava/lang/String;)V
    move-object v9, v8
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput v3, v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->label I
    invoke-interface v1, v2, v9, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v0, +030h
    return-object v0
    instance-of v1, v9, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v1, +02eh
    iget-object v1, v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_events$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v1
    new-instance v3, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$ShowToast;
    iget-object v4, v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    check-cast v9, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v9, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v5
    invoke-virtual v9, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v9
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_dir_submit_auth_failed I
    invoke-static v4, v5, v9, v6, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$errorMessage(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; I Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v9
    invoke-direct v3, v9, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$ShowToast;-><init>(Ljava/lang/String;)V
    move-object v9, v8
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput v2, v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;->label I
    invoke-interface v1, v3, v9, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v0, +003h
    return-object v0
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
    new-instance v9, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v9, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v9
.end method
