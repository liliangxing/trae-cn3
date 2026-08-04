# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$2$1;
.super Ljava/lang/Object;
.source "DeviceOverLimitDialogManager.kt"

.implements Lkotlin/jvm/functions/Function1;

.field final synthetic $lifecycleCallback:Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$2$lifecycleCallback$1;


.method constructor <init>(com.bytedance.trae.login.traeauth.DeviceOverLimitDialogManager$awaitResumedActivity$2$lifecycleCallback$1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$2$1;->$lifecycleCallback Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$2$lifecycleCallback$1;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public bridge synthetic invoke(java.lang.Object)java.lang.Object
    .registers 2
    # ins_size=2
    check-cast v1, Ljava/lang/Throwable;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$2$1;->invoke(Ljava/lang/Throwable;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final invoke(java.lang.Throwable)void
    .registers 3
    # ins_size=2
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v2
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$2$1;->$lifecycleCallback Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$2$lifecycleCallback$1;
    check-cast v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks;
    invoke-interface v2, v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->removeActivityLifecycleCallback(Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks;)V
    return-void 
.end method
