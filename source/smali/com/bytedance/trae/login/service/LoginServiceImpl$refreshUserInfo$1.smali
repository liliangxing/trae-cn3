# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "LoginServiceImpl.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $jwtToken:Ljava/lang/String;
.field final synthetic $onFail:Lkotlin/jvm/functions/Function0;
.field final synthetic $onSuccess:Lkotlin/jvm/functions/Function1;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/login/service/LoginServiceImpl;


.method constructor <init>(com.bytedance.trae.login.service.LoginServiceImpl  java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->this$0 Lcom/bytedance/trae/login/service/LoginServiceImpl;
    iput-object v2, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->$jwtToken Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->$onSuccess Lkotlin/jvm/functions/Function1;
    iput-object v4, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->$onFail Lkotlin/jvm/functions/Function0;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;
    iget-object v1, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->this$0 Lcom/bytedance/trae/login/service/LoginServiceImpl;
    iget-object v2, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->$jwtToken Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->$onSuccess Lkotlin/jvm/functions/Function1;
    iget-object v4, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->$onFail Lkotlin/jvm/functions/Function0;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;-><init>(Lcom/bytedance/trae/login/service/LoginServiceImpl; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->label I
    const/4 v2, 3
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v1, +014h
    if-eq v1, v4, +006h
    if-eq v1, v3, +004h
    if-ne v1, v2, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +5fh
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v7, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v7, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->isBytecloudLogin()Z
    move-result v7
    if-eqz v7, +016h
    iget-object v7, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->this$0 Lcom/bytedance/trae/login/service/LoginServiceImpl;
    iget-object v1, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->$jwtToken Ljava/lang/String;
    iget-object v2, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->$onSuccess Lkotlin/jvm/functions/Function1;
    iget-object v3, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->$onFail Lkotlin/jvm/functions/Function0;
    move-object v5, v6
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v4, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->label I
    invoke-static v7, v1, v2, v3, v5, Lcom/bytedance/trae/login/service/LoginServiceImpl;->access$refreshBytecloudUserInfo(Lcom/bytedance/trae/login/service/LoginServiceImpl; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +03ah
    return-object v0
    sget-object v7, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;
    invoke-virtual v7, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->isEnterpriseLogin()Z
    move-result v7
    if-eqz v7, +016h
    iget-object v7, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->this$0 Lcom/bytedance/trae/login/service/LoginServiceImpl;
    iget-object v1, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->$jwtToken Ljava/lang/String;
    iget-object v2, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->$onSuccess Lkotlin/jvm/functions/Function1;
    iget-object v4, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->$onFail Lkotlin/jvm/functions/Function0;
    move-object v5, v6
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v3, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->label I
    invoke-static v7, v1, v2, v4, v5, Lcom/bytedance/trae/login/service/LoginServiceImpl;->access$refreshEnterpriseUserInfo(Lcom/bytedance/trae/login/service/LoginServiceImpl; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +01eh
    return-object v0
    iget-object v7, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->this$0 Lcom/bytedance/trae/login/service/LoginServiceImpl;
    iget-object v1, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->$jwtToken Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->$onSuccess Lkotlin/jvm/functions/Function1;
    iget-object v4, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->$onFail Lkotlin/jvm/functions/Function0;
    move-object v5, v6
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v2, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->label I
    invoke-static v7, v1, v3, v4, v5, Lcom/bytedance/trae/login/service/LoginServiceImpl;->access$refreshPublicUserInfo(Lcom/bytedance/trae/login/service/LoginServiceImpl; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +00ah
    return-object v0
    iget-object v7, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$refreshUserInfo$1;->$onFail Lkotlin/jvm/functions/Function0;
    if-eqz v7, +005h
    invoke-interface v7, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    :try_start_0x11
    :try_start_0x20
.end method
