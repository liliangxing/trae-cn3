# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/quota/BDNetworkTagConfigImpl;
.super Ljava/lang/Object;
.source "BDNetworkTagConfigImpl.kt"

.implements Lcom/ss/android/ugc/quota/IBDNetworkTagConfig;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getApplication()android.app.Application
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    return-object v0
.end method

.method public getTagDepend()com.ss.android.ugc.quota.IBDNetworkTagDepend
    .registers 2
    # ins_size=1
    const-string/jumbo v0, open
    invoke-static v0, Lcom/bytedance/trae/network/quota/InitQuotaTaskHelper;->getBDNetworkTagDependImpl(Ljava/lang/String;)Lcom/ss/android/ugc/quota/IBDNetworkTagDepend;
    move-result-object v0
    return-object v0
.end method
