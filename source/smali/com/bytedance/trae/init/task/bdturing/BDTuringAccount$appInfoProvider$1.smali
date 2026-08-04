# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$appInfoProvider$1;
.super Lcom/bytedance/bdturing/AppInfoProvider;
.source "BDTuringAccount.kt"


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/bdturing/AppInfoProvider;-><init>()V
    return-void 
.end method

.method public getDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getInstallId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getInstallId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getOpenUDid()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getOpenUDid()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
