# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/init/task/BytecloudTokenValidator$doValidate$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BytecloudTokenValidator.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I


.method constructor <init>(kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=2
    const/4 v0, 2
    invoke-direct v1, v0, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 3
    # ins_size=3
    new-instance v1, Lcom/bytedance/trae/init/task/BytecloudTokenValidator$doValidate$1;
    invoke-direct v1, v2, Lcom/bytedance/trae/init/task/BytecloudTokenValidator$doValidate$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/coroutines/Continuation;
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/init/task/BytecloudTokenValidator$doValidate$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/init/task/BytecloudTokenValidator$doValidate$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/init/task/BytecloudTokenValidator$doValidate$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/init/task/BytecloudTokenValidator$doValidate$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 13
    # ins_size=2
    const-string v0, "doValidate: exception (ignored): "
    const-string v1, "doValidate: http error status="
    const-string v2, "doValidate: server error code="
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v11, Lcom/bytedance/trae/init/task/BytecloudTokenValidator$doValidate$1;->label I
    const/4 v5, 0
    const/4 v6, 1
    const/16 v7, 401
    const-string v8, "BytecloudTokenValidator"
    const/4 v9, 0
    if-eqz v4, +01ah
    if-ne v4, v6, +010h
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2dh
    move-exception v12
    goto/16 +0dbh
    move-exception v12
    goto +41h
    move-exception v12
    goto +70h
    move-exception v12
    goto/16 +090h
    new-instance v12, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v12, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v12
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v12, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v4, "doValidate: calling GetThirdPartyToken(bytecloud)"
    invoke-virtual v12, v8, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v12, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;
    const-string v4, "bytecloud"
    move-object v10, v11
    check-cast v10, Lkotlin/coroutines/Continuation;
    iput v6, v11, Lcom/bytedance/trae/init/task/BytecloudTokenValidator$doValidate$1;->label I
    invoke-virtual v12, v4, v10, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenRepository;->getThirdPartyToken(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v3, +003h
    return-object v3
    sget-object v12, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "doValidate: success, bytecloud token valid"
    invoke-virtual v12, v8, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v12, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->INSTANCE Lcom/bytedance/trae/init/task/BytecloudTokenValidator;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    invoke-static v12, v3, v4, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->access$saveLastCheckAt(Lcom/bytedance/trae/init/task/BytecloudTokenValidator; J)V
    invoke-static Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->access$getValidating$p()Ljava/util/concurrent/atomic/AtomicBoolean;
    move-result-object v12
    invoke-virtual v12, v9, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    goto/16 +096h
    sget-object v1, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->INSTANCE Lcom/bytedance/trae/init/task/BytecloudTokenValidator;
    move-object v2, v12
    check-cast v2, Ljava/lang/Throwable;
    invoke-static v1, v2, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->access$extractHttpStatusCode(Lcom/bytedance/trae/init/task/BytecloudTokenValidator; Ljava/lang/Throwable;)I
    move-result v1
    if-ne v1, v7, +011h
    sget-object v12, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->INSTANCE Lcom/bytedance/trae/init/task/BytecloudTokenValidator;
    invoke-static v12, v5, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->access$handleUnauthorizedSession(Lcom/bytedance/trae/init/task/BytecloudTokenValidator; Ljava/lang/String;)V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->access$getValidating$p()Ljava/util/concurrent/atomic/AtomicBoolean;
    move-result-object v0
    invoke-virtual v0, v9, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    return-object v12
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v2, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v1, v8, v12, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    goto -39h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$HttpError;->getStatusCode()I
    move-result v1
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v8, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$HttpError;->getStatusCode()I
    move-result v12
    if-ne v12, v7, -054h
    sget-object v12, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->INSTANCE Lcom/bytedance/trae/init/task/BytecloudTokenValidator;
    invoke-static v12, v5, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->access$handleUnauthorizedSession(Lcom/bytedance/trae/init/task/BytecloudTokenValidator; Ljava/lang/String;)V
    goto -5bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$ServerError;->getCode()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", msg="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v12, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$ServerError;->getServerMessage()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v8, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$ServerError;->getCode()Ljava/lang/String;
    move-result-object v0
    const-string v1, "20330"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +008h
    invoke-virtual v12, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$ServerError;->getStatusCode()I
    move-result v0
    if-ne v0, v7, -090h
    sget-object v0, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->INSTANCE Lcom/bytedance/trae/init/task/BytecloudTokenValidator;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$ServerError;->getServerMessage()Ljava/lang/String;
    move-result-object v12
    invoke-static v0, v12, Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->access$handleUnauthorizedSession(Lcom/bytedance/trae/init/task/BytecloudTokenValidator; Ljava/lang/String;)V
    goto/16 -09bh
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
    invoke-static Lcom/bytedance/trae/init/task/BytecloudTokenValidator;->access$getValidating$p()Ljava/util/concurrent/atomic/AtomicBoolean;
    move-result-object v0
    invoke-virtual v0, v9, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    throw v12
    :try_start_0x17
    :try_start_0x30
    :try_start_0x60
    :try_start_0x7a
.end method
