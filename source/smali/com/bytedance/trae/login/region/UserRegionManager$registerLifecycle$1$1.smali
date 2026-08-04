# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/region/UserRegionManager$registerLifecycle$1$1;
.super Ljava/lang/Object;
.source "UserRegionManager.kt"

.implements Landroidx/lifecycle/DefaultLifecycleObserver;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onStart(androidx.lifecycle.LifecycleOwner)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, owner
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/login/region/UserRegionManager;->access$getColdStartDone$p()Z
    move-result v3
    if-nez v3, +009h
    sget-object v3, Lcom/bytedance/trae/login/region/UserRegionManager;->INSTANCE Lcom/bytedance/trae/login/region/UserRegionManager;
    const/4 v3, 1
    invoke-static v3, Lcom/bytedance/trae/login/region/UserRegionManager;->access$setColdStartDone$p(Z)V
    return-void 
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "UserRegionManager"
    const-string v1, "ProcessLifecycleOwner onStart: warm launch, performCheckLogin"
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/login/region/UserRegionManager;->INSTANCE Lcom/bytedance/trae/login/region/UserRegionManager;
    invoke-static v3, Lcom/bytedance/trae/login/region/UserRegionManager;->access$performCheckLoginOnWarmLaunch(Lcom/bytedance/trae/login/region/UserRegionManager;)V
    return-void 
.end method
