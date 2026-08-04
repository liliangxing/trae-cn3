# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DeviceOverLimitDialog.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $activity:Landroid/app/Activity;
.field final synthetic $adapter:Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
.field final synthetic $binding:Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;
.field final synthetic $deviceId:Ljava/lang/String;
.field final synthetic $maxDeviceCount:I
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I


.method constructor <init>(java.lang.String  com.bytedance.trae.login.DeviceOverLimitDeviceAdapter  int  com.bytedance.trae.login.databinding.TraeDialogDeviceOverLimitBinding  android.app.Activity  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->$deviceId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->$adapter Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
    iput v3, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->$maxDeviceCount I
    iput-object v4, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->$binding Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;
    iput-object v5, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->$activity Landroid/app/Activity;
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 11
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;
    iget-object v1, v8, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->$deviceId Ljava/lang/String;
    iget-object v2, v8, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->$adapter Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
    iget v3, v8, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->$maxDeviceCount I
    iget-object v4, v8, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->$binding Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;
    iget-object v5, v8, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->$activity Landroid/app/Activity;
    move-object v0, v7
    move-object v6, v10
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter; I Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding; Landroid/app/Activity; Lkotlin/coroutines/Continuation;)V
    iput-object v9, v7, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->L$0 Ljava/lang/Object;
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 19
    # ins_size=2
    move-object/from16 v1, v17
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v0, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->label I
    const-string v3, "device_delete_result"
    const-string/jumbo v4, result
    const-string v5, "DeviceOverLimitDialog"
    const/4 v6, 3
    const/4 v7, 2
    const/4 v8, 1
    if-eqz v0, +022h
    if-eq v0, v8, +01ah
    if-eq v0, v7, +011h
    if-ne v0, v6, +007h
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +10ch
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v0, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->L$0 Ljava/lang/Object;
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0a9h
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v18
    goto +17h
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlinx/coroutines/CoroutineScope;
    iget-object v0, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->$deviceId Ljava/lang/String;
    sget-object v9, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    sget-object v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    iput v8, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->label I
    invoke-virtual v9, v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->clearRefreshToken(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    check-cast v0, Lcom/bytedance/trae/login/traeauth/ClearRefreshTokenResult;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v9, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    iget-object v10, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->$adapter Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
    iget-object v11, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->$deviceId Ljava/lang/String;
    iget v12, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->$maxDeviceCount I
    iget-object v13, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->$binding Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;
    iget-object v14, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->$activity Landroid/app/Activity;
    invoke-static v0, Lkotlin/Result;->isSuccess-impl(Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +06bh
    move-object v9, v0
    check-cast v9, Lcom/bytedance/trae/login/traeauth/ClearRefreshTokenResult;
    new-instance v15, Lorg/json/JSONObject;
    invoke-direct v15, Lorg/json/JSONObject;-><init>()V
    const/4 v6, 0
    invoke-virtual v15, v4, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v6, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v6, v3, v15, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v15, Ljava/lang/StringBuilder;
    const-string v8, "clearRefreshToken success, success="
    invoke-direct v15, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/login/traeauth/ClearRefreshTokenResult;->getSuccess()Ljava/lang/Boolean;
    move-result-object v8
    invoke-virtual v15, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v15, ", deviceId="
    invoke-virtual v8, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v9, Lcom/bytedance/trae/login/traeauth/ClearRefreshTokenResult;->getDeviceId()Ljava/lang/String;
    move-result-object v15
    const-string v16, ""
    if-nez v15, +004h
    move-object/from16 v15, v16
    invoke-virtual v8, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v15, ", status="
    invoke-virtual v8, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v9, Lcom/bytedance/trae/login/traeauth/ClearRefreshTokenResult;->getDeviceStatus()Ljava/lang/String;
    move-result-object v9
    if-nez v9, +004h
    move-object/from16 v9, v16
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v6, v5, v8, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v6
    check-cast v6, Lkotlin/coroutines/CoroutineContext;
    new-instance v8, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;
    const/4 v15, 0
    move-object v9, v8
    invoke-direct/range v9 ... v15, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;-><init>(Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter; Ljava/lang/String; I Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding; Landroid/app/Activity; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/jvm/functions/Function2;
    iput-object v0, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->L$0 Ljava/lang/Object;
    iput v7, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->label I
    invoke-static v6, v8, v1, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v2, +003h
    return-object v2
    iget-object v6, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->$deviceId Ljava/lang/String;
    iget-object v7, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->$activity Landroid/app/Activity;
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v8
    if-eqz v8, +04ch
    sget-object v9, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v10, Ljava/lang/StringBuilder;
    const-string v11, "clearRefreshToken failed, deviceId="
    invoke-direct v10, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v10, ", error="
    invoke-virtual v6, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v8, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v6, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v9, v5, v6, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v5, Lorg/json/JSONObject;
    invoke-direct v5, Lorg/json/JSONObject;-><init>()V
    const/4 v6, 1
    invoke-virtual v5, v4, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v4, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v4, v3, v5, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v3
    check-cast v3, Lkotlin/coroutines/CoroutineContext;
    new-instance v4, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$3$1;
    const/4 v5, 0
    invoke-direct v4, v7, v5, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$3$1;-><init>(Landroid/app/Activity; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    iput-object v0, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->L$0 Ljava/lang/Object;
    const/4 v5, 3
    iput v5, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;->label I
    invoke-static v3, v4, v1, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0x2e
    :try_start_0x3d
    :try_start_0x6f
    :try_start_0x101
.end method
