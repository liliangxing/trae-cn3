# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "LoginServiceImpl.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $onFail:Lkotlin/jvm/functions/Function1;
.field final synthetic $onSuccess:Lkotlin/jvm/functions/Function0;
.field final synthetic $params:Ljava/util/Map;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/login/service/LoginServiceImpl;


.method constructor <init>(java.util.Map  com.bytedance.trae.login.service.LoginServiceImpl  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;->$params Ljava/util/Map;
    iput-object v2, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;->this$0 Lcom/bytedance/trae/login/service/LoginServiceImpl;
    iput-object v3, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;->$onSuccess Lkotlin/jvm/functions/Function0;
    iput-object v4, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;->$onFail Lkotlin/jvm/functions/Function1;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;
    iget-object v1, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;->$params Ljava/util/Map;
    iget-object v2, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;->this$0 Lcom/bytedance/trae/login/service/LoginServiceImpl;
    iget-object v3, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;->$onSuccess Lkotlin/jvm/functions/Function0;
    iget-object v4, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;->$onFail Lkotlin/jvm/functions/Function1;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;-><init>(Ljava/util/Map; Lcom/bytedance/trae/login/service/LoginServiceImpl; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;->label I
    const/4 v2, -1
    const/4 v3, 1
    if-eqz v1, +012h
    if-ne v1, v3, +008h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1eh
    move-exception v6
    goto +3bh
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v6, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;
    iget-object v1, v5, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;->$params Ljava/util/Map;
    move-object v4, v5
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v3, v5, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;->label I
    invoke-virtual v6, v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->updateUserProfile(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    check-cast v6, Ljava/lang/Boolean;
    invoke-virtual v6, Ljava/lang/Boolean;->booleanValue()Z
    move-result v6
    if-eqz v6, +00fh
    iget-object v6, v5, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;->this$0 Lcom/bytedance/trae/login/service/LoginServiceImpl;
    iget-object v0, v5, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;->$params Ljava/util/Map;
    invoke-static v6, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl;->access$syncLocalUserInfo(Lcom/bytedance/trae/login/service/LoginServiceImpl; Ljava/util/Map;)V
    iget-object v6, v5, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;->$onSuccess Lkotlin/jvm/functions/Function0;
    invoke-interface v6, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    goto +2fh
    iget-object v6, v5, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;->$onFail Lkotlin/jvm/functions/Function1;
    invoke-static v2, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-interface v6, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +25h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v3, updateUserProfileEnterprise exception: 
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    const-string v1, "LoginServiceImpl"
    invoke-virtual v0, v1, v6, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v6, v5, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileEnterprise$1;->$onFail Lkotlin/jvm/functions/Function1;
    invoke-static v2, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-interface v6, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    :try_start_0xc
    :try_start_0x1d
.end method
