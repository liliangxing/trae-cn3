# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "LoginServiceImpl.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $onFail:Lkotlin/jvm/functions/Function1;
.field final synthetic $onSuccess:Lkotlin/jvm/functions/Function1;
.field final synthetic $path:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/login/service/LoginServiceImpl;


.method constructor <init>(java.lang.String  kotlin.jvm.functions.Function1  com.bytedance.trae.login.service.LoginServiceImpl  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;->$path Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;->$onFail Lkotlin/jvm/functions/Function1;
    iput-object v3, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;->this$0 Lcom/bytedance/trae/login/service/LoginServiceImpl;
    iput-object v4, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;->$onSuccess Lkotlin/jvm/functions/Function1;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;
    iget-object v1, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;->$path Ljava/lang/String;
    iget-object v2, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;->$onFail Lkotlin/jvm/functions/Function1;
    iget-object v3, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;->this$0 Lcom/bytedance/trae/login/service/LoginServiceImpl;
    iget-object v4, v6, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;->$onSuccess Lkotlin/jvm/functions/Function1;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;-><init>(Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/login/service/LoginServiceImpl; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    const-string/jumbo v0, uploadAvatarOversea failed: errorCode=
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v9, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;->label I
    const-string v3, "LoginServiceImpl"
    const-wide/16 v4, -1
    const/4 v6, 1
    if-eqz v2, +013h
    if-ne v2, v6, +009h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +41h
    move-exception v10
    goto/16 +0cch
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v10, Ljava/io/File;
    iget-object v2, v9, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;->$path Ljava/lang/String;
    invoke-direct v10, v2, Ljava/io/File;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Ljava/io/File;->exists()Z
    move-result v2
    if-nez v2, +00eh
    iget-object v10, v9, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;->$onFail Lkotlin/jvm/functions/Function1;
    invoke-static v4, v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v0
    invoke-interface v10, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
    new-instance v2, Lcom/bytedance/retrofit2/mime/TypedFile;
    const-string v7, "image/jpeg"
    invoke-direct v2, v7, v10, Lcom/bytedance/retrofit2/mime/TypedFile;-><init>(Ljava/lang/String; Ljava/io/File;)V
    sget-object v10, Lcom/bytedance/trae/login/service/IOverseaProfileApi;->Companion Lcom/bytedance/trae/login/service/IOverseaProfileApi$Companion;
    invoke-virtual v10, Lcom/bytedance/trae/login/service/IOverseaProfileApi$Companion;->create()Lcom/bytedance/trae/login/service/IOverseaProfileApi;
    move-result-object v10
    move-object v7, v9
    check-cast v7, Lkotlin/coroutines/Continuation;
    iput v6, v9, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;->label I
    invoke-interface v10, v2, v7, Lcom/bytedance/trae/login/service/IOverseaProfileApi;->uploadAvatar(Lcom/bytedance/retrofit2/mime/TypedFile; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v1, +003h
    return-object v1
    check-cast v10, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;
    invoke-virtual v10, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->getData()Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;->getWebUri()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v2
    invoke-virtual v10, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->getMessage()Ljava/lang/String;
    move-result-object v7
    const-string/jumbo v8, success
    invoke-static v7, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +026h
    move-object v7, v1
    check-cast v7, Ljava/lang/CharSequence;
    if-eqz v7, +00ah
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-nez v7, +003h
    goto +2h
    const/4 v6, 0
    if-nez v6, +017h
    iget-object v10, v9, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;->this$0 Lcom/bytedance/trae/login/service/LoginServiceImpl;
    const-string v0, "avatar"
    invoke-static v0, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    invoke-static v10, v0, Lcom/bytedance/trae/login/service/LoginServiceImpl;->access$syncLocalUserInfo(Lcom/bytedance/trae/login/service/LoginServiceImpl; Ljava/util/Map;)V
    iget-object v10, v9, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;->$onSuccess Lkotlin/jvm/functions/Function1;
    invoke-interface v10, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +70h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->getData()Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;
    move-result-object v0
    if-eqz v0, +00bh
    invoke-virtual v0, Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;->getErrorCode()I
    move-result v0
    invoke-static v0, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v0
    goto +2h
    move-object v0, v2
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v6, ", desc="
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v10, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->getData()Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;
    move-result-object v6
    if-eqz v6, +006h
    invoke-virtual v6, Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;->getDescription()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v9, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;->$onFail Lkotlin/jvm/functions/Function1;
    invoke-virtual v10, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->getData()Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;
    move-result-object v10
    if-eqz v10, +008h
    invoke-virtual v10, Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;->getErrorCode()I
    move-result v10
    int-to-long v1, v10
    goto +2h
    move-wide v1, v4
    invoke-static v1, v2, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v10
    invoke-interface v0, v10, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +23h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, uploadAvatarOversea exception: 
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v1, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v0, v3, v10, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v10, v9, Lcom/bytedance/trae/login/service/LoginServiceImpl$uploadAvatarOversea$1;->$onFail Lkotlin/jvm/functions/Function1;
    invoke-static v4, v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v0
    invoke-interface v10, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
    :try_start_0x12
    :try_start_0x24
.end method
