# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TraeAuthDeviceManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $callback:Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$TraeAuthDeviceCallback;
.field final synthetic $listResult:Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
.field  label:I


.method public static synthetic $r8$lambda$R9jJryZpXGHVmAmkWtjKFxHCuos(com.bytedance.trae.login.traeauth.TraeAuthDeviceManager$TraeAuthDeviceCallback  android.app.Activity  boolean)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1;->invokeSuspend$lambda$0(Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$TraeAuthDeviceCallback; Landroid/app/Activity; Z)V
    return-void 
.end method

.method constructor <init>(com.bytedance.trae.login.traeauth.ListDevicesResult  com.bytedance.trae.login.traeauth.TraeAuthDeviceManager$TraeAuthDeviceCallback  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1;->$listResult Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    iput-object v2, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$TraeAuthDeviceCallback;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$0(com.bytedance.trae.login.traeauth.TraeAuthDeviceManager$TraeAuthDeviceCallback  android.app.Activity  boolean)void
    .registers 3
    # ins_size=3
    if-eqz v2, +006h
    invoke-interface v0, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$TraeAuthDeviceCallback;->unBind()V
    goto +6h
    sget-object v0, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->INSTANCE Lcom/bytedance/trae/login/api/ForceLogoutUtils;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/api/ForceLogoutUtils;->performForceLogout(Landroid/app/Activity;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1;
    iget-object v0, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1;->$listResult Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$TraeAuthDeviceCallback;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1;-><init>(Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$TraeAuthDeviceCallback; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1;->label I
    if-nez v0, +030h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v6
    invoke-interface v6, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getCurrentActivity()Landroid/app/Activity;
    move-result-object v6
    if-eqz v6, +01eh
    invoke-virtual v6, Landroid/app/Activity;->isFinishing()Z
    move-result v0
    if-nez v0, +018h
    invoke-virtual v6, Landroid/app/Activity;->isDestroyed()Z
    move-result v0
    if-nez v0, +012h
    sget-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->INSTANCE Lcom/bytedance/trae/login/DeviceOverLimitDialog;
    iget-object v1, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1;->$listResult Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    sget-object v2, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;->EXCHANGE Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$TraeAuthDeviceCallback;
    new-instance v4, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1$$ExternalSyntheticLambda0;
    invoke-direct v4, v3, v6, Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$showLimitDeviceDialog$1$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$TraeAuthDeviceCallback; Landroid/app/Activity;)V
    invoke-virtual v0, v6, v1, v2, v4, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->show(Landroid/app/Activity; Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
.end method
