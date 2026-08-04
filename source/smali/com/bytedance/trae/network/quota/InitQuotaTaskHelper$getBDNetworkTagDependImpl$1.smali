# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/quota/InitQuotaTaskHelper$getBDNetworkTagDependImpl$1;
.super Ljava/lang/Object;
.source "InitQuotaTaskHelper.kt"

.implements Lcom/ss/android/ugc/quota/IBDNetworkTagDepend;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public enable()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method

.method public isNewInstall()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/quota/AppInfoProvider;->INSTANCE Lcom/bytedance/trae/network/quota/AppInfoProvider;
    invoke-virtual v0, Lcom/bytedance/trae/network/quota/AppInfoProvider;->isFirstStartApp()Z
    move-result v0
    return v0
.end method

.method public launchMonitor()com.ss.android.ugc.quota.launch.IBDNetworkLaunchMonitor
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/quota/AppStartManager;->INSTANCE Lcom/bytedance/trae/network/quota/AppStartManager;
    check-cast v0, Lcom/ss/android/ugc/quota/launch/IBDNetworkLaunchMonitor;
    return-object v0
.end method

.method public onLaunchTypeUpdate(int)void
    .registers 2
    # ins_size=2
    return-void 
.end method
