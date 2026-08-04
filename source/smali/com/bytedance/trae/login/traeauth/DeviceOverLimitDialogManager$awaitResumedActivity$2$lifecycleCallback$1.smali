# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$2$lifecycleCallback$1;
.super Ljava/lang/Object;
.source "DeviceOverLimitDialogManager.kt"

.implements Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks;

.field final synthetic $continuation:Lkotlinx/coroutines/CancellableContinuation;


.method constructor <init>(kotlinx.coroutines.CancellableContinuation)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$2$lifecycleCallback$1;->$continuation Lkotlinx/coroutines/CancellableContinuation;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onCreate(android.app.Activity  android.os.Bundle)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks$DefaultImpls;->onCreate(Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks; Landroid/app/Activity; Landroid/os/Bundle;)V
    return-void 
.end method

.method public onPaused(android.app.Activity)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks$DefaultImpls;->onPaused(Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks; Landroid/app/Activity;)V
    return-void 
.end method

.method public onPreDestroyed(android.app.Activity)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks$DefaultImpls;->onPreDestroyed(Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks; Landroid/app/Activity;)V
    return-void 
.end method

.method public onResumed(android.app.Activity)void
    .registers 5
    # ins_size=2
    const-string v0, "activity"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    move-object v1, v3
    check-cast v1, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks;
    invoke-interface v0, v1, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->removeActivityLifecycleCallback(Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$2$lifecycleCallback$1;->$continuation Lkotlinx/coroutines/CancellableContinuation;
    invoke-interface v0, Lkotlinx/coroutines/CancellableContinuation;->isActive()Z
    move-result v0
    if-eqz v0, +02dh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "Activity resumed: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "TraeAuthManager"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/traeauth/DeviceOverLimitDialogManager$awaitResumedActivity$2$lifecycleCallback$1;->$continuation Lkotlinx/coroutines/CancellableContinuation;
    check-cast v0, Lkotlin/coroutines/Continuation;
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-interface v0, v4, Lkotlin/coroutines/Continuation;->resumeWith(Ljava/lang/Object;)V
    return-void 
.end method

.method public onStopped(android.app.Activity)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks$DefaultImpls;->onStopped(Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks; Landroid/app/Activity;)V
    return-void 
.end method
