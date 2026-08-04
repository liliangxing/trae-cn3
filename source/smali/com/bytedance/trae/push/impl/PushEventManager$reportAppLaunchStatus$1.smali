# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/push/impl/PushEventManager$reportAppLaunchStatus$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "PushEventManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $context:Landroid/content/Context;
.field  label:I


.method constructor <init>(android.content.Context  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/push/impl/PushEventManager$reportAppLaunchStatus$1;->$context Landroid/content/Context;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/push/impl/PushEventManager$reportAppLaunchStatus$1;
    iget-object v0, v1, Lcom/bytedance/trae/push/impl/PushEventManager$reportAppLaunchStatus$1;->$context Landroid/content/Context;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/push/impl/PushEventManager$reportAppLaunchStatus$1;-><init>(Landroid/content/Context; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/push/impl/PushEventManager$reportAppLaunchStatus$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/push/impl/PushEventManager$reportAppLaunchStatus$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/push/impl/PushEventManager$reportAppLaunchStatus$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/push/impl/PushEventManager$reportAppLaunchStatus$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v3, Lcom/bytedance/trae/push/impl/PushEventManager$reportAppLaunchStatus$1;->label I
    if-nez v0, +090h
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lcom/bytedance/push/BDPush;->getPushService()Lcom/bytedance/push/interfaze/IPushService;
    move-result-object v4
    const/4 v0, 0
    if-eqz v4, +00ah
    invoke-interface v4, Lcom/bytedance/push/interfaze/IPushService;->isPushInit()Z
    move-result v4
    const/4 v1, 1
    if-ne v4, v1, +003h
    move v0, v1
    if-eqz v0, +079h
    invoke-static Lcom/bytedance/android/service/manager/PushServiceManager;->get()Lcom/bytedance/android/service/manager/PushServiceManager;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/android/service/manager/PushServiceManager;->getIRedBadgeExternalService()Lcom/bytedance/android/service/manager/redbadge/IRedBadgeExternalService;
    move-result-object v4
    invoke-interface v4, Lcom/bytedance/android/service/manager/redbadge/IRedBadgeExternalService;->isSupportGetCurRedBadgeNumber()Z
    move-result v4
    if-eqz v4, +06bh
    iget-object v4, v3, Lcom/bytedance/trae/push/impl/PushEventManager$reportAppLaunchStatus$1;->$context Landroid/content/Context;
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static Lcom/bytedance/android/service/manager/PushServiceManager;->get()Lcom/bytedance/android/service/manager/PushServiceManager;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/android/service/manager/PushServiceManager;->getIRedBadgeExternalService()Lcom/bytedance/android/service/manager/redbadge/IRedBadgeExternalService;
    move-result-object v0
    invoke-interface v0, v4, Lcom/bytedance/android/service/manager/redbadge/IRedBadgeExternalService;->getCurRedBadgeNumber(Landroid/content/Context;)I
    move-result v4
    invoke-static v4, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    goto +ch
    move-exception v4
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v0
    if-nez v0, +003h
    goto +20h
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "getCurRedBadgeNumber error = "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Throwable;->getLocalizedMessage()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "PushEventManager"
    invoke-virtual v4, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v4, -3
    invoke-static v4, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v4
    check-cast v4, Ljava/lang/Number;
    invoke-virtual v4, Ljava/lang/Number;->intValue()I
    move-result v4
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, red_botshow_cnt
    invoke-virtual v0, v1, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v4, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "app_launch_status"
    invoke-virtual v4, v1, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v4, Lcom/bytedance/trae/push/impl/PushEventManager;->INSTANCE Lcom/bytedance/trae/push/impl/PushEventManager;
    const-string v1, "launch_status"
    invoke-static v4, v1, v0, Lcom/bytedance/trae/push/impl/PushEventManager;->access$reportPushMonitorEvent(Lcom/bytedance/trae/push/impl/PushEventManager; Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
    :try_start_0x2b
.end method
