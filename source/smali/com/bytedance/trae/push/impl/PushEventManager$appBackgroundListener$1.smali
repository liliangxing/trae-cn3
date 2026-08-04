# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/push/impl/PushEventManager$appBackgroundListener$1;
.super Ljava/lang/Object;
.source "PushEventManager.kt"

.implements Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onAllActivityDestroyed()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public onAppBackground()void
    .registers 4
    # ins_size=1
    invoke-static Lcom/bytedance/trae/push/impl/PushEventManager;->access$isPush$p()Z
    move-result v0
    if-eqz v0, +00fh
    sget-object v0, Lcom/bytedance/trae/push/impl/PushEventManager;->INSTANCE Lcom/bytedance/trae/push/impl/PushEventManager;
    const/4 v0, 0
    invoke-static v0, Lcom/bytedance/trae/push/impl/PushEventManager;->access$setPush$p(Z)V
    sget-object v1, Lcom/bytedance/trae/push/impl/PushEventManager;->INSTANCE Lcom/bytedance/trae/push/impl/PushEventManager;
    const-string v2, "default"
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/push/impl/PushEventManager;->setOrUpdateIsPushCommonParams(I Ljava/lang/String;)V
    return-void 
.end method

.method public onAppForeground()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/push/impl/PushEventManager;->INSTANCE Lcom/bytedance/trae/push/impl/PushEventManager;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    check-cast v1, Landroid/content/Context;
    invoke-static v0, v1, Lcom/bytedance/trae/push/impl/PushEventManager;->access$reportAppLaunchStatus(Lcom/bytedance/trae/push/impl/PushEventManager; Landroid/content/Context;)V
    return-void 
.end method
