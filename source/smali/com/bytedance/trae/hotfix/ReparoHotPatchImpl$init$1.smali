# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl$init$1;
.super Lcom/bytedance/reparo/IReparoConfig;
.source "ReparoHotPatchImpl.kt"

.field final synthetic $config:Lcom/bytedance/trae/hotfix/HotPatchConfig;


.method constructor <init>(com.bytedance.trae.hotfix.HotPatchConfig)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl$init$1;->$config Lcom/bytedance/trae/hotfix/HotPatchConfig;
    invoke-direct v0, Lcom/bytedance/reparo/IReparoConfig;-><init>()V
    return-void 
.end method

.method public enable()boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl$init$1;->$config Lcom/bytedance/trae/hotfix/HotPatchConfig;
    invoke-virtual v0, Lcom/bytedance/trae/hotfix/HotPatchConfig;->enable()Z
    move-result v0
    return v0
.end method

.method public executePatchRequest(int  java.lang.String  byte[]  java.lang.String)java.lang.String
    .registers 6
    # ins_size=5
    const-string/jumbo v0, url
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "localPatchInfoBytes"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "contentType"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl$init$1;->$config Lcom/bytedance/trae/hotfix/HotPatchConfig;
    invoke-virtual v0, v2, v3, v4, v5, Lcom/bytedance/trae/hotfix/HotPatchConfig;->executePatchRequest(I Ljava/lang/String; [B Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method public getAppId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl$init$1;->$config Lcom/bytedance/trae/hotfix/HotPatchConfig;
    invoke-virtual v0, Lcom/bytedance/trae/hotfix/HotPatchConfig;->getAppId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getApplication()android.app.Application
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl$init$1;->$config Lcom/bytedance/trae/hotfix/HotPatchConfig;
    invoke-virtual v0, Lcom/bytedance/trae/hotfix/HotPatchConfig;->getApplication()Landroid/app/Application;
    move-result-object v0
    return-object v0
.end method

.method public getChannel()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl$init$1;->$config Lcom/bytedance/trae/hotfix/HotPatchConfig;
    invoke-virtual v0, Lcom/bytedance/trae/hotfix/HotPatchConfig;->getChannel()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl$init$1;->$config Lcom/bytedance/trae/hotfix/HotPatchConfig;
    invoke-virtual v0, Lcom/bytedance/trae/hotfix/HotPatchConfig;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getUpdateVersionCode()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl$init$1;->$config Lcom/bytedance/trae/hotfix/HotPatchConfig;
    invoke-virtual v0, Lcom/bytedance/trae/hotfix/HotPatchConfig;->getUpdateVersionCode()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public isMainProcess()boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl$init$1;->$config Lcom/bytedance/trae/hotfix/HotPatchConfig;
    invoke-virtual v0, Lcom/bytedance/trae/hotfix/HotPatchConfig;->isMainProcess()Z
    move-result v0
    return v0
.end method
