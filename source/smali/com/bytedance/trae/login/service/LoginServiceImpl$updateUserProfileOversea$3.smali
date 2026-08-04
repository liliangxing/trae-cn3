# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "LoginServiceImpl.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $apiParams:Ljava/util/Map;
.field final synthetic $onFail:Lkotlin/jvm/functions/Function1;
.field final synthetic $onSuccess:Lkotlin/jvm/functions/Function0;
.field final synthetic $params:Ljava/util/Map;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/login/service/LoginServiceImpl;


.method constructor <init>(java.util.Map  com.bytedance.trae.login.service.LoginServiceImpl  java.util.Map  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;->$apiParams Ljava/util/Map;
    iput-object v2, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;->this$0 Lcom/bytedance/trae/login/service/LoginServiceImpl;
    iput-object v3, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;->$params Ljava/util/Map;
    iput-object v4, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;->$onSuccess Lkotlin/jvm/functions/Function0;
    iput-object v5, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;->$onFail Lkotlin/jvm/functions/Function1;
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;
    iget-object v1, v7, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;->$apiParams Ljava/util/Map;
    iget-object v2, v7, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;->this$0 Lcom/bytedance/trae/login/service/LoginServiceImpl;
    iget-object v3, v7, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;->$params Ljava/util/Map;
    iget-object v4, v7, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;->$onSuccess Lkotlin/jvm/functions/Function0;
    iget-object v5, v7, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;->$onFail Lkotlin/jvm/functions/Function1;
    move-object v0, v8
    move-object v6, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;-><init>(Ljava/util/Map; Lcom/bytedance/trae/login/service/LoginServiceImpl; Ljava/util/Map; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v4, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;->label I
    const/4 v2, 1
    if-eqz v1, +012h
    if-ne v1, v2, +008h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +22h
    move-exception v5
    goto +43h
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v5, Lcom/bytedance/trae/login/service/IOverseaProfileApi;->Companion Lcom/bytedance/trae/login/service/IOverseaProfileApi$Companion;
    invoke-virtual v5, Lcom/bytedance/trae/login/service/IOverseaProfileApi$Companion;->create()Lcom/bytedance/trae/login/service/IOverseaProfileApi;
    move-result-object v5
    iget-object v1, v4, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;->$apiParams Ljava/util/Map;
    move-object v3, v4
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v4, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;->label I
    invoke-interface v5, v1, v3, Lcom/bytedance/trae/login/service/IOverseaProfileApi;->updateUserInfo(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v0, +003h
    return-object v0
    check-cast v5, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;
    invoke-virtual v5, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->getErrorCode()I
    move-result v0
    if-nez v0, +00fh
    iget-object v5, v4, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;->this$0 Lcom/bytedance/trae/login/service/LoginServiceImpl;
    iget-object v0, v4, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;->$params Ljava/util/Map;
    invoke-static v5, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl;->access$syncLocalUserInfo(Lcom/bytedance/trae/login/service/LoginServiceImpl; Ljava/util/Map;)V
    iget-object v5, v4, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;->$onSuccess Lkotlin/jvm/functions/Function0;
    invoke-interface v5, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    goto +34h
    iget-object v0, v4, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;->$onFail Lkotlin/jvm/functions/Function1;
    invoke-virtual v5, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->getErrorCode()I
    move-result v5
    invoke-static v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v5
    invoke-interface v0, v5, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +26h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, updateUserProfileOversea exception: 
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v1, "LoginServiceImpl"
    invoke-virtual v0, v1, v5, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v5, v4, Lcom/bytedance/trae/login/service/LoginServiceImpl$updateUserProfileOversea$3;->$onFail Lkotlin/jvm/functions/Function1;
    const/4 v0, -1
    invoke-static v0, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-interface v5, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
    :try_start_0xb
    :try_start_0x1c
.end method
