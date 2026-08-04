# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/TraeApplication$attachBaseContext$3;
.super Ljava/lang/Object;
.source "TraeApplication.kt"

.implements Lcom/bytedance/trae/network/LoginContextProvider;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getAiRegion()com.bytedance.trae.network.AiRegion
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/AiRegion;->Companion Lcom/bytedance/trae/network/AiRegion$Companion;
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v1, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getUserInfo()Lcom/bytedance/trae/login/user/UserInfo;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/login/user/UserInfo;->getAiRegion()Ljava/lang/String;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/AiRegion$Companion;->from(Ljava/lang/String;)Lcom/bytedance/trae/network/AiRegion;
    move-result-object v0
    return-object v0
.end method

.method public isBytecloudLogin()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->isBytecloudLogin()Z
    move-result v0
    return v0
.end method

.method public isEnterpriseBoeEnv()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v0, Lcom/bytedance/trae/network/DebugSettings;->isEnterpriseTestEnv()Z
    move-result v0
    return v0
.end method

.method public isEnterpriseLogin()boolean
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getLoginPlatform()Ljava/lang/String;
    move-result-object v0
    const-string v1, "enterprise"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    return v0
.end method
