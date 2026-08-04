# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;
.super Ljava/lang/Object;
.source "DeviceOverLimitDialogManager.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;
.field private static final TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$0YNw2TdJUeeSo0NOCn70P8Doj2U(com.bytedance.trae.login.DeviceOverLimitDialog$Callback  boolean)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;->showDialog$lambda$2(Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback; Z)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;
    invoke-direct v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$awaitResumedActivity(com.bytedance.trae.login.traeauth.DeviceOverLimitDialogManager  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;->awaitResumedActivity(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getValidResumedActivity(com.bytedance.trae.login.traeauth.DeviceOverLimitDialogManager)android.app.Activity
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;->getValidResumedActivity()Landroid/app/Activity;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$showDialog(com.bytedance.trae.login.traeauth.DeviceOverLimitDialogManager  android.app.Activity  com.bytedance.trae.login.traeauth.ListDevicesResult  com.bytedance.trae.login.DeviceOverLimitDialog$Scene  com.bytedance.trae.login.DeviceOverLimitDialog$Callback)void
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;->showDialog(Landroid/app/Activity; Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;)V
    return-void 
.end method

.method private final awaitResumedActivity(kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=2
    instance-of v0, v7, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$1;
    iget v1, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$1;
    invoke-direct v0, v6, v7, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$1;-><init>(Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v2, +017h
    if-eq v2, v4, +011h
    if-ne v2, v3, +007h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +096h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1bh
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v7
    check-cast v7, Lkotlin/coroutines/CoroutineContext;
    new-instance v2, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$current$1;
    const/4 v5, 0
    invoke-direct v2, v5, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$current$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/jvm/functions/Function2;
    iput v4, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$1;->label I
    invoke-static v7, v2, v0, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    check-cast v7, Landroid/app/Activity;
    if-eqz v7, +003h
    return-object v7
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "TraeAuthManager"
    const-string v5, "No resumed activity, waiting for next resume..."
    invoke-virtual v7, v2, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iput v3, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$1;->label I
    check-cast v0, Lkotlin/coroutines/Continuation;
    new-instance v7, Lkotlinx/coroutines/CancellableContinuationImpl;
    invoke-static v0, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->intercepted(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v2
    invoke-direct v7, v2, v4, Lkotlinx/coroutines/CancellableContinuationImpl;-><init>(Lkotlin/coroutines/Continuation; I)V
    invoke-virtual v7, Lkotlinx/coroutines/CancellableContinuationImpl;->initCancellability()V
    move-object v2, v7
    check-cast v2, Lkotlinx/coroutines/CancellableContinuation;
    new-instance v3, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$2$lifecycleCallback$1;
    invoke-direct v3, v2, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$2$lifecycleCallback$1;-><init>(Lkotlinx/coroutines/CancellableContinuation;)V
    sget-object v4, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v4
    move-object v5, v3
    check-cast v5, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks;
    invoke-interface v4, v5, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->addActivityLifecycleCallback(Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks;)V
    new-instance v4, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$2$1;
    invoke-direct v4, v3, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$2$1;-><init>(Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$2$lifecycleCallback$1;)V
    check-cast v4, Lkotlin/jvm/functions/Function1;
    invoke-interface v2, v4, Lkotlinx/coroutines/CancellableContinuation;->invokeOnCancellation(Lkotlin/jvm/functions/Function1;)V
    sget-object v3, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;
    invoke-static v3, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;->access$getValidResumedActivity(Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;)Landroid/app/Activity;
    move-result-object v3
    if-eqz v3, +01ch
    sget-object v4, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v4
    invoke-interface v4, v5, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->removeActivityLifecycleCallback(Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks;)V
    invoke-interface v2, Lkotlinx/coroutines/CancellableContinuation;->isActive()Z
    move-result v4
    if-eqz v4, +00dh
    check-cast v2, Lkotlin/coroutines/Continuation;
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-interface v2, v3, Lkotlin/coroutines/Continuation;->resumeWith(Ljava/lang/Object;)V
    invoke-virtual v7, Lkotlinx/coroutines/CancellableContinuationImpl;->getResult()Ljava/lang/Object;
    move-result-object v7
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    if-ne v7, v2, +005h
    invoke-static v0, Lkotlin/coroutines/jvm/internal/DebugProbesKt;->probeCoroutineSuspended(Lkotlin/coroutines/Continuation;)V
    if-ne v7, v1, +003h
    return-object v1
    return-object v7
.end method

.method private final getValidResumedActivity()android.app.Activity
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getResumActivity()Landroid/app/Activity;
    move-result-object v0
    if-nez v0, +00ch
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getCurrentActivity()Landroid/app/Activity;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +014h
    invoke-virtual v0, Landroid/app/Activity;->isFinishing()Z
    move-result v2
    if-nez v2, +00ah
    invoke-virtual v0, Landroid/app/Activity;->isDestroyed()Z
    move-result v2
    if-nez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    return-object v0
.end method

.method private final showDialog(android.app.Activity  com.bytedance.trae.login.traeauth.ListDevicesResult  com.bytedance.trae.login.DeviceOverLimitDialog$Scene  com.bytedance.trae.login.DeviceOverLimitDialog$Callback)void
    .registers 7
    # ins_size=5
    invoke-virtual v3, Landroid/app/Activity;->isFinishing()Z
    move-result v0
    if-nez v0, +014h
    invoke-virtual v3, Landroid/app/Activity;->isDestroyed()Z
    move-result v0
    if-eqz v0, +003h
    goto +ch
    sget-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->INSTANCE Lcom/bytedance/trae/login/DeviceOverLimitDialog;
    new-instance v1, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$$ExternalSyntheticLambda0;
    invoke-direct v1, v6, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;)V
    invoke-virtual v0, v3, v4, v5, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->show(Landroid/app/Activity; Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;)V
    return-void 
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v4, "TraeAuthManager"
    const-string v5, "Activity invalid when showing dialog, skip"
    invoke-virtual v3, v4, v5, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private static final showDialog$lambda$2(com.bytedance.trae.login.DeviceOverLimitDialog$Callback  boolean)void
    .registers 2
    # ins_size=2
    invoke-interface v0, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;->onResult(Z)V
    return-void 
.end method

.method public static final showWhenReadyAsync(com.bytedance.trae.login.traeauth.ListDevicesResult  com.bytedance.trae.login.DeviceOverLimitDialog$Scene  com.bytedance.trae.login.DeviceOverLimitDialog$Callback)void
    .registers 10
    # ins_size=3
    const-string v0, "listResult"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, scene
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "callback"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReadyAsync$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v9, v4, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReadyAsync$1;-><init>(Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final showWhenReady(com.bytedance.trae.login.traeauth.ListDevicesResult  com.bytedance.trae.login.DeviceOverLimitDialog$Scene  com.bytedance.trae.login.DeviceOverLimitDialog$Callback  kotlin.coroutines.Continuation)java.lang.Object
    .registers 15
    # ins_size=5
    instance-of v0, v14, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$1;
    if-eqz v0, +012h
    move-object v0, v14
    check-cast v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$1;
    iget v1, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v14, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$1;->label I
    sub-int/2addr v14, v2
    iput v14, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$1;
    invoke-direct v0, v10, v14, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$1;-><init>(Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager; Lkotlin/coroutines/Continuation;)V
    iget-object v14, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v2, +024h
    if-eq v2, v4, +010h
    if-ne v2, v3, +006h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +67h
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v12, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v12, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    iget-object v11, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$1;->L$2 Ljava/lang/Object;
    move-object v13, v11
    check-cast v13, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;
    iget-object v11, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$1;->L$1 Ljava/lang/Object;
    move-object v12, v11
    check-cast v12, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    iget-object v11, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$1;->L$0 Ljava/lang/Object;
    check-cast v11, Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +13h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput-object v11, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$1;->L$0 Ljava/lang/Object;
    iput-object v12, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$1;->L$1 Ljava/lang/Object;
    iput-object v13, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$1;->L$2 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$1;->label I
    invoke-direct v10, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager;->awaitResumedActivity(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v1, +003h
    return-object v1
    move-object v6, v11
    move-object v7, v12
    move-object v8, v13
    move-object v5, v14
    check-cast v5, Landroid/app/Activity;
    new-instance v11, Ljava/lang/StringBuilder;
    const-string/jumbo v12, showWhenReady:
    invoke-direct v11, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    const-string v12, "TraeAuthManager"
    invoke-static v12, v11, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v11
    check-cast v11, Lkotlin/coroutines/CoroutineContext;
    new-instance v12, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;
    const/4 v9, 0
    move-object v4, v12
    invoke-direct/range v4 ... v9, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$2;-><init>(Landroid/app/Activity; Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback; Lkotlin/coroutines/Continuation;)V
    check-cast v12, Lkotlin/jvm/functions/Function2;
    const/4 v13, 0
    iput-object v13, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$1;->L$0 Ljava/lang/Object;
    iput-object v13, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$1;->L$1 Ljava/lang/Object;
    iput-object v13, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$1;->L$2 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$showWhenReady$1;->label I
    invoke-static v11, v12, v0, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
.end method
