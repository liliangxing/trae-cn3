# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/account/AccountInitExt;
.super Ljava/lang/Object;
.source "AccountInitExt.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/account/AccountInitExt;


.method public static synthetic $r8$lambda$wOYDhf0WoCipCy3hEZ0AVJtA2pM()com.bytedance.sdk.account.settings.AuthExpirationConfigManager$Config
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/account/AccountInitExt;->setupAuthExpirationConfig$lambda$1()Lcom/bytedance/sdk/account/settings/AuthExpirationConfigManager$Config;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/account/AccountInitExt;
    invoke-direct v0, Lcom/bytedance/trae/account/AccountInitExt;-><init>()V
    sput-object v0, Lcom/bytedance/trae/account/AccountInitExt;->INSTANCE Lcom/bytedance/trae/account/AccountInitExt;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final setupAuthExpirationConfig$lambda$1()com.bytedance.sdk.account.settings.AuthExpirationConfigManager$Config
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/sdk/account/settings/AuthExpirationConfigManager$Config;
    invoke-direct v0, Lcom/bytedance/sdk/account/settings/AuthExpirationConfigManager$Config;-><init>()V
    const/4 v1, 1
    iput-boolean v1, v0, Lcom/bytedance/sdk/account/settings/AuthExpirationConfigManager$Config;->enable Z
    return-object v0
.end method

.method public final setupAuthExpirationConfig()void
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/account/AccountInitExt$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/account/AccountInitExt$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lcom/bytedance/sdk/account/settings/AuthExpirationConfigManager;->setLocalConfig(Lcom/bytedance/sdk/account/settings/AuthExpirationConfigManager$GetLocalConfig;)V
    sget-object v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;
    invoke-virtual v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->registerProvider()V
    return-void 
.end method
